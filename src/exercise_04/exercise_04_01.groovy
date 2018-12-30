def bigProjectsOutput = new File('ProjektyDuze.txt')
bigProjectsOutput.text = ''
def programmersOutput = new File('Programisci.txt')
programmersOutput.text = ''

def input = new File('Projekty.txt')

def programmersLanguages = [:].withDefault { [] }
input.each {
    if (it.size() == 0)
        return

    def values = it.split("\t")
    def language = values[0]
    def programmers = values.drop(1)

    if (programmers.size() > 3)
        bigProjectsOutput << "$language\n"

    programmers.each {
        programmersLanguages[it] += language
    }
}

programmersLanguages.each { programmer, languages ->
    programmersOutput << programmer + "\t" + languages.join("\t") + "\n"
}