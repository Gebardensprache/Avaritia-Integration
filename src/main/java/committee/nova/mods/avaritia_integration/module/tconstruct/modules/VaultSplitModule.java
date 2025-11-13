package committee.nova.mods.avaritia_integration.module.tconstruct.modules;

import com.creeping_creeper.tinkers_thinking.common.register.ModToolItems;
import committee.nova.mods.avaritia.common.entity.arrow.TraceArrowEntity;
import committee.nova.mods.avaritia_integration.module.tconstruct.registry.TinkerIntegrationItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import slimeknights.mantle.data.loadable.record.RecordLoadable;
import slimeknights.mantle.data.loadable.record.SingletonLoader;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.ranged.BowAmmoModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.ranged.ProjectileLaunchModifierHook;
import slimeknights.tconstruct.library.modifiers.modules.ModifierModule;
import slimeknights.tconstruct.library.module.HookProvider;
import slimeknights.tconstruct.library.module.ModuleHook;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Predicate;

public enum VaultSplitModule implements ModifierModule, BowAmmoModifierHook, ProjectileLaunchModifierHook {
    INSTANCE;
    private static final List<ModuleHook<?>> DEFAULT_HOOKS = HookProvider.<VaultSplitModule>defaultHooks(ModifierHooks.BOW_AMMO);
    public static final RecordLoadable<VaultSplitModule> LOADER = new SingletonLoader<>(INSTANCE);

    public @NotNull RecordLoadable<VaultSplitModule> getLoader() {
        return LOADER;
    }

    public @NotNull List<ModuleHook<?>> getDefaultHooks() {
        return DEFAULT_HOOKS;
    }
    @Override
    public ItemStack findAmmo(IToolStackView tool, ModifierEntry modifier, LivingEntity shooter, ItemStack standardAmmo, Predicate<ItemStack> ammoPredicate) {
        if (standardAmmo.isEmpty()) {
            return new ItemStack(shooter.isShiftKeyDown() ? ModToolItems.TraceArrow.get() : ModToolItems.HeavenArrow.get()).copyWithCount(64);
            //return new ItemStack(shooter.isShiftKeyDown() ? TinkerIntegrationItems.TraceArrowItem.get() : TinkerIntegrationItems.HeavenArrowItem.get()).copyWithCount(64);
        }
        return ItemStack.EMPTY;
    }

    @Override
    public void onProjectileLaunch(IToolStackView tool, ModifierEntry modifier, LivingEntity shooter, Projectile projectile, @org.jetbrains.annotations.Nullable AbstractArrow arrow, ModDataNBT persistentData, boolean primary) {
        if (arrow instanceof TraceArrowEntity) {
            arrow.pickup = AbstractArrow.Pickup.DISALLOWED;
        }
    }
}
