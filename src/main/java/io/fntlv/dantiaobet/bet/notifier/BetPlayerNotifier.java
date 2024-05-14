package io.fntlv.dantiaobet.bet.notifier;

import io.fntlv.dantiaobet.bet.BetGuess;
import io.fntlv.dantiaobet.bet.BetPlayer;
import io.fntlv.dantiaobet.bet.PVPBet;
import io.fntlv.dantiaobet.config.data.BetData;
import io.fntlv.dantiaobet.message.BetPlayerMessage;

public class BetPlayerNotifier {

    public static void betHasEnd(PVPBet pvpBet, BetPlayer betPlayer){
        BetPlayerMessage.BET_END
                .addPlaceholder("%name%",pvpBet.getPvpName())
                .send(betPlayer.getPlayer());
    }

    public static void betNoPlayer(PVPBet pvpBet,BetPlayer betPlayer){
        String betGuess1 = pvpBet.getBetGuess1().getGuessWinPlayer();
        String betGuess2 = pvpBet.getBetGuess2().getGuessWinPlayer();
        String pvpName = pvpBet.getPvpName();
        BetPlayerMessage.BET_NO_PLAYER
                .addPlaceholder("%player%",betPlayer.getBetWinPlayer())
                .addPlaceholder("%player1%", betGuess1)
                .addPlaceholder("%player2%", betGuess2)
                .addPlaceholder("%name%",pvpName)
                .send(betPlayer.getPlayer());
    }

    public static void betSuccess(BetGuess betGuess,BetPlayer betPlayer){
        BetPlayerMessage.BET_SUCCESS
                .addPlaceholder("%name%",betGuess.getPvpName())
                .addPlaceholder("%winner%",betPlayer.getBetWinPlayer())
                .addPlaceholder("%money%",betPlayer.getMoney())
                .send(betPlayer.getPlayer());
    }

    public static void hasBet(BetGuess betGuess,BetPlayer betPlayer){
        BetPlayerMessage.HAS_BET
                .addPlaceholder("%name%",betGuess.getPvpName())
                .send(betPlayer.getPlayer());
    }

    public static void outOfMoney(BetPlayer betPlayer){
        BetPlayerMessage.OUT_MONEY
                .addPlaceholder("%max%", BetData.getMaxBetValue())
                .addPlaceholder("%min%",BetData.getMinValue())
                .send(betPlayer.getPlayer());
    }

    public static void noMoney(BetPlayer betPlayer){
        BetPlayerMessage.NO_MONEY.send(betPlayer.getPlayer());
    }
}
