package org.soclabs.bankEXP.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.soclabs.bankEXP.BankEXP;
import org.soclabs.bankEXP.utils.MessageUtils;

public class MainCommand implements CommandExecutor {

    private BankEXP plugin;

    public MainCommand(BankEXP plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {

        // Consola
        if(!(sender instanceof Player)) {
            if(args.length >= 1) {
                if(args[0].equalsIgnoreCase("help")) {
                    // /bank help
                    help(sender);
                } else if (args[0].equalsIgnoreCase("get")) {
                    // /bank get <author/version>
                    subCommandGet(sender, args);
                } else {
                    // /bank use - /bank transfer - /bank info ...
                    sender.sendMessage(MessageUtils.getPrefixedMessage("console.player-only"));
                }
            } else {
                // Se ejecuta cuando la consola solo usa /bank, es decir, sin args.
                help(sender);
            }
            return true;
        }

        // Jugador
        Player player = (Player) sender;

        // Comando - args[0] args[1] args[2]...
        if(args.length >=1) {
            if(args[0].equalsIgnoreCase("help")){
                // /bank help
                sender.sendMessage(MessageUtils.getPrefixedMessage("command.in-development"));
            } else if (args[0].equalsIgnoreCase("use")) {
                // /bank use
                sender.sendMessage(MessageUtils.getPrefixedMessage("command.in-development"));
            } else if (args[0].equalsIgnoreCase("transfer")) {
                // /bank transfer
                sender.sendMessage(MessageUtils.getPrefixedMessage("command.in-development"));
            } else if (args[0].equalsIgnoreCase("info")) {
                // /bank info
                sender.sendMessage(MessageUtils.getPrefixedMessage("command.info",
                        "%player%", player.getName(), "%level%", String.valueOf(player.getLevel())));
            } else if (args[0].equalsIgnoreCase("get")) {
                // /bank get <author/version>
                subCommandGet(sender, args);
            } else {
                help(sender);
            }

        } else {
            // Se ejecuta cuando el jugador solo usa /bank, es decir, sin args.
            help(sender);
        }
        return true;
    }

    public void help (CommandSender sender) {
        sender.sendMessage(MessageUtils.getMessage("help.header"));
        sender.sendMessage(MessageUtils.getMessage("help.help"));
        sender.sendMessage(MessageUtils.getMessage("help.info"));
        sender.sendMessage(MessageUtils.getMessage("help.use"));
        sender.sendMessage(MessageUtils.getMessage("help.transfer"));
        sender.sendMessage(MessageUtils.getMessage("help.essential-header"));

        sender.sendMessage("");

        sender.sendMessage(MessageUtils.getMessage("help.admin-header"));
        sender.sendMessage(MessageUtils.getMessage("help.get-version"));
        sender.sendMessage(MessageUtils.getMessage("help.get-author"));
    }

    public void subCommandGet(CommandSender sender, String[] args) {
        if(args.length == 1) {
            // bank get version
            sender.sendMessage(MessageUtils.getPrefixedMessage("command.get-usage"));
            return;
        }

        if(args[1].equalsIgnoreCase("author")) {
            // bank get author
            sender.sendMessage(MessageUtils.getPrefixedMessage("command.get-author",
                    "%author%", plugin.getDescription().getAuthors().toString()));
        } else if (args[1].equalsIgnoreCase("version")) {
            // bank get version
            sender.sendMessage(MessageUtils.getPrefixedMessage("command.get-version",
                    "%version%", plugin.getDescription().getVersion()));
        } else {
            sender.sendMessage(MessageUtils.getPrefixedMessage("command.get-usage-error"));
        }
    }
}
