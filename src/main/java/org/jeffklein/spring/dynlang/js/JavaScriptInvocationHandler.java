package org.jeffklein.spring.dynlang.js;

/**
 * Created with IntelliJ IDEA.
 * User: jklein
 * Date: 9/12/13
 * Time: 12:24 PM
 * To change this template use File | Settings | File Templates.
 */

import org.springframework.util.ClassUtils;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JavaScriptInvocationHandler implements InvocationHandler {
    
    private final ScriptEngine engine;

    public static HelloService createJavaScriptProxy(String script, Class[] actualInterfaces) throws IOException, ScriptException {
        return (HelloService) Proxy.newProxyInstance(
                ClassUtils.getDefaultClassLoader(),
                actualInterfaces,
                new JavaScriptInvocationHandler(script, actualInterfaces)
        );
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //System.out.println(proxy + " / " + method + " / " + args);
        return ((Invocable) engine).invokeFunction(method.getName(), args);
    }

    private JavaScriptInvocationHandler(String script, Class[] interfaces) throws ScriptException {
        this.engine = new ScriptEngineManager().getEngineByName("JavaScript");
        engine.eval(script);
        //System.out.println(script);
    }

}