package org.jeffklein.spring.dynlang.js;

/**
 * Created with IntelliJ IDEA.
 * User: jklein
 * Date: 9/12/13
 * Time: 12:24 PM
 * To change this template use File | Settings | File Templates.
 */

import org.jeffklein.spring.dynlang.ScriptInvocationHandlerBase;
import org.springframework.util.ClassUtils;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class JavaScriptInvocationHandler extends ScriptInvocationHandlerBase implements InvocationHandler {

    public static JavaScriptHelloService createJavaScriptProxy(String script, Class[] actualInterfaces) throws IOException, ScriptException {
        return (JavaScriptHelloService) Proxy.newProxyInstance(
                ClassUtils.getDefaultClassLoader(),
                actualInterfaces,
                new JavaScriptInvocationHandler(script, actualInterfaces)
        );
    }

    private JavaScriptInvocationHandler(String script, Class[] interfaces) throws ScriptException {
        this.engine = new ScriptEngineManager().getEngineByName("JavaScript");
        engine.eval(script);
    }

}
