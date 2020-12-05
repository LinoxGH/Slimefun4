package io.github.thebusybiscuit.slimefun4.core.handlers;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.events.AndroidMineEvent;
import io.github.thebusybiscuit.slimefun4.implementation.items.androids.MinerAndroid;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.handlers.ItemHandler;

/**
 * The {@link BlockBreakHandler} is called when a {@link Block} is broken
 * which holds a {@link SlimefunItem}.
 * The {@link BlockBreakHandler} provides three methods for this, one for block breaking
 * caused by a {@link Player}, one for a {@link MinerAndroid} and one method for a {@link Block}
 * being destroyed by an explosion.
 * 
 * @author TheBusyBiscuit
 * 
 * @see BlockPlaceHandler
 *
 */
public abstract class BlockBreakHandler implements ItemHandler {

    /**
     * Whether a {@link MinerAndroid} is allowed to break this block.
     */
    private final boolean allowAndroids;

    /**
     * Whether an explosion is allowed to destroy this block.
     */
    private final boolean allowExplosions;

    /**
     * This constructs a new {@link BlockBreakHandler}.
     * 
     * @param allowAndroids
     *            Whether a {@link MinerAndroid} is allowed to break blocks of this type
     * @param allowExplosions
     *            Whether blocks of this type are allowed to be broken by explosions
     */
    public BlockBreakHandler(boolean allowAndroids, boolean allowExplosions) {
        this.allowAndroids = allowAndroids;
        this.allowExplosions = allowExplosions;
    }

    @ParametersAreNonnullByDefault
    public abstract void onPlayerBreak(BlockBreakEvent e, ItemStack item, List<ItemStack> drops);

    @ParametersAreNonnullByDefault
    public void onExplode(Block b, List<ItemStack> drops) {
        // This can be overridden, if necessary
    }

    @ParametersAreNonnullByDefault
    public void onAndroidBreak(AndroidMineEvent e) {
        // This can be overridden, if necessary
    }

    public boolean isExplosionAllowed() {
        return allowExplosions;
    }

    public boolean isAndroidAllowed() {
        return allowAndroids;
    }

    @Override
    public final Class<? extends ItemHandler> getIdentifier() {
        return BlockBreakHandler.class;
    }
}
