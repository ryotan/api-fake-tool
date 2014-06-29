package kaba.defapi.dsl

import kaba.defapi.http.HttpResponse

/**
 *
 * @author ryotan
 * @since 1.0
 */
class ResponseHandler {

    HttpResponse response

    ResponseHandler() {
        this.response = new HttpResponse()
    }

    HttpResponse contentType(String contentType) {
        this.response.contentType = contentType
        return this.response
    }

    HttpResponse body(String body) {
        this.response.body = body
        return this.response
    }
}
