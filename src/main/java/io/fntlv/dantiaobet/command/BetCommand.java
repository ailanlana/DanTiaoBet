package io.fntlv.dantiaobet.command;

import br.com.finalcraft.evernifecore.commands.finalcmd.annotations.Arg;
import br.com.finalcraft.evernifecore.commands.finalcmd.annotations.FinalCMD;
import io.fntlv.dantiaobet.bet.BetPlayer;
import io.fntlv.dantiaobet.bet.PVPBet;
import org.bukkit.entity.Player;


public class BetCommand {

    @FinalCMD(
            aliases = "pvpbet",
            usage = "&a这是一条命令提示"
    )
    public void pvpBet(
            Player player,
            @Arg(name = "<竞技场名字>") PVPBet pvpBet,
            @Arg(name = "<参赛选手名字>") Player winPlayer,
            @Arg(name = "<下注金币金额>") Integer money
    ){
        pvpBet.addBetPlayer(new BetPlayer(
                player.getName(),
                player.getUniqueId(),
                money,
                winPlayer.getDisplayName()
        ));
    }
}
