package com.example.lab3saeyoungpark

val historyFact = hashMapOf(
    "1492" to "Christopher Columbus discovers America",
    "1601" to "William Shakespeare writes Hamlet",
    "1632" to "Galileo discovered the acceleration of gravity on Earth to be 9.8m/s",
    "1838" to "Roughly 9.46 trillion km, the light-year is first used as a measurement in astronomy",
    "2020" to "Covid 19 Pandemic"
)

fun main() {

    historyFact.entries.map { "${it.key}=${it.value}" }.forEach(::println)
    println("--------------------------------------------------------------------------------")
    anonymous("2020")
    println(lambda(1838))
    higherOrder(lambda)
    reference(::find)
    litInlit { year -> historyFact["$year"]?: "No fact on that year"}

}


val anonymous = fun (year:String) { println(historyFact[year]) }

val lambda = {year: Int -> historyFact["$year"]}

fun higherOrder(lambda: (Int) -> String?) {
    println(lambda(1632))
}

fun find (year: Int): String {
    return "${historyFact["$year"]}"
}

fun reference (find: (Int) -> String) {
    println(find(1601))
}

val litInlit: ( lit: (Int) -> String ) -> Unit = {
        lit -> println(lit(1492))
}

