import java.io.File
import java.io.RandomAccessFile
import java.nio.charset.Charset

 suspend fun calcScore(fpath : String, getWord : String) : Int{
    val dictionary = File(fpath)
    val userWords = File("C:\\Users\\nuald\\IdeaProjects\\GameWords\\src\\main\\resources\\output.txt")

    val uWords = RandomAccessFile(userWords,"r")
    uWords.seek(0)

    val getWordArr = getCharsArr(getWord)
    var result : Int = 0
    while (uWords.filePointer < uWords.length()) {
        var curWordCoded = uWords.readLine()
        var curWord = String(curWordCoded.toByteArray(Charsets.ISO_8859_1),Charsets.UTF_8) //uWords.readLine()
//        println("Curword $curWord")


        if(!curWord.isNullOrBlank() && checkLetters(curWord, getWordArr)) {
            var res = dictionary.readLines().firstOrNull() { it.equals(curWord) }
//            println("res $res")
            if(!res.isNullOrEmpty()) result += res.length
        }
    }
     return result
}

fun checkLetters(curWord : String, charsCount : Array<Int>) : Boolean {
    val curWordArr = getCharsArr(curWord)
    if(curWordArr[0] == -1) return false
    for (i in 0..31) {
        if(curWordArr[i] > charsCount[i]) return false
    }
    return true
}

fun getCharsArr(word : String) : Array<Int> {
    var c : Char
    var res = Array(32) { 0 }

    word.toLowerCase()
//    println("word~! $word")

    for (c in String()) {

        if(c in 'a'..'я') {
            res[c.toInt() - 'а'.toInt()] ++
        }
        else {
            res[0] = -1
            return res
        }
    }

    return res
}