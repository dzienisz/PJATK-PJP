
def pmap = [
        Groovy: ['Asia', 'Jan'],
        Grails: ['Asia', 'Jan', 'Stefan', 'Mirek'],
        Java  : ['Asia', 'Stefan', 'Mirek'],
        JEE   : ['Slawek', 'Stefan', 'Janusz']
]

//a) ile osób pracuje w każdym z projektów  (3 p)

println "1. Ile osób pracuje w każdym z projektów"

def keys = pmap.keySet()
keys.each { key ->
    def count = pmap.get(key).size()
    println "$key: $count"
}

println ""
println "2. Projekty, które mają więcej niż dwóch programistów"

def moreThan2 = pmap.findAll {
    it.value.size() > 2
}
println moreThan2

println ""
println "3. W jakich projektach biorą udzial poszczególni programisci "

def names = []

pmap.values().each({
    names = (names + it).unique()
})

names.each { name ->
    def projects = pmap.findAll({ it.value.contains(name) }).collect { el -> el.key }
    println "$name: $projects"
}