package org.jeffklein.spring.dynlang;

import org.springframework.scripting.ScriptCompilationException;
import org.springframework.scripting.ScriptFactory;
import org.springframework.scripting.ScriptSource;

import java.io.IOException;

public abstract class ScriptFactoryBase implements ScriptFactory {

    private String scriptSourceLocator;
    private Class[] scriptInterfaces;

    public ScriptFactoryBase(String scriptSourceLocator, Class[] scriptInterfaces) {
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

    public abstract Object getScriptedObject(ScriptSource scriptSource, Class[] actualInterfaces) throws IOException, ScriptCompilationException;

    public Class getScriptedObjectType(ScriptSource scriptSource) throws IOException, ScriptCompilationException {
        return scriptInterfaces[0];
    }

    public boolean requiresScriptedObjectRefresh(ScriptSource scriptSource) {
        return scriptSource.isModified();
    }
}
