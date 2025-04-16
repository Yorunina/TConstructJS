package com.xiaoyue.tconstruct_js.content.modifier;

import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

import static com.xiaoyue.tconstruct_js.TConstructJS.MODID;

public class ModifierRegister {
    public static ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(MODID);
    public static final StaticModifier<DefaultAttrRangeModifier> DEFAULT_ATTR_RANGE_MODIFIER;

    public ModifierRegister() {
    }

    static {
        DEFAULT_ATTR_RANGE_MODIFIER = MODIFIERS.register("test", DefaultAttrRangeModifier::new);
    }

}
