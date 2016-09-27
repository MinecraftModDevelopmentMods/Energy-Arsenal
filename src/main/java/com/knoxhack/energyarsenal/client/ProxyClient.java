package com.knoxhack.energyarsenal.client;

import com.knoxhack.energyarsenal.Main;
import com.knoxhack.energyarsenal.common.ProxyCommon;
import com.knoxhack.energyarsenal.crafting.ModCrafting;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class ProxyClient extends ProxyCommon {
    
    @Override
    public void preInit () {
        
       // ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(TeslaArsenal.blockCharger), 0, new ModelResourceLocation(TeslaArsenal.blockCharger.getRegistryName(), "inventory"));
      
    //Tesla tools     
    ModelLoader.setCustomModelResourceLocation(Main.itemteslapickaxe, 0, new ModelResourceLocation(Main.itemteslapickaxe.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(Main.itemteslashovel, 0, new ModelResourceLocation(Main.itemteslashovel.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(Main.itemteslasword, 0, new ModelResourceLocation(Main.itemteslasword.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(Main.itemteslaaxe, 0, new ModelResourceLocation(Main.itemteslaaxe.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(Main.itemteslahoe, 0, new ModelResourceLocation(Main.itemteslahoe.getRegistryName(), "inventory"));

    //RF Tools
    ModelLoader.setCustomModelResourceLocation(Main.itemrfpickaxe, 0, new ModelResourceLocation(Main.itemrfpickaxe.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(Main.itemrfshovel, 0, new ModelResourceLocation(Main.itemrfshovel.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(Main.itemrfsword, 0, new ModelResourceLocation(Main.itemrfsword.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(Main.itemrfaxe, 0, new ModelResourceLocation(Main.itemrfaxe.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(Main.itemrfhoe, 0, new ModelResourceLocation(Main.itemrfhoe.getRegistryName(), "inventory"));

    //FE Tools
    ModelLoader.setCustomModelResourceLocation(Main.itemfepickaxe, 0, new ModelResourceLocation(Main.itemfepickaxe.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(Main.itemfeshovel, 0, new ModelResourceLocation(Main.itemfeshovel.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(Main.itemfesword, 0, new ModelResourceLocation(Main.itemfesword.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(Main.itemfeaxe, 0, new ModelResourceLocation(Main.itemfeaxe.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(Main.itemfehoe, 0, new ModelResourceLocation(Main.itemfehoe.getRegistryName(), "inventory"));

    
    //Tesla Armor
    ModelLoader.setCustomModelResourceLocation(Main.teslaArmorHelmet, 0, new ModelResourceLocation(Main.teslaArmorHelmet.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(Main.teslaArmorBoots, 0, new ModelResourceLocation(Main.teslaArmorBoots.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(Main.teslaArmorChestplate, 0, new ModelResourceLocation(Main.teslaArmorChestplate.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(Main.teslaArmorLeggings, 0, new ModelResourceLocation(Main.teslaArmorLeggings.getRegistryName(), "inventory"));

    //RF Armor
    ModelLoader.setCustomModelResourceLocation(Main.rfArmorHelmet, 0, new ModelResourceLocation(Main.rfArmorHelmet.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(Main.rfArmorBoots, 0, new ModelResourceLocation(Main.rfArmorBoots.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(Main.rfArmorChestplate, 0, new ModelResourceLocation(Main.rfArmorChestplate.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(Main.rfArmorLeggings, 0, new ModelResourceLocation(Main.rfArmorLeggings.getRegistryName(), "inventory"));

    //FE Armor
    ModelLoader.setCustomModelResourceLocation(Main.feArmorHelmet, 0, new ModelResourceLocation(Main.feArmorHelmet.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(Main.feArmorBoots, 0, new ModelResourceLocation(Main.feArmorBoots.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(Main.feArmorChestplate, 0, new ModelResourceLocation(Main.feArmorChestplate.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(Main.feArmorLeggings, 0, new ModelResourceLocation(Main.feArmorLeggings.getRegistryName(), "inventory"));

    //Items
    ModelLoader.setCustomModelResourceLocation(Main.itemdarksteelingot, 0, new ModelResourceLocation(Main.itemdarksteelingot.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(Main.itemdarksteelplate, 0, new ModelResourceLocation(Main.itemdarksteelplate.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(Main.itemcomponent, 0, new ModelResourceLocation(Main.itemcomponent.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(Main.itemtoolhandle, 0, new ModelResourceLocation(Main.itemtoolhandle.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(Main.itemteslawrench, 0, new ModelResourceLocation(Main.itemteslawrench.getRegistryName(), "inventory"));

    //Capacitors RF
    ModelLoader.setCustomModelResourceLocation(Main.itemcapacitorRF, 0, new ModelResourceLocation(Main.itemcapacitorRF.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(Main.itemcapacitorTier2RF, 0, new ModelResourceLocation(Main.itemcapacitorTier2RF.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(Main.itemcapacitorTier3RF, 0, new ModelResourceLocation(Main.itemcapacitorTier3RF.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(Main.itemcapacitorCreativeRF, 0, new ModelResourceLocation(Main.itemcapacitorCreativeRF.getRegistryName(), "inventory"));
    
    //Capacitors Tesla
    ModelLoader.setCustomModelResourceLocation(Main.itemcapacitorTesla, 0, new ModelResourceLocation(Main.itemcapacitorTesla.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(Main.itemcapacitorTier2Tesla, 0, new ModelResourceLocation(Main.itemcapacitorTier2Tesla.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(Main.itemcapacitorTier3Tesla, 0, new ModelResourceLocation(Main.itemcapacitorTier3Tesla.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(Main.itemcapacitorCreativeTesla, 0, new ModelResourceLocation(Main.itemcapacitorCreativeTesla.getRegistryName(), "inventory"));
    
    //Capacitors Forge Energy
    ModelLoader.setCustomModelResourceLocation(Main.itemcapacitorFE, 0, new ModelResourceLocation(Main.itemcapacitorFE.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(Main.itemcapacitorTier2FE, 0, new ModelResourceLocation(Main.itemcapacitorTier2FE.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(Main.itemcapacitorTier3FE, 0, new ModelResourceLocation(Main.itemcapacitorTier3FE.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(Main.itemcapacitorCreativeFE, 0, new ModelResourceLocation(Main.itemcapacitorCreativeFE.getRegistryName(), "inventory"));
    
    
    
    
    }
    
    

    
    
    
    
    
    
    
}
