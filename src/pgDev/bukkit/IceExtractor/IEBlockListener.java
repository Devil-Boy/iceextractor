package pgDev.bukkit.IceExtractor;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPistonRetractEvent;
import org.bukkit.inventory.ItemStack;

public class IEBlockListener extends BlockListener {
	private final IE plugin;
	
	public IEBlockListener(final IE pluginI) {
		plugin = pluginI;
	}
	
	public void onBlockPistonRetract(BlockPistonRetractEvent event) {
    	if (!event.isCancelled() && event.isSticky()) {
    		Block movedBlock = event.getRetractLocation().getBlock();
    		if (movedBlock.getType() == Material.ICE) {
    			movedBlock.setType(Material.AIR);
    			movedBlock.getWorld().dropItemNaturally(movedBlock.getLocation(), new ItemStack(Material.ICE, 1));
    		}
    	}
    }
}