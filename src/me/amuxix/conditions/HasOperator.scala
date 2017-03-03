package me.amuxix.conditions

/**
  * Created by Amuxix on 03/03/2017.
  */
trait HasOperator extends BaseCondition {
  val op: String
  override def toString: String = super.toString + s"${if (op.isEmpty == false) " "}$op "
}
