package com.knoxhack.energyarsenal;

import com.knoxhack.energyarsenal.common.ProxyCommon;
import com.knoxhack.energyarsenal.crafting.ModCrafting;
import com.knoxhack.energyarsenal.creativetab.CreativeTabTeslaArsenal;
import com.knoxhack.energyarsenal.item.*;

import net.minecraft.item.ItemArmor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.inventory.EntityEquipmentSlot;



@Mod(modid = "energyarsenal", name = "Energy Arsenal", version = "1.0",dependencies = "required-after:Forge", updateJSON = "https://raw.githubusercontent.com/knoxhack/Tesla-Arsenal/master/update.json")
public class Main {
    
    @SidedProxy(serverSide = "com.knoxhack.energyarsenal.common.ProxyCommon", clientSide = "com.knoxhack.energyarsenal.client.ProxyClient")
    public static ProxyCommon proxy;
    
    @Mod.Instance("energyarsenal")
    public static Main instance;
    public static CreativeTabs tab;
    public static Item itemteslawrench,itemnetherstardust,itemteslariumdust,itemteslariumingot,itemtoolhandle;
	public static Main MODID;
	ToolMaterial WOODTOOL;
	
	
	//Armor Plates
	public static Item itemdarksteelplate;
	public static Item itemdarksteelingot;
	public static Item itemcomponent;

	
	//Armor Plates
	public static Item coreTesla;
	public static Item coreRF;
	public static Item coreFE;

	
	public static Item itemcapacitorRF;
	public static Item itemcapacitorTier2RF;
	public static Item itemcapacitorTier3RF;
	public static Item itemcapacitorCreativeRF;
	//Capacitor Tier 1
	public static Item itemcapacitorTesla;
	public static Item itemcapacitorFE;
	//Capacitor Tier 2
	public static Item itemcapacitorTier2Tesla;
	public static Item itemcapacitorTier2FE;
	//Capacitor Tier 3
	public static Item itemcapacitorTier3Tesla;
	public static Item itemcapacitorTier3FE;
	//Capacitor Creative
	public static Item itemcapacitorCreativeTesla;
	public static Item itemcapacitorCreativeFE;
	

	//Armor (Helmet)
	public static Item teslaArmorHelmet;
	public static Item rfArmorHelmet;
	public static Item feArmorHelmet;
	//Armor (Chestplate)
	public static Item teslaArmorChestplate;
	public static Item rfArmorChestplate;
	public static Item feArmorChestplate;
	//Armor (Leggings)
	public static Item teslaArmorLeggings;
	public static Item rfArmorLeggings;
	public static Item feArmorLeggings;
	//Armor (Boots)
	public static Item teslaArmorBoots;
	public static Item rfArmorBoots;
	public static Item feArmorBoots;
	
	
	//Tools (Redstone Flux)
	public static Item itemrfpickaxe;
	public static Item itemrfaxe;
	public static Item itemrfshovel;
	public static Item itemrfhoe;
	public static Item itemrfsword;
	//Tools (Forge Energy)
	public static Item itemfepickaxe;
	public static Item itemfeaxe;
	public static Item itemfeshovel;
	public static Item itemfehoe;
	public static Item itemfesword;

	//Tools (Tesla)
	public static Item itemteslapickaxe;
	public static Item itemteslaaxe;
	public static Item itemteslashovel;
	public static Item itemteslahoe;
	public static Item itemteslasword;
	
	
    @EventHandler
    public void preInit (FMLPreInitializationEvent event) {
      
        tab = new CreativeTabTeslaArsenal();
        
        //Tools (Tesla)
        itemteslapickaxe = registerItem(new ItemTeslaPickaxe());
        itemteslaaxe = registerItem(new ItemTeslaAxe());
        itemteslashovel = registerItem(new ItemTeslaShovel());
        itemteslahoe = registerItem(new ItemTeslaHoe());
        itemteslasword = registerItem(new ItemTeslaSword(WOODTOOL.DIAMOND));
        //Tools (Redstone Flux)
         itemrfpickaxe = registerItem(new ItemRFPickaxe());
         itemrfaxe = registerItem(new ItemRFAxe());
         itemrfshovel = registerItem(new ItemRFShovel());
         itemrfhoe = registerItem(new ItemRFHoe());
          itemrfsword = registerItem(new ItemRFSword(WOODTOOL.DIAMOND));
      
      
    	//Tools (Forge Energy)
        itemfepickaxe = registerItem(new ItemFEPickaxe());
        itemfeaxe = registerItem(new ItemFEAxe());
        itemfeshovel = registerItem(new ItemFEShovel());
        itemfehoe = registerItem(new ItemFEHoe());
        itemfesword = registerItem(new ItemFESword(WOODTOOL.DIAMOND));
        
    	//Items
       // itemnetherstardust = registerItem(new ItemNetherStarDust());
       // itemteslariumdust = registerItem(new ItemTeslariumDust());
       // itemteslariumingot = registerItem(new ItemTeslariumIngot());
        itemtoolhandle = registerItem(new ItemToolHandle());
        itemteslawrench = registerItem(new ItemToolWrench());
        
        //Capacitor Tier 1
       itemcapacitorTesla = registerItem(new ItemTeslaCapacitor1());
       itemcapacitorFE = registerItem(new ItemFECapacitor1());
        
        //Capacitor Tier 2
      itemcapacitorTier2Tesla = registerItem(new ItemTeslaCapacitor2());
       itemcapacitorTier2FE = registerItem(new ItemFECapacitor2());
        
        //Capacitor Tier 3
       itemcapacitorTier3Tesla = registerItem(new ItemTeslaCapacitor3());
       itemcapacitorTier3FE = registerItem(new ItemFECapacitor3());
        
        //Capacitor Creative
       itemcapacitorCreativeTesla = registerItem(new ItemTeslaCapacitorCreative());
       itemcapacitorCreativeFE = registerItem(new ItemFECapacitorCreative());
       
       
       itemcapacitorRF = registerItem(new ItemRFCapacitor1());
       itemcapacitorTier2RF = registerItem(new ItemRFCapacitor2());
       itemcapacitorTier3RF = registerItem(new ItemRFCapacitor3());
       itemcapacitorCreativeRF = registerItem(new ItemRFCapacitorCreative());

       
        
       //Dark Steel
       itemdarksteelplate = registerItem(new ItemDarkSteelPlate());
       itemdarksteelingot = registerItem(new ItemDarkSteelIngot());
       itemcomponent = registerItem(new ItemComponent());
       
       
       
       
       

    	//Armor (Helmet)(Tesla)
        teslaArmorHelmet = new ItemTeslaEnergizedArmor(ItemArmor.ArmorMaterial.DIAMOND, EntityEquipmentSlot.HEAD, 10000, 200,
				200).setRegistryName("teslaenergizedarmour.helmet");
		GameRegistry.register(teslaArmorHelmet);
		
    	//Armor (Helmet)(Redstone Flux)
        rfArmorHelmet = new ItemRFEnergizedArmor(ItemArmor.ArmorMaterial.DIAMOND, EntityEquipmentSlot.HEAD, 10000, 200,
				200).setRegistryName("rfenergizedarmour.helmet");
		GameRegistry.register(rfArmorHelmet);
		
    	//Armor (Helmet)(Forge Energy)
        feArmorHelmet = new ItemFEEnergizedArmor(ItemArmor.ArmorMaterial.DIAMOND, EntityEquipmentSlot.HEAD, 10000, 200,
				200).setRegistryName("feenergizedarmour.helmet");
		GameRegistry.register(feArmorHelmet);
		
		
    	//Armor (Chestplate)(Tesla)
		teslaArmorChestplate = new ItemTeslaEnergizedArmor(ItemArmor.ArmorMaterial.DIAMOND, EntityEquipmentSlot.CHEST, 10000,
				200, 200).setRegistryName("teslaenergizedarmour.chestplate");
		GameRegistry.register(teslaArmorChestplate);
		
    	//Armor (Chestplate)(Redstone Flux)
		rfArmorChestplate = new ItemRFEnergizedArmor(ItemArmor.ArmorMaterial.DIAMOND, EntityEquipmentSlot.CHEST, 10000,
				200, 200).setRegistryName("rfenergizedarmour.chestplate");
		GameRegistry.register(rfArmorChestplate);
		
    	//Armor (Chestplate)(Forge Energy)
		feArmorChestplate = new ItemFEEnergizedArmor(ItemArmor.ArmorMaterial.DIAMOND, EntityEquipmentSlot.CHEST, 10000,
				200, 200).setRegistryName("feenergizedarmour.chestplate");
		GameRegistry.register(feArmorChestplate);
		

    	//Armor (Leggings)(Tesla)
		teslaArmorLeggings = new ItemTeslaEnergizedArmor(ItemArmor.ArmorMaterial.DIAMOND, EntityEquipmentSlot.LEGS, 10000,
				200, 200).setRegistryName("teslaenergizedarmour.leggings");
		GameRegistry.register(teslaArmorLeggings);
		
    	//Armor (Leggings)(Redstone Flux)
		rfArmorLeggings = new ItemRFEnergizedArmor(ItemArmor.ArmorMaterial.DIAMOND, EntityEquipmentSlot.LEGS, 10000,
				200, 200).setRegistryName("rfenergizedarmour.leggings");
		GameRegistry.register(rfArmorLeggings);
		
    	//Armor (Leggings)(Forge Energy)
		feArmorLeggings = new ItemFEEnergizedArmor(ItemArmor.ArmorMaterial.DIAMOND, EntityEquipmentSlot.LEGS, 10000,
				200, 200).setRegistryName("feenergizedarmour.leggings");
		GameRegistry.register(feArmorLeggings);
		
		
		
    	//Armor (Boots)(Tesla)
		teslaArmorBoots = new ItemTeslaEnergizedArmor(ItemArmor.ArmorMaterial.DIAMOND, EntityEquipmentSlot.FEET, 10000, 200,
				200).setRegistryName("teslaenergizedarmour.boots");
		GameRegistry.register(teslaArmorBoots);
		
    	//Armor (Boots)(Redstone Flux)
		rfArmorBoots = new ItemRFEnergizedArmor(ItemArmor.ArmorMaterial.DIAMOND, EntityEquipmentSlot.FEET, 10000, 200,
				200).setRegistryName("rfenergizedarmour.boots");
		GameRegistry.register(rfArmorBoots);
		
    	//Armor (Boots)(Forge Energy)
		feArmorBoots = new ItemFEEnergizedArmor(ItemArmor.ArmorMaterial.DIAMOND, EntityEquipmentSlot.FEET, 10000, 200,
				200).setRegistryName("feenergizedarmour.boots");
		GameRegistry.register(feArmorBoots);
		
        
        proxy.preInit();
    }
	public static Item registerItem (Item item) {
        GameRegistry.register(item);
        return item;
    }
    
    public static boolean hasTesla() {
        return Loader.isModLoaded("tesla");
    }
    
    @EventHandler
    public void init(FMLInitializationEvent e) {
    	
        ModCrafting.initCrafting();

    }
    }
