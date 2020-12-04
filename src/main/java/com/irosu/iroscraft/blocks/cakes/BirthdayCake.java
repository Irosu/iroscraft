package com.irosu.iroscraft.blocks.cakes;

import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import java.util.List;

public class BirthdayCake extends Block implements ICustomCake {

    protected static final int SLICES = 7;
    protected static final IntegerProperty BITES = IntegerProperty.create("bites", 0, 7);
    protected static final VoxelShape[] SHAPES = new VoxelShape[] {
            Block.makeCuboidShape(0.0001D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
            Block.makeCuboidShape(0.0001D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
            Block.makeCuboidShape(0.0001D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
            Block.makeCuboidShape(0.0001D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
            Block.makeCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
            Block.makeCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
            Block.makeCuboidShape(8.0D, 0.0D, 8.0D, 16.0D, 10.0D, 16.0D),
            Block.makeCuboidShape(8.0D, 0.0D, 8.0D, 12.0D, 10.0D, 16.0D)
    };

    private final static Properties properties = Properties.create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH);
    protected final List<Effect> effects = Lists.newArrayList();
    protected int duration;

    public BirthdayCake() {
        super(properties);
        StateContainer.Builder<Block, BlockState> builder = new StateContainer.Builder<>(this);
        super.fillStateContainer(builder);
        super.setDefaultState(this.stateContainer.getBaseState().with(BITES, 0));
    }

    public BirthdayCake(Effect effect, int duration) {
        this(Lists.newArrayList(effect), duration);
    }

    public BirthdayCake(List<Effect> effects, int duration) {
        this();
        this.effects.addAll(effects);
        this.duration = duration;
    }

    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        return CakeUtils.onBlockActivated(state, worldIn, pos, player, handIn, hit, effects, duration, BITES, SLICES);
    }

    public void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(BITES);
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPES[state.get(BITES)];
    }
}
