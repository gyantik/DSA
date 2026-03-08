@echo off
SET problem=%1
SET folder=%2

IF "%problem%"=="" (
    echo Usage: save.bat problem_name FolderName
    echo Example: save.bat two_sum ARRAYS
    exit /b
)

IF "%folder%"=="" (
    echo Usage: save.bat problem_name FolderName
    echo Example: save.bat two_sum ARRAYS
    exit /b
)

IF NOT EXIST "%folder%" mkdir "%folder%"

IF NOT EXIST "%folder%\%problem%.java" (
    echo // LeetCode: %problem% > "%folder%\%problem%.java"
    echo // Date: %date% >> "%folder%\%problem%.java"
    echo. >> "%folder%\%problem%.java"
    echo class Solution { >> "%folder%\%problem%.java"
    echo     // paste your solution here >> "%folder%\%problem%.java"
    echo } >> "%folder%\%problem%.java"
    echo ✅ File created: %folder%\%problem%.java
) ELSE (
    echo File already exists, opening it...
)

git add .
git commit -m "solved: %problem% - %folder%"
git push

echo.
echo Done! Green square added!