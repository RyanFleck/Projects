\NeedsTeXFormat{LaTeX2e}
\ProvidesClass{rcf_cv}[2019/09/17 Ryan's Resume Class]
\LoadClass{article}
\RequirePackage{titlesec} % From texlive-latex-extra.

\input{glyphtounicode}
\pdfgentounicode=1

% Increase the total=values to adjust the margins.
\usepackage[letterpaper, total={5.5in, 9.0in}]{geometry}
\usepackage[dvipsnames]{xcolor}
\usepackage{graphicx}
\usepackage{gensymb}

\usepackage{hyperref}
\hypersetup{
    colorlinks=false,
    linkbordercolor=white,
    urlbordercolor=white,
%    linkcolor=Blue,
%    filecolor=Blue,      
%    urlcolor=Blue,
}



\pagenumbering{gobble}

\titleformat{\section}
	{\LARGE\scshape\raggedright}
	{}{0em}
	{\textcolor{Blue}}
	
\titleformat{\subsection}
	{\large\scshape\raggedright}
	{}{0em}
	{}
	
\newcommand{\datedsubsection}[3]{
	\subsection[#1]{\large#1
		\small -- #2 
		\hfill #3}
}

\newcommand{\heading}[3]{
	\centerline{\Huge{#1}}
	\centerline{\small{#2}}
	\centerline{\small{#3}}
}

\newcommand{\workitems}[3]{
	\begin{itemize}
		\renewcommand\labelitemi{--}
		\setlength\itemsep{-0.4em}
		\item #1
		\item #2
		\item #3
	\end{itemize}
}
