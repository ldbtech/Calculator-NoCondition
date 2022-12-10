package calculator.model

import calculator.model.states.{InitDecimal, OperationDecideDecimal, OperationsDecide}

class InitState (calculator: Calculator) extends StatePattern(calculator){
  override def displayNumber(): Double = this.calculator.numberStr.toDouble

  override def clearPressed(): Unit = calculator.numberStr = "0"

  override def numberPressed(number: Int): Unit = {
    calculator.numberStr = calculator.numberStr.concat(number.toString)
  }

  override def dividePressed(): Unit = {
    this.calculator.state = new OperationsDecide(this.calculator, (x : Double, y : Double) => x / y)
  }

  override def multiplyPressed(): Unit = {
    this.calculator.state = new OperationsDecide(this.calculator, (x : Double, y : Double) => x * y)
  }

  override def subtractPressed(): Unit = {
    this.calculator.state = new OperationsDecide(this.calculator, (x : Double, y : Double) => x - y)
  }

  override def addPressed(): Unit = {
    this.calculator.state = new OperationsDecide(this.calculator, (x : Double, y : Double) => x + y)
  }

  override def equalsPressed(): Unit = {
    this.calculator.lhs = this.calculator.numberStr.toDouble

    this.calculator.state.equal()
  }

  override def decimalPressed(): Unit = {
    calculator.numberStr = calculator.numberStr.concat(".")
    this.calculator.state = new InitDecimal(this.calculator)
  }
}
