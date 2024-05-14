package io.fntlv.dantiaobet.config;

import br.com.finalcraft.evernifecore.config.Config;
import io.fntlv.dantiaobet.config.data.BetData;
import org.bukkit.plugin.java.JavaPlugin;

public class ConfigManager {

    private static Config mainConfig;
    private static String configVersion;

    public static void init(JavaPlugin javaPlugin){
        mainConfig = new Config(javaPlugin,"config.yml");
        configVersion = mainConfig.getOrSetDefaultValue(
                "version",
                "1.0.0",
                "版本号,请勿私自修改"
        );
        BetData.init();
        mainConfig.save();
    }

    public static Config getMainConfig() {
        return mainConfig;
    }

    public static String getConfigVersion() {
        return configVersion;
    }
}
