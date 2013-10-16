package org.jeffklein.spring.dynlang.test.refresh;

import org.jeffklein.spring.dynlang.test.HelloService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IntelliJ IDEA.
 * User: jklein
 * Date: 10/11/13
 * Time: 1:12 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:org/jeffklein/spring/dynlang/test/spring-beans-test.xml"})
public class RefreshCheckDelayTest {
    /*@Autowired(required = true)
    @Qualifier(value = "classpathGosuHelloService")
    private HelloService.Hello classpathGosuHelloService;*/

    @Test
    public void testRefreshCheckDelay() {
        //HelloService helloService = classpathGosuHelloService.createHello();
        System.out.println("testRefreshCheckDelay(): looping. waiting for changes in script file...");
        /*while (true) {
            Assert.assertEquals("Hello, Jeff!", helloService.hello("Jeff"));
        }*/
    }
}
