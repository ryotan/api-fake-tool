package kaba.defapi.dsl

/**
 *
 * @author ryotan
 * @since 1.0
 */
class ResponseHandler {

    String contentType
    String body

    ResponseHandler contentType(String contentType) {
        this.contentType = contentType
        return this
    }

    ResponseHandler body(String body) {
        this.body = body
        return this
    }
}
