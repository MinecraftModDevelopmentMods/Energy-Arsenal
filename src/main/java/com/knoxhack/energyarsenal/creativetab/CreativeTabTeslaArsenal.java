package com.knoxhack.energyarsenal.creativetab;

import com.knoxhack.energyarsenal.Main;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabTeslaArsenal extends CreativeTabs {
    
    public CreativeTabTeslaArsenal() {
        
        super("energyarsenal");
    }
    
    @Override
    public Item getTabIconItem () {
        
        return Main.itemteslapickaxe;
    }
}