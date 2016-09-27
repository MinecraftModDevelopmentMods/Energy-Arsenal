package com.knoxhack.energyarsenal.item;

import java.util.List;

import com.knoxhack.energyarsenal.Main;
import com.knoxhack.energyarsenal.TeslaArsenalTeslaUtilities;
import com.mojang.realmsclient.gui.ChatFormatting;

import cofh.api.energy.IEnergyContainerItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemRFEnergizedArmor extends ItemRFArmor  implements IEnergyContainerItem{
	
	
    private static String name;
	public long cost = 10;
	public ItemRFEnergizedArmor(ArmorMaterial material, EntityEquipmentSlot slot, long maxCapacity, long input, long output) {
		super(material, slot, capacity, name);
		this.capacity = capacity;
		this.maxReceive = maxReceive;
		this.maxExtract = maxExtract;
		if (slot == EntityEquipmentSlot.HEAD)
			setUnlocalizedName( "energyarsenal.rfenergizedarmour.helmet");
		if (slot == EntityEquipmentSlot.CHEST)
			setUnlocalizedName( "energyarsenal.rfenergizedarmour.chestplate");
		if (slot == EntityEquipmentSlot.LEGS)
			setUnlocalizedName( "energyarsenal.rfenergizedarmour.leggings");
		if (slot == EntityEquipmentSlot.FEET)
			setUnlocalizedName( "energyarsenal.rfenergizedarmour.boots");
        setCreativeTab(Main.tab);
	
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean showDurabilityBar(ItemStack stack) {
		return this.getEnergyStored(stack) < this.getMaxEnergyStored(stack);
	}

	public double getDurabilityForDisplay(ItemStack stack) {
		return 1 - ((double) this.getEnergyStored(stack) / (double) this.getMaxEnergyStored(stack));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        tooltip.add(ChatFormatting.DARK_RED + I18n.format("[WIP]") );

	}
	
	@Override
	public String getArmorTexture(ItemStack itemStack, Entity entity, EntityEquipmentSlot slot, String layer)
	{
		if(armorType == EntityEquipmentSlot.LEGS)
		{
			return "energyarsenal:textures/armor/RF_armor_layer_2.png";
		}
		return "energyarsenal:textures/armor/RF_armor_layer_1.png";
	}
	
	
	
    public int getDamage(ItemStack stack)
    {
    	int cost = 200;
		this.extractEnergy(stack, cost, false);
    	
        return stack.getMaxDamage();
    }
	

    
    		
    		
    
    
    
	
	
	
	
	
}
