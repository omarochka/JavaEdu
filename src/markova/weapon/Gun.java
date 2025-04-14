package markova.weapon;

public sealed class Gun extends Weapon permits AutomaticGun
{
    public Gun(int maxAmmo)
    {
        super(maxAmmo);
    }

    public void shoot()
    {
        if (ammo != 0)
        {
            System.out.println("bang");
            ammo -= 1;
        }
        else System.out.println("clack");
    }
}
