package markova.weapon;

public final class AutomaticGun extends Gun
{
    int rateOfFire; // Количество выстрелов в секунду

    public AutomaticGun() {
        this(30, 30);
    }

    public AutomaticGun(int maxAmmo) {
        this(maxAmmo, maxAmmo / 2);
    }

    public AutomaticGun(int maxAmmo, int rateOfFire) {
        super(maxAmmo);
        this.setRateOfFire(rateOfFire);
    }

    public void setRateOfFire(int rateOfFire) {
        if (rateOfFire <= 0)
            throw new IllegalArgumentException("rateOfFire must be positive");
        this.rateOfFire = rateOfFire;
    }

    public void shoot()
    {
        for (int i = 0; i < rateOfFire; i++){
            super.shoot();
        }
    }

    public void shoot(int nSec)
    {
        for (int i = 0; i < nSec; i++){
            this.shoot();
        }
    }
}