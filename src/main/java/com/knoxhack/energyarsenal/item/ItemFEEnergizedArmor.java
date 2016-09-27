package com.knoxhack.energyarsenal.item;

import java.util.List;

import com.knoxhack.energyarsenal.Main;
import com.knoxhack.energyarsenal.TeslaArsenalTeslaUtilities;
import com.mojang.realmsclient.gui.ChatFormatting;

import net.darkhax.tesla.api.implementation.BaseTeslaContainer;
import net.darkhax.tesla.api.implementation.BaseTeslaContainerProvider;
import net.darkhax.tesla.lib.TeslaUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFEEnergizedArmor extends ItemTeslaArmor {
	
	
    public long cost = 10;
	public ItemFEEnergizedArmor(ArmorMaterial material, EntityEquipmentSlot slot, long maxCapacity, long input, long output) {
		super(material, material.getDamageReductionAmount(slot), slot, maxCapacity, input, output);
		if (slot == EntityEquipmentSlot.HEAD)
			setUnlocalizedName( "energyarsenal.feenergizedarmour.helmet");
		if (slot == EntityEquipmentSlot.CHEST)
			setUnlocalizedName( "energyarsenal.feenergizedarmour.chestplate");
		if (slot == EntityEquipmentSlot.LEGS)
			setUnlocalizedName( "energyarsenal.feenergizedarmour.leggings");
		if (slot == EntityEquipmentSlot.FEET)
			setUnlocalizedName( "energyarsenal.feenergizedarmour.boots");
        setCreativeTab(Main.tab);
	
	}

	
	
	@Override
	public String getArmorTexture(ItemStack itemStack, Entity entity, EntityEquipmentSlot slot, String layer)
	{
		if(armorType == EntityEquipmentSlot.LEGS)
		{
			return "energyarsenal:textures/armor/FE_armor_layer_2.png";
		}
		return "energyarsenal:textures/armor/FE_armor_layer_1.png";
	}
	
	
	
    public int getDamage(ItemStack stack)
    {
    	TeslaUtils.takePower(stack, null, cost, false);
    	
        return stack.getMaxDamage();
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        tooltip.add(ChatFormatting.GOLD + I18n.format("[WIP]") );

	}

    
    
	
	
	
	
	
}
