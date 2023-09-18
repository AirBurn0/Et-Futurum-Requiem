package ganymedes01.etfuturum.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import ganymedes01.etfuturum.configuration.configs.ConfigFunctions;
import net.minecraft.client.Minecraft;

public class AttackYawHandler implements IMessageHandler<AttackYawMessage, IMessage> {

	@Override
	public IMessage onMessage(AttackYawMessage message, MessageContext ctx) {
		if (ConfigFunctions.enableAttackedAtYawFix) {
			Minecraft.getMinecraft().thePlayer.attackedAtYaw = message.attackedAtYaw;
		}
		return null;
	}

}
