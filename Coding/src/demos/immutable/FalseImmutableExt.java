package demos.immutable;

import java.util.HashMap;
import java.util.Map;

public class FalseImmutableExt extends FalseImmutable{

    public FalseImmutableExt(int id, String name, Map<String, String> map) {
        super(id, name, map);
    }

    @Override
    public int getId() {
        Map<String,String> map = getMap();
        map.put("Muted", "Yes");
        return getId();
    }

    @Override
    public Map<String, String> getMap() {
        getMap().put("Muted", "Yes");
        return new HashMap<>(getMap());
    }
}
