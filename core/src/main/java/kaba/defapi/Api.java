package kaba.defapi;

import kaba.defapi.fixture.ApiFixture;
import kaba.defapi.fixture.ApiFixtureContainer;
import kaba.defapi.http.HttpMethod;
import kaba.defapi.http.HttpResponseDef;

/**
 * @author ryotan
 * @since 1.0
 */
public class Api {

    private String name;

    private String path;

    private HttpMethod method;

    private HttpResponseDef response;

    private ApiFixtureContainer fixtures;

    public Api(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    public HttpResponseDef getResponse() {
        return this.response;
    }

    public void setResponse(HttpResponseDef response) {
        this.response = response;
    }

    public ApiFixtureContainer getFixtures() {
        return this.fixtures;
    }

    public void setFixtures(ApiFixtureContainer fixtures) {
        this.fixtures = fixtures;
    }

    public void addFixture(ApiFixture fixture) {
        this.fixtures.add(fixture);
    }
}
