package com.xiaoyue.tconstruct_js.content.modifier;

import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.build.ToolStatsModifierHook;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.nbt.IToolContext;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

public class DefaultAttrRangeModifier extends NoLevelsModifier implements ToolStatsModifierHook {
    public DefaultAttrRangeModifier() {}
    public void addToolStats(IToolContext context, ModifierEntry entry, ModifierStatsBuilder builder) {
        float rate = Float.MAX_VALUE;
        ToolStats.DRAW_SPEED.multiply(builder, rate);
        ToolStats.MINING_SPEED.multiply(builder, rate);
        ToolStats.DURABILITY.multiply(builder, rate);
        ToolStats.ATTACK_SPEED.multiply(builder, rate);
        ToolStats.ATTACK_DAMAGE.multiply(builder, rate);
        ToolStats.VELOCITY.multiply(builder, rate);
        ToolStats.ACCURACY.multiply(builder, rate);
        ToolStats.PROJECTILE_DAMAGE.multiply(builder, rate);
        ToolStats.ARMOR.multiply(builder, rate);
        ToolStats.ARMOR_TOUGHNESS.multiply(builder, rate);
    }

    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.TOOL_STATS);
    }
}
