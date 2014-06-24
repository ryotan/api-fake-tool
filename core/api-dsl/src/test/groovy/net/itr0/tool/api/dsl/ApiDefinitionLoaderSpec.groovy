package net.itr0.tool.api.dsl;

import spock.lang.Specification

/**
 * Spec for {@link ApiDefinitionLoader}
 *
 * @author ryotan
 * @since 1.0
 */
class ApiDefinitionLoaderSpec extends Specification {

    def "ApiDefinitionLoader#load(String)で、apis{}を読み込めること。"() {
        given:
        def dsl = """
                | apis {
                | }
                  """.stripMargin('|')

        when:
        def loaded = ApiDefinitionLoader.load(dsl)

        then:
        loaded == [:]
    }
}
