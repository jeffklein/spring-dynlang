package org.jeffklein.spring.dynlang.gosu;

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

public class GosuScriptInvocationHandler extends ScriptInvocationHandlerBase implements InvocationHandler {

    public GosuScriptInvocationHandler(String script) throws ScriptException {
        this.engine = new ScriptEngineManager().getEngineByName("Gosu");
        engine.eval(script);
    }

}
