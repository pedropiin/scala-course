package recfun

object RecFun extends RecFunInterface:

    def main(args: Array[String]): Unit =
        println("Pascal's Triangle")
        for row <- 0 to 10 do
            for col <- 0 to row do
                print(s"${pascal(col, row)} ")
            println()
        println(balance("I told him (that it's not (yet) done).\n(But he wasn't listening)".toList))

    /**
     * Exercise 1
     */
    def pascal(c: Int, r: Int): Int = 
        if c < 0 || c > r then 0
        else if r == 0 then 1
        else pascal(c, r - 1) + pascal(c - 1, r - 1)

    /**
     * Exercise 2
     */
    def balance(chars: List[Char]): Boolean = 
        def balanceIt(head: Char, tail: List[Char], open: Int, close: Int): Boolean = 
            if tail.isEmpty then
                if head == ')' then return open == (close + 1)
                open == close
            else if close > open then return false  
            else if head == '(' then balanceIt(tail.head, tail.tail, open + 1, close)
            else if head == ')' then balanceIt(tail.head, tail.tail, open, close + 1)
            else balanceIt(tail.head, tail.tail, open, close)
        
        if chars.isEmpty then true
        else balanceIt(chars.head, chars.tail, 0, 0)


    /**
     * Exercise 3
     */
    def countChange(money: Int, coins: List[Int]): Int = 
        def countChangeNested(money: Int, coins: List[Int], count: Int): Int = 
            if money < 0 || coins.isEmpty then return 0
            else if money == 0 then return (count + 1)
            else countChangeNested(money, coins.tail, count) + countChangeNested(money - coins.head, coins, count)

        if money == 0 then return 0
        else if coins.isEmpty then return 0
        countChangeNested(money, coins, 0)