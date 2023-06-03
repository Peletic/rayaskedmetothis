package me.unjoinable.GUI;

import java.io.File;
import gg.essential.vigilance.data.PropertyType;
import gg.essential.vigilance.data.Property;
import gg.essential.vigilance.Vigilant;

public class Config extends Vigilant
{
    public static Config INSTANCE;
    @Property(type = PropertyType.SWITCH, name = "Enderman Teleport", description = "Disables enderman from teleporting.", category = "Slayers", subcategory = "Enderman")
    public boolean emanTP;
    @Property(type = PropertyType.SWITCH, name = "Terminator Delay", description = "Disables the delay on the terminator.", category = "Weapons", subcategory = "Risky")
    public boolean terminatorDelay;
    @Property(type = PropertyType.SWITCH, name = "Copy Chat", description = "Copies the message from chat.", category = "Misc", subcategory = "Chat")
    public boolean copyChat;
    @Property(type = PropertyType.SWITCH, name = "Chat Memes", description = "Sends memes message to chat.", category = "Misc", subcategory = "Chat")
    public boolean chatMemes;
    @Property(type = PropertyType.SWITCH, name = "Player Join Messages", description = "Sends player join messages. (Disabled)", category = "Misc", subcategory = "Player")
    public boolean playerJoinMessages;
    @Property(type = PropertyType.SWITCH, name = "Auto Evacuation", description = "Automatically evacuates when the 30 second warning is sent.", category = "Misc", subcategory = "Player")
    public boolean epicEvacuate;

    public Config() {
        super(new File("config/SkysimExtras.toml"));
        this.emanTP = false;
        this.terminatorDelay = false;
        this.copyChat = false;
        this.chatMemes = true;
        this.playerJoinMessages = true;
        this.epicEvacuate = true;
        this.initialize();
    }

    static {
        Config.INSTANCE = new Config();
    }
}

