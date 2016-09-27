package com.knoxhack.energyarsenal.crafting;

import com.knoxhack.energyarsenal.Main;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;
public final class ModCrafting {

	public static void initCrafting() {

		
		GameRegistry.addRecipe(new ItemStack(Main.itemcomponent, 1), new Object[] {" # ", "ICI", " # ", '#', Items.REDSTONE, 'I', new ItemStack(Items.DYE, 1, 4),'C',Items.GOLD_INGOT});

		GameRegistry.addRecipe(new ItemStack(Main.itemdarksteelingot, 1), new Object[] {" # ", "CIC", " # ", '#', Items.IRON_INGOT, 'I',Items.COAL, 'C',Blocks.OBSIDIAN});
		GameRegistry.addRecipe(new ItemStack(Main.itemdarksteelplate, 3), new Object[] {"## ", "## ", "   ", '#', Main.itemdarksteelingot});

		GameRegistry.addRecipe(new ItemStack(Main.itemcapacitorRF, 1), new Object[] {"C#C", "#I#", "C#C", '#', Items.REDSTONE, 'I',Main.itemcomponent, 'C',Blocks.GLASS});
		//GameRegistry.addRecipe(new ItemStack(Main.itemcapacitorFE, 1), new Object[] {"C#C", "#I#", "C#C", '#', Items.GOLD_INGOT, 'I',Main.itemcomponent, 'C',Blocks.GLASS});
		GameRegistry.addRecipe(new ItemStack(Main.itemcapacitorTesla, 1), new Object[] {"C#C", "#I#", "C#C", '#', new ItemStack(Items.DYE, 1, 4), 'I',Main.itemcomponent, 'C',Blocks.GLASS});
		GameRegistry.addRecipe(new ItemStack(Main.itemcapacitorTier2RF, 1), new Object[] {"C#C", "#I#", "C#C", '#', Blocks.REDSTONE_BLOCK, 'I',Main.itemcomponent, 'C',Blocks.GLASS});
		//GameRegistry.addRecipe(new ItemStack(Main.itemcapacitorTier2FE, 1), new Object[] {"C#C", "#I#", "C#C", '#', Blocks.GOLD_BLOCK, 'I',Main.itemcomponent, 'C',Blocks.GLASS});
		GameRegistry.addRecipe(new ItemStack(Main.itemcapacitorTier2Tesla, 1), new Object[] {"C#C", "#I#", "C#C", '#', Blocks.LAPIS_BLOCK, 'I',Main.itemcomponent, 'C',Blocks.GLASS});
		GameRegistry.addRecipe(new ItemStack(Main.itemcapacitorTier3RF, 1), new Object[] {"C#C", "#I#", "C#C", '#', Blocks.REDSTONE_BLOCK, 'I',Main.itemcomponent, 'C',Blocks.IRON_BLOCK});
		//GameRegistry.addRecipe(new ItemStack(Main.itemcapacitorTier3FE, 1), new Object[] {"C#C", "#I#", "C#C", '#', Blocks.GOLD_BLOCK, 'I',Main.itemcomponent, 'C',Blocks.IRON_BLOCK});
		GameRegistry.addRecipe(new ItemStack(Main.itemcapacitorTier3Tesla, 1), new Object[] {"C#C", "#I#", "C#C", '#', Blocks.LAPIS_BLOCK, 'I',Main.itemcomponent, 'C',Blocks.IRON_BLOCK});

		
		
		GameRegistry.addRecipe(new ItemStack(Main.itemteslapickaxe, 1), new Object[] {"###", " C ", " I ", '#', Main.itemdarksteelingot, 'I',Main.itemtoolhandle, 'C',Main.itemcapacitorTesla});
		GameRegistry.addRecipe(new ItemStack(Main.itemteslaaxe, 1), new Object[] {"## ", "#C ", " I ", '#', Main.itemdarksteelingot, 'I',Main.itemtoolhandle, 'C',Main.itemcapacitorTesla});
		GameRegistry.addRecipe(new ItemStack(Main.itemteslashovel, 1), new Object[] {" # ", " C ", " I ", '#',Main.itemdarksteelingot, 'I',Main.itemtoolhandle, 'C',Main.itemcapacitorTesla});
		GameRegistry.addRecipe(new ItemStack(Main.itemteslasword, 1), new Object[] {" # ", " C ", " I ", '#', Main.itemdarksteelingot, 'I',Main.itemtoolhandle, 'C',Main.itemcapacitorTesla});
		GameRegistry.addRecipe(new ItemStack(Main.itemteslahoe, 1), new Object[] {"## ", " C ", " I ", '#', Main.itemdarksteelingot, 'I',Main.itemtoolhandle, 'C',Main.itemcapacitorTesla});

		
		
		
		
		GameRegistry.addRecipe(new ItemStack(Main.itemrfpickaxe, 1), new Object[] {"###", " C ", " I ", '#', Main.itemdarksteelingot, 'I',Main.itemtoolhandle, 'C',Main.itemcapacitorRF});
		GameRegistry.addRecipe(new ItemStack(Main.itemrfaxe, 1), new Object[] {"## ", "#C ", " I ", '#', Main.itemdarksteelingot, 'I',Main.itemtoolhandle, 'C',Main.itemcapacitorRF});
		GameRegistry.addRecipe(new ItemStack(Main.itemrfshovel, 1), new Object[] {" # ", " C ", " I ", '#',Main.itemdarksteelingot, 'I',Main.itemtoolhandle, 'C',Main.itemcapacitorRF});
		GameRegistry.addRecipe(new ItemStack(Main.itemrfsword, 1), new Object[] {" # ", " C ", " I ", '#', Main.itemdarksteelingot, 'I',Main.itemtoolhandle, 'C',Main.itemcapacitorRF});
		GameRegistry.addRecipe(new ItemStack(Main.itemrfhoe, 1), new Object[] {"## ", " C ", " I ", '#', Main.itemdarksteelingot, 'I',Main.itemtoolhandle, 'C',Main.itemcapacitorRF});

		//GameRegistry.addRecipe(new ItemStack(Main.itemfepickaxe, 1), new Object[] {"###", " C ", " I ", '#', Main.itemdarksteelingot, 'I',Main.itemtoolhandle, 'C',Main.itemcapacitorFE});
		//GameRegistry.addRecipe(new ItemStack(Main.itemfeaxe, 1), new Object[] {"## ", "#C ", " I ", '#', Main.itemdarksteelingot, 'I',Main.itemtoolhandle, 'C',Main.itemcapacitorFE});
		//GameRegistry.addRecipe(new ItemStack(Main.itemfeshovel, 1), new Object[] {" # ", " C ", " I ", '#',Main.itemdarksteelingot, 'I',Main.itemtoolhandle, 'C',Main.itemcapacitorFE});
		//GameRegistry.addRecipe(new ItemStack(Main.itemfesword, 1), new Object[] {" # ", " C ", " I ", '#', Main.itemdarksteelingot, 'I',Main.itemtoolhandle, 'C',Main.itemcapacitorFE});
		//GameRegistry.addRecipe(new ItemStack(Main.itemfehoe, 1), new Object[] {"## ", " C ", " I ", '#', Main.itemdarksteelingot, 'I',Main.itemtoolhandle, 'C',Main.itemcapacitorFE});

		
		
		
		GameRegistry.addRecipe(new ItemStack(Main.itemtoolhandle, 1), new Object[] {"   ", " I ", " I ",'I', Main.itemdarksteelingot});

		GameRegistry.addRecipe(new ItemStack(Main.teslaArmorHelmet, 1), new Object[] {"###", "#C#", "   ", '#', Main.itemdarksteelplate, 'C',Main.itemcapacitorTesla});
		GameRegistry.addRecipe(new ItemStack(Main.teslaArmorChestplate, 1), new Object[] {"#C#", "###", "###", '#', Main.itemdarksteelplate, 'C',Main.itemcapacitorTesla});
		GameRegistry.addRecipe(new ItemStack(Main.teslaArmorLeggings, 1), new Object[] {"###", "#C#", "# #", '#', Main.itemdarksteelplate, 'C',Main.itemcapacitorTesla});
		GameRegistry.addRecipe(new ItemStack(Main.teslaArmorBoots, 1), new Object[] {"   ", "# #", "#C#", '#', Main.itemdarksteelplate, 'C',Main.itemcapacitorTesla});
	
		
		//GameRegistry.addRecipe(new ItemStack(Main.rfArmorHelmet, 1), new Object[] {"###", "#C#", "   ", '#', Main.itemdarksteelplate, 'C',Main.itemcapacitorRF});
		//GameRegistry.addRecipe(new ItemStack(Main.rfArmorChestplate, 1), new Object[] {"#C#", "###", "###", '#', Main.itemdarksteelplate, 'C',Main.itemcapacitorRF});
		//GameRegistry.addRecipe(new ItemStack(Main.rfArmorLeggings, 1), new Object[] {"###", "#C#", "# #", '#', Main.itemdarksteelplate, 'C',Main.itemcapacitorRF});
		//GameRegistry.addRecipe(new ItemStack(Main.rfArmorBoots, 1), new Object[] {"   ", "# #", "#C#", '#', Main.itemdarksteelplate, 'C',Main.itemcapacitorRF});
	
		//GameRegistry.addRecipe(new ItemStack(Main.feArmorHelmet, 1), new Object[] {"###", "#C#", "   ", '#', Main.itemdarksteelplate, 'C',Main.itemcapacitorFE});
		//GameRegistry.addRecipe(new ItemStack(Main.feArmorChestplate, 1), new Object[] {"#C#", "###", "###", '#', Main.itemdarksteelplate, 'C',Main.itemcapacitorFE});
		//GameRegistry.addRecipe(new ItemStack(Main.feArmorLeggings, 1), new Object[] {"###", "#C#", "# #", '#', Main.itemdarksteelplate, 'C',Main.itemcapacitorFE});
		//GameRegistry.addRecipe(new ItemStack(Main.feArmorBoots, 1), new Object[] {"   ", "# #", "#C#", '#', Main.itemdarksteelplate, 'C',Main.itemcapacitorFE});
	
		
		
		
		
		
		
		
		
		
		
		
		
	}	
	

	}