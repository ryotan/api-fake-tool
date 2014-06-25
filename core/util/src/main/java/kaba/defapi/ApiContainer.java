package kaba.defapi;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ryotan
 * @since 1.0
 */
public class ApiContainer {

    private Map<String, Api> apis = new LinkedHashMap<>();

    public ApiContainer add(Api api) {
        apis.put(api.getName(), api);
        return this;
    }

    public Api get(String name) {
        return apis.get(name);
    }
}
