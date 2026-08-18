package org.soclabs.bankEXP.language;

import org.bukkit.configuration.file.YamlConfiguration;
import org.soclabs.bankEXP.BankEXP;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class LanguageManager {

    private static final String DEFAULT_LANGUAGE = "es";

    private final BankEXP plugin;
    private final File languageFolder;
    private YamlConfiguration messages;
    private String currentLanguage;

    public LanguageManager(BankEXP plugin) {
        this.plugin = plugin;
        this.languageFolder = new File(plugin.getDataFolder(), "language");
    }

    public void setup() {
        plugin.saveResource("language/" + DEFAULT_LANGUAGE + ".yml", false);
        plugin.saveResource("language/en.yml", false);
        load();
    }

    public void reload() {
        load();
    }

    private void load() {
        plugin.reloadConfig();
        currentLanguage = plugin.getConfig().getString("language", DEFAULT_LANGUAGE);

        File languageFile = new File(languageFolder, currentLanguage + ".yml");
        if (!languageFile.exists()) {
            plugin.getLogger().warning("No se encontro el archivo de idioma '" + currentLanguage
                    + ".yml' en la carpeta 'language'. Se usara '" + DEFAULT_LANGUAGE + "' por defecto.");
            currentLanguage = DEFAULT_LANGUAGE;
            languageFile = new File(languageFolder, DEFAULT_LANGUAGE + ".yml");
        }

        messages = YamlConfiguration.loadConfiguration(languageFile);

        try (InputStreamReader defaultStream = new InputStreamReader(
                plugin.getResource("language/" + DEFAULT_LANGUAGE + ".yml"), StandardCharsets.UTF_8)) {
            messages.setDefaults(YamlConfiguration.loadConfiguration(defaultStream));
        } catch (IOException exception) {
            plugin.getLogger().warning("No se pudieron cargar los mensajes por defecto: " + exception.getMessage());
        }
    }

    public String getRawMessage(String path) {
        return messages.getString(path, "&cFalta el mensaje: " + path);
    }

    public String getCurrentLanguage() {
        return currentLanguage;
    }
}
