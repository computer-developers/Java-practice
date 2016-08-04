echo off
start javac -d build\classes -s build\classes -h build\classes -classpath .\src;build\classes src\*.java
exit