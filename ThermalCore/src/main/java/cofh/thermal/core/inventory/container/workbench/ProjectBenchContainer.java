package cofh.thermal.core.inventory.container.workbench;

import cofh.lib.inventory.InvWrapperCoFH;
import cofh.lib.inventory.container.TileContainer;
import cofh.thermal.core.tileentity.workbench.ProjectBenchTile;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static cofh.thermal.core.init.TCoreReferences.PROJECT_BENCH_CONTAINER;

public class ProjectBenchContainer extends TileContainer {

    public final ProjectBenchTile tile;

    public ProjectBenchContainer(int windowId, World world, BlockPos pos, PlayerInventory inventory, PlayerEntity player) {

        super(PROJECT_BENCH_CONTAINER, windowId, world, pos, inventory, player);
        this.tile = (ProjectBenchTile) world.getTileEntity(pos);
        IInventory tileInv = new InvWrapperCoFH(this.tile.getItemInv());

        bindAugmentSlots(tileInv, 3, this.tile.augSize());
        bindPlayerInventory(inventory);
    }

}
