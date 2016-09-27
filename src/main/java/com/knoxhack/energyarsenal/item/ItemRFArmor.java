package com.knoxhack.energyarsenal.item;

import java.util.List;

import com.knoxhack.energyarsenal.TeslaArsenalTeslaUtilities;

import cofh.api.energy.IEnergyContainerItem;
import net.darkhax.tesla.api.implementation.BaseTeslaContainer;
import net.darkhax.tesla.api.implementation.BaseTeslaContainerProvider;
import net.darkhax.tesla.lib.TeslaUtils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public class ItemRFArmor extends ItemArmor2 implements IEnergyContainerItem{
	protected static int capacity;
	protected int maxReceive;
	protected int maxExtract;

	public ItemRFArmor(ArmorMaterial materialIn,EntityEquipmentSlot equipmentSlotIn,int capacity, String name) {
		this(materialIn, equipmentSlotIn, capacity, capacity, capacity, name);
	}

	public ItemRFArmor(ArmorMaterial materialIn,EntityEquipmentSlot equipmentSlotIn,int capacity, int maxTransfer, String name) {
		this(materialIn, equipmentSlotIn, capacity, maxTransfer, maxTransfer, name);
	}

	public ItemRFArmor(ArmorMaterial materialIn,EntityEquipmentSlot equipmentSlotIn, int capacity, int maxReceive, int maxExtract, String name) {
		super(materialIn, maxExtract, equipmentSlotIn, name);
		this.capacity = capacity;
		this.maxReceive = maxReceive;
		this.maxExtract = maxExtract;
	}

	public ItemRFArmor setCapacity(int capacity) {
		this.capacity = capacity;
		return this;
	}

	public ItemRFArmor setMaxTransfer(int maxTransfer) {
		setMaxReceive(maxTransfer);
		setMaxExtract(maxTransfer);
		return this;
	}

	public ItemRFArmor setMaxReceive(int maxReceive) {
		this.maxReceive = maxReceive;
		return this;
	}

	public ItemRFArmor setMaxExtract(int maxExtract) {
		this.maxExtract = maxExtract;
		return this;
	}

	public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {
		if (!container.hasTagCompound()) {
			container.setTagCompound(new NBTTagCompound());
		}
		int energy = container.getTagCompound().getInteger("Energy");
		int energyReceived = Math.min(this.capacity - energy, Math.min(this.maxReceive, maxReceive));
		if (!simulate) {
			energy += energyReceived;
			container.getTagCompound().setInteger("Energy", energy);
		}
		return energyReceived;
	}

	public int extractEnergy(ItemStack container, int maxExtract, boolean simulate) {
		if ((container.getTagCompound() == null) || (!container.getTagCompound().hasKey("Energy"))) {
			return 0;
		}
		int energy = container.getTagCompound().getInteger("Energy");
		int energyExtracted = Math.min(energy, Math.min(this.maxExtract, maxExtract));
		if (!simulate) {
			energy -= energyExtracted;
			container.getTagCompound().setInteger("Energy", energy);
		}
		return energyExtracted;
	}

	public int getEnergyStored(ItemStack container) {
		if ((container.getTagCompound() == null) || (!container.getTagCompound().hasKey("Energy"))) {
			return 0;
		}
		return container.getTagCompound().getInteger("Energy");
	}

	public int getMaxEnergyStored(ItemStack container) {
		return this.capacity;
	}

}

