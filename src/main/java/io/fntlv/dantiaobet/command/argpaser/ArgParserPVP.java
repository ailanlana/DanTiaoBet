package io.fntlv.dantiaobet.command.argpaser;

import br.com.finalcraft.evernifecore.argumento.Argumento;
import br.com.finalcraft.evernifecore.commands.finalcmd.argument.ArgInfo;
import br.com.finalcraft.evernifecore.commands.finalcmd.argument.ArgParser;
import br.com.finalcraft.evernifecore.commands.finalcmd.argument.exception.ArgParseException;
import br.com.finalcraft.evernifecore.locale.FCLocale;
import br.com.finalcraft.evernifecore.locale.LocaleMessage;
import io.fntlv.dantiaobet.bet.BetManager;
import io.fntlv.dantiaobet.bet.PVPBet;
import org.bukkit.command.CommandSender;
import org.bukkit.util.StringUtil;

import java.util.List;
import java.util.stream.Collectors;

public class ArgParserPVP extends ArgParser<PVPBet> {

    public ArgParserPVP(ArgInfo argInfo) {
        super(argInfo);
    }

    @FCLocale(lang = "ZH_CN",text = "§7[§6PVP§7] §c%name%的比赛还没开始,无法参与竞猜!")
    public static LocaleMessage PVP_NOT_START;

    @Override
    public PVPBet parserArgument(CommandSender sender, Argumento argumento) throws ArgParseException {
        String pvpName = BetManager.gameBetMap.keySet().stream()
                .filter(argumento::equalsIgnoreCase)
                .findFirst()
                .orElse(null);

        if (pvpName == null && this.argInfo.isRequired()){
            PVP_NOT_START
                    .addPlaceholder("%name%", argumento)
                    .send(sender);
            throw new ArgParseException();
        }

        return BetManager.gameBetMap.get(pvpName);
    }

    @Override
    public List<String> tabComplete(TabContext tabContext){
        return BetManager.gameBetMap.keySet().stream()
                .filter(s -> StringUtil.startsWithIgnoreCase(s,tabContext.getLastWord()))
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .collect(Collectors.toList());
    }

}
