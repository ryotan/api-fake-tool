package kaba.defapi.dsl

import spock.lang.Specification
/**
 * Spec for {@link DslScriptHandler}
 *
 * @author ryotan
 * @since 1.0
 */
class DslScriptHandlerSpec extends Specification {

    def "DslScriptHandler#load(String)で、defapi{}を読み込めること。"() {
        given:
        def dsl = """
                | defapi {
                |   "api-name" {
                |     // path "/books/{id:[0-9]{8}}/edit"
                |     // method POST
                |     // contentType "application/json"
                |   }
                | }
                | """.stripMargin('|')

        when:
        def loaded = DslScriptHandler.load(dsl)

        then:
        loaded["api-name"].with {
            name == "api-name"
        }
    }
}