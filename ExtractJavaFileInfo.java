import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractJavaFileInfo {

    public static void main(String[] args) {

        final String BASE_PATH = "...the entire path here../JavaFileExtractor2000/test/";
        final String FILE_NAMES_INDEX_PATH =  "...the entire path here../JavaFileExtractor2000/fileNamesToParse.txt";
                                                ///ex: /home/your_username/Documents/playground/JavaFileExtractor2000/fileNamesToParse.txt
        processFiles(getFileNames(FILE_NAMES_INDEX_PATH), BASE_PATH);
    
    }


    //Expects files to be in the same directory as the base path
    static void processFiles(List<String> fileNames, String basePath){

        
        int methodCounter = 1;
        for (String fileName : fileNames) {
            System.out.println("\nFile : " + fileName );
            methodCounter = extractJavaFile(basePath + fileName,   methodCounter);
            //System.out.println("-----------------");
        }
    }

    //Batch processing
    static List<String> getFileNames(String fileNamesPath){
        List<String> fileNames = new ArrayList<String>();
        int count = 1;
        try {
            BufferedReader input = new BufferedReader(
                    new FileReader(fileNamesPath));
            String line;
            System.out.println("Files: ");
            while ((line = input.readLine()) != null){
                System.out.println(count + ". " + line);
                fileNames.add(line);

                count++;
            }
               
            input.close();
        } catch (IOException ex) {
            System.err.println("Error occured");
            ex.printStackTrace();
        }

        return fileNames; 
    }

    
    //method for openning text file
    static int extractJavaFile(String filePath, int methodCounter) {
        try {
            BufferedReader input = new BufferedReader(
                    new FileReader(filePath));
            String line, group;

            Pattern reMethod= Pattern.compile("(public|private|protected)([A-Za-z\\s]+)\\("); 
            Matcher matchMethod; 


            while ((line = input.readLine()) != null){
               
                matchMethod = reMethod.matcher(line);
               
                if (matchMethod.find()) {
                    group = matchMethod.group();
                    System.out.println(methodCounter + " " + group.substring(0, group.length() - 1));
                    methodCounter++;
                }
            }

            input.close();
        } catch (IOException ex) {
            System.err.println("Error occured");
        }
        return methodCounter;
    }

}
