package calculator.model.states

import calculator.model.{Calculator, StatePattern}

class InitDecimal(calculator: Calculator) extends StatePattern(calculator){
  override def displayNumber(): Double = this.calculator.numberStr.toDouble

  override def clearPressed(): Unit = this.calculator.state.clearer(this.calculator)

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

  override def decimalPressed(): Unit = {}

}
