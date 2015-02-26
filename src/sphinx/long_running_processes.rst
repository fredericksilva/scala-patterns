Long running processes
======================

why
  this pattern is asynchronous-sequential, not asynchronous-parallel. You apply this pattern when you need to do things sequentially, but you spend the bulk of the time doing the work largely outside of your code (e.g., it’s IO bound)
pattern
  .. includecode:: code/LongRunningProcesses.scala
   :snippet: sequence