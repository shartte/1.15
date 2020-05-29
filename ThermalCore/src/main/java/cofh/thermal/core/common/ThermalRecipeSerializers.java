package cofh.thermal.core.common;

import cofh.thermal.core.util.managers.dynamo.*;
import cofh.thermal.core.util.managers.machine.*;
import cofh.thermal.core.util.recipes.ThermalCatalystSerializer;
import cofh.thermal.core.util.recipes.ThermalFuelSerializer;
import cofh.thermal.core.util.recipes.ThermalRecipeSerializer;
import cofh.thermal.core.util.recipes.dynamo.*;
import cofh.thermal.core.util.recipes.machine.*;

import static cofh.thermal.core.ThermalCore.RECIPE_SERIALIZERS;

public class ThermalRecipeSerializers {

    private ThermalRecipeSerializers() {

    }

    public static void register() {

        RECIPE_SERIALIZERS.register(ThermalRecipeTypes.ID_RECIPE_FURNACE, () -> new ThermalRecipeSerializer<>(FurnaceRecipe::new, FurnaceRecipeManager.instance().getDefaultEnergy()));
        RECIPE_SERIALIZERS.register(ThermalRecipeTypes.ID_RECIPE_SAWMILL, () -> new ThermalRecipeSerializer<>(SawmillRecipe::new, SawmillRecipeManager.instance().getDefaultEnergy()));
        RECIPE_SERIALIZERS.register(ThermalRecipeTypes.ID_RECIPE_PULVERIZER, () -> new ThermalRecipeSerializer<>(PulverizerRecipe::new, PulverizerRecipeManager.instance().getDefaultEnergy()));
        RECIPE_SERIALIZERS.register(ThermalRecipeTypes.ID_RECIPE_INSOLATOR, () -> new InsolatorRecipeSerializer<>(InsolatorRecipe::new, InsolatorRecipeManager.instance().getDefaultEnergy(), InsolatorRecipeManager.instance().getDefaultWater()));
        RECIPE_SERIALIZERS.register(ThermalRecipeTypes.ID_RECIPE_CENTRIFUGE, () -> new ThermalRecipeSerializer<>(CentrifugeRecipe::new, CentrifugeRecipeManager.instance().getDefaultEnergy()));
        RECIPE_SERIALIZERS.register(ThermalRecipeTypes.ID_RECIPE_PRESS, () -> new ThermalRecipeSerializer<>(PressRecipe::new, PressRecipeManager.instance().getDefaultEnergy()));
        RECIPE_SERIALIZERS.register(ThermalRecipeTypes.ID_RECIPE_CRUCIBLE, () -> new ThermalRecipeSerializer<>(CrucibleRecipe::new, CrucibleRecipeManager.instance().getDefaultEnergy()));
        RECIPE_SERIALIZERS.register(ThermalRecipeTypes.ID_RECIPE_CHILLER, () -> new ThermalRecipeSerializer<>(ChillerRecipe::new, ChillerRecipeManager.instance().getDefaultEnergy()));
        RECIPE_SERIALIZERS.register(ThermalRecipeTypes.ID_RECIPE_REFINERY, () -> new ThermalRecipeSerializer<>(RefineryRecipe::new, RefineryRecipeManager.instance().getDefaultEnergy()));
        RECIPE_SERIALIZERS.register(ThermalRecipeTypes.ID_RECIPE_BREWER, () -> new ThermalRecipeSerializer<>(BrewerRecipe::new, BrewerRecipeManager.instance().getDefaultEnergy()));
        RECIPE_SERIALIZERS.register(ThermalRecipeTypes.ID_RECIPE_BOTTLER, () -> new ThermalRecipeSerializer<>(BottlerRecipe::new, BottlerRecipeManager.instance().getDefaultEnergy()));

        RECIPE_SERIALIZERS.register(ThermalRecipeTypes.ID_CATALYST_PULVERIZER, () -> new ThermalCatalystSerializer<>(PulverizerCatalyst::new));
        RECIPE_SERIALIZERS.register(ThermalRecipeTypes.ID_CATALYST_INSOLATOR, () -> new ThermalCatalystSerializer<>(InsolatorCatalyst::new));

        RECIPE_SERIALIZERS.register(ThermalRecipeTypes.ID_FUEL_STIRLING, () -> new ThermalFuelSerializer<>(StirlingFuel::new, StirlingFuelManager.instance().getDefaultEnergy()));
        RECIPE_SERIALIZERS.register(ThermalRecipeTypes.ID_FUEL_COMPRESSION, () -> new ThermalFuelSerializer<>(CompressionFuel::new, CompressionFuelManager.instance().getDefaultEnergy()));
        RECIPE_SERIALIZERS.register(ThermalRecipeTypes.ID_FUEL_MAGMATIC, () -> new ThermalFuelSerializer<>(MagmaticFuel::new, MagmaticFuelManager.instance().getDefaultEnergy()));
        RECIPE_SERIALIZERS.register(ThermalRecipeTypes.ID_FUEL_NUMISMATIC, () -> new ThermalFuelSerializer<>(NumismaticFuel::new, NumismaticFuelManager.instance().getDefaultEnergy()));
        RECIPE_SERIALIZERS.register(ThermalRecipeTypes.ID_FUEL_LAPIDARY, () -> new ThermalFuelSerializer<>(LapidaryFuel::new, LapidaryFuelManager.instance().getDefaultEnergy()));
    }

}