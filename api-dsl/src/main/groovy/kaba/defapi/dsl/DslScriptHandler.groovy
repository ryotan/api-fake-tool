package kaba.defapi.dsl

import kaba.defapi.ApiContainer

/**
 * API定義を読み込むクラス。
 *
 * @author ryotan
 * @since 1.0
 */
class DslScriptHandler {

    def handler = new ApiDefinitionHandler()

    ApiContainer load(String dsl) {
        Script script = new GroovyShell().parse(dsl)
        script.metaClass {
            defapi { Closure cl ->
                cl.delegate = this.handler
                cl.resolveStrategy = DELEGATE_ONLY
                return cl()
            }
        }

        script.run()
        return this.handler.container
    }
}
