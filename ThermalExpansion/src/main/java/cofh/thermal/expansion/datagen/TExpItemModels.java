package cofh.thermal.expansion.datagen;

import cofh.lib.datagen.ItemModelProviderCoFH;
import cofh.lib.registries.DeferredRegisterCoFH;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.generators.ExistingFileHelper;

import static cofh.lib.util.constants.Constants.ID_THERMAL;
import static cofh.thermal.core.ThermalCore.BLOCKS;
import static cofh.thermal.core.ThermalCore.ITEMS;
import static cofh.thermal.expansion.init.TExpIDs.*;

public class TExpItemModels extends ItemModelProviderCoFH {

    public TExpItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {

        super(generator, ID_THERMAL, existingFileHelper);
    }

    @Override
    public String getName() {

        return "Thermal Expansion: Item Models";
    }

    @Override
    protected void registerModels() {

        registerBlockItemModels();

        DeferredRegisterCoFH<Item> reg = ITEMS;

        generated(reg.getSup("chiller_ball_cast"), CRAFTING);

        generated(reg.getSup("press_coin_die"), CRAFTING);
        generated(reg.getSup("press_gear_die"), CRAFTING);
    }

    private void registerBlockItemModels() {

        DeferredRegisterCoFH<Block> reg = BLOCKS;

        blockItem(reg.getSup(ID_MACHINE_FURNACE));
        blockItem(reg.getSup(ID_MACHINE_SAWMILL));
        blockItem(reg.getSup(ID_MACHINE_PULVERIZER));
        blockItem(reg.getSup(ID_MACHINE_SMELTER));
        blockItem(reg.getSup(ID_MACHINE_INSOLATOR));
        blockItem(reg.getSup(ID_MACHINE_CENTRIFUGE));
        blockItem(reg.getSup(ID_MACHINE_PRESS));
        blockItem(reg.getSup(ID_MACHINE_CRUCIBLE));
        blockItem(reg.getSup(ID_MACHINE_CHILLER));
        blockItem(reg.getSup(ID_MACHINE_REFINERY));
        blockItem(reg.getSup(ID_MACHINE_BREWER));
        blockItem(reg.getSup(ID_MACHINE_BOTTLER));
        // blockItem(reg.getSup(ID_MACHINE_FURNACE));

        blockItem(reg.getSup(ID_DYNAMO_STIRLING));
        blockItem(reg.getSup(ID_DYNAMO_COMPRESSION));
        blockItem(reg.getSup(ID_DYNAMO_MAGMATIC));
        blockItem(reg.getSup(ID_DYNAMO_NUMISMATIC));
        blockItem(reg.getSup(ID_DYNAMO_LAPIDARY));
    }

}
