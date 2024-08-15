package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModItems;
import net.thirdlife.iterrpg.init.IterRpgModAttributes;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.ItemAttributeModifierEvent;
import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;

import java.util.UUID;

@Mod.EventBusSubscriber
public class AttributeCalculateProcedure {
	@SubscribeEvent
	public static void addAttributeModifier(ItemAttributeModifierEvent event) {
		execute(event, event.getItemStack());
	}

	public static void execute(ItemStack itemstack) {
		execute(null, itemstack);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack) {
		double damage = 0;
		String spellpowerWand = "";
		String spellcooldownWand = "";
		String spellmanacostWand = "";
		String manaregenHead = "";
		String manaregenChest = "";
		String manaregenLegs = "";
		String manaregenFeet = "";
		String manacapacityHead = "";
		String manacapacityChest = "";
		String manacapacityLegs = "";
		String manacapacityFeet = "";
		String spellpowerHead = "";
		String spellpowerChest = "";
		String spellpowerLegs = "";
		String spellpowerFeet = "";
		String spellcooldownHead = "";
		String spellcooldownChest = "";
		String spellcooldownLegs = "";
		String spellcooldownFeet = "";
		String spellmanacostHead = "";
		String spellmanacostChest = "";
		String spellmanacostLegs = "";
		String spellmanacostFeet = "";
		spellpowerWand = "f1e411bf-85d7-3fa1-84ca-89a2387579f6";
		spellcooldownWand = "76d8ee49-b607-34ac-bce4-0e78763278b8";
		spellmanacostWand = "755fe73d-3ba9-3a70-abc4-54a29fa80cb3";
		manaregenHead = "29d4cc97-5744-3afd-8758-a10b62f2559b";
		manaregenChest = "e93a628c-482a-37dd-b908-9b56383432c7";
		manaregenLegs = "8ae5c3d7-5701-33f7-a93b-4f751f60a7d4";
		manaregenFeet = "ae6247ea-e987-387d-ac06-f2df183b648e";
		manacapacityHead = "12dee218-0900-3cc1-81f8-1cdd7df6167f";
		manacapacityChest = "b199749b-d3ce-3574-9752-1f5af4b896e8";
		manacapacityLegs = "c51439af-02c5-35e7-84e2-0ef433c3b734";
		manacapacityFeet = "4e920b03-cbdf-37db-98f4-379582ef5f62";
		spellpowerHead = "e2702d35-0f9a-3448-a498-ce89c5ba3a66";
		spellpowerChest = "fbcbc4f7-f0ad-3239-b649-e5f866d19246";
		spellpowerLegs = "0ee81cd4-7f38-3c27-8895-dd462e4d9eb1";
		spellpowerFeet = "1b1c36a6-75d1-3374-af97-20ea7c561038";
		spellcooldownHead = "b59a49c9-2bcf-3453-bea1-d6fd7ea834e5";
		spellcooldownChest = "e69a0820-28ed-38d8-993b-1571614a8762";
		spellcooldownLegs = "d3d65d1e-88ef-342f-ba45-c809de2e2448";
		spellcooldownFeet = "0fc82b81-b01b-3d46-9978-4bba40156d4a";
		spellmanacostHead = "74816c47-f9e7-3e1b-9d46-18da8f566a1e";
		spellmanacostChest = "87d705a8-bc6d-370a-8c1d-2b00abbe6d98";
		spellmanacostLegs = "5041f650-0ae2-373f-802f-733513d51b78";
		spellmanacostFeet = "6219dc93-32b7-316e-82af-d07526a91ccb";
		if (itemstack.is(ItemTags.create(new ResourceLocation("forge:spear")))) {
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.MAINHAND) {
				_event.addModifier(ForgeMod.ENTITY_REACH.get(), (new AttributeModifier(UUID.fromString("25dbb59e-e4d5-3e0b-9f78-0a2a506ce0d7"), "Attack range", 1.25, AttributeModifier.Operation.ADDITION)));
			}
		}
		if (itemstack.is(ItemTags.create(new ResourceLocation("forge:flail")))) {
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.MAINHAND) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK, (new AttributeModifier(UUID.fromString("6ca9e4a7-32eb-339d-a5ec-d22512529e17"), "Attack knockback", 1, AttributeModifier.Operation.ADDITION)));
			}
		}
		if (itemstack.getItem() == IterRpgModItems.AMETHYST_WAND.get()) {
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.MAINHAND) {
				_event.addModifier(IterRpgModAttributes.SPELLCASTINGPOWER.get(), (new AttributeModifier(UUID.fromString(spellpowerWand), "Spellcasting power", 1, AttributeModifier.Operation.ADDITION)));
			}
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.MAINHAND) {
				_event.addModifier(IterRpgModAttributes.SPELLCOOLDOWN.get(), (new AttributeModifier(UUID.fromString(spellcooldownWand), "Spell cooldown", 1, AttributeModifier.Operation.ADDITION)));
			}
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.MAINHAND) {
				_event.addModifier(IterRpgModAttributes.MANACONSUMPTION.get(), (new AttributeModifier(UUID.fromString(spellmanacostWand), "Mana consumption", 1, AttributeModifier.Operation.ADDITION)));
			}
		}
		if (itemstack.getItem() == IterRpgModItems.PEARL_WAND.get()) {
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.MAINHAND) {
				_event.addModifier(IterRpgModAttributes.SPELLCASTINGPOWER.get(), (new AttributeModifier(UUID.fromString(spellpowerWand), "Spellcasting power", 1.1, AttributeModifier.Operation.ADDITION)));
			}
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.MAINHAND) {
				_event.addModifier(IterRpgModAttributes.SPELLCOOLDOWN.get(), (new AttributeModifier(UUID.fromString(spellcooldownWand), "Spell cooldown", 0.95, AttributeModifier.Operation.ADDITION)));
			}
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.MAINHAND) {
				_event.addModifier(IterRpgModAttributes.MANACONSUMPTION.get(), (new AttributeModifier(UUID.fromString(spellmanacostWand), "Mana consumption", 1, AttributeModifier.Operation.ADDITION)));
			}
		}
		if (itemstack.getItem() == IterRpgModItems.RAGGED_HELMET.get()) {
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.HEAD) {
				_event.addModifier(IterRpgModAttributes.BASEMANACAPACITY.get(), (new AttributeModifier(UUID.fromString(manacapacityHead), "Mana capacity", 10, AttributeModifier.Operation.ADDITION)));
			}
		} else if (itemstack.getItem() == IterRpgModItems.RAGGED_CHESTPLATE.get()) {
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.CHEST) {
				_event.addModifier(IterRpgModAttributes.SPELLCOOLDOWN.get(), (new AttributeModifier(UUID.fromString(spellcooldownChest), "Spell cooldown", (-0.1), AttributeModifier.Operation.MULTIPLY_TOTAL)));
			}
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.CHEST) {
				_event.addModifier(IterRpgModAttributes.BASEMANAREGENERATION.get(), (new AttributeModifier(UUID.fromString(manaregenChest), "Mana regeneration", 0.15, AttributeModifier.Operation.MULTIPLY_TOTAL)));
			}
		} else if (itemstack.getItem() == IterRpgModItems.RAGGED_LEGGINGS.get()) {
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.LEGS) {
				_event.addModifier(IterRpgModAttributes.SPELLCASTINGPOWER.get(), (new AttributeModifier(UUID.fromString(spellpowerLegs), "Spellcasting power", 0.05, AttributeModifier.Operation.MULTIPLY_TOTAL)));
			}
		} else if (itemstack.getItem() == IterRpgModItems.RAGGED_BOOTS.get()) {
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.FEET) {
				_event.addModifier(IterRpgModAttributes.MANACONSUMPTION.get(), (new AttributeModifier(UUID.fromString(spellmanacostFeet), "Mana consumption", (-0.1), AttributeModifier.Operation.MULTIPLY_TOTAL)));
			}
		}
		if (itemstack.getItem() == IterRpgModItems.AMETRINE_HELMET.get()) {
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.HEAD) {
				_event.addModifier(IterRpgModAttributes.BASEMANACAPACITY.get(), (new AttributeModifier(UUID.fromString(manacapacityHead), "Mana capacity - head", 2.5, AttributeModifier.Operation.ADDITION)));
			}
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.HEAD) {
				_event.addModifier(IterRpgModAttributes.BASEMANAREGENERATION.get(), (new AttributeModifier(UUID.fromString(manaregenHead), "Mana regeneration - head", 0.025, AttributeModifier.Operation.MULTIPLY_TOTAL)));
			}
		} else if (itemstack.getItem() == IterRpgModItems.AMETRINE_CHESTPLATE.get()) {
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.CHEST) {
				_event.addModifier(IterRpgModAttributes.BASEMANACAPACITY.get(), (new AttributeModifier(UUID.fromString(manacapacityChest), "Mana capacity", 2.5, AttributeModifier.Operation.ADDITION)));
			}
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.CHEST) {
				_event.addModifier(IterRpgModAttributes.BASEMANAREGENERATION.get(), (new AttributeModifier(UUID.fromString(manaregenChest), "Mana regeneration", 0.025, AttributeModifier.Operation.MULTIPLY_TOTAL)));
			}
		} else if (itemstack.getItem() == IterRpgModItems.AMETRINE_LEGGINGS.get()) {
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.LEGS) {
				_event.addModifier(IterRpgModAttributes.BASEMANACAPACITY.get(), (new AttributeModifier(UUID.fromString(manacapacityLegs), "Mana capacity", 2.5, AttributeModifier.Operation.ADDITION)));
			}
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.LEGS) {
				_event.addModifier(IterRpgModAttributes.BASEMANAREGENERATION.get(), (new AttributeModifier(UUID.fromString(manaregenLegs), "Mana regeneration", 0.025, AttributeModifier.Operation.MULTIPLY_TOTAL)));
			}
		} else if (itemstack.getItem() == IterRpgModItems.AMETRINE_BOOTS.get()) {
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.FEET) {
				_event.addModifier(IterRpgModAttributes.BASEMANACAPACITY.get(), (new AttributeModifier(UUID.fromString(manacapacityFeet), "Mana capacity", 2.5, AttributeModifier.Operation.ADDITION)));
			}
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.FEET) {
				_event.addModifier(IterRpgModAttributes.BASEMANAREGENERATION.get(), (new AttributeModifier(UUID.fromString(manaregenFeet), "Mana regeneration", 0.025, AttributeModifier.Operation.MULTIPLY_TOTAL)));
			}
		}
	}
}
