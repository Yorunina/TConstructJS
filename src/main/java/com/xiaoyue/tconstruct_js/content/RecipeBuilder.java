package com.xiaoyue.tconstruct_js.content;

import dev.latvian.mods.kubejs.fluid.InputFluid;
import dev.latvian.mods.kubejs.fluid.OutputFluid;
import dev.latvian.mods.kubejs.item.InputItem;
import dev.latvian.mods.kubejs.item.OutputItem;
import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.BooleanComponent;
import dev.latvian.mods.kubejs.recipe.component.FluidComponents;
import dev.latvian.mods.kubejs.recipe.component.ItemComponents;
import dev.latvian.mods.kubejs.recipe.component.NumberComponent;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;

public interface RecipeBuilder {

    RecipeKey<OutputItem> RESULT = ItemComponents.OUTPUT.key("result");
    RecipeKey<InputItem> PATTERN = ItemComponents.INPUT.key("pattern");
    RecipeKey<InputItem> MATERIAL = ItemComponents.INPUT.key("material");
    RecipeKey<InputItem> INPUT = ItemComponents.INPUT.key("ingredient");
    RecipeKey<InputItem> BOTTLE = ItemComponents.INPUT.key("bottle");
    RecipeKey<InputItem> CONTAINER = ItemComponents.INPUT.key("container");
    RecipeKey<InputItem> CAST = ItemComponents.INPUT.key("cast");

    RecipeKey<Integer> DURATION = NumberComponent.INT.key("duration").optional(100);
    RecipeKey<Integer> FLUID_AMOUNT = NumberComponent.INT.key("fluid_amount").optional(100);
    RecipeKey<Double> TEMPERATURE = NumberComponent.DOUBLE.key("temperature").optional(100d);
    RecipeKey<Double> TIME = NumberComponent.DOUBLE.key("time").optional(100d);
    RecipeKey<Double> COOLING_TIME = NumberComponent.DOUBLE.key("cooling_time").optional(1.0);

    RecipeKey<Boolean> CAST_CONSUME = BooleanComponent.BOOLEAN.key("cast_consumed").optional(false);
    RecipeKey<Boolean> SWITCH_SLOTS = BooleanComponent.BOOLEAN.key("switch_slots").optional(false);
    RecipeKey<OutputFluid> FLUID_RESULT = FluidComponents.OUTPUT.key("result");
    RecipeKey<InputFluid> FLUID = FluidComponents.INPUT.key("fluid");
    RecipeKey<InputFluid[]> FLUID_INPUTS = FluidComponents.INPUT_ARRAY.key("inputs");

    RecipeSchema MOLDING_TABLE_RECIPE = new RecipeSchema(RESULT, PATTERN, MATERIAL);
    RecipeSchema MOLDING_BASIN_RECIPE = new RecipeSchema(RESULT, PATTERN, MATERIAL);
    RecipeSchema MELTING_RECIPE = new RecipeSchema(FLUID_RESULT, INPUT, TEMPERATURE, TIME);
    RecipeSchema CASTING_TABLE_RECIPE = new RecipeSchema(RESULT, FLUID, CAST, CAST_CONSUME, COOLING_TIME, SWITCH_SLOTS);
    RecipeSchema CASTING_BASIN_RECIPE = new RecipeSchema(RESULT, FLUID, CAST, CAST_CONSUME, COOLING_TIME, SWITCH_SLOTS);
    RecipeSchema TABLE_DUPLICATION = new RecipeSchema(CAST, FLUID, COOLING_TIME);
    RecipeSchema BASIN_DUPLICATION = new RecipeSchema(CAST, FLUID, COOLING_TIME);
    RecipeSchema CASTING_TABLE_POTION = new RecipeSchema(RESULT, BOTTLE, FLUID, COOLING_TIME);
    RecipeSchema CASTING_BASIN_POTION = new RecipeSchema(RESULT, BOTTLE, FLUID, COOLING_TIME);
    RecipeSchema TABLE_FILLING = new RecipeSchema(FLUID_AMOUNT, CONTAINER);
    RecipeSchema BASIN_FILLING = new RecipeSchema(FLUID_AMOUNT, CONTAINER);
    RecipeSchema ALLOY_RECIPE = new RecipeSchema(FLUID_RESULT, FLUID_INPUTS, TEMPERATURE);
    RecipeSchema MELTING_FUEL = new RecipeSchema(DURATION, FLUID, TEMPERATURE);

}
