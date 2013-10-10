package org.jeffklein.spring.dynlang;

import org.springframework.util.ClassUtils;

import javax.script.ScriptException;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 * User: jklein
 * Date: 10/10/13
 * Time: 4:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class ScriptInvocationHandlerFactory {
    public static Object createProxy(Class[] actualInterfaces, InvocationHandler handler) throws IOException, ScriptException {
        return Proxy.newProxyInstance(
                ClassUtils.getDefaultClassLoader(),
                actualInterfaces,
                handler
        );
    }
}
