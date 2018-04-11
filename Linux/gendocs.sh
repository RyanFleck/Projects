#!/bin/sh
#GENDOCS 1.0: Takes .md files in directory and PANDOC-s them through Latex.
if [ -z $1 ]; then
  echo "No argument supplied! Converting all .md docs in folder..."
  for x in *.md
  do
    y="${x%.md}"
    echo " "
    echo "Converting $x to multiple formats..."
    echo "$x >> $y.pdf"
    pandoc -f markdown_github -o $x.pdf -t latex $x
    echo "$x >> $y.docx"
    pandoc -f markdown_github -o $x.docx $x
    echo "$x >> $y.tex"
    pandoc -f markdown_github -o $x.tex -t latex $x
    echo "Docs for $x generated, moving to Documentation folder."
    rm Documentation/PDF/$y.pdf
    rm Documentation/Word/$y.docx
    rm Documentation/Latex/$y.tex
    mv $x.pdf Documentation/PDF/$y.pdf
    mv $x.docx Documentation/Word/$y.docx
    mv $x.tex Documentation/Latex/$y.tex
  done
else
  x=$1
  y="${x%.md}"
  echo " "
  echo "Converting $x to multiple formats..."
  echo "$x >> $y.pdf"
  pandoc -f markdown_github -o $x.pdf -t latex $x
  echo "$x >> $y.docx"
  pandoc -f markdown_github -o $x.docx $x
  echo "$x >> $y.tex"
  pandoc -f markdown_github -o $x.tex -t latex $x
  echo "Docs for $x generated, moving to Documentation folder."
  rm Documentation/PDF/$y.pdf
  rm Documentation/Word/$y.docx
  rm Documentation/Latex/$y.tex
  mv $x.pdf Documentation/PDF/$y.pdf
  mv $x.docx Documentation/Word/$y.docx
  mv $x.tex Documentation/Latex/$y.tex
  echo "Done!"
fi
