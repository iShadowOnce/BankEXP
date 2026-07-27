package org.soclabs.bankEXP;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.soclabs.bankEXP.commands.MainCommand;

public final class BankEXP extends JavaPlugin {

    public static String prefix = "&e[&aBancoEXP&e] ";
    private String version = getDescription().getVersion();

    @Override
    public void onEnable() {

        registrarComando();

        Bukkit.getConsoleSender().sendMessage(
                ChatColor.translateAlternateColorCodes(
                        '&',prefix+"&bBankEXP ha sido &aactivado. &eVersion: "+version
                )
        );
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(
                ChatColor.translateAlternateColorCodes(
                        '&',prefix+"&bBankEXP ha sido &cdesactivado. &eVersion: "+version
                )
        );
    }

    public void registrarComando() {
        this.getCommand("bank").setExecutor(new MainCommand());
    }
}
