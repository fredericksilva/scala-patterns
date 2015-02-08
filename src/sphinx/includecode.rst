Include Code
============

These samles are here to demonstrate the power of include code

First of all a simple todo

.. todo:: this is a todo

Second a todolist, which shows all todos in code

.. todolist::

Third, examples of how to include code in the documentation. Note that codeblocks/and lines are merged if they appear twice in the file

Codeblock
  .. includecode:: code/IncludeCode.scala
     :snippet: codeblock
Codeline
  .. includecode:: code/IncludeCode.scala
     :snippet: codeline
Specification block
  .. includecode:: code/IncludeCode.scala
     :snippet: spec
