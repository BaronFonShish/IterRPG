package net.thirdlife.iterrpg.procedures;

import top.theillusivec4.curios.api.CuriosApi;

import net.thirdlife.iterrpg.init.IterRpgModItems;
import net.thirdlife.iterrpg.init.IterRpgModAttributes;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import java.util.UUID;

public class RingCalculateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double damage = 0;
		double numberiter = 0;
		double numberiter2 = 0;
		String ringManaRegen = "";
		String ringManaCap = "";
		String ringDefense = "";
		String ringMeleeDamage = "";
		String ringArmorToughness = "";
		String ringMiningSpeed = "";
		String ringMaxHealth = "";
		ringManaRegen = "14dace5a-ce4a-3776-a261-2ff4c126785a";
		ringManaCap = "7a94f308-3d8d-305e-a9a8-dbec25c6a7ab";
		ringDefense = "30fb5b77-f35c-36d2-b930-521a7ae5d4c0";
		ringMeleeDamage = "64bcfe82-28e2-3986-9721-32fa819e3e63";
		ringArmorToughness = "14b4da7f-2f87-3434-9d79-2b5c78802c18";
		ringMiningSpeed = "4272c4f7-4182-3b10-825b-d75b24c787fd";
		ringMaxHealth = "53b2fd9a-6a89-3ce3-bb08-0175a3780440";
		numberiter = 0;
		if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(IterRpgModItems.NETHERITE_RING_AMETHYST.get(), lv).isPresent() : false) {
			numberiter = 0.05;
		} else if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(IterRpgModItems.GOLD_RING_AMETHYST.get(), lv).isPresent() : false) {
			numberiter = 0.0375;
		} else if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(IterRpgModItems.IRON_RING_AMETHYST.get(), lv).isPresent() : false) {
			numberiter = 0.025;
		}
		((LivingEntity) entity).getAttribute(IterRpgModAttributes.BASEMANAREGENERATION.get()).removeModifier((new AttributeModifier(UUID.fromString(ringManaRegen), "Mana regeneration", numberiter, AttributeModifier.Operation.ADDITION)));
		if (!(((LivingEntity) entity).getAttribute(IterRpgModAttributes.BASEMANAREGENERATION.get()).hasModifier((new AttributeModifier(UUID.fromString(ringManaRegen), "Mana regeneration", numberiter, AttributeModifier.Operation.ADDITION)))))
			((LivingEntity) entity).getAttribute(IterRpgModAttributes.BASEMANAREGENERATION.get()).addTransientModifier((new AttributeModifier(UUID.fromString(ringManaRegen), "Mana regeneration", numberiter, AttributeModifier.Operation.ADDITION)));
		numberiter = 0;
		if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(IterRpgModItems.NETHERITE_RING_ABYSSQUARTZ.get(), lv).isPresent() : false) {
			numberiter = 50;
		} else if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(IterRpgModItems.GOLD_RING_ABYSSQUARTZ.get(), lv).isPresent() : false) {
			numberiter = 35;
		} else if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(IterRpgModItems.IRON_RING_ABYSSQUARTZ.get(), lv).isPresent() : false) {
			numberiter = 20;
		}
		((LivingEntity) entity).getAttribute(IterRpgModAttributes.BASEMANACAPACITY.get()).removeModifier((new AttributeModifier(UUID.fromString(ringManaCap), "Mana capacity", numberiter, AttributeModifier.Operation.ADDITION)));
		if (!(((LivingEntity) entity).getAttribute(IterRpgModAttributes.BASEMANACAPACITY.get()).hasModifier((new AttributeModifier(UUID.fromString(ringManaCap), "Mana capacity", numberiter, AttributeModifier.Operation.ADDITION)))))
			((LivingEntity) entity).getAttribute(IterRpgModAttributes.BASEMANACAPACITY.get()).addTransientModifier((new AttributeModifier(UUID.fromString(ringManaCap), "Mana capacity", numberiter, AttributeModifier.Operation.ADDITION)));
		numberiter = 0;
		numberiter2 = 0;
		if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(IterRpgModItems.NETHERITE_RING_DIAMOND.get(), lv).isPresent() : false) {
			numberiter = 4;
			numberiter2 = 2;
		} else if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(IterRpgModItems.GOLD_RING_DIAMOND.get(), lv).isPresent() : false) {
			numberiter = 4;
		} else if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(IterRpgModItems.IRON_RING_DIAMOND.get(), lv).isPresent() : false) {
			numberiter = 2;
		}
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).removeModifier((new AttributeModifier(UUID.fromString(ringDefense), "Armor", numberiter, AttributeModifier.Operation.ADDITION)));
		if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).hasModifier((new AttributeModifier(UUID.fromString(ringDefense), "Armor", numberiter, AttributeModifier.Operation.ADDITION)))))
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).addTransientModifier((new AttributeModifier(UUID.fromString(ringDefense), "Armor", numberiter, AttributeModifier.Operation.ADDITION)));
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS)
				.removeModifier((new AttributeModifier(UUID.fromString(ringArmorToughness), "Armor toughness", numberiter2, AttributeModifier.Operation.ADDITION)));
		if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS)
				.hasModifier((new AttributeModifier(UUID.fromString(ringArmorToughness), "Armor toughness", numberiter2, AttributeModifier.Operation.ADDITION)))))
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS)
					.addTransientModifier((new AttributeModifier(UUID.fromString(ringArmorToughness), "Armor toughness", numberiter2, AttributeModifier.Operation.ADDITION)));
		numberiter = 0;
		if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(IterRpgModItems.NETHERITE_RING_MAGMANUM.get(), lv).isPresent() : false) {
			numberiter = 0.1;
		} else if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(IterRpgModItems.GOLD_RING_MAGMANUM.get(), lv).isPresent() : false) {
			numberiter = 0.075;
		} else if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(IterRpgModItems.IRON_RING_MAGMANUM.get(), lv).isPresent() : false) {
			numberiter = 0.05;
		}
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
				.removeModifier((new AttributeModifier(UUID.fromString(ringMeleeDamage), "Attack damage", numberiter, AttributeModifier.Operation.MULTIPLY_TOTAL)));
		if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
				.hasModifier((new AttributeModifier(UUID.fromString(ringMeleeDamage), "Attack damage", numberiter, AttributeModifier.Operation.MULTIPLY_TOTAL)))))
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
					.addTransientModifier((new AttributeModifier(UUID.fromString(ringMeleeDamage), "Attack damage", numberiter, AttributeModifier.Operation.MULTIPLY_TOTAL)));
		numberiter = 0;
		if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(IterRpgModItems.NETHERITE_RING_EMERALD.get(), lv).isPresent() : false) {
			numberiter = 0.1;
		} else if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(IterRpgModItems.GOLD_RING_EMERALD.get(), lv).isPresent() : false) {
			numberiter = 0.075;
		} else if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(IterRpgModItems.IRON_RING_EMERALD.get(), lv).isPresent() : false) {
			numberiter = 0.05;
		}
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED)
				.removeModifier((new AttributeModifier(UUID.fromString(ringMiningSpeed), "Attack speed", numberiter, AttributeModifier.Operation.MULTIPLY_TOTAL)));
		if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED)
				.hasModifier((new AttributeModifier(UUID.fromString(ringMiningSpeed), "Attack speed", numberiter, AttributeModifier.Operation.MULTIPLY_TOTAL)))))
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED)
					.addTransientModifier((new AttributeModifier(UUID.fromString(ringMiningSpeed), "Attack speed", numberiter, AttributeModifier.Operation.MULTIPLY_TOTAL)));
		numberiter = 0;
		if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(IterRpgModItems.NETHERITE_RING_SANGUARNET.get(), lv).isPresent() : false) {
			numberiter = 4;
		} else if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(IterRpgModItems.GOLD_RING_SANGUARNET.get(), lv).isPresent() : false) {
			numberiter = 3;
		} else if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(IterRpgModItems.IRON_RING_SANGUARNET.get(), lv).isPresent() : false) {
			numberiter = 2;
		}
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).removeModifier((new AttributeModifier(UUID.fromString(ringMaxHealth), "Max health", numberiter, AttributeModifier.Operation.ADDITION)));
		if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).hasModifier((new AttributeModifier(UUID.fromString(ringMaxHealth), "Max health", numberiter, AttributeModifier.Operation.ADDITION)))))
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
					.addTransientModifier((new AttributeModifier(UUID.fromString(ringMaxHealth), "Max health", numberiter, AttributeModifier.Operation.ADDITION)));
	}
}
