package demos.immutable;

import java.util.HashMap;
import java.util.Map;

public class FalseImmutable {
    final private int id;
    final private String name;
    final private HashMap<String, String> map;

    public FalseImmutable(int id, String name, Map<String, String> map) {
        this.id = id;
        this.name = name;
        this.map = new HashMap<>(map);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getMap() {
       return new HashMap<>(this.map);
    }
}
