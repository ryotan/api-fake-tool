package net.itr0.tool.api;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ryotan
 * @since 1.0
 */
public class ApiDefinitionContainer {

    private Map<String, Api> apis = new LinkedHashMap<>();

    public ApiDefinitionContainer add(Api api) {
        apis.put(api.getName(), api);
        return this;
    }

    public Api get(String name) {
        return apis.get(name);
    }
}
