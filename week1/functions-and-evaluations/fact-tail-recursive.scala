import scala.annotation.tailrec

@main
def main(): Unit = 
    @tailrec
    def factorial(n: Int, x: Int): Int = 
        if (n == 0) then x else factorial((n - 1), x * n)

    println(factorial(10, 1))
