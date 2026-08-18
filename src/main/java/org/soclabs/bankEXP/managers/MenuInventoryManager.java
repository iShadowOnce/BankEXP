package org.soclabs.bankEXP.managers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.soclabs.bankEXP.BankEXP;
import org.soclabs.bankEXP.utils.MessageUtils;

public class MenuInventoryManager {

    private static final int SMALL_CHEST_SIZE = 27;

    private final BankEXP plugin;

    public MenuInventoryManager(BankEXP plugin) {
        this.plugin = plugin;
    }

    public void openBankMenu(Player player) {
        Inventory bankMenu = Bukkit.createInventory(player, SMALL_CHEST_SIZE,
                MessageUtils.getMessage("menu.bank-title"));

        player.openInventory(bankMenu);
        player.sendMessage(MessageUtils.getPrefixedMessage("menu.bank-open"));
    }
}
