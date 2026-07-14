@echo off
setlocal EnableExtensions

rem Lightweight Maven bootstrapper for Windows. Downloads Maven only on first run.
set "MAVEN_VERSION=3.9.16"
set "MAVEN_HOME=%~dp0.mvn\apache-maven-%MAVEN_VERSION%"
set "MAVEN_ZIP=%~dp0.mvn\apache-maven-%MAVEN_VERSION%-bin.zip"

if exist "%MAVEN_HOME%\bin\mvn.cmd" goto runMaven

echo Maven is not installed. Downloading Maven %MAVEN_VERSION%...
if not exist "%~dp0.mvn" mkdir "%~dp0.mvn"
powershell -NoProfile -ExecutionPolicy Bypass -Command "Invoke-WebRequest -Uri 'https://dlcdn.apache.org/maven/maven-3/%MAVEN_VERSION%/binaries/apache-maven-%MAVEN_VERSION%-bin.zip' -OutFile '%MAVEN_ZIP%'"
if errorlevel 1 goto downloadFailed

echo Extracting Maven...
powershell -NoProfile -ExecutionPolicy Bypass -Command "Expand-Archive -LiteralPath '%MAVEN_ZIP%' -DestinationPath '%~dp0.mvn' -Force"
if errorlevel 1 goto extractFailed

:runMaven
call "%MAVEN_HOME%\bin\mvn.cmd" %*
exit /b %ERRORLEVEL%

:downloadFailed
echo Failed to download Maven. Check your internet connection and try again.
exit /b 1

:extractFailed
echo Failed to extract Maven.
exit /b 1
