package net.guwy.radiated.content.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

public class CoughCoalParticle extends TextureSheetParticle {
    protected CoughCoalParticle(ClientLevel pLevel, double pX, double pY, double pZ, SpriteSet spriteSet, double pXSpeed, double pYSpeed, double pZSpeed) {
        super(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed);

        this.friction = 0.8f;
        this.xd = pXSpeed;
        this.yd = pYSpeed;
        this.zd = pZSpeed;
        this.quadSize *= 1.2f;
        this.lifetime = 20; // 1 sec
        this.setSpriteFromAge(spriteSet);

        if(Math.random() < 0.5){
            this.rCol = 112 / 255f;
            this.gCol = 117 / 255f;
            this.bCol = 112 / 255f;
        } else {
            this.rCol = 139 / 255f;
            this.gCol = 132 / 255f;
            this.bCol = 126 / 255f;
        }

        this.hasPhysics = false;
        this.gravity = 0;
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
            return new CoughCoalParticle(level, x, y, z, this.sprites, dx, dy, dz);
        }


    }
}
