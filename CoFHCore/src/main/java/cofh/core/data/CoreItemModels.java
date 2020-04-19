package cofh.core.data;

import cofh.lib.data.ItemModelProviderCoFH;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ExistingFileHelper;

import static cofh.core.CoFHCore.ITEMS;
import static cofh.lib.util.constants.Constants.ID_COFH_CORE;
import static cofh.lib.util.references.CoreReferences.ID_ECTOPLASM;

public class CoreItemModels extends ItemModelProviderCoFH {

    public CoreItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {

        super(generator, ID_COFH_CORE, existingFileHelper);
    }

    @Override
    public String getName() {

        return "CoFH Core: Item Models";
    }

    @Override
    protected void registerModels() {

        // blockItem(BLOCKS.getSup(ID_GLOSSED_MAGMA));

        generated(ITEMS.getSup(ID_ECTOPLASM));
    }

}
