package org.jeffklein.spring.dynlang;

import org.springframework.scripting.config.LangNamespaceHandler;
import org.springframework.scripting.config.ScriptingDefaultsParser;

/**
 * HACK ALERT: had to copy this class
 * (org.springframework.scripting.config.ConfigurableLangNamespaceHandler)
 * from the spring source itself because
 * the original author made it impossible to extend.
 * The problem is that the registerScriptBeanDefinitionParser is private,
 * and the ScriptBeanDefinitionParser class it uses is not a public
 * class (it is only visible within its own package).
 *
 * TODO: make this class live up to its name by externalizing the strings in spring config (perhaps injecting them as a Map)
 */
public class ConfigurableLangNamespaceHandler extends LangNamespaceHandler {

    public void init() {
        registerScriptBeanDefinitionParser("groovy", "org.springframework.scripting.groovy.GroovyScriptFactory");
        registerScriptBeanDefinitionParser("jruby", "org.springframework.scripting.jruby.JRubyScriptFactory");
        registerScriptBeanDefinitionParser("bsh", "org.springframework.scripting.bsh.BshScriptFactory");
        registerScriptBeanDefinitionParser("js", "org.jeffklein.spring.dynlang.js.JavaScriptScriptFactory");
        registerScriptBeanDefinitionParser("gosu", "org.jeffklein.spring.dynlang.gosu.GosuScriptFactory");
        registerBeanDefinitionParser("defaults", new ScriptingDefaultsParser());
    }

    private void  registerScriptBeanDefinitionParser(String key, String scriptFactoryClassName) {
        registerBeanDefinitionParser(key, new ScriptBeanDefinitionParser(scriptFactoryClassName));
    }
}