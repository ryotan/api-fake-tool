package kaba.defapi.dsl

import kaba.defapi.http.HttpResponseDef

/**
 *
 * @author ryotan
 * @since 1.0
 */
class ResponseHandler {

    HttpResponseDef response

    ResponseHandler() {
        this.response = new HttpResponseDef()
    }

    HttpResponseDef contentType(String contentType) {
        this.response.contentType = contentType
        return this.response
    }

    HttpResponseDef body(String body) {
        this.response.body = body
        return this.response
    }
}
