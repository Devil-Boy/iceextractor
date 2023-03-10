package pgDev.bukkit.IceExtractor;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class IE extends JavaPlugin {
	// Listener
	final IEBlockListener blockListener = new IEBlockListener(this);
	
	public void onEnable() {
		// Register necessary events
		PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(blockListener, this);
		
		// Alert Bukkit users of our presence
        PluginDescriptionFile pdfFile = this.getDescription();
        System.out.println( pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!" );
	}
	
	public void onDisable() {
		System.out.println("IceExtractor disabled!");
	}
}
