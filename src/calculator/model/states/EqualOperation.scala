package calculator.model.states

import calculator.model.pressstates.{RHSState, RHSStateDecimal}
import calculator.model.{Calculator, InitState, StatePattern}

class EqualOperation(calculator: Calculator, var op : (Double, Double) => Double) extends StatePattern(calculator){
  override def displayNumber(): Double = this.calculator.numberStr.toDouble

  override def clearPressed(): Unit = this.calculator.state.clearer(this.calculator)

  override def numberPressed(number: Int): Unit = {
    this.calculator.lhs = this.calculator.numberStr.toDouble
    this.calculator.numberStr = "0"
    this.calculator.numberStr = this.calculator.numberStr.concat(number.toString)
    this.calculator.state = new InitState(this.calculator)
  }

  override def dividePressed(): Unit = {
    this.calculator.lhs = this.calculator.numberStr.toDouble
    this.calculator.state = new OperationsDecide(this.calculator, (x : Double, y : Double) => x / y)
  }

  override def multiplyPressed(): Unit = {
    this.calculator.lhs = this.calculator.numberStr.toDouble
    this.calculator.state = new OperationsDecide(this.calculator, (x : Double, y : Double) => x * y)
  }

  override def subtractPressed(): Unit = {
    this.calculator.lhs = this.calculator.numberStr.toDouble
    this.calculator.state = new OperationsDecide(this.calculator, (x : Double, y : Double) => x - y)
  }

  override def addPressed(): Unit = {
    this.calculator.lhs = this.calculator.numberStr.toDouble
    this.calculator.state = new OperationsDecide(this.calculator, (x : Double, y : Double) => x + y)
  }

  override def equalsPressed(): Unit = {}

  override def decimalPressed(): Unit = {
    this.calculator.lhs = this.calculator.numberStr.toDouble
    this.calculator.numberStr = "0"
    this.calculator.numberStr = this.calculator.numberStr.concat(".")
    this.calculator.state = new InitDecimal(this.calculator)
  }
}
