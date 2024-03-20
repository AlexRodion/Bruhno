package org.example

enum class Time(val value: Int) {

    MINUTE(60), HOUR(60 * 60), DAY(60 * 60 * 24)

}
class Prac3zad1(time: Int) {
    fun agoToText(time: Int) {

        when (time) {

            in 0..Time.MINUTE.value ->

                print("Был(а) в сети только что")



            in 61..Time.HOUR.value -> {

                val tempTime = time / Time.MINUTE.value

                print("Был(а) в сети $tempTime ${timeToText(tempTime.toString(), Time.MINUTE)} назад")

            }



            in (Time.HOUR.value + 1)..(Time.DAY.value) -> {

                val tempTime = time / Time.HOUR.value

                print("Был(а) в сети $tempTime ${timeToText(tempTime.toString(), Time.HOUR)} назад")

            }



            in (Time.DAY.value + 1)..(Time.DAY.value * 2) ->

                print("Был(а) в сети вчера")



            in (Time.DAY.value * 2 + 1)..(Time.DAY.value * 3) ->

                print("Был(а) в сети позавчера")



            in (Time.DAY.value * 3 + 1)..Int.MAX_VALUE ->

                print("Был(а) в сети давно")

        }

    }

}

fun timeToText(time: String, type: Time): String {

    val lastSymbol = time[time.length - 1]

    when (type) {

        Time.MINUTE ->

            when (lastSymbol) {

                '1' -> return "минуту"

                in '2'..'4' -> return "минуты"

                in '5'..'9', '0' -> return "минут"

            }



        Time.HOUR ->

            when (lastSymbol) {

                '1' -> return "час"

                in '2'..'4' -> return "часа"

                in '5'..'9', '0' -> return "часов"

            }

        else -> return "Error"
    }
    return "Error"
}
    fun main() {
    val x = 4 * 60 * 60
    agoToText(x)
    println()
    }
fun agoToText(x: Int) {

}