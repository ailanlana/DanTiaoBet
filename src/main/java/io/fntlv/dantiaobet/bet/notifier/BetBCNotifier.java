package io.fntlv.dantiaobet.bet.notifier;

import br.com.finalcraft.evernifecore.locale.LocaleMessage;
import br.com.finalcraft.evernifecore.locale.SendCustom;
import io.fntlv.dantiaobet.bet.BetGuess;
import io.fntlv.dantiaobet.bet.BetPlayer;
import io.fntlv.dantiaobet.bet.PVPBet;
import io.fntlv.dantiaobet.config.data.BetData;
import io.fntlv.dantiaobet.message.BetBCMessage;
import org.bukkit.Bukkit;

public class BetBCNotifier {

    public static void start(PVPBet pvpBet){
        SendCustom sendCustom = BetBCMessage.BET_START
                .addPlaceholder("%name%", pvpBet.getPvpName());
        notifier(sendCustom);
    }

    public static void fail(BetGuess betGuess){
        notifier(
                BetBCMessage.BET_FAIL
                        .addPlaceholder("%name%",betGuess.getPvpName())
        );
    }

    public static void newPlayerEnter(BetGuess betGuess, BetPlayer betPlayer){
        notifier(
                BetBCMessage.BET_ENTER
                        .addPlaceholder("%player%",betPlayer.getName())
                        .addPlaceholder("%name%",betGuess.getPvpName())
                        .addPlaceholder("%winner%",betGuess.getGuessWinPlayer())
                        .addPlaceholder("%money%",betPlayer.getMoney())
                        .addPlaceholder("%totalmoney%",betGuess.getTotalMoney())
                        .addPlaceholder("%num%",betGuess.getBetPlayers().size())
        );
    }

    public static void endWithTrue(BetGuess betGuess,BetPlayer betPlayer,double earnMoney){
        notifier(
                BetBCMessage.BET_TRUE
                        .addPlaceholder("%player%",betPlayer.getName())
                        .addPlaceholder("%name%",betGuess.getPvpName())
                        .addPlaceholder("%winner%",betGuess.getGuessWinPlayer())
                        .addPlaceholder("%money%",earnMoney)
                        .addPlaceholder("%totalmoney%",betGuess.getTotalMoney())
        );
    }

    public static void endWithDraw(PVPBet pvpBet){
        notifier(
                BetBCMessage.BET_DRAW
                        .addPlaceholder("%name%",pvpBet.getPvpName())
        );
    }

    private static void notifier(SendCustom sendCustom){
        String message = sendCustom.getFancyText(Bukkit.getConsoleSender()).getText();
        if (BetData.isEnableBC()){
            Bukkit.getServer().dispatchCommand(
                    Bukkit.getConsoleSender(),
                    BetData.getBroadCastCommand()+" "+message
            );
        }

    }

}
