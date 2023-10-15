package ovo.lpacket;

import org.bukkit.plugin.java.JavaPlugin;
import ovo.lpacket.utils.StringUtil;

public class ExamplePlugin extends JavaPlugin {

    public static ExamplePlugin INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;

        new ExampleListener();
        StringUtil.consoleMsg.common("Example Plugin enabled.");
    }

    @Override
    public void onDisable() {
        StringUtil.consoleMsg.common("Example Plugin disabled.");
    }
}
