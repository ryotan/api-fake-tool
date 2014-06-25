package net.itr0.tool.api.dsl

import net.itr0.tool.api.Api
import net.itr0.tool.api.ApiDefinitionContainer

/**
 *
 * @author ryotan
 * @since 1.0
 */
class ApiDefinitionHandler {

    ApiDefinitionContainer container = new ApiDefinitionContainer()

    def methodMissing(String name, args) {
        if (!(args.size() == 1 && Closure.isAssignableFrom(args.first().class))) {
            throw new MissingMethodException(name, this.class, args as Object[])
        }

        Closure<Api> cl = args.first()

        def handler = new NamedApiHandler(name)
        cl.delegate = handler
        cl.resolveStrategy = Closure.DELEGATE_FIRST
        cl()

        container.add(new Api(name))
    }
}

class NamedApiHandler {

    static final HttpMethod POST = HttpMethod.POST

    NamedApiHandler(String name) {
    }

    def path(String path) {
    }

    def method(HttpMethod method) {
    }

    def contentType(String media) {
    }
}

enum HttpMethod {

    GET,
    POST,
    PUT,
    DELETE
}
