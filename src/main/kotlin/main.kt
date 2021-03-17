import java.io.File
import kotlinx.coroutines.*

suspend fun main(args: Array<String>) {
    println("Hello World!")



//    val fpath = "C:\\Users\\nuald\\IdeaProjects\\GameWords\\src\\main\\resources\\dictionarysmall.txt"
    val fpath = "C:\\Users\\nuald\\IdeaProjects\\GameWords\\src\\main\\resources\\words.txt"

    var curWord = generate(fpath)
    println("Find words in word : $curWord")


    var c : Char = 'a'

    println("Ваше слово увожаемый Your words: ")

    var f = File("C:\\Users\\nuald\\IdeaProjects\\GameWords\\src\\main\\resources\\output.txt")
    f.deleteOnExit()
    f.createNewFile()
    val writer = f.bufferedWriter()

    var word : String? = readLine()
    while (!word.isNullOrBlank()) {
        writer.write(word)
        writer.newLine()
        writer.flush()

        word = readLine();
    }

    writer.close();

    println("End of Game. Please wait your result...  ")
//    var i = calcScore(fpath, curWord)



    var  job : Deferred<Int> = GlobalScope.async {
        calcScore(fpath,curWord)
    }

    println("loading")


    while (job.isActive) {
        print('.')
        Thread.sleep(2000)
    }
    println("DONE")


   var res : Int =  job.await()
    println("Your Score = $res")

//    println("Your score = $i")

}

