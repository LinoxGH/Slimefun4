package io.github.thebusybiscuit.slimefun4.core.handlers;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import io.github.thebusybiscuit.slimefun4.implementation.items.multiblocks.EnhancedCraftingTable;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.handlers.ItemHandler;

/**
 * This {@link ItemHandler} is triggered when the {@link EnhancedCraftingTable} crafts
 * a {@link SlimefunItem}.
 * 
 * @author Linox
 *
 * @see ItemHandler
 * @see SimpleSlimefunItem
 * @see EnhancedCraftingTable
 * 
 */
@FunctionalInterface
public interface EnhancedCraftingTableCraftHandler extends ItemHandler {

    /**
     * This function is triggered when a {@link Player} right clicks with the assigned {@link SlimefunItem}
     * in his hand.
     * 
     * @param disp
     *            The dispenser {@link Block} that the crafting happened.
     * @param result
     *            The {@link ItemStack} that was produced.
     */
    boolean onCraft(@Nonnull Block disp, @Nonnull ItemStack result);

    @Override
    default Class<? extends ItemHandler> getIdentifier() {
        return EnhancedCraftingTableCraftHandler.class;
    }

    @Override
    default boolean isPrivate() {
        return false;
    }
    
}
