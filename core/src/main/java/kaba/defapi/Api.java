package kaba.defapi;

import kaba.defapi.http.HttpMethod;
import kaba.defapi.http.HttpResponse;

/**
 * @author ryotan
 * @since 1.0
 */
public class Api {

    private String name;

    private String path;

    private HttpMethod method;

    private HttpResponse response;

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

    public HttpResponse getResponse() {
        return this.response;
    }

    public void setResponse(HttpResponse response) {
        this.response = response;
    }
}
