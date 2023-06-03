package me.unjoinable.module;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
public abstract class AbstractModule
{
    private boolean enabled;

    public abstract String getName();

    public abstract String getDescription();

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }

    public void onLoad(final FMLInitializationEvent event) {
    }
}
