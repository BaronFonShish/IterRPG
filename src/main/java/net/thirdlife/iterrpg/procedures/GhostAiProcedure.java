package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;
import net.thirdlife.iterrpg.entity.UnboundSoulEntity;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class GhostAiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double xpos = 0;
		double ypos = 0;
		double zpos = 0;
		boolean flag = false;
		if (Math.random() >= 0.6) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.SPIRIT_PARTICLE.get()), x, (y + 1), z, 1, 0.5, 0.75, 0.5, 0.0025);
		}
		if (entity.getPersistentData().getDouble("evade") > 0) {
			entity.getPersistentData().putDouble("evade", (entity.getPersistentData().getDouble("evade") - 1));
		}
		if (entity.getPersistentData().getDouble("mischief") >= Mth.nextInt(RandomSource.create(), 120, 400)) {
			entity.getPersistentData().putDouble("mischief", 0);
			flag = true;
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (flag && entityiterator instanceof ItemEntity) {
						entityiterator.setDeltaMovement(new Vec3((Mth.nextDouble(RandomSource.create(), -0.2, 0.2)), (Mth.nextDouble(RandomSource.create(), 0.05, 0.25)), (Mth.nextDouble(RandomSource.create(), -0.2, 0.2))));
						flag = false;
					}
				}
			}
		} else {
			entity.getPersistentData().putDouble("mischief", (entity.getPersistentData().getDouble("mischief") + 1));
		}
		if (entity.getPersistentData().getDouble("cavecooldown") >= Mth.nextInt(RandomSource.create(), 5000, 25000)) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof UnboundSoulEntity) {
						entityiterator.getPersistentData().putDouble("cavecooldown", 0);
					}
				}
			}
			entity.getPersistentData().putDouble("cavecooldown", 0);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.HOSTILE, 1, 1, false);
				}
			}
		} else {
			entity.getPersistentData().putDouble("cavecooldown", (entity.getPersistentData().getDouble("cavecooldown") + 1));
		}
	}
}
