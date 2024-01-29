package BenderDroid;

import Droid.Droid;

public class BenderDroid extends Droid {
    public BenderDroid() {
        setDroid_type("BenderDroid");
        setHealth(160);
        setDamage(21);
        setArmor(123);

    }

    public BenderDroid(String name) {
        super(name);
        setDroid_type("BenderDroid");
        setHealth(160);
        setDamage(21);
        setArmor(123);
    }



}
