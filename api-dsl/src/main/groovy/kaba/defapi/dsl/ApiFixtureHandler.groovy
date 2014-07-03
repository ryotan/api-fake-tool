package kaba.defapi.dsl

import kaba.defapi.fixture.ApiFixture
import kaba.defapi.fixture.ApiFixtureContainer

/**
 *
 * @author ryotan
 * @since 1.0
 */
class ApiFixtureHandler {

    ApiFixtureContainer fixtures = new ApiFixtureContainer();

    def methodMissing(String name, args) {
        if (!(args.size() == 1 && Closure.isAssignableFrom(args.first().class))) {
            throw new MissingMethodException(name, this.class, args as Object[])
        }

        Closure<ApiFixture> cl = args.first()

        def handler = new SoleApiFixtureHandler(name)
        cl.delegate = handler
        cl.resolveStrategy = Closure.DELEGATE_ONLY
        cl()

        def fixture = handler.fixture
        fixtures.add(fixture)
    }
}

class SoleApiFixtureHandler {

    ApiFixture fixture = new ApiFixture()

    SoleApiFixtureHandler(String name) {
        this.fixture.name = name
    }

    ApiFixture request(Map<String, Object> request) {
        this.fixture.params = request
        return this.fixture
    }

    ApiFixture response(String body) {
        this.fixture.body = body
        return this.fixture
    }
}
