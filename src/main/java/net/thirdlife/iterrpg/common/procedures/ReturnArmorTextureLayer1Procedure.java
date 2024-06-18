package net.thirdlife.iterrpg.common.procedures;

import net.minecraft.world.item.ItemStack;

public class ReturnArmorTextureLayer1Procedure {
	public static String execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getDouble("element") == 0) {
			return "iter_rpg:textures/models/armor/" + "forest_armor_layer_1.png";
		} else if (itemstack.getOrCreateTag().getDouble("element") == 1) {
			return "iter_rpg:textures/models/armor/" + "ocean_armor_layer_1.png";
		} else if (itemstack.getOrCreateTag().getDouble("element") == 2) {
			return "iter_rpg:textures/models/armor/" + "sky_armor_layer_1.png";
		} else if (itemstack.getOrCreateTag().getDouble("element") == 3) {
			return "iter_rpg:textures/models/armor/" + "hell_armor_layer_1.png";
		} else if (itemstack.getOrCreateTag().getDouble("element") == 4) {
			return "iter_rpg:textures/models/armor/" + "end_armor_layer_1.png";
		}
		return "iter_rpg:textures/models/armor/" + "forest_armor_layer_1.png";
	}
}
