
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

    private float angularVelocity;
	private final float angularAcceleration;

	protected LoveParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
		super(world, x, y, z);
        this.setSize(0.15f, 0.15f);
		this.quadSize *= 0.5f;
		this.lifetime = 7;
		this.gravity = -0.1f;
		this.hasPhysics = true;
		this.xd = vx * 0.3;
		this.yd = vy * 0.3;
		this.zd = vz * 0.3;
		this.angularVelocity = 0.03f;
		this.angularAcceleration = 0.03f;
		this.pickSprite(spriteSet);
	}

	@Override
	public int getLightColor(float partialTick) {
		return 15728880;
	}

	@Override
	public @NotNull ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
	}

	@Override
	public void tick() {
		super.tick();
		this.oRoll = this.roll;
		this.roll += this.angularVelocity;
		this.angularVelocity += this.angularAcceleration;
	}
}
