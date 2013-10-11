package org.jeffklein.spring.dynlang.test.mixed;

import junit.framework.Assert;
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

    @Autowired(required = true)
    @Qualifier(value = "javaMixedLanguageService")
    private MixedLanguageService javaMixedLanguageService;

    @Test
    public void testGosuInsideJavaScript() {
        System.out.println("testGosuInsideJavaScript(): " + inlineJavaScriptMixedLanguageService.getLanguageHierarchy());
        Assert.assertEquals("JavaScript", inlineJavaScriptMixedLanguageService.getLanguageName());
        Assert.assertEquals("Gosu inside JavaScript", inlineJavaScriptMixedLanguageService.getLanguageHierarchy());
    }

    @Test
    public void testJavaScriptInsideGosu() {
        System.out.println("testJavaScriptInsideGosu(): " + inlineGosuMixedLanguageService.getLanguageHierarchy());
        Assert.assertEquals("Gosu", inlineGosuMixedLanguageService.getLanguageName());
        Assert.assertEquals("JavaScript inside Gosu", inlineGosuMixedLanguageService.getLanguageHierarchy());
    }

    @Test
    public void testGosuInsideJava() {
        System.out.println("testGosuInsideJava(): " + javaMixedLanguageService.getLanguageHierarchy());
        Assert.assertEquals("Java", javaMixedLanguageService.getLanguageName());
        Assert.assertEquals("Gosu inside Java", javaMixedLanguageService.getLanguageHierarchy());
    }

    @Test
    public void testJavaScriptInsideJava() {
        ((JavaMixedLanguageService) javaMixedLanguageService).setGuestLanguageService(inlineJavaScriptMixedLanguageService);
        System.out.println("testJavaScriptInsideJava(): " + javaMixedLanguageService.getLanguageHierarchy());
        Assert.assertEquals("Java", javaMixedLanguageService.getLanguageName());
        Assert.assertEquals("JavaScript inside Java", javaMixedLanguageService.getLanguageHierarchy());
    }
}