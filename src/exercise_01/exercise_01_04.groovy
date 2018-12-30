
// Napisać pogram przekształcający liczby na ich słowne odpowiedniki.
// Np. po wprowadzeniu liczby 147 winniśmy uzyskać jeden - cztery - siedem. (5)

def scanner = new Scanner(System.in)

print "Podaj liczby: "
def nums = scanner.nextLine()

// error handling
if (!isNumeric(nums)) {
    println("")
    println("Wartość nienumeryczna!")
    return
}

def isNumeric(String text) {
    return text.toCharArray().every { it.isDigit() }
}

def numberAsWords(String rawNumbers) {
    def numbers = rawNumbers.collect { x -> Integer.parseInt(x) }
    numbers.eachWithIndex{ number, index ->
        displayAsWord(number, index == 0)
    }
}

def displayAsWord(int number, boolean isFirst) {
    def word = ""

    switch (number) {
        case 0:
            word = "zero"
            break
        case 1:
            word = "jeden"
            break
        case 2:
            word = "dwa"
            break
        case 3:
            word = "trzy"
            break
        case 4:
            word = "cztery"
            break
        case 5:
            word = "pięć"
            break
        case 6:
            word = "sześć"
            break
        case 7:
            word = "siedem"
            break
        case 8:
            word = "osiem"
            break
        case 9:
            word = "dziewięć"
            break
    }

    if (!isFirst)
        print(" - ")
    print(word)
}

numberAsWords(nums)