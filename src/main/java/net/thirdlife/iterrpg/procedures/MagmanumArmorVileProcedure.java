package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModItems;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.registries.Registries;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class MagmanumArmorVileProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double chance = 0;
		if (entity instanceof Player && ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == IterRpgModItems.MAGMANUM_ARMOR_BOOTS.get()
				|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == IterRpgModItems.MAGMANUM_ARMOR_LEGGINGS.get()
				|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == IterRpgModItems.MAGMANUM_ARMOR_CHESTPLATE.get()
				|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == IterRpgModItems.MAGMANUM_ARMOR_HELMET.get())) {
			chance = 0;
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == IterRpgModItems.MAGMANUM_ARMOR_BOOTS.get()) {
				chance = chance + 1;
			}
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == IterRpgModItems.MAGMANUM_ARMOR_LEGGINGS.get()) {
				chance = chance + 1;
			}
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == IterRpgModItems.MAGMANUM_ARMOR_CHESTPLATE.get()) {
				chance = chance + 1;
			}
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == IterRpgModItems.MAGMANUM_ARMOR_HELMET.get()) {
				chance = chance + 1;
			}
			if (chance >= Mth.nextInt(RandomSource.create(), 1, 4)) {
				sourceentity.setSecondsOnFire((int) (5 + chance * 2.5));
				sourceentity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.ON_FIRE), entity), (float) (chance * 1.25));
				if (world instanceof Level _level && !_level.isClientSide())
					_level.explode(null, (sourceentity.getX()), (sourceentity.getY() + 1), (sourceentity.getZ()), (float) 0.25, Level.ExplosionInteraction.NONE);
			}
		}
	}
}
