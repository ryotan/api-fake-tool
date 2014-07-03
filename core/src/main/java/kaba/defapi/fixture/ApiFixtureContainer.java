package kaba.defapi.fixture;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ryotan
 * @since 1.0
 */
public class ApiFixtureContainer {

    Map<String, ApiFixture> container = new LinkedHashMap<>();

    public ApiFixtureContainer add(ApiFixture fixture) {
        container.put(fixture.getName(), fixture);
        return this;
    }

    public ApiFixture get(String spec) {
        return container.get(spec);
    }
}
