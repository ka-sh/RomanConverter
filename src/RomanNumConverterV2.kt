import kotlin.math.absoluteValue

class RomanNumConverterV2(val map:MutableMap<Char,Int>):Converter{
    override fun parse(input: String): Int {
        var count=0
        var i=0

        while(i<input.length){
        when{
            i+1>input.length-1 -> {
                count+=(valOf(input[i]))
                ++i
            }
            i+1<input.length ->{
                when{
                    valOf(input[i])<valOf((input[i+1])) ->{
                        count+=valOf(input[i+1]).minus(valOf(input[i])).absoluteValue
                        i+=2
                    }
                    else->{
                        count+=valOf(input[i])
                        ++i
                    }
                }
            }
            else-> count+0
        }
        }
        return count
    }

    fun valOf(ch:Char):Int=map.get(ch)?:0


}