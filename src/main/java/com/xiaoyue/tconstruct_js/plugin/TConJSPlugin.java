package com.xiaoyue.tconstruct_js.plugin;

import com.xiaoyue.tconstruct_js.content.RecipeBuilder;
import com.xiaoyue.tconstruct_js.event.TConEventGroup;
import com.xiaoyue.tconstruct_js.utils.SimpleTCon;
import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.recipe.schema.RegisterRecipeSchemasEvent;
import dev.latvian.mods.kubejs.script.BindingsEvent;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.library.tools.helper.ToolDamageUtil;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

public class TConJSPlugin extends KubeJSPlugin {

    @Override
    public void registerRecipeSchemas(RegisterRecipeSchemasEvent event) {
        event.register(TConstruct.getResource("casting_table"), RecipeBuilder.CASTING_TABLE_RECIPE);
        event.register(TConstruct.getResource("casting_basin"), RecipeBuilder.CASTING_BASIN_RECIPE);
        event.register(TConstruct.getResource("table_duplication"), RecipeBuilder.TABLE_DUPLICATION);
        event.register(TConstruct.getResource("basin_duplication"), RecipeBuilder.BASIN_DUPLICATION);
        event.register(TConstruct.getResource("casting_table_potion"), RecipeBuilder.CASTING_TABLE_POTION);
        event.register(TConstruct.getResource("casting_basin_potion"), RecipeBuilder.CASTING_BASIN_POTION);
        event.register(TConstruct.getResource("table_filling"), RecipeBuilder.TABLE_FILLING);
        event.register(TConstruct.getResource("basin_filling"), RecipeBuilder.BASIN_FILLING);
        event.register(TConstruct.getResource("alloy"), RecipeBuilder.ALLOY_RECIPE);
        event.register(TConstruct.getResource("melting"), RecipeBuilder.MELTING_RECIPE);
        event.register(TConstruct.getResource("molding_table"), RecipeBuilder.MOLDING_TABLE_RECIPE);
        event.register(TConstruct.getResource("molding_basin"), RecipeBuilder.MOLDING_BASIN_RECIPE);
        event.register(TConstruct.getResource("melting_fuel"), RecipeBuilder.MELTING_FUEL);
        event.register(TConstruct.getResource("material"), RecipeBuilder.MATERIAL_BIND);
    }

    @Override
    public void registerEvents() {
        TConEventGroup.GROUP.register();
    }

    @Override
    public void registerBindings(BindingsEvent event) {
        event.add("SimpleTCon", SimpleTCon.class);
        event.add("TinkerToolStats", ToolStats.class);
        event.add("TinkerDamageHelper", ToolDamageUtil.class);
    }
}
