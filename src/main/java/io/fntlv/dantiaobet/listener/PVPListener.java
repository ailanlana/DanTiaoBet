package io.fntlv.dantiaobet.listener;

import br.com.finalcraft.evernifecore.listeners.base.ECListener;
import com.valorin.api.event.arena.ArenaDrawFinishEvent;
import com.valorin.api.event.arena.ArenaFinishEvent;
import com.valorin.api.event.arena.ArenaStartEvent;
import io.fntlv.dantiaobet.bet.BetManager;
import io.fntlv.dantiaobet.bet.PVPBet;
import org.bukkit.event.EventHandler;

public class PVPListener implements ECListener {

    @EventHandler
    public void onPVPStart(ArenaStartEvent event){

        String pvpName = event.getArena().getName();
        String player1Name = event.getPlayer1().getName();
        String player2Name = event.getPlayer2().getName();

        BetManager.gameBetMap.put(pvpName,new PVPBet(pvpName,player1Name,player2Name));

    }

    @EventHandler
    public void onPVPEnd(ArenaFinishEvent event){

        String pvpName = event.getArena().getName();
        String winnerName = event.getWinner().getName();
        PVPBet pvpBet = BetManager.gameBetMap.get(pvpName);

        if (pvpBet != null){
            pvpBet.endBet(winnerName);
            BetManager.gameBetMap.remove(pvpName);
        }

    }

    @EventHandler
    public void onPVPEnd2(ArenaDrawFinishEvent event){

        String pvpName = event.getArena().getName();
        PVPBet pvpBet = BetManager.gameBetMap.get(pvpName);

        if (pvpBet != null){
            pvpBet.endBetWithDraw();
            BetManager.gameBetMap.remove(pvpName);
        }

    }

}
