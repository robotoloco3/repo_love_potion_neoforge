
package com.roland.repolovepotion.client.particle;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.multiplayer.ClientLevel;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class LoveParticle extends TextureSheetParticle {
	public static LoveParticleProvider provider(SpriteSet spriteSet) {
		return new LoveParticleProvider(spriteSet);
	}

	public static class LoveParticleProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public LoveParticleProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle createParticle(@NotNull SimpleParticleType typeIn, @NotNull ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			return new LoveParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
		}
	}
	private final SpriteSet spriteSet;

	protected LoveParticle(ClientLevel world, double x, double y, double z, double velocityX, double velocityY, double velocityZ, SpriteSet textures) {
			super(world, x, y, z, velocityX, velocityY, velocityZ);
			this.spriteSet = textures;
			this.quadSize *= 1.5F;
			this.lifetime = 16;
			this.setSpriteFromAge(textures);
		}


	@Override
	public @NotNull ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
	}

	@Override
	public void tick() {
		super.tick();
		this.setSpriteFromAge(this.spriteSet);
	}
}
