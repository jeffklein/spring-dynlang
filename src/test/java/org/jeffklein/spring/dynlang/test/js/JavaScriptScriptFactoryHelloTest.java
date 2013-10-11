package org.jeffklein.spring.dynlang.test.js;

import org.jeffklein.spring.dynlang.test.HelloService;
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
@ContextConfiguration({"classpath:org/jeffklein/spring/dynlang/test/spring-beans-test.xml"})
public class JavaScriptScriptFactoryHelloTest {

    @Autowired(required = true)
    @Qualifier(value = "inlineJavaScriptHelloService")
    private HelloService inlineJavaScriptHelloService;

    @Autowired(required = true)
    @Qualifier(value = "classpathJavaScriptHelloService")
    private HelloService classpathJavaScriptHelloService;

    @Test
    public void testHelloWorldMaster() throws Exception {
        testHelloWorld(inlineJavaScriptHelloService);
        testHelloWorld(classpathJavaScriptHelloService);
    }
    private void testHelloWorld(HelloService helloService) throws Exception {
        final String name = "JavaScript";
        final String result = helloService.hello(name);
        System.out.println("Result from JS: "+result);
        Assert.assertNotNull(result);
        Assert.assertTrue(result.equals("Hello, JavaScript World!"));
    }

    @Test
    public void testAddTwoNumbersMaster() throws Exception {
        testAddTwoNumbers(inlineJavaScriptHelloService);
        testAddTwoNumbers(classpathJavaScriptHelloService);
    }
    private void testAddTwoNumbers(HelloService helloService) throws Exception {
        final double num1 = 23.2;
        final double num2 = 44.0;
        double result = helloService.addTwoNumbers(num1, num2);
        System.out.println("Result from JS: "+result);
        Assert.assertNotNull(result);
        Assert.assertEquals(67.2, result, 1e-15);
    }

    @Test
    public void testPropertyInjectionMaster() {
        testPropertyInjection(inlineJavaScriptHelloService);
        testPropertyInjection(classpathJavaScriptHelloService);
    }
    private void testPropertyInjection(HelloService helloService) {
        final Date dateFromJava = new Date();
        Date dateFromScript = helloService.getDate();
        Assert.assertNotNull(dateFromScript);
        // these are not the same date: one is created by spring. the other by this test.
        Assert.assertNotSame(dateFromJava.getTime(), dateFromScript.getTime());
    }

    @Test
    public void testChangeLocaleViaSetterMaster() {
        testChangeLocaleViaSetter(inlineJavaScriptHelloService);
        testChangeLocaleViaSetter(classpathJavaScriptHelloService);
    }
    private void testChangeLocaleViaSetter(HelloService helloService) {
        Locale localeBeforeSetter = helloService.getLocale();
        Assert.assertNotNull(localeBeforeSetter);
        Assert.assertEquals(Locale.US, localeBeforeSetter);
        helloService.setLocale(Locale.CANADA);
        Locale localeAfterSetter = helloService.getLocale();
        Assert.assertNotNull(localeAfterSetter);
        Assert.assertEquals(Locale.CANADA, localeAfterSetter);
    }
}