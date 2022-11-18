package proj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
    /**
    * FileReader class.  Reads a file and makes an index and dictionary with the text in the file
     * *
    * @author Hope Crisafi
    * @version 151 Fall 2022
    */
public class FileReader {

    private final int MIN_LENGTH = 2;
    private Scanner myReader;

    /**
     * Initializes the demo with the given file.
     * @param filename a file to read
     */
    public FileReader (String filename) {
        try {
            myReader = new Scanner(new File(filename));
            myReader.useDelimiter("[^a-zA-Z#]+");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    /**
     * Reads and prints the file word by word.
     */
    public void run() {
        Dictionary dictionary = new Dictionary();
        Index index = new Index();
        int pageNum = 1;
        while (myReader.hasNext()) {
            String nextExpression = myReader.next();
            if(nextExpression.equals("#")){
                pageNum++;
            }
            if(nextExpression.length() > MIN_LENGTH && !dictionary.contains(nextExpression)){
                if(index.containsWord(nextExpression)){
                    if(!index.wordContainsPage(pageNum, nextExpression)){
                        if(!index.pagelistIsFull(nextExpression)){
                            index.addPageNum(pageNum, nextExpression);
                        }
                        else{
                            index.delete(nextExpression);
                            dictionary.insert(nextExpression);
                        }
                    }
                }
                else{
                    index.makeEntry(nextExpression, pageNum);
                }
            }

        }
        System.out.println("");
        index.orderedPrint();
        System.out.println("");
        dictionary.orderedPrint();
    }


}
