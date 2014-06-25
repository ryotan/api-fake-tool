package net.itr0.tool.api.dsl

import net.itr0.tool.api.ApiDefinitionContainer

/**
 * API定義を読み込むクラス。
 *
 * @author ryotan
 * @since 1.0
 */
class DslScriptHandler {

    static ApiDefinitionContainer load(String dsl) {
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
