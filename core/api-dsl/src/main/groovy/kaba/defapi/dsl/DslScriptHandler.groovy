package kaba.defapi.dsl

import kaba.defapi.ApiContainer

/**
 * API定義を読み込むクラス。
 *
 * @author ryotan
 * @since 1.0
 */
class DslScriptHandler {

    static ApiContainer load(String dsl) {
        Script script = new GroovyShell().parse(dsl)
        def handler = new ApiDefinitionHandler()
        script.metaClass {
            defapi { Closure cl ->
                cl.delegate = handler
                cl.resolveStrategy = DELEGATE_ONLY
                return cl()
            }
        }
        script.run()
        return handler.container
    }
}
