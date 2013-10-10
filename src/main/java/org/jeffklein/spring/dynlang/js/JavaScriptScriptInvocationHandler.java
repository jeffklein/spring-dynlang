package org.jeffklein.spring.dynlang.js;

/**
 * Created with IntelliJ IDEA.
 * User: jklein
 * Date: 9/12/13
 * Time: 12:24 PM
 * To change this template use File | Settings | File Templates.
 */

import org.jeffklein.spring.dynlang.ScriptInvocationHandlerBase;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.lang.reflect.InvocationHandler;

public class JavaScriptScriptInvocationHandler extends ScriptInvocationHandlerBase implements InvocationHandler {

    public JavaScriptScriptInvocationHandler(String script) throws ScriptException {
        this.engine = new ScriptEngineManager().getEngineByName("JavaScript");
        engine.eval(script);
    }

}
