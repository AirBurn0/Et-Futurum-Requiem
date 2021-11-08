package ganymedes01.etfuturum.blocks;

import ganymedes01.etfuturum.EtFuturum;
import ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems;
import ganymedes01.etfuturum.core.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.world.IBlockAccess;

public class BlockEndBricks extends Block implements IConfigurable {

	public BlockEndBricks() {
		super(Material.rock);
		setHardness(3.0F);
		setResistance(9.0F);
		setStepSound(soundTypePiston);
		setBlockTextureName("end_bricks");
		setBlockName(Utils.getUnlocalisedName("end_bricks"));
		setCreativeTab(isEnabled() ? EtFuturum.creativeTabBlocks : null);
	}

	@Override
	public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity) {
		return !(entity instanceof EntityDragon);
	}

	@Override
	public boolean isEnabled() {
		return ConfigBlocksItems.enableChorusFruit;
	}
}