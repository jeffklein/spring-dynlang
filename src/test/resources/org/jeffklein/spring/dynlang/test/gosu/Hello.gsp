uses java.util.Date
uses java.util.Locale

var date : Date
var locale : Locale

function hello(name : String) : String {
    return "Hello, " + name + " World!"
}
function addTwoNumbers(num1 : double, num2 : double) : double {
    return num1 + num2
}
function setDate(_date : Date) {
    date = _date
}
function getDate() : Date {
    return date
}
function setLocale(_locale : Locale) {
    locale = _locale
}
function getLocale() : Locale {
    return locale
}