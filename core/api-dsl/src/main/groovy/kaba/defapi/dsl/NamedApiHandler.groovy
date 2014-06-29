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

    Api response(Closure cl) {
        def handler = new ResponseHandler()
        cl.delegate = handler
        cl.resolveStrategy = Closure.DELEGATE_ONLY
        this.api.response = cl()
        return this.api
    }
}

