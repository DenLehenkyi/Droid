package PowerDroid;

import Droid.Droid;

public class PowerDroid extends Droid {

    public PowerDroid() {
        setDroid_type("PowerDroid");
        setArmor(150);
        setDamage(14);
        setHealth(200);

    }

    public PowerDroid(String name) {
        super(name);
        setArmor(150);
        setDamage(14);
        setHealth(200);

        setDroid_type("PowerDroid");
    }




}
