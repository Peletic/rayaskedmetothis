package me.unjoinable.utils;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.ItemStack;
public class ItemUtils
{
    private ItemStack itemStack;

    public ItemUtils(final ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public String getID() {
        if (this.itemStack.getTagCompound() == null) {
            return "";
        }
        final NBTTagCompound tag = this.itemStack.getTagCompound();
        if (tag.hasKey("type")) {
            return tag.getString("type");
        }
        return "";
    }
}
