package kaba.defapi.dsl

import kaba.defapi.Api
import kaba.defapi.ApiContainer
import kaba.defapi.http.HttpMethod
import spock.lang.Specification

/**
 * Spec for {@link DslScriptHandler}
 *
 * @author ryotan
 * @since 1.0
 */
class DslScriptHandlerSpec extends Specification {

    def sut = new DslScriptHandler()

    def "空のAPI定義は、ロードしてもコンテナには追加されないこと。"() {
        given:
        def dsl = """
                | defapi {
                |   "empty closure" {
                |   }
                | }
                | """.stripMargin('|')

        when:
        def loaded = sut.load(dsl)

        then:
        loaded["api-name"] == null
    }

    def "API定義ブロックを読み込めること。複数回読み込んだときは、コンテナに追加されること。"() {
        given:
        def dsl = """
                | defapi {
                |   "api1" {
                |     path "/books/{id:[0-9]{8}}/edit"
                |     method POST
                |   }
                | }
                | """.stripMargin('|')
        def dsl2 = """
                | defapi {
                |   "api2" {
                |     path "/books/{id}"
                |     method GET
                |   }
                | }
                | """.stripMargin('|')

        when:
        sut.load(dsl)
        ApiContainer loaded = sut.load(dsl2)

        then:
        Api api1 = loaded.get("api1")
        api1.name == "api1"
        api1.path == "/books/{id:[0-9]{8}}/edit"
        api1.method == HttpMethod.POST

        Api api2 = loaded.get("api2")
        api2.name == "api2"
        api2.path == "/books/{id}"
        api2.method == HttpMethod.GET
    }

    def "API定義の中のresponseブロックを読み込めること。"() {
        given:
        def dsl = """
                | defapi {
                |   "api1" {
                |     path "/books/{id}/edit"
                |     method POST
                |
                |     response {
                |       contentType "application/json"
                |       body \"""
                |         {
                |           "bookId": "Description of 'bookId'"
                |           , "isbn": "Description of 'isbn'"
                |           , "title": "Description of 'title'"
                |           , "author": "Description of 'author'"
                |         }
                |         \"""
                |     }
                |   }
                | }
                | """.stripMargin('|')

        when:
        ApiContainer loaded = sut.load(dsl)

        then:
        def api = loaded.get("api1")
        def res = api.response

        api.name == "api1"
        api.path == "/books/{id}/edit"
        res.contentType == "application/json"
        res.body == """
                |         {
                |           "bookId": "Description of 'bookId'"
                |           , "isbn": "Description of 'isbn'"
                |           , "title": "Description of 'title'"
                |           , "author": "Description of 'author'"
                |         }
                |         """.stripMargin('|')
    }
}
