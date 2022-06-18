package com.github.alexthe666.iceandfire;

import static net.ilexiconn.llibrary.client.model.tabula.TabulaModelHandler.INSTANCE;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.lwjgl.input.Keyboard;

import com.github.alexthe666.iceandfire.block.BlockCharedPath;
import com.github.alexthe666.iceandfire.block.BlockDreadBase;
import com.github.alexthe666.iceandfire.block.BlockDreadStoneFace;
import com.github.alexthe666.iceandfire.block.BlockDreadWoodLock;
import com.github.alexthe666.iceandfire.block.BlockFallingReturningState;
import com.github.alexthe666.iceandfire.block.BlockReturningState;
import com.github.alexthe666.iceandfire.block.IafBlockRegistry;
import com.github.alexthe666.iceandfire.client.IafKeybindRegistry;
import com.github.alexthe666.iceandfire.client.gui.GuiMyrmexAddRoom;
import com.github.alexthe666.iceandfire.client.gui.GuiMyrmexStaff;
import com.github.alexthe666.iceandfire.client.gui.bestiary.GuiBestiary;
import com.github.alexthe666.iceandfire.client.model.ModelDeathWormArmor;
import com.github.alexthe666.iceandfire.client.model.ModelDragonsteelFireArmor;
import com.github.alexthe666.iceandfire.client.model.ModelDragonsteelIceArmor;
import com.github.alexthe666.iceandfire.client.model.ModelFireDragonArmor;
import com.github.alexthe666.iceandfire.client.model.ModelIceDragonArmor;
import com.github.alexthe666.iceandfire.client.model.ModelMyrmexQueen;
import com.github.alexthe666.iceandfire.client.model.ModelMyrmexRoyal;
import com.github.alexthe666.iceandfire.client.model.ModelMyrmexSentinel;
import com.github.alexthe666.iceandfire.client.model.ModelMyrmexSoldier;
import com.github.alexthe666.iceandfire.client.model.ModelMyrmexWorker;
import com.github.alexthe666.iceandfire.client.model.ModelSeaSerpentArmor;
import com.github.alexthe666.iceandfire.client.model.ModelSilverArmor;
import com.github.alexthe666.iceandfire.client.model.ModelTrollArmor;
import com.github.alexthe666.iceandfire.client.model.RenderDreadLichSkull;
import com.github.alexthe666.iceandfire.client.model.animator.FireDragonTabulaModelAnimator;
import com.github.alexthe666.iceandfire.client.model.animator.IceDragonTabulaModelAnimator;
import com.github.alexthe666.iceandfire.client.model.animator.SeaSerpentTabulaModelAnimator;
import com.github.alexthe666.iceandfire.client.model.util.EnumDragonAnimations;
import com.github.alexthe666.iceandfire.client.model.util.EnumSeaSerpentAnimations;
import com.github.alexthe666.iceandfire.client.model.util.IceAndFireTabulaModel;
import com.github.alexthe666.iceandfire.client.particle.IceAndFireParticleSpawner;
import com.github.alexthe666.iceandfire.client.particle.ParticleBlood;
import com.github.alexthe666.iceandfire.client.particle.ParticleDragonFlame;
import com.github.alexthe666.iceandfire.client.particle.ParticleDragonFrost;
import com.github.alexthe666.iceandfire.client.particle.ParticleDreadPortal;
import com.github.alexthe666.iceandfire.client.particle.ParticleDreadTorch;
import com.github.alexthe666.iceandfire.client.particle.ParticleHydraBreath;
import com.github.alexthe666.iceandfire.client.particle.ParticlePixieDust;
import com.github.alexthe666.iceandfire.client.particle.ParticleSerpentBubble;
import com.github.alexthe666.iceandfire.client.particle.ParticleSirenAppearance;
import com.github.alexthe666.iceandfire.client.particle.ParticleSirenMusic;
import com.github.alexthe666.iceandfire.client.render.RenderDreadlandsAurora;
import com.github.alexthe666.iceandfire.client.render.RenderDreadlandsSky;
import com.github.alexthe666.iceandfire.client.render.RenderDreadlandsWeather;
import com.github.alexthe666.iceandfire.client.render.entity.RenderAmphithere;
import com.github.alexthe666.iceandfire.client.render.entity.RenderAmphithereArrow;
import com.github.alexthe666.iceandfire.client.render.entity.RenderBlackFrostDragon;
import com.github.alexthe666.iceandfire.client.render.entity.RenderChainTie;
import com.github.alexthe666.iceandfire.client.render.entity.RenderCockatrice;
import com.github.alexthe666.iceandfire.client.render.entity.RenderCyclops;
import com.github.alexthe666.iceandfire.client.render.entity.RenderDeathWorm;
import com.github.alexthe666.iceandfire.client.render.entity.RenderDragonArrow;
import com.github.alexthe666.iceandfire.client.render.entity.RenderDragonBase;
import com.github.alexthe666.iceandfire.client.render.entity.RenderDragonEgg;
import com.github.alexthe666.iceandfire.client.render.entity.RenderDragonFireCharge;
import com.github.alexthe666.iceandfire.client.render.entity.RenderDragonSkull;
import com.github.alexthe666.iceandfire.client.render.entity.RenderDreadBeast;
import com.github.alexthe666.iceandfire.client.render.entity.RenderDreadGhoul;
import com.github.alexthe666.iceandfire.client.render.entity.RenderDreadHorse;
import com.github.alexthe666.iceandfire.client.render.entity.RenderDreadKnight;
import com.github.alexthe666.iceandfire.client.render.entity.RenderDreadLich;
import com.github.alexthe666.iceandfire.client.render.entity.RenderDreadQueen;
import com.github.alexthe666.iceandfire.client.render.entity.RenderDreadScuttler;
import com.github.alexthe666.iceandfire.client.render.entity.RenderDreadThrall;
import com.github.alexthe666.iceandfire.client.render.entity.RenderGorgon;
import com.github.alexthe666.iceandfire.client.render.entity.RenderHippocampus;
import com.github.alexthe666.iceandfire.client.render.entity.RenderHippogryph;
import com.github.alexthe666.iceandfire.client.render.entity.RenderHydra;
import com.github.alexthe666.iceandfire.client.render.entity.RenderHydraArrow;
import com.github.alexthe666.iceandfire.client.render.entity.RenderMobSkull;
//import com.github.alexthe666.iceandfire.client.render.entity.RenderModCapes;
import com.github.alexthe666.iceandfire.client.render.entity.RenderMyrmexBase;
import com.github.alexthe666.iceandfire.client.render.entity.RenderMyrmexEgg;
import com.github.alexthe666.iceandfire.client.render.entity.RenderNothing;
import com.github.alexthe666.iceandfire.client.render.entity.RenderPixie;
import com.github.alexthe666.iceandfire.client.render.entity.RenderSeaSerpent;
import com.github.alexthe666.iceandfire.client.render.entity.RenderSeaSerpentArrow;
import com.github.alexthe666.iceandfire.client.render.entity.RenderSiren;
import com.github.alexthe666.iceandfire.client.render.entity.RenderSnowVillager;
import com.github.alexthe666.iceandfire.client.render.entity.RenderStoneStatue;
import com.github.alexthe666.iceandfire.client.render.entity.RenderStymphalianArrow;
import com.github.alexthe666.iceandfire.client.render.entity.RenderStymphalianBird;
import com.github.alexthe666.iceandfire.client.render.entity.RenderStymphalianFeather;
import com.github.alexthe666.iceandfire.client.render.entity.RenderTideTrident;
import com.github.alexthe666.iceandfire.client.render.entity.RenderTroll;
import com.github.alexthe666.iceandfire.client.render.entity.layer.LayerDragonArmor;
import com.github.alexthe666.iceandfire.client.render.tile.IceAndFireTEISR;
import com.github.alexthe666.iceandfire.client.render.tile.RenderDreadPortal;
import com.github.alexthe666.iceandfire.client.render.tile.RenderDreadSpawner;
import com.github.alexthe666.iceandfire.client.render.tile.RenderEggInIce;
import com.github.alexthe666.iceandfire.client.render.tile.RenderGorgonHead;
import com.github.alexthe666.iceandfire.client.render.tile.RenderJar;
import com.github.alexthe666.iceandfire.client.render.tile.RenderLectern;
import com.github.alexthe666.iceandfire.client.render.tile.RenderPixieHouse;
import com.github.alexthe666.iceandfire.client.render.tile.RenderPodium;
import com.github.alexthe666.iceandfire.compat.TinkersCompatBridge;
import com.github.alexthe666.iceandfire.entity.EntityAmphithere;
import com.github.alexthe666.iceandfire.entity.EntityAmphithereArrow;
import com.github.alexthe666.iceandfire.entity.EntityBlackFrostDragon;
import com.github.alexthe666.iceandfire.entity.EntityChainTie;
import com.github.alexthe666.iceandfire.entity.EntityCockatrice;
import com.github.alexthe666.iceandfire.entity.EntityCockatriceEgg;
import com.github.alexthe666.iceandfire.entity.EntityCyclops;
import com.github.alexthe666.iceandfire.entity.EntityDeathWorm;
import com.github.alexthe666.iceandfire.entity.EntityDeathWormEgg;
import com.github.alexthe666.iceandfire.entity.EntityDragonArrow;
import com.github.alexthe666.iceandfire.entity.EntityDragonBase;
import com.github.alexthe666.iceandfire.entity.EntityDragonEgg;
import com.github.alexthe666.iceandfire.entity.EntityDragonFireCharge;
import com.github.alexthe666.iceandfire.entity.EntityDragonIceCharge;
import com.github.alexthe666.iceandfire.entity.EntityDragonSkull;
import com.github.alexthe666.iceandfire.entity.EntityDreadBeast;
import com.github.alexthe666.iceandfire.entity.EntityDreadGhoul;
import com.github.alexthe666.iceandfire.entity.EntityDreadHorse;
import com.github.alexthe666.iceandfire.entity.EntityDreadKnight;
import com.github.alexthe666.iceandfire.entity.EntityDreadLich;
import com.github.alexthe666.iceandfire.entity.EntityDreadLichSkull;
import com.github.alexthe666.iceandfire.entity.EntityDreadQueen;
import com.github.alexthe666.iceandfire.entity.EntityDreadScuttler;
import com.github.alexthe666.iceandfire.entity.EntityDreadThrall;
import com.github.alexthe666.iceandfire.entity.EntityFireDragon;
import com.github.alexthe666.iceandfire.entity.EntityGorgon;
import com.github.alexthe666.iceandfire.entity.EntityHippocampus;
import com.github.alexthe666.iceandfire.entity.EntityHippogryph;
import com.github.alexthe666.iceandfire.entity.EntityHippogryphEgg;
import com.github.alexthe666.iceandfire.entity.EntityHydra;
import com.github.alexthe666.iceandfire.entity.EntityHydraArrow;
import com.github.alexthe666.iceandfire.entity.EntityHydraBreath;
import com.github.alexthe666.iceandfire.entity.EntityIceDragon;
import com.github.alexthe666.iceandfire.entity.EntityMobSkull;
import com.github.alexthe666.iceandfire.entity.EntityMyrmexEgg;
import com.github.alexthe666.iceandfire.entity.EntityMyrmexQueen;
import com.github.alexthe666.iceandfire.entity.EntityMyrmexRoyal;
import com.github.alexthe666.iceandfire.entity.EntityMyrmexSentinel;
import com.github.alexthe666.iceandfire.entity.EntityMyrmexSoldier;
import com.github.alexthe666.iceandfire.entity.EntityMyrmexSwarmer;
import com.github.alexthe666.iceandfire.entity.EntityMyrmexWorker;
import com.github.alexthe666.iceandfire.entity.EntityPixie;
import com.github.alexthe666.iceandfire.entity.EntityPixieCharge;
import com.github.alexthe666.iceandfire.entity.EntitySeaSerpent;
import com.github.alexthe666.iceandfire.entity.EntitySeaSerpentArrow;
import com.github.alexthe666.iceandfire.entity.EntitySeaSerpentBubbles;
import com.github.alexthe666.iceandfire.entity.EntitySiren;
import com.github.alexthe666.iceandfire.entity.EntitySnowVillager;
import com.github.alexthe666.iceandfire.entity.EntityStoneStatue;
import com.github.alexthe666.iceandfire.entity.EntityStymphalianArrow;
import com.github.alexthe666.iceandfire.entity.EntityStymphalianBird;
import com.github.alexthe666.iceandfire.entity.EntityStymphalianFeather;
import com.github.alexthe666.iceandfire.entity.EntityTideTrident;
import com.github.alexthe666.iceandfire.entity.EntityTroll;
import com.github.alexthe666.iceandfire.entity.MyrmexHive;
import com.github.alexthe666.iceandfire.entity.tile.TileEntityDreadPortal;
import com.github.alexthe666.iceandfire.entity.tile.TileEntityDreadSpawner;
import com.github.alexthe666.iceandfire.entity.tile.TileEntityDummyGorgonHead;
import com.github.alexthe666.iceandfire.entity.tile.TileEntityDummyGorgonHeadActive;
import com.github.alexthe666.iceandfire.entity.tile.TileEntityEggInIce;
import com.github.alexthe666.iceandfire.entity.tile.TileEntityJar;
import com.github.alexthe666.iceandfire.entity.tile.TileEntityLectern;
import com.github.alexthe666.iceandfire.entity.tile.TileEntityPixieHouse;
import com.github.alexthe666.iceandfire.entity.tile.TileEntityPodium;
import com.github.alexthe666.iceandfire.enums.EnumDragonArmor;
import com.github.alexthe666.iceandfire.enums.EnumHippogryphTypes;
import com.github.alexthe666.iceandfire.enums.EnumSeaSerpent;
import com.github.alexthe666.iceandfire.enums.EnumSkullType;
import com.github.alexthe666.iceandfire.enums.EnumTroll;
import com.github.alexthe666.iceandfire.event.ClientEvents;
import com.github.alexthe666.iceandfire.item.ICustomRendered;
import com.github.alexthe666.iceandfire.item.IafItemRegistry;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
public class ClientProxy extends CommonProxy {

    private static final ModelFireDragonArmor FIRE_DRAGON_SCALE_ARMOR_MODEL = new ModelFireDragonArmor(0.5F, false);
    private static final ModelFireDragonArmor FIRE_DRAGON_SCALE_ARMOR_MODEL_LEGS = new ModelFireDragonArmor(0.2F, true);
    private static final ModelIceDragonArmor ICE_DRAGON_SCALE_ARMOR_MODEL = new ModelIceDragonArmor(0.5F, false);
    private static final ModelIceDragonArmor ICE_DRAGON_SCALE_ARMOR_MODEL_LEGS = new ModelIceDragonArmor(0.2F, true);
    private static final ModelDeathWormArmor DEATHWORM_ARMOR_MODEL = new ModelDeathWormArmor(0.5F);
    private static final ModelDeathWormArmor DEATHWORM_ARMOR_MODEL_LEGS = new ModelDeathWormArmor(0.2F);
    private static final ModelTrollArmor TROLL_ARMOR_MODEL = new ModelTrollArmor(0.75F);
    private static final ModelTrollArmor TROLL_ARMOR_MODEL_LEGS = new ModelTrollArmor(0.35F);
    private static final ModelSeaSerpentArmor TIDE_ARMOR_MODEL = new ModelSeaSerpentArmor(0.4F);
    private static final ModelSeaSerpentArmor TIDE_ARMOR_MODEL_LEGS = new ModelSeaSerpentArmor(0.2F);
    private static final ModelDragonsteelFireArmor DRAGONSTEEL_FIRE_ARMOR_MODEL = new ModelDragonsteelFireArmor(0.4F);
    private static final ModelDragonsteelFireArmor DRAGONSTEEL_FIRE_ARMOR_MODEL_LEGS = new ModelDragonsteelFireArmor(0.2F);
    private static final ModelDragonsteelIceArmor DRAGONSTEEL_ICE_ARMOR_MODEL = new ModelDragonsteelIceArmor(0.4F);
    private static final ModelDragonsteelIceArmor DRAGONSTEEL_ICE_ARMOR_MODEL_LEGS = new ModelDragonsteelIceArmor(0.2F);
    private static final ModelSilverArmor SILVER_ARMOR_MODEL = new ModelSilverArmor(0.5F);
    private static final ModelSilverArmor SILVER_ARMOR_MODEL_LEGS = new ModelSilverArmor(0.2F);
    @SideOnly(Side.CLIENT)
    private static final IceAndFireTEISR TEISR = new IceAndFireTEISR();
    public static List<UUID> currentDragonRiders = new ArrayList<UUID>();
    private static MyrmexHive referedClientHive = null;
    private IceAndFireParticleSpawner particleSpawner;
    private FontRenderer bestiaryFontRenderer;
    private int previousViewType = 0;
    private int thirdPersonViewDragon = 0;
    private IRenderHandler dreadlandsWeatherRenderer = new RenderDreadlandsWeather();
    private IRenderHandler dreadlandsSkyRenderer = new RenderDreadlandsSky();
    private IRenderHandler dreadlandsAuroraRender = new RenderDreadlandsAurora();

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void registerModels(ModelRegistryEvent event) {
        ModelBakery.registerItemVariants(Item.getItemFromBlock(IafBlockRegistry.podium), new ResourceLocation("iceandfire:podium_oak"), new ResourceLocation("iceandfire:podium_spruce"), new ResourceLocation("iceandfire:podium_birch"), new ResourceLocation("iceandfire:podium_jungle"), new ResourceLocation("iceandfire:podium_acacia"), new ResourceLocation("iceandfire:podium_dark_oak"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(IafBlockRegistry.podium), 0, new ModelResourceLocation("iceandfire:podium_oak", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(IafBlockRegistry.podium), 1, new ModelResourceLocation("iceandfire:podium_spruce", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(IafBlockRegistry.podium), 2, new ModelResourceLocation("iceandfire:podium_birch", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(IafBlockRegistry.podium), 3, new ModelResourceLocation("iceandfire:podium_jungle", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(IafBlockRegistry.podium), 4, new ModelResourceLocation("iceandfire:podium_acacia", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(IafBlockRegistry.podium), 5, new ModelResourceLocation("iceandfire:podium_dark_oak", "inventory"));
        ModelBakery.registerItemVariants(IafItemRegistry.dragonbone_bow, new ResourceLocation("iceandfire:dragonbone_bow"), new ResourceLocation("iceandfire:dragonbone_bow_pulling_0"), new ResourceLocation("iceandfire:dragonbone_bow_pulling_1"));
        ModelLoader.setCustomModelResourceLocation(IafItemRegistry.dragonbone_bow, 0, new ModelResourceLocation("iceandfire:dragonbone_bow", "inventory"));
        ModelBakery.registerItemVariants(IafItemRegistry.dragon_skull, new ResourceLocation("iceandfire:dragon_skull_fire"), new ResourceLocation("iceandfire:dragon_skull_ice"));
        ModelLoader.setCustomModelResourceLocation(IafItemRegistry.dragon_skull, 0, new ModelResourceLocation("iceandfire:dragon_skull_fire", "inventory"));
        ModelLoader.setCustomModelResourceLocation(IafItemRegistry.dragon_skull, 1, new ModelResourceLocation("iceandfire:dragon_skull_ice", "inventory"));
        ModelBakery.registerItemVariants(IafItemRegistry.dragon_armor_iron, new ResourceLocation("iceandfire:dragonarmor_iron_head"), new ResourceLocation("iceandfire:dragonarmor_iron_neck"), new ResourceLocation("iceandfire:dragonarmor_iron_body"), new ResourceLocation("iceandfire:dragonarmor_iron_tail"));
        ModelLoader.setCustomModelResourceLocation(IafItemRegistry.dragon_armor_iron, 0, new ModelResourceLocation("iceandfire:dragonarmor_iron_head", "inventory"));
        ModelLoader.setCustomModelResourceLocation(IafItemRegistry.dragon_armor_iron, 1, new ModelResourceLocation("iceandfire:dragonarmor_iron_neck", "inventory"));
        ModelLoader.setCustomModelResourceLocation(IafItemRegistry.dragon_armor_iron, 2, new ModelResourceLocation("iceandfire:dragonarmor_iron_body", "inventory"));
        ModelLoader.setCustomModelResourceLocation(IafItemRegistry.dragon_armor_iron, 3, new ModelResourceLocation("iceandfire:dragonarmor_iron_tail", "inventory"));
        ModelBakery.registerItemVariants(IafItemRegistry.dragon_armor_gold, new ResourceLocation("iceandfire:dragonarmor_gold_head"), new ResourceLocation("iceandfire:dragonarmor_gold_neck"), new ResourceLocation("iceandfire:dragonarmor_gold_body"), new ResourceLocation("iceandfire:dragonarmor_gold_tail"));
        ModelLoader.setCustomModelResourceLocation(IafItemRegistry.dragon_armor_gold, 0, new ModelResourceLocation("iceandfire:dragonarmor_gold_head", "inventory"));
        ModelLoader.setCustomModelResourceLocation(IafItemRegistry.dragon_armor_gold, 1, new ModelResourceLocation("iceandfire:dragonarmor_gold_neck", "inventory"));
        ModelLoader.setCustomModelResourceLocation(IafItemRegistry.dragon_armor_gold, 2, new ModelResourceLocation("iceandfire:dragonarmor_gold_body", "inventory"));
        ModelLoader.setCustomModelResourceLocation(IafItemRegistry.dragon_armor_gold, 3, new ModelResourceLocation("iceandfire:dragonarmor_gold_tail", "inventory"));
        ModelBakery.registerItemVariants(IafItemRegistry.dragon_armor_diamond, new ResourceLocation("iceandfire:dragonarmor_diamond_head"), new ResourceLocation("iceandfire:dragonarmor_diamond_neck"), new ResourceLocation("iceandfire:dragonarmor_diamond_body"), new ResourceLocation("iceandfire:dragonarmor_diamond_tail"));
        ModelLoader.setCustomModelResourceLocation(IafItemRegistry.dragon_armor_diamond, 0, new ModelResourceLocation("iceandfire:dragonarmor_diamond_head", "inventory"));
        ModelLoader.setCustomModelResourceLocation(IafItemRegistry.dragon_armor_diamond, 1, new ModelResourceLocation("iceandfire:dragonarmor_diamond_neck", "inventory"));
        ModelLoader.setCustomModelResourceLocation(IafItemRegistry.dragon_armor_diamond, 2, new ModelResourceLocation("iceandfire:dragonarmor_diamond_body", "inventory"));
        ModelLoader.setCustomModelResourceLocation(IafItemRegistry.dragon_armor_diamond, 3, new ModelResourceLocation("iceandfire:dragonarmor_diamond_tail", "inventory"));
        ModelBakery.registerItemVariants(IafItemRegistry.dragon_armor_silver, new ResourceLocation("iceandfire:dragonarmor_diamond_head"), new ResourceLocation("iceandfire:dragonarmor_diamond_neck"), new ResourceLocation("iceandfire:dragonarmor_diamond_body"), new ResourceLocation("iceandfire:dragonarmor_diamond_tail"));
        ModelLoader.setCustomModelResourceLocation(IafItemRegistry.dragon_armor_silver, 0, new ModelResourceLocation("iceandfire:dragonarmor_silver_head", "inventory"));
        ModelLoader.setCustomModelResourceLocation(IafItemRegistry.dragon_armor_silver, 1, new ModelResourceLocation("iceandfire:dragonarmor_silver_neck", "inventory"));
        ModelLoader.setCustomModelResourceLocation(IafItemRegistry.dragon_armor_silver, 2, new ModelResourceLocation("iceandfire:dragonarmor_silver_body", "inventory"));
        ModelLoader.setCustomModelResourceLocation(IafItemRegistry.dragon_armor_silver, 3, new ModelResourceLocation("iceandfire:dragonarmor_silver_tail", "inventory"));
        ModelBakery.registerItemVariants(IafItemRegistry.dragon_armor_dragonsteel_fire, new ResourceLocation("iceandfire:dragonarmor_dragonsteel_fire_head"), new ResourceLocation("iceandfire:dragonarmor_dragonsteel_fire_neck"), new ResourceLocation("iceandfire:dragonarmor_dragonsteel_fire_body"), new ResourceLocation("iceandfire:dragonarmor_dragonsteel_fire_tail"));
        ModelLoader.setCustomModelResourceLocation(IafItemRegistry.dragon_armor_dragonsteel_fire, 0, new ModelResourceLocation("iceandfire:dragonarmor_dragonsteel_fire_head", "inventory"));
        ModelLoader.setCustomModelResourceLocation(IafItemRegistry.dragon_armor_dragonsteel_fire, 1, new ModelResourceLocation("iceandfire:dragonarmor_dragonsteel_fire_neck", "inventory"));
        ModelLoader.setCustomModelResourceLocation(IafItemRegistry.dragon_armor_dragonsteel_fire, 2, new ModelResourceLocation("iceandfire:dragonarmor_dragonsteel_fire_body", "inventory"));
        ModelLoader.setCustomModelResourceLocation(IafItemRegistry.dragon_armor_dragonsteel_fire, 3, new ModelResourceLocation("iceandfire:dragonarmor_dragonsteel_fire_tail", "inventory"));
        ModelBakery.registerItemVariants(IafItemRegistry.dragon_armor_dragonsteel_ice, new ResourceLocation("iceandfire:dragonarmor_dragonsteel_ice_head"), new ResourceLocation("iceandfire:dragonarmor_dragonsteel_ice_neck"), new ResourceLocation("iceandfire:dragonarmor_dragonsteel_ice_body"), new ResourceLocation("iceandfire:dragonarmor_dragonsteel_ice_tail"));
        ModelLoader.setCustomModelResourceLocation(IafItemRegistry.dragon_armor_dragonsteel_ice, 0, new ModelResourceLocation("iceandfire:dragonarmor_dragonsteel_ice_head", "inventory"));
        ModelLoader.setCustomModelResourceLocation(IafItemRegistry.dragon_armor_dragonsteel_ice, 1, new ModelResourceLocation("iceandfire:dragonarmor_dragonsteel_ice_neck", "inventory"));
        ModelLoader.setCustomModelResourceLocation(IafItemRegistry.dragon_armor_dragonsteel_ice, 2, new ModelResourceLocation("iceandfire:dragonarmor_dragonsteel_ice_body", "inventory"));
        ModelLoader.setCustomModelResourceLocation(IafItemRegistry.dragon_armor_dragonsteel_ice, 3, new ModelResourceLocation("iceandfire:dragonarmor_dragonsteel_ice_tail", "inventory"));
        for (int i = 0; i < EnumHippogryphTypes.values().length; i++) {
            ModelLoader.setCustomModelResourceLocation(IafItemRegistry.hippogryph_egg, i, new ModelResourceLocation("iceandfire:hippogryph_egg", "inventory"));
        }
        ModelLoader.setCustomModelResourceLocation(IafItemRegistry.gorgon_head, 0, new ModelResourceLocation("iceandfire:gorgon_head", "inventory"));
        ModelLoader.setCustomModelResourceLocation(IafItemRegistry.gorgon_head, 1, new ModelResourceLocation("iceandfire:gorgon_head", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(IafBlockRegistry.pixieHouse), 0, new ModelResourceLocation("iceandfire:pixie_house", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(IafBlockRegistry.pixieHouse), 1, new ModelResourceLocation("iceandfire:pixie_house", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(IafBlockRegistry.pixieHouse), 2, new ModelResourceLocation("iceandfire:pixie_house", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(IafBlockRegistry.pixieHouse), 3, new ModelResourceLocation("iceandfire:pixie_house", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(IafBlockRegistry.pixieHouse), 4, new ModelResourceLocation("iceandfire:pixie_house", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(IafBlockRegistry.pixieHouse), 5, new ModelResourceLocation("iceandfire:pixie_house", "inventory"));
        ModelBakery.registerItemVariants(Item.getItemFromBlock(IafBlockRegistry.jar_pixie), new ResourceLocation("iceandfire:jar_0"), new ResourceLocation("iceandfire:jar_1"), new ResourceLocation("iceandfire:jar_2"), new ResourceLocation("iceandfire:jar_3"), new ResourceLocation("iceandfire:jar_4"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(IafBlockRegistry.jar_empty), 0, new ModelResourceLocation("iceandfire:jar", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(IafBlockRegistry.jar_pixie), 0, new ModelResourceLocation("iceandfire:jar_0", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(IafBlockRegistry.jar_pixie), 1, new ModelResourceLocation("iceandfire:jar_1", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(IafBlockRegistry.jar_pixie), 2, new ModelResourceLocation("iceandfire:jar_2", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(IafBlockRegistry.jar_pixie), 3, new ModelResourceLocation("iceandfire:jar_3", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(IafBlockRegistry.jar_pixie), 4, new ModelResourceLocation("iceandfire:jar_4", "inventory"));
        ModelBakery.registerItemVariants(IafItemRegistry.deathworm_chitin, new ResourceLocation("iceandfire:deathworm_chitin_yellow"), new ResourceLocation("iceandfire:deathworm_chitin_white"), new ResourceLocation("iceandfire:deathworm_chitin_red"));
        ModelLoader.setCustomModelResourceLocation(IafItemRegistry.deathworm_chitin, 0, new ModelResourceLocation("iceandfire:deathworm_chitin_yellow", "inventory"));
        ModelLoader.setCustomModelResourceLocation(IafItemRegistry.deathworm_chitin, 1, new ModelResourceLocation("iceandfire:deathworm_chitin_white", "inventory"));
        ModelLoader.setCustomModelResourceLocation(IafItemRegistry.deathworm_chitin, 2, new ModelResourceLocation("iceandfire:deathworm_chitin_red", "inventory"));
        ModelBakery.registerItemVariants(IafItemRegistry.deathworm_egg, new ResourceLocation("iceandfire:deathworm_egg"), new ResourceLocation("iceandfire:deathworm_egg_giant"));
        ModelLoader.setCustomModelResourceLocation(IafItemRegistry.deathworm_egg, 0, new ModelResourceLocation("iceandfire:deathworm_egg", "inventory"));
        ModelLoader.setCustomModelResourceLocation(IafItemRegistry.deathworm_egg, 1, new ModelResourceLocation("iceandfire:deathworm_egg_giant", "inventory"));
        for (EnumDragonArmor armor : EnumDragonArmor.values()) {
            renderDragonArmors(armor);
        }
        for (EnumSeaSerpent armor : EnumSeaSerpent.values()) {
            renderSeaSerpentArmors(armor);
        }
        for (EnumTroll.Weapon weapon : EnumTroll.Weapon.values()) {
            ModelLoader.setCustomModelResourceLocation(weapon.item, 0, new ModelResourceLocation("iceandfire:troll_weapon", "inventory"));
        }
        for (EnumTroll troll : EnumTroll.values()) {
            ModelLoader.setCustomModelResourceLocation(troll.leather, 0, new ModelResourceLocation("iceandfire:troll_leather_" + troll.name().toLowerCase(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(troll.helmet, 0, new ModelResourceLocation("iceandfire:" + troll.name().toLowerCase() + "_troll_leather_helmet", "inventory"));
            ModelLoader.setCustomModelResourceLocation(troll.chestplate, 0, new ModelResourceLocation("iceandfire:" + troll.name().toLowerCase() + "_troll_leather_chestplate", "inventory"));
            ModelLoader.setCustomModelResourceLocation(troll.leggings, 0, new ModelResourceLocation("iceandfire:" + troll.name().toLowerCase() + "_troll_leather_leggings", "inventory"));
            ModelLoader.setCustomModelResourceLocation(troll.boots, 0, new ModelResourceLocation("iceandfire:" + troll.name().toLowerCase() + "_troll_leather_boots", "inventory"));
        }
        for (EnumSkullType skull : EnumSkullType.values()) {
            ModelLoader.setCustomModelResourceLocation(skull.skull_item, 0, new ModelResourceLocation("iceandfire:" + skull.itemResourceName, "inventory"));
        }
        ModelBakery.registerItemVariants(Item.getItemFromBlock(IafBlockRegistry.myrmex_resin), new ResourceLocation("iceandfire:desert_myrmex_resin"), new ResourceLocation("iceandfire:jungle_myrmex_resin"));
        ModelBakery.registerItemVariants(Item.getItemFromBlock(IafBlockRegistry.myrmex_resin_sticky), new ResourceLocation("iceandfire:desert_myrmex_resin_sticky"), new ResourceLocation("iceandfire:jungle_myrmex_resin_sticky"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(IafBlockRegistry.myrmex_resin), 0, new ModelResourceLocation("iceandfire:desert_myrmex_resin", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(IafBlockRegistry.myrmex_resin), 1, new ModelResourceLocation("iceandfire:jungle_myrmex_resin", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(IafBlockRegistry.myrmex_resin_sticky), 0, new ModelResourceLocation("iceandfire:desert_myrmex_resin_sticky", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(IafBlockRegistry.myrmex_resin_sticky), 1, new ModelResourceLocation("iceandfire:jungle_myrmex_resin_sticky", "inventory"));
        for (int i = 0; i < 5; i++) {
            ModelLoader.setCustomModelResourceLocation(IafItemRegistry.myrmex_desert_egg, i, new ModelResourceLocation("iceandfire:myrmex_desert_egg", "inventory"));
            ModelLoader.setCustomModelResourceLocation(IafItemRegistry.myrmex_jungle_egg, i, new ModelResourceLocation("iceandfire:myrmex_jungle_egg", "inventory"));
        }
        for (EnumSeaSerpent color : EnumSeaSerpent.values()) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(color.scaleBlock), 0, new ModelResourceLocation("iceandfire:" + color.scaleBlock.getRegistryName().getPath(), "inventory"));
        }
        try {
            for (Field f : IafItemRegistry.class.getDeclaredFields()) {
                Object obj = f.get(null);
                if (obj instanceof Item && !(obj instanceof ICustomRendered)) {
                    ModelLoader.setCustomModelResourceLocation((Item) obj, 0, new ModelResourceLocation("iceandfire:" + ((Item) obj).getRegistryName().getPath(), "inventory"));
                } else if (obj instanceof Item[]) {
                    for (Item item : (Item[]) obj) {
                        if (!(item instanceof ICustomRendered)) {
                            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation("iceandfire:" + item.getRegistryName().getPath(), "inventory"));

                        }
                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        ModelLoader.setCustomStateMapper(IafBlockRegistry.charedDirt, (new StateMap.Builder()).ignore(BlockReturningState.REVERTS).build());
        ModelLoader.setCustomStateMapper(IafBlockRegistry.charedGrass, (new StateMap.Builder()).ignore(BlockReturningState.REVERTS).build());
        ModelLoader.setCustomStateMapper(IafBlockRegistry.charedStone, (new StateMap.Builder()).ignore(BlockReturningState.REVERTS).build());
        ModelLoader.setCustomStateMapper(IafBlockRegistry.charedCobblestone, (new StateMap.Builder()).ignore(BlockReturningState.REVERTS).build());
        ModelLoader.setCustomStateMapper(IafBlockRegistry.charedGravel, (new StateMap.Builder()).ignore(BlockFallingReturningState.REVERTS).build());
        ModelLoader.setCustomStateMapper(IafBlockRegistry.charedGrassPath, (new StateMap.Builder()).ignore(BlockCharedPath.REVERTS).build());
        ModelLoader.setCustomStateMapper(IafBlockRegistry.frozenDirt, (new StateMap.Builder()).ignore(BlockReturningState.REVERTS).build());
        ModelLoader.setCustomStateMapper(IafBlockRegistry.frozenGrass, (new StateMap.Builder()).ignore(BlockReturningState.REVERTS).build());
        ModelLoader.setCustomStateMapper(IafBlockRegistry.frozenStone, (new StateMap.Builder()).ignore(BlockReturningState.REVERTS).build());
        ModelLoader.setCustomStateMapper(IafBlockRegistry.frozenCobblestone, (new StateMap.Builder()).ignore(BlockReturningState.REVERTS).build());
        ModelLoader.setCustomStateMapper(IafBlockRegistry.frozenGravel, (new StateMap.Builder()).ignore(BlockFallingReturningState.REVERTS).build());
        ModelLoader.setCustomStateMapper(IafBlockRegistry.frozenGrassPath, (new StateMap.Builder()).ignore(BlockCharedPath.REVERTS).build());
        ModelLoader.setCustomStateMapper(IafBlockRegistry.dread_stone, (new StateMap.Builder()).ignore(BlockDreadBase.PLAYER_PLACED).build());
        ModelLoader.setCustomStateMapper(IafBlockRegistry.dread_stone_bricks, (new StateMap.Builder()).ignore(BlockDreadBase.PLAYER_PLACED).build());
        ModelLoader.setCustomStateMapper(IafBlockRegistry.dread_stone_bricks_chiseled, (new StateMap.Builder()).ignore(BlockDreadBase.PLAYER_PLACED).build());
        ModelLoader.setCustomStateMapper(IafBlockRegistry.dread_stone_bricks_cracked, (new StateMap.Builder()).ignore(BlockDreadBase.PLAYER_PLACED).build());
        ModelLoader.setCustomStateMapper(IafBlockRegistry.dread_stone_bricks_mossy, (new StateMap.Builder()).ignore(BlockDreadBase.PLAYER_PLACED).build());
        ModelLoader.setCustomStateMapper(IafBlockRegistry.dread_stone_tile, (new StateMap.Builder()).ignore(BlockDreadBase.PLAYER_PLACED).build());
        ModelLoader.setCustomStateMapper(IafBlockRegistry.dread_stone_face, (new StateMap.Builder()).ignore(BlockDreadStoneFace.PLAYER_PLACED).build());
        ModelLoader.setCustomStateMapper(IafBlockRegistry.dreadwood_planks, (new StateMap.Builder()).ignore(BlockDreadBase.PLAYER_PLACED).build());
        ModelLoader.setCustomStateMapper(IafBlockRegistry.dreadwood_planks_lock, (new StateMap.Builder()).ignore(BlockDreadWoodLock.PLAYER_PLACED).build());
        try {
            for (Field f : IafBlockRegistry.class.getDeclaredFields()) {
                Object obj = f.get(null);
                if (obj instanceof Block && !(obj instanceof ICustomRendered)) {
                    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock((Block) obj), 0, new ModelResourceLocation("iceandfire:" + ((Block) obj).getRegistryName().getPath(), "inventory"));
                } else if (obj instanceof Block[]) {
                    for (Block block : (Block[]) obj) {
                        if (!(block instanceof ICustomRendered)) {
                            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("iceandfire:" + block.getRegistryName().getPath(), "inventory"));

                        }
                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        TinkersCompatBridge.loadTinkersClientModels(event);
    }


    @SideOnly(Side.CLIENT)
    public static void renderDragonArmors(EnumDragonArmor armor) {
        ModelLoader.setCustomModelResourceLocation(armor.helmet, 0, new ModelResourceLocation("iceandfire:" + armor.name() + "_helmet", "inventory"));
        ModelLoader.setCustomModelResourceLocation(armor.chestplate, 0, new ModelResourceLocation("iceandfire:" + armor.name() + "_chestplate", "inventory"));
        ModelLoader.setCustomModelResourceLocation(armor.leggings, 0, new ModelResourceLocation("iceandfire:" + armor.name() + "_leggings", "inventory"));
        ModelLoader.setCustomModelResourceLocation(armor.boots, 0, new ModelResourceLocation("iceandfire:" + armor.name() + "_boots", "inventory"));
    }

    @SideOnly(Side.CLIENT)
    public static void renderSeaSerpentArmors(EnumSeaSerpent armor) {
        ModelLoader.setCustomModelResourceLocation(armor.scale, 0, new ModelResourceLocation("iceandfire:sea_serpent_scales_" + armor.resourceName, "inventory"));
        ModelLoader.setCustomModelResourceLocation(armor.helmet, 0, new ModelResourceLocation("iceandfire:tide_" + armor.resourceName + "_helmet", "inventory"));
        ModelLoader.setCustomModelResourceLocation(armor.chestplate, 0, new ModelResourceLocation("iceandfire:tide_" + armor.resourceName + "_chestplate", "inventory"));
        ModelLoader.setCustomModelResourceLocation(armor.leggings, 0, new ModelResourceLocation("iceandfire:tide_" + armor.resourceName + "_leggings", "inventory"));
        ModelLoader.setCustomModelResourceLocation(armor.boots, 0, new ModelResourceLocation("iceandfire:tide_" + armor.resourceName + "_boots", "inventory"));
    }

    public static MyrmexHive getReferedClientHive() {
        return referedClientHive;
    }

    public static void setReferedClientHive(MyrmexHive hive) {
        referedClientHive = hive;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void preRender() {
        TinkersCompatBridge.loadTinkersClientCompat();
    }

    @SideOnly(Side.CLIENT)
    @Override
    @SuppressWarnings("deprecation")
    public void render() {
        try{
            this.bestiaryFontRenderer = new FontRenderer(Minecraft.getMinecraft().gameSettings, new ResourceLocation("iceandfire:textures/font/bestiary.png"), Minecraft.getMinecraft().renderEngine, false);
            ((IReloadableResourceManager) Minecraft.getMinecraft().getResourceManager()).registerReloadListener(this.bestiaryFontRenderer);
        }catch(Exception e){
            this.bestiaryFontRenderer = Minecraft.getMinecraft().fontRenderer;
        }
        this.particleSpawner = new IceAndFireParticleSpawner();
        ((IReloadableResourceManager) Minecraft.getMinecraft().getResourceManager()).registerReloadListener(this.bestiaryFontRenderer);
        IafKeybindRegistry.init();
//        MinecraftForge.EVENT_BUS.register(new RenderModCapes());
        MinecraftForge.EVENT_BUS.register(new ClientEvents());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDummyGorgonHead.class, new RenderGorgonHead(false));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDummyGorgonHeadActive.class, new RenderGorgonHead(true));
        ForgeHooksClient.registerTESRItemStack(IafItemRegistry.gorgon_head, 0, TileEntityDummyGorgonHead.class);
        ForgeHooksClient.registerTESRItemStack(IafItemRegistry.gorgon_head, 1, TileEntityDummyGorgonHeadActive.class);
        renderEntities();


    }

    @SideOnly(Side.CLIENT)
    public void postRender() {
        ClientEvents.initializeStoneLayer();
        for (EnumTroll.Weapon weapon : EnumTroll.Weapon.values()) {
            weapon.item.setTileEntityItemStackRenderer(TEISR);
        }
        IafItemRegistry.deathworm_gauntlet_yellow.setTileEntityItemStackRenderer(TEISR);
        IafItemRegistry.deathworm_gauntlet_white.setTileEntityItemStackRenderer(TEISR);
        IafItemRegistry.deathworm_gauntlet_red.setTileEntityItemStackRenderer(TEISR);
        Item.getItemFromBlock(IafBlockRegistry.dread_portal).setTileEntityItemStackRenderer(TEISR);

    }

    @SuppressWarnings("deprecation")
    @SideOnly(Side.CLIENT)
    private void renderEntities() {
        EnumDragonAnimations.initializeDragonModels();
        EnumSeaSerpentAnimations.initializeSerpentModels();
        ModelBase firedragon_model = null;
        ModelBase icedragon_model = null;
        ModelBase seaserpent_model = null;

        try {
            firedragon_model = new IceAndFireTabulaModel(INSTANCE.loadTabulaModel("/assets/iceandfire/models/tabula/firedragon/dragonFireGround"), new FireDragonTabulaModelAnimator());
            icedragon_model = new IceAndFireTabulaModel(INSTANCE.loadTabulaModel("/assets/iceandfire/models/tabula/icedragon/dragonIceGround"), new IceDragonTabulaModelAnimator());
            seaserpent_model = new IceAndFireTabulaModel(INSTANCE.loadTabulaModel("/assets/iceandfire/models/tabula/seaserpent/seaserpent"), new SeaSerpentTabulaModelAnimator());
        } catch (IOException e) {
            e.printStackTrace();
        }
        RenderingRegistry.registerEntityRenderingHandler(EntityFireDragon.class, new RenderDragonBase(Minecraft.getMinecraft().getRenderManager(), firedragon_model, true));
        RenderingRegistry.registerEntityRenderingHandler(EntityIceDragon.class, new RenderDragonBase(Minecraft.getMinecraft().getRenderManager(), icedragon_model, false));
        RenderingRegistry.registerEntityRenderingHandler(EntityDragonEgg.class, new RenderDragonEgg(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityDragonArrow.class, new RenderDragonArrow(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityDragonSkull.class, new RenderDragonSkull(Minecraft.getMinecraft().getRenderManager(), firedragon_model, icedragon_model));
        RenderingRegistry.registerEntityRenderingHandler(EntityDragonFireCharge.class, new RenderDragonFireCharge(Minecraft.getMinecraft().getRenderManager(), true));
        RenderingRegistry.registerEntityRenderingHandler(EntityDragonIceCharge.class, new RenderDragonFireCharge(Minecraft.getMinecraft().getRenderManager(), false));
        RenderingRegistry.registerEntityRenderingHandler(EntitySnowVillager.class, new RenderSnowVillager(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityHippogryphEgg.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), IafItemRegistry.hippogryph_egg, Minecraft.getMinecraft().getRenderItem()));
        RenderingRegistry.registerEntityRenderingHandler(EntityHippogryph.class, new RenderHippogryph(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityStoneStatue.class, new RenderStoneStatue(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityGorgon.class, new RenderGorgon(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityPixie.class, new RenderPixie(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityCyclops.class, new RenderCyclops(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntitySiren.class, new RenderSiren(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityHippocampus.class, new RenderHippocampus(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityDeathWorm.class, new RenderDeathWorm(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityDeathWormEgg.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), IafItemRegistry.deathworm_egg, Minecraft.getMinecraft().getRenderItem()));
        RenderingRegistry.registerEntityRenderingHandler(EntityCockatrice.class, new RenderCockatrice(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityCockatriceEgg.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), IafItemRegistry.rotten_egg, Minecraft.getMinecraft().getRenderItem()));
        RenderingRegistry.registerEntityRenderingHandler(EntityStymphalianBird.class, new RenderStymphalianBird(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityStymphalianFeather.class, new RenderStymphalianFeather(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityStymphalianArrow.class, new RenderStymphalianArrow(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityTroll.class, new RenderTroll(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityMyrmexWorker.class, new RenderMyrmexBase(Minecraft.getMinecraft().getRenderManager(), new ModelMyrmexWorker(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityMyrmexSoldier.class, new RenderMyrmexBase(Minecraft.getMinecraft().getRenderManager(), new ModelMyrmexSoldier(), 0.75F));
        RenderingRegistry.registerEntityRenderingHandler(EntityMyrmexQueen.class, new RenderMyrmexBase(Minecraft.getMinecraft().getRenderManager(), new ModelMyrmexQueen(), 1.25F));
        RenderingRegistry.registerEntityRenderingHandler(EntityMyrmexEgg.class, new RenderMyrmexEgg(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityMyrmexSentinel.class, new RenderMyrmexBase(Minecraft.getMinecraft().getRenderManager(), new ModelMyrmexSentinel(), 0.85F));
        RenderingRegistry.registerEntityRenderingHandler(EntityMyrmexRoyal.class, new RenderMyrmexBase(Minecraft.getMinecraft().getRenderManager(), new ModelMyrmexRoyal(), 0.75F));
        RenderingRegistry.registerEntityRenderingHandler(EntityMyrmexSwarmer.class, new RenderMyrmexBase(Minecraft.getMinecraft().getRenderManager(), new ModelMyrmexRoyal(), 0.25F));
        RenderingRegistry.registerEntityRenderingHandler(EntityAmphithere.class, new RenderAmphithere(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityAmphithereArrow.class, new RenderAmphithereArrow(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntitySeaSerpent.class, new RenderSeaSerpent(Minecraft.getMinecraft().getRenderManager(), seaserpent_model));
        RenderingRegistry.registerEntityRenderingHandler(EntitySeaSerpentBubbles.class, new RenderNothing(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntitySeaSerpentArrow.class, new RenderSeaSerpentArrow(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityChainTie.class, new RenderChainTie(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityPixieCharge.class, new RenderNothing(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityTideTrident.class, new RenderTideTrident(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityMobSkull.class, new RenderMobSkull(Minecraft.getMinecraft().getRenderManager(), seaserpent_model));
        RenderingRegistry.registerEntityRenderingHandler(EntityDreadThrall.class, new RenderDreadThrall(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityDreadGhoul.class, new RenderDreadGhoul(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityDreadBeast.class, new RenderDreadBeast(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityDreadScuttler.class, new RenderDreadScuttler(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityDreadLich.class, new RenderDreadLich(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityDreadLichSkull.class, new RenderDreadLichSkull(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityDreadKnight.class, new RenderDreadKnight(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityDreadHorse.class, new RenderDreadHorse(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityBlackFrostDragon.class, new RenderBlackFrostDragon(Minecraft.getMinecraft().getRenderManager(), icedragon_model, false));
        RenderingRegistry.registerEntityRenderingHandler(EntityDreadQueen.class, new RenderDreadQueen(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityHydra.class, new RenderHydra(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityHydraBreath.class, new RenderNothing(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityHydraArrow.class, new RenderHydraArrow(Minecraft.getMinecraft().getRenderManager()));

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPodium.class, new RenderPodium());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLectern.class, new RenderLectern());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEggInIce.class, new RenderEggInIce());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPixieHouse.class, new RenderPixieHouse());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityJar.class, new RenderJar());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDreadPortal.class, new RenderDreadPortal());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDreadSpawner.class, new RenderDreadSpawner());
        ForgeHooksClient.registerTESRItemStack(Item.getItemFromBlock(IafBlockRegistry.pixieHouse), 0, TileEntityPixieHouse.class);
        ForgeHooksClient.registerTESRItemStack(Item.getItemFromBlock(IafBlockRegistry.pixieHouse), 1, TileEntityPixieHouse.class);
        ForgeHooksClient.registerTESRItemStack(Item.getItemFromBlock(IafBlockRegistry.pixieHouse), 2, TileEntityPixieHouse.class);
        ForgeHooksClient.registerTESRItemStack(Item.getItemFromBlock(IafBlockRegistry.pixieHouse), 3, TileEntityPixieHouse.class);
        ForgeHooksClient.registerTESRItemStack(Item.getItemFromBlock(IafBlockRegistry.pixieHouse), 4, TileEntityPixieHouse.class);
        ForgeHooksClient.registerTESRItemStack(Item.getItemFromBlock(IafBlockRegistry.pixieHouse), 5, TileEntityPixieHouse.class);

    }

    @SideOnly(Side.CLIENT)
    public void spawnDragonParticle(String name, double x, double y, double z, double motX, double motY, double motZ, EntityDragonBase entityDragonBase) {
        World world = Minecraft.getMinecraft().world;
        if (world == null) {
            return;
        }
        net.minecraft.client.particle.Particle particle = null;
        if (name.equals("dragonfire")) {
            particle = new ParticleDragonFlame(world, x, y, z, motX, motY, motZ, entityDragonBase, 0);
        }
        if (name.equals("dragonice")) {
            particle = new ParticleDragonFrost(world, x, y, z, motX, motY, motZ, entityDragonBase, 0);
        }
        if (particle != null) {
            particleSpawner.spawnParticle(particle, true, true, false, x, y, z);
        }
    }

    @SideOnly(Side.CLIENT)
    public void spawnParticle(String name, double x, double y, double z, double motX, double motY, double motZ, float size) {
        World world = Minecraft.getMinecraft().world;
        if (world == null) {
            return;
        }
        net.minecraft.client.particle.Particle particle = null;
        if (name.equals("dragonfire")) {
            particle = new ParticleDragonFlame(world, x, y, z, motX, motY, motZ, size);
        }
        if (name.equals("dragonice")) {
            particle = new ParticleDragonFrost(world, x, y, z, motX, motY, motZ, size);
        }
        if (name.equals("dread_torch")) {
            particle = new ParticleDreadTorch(world, x, y, z, motX, motY, motZ, size);
        }
        if (name.equals("dread_portal")) {
            particle = new ParticleDreadPortal(world, x, y, z, motX, motY, motZ, size);
        }
        if (name.equals("blood")) {
            particle = new ParticleBlood(world, x, y, z);
        }
        if (name.equals("if_pixie")) {
            particle = new ParticlePixieDust(world, x, y, z, (float) motX, (float) motY, (float) motZ);
        }
        if (name.equals("siren_appearance")) {
            particle = new ParticleSirenAppearance(world, x, y, z);
        }
        if (name.equals("siren_music")) {
            particle = new ParticleSirenMusic(world, x, y, z, motX, motY, motZ);
        }
        if (name.equals("serpent_bubble")) {
            particle = new ParticleSerpentBubble(world, x, y, z, motX, motY, motZ);
        }
        if (name.equals("hydra")) {
            particle = new ParticleHydraBreath(world, x, y, z, (float) motX, (float) motY, (float) motZ);
        }
        if (particle != null) {
            particleSpawner.spawnParticle(particle, false, false, false, x, y, z);
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void openBestiaryGui(ItemStack book) {
        Minecraft.getMinecraft().displayGuiScreen(new GuiBestiary(book));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void openMyrmexStaffGui(ItemStack staff) {
        Minecraft.getMinecraft().displayGuiScreen(new GuiMyrmexStaff(staff));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void openMyrmexAddRoomGui(ItemStack staff, BlockPos pos, EnumFacing facing) {
        Minecraft.getMinecraft().displayGuiScreen(new GuiMyrmexAddRoom(staff, pos, facing));
    }

    @SideOnly(Side.CLIENT)
    public Object getArmorModel(int armorId) {
        switch (armorId) {
            case 0:
                return FIRE_DRAGON_SCALE_ARMOR_MODEL;
            case 1:
                return FIRE_DRAGON_SCALE_ARMOR_MODEL_LEGS;
            case 2:
                return ICE_DRAGON_SCALE_ARMOR_MODEL;
            case 3:
                return ICE_DRAGON_SCALE_ARMOR_MODEL_LEGS;
            case 4:
                return DEATHWORM_ARMOR_MODEL;
            case 5:
                return DEATHWORM_ARMOR_MODEL_LEGS;
            case 6:
                return TROLL_ARMOR_MODEL;
            case 7:
                return TROLL_ARMOR_MODEL_LEGS;
            case 8:
                return TIDE_ARMOR_MODEL;
            case 9:
                return TIDE_ARMOR_MODEL_LEGS;
            case 10:
                return DRAGONSTEEL_FIRE_ARMOR_MODEL;
            case 11:
                return DRAGONSTEEL_FIRE_ARMOR_MODEL_LEGS;
            case 12:
                return DRAGONSTEEL_ICE_ARMOR_MODEL;
            case 13:
                return DRAGONSTEEL_ICE_ARMOR_MODEL_LEGS;
            case 14:
                return SILVER_ARMOR_MODEL;
            case 15:
                return SILVER_ARMOR_MODEL_LEGS;
        }
        return null;
    }

    public Object getFontRenderer() {
        return this.bestiaryFontRenderer;
    }

    public int getDragon3rdPersonView() {
        return thirdPersonViewDragon;
    }

    public void setDragon3rdPersonView(int view) {
        thirdPersonViewDragon = view;
    }

    public Object getDreadlandsRender(int i) {
        if(i == 0){
            return dreadlandsSkyRenderer;
        }
        if(i == 1){
            return dreadlandsWeatherRenderer;
        }
        if(i == 2){
            return dreadlandsAuroraRender;
        }
        return null;
    }

    public int getPreviousViewType() {
        return previousViewType;
    }

    public void setPreviousViewType(int view) {
        previousViewType = view;
    }

    public void updateDragonArmorRender(String clear){
        LayerDragonArmor.clearCache(clear);
    }

    public boolean shouldSeeBestiaryContents() {
        return Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT);
    }
}
