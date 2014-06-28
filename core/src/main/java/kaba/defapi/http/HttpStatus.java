package kaba.defapi.http;

import java.util.stream.Stream;

/**
 * HTTP status definitions according to RFC 2616.
 *
 * @author ryotan
 * @since 1.0
 */
public enum HttpStatus {
    // Informational 1xx
    CONTINUE(100, "Continue"),
    SWITCHING_PROTOCOLS(101, "Switching Protocols"),

    // Successful 2xx
    OK(200, "OK"),
    CREATED(201, "Created"),
    ACCEPTED(202, "Accepted"),
    NON_AUTHORITATIVE_INFORMATION(203, "Non-Authoritative Information"),
    NO_CONTENT(204, "No Content"),
    RESET_CONTENT(205, "Reset Content"),
    PARTIAL_CONTENT(206, "Partial Content"),

    // Redirection 3xx
    MULTIPLE_CHOICES(300, "Multiple Choices"),
    MOVED_PERMANENTLY(301, "Moved Permanently"),
    FOUND(302, "Found"),
    SEE_OTHER(303, "See Other"),
    NOT_MODIFIED(304, "Not Modified"),
    USE_PROXY(305, "Use Proxy"),
    UNUSED_306(306, "Unused"),
    TEMPORARY_REDIRECT(307, "Temporary Redirect"),

    // Client Error 4xx
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Unauthorized"),
    PAYMENT_REQUIRED(402, "Payment Required"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),
    METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
    NOT_ACCEPTABLE(406, "Not Acceptable"),
    PROXY_AUTHENTICATION_REQUIRED(407, "Proxy Authentication Required"),
    REQUEST_TIMEOUT(408, "Request Timeout"),
    CONFLICT(409, "Conflict"),
    GONE(410, "Gone"),
    LENGTH_REQUIRED(411, "Length Required"),
    PRECONDITION_FAILED(412, "Precondition Failed"),
    REQUEST_ENTITY_TOO_LARGE(413, "Request Entity Too Large"),
    REQUEST_URI_TOO_LONG(414, "Request-URI Too Long"),
    UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type"),
    REQUESTED_RANGE_NOT_SATISFIABLE(416, "Requested Range Not Satisfiable"),
    EXPECTATION_FAILED(417, "Expectation Failed"),

    // Server Error 5xx
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    NOT_IMPLEMENTED(501, "Not Implemented"),
    BAD_GATEWAY(502, "Bad Gateway"),
    SERVICE_UNAVAILABLE(503, "Service Unavailable"),
    GATEWAY_TIMEOUT(504, "Gateway Timeout"),
    HTTP_VERSION_NOT_SUPPORTED(505, "HTTP Version Not Supported");

    /**
     * HTTP status code
     */
    private final int statusCode;

    /**
     * HTTP status message
     */
    private final String message;

    /**
     * @param statusCode HTTP status code
     * @param message HTTP status message
     */
    HttpStatus(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    /**
     * @return HTTP status code of this enum.
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * @return HTTP status message of this enum.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Returns {@link HttpStatus} whose status code is {@code statusCode}.
     *
     * @param statusCode HTTP status code
     * @return {@link HttpStatus} of {@code statusCode}
     */
    public static HttpStatus of(int statusCode) {
        return Stream.of(HttpStatus.values())
                     .filter(status -> status.getStatusCode() == statusCode)
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException("HTTP status for status code [" + statusCode + "] is not defined."));
    }
}
