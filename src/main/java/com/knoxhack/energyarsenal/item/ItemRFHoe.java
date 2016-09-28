package com.knoxhack.energyarsenal.item;
import java.util.Iterator;
import java.util.List;

import com.mojang.realmsclient.gui.ChatFormatting;

import net.darkhax.tesla.api.implementation.BaseTeslaContainer;
import net.darkhax.tesla.capability.TeslaCapabilities;
import net.darkhax.tesla.lib.TeslaUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
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

public class ItemRFHoe extends ItemRF {

	protected double distanceFromPlayer;
	protected static String name = "itemrfhoe";

	public ItemRFHoe() {
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






	 @SuppressWarnings("incomplete-switch")
	    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	    {
	        if (!playerIn.canPlayerEdit(pos.offset(facing), facing, stack))
	        {
	            return EnumActionResult.FAIL;
	        }
	        else
	        {
	            int hook = net.minecraftforge.event.ForgeEventFactory.onHoeUse(stack, playerIn, worldIn, pos);
	            if (hook != 0) return hook > 0 ? EnumActionResult.SUCCESS : EnumActionResult.FAIL;

	            IBlockState iblockstate = worldIn.getBlockState(pos);
	            Block block = iblockstate.getBlock();

	            if (facing != EnumFacing.DOWN && worldIn.isAirBlock(pos.up()))
	            	
	            	
	            	
	            {    	
	            	
	            	
	    			int cost = 200;
					this.extractEnergy(stack, cost, false);
	            	
	            	 final BaseTeslaContainer container = (BaseTeslaContainer) stack.getCapability(TeslaCapabilities.CAPABILITY_HOLDER, null);
	                 if(container.getStoredPower() == 0)
	                 return EnumActionResult.FAIL;
	                 
	                 
	                if   (block == Blocks.GRASS || block == Blocks.GRASS_PATH)
	                	
	                {
	                    this.setBlock(stack, playerIn, worldIn, pos, Blocks.FARMLAND.getDefaultState());
	                    return EnumActionResult.SUCCESS;
	                }

	                if (block == Blocks.DIRT)
	                {
	                    switch ((BlockDirt.DirtType)iblockstate.getValue(BlockDirt.VARIANT))
	                    {
	                        case DIRT:
	                            this.setBlock(stack, playerIn, worldIn, pos, Blocks.FARMLAND.getDefaultState());
	                            return EnumActionResult.SUCCESS;
	                        case COARSE_DIRT:
	                            this.setBlock(stack, playerIn, worldIn, pos, Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT));
	                            return EnumActionResult.SUCCESS;
	                    }
	                }
	            }

	            return EnumActionResult.PASS;
	        }
	    }
	    
	    protected void setBlock(ItemStack stack, EntityPlayer player, World worldIn, BlockPos pos, IBlockState state)
	    {
	        worldIn.playSound(player, pos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);

	        if (!worldIn.isRemote)
	        {
	            worldIn.setBlockState(pos, state, 11);
	            stack.damageItem(1, player);
	        }
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
	        return Items.DIAMOND_HOE.canHarvestBlock(state);
	    }

	    @Override
	    public float getStrVsBlock(ItemStack stack, IBlockState state)
	    {
	        int cost = 200;
			if (this.getEnergyStored(stack) < cost)
	        {
	            return 0.5F;
	        }
	        if (Items.WOODEN_HOE.getStrVsBlock(stack, state) > 1.0F )
	        {
	            return 5.5F;
	        }
	        else
	        {
	            return super.getStrVsBlock(stack, state);
	        }
	    }}
	


