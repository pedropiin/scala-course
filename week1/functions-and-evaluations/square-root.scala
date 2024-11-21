@main
def main(): Unit = 
  def abs(x: Double) = 
    if (x < 0) then -x else x

  def sqrtIter(guess: Double, x: Double): Double = 
    if (isGoodEnough(guess, x)) then guess 
    else sqrtIter(improve(guess, x), x)

  def isGoodEnough(guess: Double, x: Double): Boolean =
    abs((x / guess) - guess) < 0.001

  def improve(guess: Double, x: Double) = 
    (guess + x / guess) / 2

  def sqrt(x: Double): Double = 
    sqrtIter(1.0, x)

  println(sqrt(893))