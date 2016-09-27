package com.knoxhack.energyarsenal.item;

import java.util.List;

import com.knoxhack.energyarsenal.TeslaArsenalTeslaUtilities;

import net.darkhax.tesla.api.implementation.BaseTeslaContainer;
import net.darkhax.tesla.api.implementation.BaseTeslaContainerProvider;
import net.darkhax.tesla.lib.TeslaUtils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public class ItemFEArmor extends ItemArmor {

	
	public ItemFEArmor(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setMaxStackSize(1);

	}

	@Override public boolean isRepairable()
	{
		return false;
	}
	
	
	//@Override public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
	//{
	//	ItemStack powered = TeslaArsenalTeslaUtilities.createChargedStack(new ItemStack(itemIn));
	//	ItemStack unpowered = new ItemStack(itemIn);
		//subItems.add(powered);
		//subItems.add(unpowered);
	//}
	
	
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
        
        TeslaUtils.createTooltip(stack, tooltip);
    }

	private long getStoredPower(ItemStack stack, Object object) {
		return TeslaUtils.getStoredPower(stack, null);
	}
	private double getCapacity(ItemStack stack, Object object) {
		return TeslaUtils.getCapacity(stack, null);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
