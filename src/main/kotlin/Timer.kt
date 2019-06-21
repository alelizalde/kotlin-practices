import java.lang.Thread.sleep

fun main() {
    timer(2)
}

fun timer(n: Int){
    var time = n * 60
    while(time>0){
        time--
        sleep(1000)
        val minutes = time / 60
        val seconds = time % 60
        println("\u001Bc")
        println("timer: ${String.format("%02d:%02d", minutes, seconds)}")
    }
    print("Completed")
}