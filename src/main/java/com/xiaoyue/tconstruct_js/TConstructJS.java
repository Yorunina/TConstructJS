package com.xiaoyue.tconstruct_js;

import com.xiaoyue.tconstruct_js.content.modifier.ModifierRegister;
import com.xiaoyue.tconstruct_js.event.ModifierRegisterEventJS;
import com.xiaoyue.tconstruct_js.event.TConEventGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import slimeknights.tconstruct.library.modifiers.ModifierManager;

@Mod(TConstructJS.MODID)
public class TConstructJS {
    public static final String MODID = "tconstruct_js";

    public TConstructJS() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModifierRegister.MODIFIERS.register(eventBus);
        eventBus.addListener(this::initModifier);
    }

    public void initModifier(ModifierManager.ModifierRegistrationEvent event) {
        var eventJs = new ModifierRegisterEventJS();
        TConEventGroup.REGISTRY.post(eventJs);
        for (var entry : eventJs.MODIFIER_MAP.entrySet()) {
            event.registerStatic(entry.getKey(), entry.getValue());
        }
    }
}
