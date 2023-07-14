package com.Apothic0n.StratosphericalExpansion.core.objects;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Random;

public class AmethystVinesBlock extends GrowingPlantHeadBlock implements AmethystVines {
    private static final float CHANCE_OF_BERRIES_ON_GROWTH = 0.26F;

    public AmethystVinesBlock(Properties properties) {
        super(properties, Direction.DOWN, SHAPE, false, 0.1D);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, Integer.valueOf(0)).setValue(BERRIES, Boolean.valueOf(false)));
    }

    protected int getBlocksToGrowWhenBonemealed(Random random) {
        return 1;
    }

    protected boolean canGrowInto(BlockState blockState) {
        return blockState.isAir();
    }

    protected Block getBodyBlock() {
        return StratoBlocks.AMETHYST_VINES_PLANT.get();
    }

    protected BlockState updateBodyAfterConvertedFromHead(BlockState blockState1, BlockState blockState2) {
        return blockState2.setValue(BERRIES, blockState1.getValue(BERRIES));
    }

    protected BlockState getGrowIntoState(BlockState blockState1, RandomSource blockState2) {
        return super.getGrowIntoState(blockState1, blockState2).setValue(BERRIES, Boolean.valueOf(blockState2.nextFloat() < CHANCE_OF_BERRIES_ON_GROWTH));
    }

    public ItemStack getCloneItemStack(BlockGetter blockGetter, BlockPos blockPos, BlockState blockState) {
        return new ItemStack(Items.AMETHYST_SHARD, 1);
    }

    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        return AmethystVines.use(blockState, level, blockPos);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        super.createBlockStateDefinition(stateBuilder);
        stateBuilder.add(BERRIES);
    }

    @Override
    protected int getBlocksToGrowWhenBonemealed(RandomSource p_221341_) {
        return 0;
    }

    /**
     * @return whether bonemeal can be used on this block
     */
    public boolean isValidBonemealTarget(BlockGetter blockGetter, BlockPos blockPos, BlockState blockState, boolean bool) {
        return false;
    }
}
