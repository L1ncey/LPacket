package ovo.lpacket.utils;

import lombok.experimental.UtilityClass;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.List;

@UtilityClass
public class StringUtil {
    public static String color (String message) {
        if (message == null || message.isEmpty()) return "";

        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public List<String> color (List<String> in) {
        in.replaceAll(StringUtil::color);

        return in;
    }

    public class consoleMsg {
        public static void common (String message) {
            Bukkit.getConsoleSender().sendMessage(color("&f[&bLPacket&f] &f" + message));
        }

        public static void alert (String message) {
            Bukkit.getConsoleSender().sendMessage(color("&f[&bLPacket&f] &c[ALERT] &f" + message));
        }
    }
}
