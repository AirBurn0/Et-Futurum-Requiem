package ganymedes01.etfuturum.items;

import ganymedes01.etfuturum.EtFuturum;
import ganymedes01.etfuturum.ModBlocks;
import ganymedes01.etfuturum.core.utils.Utils;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;

public class ItemBeetrootSeeds extends ItemSeeds {

	public ItemBeetrootSeeds() {
		super(ModBlocks.BEETROOTS.get(), Blocks.farmland);
		setTextureName("beetroot_seeds");
		setUnlocalizedName(Utils.getUnlocalisedName("beetroot_seeds"));
		setCreativeTab(EtFuturum.creativeTabItems);
	}
}