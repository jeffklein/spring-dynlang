var date
var locale
function hello(name) {
    return "Hello, " + name + "!"
}

function addTwoNumbers(num1, num2) {
    return num1 + num2
}
function setDate(date) {
    print('date in js: ' + date.toString() + '\n')
    this.date = date
}
function getDate() {
    return this.date
}
function setLocale(locale) {
    print('locale in js: ' + locale.toString() + '\n')
    this.locale = locale
}
function getLocale() {
    return this.locale
}