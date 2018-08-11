# Ryan's LaTeX Manual

  [![Build Status](https://travis-ci.org/RyanFleck/Projects.svg?branch=master)](https://travis-ci.org/RyanFleck/Projects)

  [Formatted Manual](https://ryanfleck.github.io/tex)
  

*LaTeX* is a typesetting language designed for producing beautiful documents. I haven't done any work on this manual yet, but it should be updated sometime during **December 2018**.


> LaTeX, which is pronounced «Lah-tech» or «Lay-tech» (to rhyme with «blech» or «Bertolt Brecht»), is a document preparation system for high-quality typesetting. It is most often used for medium-to-large technical or scientific documents but it can be used for almost any form of publishing. [latex-project.org](https://www.latex-project.org/about/)

## Resume
Currently, I process my resume in LaTeX:
```latex

% LaTeX resume using res.cls
\documentclass[margin]{res}
%\usepackage{helvetica} % uses helvetica postscript font (download helvetica.sty)
%\usepackage{newcent}   % uses new century schoolbook postscript font
\setlength{\textwidth}{5.1in} % set width of text portion

\begin{document}

% Center the name over the entire width of resume:
 \moveleft.5\hoffset\centerline{\large\bf Ryan C. Fleck}
% Draw a horizontal line the whole width of resume:
 \moveleft\hoffset\vbox{\hrule width\resumewidth height 1pt}\smallskip
% address begins here
% Again, the address lines must be centered over entire width of resume:
 \moveleft.5\hoffset\centerline{ryan.fleck@protonmail.com}
 \moveleft.5\hoffset\centerline{1 613 501 4043}


\begin{resume}

\section{OBJECTIVE}  An internship or part-time position in the field of Computer or Software Engineering with special interest in human behavior analytics, data structures, information processing, GNU/Linux and Unix programming philosophies. Optimal term 4-12 mo.


\section{EDUCATION} {\sl Bachelor of Applied Science,} Computer Engineering \\
                University of Ottawa, Ontario, graduating April 2020

                {\sl High School Diploma, Gifted, with Honors} \\
                Westmount Charter School, Calgary, AB, graduated June 2015


\section{COMPUTER \\ SKILLS} {\sl Programming Languages} - Java, C, Python 2.7/3, Shell Scripting, MATLAB, C++(Arduino).\\
                 {\sl Formatting Languages} - HTML, CSS, LaTeX, Markdown.\\
                {\sl Operating Systems} - GNU/Linux, FreeBSD, MS Windows. \\
                 {\sl GNU/Linux Distributions} - RHEL, Debian and SUSE Linux products, and their respective downstream distributions, for desktop and small-server use.\\
                 {\sl Version Control} - Uses GIT for personal file organization and school projects.\\
                 {\sl Networking} - Personal user of ssh, ftp and associated security protocols.\\
                 {\sl Linux SysAdmin} - Runs a Debian server for personal/friend use.

\section{WORKPLACE \\ SKILLS}
 {\sl Documentation} - Proficient with the Microsoft Office Suite, Libreoffice and Latex.\\
{\sl Customer Service Experience} - Has worked in restaurants, coffee shops and retail.\\
{\sl Teamwork} - Has worked in teams on various job sites, excellent delegation skills.\\
{\sl Quality of Writing} - Appreciates brevity, can communicate ideas effectively over email.\\
{\sl Honest} - Appreciates critical feedback and peer review, won't blame or hide mistakes.\\
{\sl Helpful} - Will go out of his way to help peers with complex or poorly defined material.



\section{PERSONAL \\ PROJECTS}     
	{\sl Server} - Maintains a Debian server for Mumble, a personal cloud, remote computing.\\   
	{\sl Blog} - Built a site using Ruby and the Jekyll static site generator. Project blog.\\   
	{\sl BCOM} - Top-down turn-based strategy game implemented in Java based LibGDX.\\
	{\sl GameMaker Engine} - Has made a handful of 1-4 player, 2-D physics games.\\
	{\sl Art, Sound, Animation} - Creates assets for games using Krita, Gimp, Audacity, etc.\\
	{\sl Hack-a-thon} - Participant in Pebble Smartwatch Hack-a-thon. Implemented in C.





\section{EXPERIENCE} {\sl Analyst-Developer at MNP} \hfill Winter 2018 - Present\\
                Consulting and Software Development / Data Science position. Self-driven CO-OP.
                 \begin{itemize}  \itemsep -2pt %reduce space between items
                 \item Directly provides clients with documentation and updates on contracted work.
                \item  Presents technical materials to audiences with varying levels of expertise.
                \end{itemize}

                {\sl Partner at Starbucks Coffee} \hfill Summer 2017 - Winter 2018 \\
                Barista, Cashier, Support - Rideau Ctr, Ottawa, ON.
                 \begin{itemize}  \itemsep -2pt %reduce space between items
                 \item Valued member of the team with excellent customer service skills
                \item  Ensures efficient operation of the store, helps others and delegates tasks
                \end{itemize}

 {\sl General Laborer at Advantage Personnel} \hfill    Summer 2017 \\
                Contract light industrial, warehouse, dispatch, construction work - Ottawa, ON.
                 \begin{itemize}  \itemsep -2pt %reduce space between items
                 \item Courier Assistant for MIDLAND - Delivered pallets, night shift
                 \item Warehousing worker for various contractors, heavy lifting involved
                 \item Demolished and restored many buildings in downtown and rural Ottawa, including a Swiss Chalet, Sushi joint, French School and many private residences
\item Construction work- Digging, basic carpentry, can operate many basic machines
                 \end{itemize}


                {\sl Personal Shopper at Loblaws} \hfill            Summer 2016 - Winter 2017 \\
                Click and Collect Department - MacArthur Ave, Vanier, ON.
                 \begin{itemize}  \itemsep -2pt %reduce space between items
                 \item Prepared groceries for pickup by customers
                 \item Interacted directly with customers to confirm details and problems with order
                 \item Never missed a shift, was never late to work
                 \end{itemize}


\section{SPECIFIC \\ LANGUAGE \\ EXPERIENCE}
{\sl Shell Scripting} - Uses shell scripts to initialize and automate Linux installations.\\       
{\sl Java} - All school projects are completed in Java. Also used for many personal projects.\\
{\sl Python} - First programming language. Heavily utilized in personal sysadmin.\\
{\sl Haskell} -  Tinkered with while taking a statistics course, along with R and cLISP.\\
{\sl C} - Used to build a Pebble Watch-face and a number of small, simple programs.\\
{\sl MATLAB} - Used during 'Signals and Systems,' signal processing class ELG3125.\\
{\sl LaTeX} -  Used for assignments, labs and reports. Personal favorite for formatting.\\
{\sl Miscellaneous Scripting Languages} -  Give me a cheat sheet and a weekend.\\
{\sl In My Queue} - LISPs, Erlang, Rust, Hadoop, functional programming in general.




 \section{COMMUNITY \\ SERVICE}  {\sl Group Tutoring} - Organized and directed tutoring sessions for Introduction to Programming I (ITI1120). Helped to troubleshoot assignments and walked through generic solutions to common problems with a large group of students. Brought a personal projector to the library to more easily communicate with the group. One peer commented that my sessions were {\sl "Twice as useful as going to class."}\\
{\sl English and Math Tutoring} - Tutored young children grades 5-9 in Mathematics, English and Programming while attending classes at Westmount Charter School.



\section{SOCIAL \\ MEDIA}        
{\sl Github} - github.com/ryanfleck \\
{\sl Linkedin} - linkedin.com/in/ryan-fleck-b5769412a \\
{\sl Facebook} - facebook.com/ryan.fleck.585 \\

 \vfill
 {\hfill\large\bf ryanfleck.github.io}


\end{resume}
\end{document}






```

## Unreasonable amounts of polish for student docs.
Potential future project: **BSTEM**, "Beautiful Scientific Typesetting Effortlessly Made"
