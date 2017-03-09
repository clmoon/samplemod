package duramod.samplemod;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;

/**
 * @author durandal
 */
@Mod(modid = SampleMod.MOD_ID, version = SampleMod.VERSION, dependencies = SampleMod.DEPENDENCIES, acceptedMinecraftVersions = SampleMod.REQUIRED_MC_VERSION, useMetadata = true)
public class SampleMod {
	/** MOD ID */
	public static final String MOD_ID = "samplemod";
	/** MODバージョン */
	public static final String VERSION = "1.0";
	/** 依存するライブラリ */
	public static final String DEPENDENCIES = "required-after:forge@[1.11-13.19.0.2238,)";
	/** 依存するMCバージョン */
	public static final String REQUIRED_MC_VERSION = "[1.11]";

	@ObjectHolder(MOD_ID)
	public static class ITEMS {
		public static Item sampleItem = null;
	}

	@SubscribeEvent
	protected static void registerItems(RegistryEvent.Register<Item> event) {
		System.out.println("##### registerItems");
		ITEMS.sampleItem = new Item();
		// 登録名を設定
		ITEMS.sampleItem.setRegistryName(MOD_ID, "SAMPLE_ITEM");
		// クリエイティブタブに登録
		ITEMS.sampleItem.setCreativeTab(CreativeTabs.MISC);
		// 翻訳キーを登録
		ITEMS.sampleItem.setUnlocalizedName("sample");
		// アイテムを登録
		event.getRegistry().registerAll(ITEMS.sampleItem);
		/* .setHasSubtypes(true) *//* ダメージ値等で複数の種類のアイテムを分けているかどうか。デフォルトfalse */
		/* .setMaxDamage(256) *//* 耐久値の設定。デフォルト0 */
		/* .setFull3D() *//* 3D表示で描画させる。ツールや骨、棒等。 */
		/* .setContainerItem(Items.stick) *//* クラフト時にアイテムを返却できるようにしている際の返却アイテムの指定。 */
		/* .setPotionEffect(PotionHelper.ghastTearEffect) *//*
															 * 指定文字列に対応した素材として醸造台で使える
															 * 。
															 * PotionHelper参照のこと。
															 */
		/* .setNoRepair() *//* 修理レシピを削除し、金床での修繕を出来なくする */
		/* .setMaxStackSize(64) *//* スタックできる量。デフォルト64 */
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println("##### preInit");
		if (event.getSide() == Side.CLIENT) {
			ModelLoader.setCustomModelResourceLocation(ITEMS.sampleItem, 0,
					new ModelResourceLocation(ITEMS.sampleItem.getRegistryName(), "inventory"));
		}
	}
}
