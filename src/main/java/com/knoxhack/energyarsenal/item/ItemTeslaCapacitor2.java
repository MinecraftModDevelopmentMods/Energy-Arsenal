package com.knoxhack.energyarsenal.item;
import com.knoxhack.energyarsenal.Main;
import com.knoxhack.energyarsenal.TeslaArsenalTeslaUtilities;
import com.knoxhack.energyarsenal.TeslaUtililties;
import com.mojang.realmsclient.gui.ChatFormatting;

import cofh.api.energy.ItemEnergyContainer;
import net.darkhax.tesla.api.ITeslaConsumer;
import net.darkhax.tesla.api.ITeslaHolder;
import net.darkhax.tesla.api.implementation.BaseTeslaContainer;
import net.darkhax.tesla.api.implementation.BaseTeslaContainerProvider;
import net.darkhax.tesla.lib.TeslaUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
public class ItemTeslaCapacitor2 extends ItemTesla
{
	private EntityPlayer player;

	public ItemTeslaCapacitor2()
    {
        super();
        setUnlocalizedName("energyarsenal.itemteslacapacitortier2");
        setRegistryName("itemteslacapacitortier2");
        this.setMaxStackSize(1);
    }
	@Override public boolean isRepairable()
	{
		return false;
	}

	@Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected){

		if(!world.isRemote && entity instanceof EntityPlayer){
            EntityPlayer player = (EntityPlayer)entity;
            for(int i = 0; i < player.inventory.getSizeInventory(); i++){
                ItemStack slot = player.inventory.getStackInSlot(i);
                if(slot != null){
                	   int take = 0;
                    Item item = slot.getItem();
                    if(Main.hasTesla() && slot.hasCapability(TeslaUtililties.teslaConsumer, null)){
                    ITeslaConsumer cap = slot.getCapability(TeslaUtililties.teslaConsumer, null);
                    if(cap != null){
	                    take = (int)cap.givePower(this.getStoredPower(stack, null), false);}}
                    if(take > 0){
                    TeslaUtils.takePower(stack, null, 100, false);
                    }  
                }
            }
        }
    }

	private long getStoredPower(ItemStack stack, Object object) {
		return TeslaUtils.getStoredPower(stack, null);
	}

	@Override
    public ICapabilityProvider initCapabilities(final ItemStack stack, NBTTagCompound nbt) {
        return new BaseTeslaContainerProvider(new BaseTeslaContainer(500000, 500, 500){
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
    
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        tooltip.add(ChatFormatting.GRAY + I18n.format("Charges other Tesla items in your inventory") );
        tooltip.add(ChatFormatting.DARK_AQUA + I18n.format("[Energy Mode: Off]") );
        tooltip.add(ChatFormatting.DARK_AQUA + I18n.format("")+ this.getEnergyStored(stack) + "/" + this.getMaxEnergyStored(stack)+ I18n.format(" Tesla"));


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