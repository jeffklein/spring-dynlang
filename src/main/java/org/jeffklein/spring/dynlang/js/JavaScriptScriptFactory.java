package org.jeffklein.spring.dynlang.js;

import org.jeffklein.spring.dynlang.ScriptFactoryBase;
import org.jeffklein.spring.dynlang.ScriptInvocationHandlerFactory;
import org.springframework.scripting.ScriptCompilationException;
import org.springframework.scripting.ScriptFactory;
import org.springframework.scripting.ScriptSource;

import javax.script.ScriptException;
import java.io.IOException;

public class JavaScriptScriptFactory extends ScriptFactoryBase implements ScriptFactory {

    public JavaScriptScriptFactory(String scriptSourceLocator, Class[] scriptInterfaces) {
        super(scriptSourceLocator, scriptInterfaces);
    }

    public Object getScriptedObject(ScriptSource scriptSource, Class[] actualInterfaces) throws IOException, ScriptCompilationException {
        try {
            return ScriptInvocationHandlerFactory.createProxy(actualInterfaces, new JavaScriptScriptInvocationHandler(scriptSource.getScriptAsString()));
        } catch (ScriptException e) {
            throw new ScriptCompilationException(scriptSource, e);
        }
    }

}
