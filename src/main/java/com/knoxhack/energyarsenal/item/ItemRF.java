package com.knoxhack.energyarsenal.item;

import cofh.api.energy.IEnergyContainerItem;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ItemRF extends ItemBase2 implements IEnergyContainerItem {

	protected int capacity;
	protected int maxReceive;
	protected int maxExtract;

	public ItemRF(int capacity, String name) {
		this(capacity, capacity, capacity, name);
	}

	public ItemRF(int capacity, int maxTransfer, String name) {
		this(capacity, maxTransfer, maxTransfer, name);
	}

	public ItemRF(int capacity, int maxReceive, int maxExtract, String name) {
		super(name);
		this.capacity = capacity;
		this.maxReceive = maxReceive;
		this.maxExtract = maxExtract;
	}

	public ItemRF setCapacity(int capacity) {
		this.capacity = capacity;
		return this;
	}

	public ItemRF setMaxTransfer(int maxTransfer) {
		setMaxReceive(maxTransfer);
		setMaxExtract(maxTransfer);
		return this;
	}

	public ItemRF setMaxReceive(int maxReceive) {
		this.maxReceive = maxReceive;
		return this;
	}

	public ItemRF setMaxExtract(int maxExtract) {
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