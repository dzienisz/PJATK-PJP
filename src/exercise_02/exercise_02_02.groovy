// Napisać funkcję List getInts(), która prosi o podanie szeregu liczb całkowitych
// w dialogu wejściowym i zwraca listę wprowadzonych liczb (jako obiektów typu Integer).
// Nie dopuścić do wprowadzenia wadliwych danych (ponowienie dialogu do poprawki).

import javax.swing.JOptionPane

def getInts() {
    def numbers = []
    def err = false
    while (true) {
        def dialogMessage = "Podaj liczbę"
        if (err) {
            err = false
            dialogMessage = "Błąd. $dialogMessage"
        }

        def input = JOptionPane.showInputDialog(null, dialogMessage, "")
        if (input == null)
            break
        if (input.matches("[0-9]*"))
            numbers.push(Integer.parseInt(input))
        else
            err = true
    }

    return numbers
}

print getInts()