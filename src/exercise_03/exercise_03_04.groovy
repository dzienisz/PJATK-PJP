import groovy.json.JsonSlurper

import java.text.DecimalFormat

println "1. Napisać wyrażenie regularne, za pomoca którego mozna odnaleźć w tekście dowolne liczby rzeczywiste."
println ""

def realNumberRegex = /\-?[0-9]+\.[0-9]+|\-?[0-9]+/
def inputText = "W tym tekście znajduje się liczba 1.23 oraz liczba 123.123 można też odejmować liczby -123.123"

def matches = inputText =~ realNumberRegex

matches.each {
    println it
}

println ""


println "2. Zastosować je do przetwarzania tekstu zawierającego (posród innych) napisy w postaci liczba PLN,"
println "w taki sposób, aby zamienić te fragmenty na liczba EUR (po aktualnym kursie)"
println ""

def matchRealNumbersRegex = /((\+|-)?([0-9]+)([.][0-9]+)?)/
def matchPricesRegex = /((\+|-)?([0-9]+)([.][0-9]+)?[ ][P][L][N])/

BigDecimal getCurrentPlnToEuroRate()
{
    def euroToPln = (new JsonSlurper()).parse(new URL('http://api.nbp.pl/api/exchangerates/rates/A/EUR?format=json'))["rates"][0]["mid"]
    return 1 / euroToPln
}

def pricesString = "klocki 25.0 PLN, mleko 3.50 PLN, bulki 3.14 PLN, orzechy po 12 PLN"

def plnToEurRate = getCurrentPlnToEuroRate()
def decimalFormatter = new DecimalFormat("###,##0.00");

def euroPricesString = pricesString.replaceAll(matchPricesRegex, {
    def price = (it[0] =~ matchRealNumbersRegex)[0][0] as BigDecimal
    return decimalFormatter.format(price * plnToEurRate) + " EUR"
})

println pricesString
println euroPricesString

