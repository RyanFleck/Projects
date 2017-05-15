#!/bin/bash
# -*- coding: utf-8 -*-
#
#  classDirMaker.sh - shell script to initialize directory tree for a class.
#  
#  Copyright 2017 Ryan Fleck <rflec028@uottawa.ca>
#  
#  This program is free software; you can redistribute it and/or modify
#  it under the terms of the GNU General Public License as published by
#  the Free Software Foundation; either version 2 of the License, or
#  (at your option) any later version.
#  
#  This program is distributed in the hope that it will be useful,
#  but WITHOUT ANY WARRANTY; without even the implied warranty of
#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#  GNU General Public License for more details.
#  
#  You should have received a copy of the GNU General Public License
#  along with this program; if not, write to the Free Software
#  Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
#  MA 02110-1301, USA.
#

if [ ! "$1" ]; then
  echo -n "Enter class name >> "
  read className
else
  className="$1"
fi

#Ensure we're writing to a fresh directory.
if [ -d "$className" ]; then
  echo "Directory already exists!!!!!!!!!!!"
  exit 1
fi

echo "Creating directory tree for $className."
mkdir $className && cd $className
dirPath=$(pwd)
echo "Directory is located at $dirPath"

#Insert and fill class info file.
echo "Info file for $className: INSERT COURSE TITLE HERE">"$className.info"
date=$(date)
echo "Created by $USER on $date" >>"$className.info"
cat >> "$className.info" <<'EOL'
Professor: 
Important dates:
-
-
-

EOL

#Write top level folders.
mkdir $className.{Assignments,Labs,ClassNotes,Materials}
cd $dirPath/$className.Labs
for i in {1..10}; do 
  mkdir "$className.L$i"
  touch "$className.L$i"/"$className.L$i.Notes.txt"
  cat >> "$className.L$i"/"$className.L$i.Report.tex" <<'EOL'
\documentclass[a4paper,12pt]{article}
\begin{document}
\pagenumbering{roman}
\title{Lab LABTITLE.REPLACE}
\author{Ryan Fleck\\\#8276723}
\maketitle
\tableofcontents
\newpage
\pagenumbering{arabic}
\section{First Section: Topics.}
Talk about things here. $\Delta X$ is a thing. so is $\Sigma X$


\large${RY}{(1+\textit{a})^n + (\textit{f(le)+ck})}$

\begin{abstract}
The abstract text goes here.
\end{abstract}

\section{Introduction}
Here is the text of your introduction.

\begin{equation}
    \label{simple_equation}
    \alpha = \sqrt{ \beta }
\end{equation}

\subsection{Subsection One-A-Alpha-1}
Write your subsection text here.

\section{Conclusion}
Write your conclusion here.
\end{document}
EOL
  
  done

cd $dirPath/$className.Assignments
for i in {1..10}; do 
  mkdir "$className.A$i"
done

echo "Folders and files created."




