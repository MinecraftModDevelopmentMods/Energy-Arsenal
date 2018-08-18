package com.knoxhack.energyarsenal.item;
import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Multimap;
import com.knoxhack.energyarsenal.TeslaArsenalTeslaUtilities;
import com.mojang.realmsclient.gui.ChatFormatting;

import net.darkhax.tesla.api.implementation.BaseTeslaContainer;
import net.darkhax.tesla.api.implementation.BaseTeslaContainerProvider;
import net.darkhax.tesla.lib.TeslaUtils;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.common.util.EnumHelper;
public class ItemRFSword extends ItemRF {

	protected double distanceFromPlayer;
	protected static String name = "itemrfsword";
	  ToolMaterial DIAMONTOOL = EnumHelper.addToolMaterial("DIAMONTOOL", 3, 1000, 15.0F, 4.0F, 30);
	  ToolMaterial WOODTOOL = EnumHelper.addToolMaterial("WOODTOOL", 3, 1000, 1.0F, 8.0F, 30);
	    private final Item.ToolMaterial material;
	    private float attackDamage;
		
	public ItemRFSword(ToolMaterial material) {
		super(1000000, 1000, name);
		setMaxStackSize(1);
		this.distanceFromPlayer = 6.5;
		canRepair = false;
		setMaxDamage(0);
        this.material = material;
        this.attackDamage = 5.0F + material.getDamageVsEntity();

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

    public float getDamageVsEntity()
    {
        return this.material.getDamageVsEntity();
    }

    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
    	int cost = 200;
		if (this.getEnergyStored(stack) < cost)
    		return true;

		this.extractEnergy(stack, cost, false);

        return false;
    }

    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot)
    {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

        if (equipmentSlot == EntityEquipmentSlot.MAINHAND)
        {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.attackDamage, 0));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -2.4000000953674316D, 0));
        }

        return multimap;
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
        return Items.DIAMOND_SWORD.canHarvestBlock(state) ;
    }

    @Override
    public float getStrVsBlock(ItemStack stack, IBlockState state)
    {
        int cost = 200;
		if (this.getEnergyStored(stack) < cost)
        {
            return 0.5F;
        }
        if (Items.WOODEN_SWORD.getStrVsBlock(stack, state) > 1.0F )
        {
            return 5.5F;
        }
        else
        {
            return super.getStrVsBlock(stack, state);
        }
    }
}
