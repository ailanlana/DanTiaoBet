package io.fntlv.dantiaobet.bet;

import br.com.finalcraft.evernifecore.config.playerdata.PlayerController;
import br.com.finalcraft.evernifecore.config.playerdata.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class BetPlayer {

    private final String name;
    private final UUID uuid;
    private final int money;
    private final String betWinPlayer;

    public BetPlayer(String name,UUID uuid,int money,String betWinPlayer){
        this.name = name;
        this.uuid = uuid;
        this.money = money;
        this.betWinPlayer = betWinPlayer;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public String getBetWinPlayer() {
        return betWinPlayer;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Player getPlayer(){
        return Bukkit.getPlayer(uuid);
    }

    public PlayerData getPlayerData(){
        return PlayerController.getPlayerData(uuid);
    }
}
