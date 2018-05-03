
class RomanNumConverter(val map:MutableMap<Char,Int>):Converter{

    override fun parse(input: String): Int {
        val equation = compile(input)
//        println("->>>>"+equation)
        val result = calculate(equation)
//        println("->>>> $result")
        return result
    }

    /**
     * Evaluate calculus equation
     */
    fun calculate(equation:String):Int{
        var count=0
        /**
         * Subtraction takes precedence over any other operation
         */
        val subtract = "[+]\\d+[-]\\d+".toRegex().findAll(equation).iterator()
        var tmp=equation
        while (subtract.hasNext()){
            var str =subtract.next().value
            tmp=tmp.replace(str,"")
            var arr = str.split("[+|-]".toRegex()).filter { it.isNotEmpty() }
            count+= (arr[1].toInt()-arr[0].toInt())
        }
        /**
         * After removing the processed items from the equation string,
         * now we move to evaluate addition
         */
        var addtion = "[+]\\d+".toRegex().findAll(tmp).iterator()
        while (addtion.hasNext()){
            count+= addtion.next().value.toInt()
        }
        return count
    }

    /**
     * Convert String of Roman numerals to calculus equation
     * EX: III => +1+1+1
     */
    fun compile(input:String):String{
        var equation:String="+"
        if(input.length==1){
            return "+${map.get(input[0])!!}"
        }


        for(i in 0..input.length){
        equation+="${map.get(input[i])}"
            if (i+1<input.length){
                when{
                    map.get(input[i])!!<map.get(input[i+1])!! ->equation+='-'
                    else->equation+='+'
                }
            }else{
                break
            }

        }
        return equation
    }
}