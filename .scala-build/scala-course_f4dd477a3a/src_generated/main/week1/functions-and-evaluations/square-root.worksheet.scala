package week1.functions$minusand$minusevaluations


final class square$minusroot$u002Eworksheet$_ {
def args = square$minusroot$u002Eworksheet_sc.args$
def scriptPath = """week1/functions-and-evaluations/square-root.worksheet.sc"""
/*<script>*/
def sqrt(x: Double): Double = 
  def abs(x: Double) = 
    if (x < 0) then -x else x

  def sqrtIter(guess: Double, x: Double): Double = 
    if (isGoodEnough(guess, x)) then guess 
    else sqrtIter(improve(guess, x), x)

  def isGoodEnough(guess: Double, x: Double): Boolean =
    abs((x / guess) - guess) < 0.001

  def improve(guess: Double, x: Double) = 
    (guess + x / guess) / 2

  sqrtIter(1.0, x)

sqrt(25)
/*</script>*/ /*<generated>*//*</generated>*/
}

object square$minusroot$u002Eworksheet_sc {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new square$minusroot$u002Eworksheet$_

  def main(args: Array[String]): Unit = {
    args$set(args)
    val _ = script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export square$minusroot$u002Eworksheet_sc.script as `square-root.worksheet`

