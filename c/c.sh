#RCF-Compile and Run Shell Script for C#
if [ -z $1 ]; then
  echo "No argument." 
else
  x=$1 
  y="${x%.c}"
  echo "Compiling $x"
  cc -std=c99 -Wall $x mpc.c -lm -lreadline
  echo "Compilation done. Running..."
  echo
  ./a.out
  echo
  echo
  echo "Done."
fi
