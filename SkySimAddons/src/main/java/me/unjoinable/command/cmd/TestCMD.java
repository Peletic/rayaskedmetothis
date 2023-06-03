package me.unjoinable.command.cmd;

import me.unjoinable.SkySimAddons;
import me.unjoinable.command.CMDBase;
import net.minecraft.client.gui.GuiScreen;

public class TestCMD extends CMDBase
{
    public TestCMD() {
        super("/test", "test command", new String[] { "/t" });
    }

    @Override
    public void execute(final String[] args) {
        SkySimAddons.display = (GuiScreen) SkySimAddons.m.gui();
    }
}
