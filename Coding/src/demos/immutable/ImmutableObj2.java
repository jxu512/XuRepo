/*
Some people suggest make all methods final instead of making class final. It generally works, but
class cab ne extended, an subclass can define new fields with same name causing confusion.
 */

package demos.immutable;

import java.util.HashMap;
import java.util.Map;

public class ImmutableObj2 {
    final private int id;
    final private String name;
    final private HashMap<String, String> map;

    public ImmutableObj2(int id, String name, Map<String, String> map) {
        this.id = id;
        this.name = name;
        this.map = new HashMap<>(map);
    }

    final public int getId() {
        return id;
    }

    final public String getName() {
        return name;
    }

    final public Map<String, String> getMap() {
       return new HashMap<>(this.map);
    }
}
