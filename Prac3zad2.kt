package org.example
const val TYPE_1 = "Maestro"
const val TYPE_2 = "MasterCard"
const val MAXAMOUNT_TYPE_1 = 75000_00
const val FixComm_TYPE_1 = 20_00
const val COMMISSIONPERCENTAGE_TYPE_1 = 0.06
const val TYPE_3 = "VISA"
const val TYPE_4 = "Мир"
const val FIXCOMMISSION_TYPE_3 = 35_00
const val COMMISSIONPERCENTAGE_TYPE_3 = 0.0075
const val TYPE_5 = "VK Pay"
const val COMSSNPERCENT_TYPE_5 = 0

class Prac3zad2 {


    fun main() {
        testClcPrint(type = TYPE_1, amntTransf = 100_00)
        testClcPrint(TYPE_1, 400_00, 100_00)
        testClcPrint(TYPE_1, 100_000_00, 50_00)
        testClcPrint(TYPE_2, 0, 100_00)
        testClcPrint(TYPE_2, 400_00, 100_00)
        testClcPrint(TYPE_2, 100_000_00, 50_00)
        testClcPrint(TYPE_3, 0, 100_00)
        testClcPrint(TYPE_3, 400_00, 1000_00)
        testClcPrint(TYPE_3, 100_000_00, 5000_00)
        testClcPrint(TYPE_4, 0, 100_00)
        testClcPrint(TYPE_4, 400_00, 1000_00)
        testClcPrint(TYPE_4, 100_000_00, 5000_00)
        testClcPrint(TYPE_5, 100_000_00, 5000_00)
        testClcPrint(amntOfPrevPurch = 100_000_00, amntTransf = 15000_00)
        testClcPrint(amntTransf = 25000_00)
    }

    fun testClcPrint(type : String = TYPE_5,
                      amntOfPrevPurch : Int = 0,
                      amntTransf : Int){
        println("=============================================================================================");
        println("Сумма перевода: " + convertToRubKop(amntTransf));
        println("Тип карты: $type");
        println("Сумма предыдущих переводов в этом месяце: " + convertToRubKop(amntOfPrevPurch));
        println("Комиссия: " + convertToRubKop(calcCommission(type, amntOfPrevPurch, amntTransf)));
    }

    fun convertToRubKop(amount : Int) : String{
        return (amount / 100).toInt().toString() + " руб " + amount % 100 + " коп"
    }
    fun calcCommission(type : String,
                       amntOfPrevPurch : Int,
                       amntTransf : Int) : Int {
        when (type) {
            TYPE_1, TYPE_2 -> {
                if ((amntOfPrevPurch + amntTransf) in (1..MAXAMOUNT_TYPE_1)) return 0
                else return (FixComm_TYPE_1 + COMMISSIONPERCENTAGE_TYPE_1 * amntTransf).toInt()
            }
            TYPE_3, TYPE_4 -> {
                if (COMMISSIONPERCENTAGE_TYPE_3 * amntTransf > FixComm_TYPE_1)
                    return (COMMISSIONPERCENTAGE_TYPE_3 * amntTransf).toInt()
                else return FIXCOMMISSION_TYPE_3
            }
            TYPE_5 -> {
                return (COMSSNPERCENT_TYPE_5 * amntTransf).toInt()
            }
        }
        return 0
    }
}