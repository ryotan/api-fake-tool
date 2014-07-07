package kaba.defapi.dsl.api

import kaba.defapi.Api
import kaba.defapi.dsl.fixture.ApiFixtureHandler
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
        def handler = new HttpResponseDefHandler()
        cl.delegate = handler
        cl.resolveStrategy = Closure.DELEGATE_ONLY
        this.api.response = cl()
        return this.api
    }

    Api fixtures(Closure cl) {
        def handler = new ApiFixtureHandler()
        cl.delegate = handler
        cl.resolveStrategy = Closure.DELEGATE_ONLY
        cl()

        this.api.fixtures = handler.fixtures
        return this.api
    }
}

