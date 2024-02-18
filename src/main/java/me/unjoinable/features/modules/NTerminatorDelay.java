package me.unjoinable.features.modules;

import me.unjoinable.GUI.Config;
import me.unjoinable.features.AbstractModule;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.init.Items;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;


public class NTerminatorDelay extends AbstractModule
{
    @Override
    public String getName() {
        return "No Term Delay";
    }

    @Override
    public String getDescription() {
        return "No Term Delay";
    }

    @SubscribeEvent
    public void onBowPullBack(final PlayerInteractEvent event) {
        if (!Config.INSTANCE.terminatorDelay) {
            return;
        }
        if (event.action != PlayerInteractEvent.Action.RIGHT_CLICK_AIR && event.action != PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
            return;
        }
        if (event.entityPlayer.	getHeldItem() == null) {
            return;
        }
        if (event.entityPlayer.	getHeldItem().getItem() != Items.bow) {
            return;
        }
        final ItemStack bow = event.entityPlayer.getHeldItem();
        if (bow.getTagCompound() == null) {
            return;
        }
        final NBTTagCompound tag = bow.getTagCompound();
        if (!tag.getString("type").equals("TERMINATOR")) {
            return;
        }
        event.setCanceled(true);
        final C08PacketPlayerBlockPlacement packet = new C08PacketPlayerBlockPlacement(event.entityPlayer.inventory.getCurrentItem());
        Minecraft.getMinecraft().thePlayer.sendQueue.addToSendQueue((Packet)packet);
    }
}
