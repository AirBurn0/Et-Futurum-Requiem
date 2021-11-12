package ganymedes01.etfuturum.configuration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import ganymedes01.etfuturum.EtFuturum;
import ganymedes01.etfuturum.EtFuturumMixinPlugin;
import ganymedes01.etfuturum.lib.Reference;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.launchwrapper.Launch;
import net.minecraftforge.common.config.ConfigElement;

public class ConfigGUI extends GuiConfig {

	public ConfigGUI(GuiScreen parent) {
		super(parent, getElements(), Reference.MOD_ID, Reference.MOD_ID, false, false, GuiConfig.getAbridgedConfigPath(Launch.minecraftHome + "config" + File.separator + Reference.MOD_ID));
	}

	private static List<IConfigElement> getElements() {
		List<IConfigElement> list = new ArrayList<IConfigElement>();
//      for (String category : ConfigBase.usedCategories)
//          list.add(new ConfigElement(ConfigBase.INSTANCE.cfg.getCategory(category)));
		return list;
	}
}