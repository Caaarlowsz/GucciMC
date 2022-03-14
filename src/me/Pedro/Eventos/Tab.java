package me.Pedro.Eventos;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.spigotmc.ProtocolInjector;

import com.github.caaarlowsz.guccimc.kitpvp.GucciPvP;
import net.minecraft.server.v1_7_R4.ChatSerializer;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;
import net.minecraft.server.v1_7_R4.Packet;
import net.minecraft.server.v1_7_R4.PlayerConnection;

public class Tab implements Listener {
	private static int VERSION;

	static {
		Tab.VERSION = 47;
	}

	public Tab(final GucciPvP main) {
	}

	@EventHandler
	void TabDoServidor(final PlayerJoinEvent e) {
		final Player jogador = e.getPlayer();
		Bukkit.getScheduler().scheduleSyncRepeatingTask(GucciPvP.getPlugin(), (Runnable) new Runnable() {
			@Override
			public void run() {
				final PlayerConnection connect = ((CraftPlayer) jogador).getHandle().playerConnection;
				final IChatBaseComponent top = ChatSerializer
						.a("{'extra': [{text: '', color: 'aqua'}],'color': gold, 'text': '      " + GucciPvP.p
								+ " �7FanntNetwork - KITPVP " + "\n       '}");
				final IChatBaseComponent bottom = ChatSerializer
						.a("{'extra': [{'color': 'aqua', 'text': '\n �7Jogadores: �c"
								+ Bukkit.getServer().getOnlinePlayers().length + " �7|Capacidade: �c"
								+ Bukkit.getMaxPlayers() + "\n�7 "
								+ "', 'underline': 'true'}], 'color': 'gold', 'text': ''}");
				if (((CraftPlayer) jogador).getHandle().playerConnection.networkManager.getVersion() < Tab.VERSION) {
					return;
				}
				connect.sendPacket((Packet) new ProtocolInjector.PacketTabHeader(top, bottom));
			}
		}, 1L, 20L);
	}
}
