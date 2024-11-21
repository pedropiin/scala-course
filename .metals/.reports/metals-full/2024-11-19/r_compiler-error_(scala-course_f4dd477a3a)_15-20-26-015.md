file://<WORKSPACE>/week1/functions-and-evaluations/recfun/src/main/scala/recfun/RecFun.scala
### java.lang.AssertionError: NoDenotation.owner

occurred in the presentation compiler.

presentation compiler configuration:


action parameters:
offset: 514
uri: file://<WORKSPACE>/week1/functions-and-evaluations/recfun/src/main/scala/recfun/RecFun.scala
text:
```scala
package recfun

object RecFun extends RecFunInterface:

  def main(args: Array[String]): Unit =
    println("Pascal's Triangle")
    for row <- 0 to 10 do
      for col <- 0 to row do
        print(s"${pascal(col, row)} ")
      println()

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
    if chars.isEmpty then true[@@]

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = ???

```



#### Error stacktrace:

```
dotty.tools.dotc.core.SymDenotations$NoDenotation$.owner(SymDenotations.scala:2623)
	dotty.tools.dotc.core.SymUtils.isLocalToBlock(SymUtils.scala:335)
	dotty.tools.dotc.util.Signatures$.applyCallInfo(Signatures.scala:223)
	dotty.tools.dotc.util.Signatures$.computeSignatureHelp(Signatures.scala:104)
	dotty.tools.dotc.util.Signatures$.signatureHelp(Signatures.scala:88)
	dotty.tools.pc.SignatureHelpProvider$.signatureHelp(SignatureHelpProvider.scala:47)
	dotty.tools.pc.ScalaPresentationCompiler.signatureHelp$$anonfun$1(ScalaPresentationCompiler.scala:422)
```
#### Short summary: 

java.lang.AssertionError: NoDenotation.owner