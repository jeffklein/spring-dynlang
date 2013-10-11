var date
var locale
function hello(name) {
    return "Hello, " + name + " World!"
}

function addTwoNumbers(num1, num2) {
    return num1 + num2
}
function setDate(date) {
    this.date = date
}
function getDate() {
    return this.date
}
function setLocale(locale) {
    this.locale = locale
}
function getLocale() {
    return this.locale
}