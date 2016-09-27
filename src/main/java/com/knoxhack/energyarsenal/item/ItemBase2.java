package com.knoxhack.energyarsenal.item;

import com.knoxhack.energyarsenal.Main;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemBase2 extends Item {
	
	private String name = "";

	public ItemBase2(String name) {
		this.name = name;
		setRegistryName(this.name);
		setUnlocalizedName(this.name);
		GameRegistry.register(this);
		setMaxStackSize(64);
		setMaxDamage(0);
        setCreativeTab(Main.tab);
	}


}