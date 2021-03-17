import java.io.File
import java.io.RandomAccessFile
import kotlin.random.Random

fun generate(fpath: String) : String {
    val f = File(fpath)

    var f1 = RandomAccessFile(f,"r")

    var utf8str : String = " "

    while (utf8str.length < 5) {
        val num = Random.nextLong(0,f1.length()-26)

        f1.seek(num);
        var curWord = f1.readLine()
        curWord = f1.readLine()
        //   var utf8 : String = String(curWord.toByteArray(),Cha)

        utf8str = String(curWord.toByteArray(Charsets.ISO_8859_1),Charsets.UTF_8)

    }

    f1.close();
    return utf8str;
}