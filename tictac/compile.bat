echo off
start /min javac -d build\classes -s build\classes -h build\classes -classpath .\src;build\classes src\*.java
exit