package com.knoxhack.energyarsenal.item;
import java.util.Iterator;
import java.util.List;

import com.mojang.realmsclient.gui.ChatFormatting;

import net.darkhax.tesla.lib.TeslaUtils;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemRFPickaxe extends ItemRF {

	protected double distanceFromPlayer;
	protected static String name = "itemrfpickaxe";

	public ItemRFPickaxe() {
		super(1000000, 1000, name);
		setMaxStackSize(1);
		this.distanceFromPlayer = 6.5;
		canRepair = false;
		setMaxDamage(0);

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
        tooltip.add(ChatFormatting.DARK_RED + I18n.format("[Energy Mode: ON]") );

        tooltip.add(ChatFormatting.DARK_RED + I18n.format("")+ this.getEnergyStored(stack) + "/" + this.getMaxEnergyStored(stack)+ I18n.format(" RF"));

	}


    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving)
    {
    	int cost = 200;
		this.extractEnergy(stack, cost, false);
		return true;
    }

    @Override
    public boolean canHarvestBlock(IBlockState state)
    {
        return Items.DIAMOND_PICKAXE.canHarvestBlock(state);
    }

    @Override
    public float getStrVsBlock(ItemStack stack, IBlockState state)
    {
        int cost = 200;
		if (this.getEnergyStored(stack) < cost)
        {
            return 0.5F;
        }
        if (Items.WOODEN_PICKAXE.getStrVsBlock(stack, state) > 1.0F)
        {
            return 5.5F;
        }
        else
        {
            return super.getStrVsBlock(stack, state);
        }
    }
    

}

	


