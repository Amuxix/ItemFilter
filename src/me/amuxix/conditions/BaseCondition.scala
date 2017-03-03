package me.amuxix.conditions

/**
  * Created by Amuxix on 03/03/2017.
  */
class BaseCondition {
  override def toString: String = getClass.getSimpleName.split("\\$").last
}
