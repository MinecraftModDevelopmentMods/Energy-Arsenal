package com.knoxhack.energyarsenal;

import net.darkhax.tesla.api.ITeslaConsumer;
import net.darkhax.tesla.api.ITeslaHolder;
import net.darkhax.tesla.api.ITeslaProducer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public final class TeslaUtililties{

    @CapabilityInject(ITeslaConsumer.class)
    public static Capability<ITeslaConsumer> teslaConsumer;
    @CapabilityInject(ITeslaProducer.class)
    public static Capability<ITeslaProducer> teslaProducer;
    @CapabilityInject(ITeslaHolder.class)
    public static Capability<ITeslaHolder> teslaHolder;
    
   

  







}
