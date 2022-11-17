package proj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    private Scanner myReader;

    /**
     * Initializes the demo with the given file.
     * @param filename
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
            if(nextExpression.length() > 2 && !dictionary.contains(nextExpression)){
                if(index.wordContainsPage(pageNum, nextExpression)){
                    if(index.pagelistIsFull(nextExpression)){
                        index.addPageNum(pageNum, nextExpression);
                    }
                    else{
                        index.delete(nextExpression);
                        dictionary.insert(nextExpression);
                    }
                }
            }
            else{
                index.makeEntry(nextExpression);
            }
        }
    }
}
