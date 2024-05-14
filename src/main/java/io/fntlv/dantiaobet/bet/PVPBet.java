package io.fntlv.dantiaobet.bet;

import io.fntlv.dantiaobet.bet.handler.BetRewardHandler;
import io.fntlv.dantiaobet.bet.notifier.BetBCNotifier;
import io.fntlv.dantiaobet.bet.notifier.BetPlayerNotifier;

public class PVPBet {

    private BetStatus betStatus;
    private final String pvpName;

    private final BetGuess betGuess1;
    private final BetGuess betGuess2;

    public PVPBet(String pvpName, String player1, String player2){
        this.betStatus = BetStatus.TOWARD;
        this.pvpName = pvpName;
        this.betGuess1 = new BetGuess(pvpName,player1);
        this.betGuess2 = new BetGuess(pvpName,player2);
        BetBCNotifier.start(this);
    }

    public void addBetPlayer(BetPlayer betPlayer){

        if (this.betStatus.equals(BetStatus.END)){
            BetPlayerNotifier.betHasEnd(this,betPlayer);
            return;
        }

        String guessWinPlayer1 = betGuess1.getGuessWinPlayer();
        String guessWinPlayer2 = betGuess2.getGuessWinPlayer();

        if (betPlayer.getBetWinPlayer().equals(guessWinPlayer1)){
            betGuess1.addBetPlayerToGuess(betPlayer);
        } else if (betPlayer.getBetWinPlayer().equals(guessWinPlayer2)){
            betGuess2.addBetPlayerToGuess(betPlayer);
        } else {
            BetPlayerNotifier.betNoPlayer(this,betPlayer);
        }

    }

    public void endBet(String winPlayer){
        this.betStatus = BetStatus.END;
        BetRewardHandler.distributeRewards(betGuess1,betGuess2,winPlayer);
    }

    public void endBetWithDraw(){
        this.betStatus = BetStatus.END;
        betGuess1.returnBetAmount();
        betGuess2.returnBetAmount();
        BetBCNotifier.endWithDraw(this);
    }

    public String getPvpName() {
        return pvpName;
    }

    public BetGuess getBetGuess1() {
        return betGuess1;
    }

    public BetGuess getBetGuess2() {
        return betGuess2;
    }
}
