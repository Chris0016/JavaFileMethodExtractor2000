Tool for extracting the method names from a given java File.

**Suggested Use**

Load all the files necessary into a DIR.

Update the BASE_PATH, FILE_NAMES_INDEX_PATH variables as necessary. 

The BASE_PATH variable holds the path directory where the actual files to be parsed are. 
The FILE_NAMES_INDEX_PATH varible holds the path of the file(including the file name)  indicating where the names of all the files to be parsed. 


**If you have a lot of files it is recommended to run**
 
    ls < dir of all files to parse> >  fileNamesToParse.txt


The current regex used searches for(public|private|protected) within the current line and grabs the result up to the "(" character. You can update the regex as deemed necessary. Currently the regex works best for java/c++ program files. 


Made by yours Truly.
 
