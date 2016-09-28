package com.knoxhack.energyarsenal.item;


import com.knoxhack.energyarsenal.TeslaArsenalTeslaUtilities;
import com.mojang.realmsclient.gui.ChatFormatting;

import net.darkhax.tesla.api.implementation.BaseTeslaContainer;
import net.darkhax.tesla.api.implementation.BaseTeslaContainerProvider;
import net.minecraft.block.Block;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Set;
import net.darkhax.tesla.lib.TeslaUtils;









public class ItemTesla extends ItemBase
{


	public ItemTesla()
	{
		setMaxStackSize(1);

	}

	@Override public double getDurabilityForDisplay(ItemStack stack)
	{
		return (1 - (double) this.getStoredPower(stack, null) / (double) this.getCapacity(stack, null));
    }

	@Override public boolean showDurabilityBar(ItemStack stack)
	{
		return true;
	}
    @Override
    public void addInformation (ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        tooltip.add(ChatFormatting.DARK_AQUA + I18n.format("[Energy Mode: Off]") );

        tooltip.add(ChatFormatting.DARK_AQUA + I18n.format("")+ this.getEnergyStored(stack) + "/" + this.getMaxEnergyStored(stack)+ I18n.format(" Tesla"));


	}

	private long getMaxEnergyStored(ItemStack stack) {
		// TODO Auto-generated method stub
		return TeslaUtils.getCapacity(stack, null);
	}

	private long getEnergyStored(ItemStack stack) {
		// TODO Auto-generated method stub
		return TeslaUtils.getStoredPower(stack, null);
	}

	private long getStoredPower(ItemStack stack, Object object) {
		return TeslaUtils.getStoredPower(stack, null);
	}
	private double getCapacity(ItemStack stack, Object object) {
		// TODO Auto-generated method stub
		return TeslaUtils.getCapacity(stack, null);
	}


	//@Override public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
	//{
		//ItemStack powered = TeslaArsenalTeslaUtilities.createChargedStack(new ItemStack(itemIn));
		//ItemStack unpowered = new ItemStack(itemIn);
		//subItems.add(powered);
		//subItems.add(unpowered);
	//}
	
 





	

 

	
}