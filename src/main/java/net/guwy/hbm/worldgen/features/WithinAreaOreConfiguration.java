package net.guwy.hbm.worldgen.features;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

import java.util.List;

public class WithinAreaOreConfiguration implements FeatureConfiguration {
    public static final Codec<WithinAreaOreConfiguration> CODEC = RecordCodecBuilder.create(
            p_67849_ -> p_67849_.group(
                            Codec.list(WithinAreaOreConfiguration.TargetBlockState.CODEC).fieldOf("targets").forGetter(p_161027_ -> p_161027_.targetStates),
                            Codec.intRange(0, 64).fieldOf("size").forGetter(p_161025_ -> p_161025_.size),
                            Codec.floatRange(0.0F, 1.0F).fieldOf("discard_chance_on_air_exposure").forGetter(p_161020_ -> p_161020_.discardChanceOnAirExposure),
                            Codec.intRange(Integer.MIN_VALUE, Integer.MAX_VALUE).fieldOf("minX").forGetter(p_161020_ -> p_161020_.minX),
                            Codec.intRange(Integer.MIN_VALUE, Integer.MAX_VALUE).fieldOf("maxX").forGetter(p_161020_ -> p_161020_.maxX),
                            Codec.intRange(Integer.MIN_VALUE, Integer.MAX_VALUE).fieldOf("minZ").forGetter(p_161020_ -> p_161020_.minZ),
                            Codec.intRange(Integer.MIN_VALUE, Integer.MAX_VALUE).fieldOf("maxZ").forGetter(p_161020_ -> p_161020_.maxZ)
                    )
                    .apply(p_67849_, WithinAreaOreConfiguration::new)
    );
    public final List<WithinAreaOreConfiguration.TargetBlockState> targetStates;
    public final int size;
    public final float discardChanceOnAirExposure;
    public final int minX, maxX, minZ, maxZ;

    public WithinAreaOreConfiguration(List<WithinAreaOreConfiguration.TargetBlockState> targetStates, int size, float discardChanceOnAirExposure,
                                      int minX, int maxX, int minZ, int maxZ) {
        this.size = size;
        this.targetStates = targetStates;
        this.discardChanceOnAirExposure = discardChanceOnAirExposure;
        this.minX = minX;
        this.maxX = maxX;
        this.minZ = minZ;
        this.maxZ = maxZ;
    }

    public WithinAreaOreConfiguration(List<WithinAreaOreConfiguration.TargetBlockState> targetStates, int size, int minX, int maxX, int minZ, int maxZ) {
        this(targetStates, size, 0.0F, minX, maxX, minZ, maxZ);
    }

    public WithinAreaOreConfiguration(RuleTest target, BlockState state, int size, float discardChanceOnAirExposure, int minX, int maxX, int minZ, int maxZ) {
        this(ImmutableList.of(new WithinAreaOreConfiguration.TargetBlockState(target, state)), size, discardChanceOnAirExposure, minX, maxX, minZ, maxZ);
    }

    public WithinAreaOreConfiguration(RuleTest target, BlockState state, int size, int minX, int maxX, int minZ, int maxZ) {
        this(ImmutableList.of(new WithinAreaOreConfiguration.TargetBlockState(target, state)), size, 0.0F, minX, maxX, minZ, maxZ);
    }

    public static WithinAreaOreConfiguration.TargetBlockState target(RuleTest target, BlockState state) {
        return new WithinAreaOreConfiguration.TargetBlockState(target, state);
    }

    public static class TargetBlockState {
        public static final Codec<WithinAreaOreConfiguration.TargetBlockState> CODEC = RecordCodecBuilder.create(
                p_161039_ -> p_161039_.group(
                                RuleTest.CODEC.fieldOf("target").forGetter(p_161043_ -> p_161043_.target),
                                BlockState.CODEC.fieldOf("state").forGetter(p_161041_ -> p_161041_.state)
                        )
                        .apply(p_161039_, WithinAreaOreConfiguration.TargetBlockState::new)
        );
        public final RuleTest target;
        public final BlockState state;

        TargetBlockState(RuleTest target, BlockState state) {
            this.target = target;
            this.state = state;
        }
    }
}
