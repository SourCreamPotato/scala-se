package arithmetic
import javax.print.MultiDoc
object Main 
{
    
    enum ArithmeticExpression() 
    {
      case Num(i: Int)
      case Minus(exp : ArithmeticExpression)
      case Plus(exp1 : ArithmeticExpression , exp2 : ArithmeticExpression)
      case Mult(exp1: ArithmeticExpression , exp2: ArithmeticExpression)
      case Div(exp1: ArithmeticExpression , exp2: ArithmeticExpression)
      case Pow(exp1: ArithmeticExpression , exp2: ArithmeticExpression)
    }


    object ArithmeticExpression{

      def evaluate(expression : ArithmeticExpression) : Double = 
      {
      
      //if Num
        if (expression.productPrefix == ArithmeticExpression.Num.toString())
        {
          return extractDouble(expression.productElement(0)).get
        }

      //if Minus
        if (expression.productPrefix == ArithmeticExpression.Minus.toString())
        {
          expression.productElement(0)
          return (-1) * ArithmeticExpression.evaluate(expression.productElement(0).asInstanceOf[ArithmeticExpression])
        }

      //if Plus
        if (expression.productPrefix == ArithmeticExpression.Plus.toString())
        {
          
          
          return 
            //left
            ArithmeticExpression.evaluate(expression.productElement(0).asInstanceOf[ArithmeticExpression]) 
            +
            ArithmeticExpression.evaluate(expression.productElement(1).asInstanceOf[ArithmeticExpression])
            //right
          
          }

        if (expression.productPrefix == ArithmeticExpression.Mult.toString())
        {
           return 
            //left
            ArithmeticExpression.evaluate(expression.productElement(0).asInstanceOf[ArithmeticExpression]) 
            *
            ArithmeticExpression.evaluate(expression.productElement(1).asInstanceOf[ArithmeticExpression])
            //right         
        }


        if (expression.productPrefix == ArithmeticExpression.Div.toString())
        {
           return 
            //left
            ArithmeticExpression.evaluate(expression.productElement(0).asInstanceOf[ArithmeticExpression]) 
            /
            ArithmeticExpression.evaluate(expression.productElement(1).asInstanceOf[ArithmeticExpression])
            //right         
        }

        
        return 1
      }

      def pretty(expression : ArithmeticExpression) : String = 
      {
        
       
      //if Num
        if (expression.productPrefix == ArithmeticExpression.Num.toString())
        {
          return  "" + extractDouble(expression.productElement(0)).get.toString() + ""
        }

      //if Minus
        if (expression.productPrefix == ArithmeticExpression.Minus.toString())
        {
          expression.productElement(0)
          return "(-"+ ArithmeticExpression.pretty(expression.productElement(0).asInstanceOf[ArithmeticExpression]).toString() + ")"
        }

      //if Plus
        if (expression.productPrefix == ArithmeticExpression.Plus.toString())
        {
          
          
          return 
            //left
            "(" + ArithmeticExpression.pretty(expression.productElement(0).asInstanceOf[ArithmeticExpression]).toString() + ")"
            + "+" +
            "("+ ArithmeticExpression.pretty(expression.productElement(1).asInstanceOf[ArithmeticExpression]).toString() + ")"
            //right
          
          }

        if (expression.productPrefix == ArithmeticExpression.Mult.toString())
        {
          return 
            //left
            "(" + ArithmeticExpression.pretty(expression.productElement(0).asInstanceOf[ArithmeticExpression]).toString() + ")"
            + "*" +
            "("+ ArithmeticExpression.pretty(expression.productElement(1).asInstanceOf[ArithmeticExpression]).toString() + ")"
            // right
          
 
        }


        if (expression.productPrefix == ArithmeticExpression.Div.toString())
        {
          return ""+
          //left
          "(" + ArithmeticExpression.pretty(expression.productElement(0).asInstanceOf[ArithmeticExpression]).toString() + ")"
          + "/" +
          "("+ ArithmeticExpression.pretty(expression.productElement(1).asInstanceOf[ArithmeticExpression]).toString() + ")"
          //right
        }

        
       
        
          return "result"
      }

      // doesnt work yet
      def evaluate(expressions : List[ArithmeticExpression]): List[Double] =
      {
        val l:List[Double]
        var counter = 0

        expressions.foreach {
          var l2 = List[Double]
          ArithmeticExpression.evaluate(l(counter)) :: l2
          
          l = l2 :+

          counter = counter + 1
        }
      }

    }

    
// from https://stackoverflow.com/questions/42433234/how-to-convert-any-number-to-double
    def extractDouble(expectedNumber: Any): Option[Double] = expectedNumber match 
    {
      case i: Int => Some(i.toDouble)
      case l: Long => Some(l.toDouble)
      case d: Double => Some(d)
      case _ => None
    }



    def main(args: Array[String]): Unit =
    {
    }
}