package VoltDroid;

import Droid.Droid;

public class VoltDroid extends Droid {
    public VoltDroid() {
        setDroid_type("VoltDroid");
        setHealth(130);
        setArmor(160);
        setDamage(18);

    }

    public VoltDroid(String name) {
        super(name);
        setHealth(130);
        setArmor(160);
        setDamage(18);

        setDroid_type("VoltDroid");
    }




}
