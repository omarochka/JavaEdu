package weapon;

public abstract class Weapon implements Cloneable
{
    final int maxAmmo;
    protected int ammo;

    public Weapon(int maxAmmo)
    {
        this.maxAmmo = maxAmmo;
        this.ammo = 0;
    }

    public int getMaxAmmo() {
        return maxAmmo;
    }

    public int getAmmo() {
        return ammo;
    }

    public abstract void shoot();

    public int load(int ammo){
        if (ammo < 0)
            throw new IllegalArgumentException("The number of ammo cannot be negative");
        if (this.ammo + ammo > maxAmmo)
        {
            int retAmmo = ammo - maxAmmo;
            this.ammo = maxAmmo;
            return retAmmo;
        }
        this.ammo += ammo;
        return 0;
    }

    public int unload(){
        int retAmmo = this.ammo;
        this.ammo = 0;
        return retAmmo;
    }

    public boolean isLoad(){
        return getAmmo() != 0;
    }


    @Override
    public Weapon clone() {
        try {
            return (Weapon) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
