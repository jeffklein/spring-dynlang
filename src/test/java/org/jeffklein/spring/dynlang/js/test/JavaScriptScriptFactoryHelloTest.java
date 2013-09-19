package org.jeffklein.spring.dynlang.js.test;

import org.jeffklein.spring.dynlang.js.HelloService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
    public void shouldReturnHelloStringFromJs() throws Exception {

        final String name = "Tomek";

        final String result = javaScriptHelloService.hello(name);

        Assert.assertNotNull(result);

        Assert.assertTrue(result.equals("Hello, Tomek!"));

    }

}