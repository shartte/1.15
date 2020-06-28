package cofh.thermal.core.client.gui.workbench;

import cofh.core.client.gui.element.ElementAugmentSlots;
import cofh.lib.util.helpers.StringHelper;
import cofh.thermal.core.client.gui.ThermalScreenBase;
import cofh.thermal.core.inventory.container.workbench.TinkerBenchContainer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

import static cofh.core.util.GuiHelper.*;
import static cofh.lib.util.constants.Constants.ID_THERMAL;

public class TinkerBenchScreen extends ThermalScreenBase<TinkerBenchContainer> {

    public static final String TEX_PATH = ID_THERMAL + ":textures/gui/workbenches/tinker_bench.png";
    public static final ResourceLocation TEXTURE = new ResourceLocation(TEX_PATH);

    public TinkerBenchScreen(TinkerBenchContainer container, PlayerInventory inv, ITextComponent titleIn) {

        super(container, inv, container.tile, StringHelper.getTextComponent("block.thermal.tinker_bench"));
        texture = TEXTURE;
        info = generateTabInfo("info.thermal.tinker_bench");
        name = "tinker_bench";
    }

    @Override
    public void init() {

        super.init();

        addElement(setClearable(createDefaultEnergyStorage(this, 8, 8, tile.getEnergyStorage()), tile, 0));
        addElement(setClearable(createMediumFluidStorage(this, 151, 8, tile.getTank(0)), tile, 0));
        addElement(new ElementAugmentSlots(this, 80, 17, container::getNumTinkerAugmentSlots, container.getTinkerAugmentSlots()));
    }

}