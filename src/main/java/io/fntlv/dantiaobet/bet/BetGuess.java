package io.fntlv.dantiaobet.bet;

import br.com.finalcraft.evernifecore.config.playerdata.PlayerData;
import br.com.finalcraft.evernifecore.economy.IEconomyProvider;
import io.fntlv.dantiaobet.Main;
import io.fntlv.dantiaobet.bet.notifier.BetBCNotifier;
import io.fntlv.dantiaobet.bet.notifier.BetPlayerNotifier;
import io.fntlv.dantiaobet.config.data.BetData;
import io.fntlv.dantiaobet.message.BetBCMessage;

import java.util.ArrayList;
import java.util.List;

public class BetGuess {

    private final String pvpName;
    private final String guessWinPlayer;
    private int totalMoney;
    private List<BetPlayer> betPlayers = new ArrayList<>();

    public BetGuess(String pvpName,String guessWinPlayer){
        this.pvpName = pvpName;
        this.guessWinPlayer = guessWinPlayer;
    }

    public String getGuessWinPlayer() {
        return guessWinPlayer;
    }

    public void addBetPlayerToGuess(BetPlayer betPlayer){
        if (betPlayers.stream()
                .noneMatch(player -> player.getName().equals(betPlayer.getName()))
        ){
            if (deductBetAmount(betPlayer)){
                this.betPlayers.add(betPlayer);
                this.totalMoney += betPlayer.getMoney();
                BetPlayerNotifier.betSuccess(this,betPlayer);
                BetBCNotifier.newPlayerEnter(this,betPlayer);
            }
        } else {
            BetPlayerNotifier.hasBet(this,betPlayer);
        }
    }

    public void returnBetAmount() {
        betPlayers.forEach(betPlayer -> {
            Main.getEconomyProvider().ecoGive(betPlayer.getPlayerData(), betPlayer.getMoney());
        });
    }

    private boolean deductBetAmount(BetPlayer betPlayer) {

        IEconomyProvider economyProvider = Main.getEconomyProvider();
        PlayerData playerData = betPlayer.getPlayerData();
        double haveMoney = economyProvider.ecoGet(playerData);
        int money = betPlayer.getMoney();

        if (money > BetData.getMaxBetValue() || money < BetData.getMinValue()){
            BetPlayerNotifier.outOfMoney(betPlayer);
            return false;
        }

        if (haveMoney < money){
            BetPlayerNotifier.noMoney(betPlayer);
            return false;
        } else {
            economyProvider.ecoTake(playerData, money);
            return true;
        }
    }

    public List<BetPlayer> getBetPlayers() {
        return betPlayers;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public String getPvpName() {
        return pvpName;
    }
}
