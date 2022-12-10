package calculator.model.pressstates

import calculator.model.states.{EqualOperation, OperationsDecide}
import calculator.model.{Calculator, StatePattern}

class RHSState (calculator: Calculator, var op : (Double, Double) => Double) extends StatePattern(calculator){
  override def displayNumber(): Double = this.calculator.numberStr.toDouble

  override def clearPressed(): Unit = this.calculator.state.clearer(this.calculator)

  override def numberPressed(number: Int): Unit = this.calculator.numberStr = this.calculator.numberStr.concat(number.toString)

  override def dividePressed(): Unit = {
    this.calculator.rhs = this.calculator.numberStr.toDouble
    this.calculator.lhs = this.op(this.calculator.lhs, this.calculator.rhs)
    this.calculator.numberStr = this.calculator.lhs.toString // Just to show it on screen after clicking second operation
    this.op = (x : Double, y : Double) => x / y
    this.calculator.state = new OperationsDecide(this.calculator, this.op)
  }

  override def multiplyPressed(): Unit = {
    this.calculator.rhs = this.calculator.numberStr.toDouble
    this.calculator.lhs = this.op(this.calculator.lhs, this.calculator.rhs)
    this.calculator.numberStr = this.calculator.lhs.toString // Just to show it on screen after clicking second operation
    this.op = (x : Double, y : Double) => x * y
    this.calculator.state = new OperationsDecide(this.calculator, this.op)
  }

  override def subtractPressed(): Unit = {
    this.calculator.rhs = this.calculator.numberStr.toDouble
    this.calculator.lhs = this.op(this.calculator.lhs, this.calculator.rhs)
    this.calculator.numberStr = this.calculator.lhs.toString // Just to show it on screen after clicking second operation
    this.op = (x : Double, y : Double) => x - y
    this.calculator.state = new OperationsDecide(this.calculator, this.op)
  }

  override def addPressed(): Unit = {
    this.calculator.rhs = this.calculator.numberStr.toDouble
    this.calculator.lhs = this.op(this.calculator.lhs, this.calculator.rhs)
    this.calculator.numberStr = this.calculator.lhs.toString // Just to show it on screen after clicking second operation
    this.op = (x : Double, y : Double) => x + y
    this.calculator.state = new OperationsDecide(this.calculator, this.op)
  }

  override def equalsPressed(): Unit = {
    this.calculator.rhs = this.calculator.numberStr.toDouble
    this.calculator.lhs = this.op(this.calculator.lhs, this.calculator.rhs)
    this.calculator.numberStr = this.calculator.lhs.toString
    //I need send it somewhere.
    this.calculator.state = new EqualOperation(this.calculator, this.op)
  }

  override def decimalPressed(): Unit = {
    this.calculator.numberStr = this.calculator.numberStr.concat(".")
    this.calculator.state = new RHSStateDecimal(this.calculator, this.op)
  }
}
