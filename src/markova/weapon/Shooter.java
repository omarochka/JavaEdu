package markova.weapon;

public class Shooter
{
    private String name;
    private Weapon weapon;

    public Shooter(String name){
        setName(name);
    }

    public String getName() {
        return name;
    }

    public Weapon getWeapon() {
        return weapon.clone();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void shoot(){
        if (weapon == null)
            System.out.println("Не могу участвовать в перестрелке");
        else weapon.shoot();
    }
}
