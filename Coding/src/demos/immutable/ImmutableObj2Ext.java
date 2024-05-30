package demos.immutable;

import java.util.HashMap;
import java.util.Map;

public class ImmutableObj2Ext extends ImmutableObj2{

    private int id;     // Define new id

    public ImmutableObj2Ext(int id, String name, Map<String, String> map) {
        super(id, name, map);
    }

    // Can't define getter with same name
    public int getId_diff_name() {
        return id;
    }

}
