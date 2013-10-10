package org.jeffklein.spring.dynlang.js.test;

import org.jeffklein.spring.dynlang.js.JavaScriptHelloService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Autowired(required = true)
    @Qualifier(value = "inlineJavascriptHelloService")
    private JavaScriptHelloService inlineJavascriptHelloService;

    @Autowired(required = true)
    @Qualifier(value = "classpathJavascriptHelloService")
    private JavaScriptHelloService classpathJavascriptHelloService;

    @Test
    public void testHelloFromJsMaster() throws Exception {
        testHelloFromJs(inlineJavascriptHelloService);
        testHelloFromJs(classpathJavascriptHelloService);
    }
    private void testHelloFromJs(JavaScriptHelloService helloService) throws Exception {
        final String name = "World";
        final String result = helloService.hello(name);
        System.out.println("Result from JS: "+result);
        Assert.assertNotNull(result);
        Assert.assertTrue(result.equals("Hello, World!"));
    }

    @Test
    public void testAddTwoIntsMaster() throws Exception {
        testAddTwoInts(inlineJavascriptHelloService);
        testAddTwoInts(classpathJavascriptHelloService);
    }
    private void testAddTwoInts(JavaScriptHelloService helloService) throws Exception {
        final double num1 = 23.2;
        final double num2 = 44.0;
        double result = helloService.addTwoNumbers(num1, num2);
        System.out.println("Result from JS: "+result);
        Assert.assertNotNull(result);
        Assert.assertEquals(67.2, result, 1e-15);
    }

    @Test
    public void testPropertyInjectionMaster() {
        testPropertyInjection(inlineJavascriptHelloService);
        testPropertyInjection(classpathJavascriptHelloService);
    }
    private void testPropertyInjection(JavaScriptHelloService helloService) {
        final Date dateFromJava = new Date();
        Date dateFromJs = helloService.getDate();
        Assert.assertNotNull(dateFromJs);
        // these are not the same date: one is created by spring. the other by this test.
        Assert.assertNotSame(dateFromJava.getTime(), dateFromJs.getTime());
    }

    @Test
    public void testChangeLocaleViaSetterMaster() {
        testChangeLocaleViaSetter(inlineJavascriptHelloService);
        testChangeLocaleViaSetter(classpathJavascriptHelloService);
    }
    private void testChangeLocaleViaSetter(JavaScriptHelloService helloService) {
        Locale localeBeforeSetter = helloService.getLocale();
        Assert.assertNotNull(localeBeforeSetter);
        Assert.assertEquals(Locale.US, localeBeforeSetter);
        helloService.setLocale(Locale.CANADA);
        Locale localeAfterSetter = helloService.getLocale();
        Assert.assertNotNull(localeAfterSetter);
        Assert.assertEquals(Locale.CANADA, localeAfterSetter);
    }
}