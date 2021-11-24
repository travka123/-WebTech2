package bsuir.webtech.lab3.shared;

public class AccessRights {
    public static final int READ = 1;
    public static final int CREATE = 2;
    public static final int UPDATE = 4;

    private final int rights;

    public AccessRights(int rights) {
        this.rights = rights;
    }

    public int getCode() {
        return rights;
    }

    public boolean canRead() {
        return (rights & 1) > 0;
    }

    public boolean canCreate() {
        return (rights & 2) > 0;
    }

    public boolean canUpdate() {
        return (rights & 4) > 0;
    }
}
