package me.Pedro.CMD;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FakeAleatorio implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command command, final String commandLabel,
			final String[] args) {
		final Player player = (Player) sender;
		if (commandLabel.equalsIgnoreCase("fakealeatorio")) {
			player.sendMessage("§f§lJoaozindospvp");
			player.sendMessage("§f§lyVeryPVP");
			player.sendMessage("§f§ldolyguarana");
			player.sendMessage("§f§lSorrisoCongate");
			player.sendMessage("§f§lBlaaackoutx");
			player.sendMessage("§f§lTheDougrinhasX");
			player.sendMessage("§f§lHakunaMadara");
			player.sendMessage("§f§lPepeFeio");
			player.sendMessage("§f§lVamoPularVamoPular");
			player.sendMessage("§f§lDesneecessauro");
			player.sendMessage("§f§lObsekio");
			player.sendMessage("§f§lyMatheus123");
			player.sendMessage("§f§lTiagaoDosPvP");
			player.sendMessage("§f§lNegoDoBoreeel");
			player.sendMessage("§f§lyLeftaaayUS");
			player.sendMessage("§f§lAmoOreacteey");
			player.sendMessage("§f§lFilhoDoDinizu");
			player.sendMessage("§f§lDesastradoPvP");
			player.sendMessage("§f§lRickBr");
			player.sendMessage("§f§lFapolkBr");
			player.sendMessage("§f§lECHAVE");
			player.sendMessage("§f§lTRAPAAADU_");
			player.sendMessage("§f§lNEGUINPRETO_");
			player.sendMessage("§f§lOnyxPvP");
			player.sendMessage("§f§lFhaaaleyPvP");
			player.sendMessage("§f§lFelixNexPvP");
			player.sendMessage("§f§lBruninhaaaaaaw");
			player.sendMessage("§f§lBrunoDZN");
			player.sendMessage("§f§lBrasileirooo");
			player.sendMessage("§f§lEspana");
			player.sendMessage("§f§lGozeiVendoRezende");
			player.sendMessage("§f§lMyNameIsPedro");
			player.sendMessage("§f§lOxygenPvP");
			player.sendMessage("§f§lDJ_PVP");
			player.sendMessage("§f§lFENTAPVP");
			player.sendMessage("§f§lCocaColae");
			player.sendMessage("§f§lBoraMatarEle_G0D");
			player.sendMessage("§f§lWellPvP");
			return true;
		}
		return false;
	}
}
