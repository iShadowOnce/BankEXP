package org.soclabs.bankEXP.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.soclabs.bankEXP.BankEXP;
import org.soclabs.bankEXP.utils.MessageUtils;

public class MainCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {

        // Consola
        if(!(sender instanceof Player)) {
            if(args.length >= 1) {
                if(args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("ayuda")) {
                    // /bank help - /banco ayuda
                    help(sender);
                } else {
                    // /banco usar - /banco transferir - /banco info ...
                    sender.sendMessage(MessageUtils.getColoredMenssage(
                            BankEXP.prefix+"&cSolo puedes usar este comando desde un jugador."
                    ));
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
                sender.sendMessage(MessageUtils.getColoredMenssage(BankEXP.prefix+"&c Funcionalidad en desarrollo."));
            } else if(args[0].equalsIgnoreCase("ayuda")) {
                // /banco ayuda
                sender.sendMessage(MessageUtils.getColoredMenssage(BankEXP.prefix+"&c Funcionalidad en desarrollo."));
            } else if (args[0].equalsIgnoreCase("usar")) {
                // /banco usar
                sender.sendMessage(MessageUtils.getColoredMenssage(BankEXP.prefix+"&c Funcionalidad en desarrollo."));
            } else if (args[0].equalsIgnoreCase("transferir")) {
                // /banco transferir
                sender.sendMessage(MessageUtils.getColoredMenssage(BankEXP.prefix+"&c Funcionalidad en desarrollo."));
            } else if (args[0].equalsIgnoreCase("info")) {
                // /banco info
                sender.sendMessage(MessageUtils.getColoredMenssage(
                        BankEXP.prefix+"&bHola &e"+player.getName()+" &bActualmente tienes &e"+player.getExp()+" &eExperiencia&b, puedes guardarla en el banco."));
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
        sender.sendMessage(MessageUtils.getColoredMenssage(
                "&e&l---> &a&l BANCO DE EXPERIENCIA &e&l<---"
        ));
        sender.sendMessage(MessageUtils.getColoredMenssage(
                "&a- &e/bank help &a-> &bComandos disponibles."
        ));
        sender.sendMessage(MessageUtils.getColoredMenssage(
                "&a- &e/bank info &a-> &bMostrar informacion personal."
        ));
        sender.sendMessage(MessageUtils.getColoredMenssage(
                "&a- &e/bank usar &a-> &bAbrir Banco de Experiencia."
        ));
        sender.sendMessage(MessageUtils.getColoredMenssage(
                "&a- &e/bank transferir &a-> &bTransferir Experiencia a otros usuarios."
        ));
        sender.sendMessage(MessageUtils.getColoredMenssage(
                "&e&l---> &a&l COMANDOS ESENCIALES &e&l<---"
        ));
    }
}
