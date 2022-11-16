package proj5;


/**
 * Driver for the index maker project
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Client
{
    public static void main(String[] args)
    {
        String file = "proj5/input.txt";
    	makeIndex(file); //replace with correct path
        //makeDictionary(file);
    }
    
    /**
     * Makes an index out of fileName. Gradescope needs this function.
     * 
     * @param fileName path to text file that you want to index
     */
    public static void makeIndex(String fileName) {
        // replace the following code
    	FileReadingDemo demo = new FileReadingDemo(fileName);
        demo.run();
    }
}
