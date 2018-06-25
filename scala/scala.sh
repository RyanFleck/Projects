#!/bin/sh
#Ryan's simple scala compile-and-runner.


if [ -z $1 ]; then
  echo "[rcf] Provide an argument."
else
  echo "[rcf] Compiling and running $1"
  scalac $1
  echo
  scala $1
  echo
  rm *.class
fi
