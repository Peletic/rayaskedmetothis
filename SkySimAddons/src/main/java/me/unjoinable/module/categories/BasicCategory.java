package me.unjoinable.module.categories;


import me.unjoinable.module.Category;

public class BasicCategory extends Category
{
    @Override
    public String getName() {
        return "Basic";
    }

    @Override
    public int getCateWeight() {
        return 0;
    }
}
