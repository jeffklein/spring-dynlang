//package org.jeffklein.spring.dynlang.test.gosu

uses java.util.Date
uses java.util.Locale
uses org.jeffklein.spring.dynlang.test.HelloService

public class Hello implements HelloService {

    var date : Date as readonly Date
    var locale : Locale as Locale

    function hello(name : String) : String {
        return "Hello, " + name + "!"
    }
    function addTwoNumbers(num1 : double, num2 : double) : double {
        return num1 + num2
    }
}

function createHello() : HelloService {
  return new Hello()
}