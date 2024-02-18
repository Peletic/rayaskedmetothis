package me.unjoinable;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import java.io.IOException;
import net.minecraftforge.common.MinecraftForge;
import me.unjoinable.command.CMDBase;
import me.unjoinable.command.cmd.TestCMD;
import me.unjoinable.module.Category;
import me.unjoinable.module.AbstractModule;
import me.unjoinable.module.categories.BasicCategory;
import me.unjoinable.module.Modules.NTerminatorDelay;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import me.unjoinable.command.CommandManager;
import me.unjoinable.module.ModuleContainer;
import net.minecraft.client.gui.GuiScreen;
import me.unjoinable.GUI.Config;
import net.minecraftforge.fml.common.Mod;

@Mod(modid = SkySimAddons.MODID, version = SkySimAddons.VERSION)
public class SkySimAddons {
    public static final String MODID = "SkySimAddons";
    public static final String VERSION = "1.0";
    public static Config m;
    public static GuiScreen display;
    private static SkySimAddons instance;
    private static ModuleContainer container;
    private static CommandManager commandManager;
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) throws IOException {
        System.out.println("good morning");
        container = new ModuleContainer();
        instance = this;
        container.register(new NTerminatorDelay(), new BasicCategory());
        (SkySimAddons.commandManager = new CommandManager()).register(new TestCMD());
        SkySimAddons.commandManager.reg();
        MinecraftForge.EVENT_BUS.register(this);

    }
    @SubscribeEvent
    public void tick(final TickEvent.ClientTickEvent event) {
        if(SkySimAddons.display != null){
            try{
                Minecraft.getMinecraft().displayGuiScreen(SkySimAddons.display);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            SkySimAddons.display = null;
        }
    }

    public static SkySimAddons getInstance() {
        return SkySimAddons.instance;
    }
    static {
        SkySimAddons.m = Config.INSTANCE;
        SkySimAddons.display = null;
    }
}
