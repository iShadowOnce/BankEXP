package org.soclabs.bankEXP.utils;

import org.bukkit.ChatColor;

public class MessageUtils {
    public static String getColoredMenssage(String message) {
        return ChatColor.translateAlternateColorCodes('&',message);
    }
}
