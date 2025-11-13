package committee.nova.mods.avaritia_integration.module.tconstruct;

import committee.nova.mods.avaritia_integration.AvaritiaIntegration;
import net.minecraft.resources.ResourceLocation;
import slimeknights.tconstruct.library.modifiers.ModifierId;

public class AvaritiaModifierIds {
    public static final ModifierId RuleOver = id("rule_over");
    public static final ModifierId Eternity = id("eternity");
    private AvaritiaModifierIds() {}
    private static ModifierId id(String name) {
        return new ModifierId(new ResourceLocation(AvaritiaIntegration.MOD_ID, name));
    }
}
