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
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Set;
import net.darkhax.tesla.lib.TeslaUtils;

public class ItemFE extends ItemBase
{

	public ItemFE(float f, float g, ToolMaterial diamond, Set<Block> effectiveOn, long maxCapacity, long input, long output)
	{
		setMaxStackSize(1);

	}

	@Override public boolean isRepairable()
	{
		return false;
	}

	@Override public double getDurabilityForDisplay(ItemStack stack)
	{
		return (1 - (double) this.getStoredPower(stack, null) / (double) this.getCapacity(stack, null));
    }

	@Override public boolean showDurabilityBar(ItemStack stack)
	{
		return true;
	}
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        tooltip.add(ChatFormatting.GOLD + I18n.format("[WIP]") );

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