@echo off
cd ..
javac -d .\tmp\classes .\FunctionsExtractor.java
java -cp .\tmp\classes function.builder.FunctionsExtractor
pause