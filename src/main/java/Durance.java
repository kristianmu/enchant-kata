public class Durance {
    Weapon weapon;
    MagicBook magicBook;

    public Durance(Weapon weapon, MagicBook magicBook) {
        this.weapon = weapon;
        this.magicBook = magicBook;
    }

    public void enchant() {
        throw new UnsupportedOperationException();
    }

    public String describeWeapon() {
        return weapon.stats();
    }
}

