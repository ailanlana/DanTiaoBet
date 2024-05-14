package io.fntlv.dantiaobet.message;

import br.com.finalcraft.evernifecore.locale.FCLocale;
import br.com.finalcraft.evernifecore.locale.LocaleMessage;

public class BetBCMessage {

    @FCLocale(lang = "ZH_CN",text = "§7[§6PVP§7] §f竞技场%name%的比赛开始了,快来§b主城大区§f参与竞猜吧!竞猜指令§a/pvpbet")
    public static LocaleMessage BET_START;

    @FCLocale(lang = "ZH_CN",text = "§7[§6PVP§7] §f竞技场%name%的比赛开盘失败,所有玩家投注了同一玩家!")
    public static LocaleMessage BET_FAIL;

    @FCLocale(lang = "ZH_CN",text = "§7[§6PVP§7] §f玩家§b%player%§f参与了竞技场%name%§f的竞猜,押注§6%winner%§f赢,投注金额为: §e%money%,§f押注该玩家胜利共%num%人累计总共金额: §e%totalmoney%")
    public static LocaleMessage BET_ENTER;

    @FCLocale(lang = "ZH_CN",text = "§7[§6PVP§7] §f竞技场%name%§f的比赛开盘了,最终§6%winner%§f获得了胜利,押注对的玩家可瓜分金币:§e%totalmoney%§f,玩家§b%player%§f获得了金币§e%money%!")
    public static LocaleMessage BET_TRUE;

    @FCLocale(lang = "ZH_CN",text = "§7[§6PVP§7] §f竞技场%name%§f的比赛开盘了,双方战至平局,所有人金币返还!")
    public static LocaleMessage BET_DRAW;

}
