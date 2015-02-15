Behavioural Composition
=======================

what
  Create a new derivation of the actor that allows us to compose the `receive` partial function without having to know about every component that goes into its construction.
when
  As the number of behavioural functions increase, the number of permutations increases as well. Keeping everything straight can be a real problem, and constructing the new receive method at each point in the code can also be quite problematic.
default business logic
  HelloHandler and byehandler are two traits containing our default business logic to handler specific events

  .. includecode:: code/BehaviouralComposition.scala
     :snippet: hello_handler

  .. includecode:: code/BehaviouralComposition.scala
     :snippet: bye_handler
final actor
  The final actor is the actor which the default business logic is mixed in. Next to it we override the default logic when we receive a change answer.

  .. includecode:: code/BehaviouralComposition.scala
     :snippet: final_actor
pattern trait
  ReceiveCompositingActor is should be used to support this pattern

  .. includecode:: code/BehaviouralComposition.scala
     :snippet: base_trait
