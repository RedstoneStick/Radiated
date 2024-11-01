package net.guwy.hbm.worldgen.features;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

import java.util.List;

public class WithinSeededRandomAreaOreConfiguration implements FeatureConfiguration {
    public static final Codec<WithinSeededRandomAreaOreConfiguration> CODEC = RecordCodecBuilder.create(
            p_67849_ -> p_67849_.group(
                            Codec.list(WithinSeededRandomAreaOreConfiguration.TargetBlockState.CODEC).fieldOf("targets").forGetter(p_161027_ -> p_161027_.targetStates),
                            Codec.intRange(0, 64).fieldOf("size").forGetter(p_161025_ -> p_161025_.size),
                            Codec.floatRange(0.0F, 1.0F).fieldOf("discard_chance_on_air_exposure").forGetter(p_161020_ -> p_161020_.discardChanceOnAirExposure),
                            Codec.intRange(Integer.MIN_VALUE, Integer.MAX_VALUE).fieldOf("seed_offset").forGetter(p_161020_ -> p_161020_.seed_offset),
                            Codec.intRange(0, Integer.MAX_VALUE).fieldOf("range").forGetter(p_161020_ -> p_161020_.range),
                            Codec.intRange(0, Integer.MAX_VALUE).fieldOf("maxDistFromSpawn").forGetter(p_161020_ -> p_161020_.maxDistFromSpawn)
                    )
                    .apply(p_67849_, WithinSeededRandomAreaOreConfiguration::new)
    );
    public final List<WithinSeededRandomAreaOreConfiguration.TargetBlockState> targetStates;
    public final int size;
    public final float discardChanceOnAirExposure;
    int seed_offset, range, maxDistFromSpawn;

    public WithinSeededRandomAreaOreConfiguration(List<WithinSeededRandomAreaOreConfiguration.TargetBlockState> targetStates, int size, float discardChanceOnAirExposure,
                                                  int seed_offset, int range, int maxDistFromSpawn) {
        this.size = size;
        this.targetStates = targetStates;
        this.discardChanceOnAirExposure = discardChanceOnAirExposure;
        this.seed_offset = seed_offset;
        this.range = range;
        this.maxDistFromSpawn = maxDistFromSpawn;
    }

    public WithinSeededRandomAreaOreConfiguration(List<WithinSeededRandomAreaOreConfiguration.TargetBlockState> targetStates, int size, int seed_offset, int range, int maxDistFromSpawn) {
        this(targetStates, size, 0.0F, seed_offset, range, maxDistFromSpawn);
    }

    public WithinSeededRandomAreaOreConfiguration(RuleTest target, BlockState state, int size, float discardChanceOnAirExposure, int seed_offset, int range, int maxDistFromSpawn) {
        this(ImmutableList.of(new WithinSeededRandomAreaOreConfiguration.TargetBlockState(target, state)), size, discardChanceOnAirExposure, seed_offset, range, maxDistFromSpawn);
    }

    public WithinSeededRandomAreaOreConfiguration(RuleTest target, BlockState state, int size, int seed_offset, int range, int maxDistFromSpawn) {
        this(ImmutableList.of(new WithinSeededRandomAreaOreConfiguration.TargetBlockState(target, state)), size, 0.0F, seed_offset, range, maxDistFromSpawn);
    }

    public static WithinSeededRandomAreaOreConfiguration.TargetBlockState target(RuleTest target, BlockState state) {
        return new WithinSeededRandomAreaOreConfiguration.TargetBlockState(target, state);
    }

    public static class TargetBlockState {
        public static final Codec<WithinSeededRandomAreaOreConfiguration.TargetBlockState> CODEC = RecordCodecBuilder.create(
                p_161039_ -> p_161039_.group(
                                RuleTest.CODEC.fieldOf("target").forGetter(p_161043_ -> p_161043_.target),
                                BlockState.CODEC.fieldOf("state").forGetter(p_161041_ -> p_161041_.state)
                        )
                        .apply(p_161039_, WithinSeededRandomAreaOreConfiguration.TargetBlockState::new)
        );
        public final RuleTest target;
        public final BlockState state;

        TargetBlockState(RuleTest target, BlockState state) {
            this.target = target;
            this.state = state;
        }
    }
}
