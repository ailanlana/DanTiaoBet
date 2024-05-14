package io.fntlv.dantiaobet.config.data;

import br.com.finalcraft.evernifecore.config.Config;
import io.fntlv.dantiaobet.config.ConfigManager;

public class BetData {

    private static int maxBetValue;
    private static int minValue;
    private static double multiple;
    private static boolean enableBC;
    private static String broadCastCommand;

    public static void init(){
        Config mainConfig = ConfigManager.getMainConfig();
        maxBetValue = mainConfig.getOrSetDefaultValue(
                "Bet.MaxValue",
                200,
                "参与竞猜的最大金币"
        );
        minValue = mainConfig.getOrSetDefaultValue(
                "Bet.Minvalue",
                20,
                "参与竞猜的最小金币"
        );
        multiple = mainConfig.getOrSetDefaultValue(
                "Bet.Multiple",
                0.5,
                "倍率"
        );
        enableBC = mainConfig.getOrSetDefaultValue(
                "Bet.BroadCast.Enable",
                true,
                "是否开启广播"
        );
        broadCastCommand = mainConfig.getOrSetDefaultValue(
                "Bet.BroadCast.Command",
                "tongzhi",
                "投注广播命令"
        );
    }

    public static int getMinValue() {
        return minValue;
    }

    public static int getMaxBetValue() {
        return maxBetValue;
    }

    public static double getMultiple() {
        return multiple;
    }

    public static String getBroadCastCommand() {
        return broadCastCommand;
    }

    public static boolean isEnableBC() {
        return enableBC;
    }
}
