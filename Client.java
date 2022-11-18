package proj5;


/**
 * Driver for the index maker project
 * 
 * @author Hope Crisafi
 * @version 151 Fall 2022
 */
public class Client
{
    public static void main(String[] args)
    {
        String file = "uscons.txt";
    	makeIndex(file);
    }
    
    /**
     * Makes an index out of fileName. Gradescope needs this function.
     * 
     * @param fileName path to text file that you want to index
     */
    public static void makeIndex(String fileName) {
    	FileReader fileReader = new FileReader(fileName);
        fileReader.run();
    }


}
