@echo off
cd ..
javac -d .\tmp\classes .\FunctionsBuilder.java
java -cp .\tmp\classes jmeos.functions.builder.FunctionsBuilder
echo End of function generation.
pause