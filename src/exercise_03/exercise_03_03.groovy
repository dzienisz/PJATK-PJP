import java.text.ParseException
import java.text.SimpleDateFormat

def inputText = "" +
        "2018-12-12 lorem ipsum" +
        "2018-34-12 zły miesiąc" +
        "2018-12-33 zły dzień" +
        "tekst przed datą 2018-01-01"

def matches = inputText =~ /[0-9]{4}-[0-9]{2}-[0-9]{2}/
def validDates = matches.findAll({
    def valid = true

    try {
        def dateFormat = new SimpleDateFormat("yyyy-MM-dd")
        dateFormat.setLenient(false)
        dateFormat.parse(it)
    } catch(ParseException e) {
        valid = false
    }

    return valid
})

println validDates