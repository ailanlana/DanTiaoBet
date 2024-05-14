package io.fntlv.dantiaobet.bet.handler;

import io.fntlv.dantiaobet.Main;
import io.fntlv.dantiaobet.bet.BetGuess;
import io.fntlv.dantiaobet.bet.notifier.BetBCNotifier;
import io.fntlv.dantiaobet.config.data.BetData;
import io.fntlv.dantiaobet.message.BetPlayerMessage;

public class BetRewardHandler {

    public static void distributeRewards(BetGuess betGuess1, BetGuess betGuess2, String winPlayer) {
        if (betGuess1.getBetPlayers().isEmpty() || betGuess2.getBetPlayers().isEmpty()){
            handleNoPlayers(betGuess1);
            handleNoPlayers(betGuess2);
            return;
        }

        BetGuess winGuess = betGuess1.getGuessWinPlayer().equals(winPlayer) ? betGuess1 : betGuess2;
        BetGuess loseGuess = winGuess == betGuess1 ? betGuess2 : betGuess1;

        distributeReward(winGuess, loseGuess);
    }

    private static void handleNoPlayers(BetGuess betGuess) {
        betGuess.returnBetAmount();
        betGuess.getBetPlayers().forEach(betPlayer -> {
            BetPlayerMessage.BET_FAIL
                    .addPlaceholder("%name%", betGuess.getPvpName())
                    .send(betPlayer.getPlayer());
        });
        BetBCNotifier.fail(betGuess);
    }

    private static void distributeReward(BetGuess winGuess, BetGuess loseGuess) {
        winGuess.returnBetAmount();

        double totalLoseMoney = loseGuess.getTotalMoney() * BetData.getMultiple();

        winGuess.getBetPlayers().forEach(betPlayer -> {
            double ratio = (double) betPlayer.getMoney() / winGuess.getTotalMoney();
            double winningAmount = totalLoseMoney * ratio;
            Main.getEconomyProvider().ecoGive(betPlayer.getPlayerData(), winningAmount);
            BetPlayerMessage.BET_TRUE
                    .addPlaceholder("%winner%", winGuess.getGuessWinPlayer())
                    .addPlaceholder("%money%", winningAmount)
                    .send(betPlayer.getPlayer());
            BetBCNotifier.endWithTrue(winGuess,betPlayer,winningAmount);
        });

        loseGuess.getBetPlayers().forEach(betPlayer -> {
            BetPlayerMessage.BET_FALSE
                    .addPlaceholder("%winner%", winGuess.getGuessWinPlayer())
                    .addPlaceholder("%money%", betPlayer.getMoney())
                    .send(betPlayer.getPlayer());
        });
    }
}

