package io.fntlv.dantiaobet;

import br.com.finalcraft.evernifecore.economy.EconomyManager;
import br.com.finalcraft.evernifecore.economy.IEconomyProvider;
import br.com.finalcraft.evernifecore.listeners.base.ECListener;
import br.com.finalcraft.evernifecore.locale.FCLocaleManager;
import io.fntlv.dantiaobet.command.CommandRegister;
import io.fntlv.dantiaobet.config.ConfigManager;
import io.fntlv.dantiaobet.listener.PVPListener;
import io.fntlv.dantiaobet.message.BetBCMessage;
import io.fntlv.dantiaobet.message.BetPlayerMessage;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static JavaPlugin inst;
    private static IEconomyProvider economyProvider;

    public static void info(String msg){
        inst.getLogger().info("[Info] " + msg.replace("&","§"));
    }

    public static void warn(String msg){
        inst.getLogger().info("§e[warn] " + msg.replace("&","§"));
    }

    @Override
    public void onEnable() {
        inst = this;
        info("&6DanTiao-Bet插件加载中...");
        economyProvider = EconomyManager.getProvider();
        if (economyProvider == null){
            warn("&c未找到经济插件,插件加载失败!");
            return;
        } else {
            info("&a经济插件HOOK成功");
        }
        ConfigManager.init(this);
        FCLocaleManager.loadLocale(this, BetPlayerMessage.class);
        FCLocaleManager.loadLocale(this, BetBCMessage.class);
        info("&a配置文件加载成功");
        CommandRegister.init(this);;
        info("&a命令注册成功");
        ECListener.register(this, PVPListener.class);
        info("&a监听器注册成功");
        info("&d插件作者: FnTlv QQ:1781872216");
        info("&d插件交流群: 539651313");
    }

    @Override
    public void onDisable() {
        info("&6DanTiao-Bet插件卸载中...");
        info("&d插件作者: FnTlv QQ:1781872216");
        info("&d插件交流群: 539651313");
    }

    public static IEconomyProvider getEconomyProvider() {
        return economyProvider;
    }
}
