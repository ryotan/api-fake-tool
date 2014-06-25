package kaba.defapi.dsl

import kaba.defapi.Api
import kaba.defapi.HttpMethod

/**
 *
 * @author ryotan
 * @since 1.0
 */
class NamedApiHandler {

    static final HttpMethod POST = HttpMethod.POST
    Api api

    NamedApiHandler(String name) {
        this.api = new Api(name)
    }

    def path(String path) {
    }

    def method(HttpMethod method) {
    }

    def contentType(String media) {
    }
}

