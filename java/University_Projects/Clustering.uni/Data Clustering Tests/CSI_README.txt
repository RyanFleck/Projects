/****************************************************/
/* Extra Testing for Clustering Data Application    */
/* Assignment#4                                     */
/* Instructions written by Lucia Moura              */
/****************************************************/

Here you will find:

1) New classes for testing written by TA Sahil Saroop

TestClusteringDataset (main class)
Distance (auxiliairy to calculate distance in data using weka library)
TXTtoCSV (converting the given files from .txt to .csv)

2) a jar file (WEKA library - a library for data mining applications)
http://www.cs.waikato.ac.nz/ml/weka/

3) Two directories with data from:

HARTINGAN clustering algorithm dataset
https://people.sc.fsu.edu/~jburkardt/datasets/hartigan/hartigan.html

SPAETH cluster analysis datasets
https://people.sc.fsu.edu/~jburkardt/datasets/spaeth/spaeth.html

KNOWN BUGS AND USAGE:
The parser does not work for all file types, and it may crash for a few files that are in different formats.
The data only makes sense for our program for the files where each line represent one data entry with a vector of attributes (e.g HATINGAN file02.txt); 
for data that is a table of distances ignore them since our parser does not ready hem that way (e.g. HARTINGAN file23.txt).

INSTRUCTIONS:
This tasks is optional, and are an opportunity for learning about data clustering
and doing a bit more testing on your program.
WARNING: Adding libraries and reading from files are likely to give you
some bugs just due to small mistakes where the new features are located.

To use this dataset.
0) Create a new project to do this extra testing; copy the old classes,
once your program is working properly with the previous tests.
(see WARNING above).
1) Add weka.jar library as a resource for your project.
2) Put the file directories where you want them.
3) Add the 3 java classes to your project.
4) Fix the file path in the first lines of TestClusteringDatasets, if needed.
5) Experiment with different files, distance types and number of clusters.



 
