// Napisy wprowadzane w kolejnych dialogach mają formę:  pozycja = koszt.
// Zsumuj wszystkie koszty dla tych samych pozycji (np. mleko, chleb). (5)

def items = collectItems()
println ""
println "Lista produktów:"

items.each { key, value ->
    println "- $key: $value"
}

def collectItems() {
    def map = [:].withDefault { 0 }

    while (true) {
        def rawProduct = getRawProduct()
        if (rawProduct == "")
            break

        def parts = rawProduct.split(" = ")
        def product = parts[0]
        def price = new BigDecimal(parts[1])

        if (map.containsKey(product)) {
            def sum = map.get(product)
            sum += price
            map.replace(product, sum)
        }
        else
            map.put(product, price)
    }

    return map
}

def getRawProduct() {
    def prompt = true
    def scanner = new Scanner(System.in)
    def input = ""
    def regex = "[a-zA-Z]* = [0-9]*.[0-9]*"

    while (prompt) {
        prompt = false
        print ""
        print "Podaj produkt: "
        input = scanner.nextLine()
        if (input == null || input.equals(""))
            break

        if (!input.matches(regex)) {
            prompt = true
            println "Niepoprawna wartość: $input (produkt = koszt)"
        }
    }

    return input
}
