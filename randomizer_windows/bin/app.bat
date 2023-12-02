@echo off
set JLINK_VM_OPTIONS=
set DIR=%~dp0
"%DIR%\java" %JLINK_VM_OPTIONS% -m ru.grinchick.randomizer/ru.grinchick.randomizer.HelloApplication %*
