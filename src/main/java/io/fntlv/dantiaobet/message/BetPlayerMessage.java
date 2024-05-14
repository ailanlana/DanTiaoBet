package io.fntlv.dantiaobet.message;

import br.com.finalcraft.evernifecore.locale.FCLocale;
import br.com.finalcraft.evernifecore.locale.LocaleMessage;

public class BetPlayerMessage {

    @FCLocale(lang = "ZH_CN",text = "§7[§6PVP§7] §c竞技场%name%比赛已经结束了,无法参与竞猜!")
    public static LocaleMessage BET_END;

    @FCLocale(lang = "ZH_CN",text = "§7[§6PVP§7] §c玩家&c%player%§f未参与竞技场%name%的比赛,参与本次比赛的玩家有&b%player1%&f和&b%player2%")
    public static LocaleMessage BET_NO_PLAYER;

    @FCLocale(lang = "ZH_CN",text = "§7[§6PVP§7] §f成功参与竞技场%name%§f的竞猜,你押§b%winner%§f赢,押注金币为: §e%money%")
    public static LocaleMessage BET_SUCCESS;

    @FCLocale(lang = "ZH_CN",text = "§7[§6PVP§7] §c你已经参与过竞技场%name%§c竞猜了,无法重复参与竞猜!")
    public static LocaleMessage HAS_BET;

    @FCLocale(lang = "ZH_CN",text = "§7[§6PVP§7] §f竞技场%name%的竞猜因所有参与人员投注胜利者相同,开盘失败,所有人投注金币已返还!")
    public static LocaleMessage BET_FAIL;

    @FCLocale(lang = "ZH_CN",text = "§7[§6PVP§7] §c你下注的金币太大了,你没有这么多的金币!")
    public static LocaleMessage NO_MONEY;

    @FCLocale(lang = "ZH_CN",text = "§7[§6PVP§7] §c你参与下注的金币超出范围了!§7(§f最大为§a%max%§f,最小为§a%min%§7)")
    public static LocaleMessage OUT_MONEY;

    @FCLocale(lang = "ZH_CN",text = "§7[§6PVP§7] §f恭喜你猜对了!玩家§6%winner%§f最终取得了胜利,你获得金币: §e%money%")
    public static LocaleMessage BET_TRUE;

    @FCLocale(lang = "ZH_CN",text = "§7[§6PVP§7] §f很遗憾,你猜了!玩家§6%winner%§f最终取得了胜利,你失去了你的下注金币: §e%money%")
    public static LocaleMessage BET_FALSE;
}
