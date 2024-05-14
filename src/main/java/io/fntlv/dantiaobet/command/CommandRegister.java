package io.fntlv.dantiaobet.command;

import br.com.finalcraft.evernifecore.commands.finalcmd.FinalCMDManager;
import br.com.finalcraft.evernifecore.commands.finalcmd.argument.ArgParserManager;
import io.fntlv.dantiaobet.bet.PVPBet;
import io.fntlv.dantiaobet.command.argpaser.ArgParserPVP;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandRegister {

    public static void init(JavaPlugin javaPlugin){
        ArgParserManager.addPluginParser(javaPlugin,PVPBet.class, ArgParserPVP.class);
        FinalCMDManager.registerCommand(javaPlugin,BetCommand.class);
    }

}
