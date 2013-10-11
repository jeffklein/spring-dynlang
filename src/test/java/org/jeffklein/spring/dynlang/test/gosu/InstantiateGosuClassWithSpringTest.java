package org.jeffklein.spring.dynlang.test.gosu;

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
public class InstantiateGosuClassWithSpringTest {
    @Autowired(required = true)
    @Qualifier(value = "classpathGosuHelloService")
    private HelloService.Hello classpathGosuHelloService;

    @Test
    public void testInstantiateGosuClassWithSpringTest() {
        Assert.assertNotNull( "expecting non-null service", classpathGosuHelloService );
        Assert.assertNotNull( classpathGosuHelloService.createHello() );
    }
}
