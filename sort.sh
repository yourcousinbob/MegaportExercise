#!/bin/sh

## Argument checking
if [ "$#" -ne 1 ]; then
    echo "Proper Usage is: ./sort file"
    exit 1
fi

if [[ $1 == *.txt ]]; then
    java -Dfile.encoding=UTF-8 -jar ./out/artifacts/MegaportExercise_jar/MegaportExercise.jar $1
else
    echo "Must use a text document"
    exit 1
fi

