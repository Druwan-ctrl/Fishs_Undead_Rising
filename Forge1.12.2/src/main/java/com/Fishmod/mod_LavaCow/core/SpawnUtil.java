package com.Fishmod.mod_LavaCow.core;

import com.Fishmod.mod_LavaCow.client.Modconfig;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkProviderServer;

public class SpawnUtil {
	
	public static boolean isDay(World worldIn) {
		return worldIn.getWorldTime() <= 12000;
	}
	
	public static boolean isAllowedDimension(int dimensionIn) {
		for(int i : Modconfig.Spawn_AllowList) {
			if(i == dimensionIn)
				return true;
		}
		
		return false;
	}
	
	public static boolean isAllowedDimensionCemetery(int dimensionIn) {
		for(int i : Modconfig.Spawn_Cemetery_AllowList) {
			if(i == dimensionIn)
				return true;
		}
		
		return false;
	}
	
	/* Used to determine the relative height */
    public static BlockPos getHeight(Entity entityIn) {
    	return entityIn.world.getHeight(entityIn.getPosition());
    }
    
    public static boolean isInsideStructure(World worldIn, String structureName, BlockPos pos) {
    	if(worldIn.getChunkProvider() instanceof ChunkProviderServer)
    		return ((ChunkProviderServer)worldIn.getChunkProvider()).isInsideStructure(worldIn, structureName, pos);
    	
    	return false;
    }
}
