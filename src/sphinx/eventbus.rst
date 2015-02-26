Eventbus
========

why
  Akka’s event bus concept is an excellent one; however, you don’t always require the generality of it. Often, you just want to create an event bus where the subscribers are actors. This pattern helps us achieve a reusable actor event bus.
other patterns
  The defaultsto pattern is used
pattern
  This is the pattern to use. It extends

  - Actoreventbus. Used for subscribe, unsubscribe and publish.
  - Lookupclassification. Used for publishing specific events to specific subscribers based on a classification.

  .. includecode:: code/Eventbus.scala
 		:snippet: eventbus_pattern

  The classification can be a **default**. In this case the classify function will be used. The events are classified on its class type. (See example on postofficeA)

  The classification can be **customized**. In this case one have to provide a selection function. (See example with postoffficeB)

domain model
  The domain model that is used in the next examples.

 	.. includecode:: code/Eventbus.scala
 	  :snippet: setup

Postoffice A: Eventbus with default (class) classification
  In this example we will use the default classfication. The customer subscribes for events of the letternotification class.

  When we do classification by class type, we need to use the defaultsto pattern in the patterndefinition, because we want a default type for typeparameters. If not, we would have an exception in the creation of EventBusForActors in postofficeA. This is a phantom type implementation of a concept that supplies default values to type parameters - something lacking in Scala.

  .. includecode:: code/Eventbus.scala
    :snippet: postofficea

Postoffice B: Eventbus with custom classification
  In this example we will use the custom classfication. The customer subscribes for events that are classified by a boolean. It receives the events when the classification is has the value true.

 	.. includecode:: code/Eventbus.scala
	  :snippet: postofficeb