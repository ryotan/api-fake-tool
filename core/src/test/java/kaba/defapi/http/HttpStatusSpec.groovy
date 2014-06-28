package kaba.defapi.http

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Spec for {@link HttpStatus}
 *
 * @author ryotan
 * @since 1.0
 */
class HttpStatusSpec extends Specification {

    @Unroll
    def "HttpStatus.of(#code) should be #status."() {
        expect:
        HttpStatus.of(code) == status

        where:
        status               | code
        HttpStatus.OK        | 200
        HttpStatus.FOUND     | 302
        HttpStatus.SEE_OTHER | 303
    }

    def "HttpStatus.of(int) throws Exception when matching status doesn't exist."() {
        given:
        def nonExist = 999

        when:
        HttpStatus.of(nonExist)

        then:
        def e = thrown(IllegalArgumentException)
        e.message.contains(String.valueOf(nonExist))
    }

    @Unroll
    def "#status should have status code: #code, message: #message. (RFC 2616)."() {
        expect:
        status.getStatusCode() == code
        status.getMessage() == message

        where:
        status                                     | code | message
        HttpStatus.CONTINUE                        | 100  | "Continue"
        HttpStatus.SWITCHING_PROTOCOLS             | 101  | "Switching Protocols"

        HttpStatus.OK                              | 200  | "OK"
        HttpStatus.CREATED                         | 201  | "Created"
        HttpStatus.ACCEPTED                        | 202  | "Accepted"
        HttpStatus.NON_AUTHORITATIVE_INFORMATION   | 203  | "Non-Authoritative Information"
        HttpStatus.NO_CONTENT                      | 204  | "No Content"
        HttpStatus.RESET_CONTENT                   | 205  | "Reset Content"
        HttpStatus.PARTIAL_CONTENT                 | 206  | "Partial Content"

        HttpStatus.MULTIPLE_CHOICES                | 300  | "Multiple Choices"
        HttpStatus.MOVED_PERMANENTLY               | 301  | "Moved Permanently"
        HttpStatus.FOUND                           | 302  | "Found"
        HttpStatus.SEE_OTHER                       | 303  | "See Other"
        HttpStatus.NOT_MODIFIED                    | 304  | "Not Modified"
        HttpStatus.USE_PROXY                       | 305  | "Use Proxy"
        HttpStatus.UNUSED_306                      | 306  | "Unused"
        HttpStatus.TEMPORARY_REDIRECT              | 307  | "Temporary Redirect"

        HttpStatus.BAD_REQUEST                     | 400  | "Bad Request"
        HttpStatus.UNAUTHORIZED                    | 401  | "Unauthorized"
        HttpStatus.PAYMENT_REQUIRED                | 402  | "Payment Required"
        HttpStatus.FORBIDDEN                       | 403  | "Forbidden"
        HttpStatus.NOT_FOUND                       | 404  | "Not Found"
        HttpStatus.METHOD_NOT_ALLOWED              | 405  | "Method Not Allowed"
        HttpStatus.NOT_ACCEPTABLE                  | 406  | "Not Acceptable"
        HttpStatus.PROXY_AUTHENTICATION_REQUIRED   | 407  | "Proxy Authentication Required"
        HttpStatus.REQUEST_TIMEOUT                 | 408  | "Request Timeout"
        HttpStatus.CONFLICT                        | 409  | "Conflict"
        HttpStatus.GONE                            | 410  | "Gone"
        HttpStatus.LENGTH_REQUIRED                 | 411  | "Length Required"
        HttpStatus.PRECONDITION_FAILED             | 412  | "Precondition Failed"
        HttpStatus.REQUEST_ENTITY_TOO_LARGE        | 413  | "Request Entity Too Large"
        HttpStatus.REQUEST_URI_TOO_LONG            | 414  | "Request-URI Too Long"
        HttpStatus.UNSUPPORTED_MEDIA_TYPE          | 415  | "Unsupported Media Type"
        HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE | 416  | "Requested Range Not Satisfiable"
        HttpStatus.EXPECTATION_FAILED              | 417  | "Expectation Failed"

        HttpStatus.INTERNAL_SERVER_ERROR           | 500  | "Internal Server Error"
        HttpStatus.NOT_IMPLEMENTED                 | 501  | "Not Implemented"
        HttpStatus.BAD_GATEWAY                     | 502  | "Bad Gateway"
        HttpStatus.SERVICE_UNAVAILABLE             | 503  | "Service Unavailable"
        HttpStatus.GATEWAY_TIMEOUT                 | 504  | "Gateway Timeout"
        HttpStatus.HTTP_VERSION_NOT_SUPPORTED      | 505  | "HTTP Version Not Supported"
    }
}
