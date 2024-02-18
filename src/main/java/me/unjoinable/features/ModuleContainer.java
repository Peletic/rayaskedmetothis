package me.unjoinable.features;

import net.minecraftforge.common.MinecraftForge;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class ModuleContainer
{
    private final HashMap<Category, List<AbstractModule>> modules;

    public ModuleContainer() {
        this.modules = new HashMap<Category, List<AbstractModule>>();
    }

    public void register(final AbstractModule m, final Category c) {
        if (!this.modules.containsKey(c)) {
            this.modules.put(c, new ArrayList<AbstractModule>());
        }
        this.modules.get(c).add(m);
        MinecraftForge.EVENT_BUS.register((Object)m);
    }

    public List<AbstractModule> getModules(final Category c) {
        return this.modules.get(c);
    }

    public List<AbstractModule> getModules() {
        final List<AbstractModule> modules = new ArrayList<AbstractModule>();
        for (final Category c : this.modules.keySet()) {
            modules.addAll(this.getModules(c));
        }
        return modules;
    }

    public AbstractModule getModule(final String name) {
        for (final AbstractModule m : this.getModules()) {
            if (m.getName().equalsIgnoreCase(name)) {
                return m;
            }
        }
        return null;
    }

    public List<AbstractModule> getModulesByCategory(final Category c) {
        return this.modules.get(c);
    }

    public List<AbstractModule> getModulesByCategory(final String name) {
        for (final Category c : this.modules.keySet()) {
            if (c.getName().equalsIgnoreCase(name)) {
                return this.getModulesByCategory(c);
            }
        }
        return null;
    }

    public List<Category> getCategories() {
        return new ArrayList<Category>(this.modules.keySet());
    }

    public Category getCategory(final String name) {
        for (final Category c : this.modules.keySet()) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    public AbstractModule getModuleInstance(final Class<? extends AbstractModule> clazz) {
        for (final AbstractModule m : this.getModules()) {
            if (m.getClass().equals(clazz)) {
                return m;
            }
        }
        return null;
    }

    public Category getCategory(final AbstractModule m) {
        for (final Category c : this.modules.keySet()) {
            if (this.modules.get(c).contains(m)) {
                return c;
            }
        }
        return null;
    }

    public void removeModule(final AbstractModule m) {
        this.modules.get(this.getCategory(m)).remove(m);
    }

    public void removeCategory(final Category c) {
        this.modules.remove(c);
    }

    public void removeCategory(final String name) {
        this.removeCategory(this.getCategory(name));
    }

    public void removeModule(final String name) {
        this.removeModule(this.getModule(name));
    }

    public void removeModule(final Category c, final AbstractModule m) {
        this.modules.get(c).remove(m);
    }
}

