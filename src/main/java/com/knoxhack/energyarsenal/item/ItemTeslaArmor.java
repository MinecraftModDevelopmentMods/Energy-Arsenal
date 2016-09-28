package com.knoxhack.energyarsenal.item;

import java.util.List;

import com.knoxhack.energyarsenal.TeslaArsenalTeslaUtilities;
import com.mojang.realmsclient.gui.ChatFormatting;

import net.darkhax.tesla.api.implementation.BaseTeslaContainer;
import net.darkhax.tesla.api.implementation.BaseTeslaContainerProvider;
import net.darkhax.tesla.lib.TeslaUtils;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public class ItemTeslaArmor extends ItemArmor {
	
	
	public ItemTeslaArmor(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn, long maxCapacity, long input, long output) {
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
	//	subItems.add(powered);
	//	subItems.add(unpowered);
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
        tooltip.add(ChatFormatting.DARK_AQUA + I18n.format("[Energy Mode: Off]") );

        tooltip.add(ChatFormatting.DARK_AQUA + I18n.format("")+ this.getEnergyStored(stack) + "/" + this.getMaxEnergyStored(stack)+ I18n.format(" Tesla"));

    }

	private long getStoredPower(ItemStack stack, Object object) {
		return TeslaUtils.getStoredPower(stack, null);
	}
	private double getCapacity(ItemStack stack, Object object) {
		return TeslaUtils.getCapacity(stack, null);
	}
	


	private long getMaxEnergyStored(ItemStack stack) {
		// TODO Auto-generated method stub
		return TeslaUtils.getCapacity(stack, null);
	}

	private long getEnergyStored(ItemStack stack) {
		// TODO Auto-generated method stub
		return TeslaUtils.getStoredPower(stack, null);
	}
	
	
	
	
	
	
	
	
	
	
}
