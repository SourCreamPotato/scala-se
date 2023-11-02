import javax.print.MultiDoc
object Main 
{
    
    enum ArithmeticExpression() 
    {
      case Num(i: Int)
      case Minus(exp : ArithmeticExpression)
      case Mult(exp1: ArithmeticExpression , exp2: ArithmeticExpression)
      case Div(exp1: ArithmeticExpression , exp2: ArithmeticExpression)
      case Pow(exp1: ArithmeticExpression , exp2: ArithmeticExpression)
    }

    val mynum  = ArithmeticExpression.Num(5)
    val myminus = ArithmeticExpression.Minus(mynum)

    object ArithmeticExpression{

      // todo : implement
      def evaluate(expression : ArithmeticExpression) : Double = {2.2}

      // todo : Implement
      def pretty(expression : ArithmeticExpression) : String = {"result"}


    }

    def f[T](v: T) = v
    
    def main(args: Array[String]): Unit =
    {
      println(s"num: ${mynum}")
      println(s"myminus: ${myminus}")
      println("Done")
    }
}
