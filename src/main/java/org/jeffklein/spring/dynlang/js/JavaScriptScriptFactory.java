package org.jeffklein.spring.dynlang.js;

import org.springframework.scripting.ScriptCompilationException;
import org.springframework.scripting.ScriptFactory;
import org.springframework.scripting.ScriptSource;

import javax.script.ScriptException;
import java.io.IOException;

/**
 * @author Tomasz Nurkiewicz
 * @since 2010-08-24, 22:58:28
 */
public class JavaScriptScriptFactory implements ScriptFactory {

    private String scriptSourceLocator;
    private Class[] scriptInterfaces;

    public JavaScriptScriptFactory(String scriptSourceLocator, Class[] scriptInterfaces) {
        this.scriptSourceLocator = scriptSourceLocator;
        this.scriptInterfaces = scriptInterfaces;
    }

    public String getScriptSourceLocator() {
        return scriptSourceLocator;
    }

    public Class[] getScriptInterfaces() {
        return scriptInterfaces;
    }

    public boolean requiresConfigInterface() {
        return true;
    }

    public Object getScriptedObject(ScriptSource scriptSource, Class[] actualInterfaces) throws IOException, ScriptCompilationException {
        try {
            return JavaScriptInvocationHandler.createJavaScriptProxy(scriptSource.getScriptAsString(), actualInterfaces);
        } catch (ScriptException e) {
            throw new ScriptCompilationException(scriptSource, e);
        }
    }

    public Class getScriptedObjectType(ScriptSource scriptSource) throws IOException, ScriptCompilationException {
        return null;
    }

    public boolean requiresScriptedObjectRefresh(ScriptSource scriptSource) {
        return scriptSource.isModified();
    }
}
