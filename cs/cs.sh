#RCF-Compile and Run Shell Script for C#
if [ -z $1 ]; then
  echo "No arg, compiling all..."
  for x in *.cs
  do
    y="${x%.cs}"
    echo "Compiling C# program $y"
    # mcs $y.cs 
    echo "Compiling all programs has been disabled for now, please insert the name of the program you wish to compile and run as the first option."
  done
else
  x=$1
  echo "Arg $1 supplied."
  y="${x%.cs}"
  echo "Compiling C# program $y"
  mcs -out:prog.exe $y.cs
  echo "Compiled to prog.exe, running..."
  echo
  mono prog.exe
  echo
fi
