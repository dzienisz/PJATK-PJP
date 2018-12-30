import groovy.json.JsonSlurper

import java.text.DecimalFormat

BigDecimal getCurrentPlnToEuroRate()
{
    def euroToPln = (new JsonSlurper()).parse(new URL('http://api.nbp.pl/api/exchangerates/rates/A/EUR?format=json'))["rates"][0]["mid"]
    return 1 / euroToPln
}

def plnToEurRate = getCurrentPlnToEuroRate()
def decimalFormatter = new DecimalFormat("###,##0.00")

def input = new File('MenuPl.txt')
def output = new File('MenuEur.txt')

output.text = ''
input.each {
    if (it.size() == 0)
        return

    def values = it.split(" ")
    def price = values[1] as BigDecimal
    output << values[0] + " " + decimalFormatter.format(price * plnToEurRate) + "\n"
}