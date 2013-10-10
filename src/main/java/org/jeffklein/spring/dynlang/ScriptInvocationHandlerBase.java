package org.jeffklein.spring.dynlang;

/**
 * Created with IntelliJ IDEA.
 * User: jklein
 * Date: 9/12/13
 * Time: 12:24 PM
 * To change this template use File | Settings | File Templates.
 */

import javax.script.Invocable;
import javax.script.ScriptEngine;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public abstract class ScriptInvocationHandlerBase implements InvocationHandler {

    protected ScriptEngine engine = null;

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return ((Invocable) engine).invokeFunction(method.getName(), args);
    }

}
