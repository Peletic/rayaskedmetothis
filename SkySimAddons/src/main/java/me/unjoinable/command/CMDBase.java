package me.unjoinable.command;

public abstract class CMDBase {
    private String name;
    private String description;
    private String[] aliases;

    public CMDBase(final String name, final String description) {
        this.name = name;
        this.description = description;
        this.aliases = new String[0];
    }

    public CMDBase(final String name) {
        this.name = name;
        this.aliases = new String[0];
    }

    public CMDBase(final String name, final String description, final String... aliases) {
        this.name = name;
        this.description = description;
        this.aliases = aliases;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public abstract void execute(final String[] p0);

    public String[] getAliases() {
        return this.aliases;
    }

    public void setAliases(final String[] aliases) {
        this.aliases = aliases;
    }

    public void addAlias(final String alias) {
        final String[] aliases = this.getAliases();
        final String[] newAliases = new String[aliases.length + 1];
        for (int i = 0; i < aliases.length; ++i) {
            newAliases[i] = aliases[i];
        }
        newAliases[newAliases.length - 1] = alias;
        this.setAliases(newAliases);
    }

    public void removeAlias(final String alias) {
        final String[] aliases = this.getAliases();
        final String[] newAliases = new String[aliases.length - 1];
        int index = 0;
        for (int i = 0; i < aliases.length; ++i) {
            if (aliases[i].equals(alias)) {
                index = i;
                break;
            }
        }
        for (int i = 0; i < aliases.length; ++i) {
            if (i < index) {
                newAliases[i] = aliases[i];
            }
            else if (i > index) {
                newAliases[i - 1] = aliases[i];
            }
        }
        this.setAliases(newAliases);
    }
}
