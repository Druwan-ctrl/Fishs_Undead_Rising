package com.Fishmod.mod_LavaCow.item;

import java.util.List;

import javax.annotation.Nullable;

import com.Fishmod.mod_LavaCow.client.Modconfig;
import com.Fishmod.mod_LavaCow.init.FishItems;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Optional.Interface(iface = "baubles.api.IBauble", modid = "baubles", striprefs = true)
public class ItemBaubleTrinket extends ItemRareLoot implements baubles.api.IBauble{

	public ItemBaubleTrinket(String registryName, CreativeTabs tab, EnumRarity rarity, boolean hasTooltip) {
		super(registryName, tab, rarity, hasTooltip);
		this.setMaxStackSize(1);
		this.setMaxDamage(0);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if(stack.getItemDamage() > stack.getMaxDamage())stack.setItemDamage(stack.getMaxDamage());
	}
	
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flag) {
		if(stack.getItem().equals(FishItems.HALO_NECKLACE))
			list.add(TextFormatting.YELLOW + I18n.format(this.Tooltip, Modconfig.HaloNecklace_Damage));
		else if(stack.getItem().equals(FishItems.MOOTENHEART))
			list.add(TextFormatting.YELLOW + I18n.format(this.Tooltip, Modconfig.MootenHeart_Damage) + I18n.format("item.mod_lavacow.potion_of_mooten_lava.name"));
	}
	
    /**
     * Add Baubles support
     * @param arg0
     * @param arg1
     */  
    @Override
    @Optional.Method(modid = "baubles")
    public boolean canEquip(ItemStack arg0, EntityLivingBase arg1) {
      return true;
    }
    
    @Override
    @Optional.Method(modid = "baubles")
    public boolean canUnequip(ItemStack arg0, EntityLivingBase arg1) {
      return true;
    }
    
    @Override
    @Optional.Method(modid = "baubles")
    public baubles.api.BaubleType getBaubleType(ItemStack arg0) {
    	if(arg0.getItem().equals(FishItems.HALO_NECKLACE))
    		return baubles.api.BaubleType.AMULET;
    	else
    		return baubles.api.BaubleType.TRINKET;
    }
    
    @Override
    @Optional.Method(modid = "baubles")
    public void onWornTick(ItemStack stack, EntityLivingBase plr) {

    }
    
	@Override
	@Optional.Method(modid = "baubles")
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
		player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, .75F, 1.9f);
	}

	@Override
	@Optional.Method(modid = "baubles")
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
		player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, .75F, 2f);
	}
}
