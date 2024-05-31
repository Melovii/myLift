@echo off
set bin=%~dp0bin
set src=%~dp0src

if exist %bin% rmdir /S /Q %bin%

mkdir %bin% && javac -encoding utf8 -d %bin% -cp %src% %src%\myLift.java

@REM jar cvfe %~dp0myLift.jar Main -C %bin%