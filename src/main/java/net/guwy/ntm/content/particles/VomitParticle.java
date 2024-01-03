package net.guwy.ntm.content.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

public class VomitParticle extends TextureSheetParticle {
    protected VomitParticle(ClientLevel pLevel, double pX, double pY, double pZ, SpriteSet spriteSet, double pXSpeed, double pYSpeed, double pZSpeed) {
        super(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed);

        this.friction = 0.8f;
        this.xd = pXSpeed;
        this.yd = pYSpeed;
        this.zd = pZSpeed;
        this.quadSize *= 0.85f;
        this.lifetime = 1200; // 1 min
        this.setSpriteFromAge(spriteSet);

        if(Math.random() < 0.5){
            this.rCol = 96 / 255f;
            this.gCol = 104 / 255f;
            this.bCol = 52 / 255f;
        } else {
            this.rCol = 112 / 255f;
            this.gCol = 130 / 255f;
            this.bCol = 58 / 255f;
        }

        this.hasPhysics = true;
        this.gravity = 3.6f;
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    public void tick() {
        fadeOut();

        super.tick();
    }

    private void fadeOut(){
        float fadeTicks = 20.0f;
        this.alpha = (Math.max(0.0f, Math.min(1.0f, (this.lifetime - this.age) / fadeTicks)));
    }

    public static class Provider implements ParticleProvider<SimpleParticleType>{
        private final SpriteSet sprites;

        public Provider(SpriteSet spriteSet){
            this.sprites = spriteSet;
        }

        public Particle createParticle(SimpleParticleType particleType, ClientLevel level,
                                       double x, double y, double z, double dx, double dy, double dz){
            return new VomitParticle(level, x, y, z, this.sprites, dx, dy, dz);
        }


    }
}
