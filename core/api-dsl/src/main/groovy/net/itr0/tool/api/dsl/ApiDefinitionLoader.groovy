package net.itr0.tool.api.dsl

/**
 * API定義を読み込むクラス。
 *
 * @author ryotan
 * @since 1.0
 */
class ApiDefinitionLoader {

    static load(String dsl) {
        Script dslScript = new GroovyShell().parse(dsl)
        dslScript.metaClass = wrap(dslScript.class) { ExpandoMetaClass meta ->
            meta.apis = { Closure cl -> [:] }
        }
        dslScript.run()
    }

    static wrap(Class c, Closure cl) {
        def meta = new ExpandoMetaClass(c, false)
        cl(meta)
        meta.initialize()
        meta
    }
}
