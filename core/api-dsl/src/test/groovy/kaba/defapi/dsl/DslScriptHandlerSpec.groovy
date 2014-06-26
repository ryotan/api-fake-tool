package kaba.defapi.dsl

import kaba.defapi.http.HttpMethod
import spock.lang.Shared
import spock.lang.Specification

/**
 * Spec for {@link DslScriptHandler}
 *
 * @author ryotan
 * @since 1.0
 */
class DslScriptHandlerSpec extends Specification {

    @Shared
    def sut = new DslScriptHandler()

    def "DslScriptHandler#load(String)で、defapi{}を読み込めること。"() {
        given:
        def dsl = """
                | defapi {
                |   "empty" {
                |   }
                | }
                | """.stripMargin('|')

        when:
        def loaded = sut.load(dsl)

        then:
        loaded["api-name"] == null
    }

    def "DslScriptHandler#load(String)で、defapi{\"api-name\"{}}を読み込めること。"() {
        given:
        def dsl = """
                | defapi {
                |   "api1" {
                |     path "/books/{id:[0-9]{8}}/edit"
                |     method POST
                |     contentType "application/json"
                |   }
                | }
                | """.stripMargin('|')

        when:
        def loaded = sut.load(dsl)

        then:
        loaded["api1"].with {
            name == "api1"
            path == "/books/{id:[0-9]{8}}/edit"
            method == HttpMethod.POST
            contentType == "application/json"
        }
    }

    def "DslScriptHandler#load(String)で、defapi{\"api-name\"{}}を読み込めること。その２"() {
        given:
        def dsl = """
                | defapi {
                |   "api2" {
                |     path "/books/{id:[0-9]{8}}/edit"
                |     method POST
                |     contentType "application/json"
                |   }
                | }
                | """.stripMargin('|')

        when:
        def loaded = sut.load(dsl)

        then:
        loaded["api1"].with {
            name == "api1"
            path == "/books/{id:[0-9]{8}}/edit"
            method == HttpMethod.POST
            contentType == "application/json"
        }
    }
}
