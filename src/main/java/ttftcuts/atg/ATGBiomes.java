package ttftcuts.atg;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenBlockBlob;
import net.minecraft.world.gen.feature.WorldGenSavannaTree;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import ttftcuts.atg.biome.*;
import ttftcuts.atg.biome.heightmods.HeightModDunes;
import ttftcuts.atg.generator.biome.IBiomeHeightModifier;

public abstract class ATGBiomes {

    public static Biome SHRUBLAND;
    public static Biome WOODLAND;
    public static Biome TROPICAL_SHRUBLAND;
    public static Biome TUNDRA;
    public static Biome GRAVEL_BEACH;
    public static Biome GRAVEL_BEACH_SNOWY;

    public static void init() {

        SHRUBLAND = register(141, "atg_shrubland", new BiomeShrubland(), true, Type.PLAINS, Type.SPARSE);
        WOODLAND = register(142, "atg_woodland", new BiomeWoodland(), false, Type.FOREST);
        TROPICAL_SHRUBLAND = register(143, "atg_tropical_shrubland", new BiomeTropicalShrubland(), false, Type.HOT, Type.WET, Type.JUNGLE, Type.FOREST, Type.SAVANNA);
        TUNDRA = register(144, "atg_steppe", new BiomeTundra(), true, Type.PLAINS, Type.COLD, Type.CONIFEROUS, Type.SPARSE);
        GRAVEL_BEACH = register(145, "atg_gravel_beach", new BiomeGravelBeach(), false, Type.COLD, Type.BEACH);
        GRAVEL_BEACH_SNOWY = register(146, "atg_snowy_gravel_beach", new BiomeSnowyGravelBeach(), false, Type.COLD, Type.BEACH, Type.SNOWY);
    }

    public static Biome register(int id, String name, Biome biome, boolean villages, BiomeDictionary.Type... dictionaryTypes) {
        Biome.registerBiome(id, name, biome);

        if (villages) {
            BiomeManager.addVillageBiome(biome, true);
        }

        if (dictionaryTypes.length > 0) {
            BiomeDictionary.registerBiomeType(biome, dictionaryTypes);
        }

        return biome;
    }

    public static abstract class HeightModifiers {
        public static final IBiomeHeightModifier DUNES = new HeightModDunes();
    }

    public static abstract class BiomeBlocks {
        public static final IBlockState OAK_LOG = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK);
        public static final IBlockState OAK_LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.OAK).withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));

        public static final IBlockState BIRCH_LOG = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.BIRCH);
        public static final IBlockState BIRCH_LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.BIRCH).withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));

        public static final IBlockState SPRUCE_LOG = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE);
        public static final IBlockState SPRUCE_LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.SPRUCE).withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));

        public static final IBlockState JUNGLE_LOG = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE);
        public static final IBlockState JUNGLE_LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.JUNGLE).withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
    }

    public static abstract class Features {
        public static final WorldGenShrub OAK_SHRUB = new WorldGenShrub(BiomeBlocks.OAK_LOG, BiomeBlocks.OAK_LEAF);
        public static final WorldGenShrub JUNGLE_SHRUB = new WorldGenShrub(BiomeBlocks.JUNGLE_LOG, BiomeBlocks.OAK_LEAF);
        public static final WorldGenShrub TUNDRA_SHRUB = new WorldGenShrub(BiomeBlocks.OAK_LOG, BiomeBlocks.SPRUCE_LEAF);

        public static final WorldGenSavannaTree SAVANNA_TREE = new WorldGenSavannaTree(false);

        public static final WorldGenBlockBlob BOULDER_COBBLE = new WorldGenBlockBlob(Blocks.COBBLESTONE, 0);
    }
}
