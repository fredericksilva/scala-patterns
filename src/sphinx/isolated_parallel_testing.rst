Isolated and parallel testing
=============================

what
  To support isolated and parallel testing.
actor under test
  The echo actor is the actor unde test

  .. includecode:: code/IsolatedAndParallelTesting.scala
   :snippet: actor_under_test

snippet
  This snippet generates unique id's for the actor systems

  .. includecode:: code/IsolatedAndParallelTesting.scala
   :snippet: unique_names

  This snippet defines parallel and isolating testing.

  - For each test a fixture is inserted, which one can override
  - The default fixture is an actorsystem with a unique id
  - The fixturetypeparam is something the scalatest requires

  .. includecode:: code/IsolatedAndParallelTesting.scala
   :snippet: pattern
sequential and parallel
  We can define two types of testing to support parallel and parallel testing

  .. includecode:: code/IsolatedAndParallelTesting.scala
   :snippet: type_def
example spec
  In this spec we create a specific fixture for testing echo, which instantiates an echo actor. This avoids duplication, because now we have the setup code and creation of the actor under test at a single place.

  .. includecode:: code/IsolatedAndParallelTesting.scala
   :snippet: actor_spec