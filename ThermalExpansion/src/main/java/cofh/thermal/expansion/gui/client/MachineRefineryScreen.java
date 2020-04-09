package cofh.thermal.expansion.gui.client;

import cofh.core.gui.element.ElementScaled;
import cofh.core.gui.element.ElementScaled.StartDirection;
import cofh.core.gui.element.ElementScaledFluid;
import cofh.core.util.GuiHelper;
import cofh.lib.util.helpers.StringHelper;
import cofh.thermal.core.gui.client.MachineScreenBase;
import cofh.thermal.expansion.inventory.container.machine.MachineRefineryContainer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

import static cofh.core.util.GuiHelper.*;
import static cofh.lib.util.constants.Constants.ID_THERMAL;

public class MachineRefineryScreen extends MachineScreenBase<MachineRefineryContainer> {

    public static final String TEX_PATH = ID_THERMAL + ":textures/gui/machine/refinery.png";
    public static final ResourceLocation TEXTURE = new ResourceLocation(TEX_PATH);

    public MachineRefineryScreen(MachineRefineryContainer container, PlayerInventory inv, ITextComponent titleIn) {

        super(container, inv, container.tile, StringHelper.getTextComponent("block.thermal.machine_refinery"));
        texture = TEXTURE;
        info = generateTabInfo("info.thermal.machine_refinery");
    }

    @Override
    public void init() {

        super.init();

        addElement(GuiHelper.createSmallFluidStorage(this, 34, 17, tile.getTank(0)));
        addElement(GuiHelper.createMediumFluidStorage(this, 133, 22, tile.getTank(1)));
        addElement(GuiHelper.createMediumFluidStorage(this, 151, 22, tile.getTank(2)));

        progressOverlay = (ElementScaledFluid) addElement(new ElementScaledFluid(this, 65, 35).setFluid(tile.getRenderFluid()).setDirection(StartDirection.LEFT).setSize(PROGRESS, 16).setTexture(PROG_DROP_RIGHT, 64, 16));
        speed = (ElementScaled) addElement(new ElementScaled(this, 35, 53).setSize(16, SPEED).setTexture(SCALE_FLAME, 32, 16));
    }

}
