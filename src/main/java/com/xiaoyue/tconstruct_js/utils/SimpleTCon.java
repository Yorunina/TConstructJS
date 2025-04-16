package com.xiaoyue.tconstruct_js.utils;

import com.xiaoyue.tconstruct_js.content.modifier.ModifierBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.util.NonNullConsumer;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierId;
import slimeknights.tconstruct.library.modifiers.ModifierManager;
import slimeknights.tconstruct.library.tools.capability.TinkerDataCapability;
import slimeknights.tconstruct.library.tools.helper.ModifierUtil;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

import java.util.List;
import java.util.stream.Stream;

public class SimpleTCon {

    public static ModifierBuilder newBuilder() {
        return new ModifierBuilder();
    }

    public static ResourceLocation getLocationKey(String key) {
        return new ResourceLocation(key);
    }

    public static Modifier getModifier(String id) {
        return ModifierManager.getValue(new ModifierId(id));
    }

    public static ModifierId getModifierId(String id) {
        return new ModifierId(id);
    }

    public static boolean hasModifier(ItemStack stack, String id) {
        return ModifierUtil.getModifierLevel(stack, new ModifierId(id)) > 0;
    }

    public static int getModifierLevel(ItemStack stack, String id) {
        return ModifierUtil.getModifierLevel(stack, new ModifierId(id));
    }

    public static ModifierEntry getModifierEntry(Modifier modifier, int level) {
        return new ModifierEntry(modifier, level);
    }

    public static ModifierEntry getModifierEntry(String id, int level) {
        return new ModifierEntry(new ModifierId(id), level);
    }

    public static Stream<Modifier> getModifiersFromGame() {
        return ModifierManager.INSTANCE.getAllValues();
    }

    public static List<Modifier> getModifiersFromTag(String tag) {
        return ModifierManager.getTagValues(TagKey.create(ModifierManager.REGISTRY_KEY, new ResourceLocation(tag)));
    }

    @Nullable
    public static ToolStack getToolInSlot(LivingEntity entity, EquipmentSlot slot) {
        return Modifier.getHeldTool(entity, slot);
    }

    public static ToolStack castToolStack(IToolStackView tool) {
        return ((ToolStack) tool);
    }

    public static int getMaterialsInTool(IToolStackView tool, String materialId) {
        return (int) tool.getMaterials().getList().stream().filter(variant -> variant.get().getIdentifier().toString().equals(materialId)).count();
    }

    public static boolean hasMaterialInTool(IToolStackView tool, String materialId) {
        return getMaterialsInTool(tool, materialId) > 0;
    }

    @Nullable
    public static ToolStack getToolStack(ItemStack stack) {
        if (!stack.isEmpty() && stack.is(TinkerTags.Items.MODIFIABLE)) {
            return ToolStack.from(stack).isBroken() ? null : ToolStack.from(stack);
        }
        return null;
    }

    public static void getTinkerData(Entity entity, NonNullConsumer<TinkerDataCapability.Holder> consumer) {
        entity.getCapability(TinkerDataCapability.CAPABILITY).ifPresent(consumer);
    }
}
