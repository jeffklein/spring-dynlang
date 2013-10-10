package org.jeffklein.spring.dynlang.gosu;

import org.jeffklein.spring.dynlang.ScriptFactoryBase;
import org.jeffklein.spring.dynlang.ScriptInvocationHandlerFactory;
import org.springframework.scripting.ScriptCompilationException;
import org.springframework.scripting.ScriptFactory;
import org.springframework.scripting.ScriptSource;

import javax.script.ScriptException;
import java.io.IOException;

public class GosuScriptFactory extends ScriptFactoryBase implements ScriptFactory {

    public GosuScriptFactory(String scriptSourceLocator, Class[] scriptInterfaces) {
        super(scriptSourceLocator, scriptInterfaces);
    }

    public Object getScriptedObject(ScriptSource scriptSource, Class[] actualInterfaces) throws IOException, ScriptCompilationException {
        try {
            return ScriptInvocationHandlerFactory.createProxy(actualInterfaces, new GosuScriptInvocationHandler(scriptSource.getScriptAsString()));
        } catch (ScriptException e) {
            throw new ScriptCompilationException(scriptSource, e);
        }
    }

}
