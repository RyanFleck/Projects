\NeedsTeXFormat{LaTeX2e}
\ProvidesClass{rcf_cv}[2019/09/17 Ryan's Resume Class]
\LoadClass{article}
\RequirePackage{titlesec} % From texlive-latex-extra.



\usepackage[letterpaper, total={5in, 8in}]{geometry}



\pagenumbering{gobble}

\titleformat{\section}
	{\LARGE\scshape\raggedright}
	{}{0em}
	{}
	
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