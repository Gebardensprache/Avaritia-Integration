package committee.nova.mods.avaritia_integration.module.tconstruct;

import committee.nova.mods.avaritia_integration.module.ModMeta;
import committee.nova.mods.avaritia_integration.module.Module;
import committee.nova.mods.avaritia_integration.module.ModuleEntry;
import committee.nova.mods.avaritia_integration.module.tconstruct.registry.TinkerIntegrationItems;
import net.minecraftforge.eventbus.api.IEventBus;

@ModuleEntry(id = TConstructModule.MOD_ID, target = @ModMeta(TConstructModule.MOD_ID))
public final class TConstructModule implements Module {
    public static final String MOD_ID = "tconstruct";
    @Override
    public void init(IEventBus registryBus) {
        TinkerIntegrationItems.REGISTRY.register(registryBus);
    }
}
