package me.Pedro.CMD;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import ca.wacos.nametagedit.NametagAPI;
import me.Pedro.Main;
import me.Pedro.Eventos.ChatAPI;

public class Tag implements Listener, CommandExecutor {
	public Tag(final Main main) {
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!cmd.getName().equalsIgnoreCase("tag")) {
			return false;
		}
		final Player p = (Player) sender;
		if (args.length != 0) {
			if (args[0].equalsIgnoreCase("normal")) {
				if (p.hasPermission("tag.normal")) {
					p.sendMessage(
							String.valueOf(String.valueOf(Main.p)) + " §7Sua tag foi alterada para: §7§lNORMAL §7!");
					p.setDisplayName("§7§lNORMAL §7" + p.getName());
					p.setPlayerListName("§7" + getShortStr(p.getName()));
					NametagAPI.setPrefix(p.getName(), "§7§lNORMAL §7");
					return true;
				}
				p.sendMessage(String.valueOf(String.valueOf(Main.p)) + " §7Sem permiss\u00e3o !");
			}
			if (args[0].equalsIgnoreCase("pro")) {
				if (p.hasPermission("tag.pro")) {
					p.sendMessage(String.valueOf(String.valueOf(Main.p)) + " §7Sua tag foi alterada para: §6§lPRO §7!");
					p.setDisplayName("§6§lVIP §6" + p.getName());
					p.setPlayerListName("§6" + getShortStr(p.getName()));
					NametagAPI.setPrefix(p.getName(), "§6§lPRO §6");
					return true;
				}
				p.sendMessage(String.valueOf(String.valueOf(Main.p)) + " §7Sem permiss\u00e3o !");
			}
			if (args[0].equalsIgnoreCase("pro")) {
				if (p.hasPermission("tag.pro")) {
					p.sendMessage(String.valueOf(String.valueOf(Main.p)) + " §7Sua tag foi alterada para: §6§lPRO §7!");
					p.setDisplayName("§6§lVIP §6" + p.getName());
					p.setPlayerListName("§6" + getShortStr(p.getName()));
					NametagAPI.setPrefix(p.getName(), "§6§lPRO §6");
					return true;
				}
				p.sendMessage(String.valueOf(String.valueOf(Main.p)) + " §7Sem permiss\u00e3o !");
			}
			if (args[0].equalsIgnoreCase("builder")) {
				if (p.hasPermission("tag.builder")) {
					p.sendMessage(
							String.valueOf(String.valueOf(Main.p)) + " §7Sua tag foi alterada para: §9§lBUILDER §7!");
					p.setDisplayName("§9§lBUILDER §9" + p.getName());
					p.setPlayerListName("§9" + getShortStr(p.getName()));
					NametagAPI.setPrefix(p.getName(), "§9§lBUILDER §9");
					return true;
				}
				p.sendMessage(String.valueOf(String.valueOf(Main.p)) + " §7Sem permiss\u00e3o !");
			}
			if (args[0].equalsIgnoreCase("mvp")) {
				if (p.hasPermission("tag.mvp")) {
					p.sendMessage(String.valueOf(String.valueOf(Main.p)) + " §7Sua tag foi alterada para: §9§lMVP §7!");
					p.setDisplayName("§9§lMVP §9" + p.getName());
					p.setPlayerListName("§9" + getShortStr(p.getName()));
					NametagAPI.setPrefix(p.getName(), "§9§lMVP §9");
					return true;
				}
				p.sendMessage(String.valueOf(String.valueOf(Main.p)) + " §7Sem permiss\u00e3o !");
			}
			if (args[0].equalsIgnoreCase("yt")) {
				if (p.hasPermission("tag.yt")) {
					p.sendMessage(String.valueOf(String.valueOf(Main.p)) + " §7Sua tag foi alterada para: §b§lYT §7!");
					p.setDisplayName("§b§lYT §b" + p.getName());
					p.setPlayerListName("§b" + getShortStr(p.getName()));
					NametagAPI.setPrefix(p.getName(), "§b§lYT §b");
					return true;
				}
				p.sendMessage(String.valueOf(String.valueOf(Main.p)) + " §7Sem permiss\u00e3o !");
			}
			if (args[0].equalsIgnoreCase("trial")) {
				if (p.hasPermission("tag.trial")) {
					p.sendMessage(
							String.valueOf(String.valueOf(Main.p)) + " §7Sua tag foi alterada para: §d§lTRIAL §7!");
					p.setDisplayName("§d§lTRIAL §d" + p.getName());
					p.setPlayerListName("§d" + getShortStr(p.getName()));
					NametagAPI.setPrefix(p.getName(), "§d§lTRIAL §d");
					return true;
				}
				p.sendMessage(String.valueOf(String.valueOf(Main.p)) + " §7Sem permiss\u00e3o !");
			}
			if (args[0].equalsIgnoreCase("tk")) {
				if (p.hasPermission("tag.tk")) {
					p.sendMessage(String.valueOf(String.valueOf(Main.p)) + " §7Sua tag foi alterada para: §e§lTK §7!");
					p.setDisplayName("§e§lTK §e" + p.getName());
					p.setPlayerListName("§e" + getShortStr(p.getName()));
					NametagAPI.setPrefix(p.getName(), "§e§lTK §e");
					return true;
				}
				p.sendMessage(String.valueOf(String.valueOf(Main.p)) + " §7Sem permiss\u00e3o !");
			}
			if (args[0].equalsIgnoreCase("copa")) {
				if (p.hasPermission("tag.copa")) {
					p.sendMessage(
							String.valueOf(String.valueOf(Main.p)) + " §7Sua tag foi alterada para: §e§lCOPA §7!");
					p.setDisplayName("§e§lCOPA §e" + p.getName());
					p.setPlayerListName("§e" + getShortStr(p.getName()));
					NametagAPI.setPrefix(p.getName(), "§e§lCOPA §e");
					return true;
				}
				p.sendMessage(String.valueOf(String.valueOf(Main.p)) + " §7Sem permiss\u00e3o !");
			}
			if (args[0].equalsIgnoreCase("mod")) {
				if (p.hasPermission("tag.mod")) {
					p.sendMessage(String.valueOf(String.valueOf(Main.p)) + " §7Sua tag foi alterada para: §5§lMOD §7!");
					p.setDisplayName("§5§lMOD §5" + p.getName());
					p.setPlayerListName("§5" + getShortStr(p.getName()));
					NametagAPI.setPrefix(p.getName(), "§5§lMOD §5");
					return true;
				}
				p.sendMessage(String.valueOf(String.valueOf(Main.p)) + " §7Sem permiss\u00e3o !");
			}
			if (args[0].equalsIgnoreCase("mod+")) {
				if (p.hasPermission("tag.mod+")) {
					p.sendMessage(
							String.valueOf(String.valueOf(Main.p)) + " §7Sua tag foi alterada para: §5§lMOD+ §7!");
					p.setDisplayName("§5§lMOD+ §5" + p.getName());
					p.setPlayerListName("§5" + getShortStr(p.getName()));
					NametagAPI.setPrefix(p.getName(), "§5§lMOD+ §5");
					return true;
				}
				p.sendMessage(String.valueOf(String.valueOf(Main.p)) + " §7Sem permiss\u00e3o !");
			}
			if (args[0].equalsIgnoreCase("admin")) {
				if (p.hasPermission("tag.admin")) {
					p.sendMessage(
							String.valueOf(String.valueOf(Main.p)) + " §7Sua tag foi alterada para: §c§lADMIN §7!");
					p.setDisplayName("§c§lADMIN §c" + p.getName());
					p.setPlayerListName("§c" + getShortStr(p.getName()));
					NametagAPI.setPrefix(p.getName(), "§c§lADMIN §c");
					return true;
				}
				p.sendMessage(String.valueOf(String.valueOf(Main.p)) + " §7Sem permiss\u00e3o !");
			}
			if (args[0].equalsIgnoreCase("ajudante")) {
				if (p.hasPermission("tag.ajudante")) {
					p.sendMessage(
							String.valueOf(String.valueOf(Main.p)) + " §7Sua tag foi alterada para: §e§lAJUDANTE §7!");
					p.setDisplayName("§e§lAJUDANTE §e" + p.getName());
					p.setPlayerListName("§e" + getShortStr(p.getName()));
					NametagAPI.setPrefix(p.getName(), "§e§lAJUDANTE §e");
					return true;
				}
				p.sendMessage(String.valueOf(String.valueOf(Main.p)) + " §7Sem permiss\u00e3o !");
			}
			if (args[0].equalsIgnoreCase("vip")) {
				if (p.hasPermission("tag.vip")) {
					p.sendMessage(String.valueOf(String.valueOf(Main.p)) + " §7Sua tag foi alterada para: §a§lVIP §7!");
					p.setDisplayName("§a§lVIP §a" + p.getName());
					p.setPlayerListName("§a" + getShortStr(p.getName()));
					NametagAPI.setPrefix(p.getName(), "§a§lVIP §a");
					return true;
				}
				p.sendMessage(String.valueOf(String.valueOf(Main.p)) + " §7Sem permiss\u00e3o !");
			}
			if (args[0].equalsIgnoreCase("spro")) {
				if (p.hasPermission("tag.spro")) {
					p.sendMessage(
							String.valueOf(String.valueOf(Main.p)) + " §7Sua tag foi alterada para: §6§lSPRO §7!");
					p.setDisplayName("§6§lSPRO §6" + p.getName());
					p.setPlayerListName("§6" + getShortStr(p.getName()));
					NametagAPI.setPrefix(p.getName(), "§6§lSPRO §6");
					return true;
				}
				p.sendMessage(String.valueOf(String.valueOf(Main.p)) + " §7Sem permiss\u00e3o !");
			}
			if (args[0].equalsIgnoreCase("dona")) {
				if (p.hasPermission("tag.dona")) {
					p.sendMessage(String.valueOf(String.valueOf(Main.p))
							+ " §7Sua tag foi alterada para: §4§lDONA SUA LINDA §7!");
					p.setDisplayName("§4§lDONA §4" + p.getName());
					p.setPlayerListName("§4" + getShortStr(p.getName()));
					NametagAPI.setPrefix(p.getName(), "§4§lDONA §4");
					return true;
				}
				p.sendMessage(String.valueOf(String.valueOf(Main.p)) + " §7Sem permiss\u00e3o !");
			}
			if (args[0].equalsIgnoreCase("fundador")) {
				if (p.hasPermission("tag.fundador")) {
					if (!p.getName().equals("reacteey") && p.getName() != "reacteey") {
						p.sendMessage("§4§lTAG §a» §fVoc\u00ea, n\u00e3o \u00e9 o §3§lFUNDADOR!");
						p.sendMessage("§4§lTAG §a» §7Kickando em 2 Segundos!");
						Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin,
								(Runnable) new Runnable() {
									@Override
									public void run() {
										p.kickPlayer(
												"§c§lMODERADOR §7- §fVoc\u00ea, n\u00e3o \u00e9 o §3§lFUNDADOR §fdeste servidor!");
									}
								}, 60L);
					}
					p.sendMessage(
							String.valueOf(String.valueOf(Main.p)) + " §7Sua tag foi alterada para: §3§lFUNDADOR §7!");
					p.setDisplayName("§3§lFUNDADOR §3" + p.getName());
					p.setPlayerListName("§3" + getShortStr(p.getName()));
					NametagAPI.setPrefix(p.getName(), "§3§lFUNDADOR §3");
					return true;
				}
				p.sendMessage(String.valueOf(String.valueOf(Main.p)) + " §7Sem permiss\u00e3o !");
			}
			return false;
		}
		if (p.hasPermission("tag.normal")) {
			p.sendMessage(" ");
			p.sendMessage(String.valueOf(String.valueOf(Main.p)) + " §7Suas tags:");
			p.sendMessage(" ");
			ChatAPI.Comando(p.getName(), "§7§lNORMAL", "/tag normal", "§7Clique (§bbot\u00e3o esquerdo§7) !");
			if (p.hasPermission("tag.pro")) {
				ChatAPI.Comando(p.getName(), "§6§lPRO", "/tag pro", "§7Clique (§bbot\u00e3o esquerdo§7) !");
			}
			if (p.hasPermission("tag.builder")) {
				ChatAPI.Comando(p.getName(), "§9§lBUILDER", "/tag builder", "§7Clique (§bbot\u00e3o esquerdo§7) !");
			}
			if (p.hasPermission("tag.mvp")) {
				ChatAPI.Comando(p.getName(), "§9§lMVP", "/tag mvp", "§7Clique (§bbot\u00e3o esquerdo§7) !");
			}
			if (p.hasPermission("tag.yt")) {
				ChatAPI.Comando(p.getName(), "§b§lYT", "/tag yt", "§7Clique (§bbot\u00e3o esquerdo§7) !");
			}
			if (p.hasPermission("tag.trial")) {
				ChatAPI.Comando(p.getName(), "§d§lTRIAL", "/tag trial", "§7Clique (§bbot\u00e3o esquerdo§7) !");
			}
			if (p.hasPermission("tag.tk")) {
				ChatAPI.Comando(p.getName(), "§e§lTK", "/tag tk", "§7Clique (§bbot\u00e3o esquerdo§7) !");
			}
			if (p.hasPermission("tag.copa")) {
				ChatAPI.Comando(p.getName(), "§e§lCOPA", "/tag copa", "§7Clique (§bbot\u00e3o esquerdo§7) !");
			}
			if (p.hasPermission("tag.mod")) {
				ChatAPI.Comando(p.getName(), "§5§lMOD", "/tag mod", "§7Clique (§bbot\u00e3o esquerdo§7) !");
			}
			if (p.hasPermission("tag.mod+")) {
				ChatAPI.Comando(p.getName(), "§5§lMOD+", "/tag mod+", "§7Clique (§bbot\u00e3o esquerdo§7) !");
			}
			if (p.hasPermission("tag.admin")) {
				ChatAPI.Comando(p.getName(), "§c§lADMIN", "/tag admin", "§7Clique (§bbot\u00e3o esquerdo§7) !");
			}
			if (p.hasPermission("tag.ajudante")) {
				ChatAPI.Comando(p.getName(), "§e§lAJUDANTE", "/tag ajudante", "§7Clique (§bbot\u00e3o esquerdo§7) !");
			}
			if (p.hasPermission("tag.vip")) {
				ChatAPI.Comando(p.getName(), "§a§lVIP", "/tag vip", "§7Clique (§bbot\u00e3o esquerdo§7) !");
			}
			if (p.hasPermission("tag.spro")) {
				ChatAPI.Comando(p.getName(), "§6§lSPRO", "/tag spro", "§7Clique (§bbot\u00e3o esquerdo§7) !");
			}
			if (p.hasPermission("tag.dono")) {
				ChatAPI.Comando(p.getName(), "§4§lDONO", "/tag dono", "§7Clique (§bbot\u00e3o esquerdo§7) !");
			}
			if (p.hasPermission("tag.fundador")) {
				ChatAPI.Comando(p.getName(), "§3§lFUNDADOR", "/tag fundador", "§7Clique (§bbot\u00e3o esquerdo§7) !");
			}
		}
		return false;
	}

	public static String getShortStr(final String s) {
		if (s.length() == 20) {
			final String shorts = s.substring(0, s.length() - 12);
			return shorts;
		}
		if (s.length() == 19) {
			final String shorts = s.substring(0, s.length() - 11);
			return shorts;
		}
		if (s.length() == 18) {
			final String shorts = s.substring(0, s.length() - 10);
			return shorts;
		}
		if (s.length() == 17) {
			final String shorts = s.substring(0, s.length() - 9);
			return shorts;
		}
		if (s.length() == 16) {
			final String shorts = s.substring(0, s.length() - 8);
			return shorts;
		}
		if (s.length() == 15) {
			final String shorts = s.substring(0, s.length() - 7);
			return shorts;
		}
		if (s.length() == 14) {
			final String shorts = s.substring(0, s.length() - 6);
			return shorts;
		}
		if (s.length() == 13) {
			final String shorts = s.substring(0, s.length() - 5);
			return shorts;
		}
		if (s.length() == 12) {
			final String shorts = s.substring(0, s.length() - 4);
			return shorts;
		}
		if (s.length() == 11) {
			final String shorts = s.substring(0, s.length() - 3);
			return shorts;
		}
		if (s.length() == 10) {
			final String shorts = s.substring(0, s.length() - 2);
			return shorts;
		}
		if (s.length() == 9) {
			final String shorts = s.substring(0, s.length() - 1);
			return shorts;
		}
		return s;
	}
}
