package kaba.defapi.dsl

import kaba.defapi.Api
import kaba.defapi.http.HttpMethod

/**
 *
 * @author ryotan
 * @since 1.0
 */
class NamedApiHandler {

    static final HttpMethod GET = HttpMethod.GET
    static final HttpMethod POST = HttpMethod.POST
    static final HttpMethod PUT = HttpMethod.PUT
    static final HttpMethod DELETE = HttpMethod.DELETE

    Api api

    NamedApiHandler(String name) {
        this.api = new Api(name)
    }

    Api path(String path) {
        this.api.path = path
        return this.api
    }

    Api method(HttpMethod method) {
        this.api.method = method
        return this.api
    }

    Api contentType(String media) {
        this.api.contentType = media
        return this.api
    }
}

