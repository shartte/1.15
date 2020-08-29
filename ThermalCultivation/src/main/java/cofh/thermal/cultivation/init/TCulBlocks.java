package cofh.thermal.cultivation.init;

import cofh.core.util.ProxyUtils;
import cofh.lib.block.Block4Way;
import cofh.lib.block.CakeBlockCoFH;
import cofh.lib.block.TileBlock4Way;
import cofh.lib.block.crops.StemBlockAttached;
import cofh.lib.block.crops.StemBlockCoFH;
import cofh.thermal.core.common.ThermalConfig;
import cofh.thermal.cultivation.block.FrostMelonBlock;
import cofh.thermal.cultivation.block.SoilBlock;
import cofh.thermal.cultivation.block.TilledSoilBlock;
import cofh.thermal.cultivation.inventory.container.device.DeviceSoilInfuserContainer;
import cofh.thermal.cultivation.tileentity.DeviceSoilInfuserTile;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.extensions.IForgeContainerType;

import java.util.function.IntSupplier;
import java.util.function.Predicate;

import static cofh.thermal.core.ThermalCore.*;
import static cofh.thermal.core.util.RegistrationHelper.*;
import static cofh.thermal.cultivation.init.TCulIDs.*;
import static cofh.thermal.cultivation.init.TCulReferences.DEVICE_SOIL_INFUSER_BLOCK;
import static net.minecraft.block.Block.Properties.create;

public class TCulBlocks {

    private TCulBlocks() {

    }

    public static void register() {

        registerPlants();
        registerFoods();
        registerStorage();
        registerMisc();

        registerTileBlocks();
        registerTileContainers();
        registerTileEntities();
    }

    public static void setup() {

        FireBlock fire = (FireBlock) Blocks.FIRE;

        fire.setFireInfo(BLOCKS.get(block(ID_BARLEY)), 60, 20);
    }

    // region HELPERS
    private static void registerPlants() {

        // ANNUAL
        registerAnnual(ID_BARLEY);
        // registerTallAnnual(ID_CORN);
        registerAnnual(ID_ONION);
        registerAnnual(ID_RADISH);
        registerAnnual(ID_RICE);
        registerAnnual(ID_SADIROOT);
        registerAnnual(ID_SPINACH);

        // PERENNIAL
        registerPerennial(ID_BELL_PEPPER);
        registerPerennial(ID_EGGPLANT);
        registerPerennial(ID_GREEN_BEAN);
        registerPerennial(ID_PEANUT);
        registerPerennial(ID_STRAWBERRY);
        registerPerennial(ID_TOMATO);

        registerPerennial(ID_COFFEE);
        // registerTallPerennial(ID_HOPS);
        registerPerennial(ID_TEA);

        // STEM
        registerBlock(ID_FROST_MELON, () -> new FrostMelonBlock(create(Material.GOURD, MaterialColor.CYAN).hardnessAndResistance(1.0F).sound(SoundType.SNOW).tickRandomly()), Rarity.UNCOMMON);
        registerBlockOnly(ID_FROST_MELON_STEM, () -> new StemBlockCoFH(create(Material.PLANTS).doesNotBlockMovement().hardnessAndResistance(0.0F).sound(SoundType.WOOD)).crop(BLOCKS.getSup(ID_FROST_MELON)).seed(ITEMS.getSup(seeds(ID_FROST_MELON))));
        registerBlockOnly(ID_FROST_MELON_STEM_ATTACHED, () -> new StemBlockAttached(create(Material.PLANTS).doesNotBlockMovement().hardnessAndResistance(0.0F).sound(SoundType.STEM)).crop(BLOCKS.getSup(ID_FROST_MELON)).seed(ITEMS.getSup(seeds(ID_FROST_MELON))));
    }

    private static void registerFoods() {

        registerBlock(ID_CHOCOLATE_CAKE, () -> new CakeBlockCoFH(create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH), TCulFoods.CHOCOLATE_CAKE));
        registerBlock(ID_SPICE_CAKE, () -> new CakeBlockCoFH(create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH), TCulFoods.SPICE_CAKE));
    }

    private static void registerStorage() {

        registerBlock(block(ID_BARLEY), () -> new HayBlock(create(Material.ORGANIC, MaterialColor.GOLD).hardnessAndResistance(0.5F).sound(SoundType.PLANT)));
        registerBlock(block(ID_CORN), () -> new Block(create(Material.WOOD, MaterialColor.YELLOW).hardnessAndResistance(1.5F).sound(SoundType.WOOD)));
        registerBlock(block(ID_ONION), () -> new Block(create(Material.WOOD, MaterialColor.WHITE_TERRACOTTA).hardnessAndResistance(1.5F).sound(SoundType.WOOD)));
        registerBlock(block(ID_RADISH), () -> new Block(create(Material.WOOD, MaterialColor.RED_TERRACOTTA).hardnessAndResistance(1.5F).sound(SoundType.WOOD)));
        registerBlock(block(ID_SADIROOT), () -> new Block(create(Material.WOOD, MaterialColor.GREEN_TERRACOTTA).hardnessAndResistance(1.5F).sound(SoundType.WOOD)));
        registerBlock(block(ID_SPINACH), () -> new Block(create(Material.WOOD, MaterialColor.GREEN).hardnessAndResistance(1.5F).sound(SoundType.WOOD)));

        registerBlock(block(ID_BELL_PEPPER), () -> new Block(create(Material.WOOD, MaterialColor.RED_TERRACOTTA).hardnessAndResistance(1.5F).sound(SoundType.WOOD)));
        registerBlock(block(ID_EGGPLANT), () -> new Block(create(Material.WOOD, MaterialColor.PURPLE_TERRACOTTA).hardnessAndResistance(1.5F).sound(SoundType.WOOD)));
        registerBlock(block(ID_GREEN_BEAN), () -> new Block(create(Material.WOOD, MaterialColor.GREEN).hardnessAndResistance(1.5F).sound(SoundType.WOOD)));
        registerBlock(block(ID_HOPS), () -> new Block(create(Material.WOOD, MaterialColor.GREEN).hardnessAndResistance(1.5F).sound(SoundType.WOOD)));
        registerBlock(block(ID_STRAWBERRY), () -> new Block(create(Material.WOOD, MaterialColor.RED_TERRACOTTA).hardnessAndResistance(1.5F).sound(SoundType.WOOD)));
        registerBlock(block(ID_TOMATO), () -> new Block(create(Material.WOOD, MaterialColor.RED).hardnessAndResistance(1.5F).sound(SoundType.WOOD)));

        registerBlock(block(ID_RICE), () -> new Block4Way(create(Material.WOOL, MaterialColor.WHITE_TERRACOTTA).hardnessAndResistance(0.5F).sound(SoundType.CLOTH)));

        registerBlock(block(ID_COFFEE), () -> new Block4Way(create(Material.WOOL, MaterialColor.RED_TERRACOTTA).hardnessAndResistance(0.5F).sound(SoundType.CLOTH)));
        registerBlock(block(ID_PEANUT), () -> new Block4Way(create(Material.WOOL, MaterialColor.BROWN_TERRACOTTA).hardnessAndResistance(0.5F).sound(SoundType.CLOTH)));
        registerBlock(block(ID_TEA), () -> new Block4Way(create(Material.WOOL, MaterialColor.GREEN_TERRACOTTA).hardnessAndResistance(0.5F).sound(SoundType.CLOTH)));
    }

    private static void registerMisc() {

        registerBlock(ID_PHYTOSOIL, () -> new SoilBlock(create(Material.EARTH).tickRandomly().hardnessAndResistance(0.8F).sound(SoundType.GROUND).lightValue(7)));
        registerBlock(ID_PHYTOSOIL_TILLED, () -> new TilledSoilBlock(create(Material.EARTH).tickRandomly().hardnessAndResistance(0.8F).sound(SoundType.GROUND).lightValue(7)));
    }

    private static void registerTileBlocks() {

        IntSupplier deviceAugs = () -> ThermalConfig.deviceAugments;
        Predicate<ItemStack> deviceValidator = (e) -> true;

        registerAugBlock(ID_DEVICE_SOIL_INFUSER, () -> new TileBlock4Way(create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.5F).lightValue(10), DeviceSoilInfuserTile::new), deviceAugs, deviceValidator);
    }

    private static void registerTileContainers() {

        CONTAINERS.register(ID_DEVICE_SOIL_INFUSER, () -> IForgeContainerType.create((windowId, inv, data) -> new DeviceSoilInfuserContainer(windowId, ProxyUtils.getClientWorld(), data.readBlockPos(), inv, ProxyUtils.getClientPlayer())));
    }

    private static void registerTileEntities() {

        TILE_ENTITIES.register(ID_DEVICE_SOIL_INFUSER, () -> TileEntityType.Builder.create(DeviceSoilInfuserTile::new, DEVICE_SOIL_INFUSER_BLOCK).build(null));
    }
    // endregion
}
