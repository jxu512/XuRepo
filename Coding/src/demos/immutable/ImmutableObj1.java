/*
Immutable objects don't need synchronization in concurrency
To make class immutable
1. make class final so that it can't be extended
2. make fields final
3. No setter methods
4. For mutable field, return a copy and don't share reference
5. Optionally, override clone()
 */

package demos.immutable;

import java.util.HashMap;
import java.util.Map;

final public class ImmutableObj1 implements Cloneable{
    final private int id;
    final private String name;
    final private HashMap<String, String> map;

    public ImmutableObj1(int id, String name, Map<String, String> map) {
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

    @Override
    public ImmutableObj1 clone() {
        return new ImmutableObj1(id, name, map);
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("one", "1");
        ImmutableObj1 immutableObj1 = new ImmutableObj1(1,"one", map);
        map.put("one", "3");
        ImmutableObj1 immutableObj12 = immutableObj1.clone();
        immutableObj12.getMap().put("one", "2");
    }
}
