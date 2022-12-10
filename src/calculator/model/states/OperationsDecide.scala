package calculator.model.states

import calculator.model.pressstates.RHSState
import calculator.model.{Calculator, StatePattern}

class OperationsDecide(calculator: Calculator, var op : (Double, Double) => Double) extends StatePattern(calculator){
  override def displayNumber(): Double = this.calculator.numberStr.toDouble

  override def clearPressed(): Unit = this.calculator.state.clearer(this.calculator)

  override def numberPressed(number: Int): Unit = {
    this.calculator.lhs = this.calculator.numberStr.toDouble
    this.calculator.numberStr = "0"
    this.calculator.numberStr = this.calculator.numberStr.concat(number.toString)
    this.calculator.state = new RHSState(this.calculator, this.op)
  }

  override def dividePressed(): Unit = {
    this.op = (x : Double, y : Double) => x / y
  }

  override def multiplyPressed(): Unit = {
    this.op = (x : Double, y : Double) => x * y
  }

  override def subtractPressed(): Unit = {
    this.op = (x : Double, y : Double) => x - y
  }

  override def addPressed(): Unit = {
    this.op = (x : Double, y : Double) => x + y
  }

  override def equalsPressed(): Unit = {
    //this.calculator.numberStr = this.calculator.result.toString // Still in question
    this.calculator.numberStr = this.op(this.calculator.lhs, this.calculator.numberStr.toDouble).toString
    this.calculator.lhs = this.calculator.numberStr.toDouble
  }

  override def decimalPressed(): Unit = {
    this.calculator.lhs = this.calculator.numberStr.toDouble
    this.calculator.numberStr = "0"
    this.calculator.numberStr = this.calculator.numberStr.concat(".")
    this.calculator.state = new OperationDecideDecimal(this.calculator, this.op)
  }
}
