package com.knoxhack.energyarsenal;

import net.darkhax.tesla.api.ITeslaConsumer;
import net.darkhax.tesla.api.ITeslaHolder;
import net.darkhax.tesla.api.ITeslaProducer;
import net.darkhax.tesla.api.implementation.BaseTeslaContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public class TeslaW implements ITeslaProducer, ITeslaHolder, ITeslaConsumer, ICapabilityProvider{

    private static final long Tesla = 0;
	private BaseTeslaContainer item;
	public TeslaW(ItemStack stack, BaseTeslaContainer item){
        this.item = item;
    }

    @Override
    public long givePower(long power, boolean simulated){
        return this.item.givePower(Tesla, simulated);
    }

    @Override
    public long getStoredPower(){
        return this.item.getStoredPower();
    }

    @Override
    public long getCapacity(){
        return this.item.getCapacity();
    }

    @Override
    public long takePower(long power, boolean simulated){
        return this.item.takePower(Tesla, simulated);
    }

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing){
        return capability == TeslaUtililties.teslaProducer || capability == TeslaUtililties.teslaHolder || capability == TeslaUtililties.teslaConsumer;
    }

    @SuppressWarnings("unchecked")
	@Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing){
        return this.hasCapability(capability, facing) ? (T)this : null;
    }
}