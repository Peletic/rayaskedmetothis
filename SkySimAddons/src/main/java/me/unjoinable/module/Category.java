package me.unjoinable.module;

public abstract class Category
{
    private int x;
    private int y;
    private CategoryState state;

    public Category() {
        this.state = CategoryState.CLOSED;
    }

    public abstract String getName();

    public abstract int getCateWeight();

    public int getX() {
        return this.x;
    }

    public void setX(final int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(final int y) {
        this.y = y;
    }

    public CategoryState getState() {
        return this.state;
    }

    public void setState(final CategoryState state) {
        this.state = state;
    }
}

