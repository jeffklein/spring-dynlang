package org.jeffklein.spring.dynlang.test.mixed;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
@ContextConfiguration({"classpath:org/jeffklein/spring/dynlang/test/mixed/spring-beans-test-mixed.xml"})
public class MixedLanguageTest {

    @Autowired(required = true)
    @Qualifier(value = "inlineJavaScriptMixedLanguageService")
    private MixedLanguageService inlineJavaScriptMixedLanguageService;

    @Autowired(required = true)
    @Qualifier(value = "inlineGosuMixedLanguageService")
    private MixedLanguageService inlineGosuMixedLanguageService;

    @Test
    public void testGosuInsideJavaScript() {
        System.out.println("testGosuInsideJavaScript(): " + inlineJavaScriptMixedLanguageService.getLanguageHierarchy());
    }

    @Test
    public void testJavaScriptInsideGosu() {
        System.out.println("testJavaScriptInsideGosu(): " + inlineGosuMixedLanguageService.getLanguageHierarchy());
    }
}