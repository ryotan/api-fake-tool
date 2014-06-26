package kaba.defapi.dsl

import kaba.defapi.Api
import kaba.defapi.ApiContainer

/**
 *
 * @author ryotan
 * @since 1.0
 */
class ApiDefinitionHandler {

    ApiContainer container = new ApiContainer()

    def methodMissing(String name, args) {
        if (!(args.size() == 1 && Closure.isAssignableFrom(args.first().class))) {
            throw new MissingMethodException(name, this.class, args as Object[])
        }

        Closure<Api> cl = args.first()

        def handler = new NamedApiHandler(name)
        cl.delegate = handler
        cl.resolveStrategy = Closure.DELEGATE_FIRST


        Api api = cl()
        api ? container.add(api) : container
    }
}
