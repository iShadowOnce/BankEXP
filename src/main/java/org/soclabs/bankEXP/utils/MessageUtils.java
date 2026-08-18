package org.soclabs.bankEXP.utils;

import org.bukkit.ChatColor;
import org.soclabs.bankEXP.BankEXP;

public class MessageUtils {

    public static String getColoredMenssage(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static String getMessage(String path, String... placeholders) {da
        String message = applyPlaceholders(getRawMessage(path), placeholders);
        return getColoredMenssage(message);
    }

    public static String getPrefixedMessage(String path, String... placeholders) {
        String message = getRawMessage("prefix") + getRawMessage(path);
        return getColoredMenssage(applyPlaceholders(message, placeholders));
    }

    private static String getRawMessage(String path) {
        return BankEXP.getInstance().getLanguageManager().getRawMessage(path);
    }

    private static String applyPlaceholders(String message, String... placeholders) {
        if (placeholders == null) {
            return message;
        }
        for (int i = 0; i + 1 < placeholders.length; i += 2) {
            message = message.replace(placeholders[i], placeholders[i + 1]);
        }
        return message;
    }
}
