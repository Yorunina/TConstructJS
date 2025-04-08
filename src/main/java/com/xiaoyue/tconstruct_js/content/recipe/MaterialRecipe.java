package com.xiaoyue.tconstruct_js.content.recipe;

import dev.latvian.mods.kubejs.item.InputItem;
import dev.latvian.mods.kubejs.item.OutputItem;
import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.ItemComponents;
import dev.latvian.mods.kubejs.recipe.component.NumberComponent;
import dev.latvian.mods.kubejs.recipe.component.StringComponent;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;

public interface MaterialRecipe {
    RecipeKey<InputItem> INPUT = ItemComponents.INPUT.key("ingredient");
    RecipeKey<String> MATERIAL_ID = StringComponent.ID.key("material");
    RecipeKey<OutputItem> LEFTOVER = ItemComponents.OUTPUT.key("leftover").optional(OutputItem.EMPTY);
    RecipeKey<Integer> MATERIAL_VALUE = NumberComponent.INT.key("value").optional(1);
    RecipeKey<Integer> MATERIAL_NEED = NumberComponent.INT.key("needed").optional(1);

    RecipeSchema MATERIAL_BIND = new RecipeSchema(MATERIAL_ID, INPUT, MATERIAL_VALUE, MATERIAL_NEED, LEFTOVER);
}
