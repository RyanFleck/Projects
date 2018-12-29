#RCF-Compile and Run Shell Script for C

if [ -z $1 ]; then
  echo "No argument." 
else
  if [ -f a.out ]; then
    rm a.out
  fi
  x=$1 
  y="${x%.c}"
  echo "Compiling $x"
  cc -std=c99 -Wall $x
  echo
  if [ -f a.out ]; then
    echo "Compilation successful. Running..."
    ./a.out
    rm a.out
  else
    echo "File was not compiled."
  fi
  echo
  echo
  echo "Done."
fi
