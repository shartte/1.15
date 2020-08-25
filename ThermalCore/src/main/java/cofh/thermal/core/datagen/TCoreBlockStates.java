package cofh.thermal.core.datagen;

import cofh.lib.datagen.BlockStateProviderCoFH;
import cofh.lib.registries.DeferredRegisterCoFH;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ExistingFileHelper;

import static cofh.lib.util.constants.Constants.ID_THERMAL;
import static cofh.thermal.core.ThermalCore.BLOCKS;
import static cofh.thermal.core.init.TCoreIDs.*;

public class TCoreBlockStates extends BlockStateProviderCoFH {

    public TCoreBlockStates(DataGenerator gen, ExistingFileHelper exFileHelper) {

        super(gen, ID_THERMAL, exFileHelper);
    }

    @Override
    public String getName() {

        return "Thermal Core: BlockStates";
    }

    @Override
    protected void registerStatesAndModels() {

        DeferredRegisterCoFH<Block> reg = BLOCKS;

        registerVanilla(reg);
        registerResources(reg);
        registerStorage(reg);
        registerBuildingBlocks(reg);
        registerMisc(reg);
    }

    // region HELPERS
    private void registerVanilla(DeferredRegisterCoFH<Block> reg) {

        storageBlock(reg.getSup(ID_CHARCOAL_BLOCK));
        storageBlock(reg.getSup(ID_GUNPOWDER_BLOCK));
        axisBlock(reg.getSup(ID_BAMBOO_BLOCK), "bamboo_block", STORAGE);
        axisBlock(reg.getSup(ID_SUGAR_CANE_BLOCK), "sugar_cane_block", STORAGE);

        // TODO: Missing - Food Crates
    }

    private void registerResources(DeferredRegisterCoFH<Block> reg) {

        oreBlock(reg.getSup(ID_APATITE_ORE));
        oreBlock(reg.getSup(ID_CINNABAR_ORE));
        oreBlock(reg.getSup(ID_NITER_ORE));
        oreBlock(reg.getSup(ID_SULFUR_ORE));

        oreBlock(reg.getSup(ID_COPPER_ORE));
        oreBlock(reg.getSup(ID_LEAD_ORE));
        oreBlock(reg.getSup(ID_NICKEL_ORE));
        oreBlock(reg.getSup(ID_SILVER_ORE));
        oreBlock(reg.getSup(ID_TIN_ORE));

        oreBlock(reg.getSup(ID_RUBY_ORE));
        oreBlock(reg.getSup(ID_SAPPHIRE_ORE));
    }

    private void registerStorage(DeferredRegisterCoFH<Block> reg) {

        storageBlock(reg.getSup(ID_APATITE_BLOCK));
        storageBlock(reg.getSup(ID_CINNABAR_BLOCK));
        storageBlock(reg.getSup(ID_NITER_BLOCK));
        storageBlock(reg.getSup(ID_SULFUR_BLOCK));

        storageBlock(reg.getSup(ID_COPPER_BLOCK));
        storageBlock(reg.getSup(ID_LEAD_BLOCK));
        storageBlock(reg.getSup(ID_NICKEL_BLOCK));
        storageBlock(reg.getSup(ID_SILVER_BLOCK));
        storageBlock(reg.getSup(ID_TIN_BLOCK));

        storageBlock(reg.getSup(ID_BRONZE_BLOCK));
        storageBlock(reg.getSup(ID_CONSTANTAN_BLOCK));
        storageBlock(reg.getSup(ID_ELECTRUM_BLOCK));
        storageBlock(reg.getSup(ID_INVAR_BLOCK));

        storageBlock(reg.getSup(ID_ENDERIUM_BLOCK));
        storageBlock(reg.getSup(ID_LUMIUM_BLOCK));
        storageBlock(reg.getSup(ID_SIGNALUM_BLOCK));

        storageBlock(reg.getSup(ID_RUBY_BLOCK));
        storageBlock(reg.getSup(ID_SAPPHIRE_BLOCK));

        storageBlock(reg.getSup(ID_SAWDUST_BLOCK));
        // TODO: Add a top/bottom method to handle this easily.
        // storageBlock(reg.getSup(ID_ROSIN_BLOCK));

        storageBlock(reg.getSup(ID_RUBBER_BLOCK));
        storageBlock(reg.getSup(ID_CURED_RUBBER_BLOCK));
        storageBlock(reg.getSup(ID_SLAG_BLOCK));
        storageBlock(reg.getSup(ID_RICH_SLAG_BLOCK));
    }

    private void registerBuildingBlocks(DeferredRegisterCoFH<Block> reg) {

        // TODO: Missing - Machine Frame

        glassBlock(reg.getSup(ID_HARDENED_GLASS));
        glassBlock(reg.getSup(ID_SIGNALUM_GLASS));
        glassBlock(reg.getSup(ID_LUMIUM_GLASS));
        glassBlock(reg.getSup(ID_ENDERIUM_GLASS));
    }

    private void registerMisc(DeferredRegisterCoFH<Block> reg) {

        // miscBlock(reg.getSup(ID_PHYTO_TNT));
    }
    // endregion
}
