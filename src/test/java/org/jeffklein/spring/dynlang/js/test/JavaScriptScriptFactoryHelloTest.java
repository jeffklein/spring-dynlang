package org.jeffklein.spring.dynlang.js.test;

import org.jeffklein.spring.dynlang.js.HelloService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: jklein
 * Date: 9/11/13
 * Time: 4:27 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:org/jeffklein/spring/dynlang/js/test/spring-beans-test.xml"})
public class JavaScriptScriptFactoryHelloTest {

    @Autowired
    private HelloService javaScriptHelloService;

    @Test
    public void testHelloFromJs() throws Exception {
        final String name = "World";
        final String result = javaScriptHelloService.hello(name);
        System.out.println("Result from JS: "+result);
        Assert.assertNotNull(result);
        Assert.assertTrue(result.equals("Hello, World!"));
    }

    @Test
    public void testHelloParameterizedFromJs() throws Exception {
        final String name = "Jeff";
        final int age = 44;
        String result = javaScriptHelloService.helloParameterized(name, age, Locale.US);
        System.out.println("Result from JS: "+result);
        Assert.assertNotNull(result);
    }

    @Test
    public void testPropertyInjection() {
        final Date dateFromJava = new Date();
        //javaScriptHelloService.setDate(date);
        Date dateFromJs = javaScriptHelloService.getDate();
        Assert.assertNotNull(dateFromJs);
        // these are not the same date: one is created by spring. the other by this test.
        Assert.assertNotSame(dateFromJava, dateFromJs);
    }
}