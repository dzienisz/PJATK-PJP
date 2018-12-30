def htmlDir = new File('pliki_html')

def counter = 1

htmlDir.eachFileRecurse {
    if (it.isFile() && it.name.endsWith('.html')) {
        println(counter + " " + it)
        counter++
    }
}