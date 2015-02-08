# Overview
Project that contains scala-related patterns and practices. So patterns & practices for akka, spray or sbt are also welcome!

# Basic philosophy
* Let it be an easy and accessible lookup and reference
* Let code speak. So every pattern or practice should have a minimal description to support the code.

# How to contribute
* Do you see a typo? Or another issue in the code? Please fix it on master!
* Do you have a new pattern or practice? Create a pull request!

# How to contribute a pattern
* Find a good, descriptive name that covers it.
* Do you have a pattern? Please provide a related code-smell.
* Do you have an anti-pattern? Please provide also a solution what the desired result should be.
* Every pattern or practice should get a seperate .rst file and a scala file. Rename these files to your patternname.
* Don't create subfolders. For now, we don't structure the patterns. First we want to build a library and then we'll have a good feeling how to structure them.
* When you've created a code example, please take your time and ask yourself? Can it be more simple with less code?
* When you've created a description, please take your time and ask yourself again? ...
* We prefer inline comments above a description, because they are more context bound.

# Last but not least
* You can link in your .RST to parts in the codebase
* Every commit on master will result in a new deploy on www.scalapatterns.io

# Includecode
There are several ways to include code
* Include code block `//# snippet_name` and end the block with `//#`
* Add a specification with signature `"snippet_name" in compileOnly { ... } `
* Cherry pick some lines for a snippet with `... code ... // snippet_name
* Only a _method_ signature by naming the def/val the name of the snippet `def snippet_name(..) = {}`

Note that one can refer multiple times to a snippet in a code file. These code_lines will be merged
One can hide a line with the comment `// hide ...`
