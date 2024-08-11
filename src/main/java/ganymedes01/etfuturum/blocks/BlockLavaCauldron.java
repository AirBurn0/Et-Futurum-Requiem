package ganymedes01.etfuturum.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ganymedes01.etfuturum.core.utils.Utils;
import ganymedes01.etfuturum.lib.RenderIDs;
import net.minecraft.block.BlockCauldron;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

public class BlockLavaCauldron extends BlockCauldron {

	public BlockLavaCauldron() {
		super();
		this.setStepSound(Blocks.cauldron.stepSound);
		this.setHardness(2);
		this.setResistance(2);
		this.setLightLevel(1.0F);
		this.setBlockName(Utils.getUnlocalisedName("lava_cauldron"));
	}

	@Override
	public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
//      ItemStack item;
//      if (p_149727_5_.getCurrentEquippedItem() != null) {
//          item = p_149727_5_.getCurrentEquippedItem();
//          if (item.getItem() instanceof ItemBucket) {
//              // TODO Bucketing lava out of the cauldron
//          }
//      }
//      return true;
		return super.onBlockActivated(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, p_149727_5_, p_149727_6_, p_149727_7_, p_149727_8_, p_149727_9_);
	}

	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		if (!world.isRemote && !entity.isImmuneToFire()) {
			if (!(entity instanceof EntityLiving) && !entity.isBurning()) {
				entity.playSound("random.fizz", 0.4F, 2.0F + world.rand.nextFloat() * 0.4F);
				if (!world.isRaining() && !world.canBlockSeeTheSky(x, y + 1, z)) {
					entity.setFire(15);
				}
			}
			entity.attackEntityFrom(DamageSource.lava, 4.0F);
		}
	}

	@Override
	public int tickRate(World world) {
		return 0;
	}

	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		float min = 0.125F;
		float max = 0.875F;
		double d0 = x + (min + random.nextFloat() * (max - min));
		double d1 = z + (min + random.nextFloat() * (max - min));

		if (world.canBlockSeeTheSky(x, y + 1, z) && world.isRaining()) {
			world.spawnParticle("smoke", d0, y + 0.9375F, d1, 0.0D, 0.0D, 0.0D);
		}
		if (random.nextInt(100) == 0) {
			world.spawnParticle("lava", d0, y + 0.9375F, d1, 0.0D, 0.0D, 0.0D);
			world.playSound(x + .5, y + 1, z + 0.5, "liquid.lavapop", 0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false);
		}
		if (random.nextInt(200) == 0) {
			world.playSound(x + .5, y + 1, z + 0.5, "liquid.lava", 0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false);
		}
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		return Blocks.cauldron.getIcon(side, meta);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_) {
		// Taking Icons from original Cauldron
	}

	@Override
	public int getRenderType() {
		return RenderIDs.LAVA_CAULDRON;
	}

}
