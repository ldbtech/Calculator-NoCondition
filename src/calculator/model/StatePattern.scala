package calculator.model

abstract class StatePattern(calculator: Calculator){
  // Accessed by View. You should edit this method as you build functionality
  def displayNumber(): Double

  def clearPressed(): Unit

  def numberPressed(number: Int): Unit

  def dividePressed(): Unit

  def multiplyPressed(): Unit

  def subtractPressed(): Unit

  def addPressed(): Unit

  def equalsPressed(): Unit

  def decimalPressed(): Unit

  //Extra Function
  def clearer(calculator: Calculator): Unit ={
    calculator.numberStr = "0"
    calculator.lhs = 0.0
    calculator.rhs = 0.0
    calculator.result = 0.0
    calculator.state = new InitState(calculator)
  }

  // This will call all operations
  def allOperation(op : (Double, Double) => Double): Double ={
    this.calculator.rhs = this.calculator.numberStr.toDouble
    op(this.calculator.lhs, this.calculator.rhs)
  }

  def equal() : Unit = {
    this.calculator.result = this.calculator.lhs
    this.calculator.numberStr = this.calculator.result.toString
  }

}
