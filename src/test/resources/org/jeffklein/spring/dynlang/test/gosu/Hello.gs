package org.jeffklein.spring.dynlang.test.gosu

uses java.util.Date
uses java.util.Locale

public class Hello {

    var date : Date
    var locale : Locale

    function hello(name : String) : String {
        return "Hello, " + name + "!"
    }
    function addTwoNumbers(num1 : double, num2 : double) : double {
        return num1 + num2
    }
    function setDate(_date : Date) {
        print("date in Gosu: " + _date.toString() + "\n")
        date = _date
    }
    function getDate() : Date {
        return date
    }
    function setLocale(_locale : Locale) {
        print("locale in Gosu: " + _locale.toString() + "\n")
        locale = _locale
    }
    function getLocale() : Locale {
        return locale
    }
}