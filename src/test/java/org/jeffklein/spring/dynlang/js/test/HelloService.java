package org.jeffklein.spring.dynlang.js.test;

import java.util.Date;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: jklein
 * Date: 9/11/13
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */
public interface HelloService {
    String hello(String name);
    double addTwoNumbers(double int1, double int2);
    void setLocale(Locale locale);
    Locale getLocale();
    // notice there is no setDate(), but there is one on the js impls that spring injects into.
    Date getDate();
}
