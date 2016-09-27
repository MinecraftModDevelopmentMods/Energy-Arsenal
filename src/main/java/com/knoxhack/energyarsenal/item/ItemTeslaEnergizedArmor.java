package com.knoxhack.energyarsenal.item;

import com.knoxhack.energyarsenal.Main;
import com.knoxhack.energyarsenal.TeslaArsenalTeslaUtilities;

import net.darkhax.tesla.api.implementation.BaseTeslaContainer;
import net.darkhax.tesla.api.implementation.BaseTeslaContainerProvider;
import net.darkhax.tesla.lib.TeslaUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public class ItemTeslaEnergizedArmor extends ItemTeslaArmor {
	
	
    public long cost = 100;
	public ItemTeslaEnergizedArmor(ArmorMaterial material, EntityEquipmentSlot slot, long maxCapacity, long input, long output) {
		super(material, material.getDamageReductionAmount(slot), slot, maxCapacity, input, output);
		if (slot == EntityEquipmentSlot.HEAD)
			setUnlocalizedName( "energyarsenal.teslaenergizedarmour.helmet");
		if (slot == EntityEquipmentSlot.CHEST)
			setUnlocalizedName( "energyarsenal.teslaenergizedarmour.chestplate");
		if (slot == EntityEquipmentSlot.LEGS)
			setUnlocalizedName( "energyarsenal.teslaenergizedarmour.leggings");
		if (slot == EntityEquipmentSlot.FEET)
			setUnlocalizedName( "energyarsenal.teslaenergizedarmour.boots");
        setCreativeTab(Main.tab);
	
	}

	
	
	@Override
	public String getArmorTexture(ItemStack itemStack, Entity entity, EntityEquipmentSlot slot, String layer)
	{
		if(armorType == EntityEquipmentSlot.LEGS)
		{
			return "energyarsenal:textures/armor/Tesla_armor_layer_2.png";
		}
		return "energyarsenal:textures/armor/Tesla_armor_layer_1.png";
	}
	
	
	
    public int getDamage(ItemStack stack)
    {
    	TeslaUtils.takePower(stack, null, cost, false);
    	
        return stack.getMaxDamage();
    }
	
    		
	@Override
    public ICapabilityProvider initCapabilities(final ItemStack stack, NBTTagCompound nbt) {
        return new BaseTeslaContainerProvider(new BaseTeslaContainer(100000, 100, 100){
            @Override
            public long givePower(long Tesla, boolean simulated) {
            setDamage(stack, 0);
            return super.givePower(Tesla, simulated);
            }

            @Override
            public long takePower(long Tesla, boolean simulated) {
            setDamage(stack, 0);
            return super.takePower(Tesla, simulated);
            }
        });
    }
    
    
    public float getToughness(ItemStack stack)
    {
        if (TeslaUtils.getStoredPower(stack, null) > cost)
        {
            return 0.0F;
        }
        return this.toughness;
    }
	
	
	
	
}
