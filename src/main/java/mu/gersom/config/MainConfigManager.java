package mu.gersom.config;

import java.util.List;

import mu.gersom.MuMc;

public class MainConfigManager {
    private final CustomConfig configFile;
    private LanguageManager languageManager;
    private final MuMc plugin;

    public MainConfigManager(MuMc plugin) {
        this.plugin = plugin;
        this.configFile = new CustomConfig("config.yml", null, plugin);
        this.configFile.registerConfig();
    }

    public void initialize() {
        this.languageManager = new LanguageManager(plugin);
    }

    public void reloadConfig() {
        configFile.reloadConfig();
        languageManager.reloadLanguageConfig();
    }

    public String getLanguage() {
        return configFile.getString("language", "en");
    }

    public void setLanguage(String language) {
        configFile.getConfig().set("language", language);
        configFile.saveConfig();
        languageManager.reloadLanguageConfig();
    }

    // Delegate message methods to LanguageManager
    public String getMsgPluginEnabled() {
        return languageManager.getMsgPluginEnabled();
    }

    public String getMsgPluginDisabled() {
        return languageManager.getMsgPluginDisabled();
    }

    public String getHelpText() {
        return languageManager.getHelpText();
    }

    public String getCommandNotFound() {
        return languageManager.getCommandNotFound();
    }

    public String getPlayerOnlyCommand() {
        return languageManager.getPlayerOnlyCommand();
    }

    public String getWelcomeMessage() {
        return languageManager.getWelcomeMessage();
    }

    public List<String> getDescriptionMessages() {
        return languageManager.getDescriptionMessages();
    }

    public String getListCommands() {
        return languageManager.getListCommands();
    }

    public String getReloadText() {
        return languageManager.getReloadText();
    }
}