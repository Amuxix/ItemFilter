package me.amuxix

sealed trait ItemClass extends Named

case object Currency extends ItemClass