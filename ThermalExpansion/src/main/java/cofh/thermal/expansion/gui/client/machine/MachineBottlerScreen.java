package cofh.thermal.expansion.gui.client.machine;

import cofh.lib.util.helpers.StringHelper;
import cofh.thermal.core.gui.client.MachineScreenBase;
import cofh.thermal.expansion.inventory.container.machine.MachineBottlerContainer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

import static cofh.core.util.GuiHelper.*;
import static cofh.lib.util.constants.Constants.ID_THERMAL;

public class MachineBottlerScreen extends MachineScreenBase<MachineBottlerContainer> {

    public static final String TEX_PATH = ID_THERMAL + ":textures/gui/machine/bottler.png";
    public static final ResourceLocation TEXTURE = new ResourceLocation(TEX_PATH);

    public MachineBottlerScreen(MachineBottlerContainer container, PlayerInventory inv, ITextComponent titleIn) {

        super(container, inv, container.tile, StringHelper.getTextComponent("block.thermal.machine_bottler"));
        texture = TEXTURE;
        info = generateTabInfo("info.thermal.machine_bottler");
    }

    @Override
    public void init() {

        super.init();

        addElement(createInputSlot(this, 62, 26, tile));

        addElement(createLargeOutputSlot(this, 125, 35, tile));

        addElement(createMediumInputFluidStorage(this, 34, 22, tile.getTank(0), tile));

        progressOverlay = addElement(createDefaultFluidProgress(this, 88, 34, PROG_ARROW_FLUID_RIGHT, tile.getRenderFluid(), () -> !tile.getRenderFluid().isEmpty()));
        progress = addElement(createDefaultProgress(this, 88, 34, PROG_ARROW_RIGHT, () -> tile.getRenderFluid().isEmpty()));
        speed = addElement(createDefaultSpeed(this, 62, 44, SCALE_BUBBLE));
    }

}