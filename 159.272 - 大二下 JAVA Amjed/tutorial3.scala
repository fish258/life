object tutorial3 {
  
 
  def main(args: Array[String]) = {
    
   /* demonstrate the behaviour of your functions 
    by calling them on suitable arguments 
    and printing out the results */
    
  }

  def applyEach(fnList:List[(Int=>Any)], x:Int): List[Any] =
  {
   
  }
  
  def twice[T](fn:(T=>T), x:T): T =
  {
    fn(fn(x))
  }
  
  def iter[T](fn:(T=>T), n:Int, x:T): T =
  {
    
  }
  
  def liftTwice[T](fn:(T=>T)): (T => T) =
  {
    fn compose fn
  }
  
  def liftIter[T](fn:(T=>T), n:Int): (T => T) = 
  {
    
  }
  
  sealed abstract class Expr
  case class Var(name:String) extends Expr
  case class Number(num:Double) extends Expr
  case class UnOp(operator:String, arg:Expr) extends Expr
  case class BinOp(operator:String, left:Expr, right:Expr) extends Expr
  
  def exprSize(e: Expr):Int = 
  {
    
  }
  
  def exprToString(e: Expr):String = 
  {
    
  }
  
  sealed abstract class Suit
  case object Club extends Suit
  case object Diamond extends Suit
  case object Heart extends Suit
  case object Spade extends Suit

  sealed abstract class FaceValue
  case object Ace extends FaceValue
  case object King extends FaceValue
  case object Queen extends FaceValue
  case object Jack extends FaceValue
  case object Ten extends FaceValue
  case object Nine extends FaceValue
  case object Eight extends FaceValue
  case object Seven extends FaceValue
  case object Six extends FaceValue
  case object Five extends FaceValue
  case object Four extends FaceValue
  case object Three extends FaceValue
  case object Deuce extends FaceValue

  sealed case class Card(suit:Suit, value:FaceValue) 

  type Hand = List[Card]
  
  sealed abstract class Trumps
  case object TClub extends Trumps
  case object TDiamond extends Trumps
  case object THeart extends Trumps
  case object TSpade extends Trumps
  case object NoTrump extends Trumps
  
  sealed abstract class Bid
  case object Pass extends Bid
  case class OpBid(level: Int, trumpSuit: Trumps)

  
  def openingBid(myHand:Hand): Bid =
  {
   
  }
  
}