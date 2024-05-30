/*
Immutable objects don't need synchronization in concurrency
To make class immutable
1. make class final so that it can't be extended
2. make fields final
3. No setter methods
4. For mutable field, return a copy and don't share reference
 */

package demos.immutable;

import java.util.HashMap;
import java.util.Map;

final public class ImmutableObj3 {
    final private int id;
    final private String name;
    final private HashMap<String, String> map;

    private ImmutableObj3(int id, String name, Map<String, String> map) {
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

    public ImmutableObj3 getImmutableObject3(int id, String name, Map<String, String> map) {
        return new ImmutableObj3(id, name, map);
    }
}
