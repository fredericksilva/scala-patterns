Defaults to
===========
what
  This is a phantom type implementation of a concept that supplies default values to type parameters - something lacking in Scala.  
without pattern
  In this scenario their will be a classcast exception because the compiler cannot infer the return type. 

  .. includecode:: code/DefaultsTo.scala
     :snippet: without_pattern
with pattern  
	when this pattern is used the compiler can infer the return type, that will be of type Vehicle

	.. includecode:: code/DefaultsTo.scala
		 :snippet: with_pattern
pattern to use  
  .. includecode:: code/DefaultsTo.scala
     :snippet: phantom_type

reference
  http://stackoverflow.com/a/6629984/230401