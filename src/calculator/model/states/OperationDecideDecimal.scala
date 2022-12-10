package calculator.model.states

import calculator.model.{Calculator, StatePattern}

class OperationDecideDecimal(calculator: Calculator, var op : (Double, Double) => Double) extends StatePattern(calculator){
  override def displayNumber(): Double = this.calculator.numberStr.toDouble

  override def clearPressed(): Unit = this.calculator.state.clearer(calculator)

  override def numberPressed(number: Int): Unit = {

    calculator.numberStr = calculator.numberStr.concat(number.toString)
  }

  override def dividePressed(): Unit = {
    this.calculator.lhs = this.op(this.calculator.lhs, this.calculator.numberStr.toDouble)
    this.op = (x : Double, y : Double) => x / y
    this.calculator.state = new OperationsDecide(this.calculator, this.op)
  }

  override def multiplyPressed(): Unit = {
    this.calculator.lhs = this.op(this.calculator.lhs, this.calculator.numberStr.toDouble)
    this.op = (x : Double, y : Double) => x * y
    this.calculator.state = new OperationsDecide(this.calculator, this.op)
  }

  override def subtractPressed(): Unit = {
    this.calculator.lhs = this.op(this.calculator.lhs, this.calculator.numberStr.toDouble)
    this.op = (x : Double, y : Double) => x - y
    this.calculator.state = new OperationsDecide(this.calculator, this.op)
  }

  override def addPressed(): Unit = {
    this.calculator.lhs = this.op(this.calculator.lhs, this.calculator.numberStr.toDouble)
    this.op = (x : Double, y : Double) => x + y
    this.calculator.state = new OperationsDecide(this.calculator, this.op)
  }

  override def equalsPressed(): Unit = {
    this.calculator.numberStr = this.op(this.calculator.lhs, this.calculator.numberStr.toDouble).toString
  }

  override def decimalPressed(): Unit = {}
}
