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

    "Minus" should "portray a Num * (-1)" in{
        val mynum = ArithmeticExpression.Num(7)
        val myminus = ArithmeticExpression(mynum)

        ArithmeticExpression.evaluate(myminus) should be (-7.0)
    }

    
}