package com.knoxhack.energyarsenal.item;
import java.util.Set;

import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.knoxhack.energyarsenal.TeslaArsenalTeslaUtilities;

import net.darkhax.tesla.api.implementation.BaseTeslaContainer;
import net.darkhax.tesla.api.implementation.BaseTeslaContainerProvider;
import net.darkhax.tesla.capability.TeslaCapabilities;
import net.darkhax.tesla.lib.TeslaUtils;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.EnumHelper;
public class ItemTeslaSword extends ItemTesla
{
	
	
  ToolMaterial DIAMONTOOL = EnumHelper.addToolMaterial("DIAMONTOOL", 3, 1000, 15.0F, 4.0F, 30);
  ToolMaterial WOODTOOL = EnumHelper.addToolMaterial("WOODTOOL", 3, 1000, 1.0F, 8.0F, 30);

	

    public long cost = 100;

  
    private final Item.ToolMaterial material;

    private float attackDamage;
	private ItemStack stack;
    public static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(new Block[] {Blocks.ACTIVATOR_RAIL, Blocks.COAL_ORE, Blocks.COBBLESTONE, Blocks.DETECTOR_RAIL, Blocks.DIAMOND_BLOCK, Blocks.DIAMOND_ORE, Blocks.DOUBLE_STONE_SLAB, Blocks.GOLDEN_RAIL, Blocks.GOLD_BLOCK, Blocks.GOLD_ORE, Blocks.ICE, Blocks.IRON_BLOCK, Blocks.IRON_ORE, Blocks.LAPIS_BLOCK, Blocks.LAPIS_ORE, Blocks.LIT_REDSTONE_ORE, Blocks.MOSSY_COBBLESTONE, Blocks.NETHERRACK, Blocks.PACKED_ICE, Blocks.RAIL, Blocks.REDSTONE_ORE, Blocks.SANDSTONE, Blocks.RED_SANDSTONE, Blocks.STONE, Blocks.STONE_SLAB, Blocks.STONE_BUTTON, Blocks.STONE_PRESSURE_PLATE});

    public ItemTeslaSword(ToolMaterial material)
    {
    	
        super();
 
        this.material = material;

        setUnlocalizedName("energyarsenal.itemteslasword");
        setRegistryName("itemteslasword");
        this.attackDamage = 5.0F + material.getDamageVsEntity();

    }
    public float getDamageVsEntity()
    {
        return this.material.getDamageVsEntity();
    }

    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
    	if (TeslaUtils.getStoredPower(stack, null) < cost)
    		return true;
    	TeslaUtils.takePower(stack, null, cost, false);

        return false;
    }

    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot)
    {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

        if (equipmentSlot == EntityEquipmentSlot.MAINHAND)
        {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getAttributeUnlocalizedName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.attackDamage, 0));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getAttributeUnlocalizedName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -2.4000000953674316D, 0));
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
    	TeslaArsenalTeslaUtilities.usePower(stack, cost, false);
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
        if (TeslaArsenalTeslaUtilities.getStoredPower(stack) < cost)
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