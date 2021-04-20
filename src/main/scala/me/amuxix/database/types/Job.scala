package me.amuxix.database.types

object Job extends Enumeration {
  type JobType = Value
  val Any = Value("Any")
  val Lockpicking = Value("Lockpicking")
  val BruteForce = Value("Brute Force")
  val Engineering = Value("Engineering")
  val Agility = Value("Agility")
  val CounterThaumaturgy = Value("Counter-Thaumaturgy")
  val Perception = Value("Perception")
  val Demolition = Value("Demolition")
  val TrapDisarmament = Value("Trap Disarmament")
  val Deception = Value("Deception")
}
