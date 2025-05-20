#!/bin/bash

# 批量更新当前目录下的所有 git 项目

function printfColor() {
    local color_code="\e[0m"
    case "$1" in
        "red") color_code="\e[31m" ;;
        "green") color_code="\e[32m" ;;
        "yellow") color_code="\e[33m" ;;
        "blue") color_code="\e[34m" ;;
        "purple") color_code="\e[35m" ;;
        "cyan") color_code="\e[36m" ;;
        "grey") color_code="\e[37m" ;;
        *) color_code="\e[0m" ;;
    esac
    shift
    printf "${color_code}%s\e[0m\n" "$@"
}

printfColor "blue" ">>> 当前路径：$(pwd)"

function gitpull() {
    for file in `ls $1`
    do
        subdir="$1/$file"
    if [ -d "$subdir" ]
	then
        cd "$subdir"
	    filename="${subdir##*/}"
        printfColor "cyan" ">>> start git pull $filename"
        git pull
        else
            printfColor "yellow" ">>> ignore file: $subdir"
        fi
    done
    printfColor "green" ">>> finish..."
}

gitpull "$(pwd)"