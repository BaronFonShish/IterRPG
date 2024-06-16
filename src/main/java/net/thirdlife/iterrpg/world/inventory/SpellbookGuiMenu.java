
package net.thirdlife.iterrpg.world.inventory;

import net.thirdlife.iterrpg.procedures.SpellbookScrollConditionProcedure;
import net.thirdlife.iterrpg.init.IterRpgModMenus;

import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

public class SpellbookGuiMenu extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>> {
	public final static HashMap<String, Object> guistate = new HashMap<>();
	public final Level world;
	public final Player entity;
	public int x, y, z;
	private ContainerLevelAccess access = ContainerLevelAccess.NULL;
	private IItemHandler internal;
	private final Map<Integer, Slot> customSlots = new HashMap<>();
	private boolean bound = false;
	private Supplier<Boolean> boundItemMatcher = null;
	private Entity boundEntity = null;
	private BlockEntity boundBlockEntity = null;

	public SpellbookGuiMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
		super(IterRpgModMenus.SPELLBOOK_GUI.get(), id);
		this.entity = inv.player;
		this.world = inv.player.level();
		this.internal = new ItemStackHandler(55);
		BlockPos pos = null;
		if (extraData != null) {
			pos = extraData.readBlockPos();
			this.x = pos.getX();
			this.y = pos.getY();
			this.z = pos.getZ();
			access = ContainerLevelAccess.create(world, pos);
		}
		if (pos != null) {
			if (extraData.readableBytes() == 1) { // bound to item
				byte hand = extraData.readByte();
				ItemStack itemstack = hand == 0 ? this.entity.getMainHandItem() : this.entity.getOffhandItem();
				this.boundItemMatcher = () -> itemstack == (hand == 0 ? this.entity.getMainHandItem() : this.entity.getOffhandItem());
				itemstack.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
					this.internal = capability;
					this.bound = true;
				});
			} else if (extraData.readableBytes() > 1) { // bound to entity
				extraData.readByte(); // drop padding
				boundEntity = world.getEntity(extraData.readVarInt());
				if (boundEntity != null)
					boundEntity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
						this.internal = capability;
						this.bound = true;
					});
			} else { // might be bound to block
				boundBlockEntity = this.world.getBlockEntity(pos);
				if (boundBlockEntity != null)
					boundBlockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
						this.internal = capability;
						this.bound = true;
					});
			}
		}
		this.customSlots.put(1, this.addSlot(new SlotItemHandler(internal, 1, 45, 127) {
			private final int slot = 1;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(2, this.addSlot(new SlotItemHandler(internal, 2, 79, 116) {
			private final int slot = 2;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(3, this.addSlot(new SlotItemHandler(internal, 3, 113, 124) {
			private final int slot = 3;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(4, this.addSlot(new SlotItemHandler(internal, 4, 179, 124) {
			private final int slot = 4;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(5, this.addSlot(new SlotItemHandler(internal, 5, 213, 116) {
			private final int slot = 5;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(6, this.addSlot(new SlotItemHandler(internal, 6, 247, 127) {
			private final int slot = 6;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(7, this.addSlot(new SlotItemHandler(internal, 7, 34, 30) {
			private final int slot = 7;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(8, this.addSlot(new SlotItemHandler(internal, 8, 52, 30) {
			private final int slot = 8;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(9, this.addSlot(new SlotItemHandler(internal, 9, 70, 29) {
			private final int slot = 9;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(10, this.addSlot(new SlotItemHandler(internal, 10, 88, 28) {
			private final int slot = 10;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(11, this.addSlot(new SlotItemHandler(internal, 11, 106, 27) {
			private final int slot = 11;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(12, this.addSlot(new SlotItemHandler(internal, 12, 124, 26) {
			private final int slot = 12;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(13, this.addSlot(new SlotItemHandler(internal, 13, 168, 26) {
			private final int slot = 13;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(14, this.addSlot(new SlotItemHandler(internal, 14, 186, 27) {
			private final int slot = 14;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(15, this.addSlot(new SlotItemHandler(internal, 15, 204, 28) {
			private final int slot = 15;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(16, this.addSlot(new SlotItemHandler(internal, 16, 222, 29) {
			private final int slot = 16;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(17, this.addSlot(new SlotItemHandler(internal, 17, 240, 30) {
			private final int slot = 17;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(18, this.addSlot(new SlotItemHandler(internal, 18, 258, 30) {
			private final int slot = 18;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(19, this.addSlot(new SlotItemHandler(internal, 19, 34, 48) {
			private final int slot = 19;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(20, this.addSlot(new SlotItemHandler(internal, 20, 52, 48) {
			private final int slot = 20;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(21, this.addSlot(new SlotItemHandler(internal, 21, 70, 47) {
			private final int slot = 21;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(22, this.addSlot(new SlotItemHandler(internal, 22, 88, 46) {
			private final int slot = 22;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(23, this.addSlot(new SlotItemHandler(internal, 23, 106, 45) {
			private final int slot = 23;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(24, this.addSlot(new SlotItemHandler(internal, 24, 124, 44) {
			private final int slot = 24;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(25, this.addSlot(new SlotItemHandler(internal, 25, 168, 44) {
			private final int slot = 25;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(26, this.addSlot(new SlotItemHandler(internal, 26, 186, 45) {
			private final int slot = 26;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(27, this.addSlot(new SlotItemHandler(internal, 27, 204, 46) {
			private final int slot = 27;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(28, this.addSlot(new SlotItemHandler(internal, 28, 222, 47) {
			private final int slot = 28;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(29, this.addSlot(new SlotItemHandler(internal, 29, 240, 48) {
			private final int slot = 29;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(30, this.addSlot(new SlotItemHandler(internal, 30, 258, 48) {
			private final int slot = 30;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(31, this.addSlot(new SlotItemHandler(internal, 31, 34, 66) {
			private final int slot = 31;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(32, this.addSlot(new SlotItemHandler(internal, 32, 52, 66) {
			private final int slot = 32;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(33, this.addSlot(new SlotItemHandler(internal, 33, 70, 65) {
			private final int slot = 33;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(34, this.addSlot(new SlotItemHandler(internal, 34, 88, 64) {
			private final int slot = 34;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(35, this.addSlot(new SlotItemHandler(internal, 35, 106, 63) {
			private final int slot = 35;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(36, this.addSlot(new SlotItemHandler(internal, 36, 124, 62) {
			private final int slot = 36;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(37, this.addSlot(new SlotItemHandler(internal, 37, 168, 62) {
			private final int slot = 37;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(38, this.addSlot(new SlotItemHandler(internal, 38, 186, 63) {
			private final int slot = 38;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(39, this.addSlot(new SlotItemHandler(internal, 39, 204, 64) {
			private final int slot = 39;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(40, this.addSlot(new SlotItemHandler(internal, 40, 222, 65) {
			private final int slot = 40;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(41, this.addSlot(new SlotItemHandler(internal, 41, 240, 66) {
			private final int slot = 41;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(42, this.addSlot(new SlotItemHandler(internal, 42, 258, 66) {
			private final int slot = 42;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(43, this.addSlot(new SlotItemHandler(internal, 43, 34, 84) {
			private final int slot = 43;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(44, this.addSlot(new SlotItemHandler(internal, 44, 52, 84) {
			private final int slot = 44;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(45, this.addSlot(new SlotItemHandler(internal, 45, 70, 83) {
			private final int slot = 45;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(46, this.addSlot(new SlotItemHandler(internal, 46, 88, 82) {
			private final int slot = 46;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(47, this.addSlot(new SlotItemHandler(internal, 47, 106, 81) {
			private final int slot = 47;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(48, this.addSlot(new SlotItemHandler(internal, 48, 124, 80) {
			private final int slot = 48;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(49, this.addSlot(new SlotItemHandler(internal, 49, 168, 80) {
			private final int slot = 49;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(50, this.addSlot(new SlotItemHandler(internal, 50, 186, 81) {
			private final int slot = 50;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(51, this.addSlot(new SlotItemHandler(internal, 51, 204, 82) {
			private final int slot = 51;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(52, this.addSlot(new SlotItemHandler(internal, 52, 222, 83) {
			private final int slot = 52;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(53, this.addSlot(new SlotItemHandler(internal, 53, 240, 84) {
			private final int slot = 53;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		this.customSlots.put(54, this.addSlot(new SlotItemHandler(internal, 54, 258, 84) {
			private final int slot = 54;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !SpellbookScrollConditionProcedure.execute(itemstack);
			}
		}));
		for (int si = 0; si < 3; ++si)
			for (int sj = 0; sj < 9; ++sj)
				this.addSlot(new Slot(inv, sj + (si + 1) * 9, 67 + 8 + sj * 18, 85 + 84 + si * 18));
		for (int si = 0; si < 9; ++si)
			this.addSlot(new Slot(inv, si, 67 + 8 + si * 18, 85 + 142));
	}

	@Override
	public boolean stillValid(Player player) {
		if (this.bound) {
			if (this.boundItemMatcher != null)
				return this.boundItemMatcher.get();
			else if (this.boundBlockEntity != null)
				return AbstractContainerMenu.stillValid(this.access, player, this.boundBlockEntity.getBlockState().getBlock());
			else if (this.boundEntity != null)
				return this.boundEntity.isAlive();
		}
		return true;
	}

	@Override
	public ItemStack quickMoveStack(Player playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = (Slot) this.slots.get(index);
		if (slot != null && slot.hasItem()) {
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();
			if (index < 54) {
				if (!this.moveItemStackTo(itemstack1, 54, this.slots.size(), true))
					return ItemStack.EMPTY;
				slot.onQuickCraft(itemstack1, itemstack);
			} else if (!this.moveItemStackTo(itemstack1, 0, 54, false)) {
				if (index < 54 + 27) {
					if (!this.moveItemStackTo(itemstack1, 54 + 27, this.slots.size(), true))
						return ItemStack.EMPTY;
				} else {
					if (!this.moveItemStackTo(itemstack1, 54, 54 + 27, false))
						return ItemStack.EMPTY;
				}
				return ItemStack.EMPTY;
			}
			if (itemstack1.getCount() == 0)
				slot.set(ItemStack.EMPTY);
			else
				slot.setChanged();
			if (itemstack1.getCount() == itemstack.getCount())
				return ItemStack.EMPTY;
			slot.onTake(playerIn, itemstack1);
		}
		return itemstack;
	}

	@Override
	protected boolean moveItemStackTo(ItemStack p_38904_, int p_38905_, int p_38906_, boolean p_38907_) {
		boolean flag = false;
		int i = p_38905_;
		if (p_38907_) {
			i = p_38906_ - 1;
		}
		if (p_38904_.isStackable()) {
			while (!p_38904_.isEmpty()) {
				if (p_38907_) {
					if (i < p_38905_) {
						break;
					}
				} else if (i >= p_38906_) {
					break;
				}
				Slot slot = this.slots.get(i);
				ItemStack itemstack = slot.getItem();
				if (slot.mayPlace(itemstack) && !itemstack.isEmpty() && ItemStack.isSameItemSameTags(p_38904_, itemstack)) {
					int j = itemstack.getCount() + p_38904_.getCount();
					int maxSize = Math.min(slot.getMaxStackSize(), p_38904_.getMaxStackSize());
					if (j <= maxSize) {
						p_38904_.setCount(0);
						itemstack.setCount(j);
						slot.set(itemstack);
						flag = true;
					} else if (itemstack.getCount() < maxSize) {
						p_38904_.shrink(maxSize - itemstack.getCount());
						itemstack.setCount(maxSize);
						slot.set(itemstack);
						flag = true;
					}
				}
				if (p_38907_) {
					--i;
				} else {
					++i;
				}
			}
		}
		if (!p_38904_.isEmpty()) {
			if (p_38907_) {
				i = p_38906_ - 1;
			} else {
				i = p_38905_;
			}
			while (true) {
				if (p_38907_) {
					if (i < p_38905_) {
						break;
					}
				} else if (i >= p_38906_) {
					break;
				}
				Slot slot1 = this.slots.get(i);
				ItemStack itemstack1 = slot1.getItem();
				if (itemstack1.isEmpty() && slot1.mayPlace(p_38904_)) {
					if (p_38904_.getCount() > slot1.getMaxStackSize()) {
						slot1.setByPlayer(p_38904_.split(slot1.getMaxStackSize()));
					} else {
						slot1.setByPlayer(p_38904_.split(p_38904_.getCount()));
					}
					slot1.setChanged();
					flag = true;
					break;
				}
				if (p_38907_) {
					--i;
				} else {
					++i;
				}
			}
		}
		return flag;
	}

	@Override
	public void removed(Player playerIn) {
		super.removed(playerIn);
		if (!bound && playerIn instanceof ServerPlayer serverPlayer) {
			if (!serverPlayer.isAlive() || serverPlayer.hasDisconnected()) {
				for (int j = 0; j < internal.getSlots(); ++j) {
					playerIn.drop(internal.extractItem(j, internal.getStackInSlot(j).getCount(), false), false);
				}
			} else {
				for (int i = 0; i < internal.getSlots(); ++i) {
					playerIn.getInventory().placeItemBackInInventory(internal.extractItem(i, internal.getStackInSlot(i).getCount(), false));
				}
			}
		}
	}

	public Map<Integer, Slot> get() {
		return customSlots;
	}
}
