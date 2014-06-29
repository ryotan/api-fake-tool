package kaba.defapi.http;

/**
 * @author ryotan
 * @since 1.0
 */
public class HttpResponse {

    private String contentType;

    private String body;

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
