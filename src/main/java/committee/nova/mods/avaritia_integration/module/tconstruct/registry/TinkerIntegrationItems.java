package committee.nova.mods.avaritia_integration.module.tconstruct.registry;

import committee.nova.mods.avaritia.init.registry.ModRarities;
import committee.nova.mods.avaritia_integration.AvaritiaIntegration;
import committee.nova.mods.avaritia_integration.module.tconstruct.item.HeavenArrowItem;
import committee.nova.mods.avaritia_integration.module.tconstruct.item.TraceArrowItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class TinkerIntegrationItems {
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(Registries.ITEM, AvaritiaIntegration.MOD_ID);
    public static final RegistryObject<ArrowItem> HeavenArrowItem = register("heaven_arrow", () -> new HeavenArrowItem(new Item.Properties().rarity(ModRarities.COSMIC)));
    public static final RegistryObject<ArrowItem> TraceArrowItem = register("trace_arrow", () -> new TraceArrowItem(new Item.Properties().rarity(ModRarities.COSMIC)));
    public static <T extends Item> RegistryObject<T> register(String id, Supplier<T> obj) {
        return REGISTRY.register(id, obj);
    }
}
