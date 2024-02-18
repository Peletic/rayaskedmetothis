package me.unjoinable.features.categories;


import me.unjoinable.features.Category;

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
