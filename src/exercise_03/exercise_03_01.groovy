def list1 = [ 'a', 'b', 'c']
def list2 = [ 1, 8, 23 ]

// a) wypisać wszystkie elementy (2 p.),

print("list1: ")
list1.each {
    print(it)
    print(" ")
}

println()

print("list2: ")
list2.each {
    print(it)
    print(" ")
}

println()

// b) stworzyć nowe listy list11 i list12 zawierające podwojone wartości list oryginalnych (3 p.).

def list11 = []
list1.each {
    list11.push(it + it)
}
println(list11)

def list12 = []
list2.each {
    list12.push(it + it)
}
println(list12)