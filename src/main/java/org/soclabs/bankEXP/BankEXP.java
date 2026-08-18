package org.soclabs.bankEXP;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.soclabs.bankEXP.commands.MainCommand;
import org.soclabs.bankEXP.language.LanguageManager;
import org.soclabs.bankEXP.utils.MessageUtils;

public final class BankEXP extends JavaPlugin {

    private static BankEXP instance;

    private LanguageManager languageManager;
    private String version;

    @Override
    public void onEnable() {
        instance = this;
        version = getDescription().getVersion();

        saveDefaultConfig();
        languageManager = new LanguageManager(this);
        languageManager.setup();

        registrarComando();

        Bukkit.getConsoleSender().sendMessage(
                MessageUtils.getPrefixedMessage("console.enabled", "%version%", version)
        );
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(
                MessageUtils.getPrefixedMessage("console.disabled", "%version%", version)
        );
    }

    public void registrarComando() {
        this.getCommand("bank").setExecutor(new MainCommand(this));
    }

    public static BankEXP getInstance() {
        return instance;
    }

    public LanguageManager getLanguageManager() {
        return languageManager;
    }
}
