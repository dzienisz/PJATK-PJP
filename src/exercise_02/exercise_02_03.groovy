// Napisać funkcję List apply(List l, Closure c), która każdy element listy l transformuje
// za pomocą domknięcie c i zwraca listę transformowanych wartości.

// Przetestować dla różnych list i różnych domknięć

def apply(List l, Closure c) {
    l.collect(c)
}

def res

def l1 = [1, 2, 3, 4]
res = apply(l1, {
    it * 2
})
println res

def l2 = [5, 4, 3, 2]
res = apply(l2, {
    it * it
})
println res