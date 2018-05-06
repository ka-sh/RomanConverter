import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TestRomanConverterV2{
    private var converter:Converter=RomanNumConverterV2(mutableMapOf('I' to 1, 'V' to 5,'X' to 10,'L' to 50))
    private var cases:MutableMap<String,Int> = mutableMapOf(
            "I" to 1,
            "II" to 2,
            "III" to 3,
            "IV" to 4,
            "V" to 5,
            "VI" to 6,
            "VII" to 7,
            "XI" to 11,
            "XIII" to 13,
            "XV" to 15,
            "XIV" to 14,
            "XX" to 20,
            "XXVII" to 27,
            "XXVIII" to 28,
            "XXIX" to 29,
            "XXXVIII" to 38,
            "XXXVI" to 36,
            "XLIX" to 49,
            "XLVI" to 46,
            "XLV" to 45,
            "LXXIII" to 73
    )
    @Test
    fun TestConverterParse(){
        for(key in cases.keys){
            Assertions.assertEquals(cases.get(key),converter.parse(key))
        }
    }
}