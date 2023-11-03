file://<WORKSPACE>/src/main/scala/test.scala
### java.lang.IndexOutOfBoundsException: 0

occurred in the presentation compiler.

action parameters:
offset: 949
uri: file://<WORKSPACE>/src/main/scala/test.scala
text:
```scala
package arithmetic
import Main.ArithmeticExpression
import Main.ArithmeticExpression.*
import Main.extractDouble
import org.scalatest._

class Test extends  FlatSpec with Matchers{

    "evaluate" should "Calculate Result of Input" in {
        val exp1 = ArithmeticExpression.Num(9)
        val exp2 = ArithmeticExpression.Num(4)
        val exp3 = ArithmeticExpression.Plus(exp1,exp2)

        ArithmeticExpression.evaluate(exp3) should be (13.0)
    }

    "pretty" should "Write out the Expression" in{
        val exp1 = ArithmeticExpression.Num(9)
        val exp2 = ArithmeticExpression.Num(4)
        val exp3 = ArithmeticExpression.Plus(exp1,exp2)
        
        ArithmeticExpression.pretty(exp3) should be ("(9+4)")
    }

    "Num" should "portray a number as a double" in{
        val mynum = ArithmeticExpression.Num(7)
        
        ArithmeticExpression.evaluate(mynum) should be (7.0)
    }

    "Minus" should "portray a Num * (@@)"
}
```



#### Error stacktrace:

```
scala.collection.LinearSeqOps.apply(LinearSeq.scala:131)
	scala.collection.LinearSeqOps.apply$(LinearSeq.scala:128)
	scala.collection.immutable.List.apply(List.scala:79)
	dotty.tools.dotc.util.Signatures$.countParams(Signatures.scala:501)
	dotty.tools.dotc.util.Signatures$.applyCallInfo(Signatures.scala:186)
	dotty.tools.dotc.util.Signatures$.computeSignatureHelp(Signatures.scala:94)
	dotty.tools.dotc.util.Signatures$.signatureHelp(Signatures.scala:63)
	scala.meta.internal.pc.MetalsSignatures$.signatures(MetalsSignatures.scala:17)
	scala.meta.internal.pc.SignatureHelpProvider$.signatureHelp(SignatureHelpProvider.scala:51)
	scala.meta.internal.pc.ScalaPresentationCompiler.signatureHelp$$anonfun$1(ScalaPresentationCompiler.scala:375)
```
#### Short summary: 

java.lang.IndexOutOfBoundsException: 0