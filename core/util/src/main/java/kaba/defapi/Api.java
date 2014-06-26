package kaba.defapi;

/**
 * @author ryotan
 * @since 1.0
 */
public class Api {

    private String name;

    private String path;

    private HttpMethod method;

    private String contentType;

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

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
