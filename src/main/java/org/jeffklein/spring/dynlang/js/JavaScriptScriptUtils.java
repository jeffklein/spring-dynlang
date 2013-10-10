package org.jeffklein.spring.dynlang.js;

/**
 * Created with IntelliJ IDEA.
 * User: jklein
 * Date: 9/12/13
 * Time: 12:24 PM
 * To change this template use File | Settings | File Templates.
 */

import org.springframework.scripting.ScriptSource;
import org.springframework.util.ClassUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Tomasz Nurkiewicz
 * @since 2010-09-21, 23:05:20
 */
public class JavaScriptScriptUtils {
    public static HelloService createJavaScriptObject(String script, Class[] actualInterfaces) throws IOException, ScriptException {
        return (HelloService) Proxy.newProxyInstance(
                ClassUtils.getDefaultClassLoader(),
                actualInterfaces,
                new JavaScriptInvocationHandler(script, actualInterfaces)
        );
    }

    private static class JavaScriptInvocationHandler implements InvocationHandler {
        private final ScriptEngine engine;
        private final Class[] interfaces;
        private String script;

        private JavaScriptInvocationHandler(String script, Class[] interfaces) throws ScriptException {
            this.interfaces = interfaces;
            this.engine = new ScriptEngineManager().getEngineByName("JavaScript");
            this.script = script;
            engine.eval(script);
            //System.out.println(script);
        }

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (ReflectionUtils.isEqualsMethod(method))
                return equals(args[0]);
            if (ReflectionUtils.isHashCodeMethod(method))
                return this.hashCode();
            if (ReflectionUtils.isToStringMethod(method))
                return toString();
            //System.out.println(proxy + " / " + method + " / " + args);
            return ((Invocable) engine).invokeFunction(method.getName(), args);
        }
    }
}
