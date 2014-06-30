package kaba.defapi.fixture;

import java.util.Map;

/**
 * @author ryotan
 * @since 1.0
 */
public class ApiFixture {

    private String name;
    private String body;
    private Map<String, Object> params;

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
