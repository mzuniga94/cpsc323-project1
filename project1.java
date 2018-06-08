import java.util.*;
import java.io.*;

class project1 {

    public static void main(String[] args)
    {
        // Initialize reserved words and operators
        String[] reservedWords = {"cout<<", "for", "int", "while"};
        String[] special = {"<", "=", "*", "-", ",", "(", ")", "<=", "+", ","};

        //TODO: Figure out how to get relative path or correct directory
        String filename = "C:\\Users\\Matthew\\IdeaProjects\\cpsc323-project1\\src\\test.txt";
        String writeFile = "output.txt";
        String line = null; // One line at a time.

        int offset = 0; // Create an offset for the lines

        try
        { // Read and display line-by-line
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            // Write to "output.txt"
            FileWriter fileWriter = new FileWriter(writeFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            //TODO: After each token, have only one whitespace.
            //TODO: After each newline, have only one newline.
            while ((line = bufferedReader.readLine()) != null)
            {
                offset = line.indexOf("//");
                if (-1 != offset)
                {
                    line = line.substring(0, offset);
                }
                bufferedWriter.write(line);
                System.out.println(line);
            }
            bufferedReader.close();
            bufferedWriter.close();
        } catch (FileNotFoundException ex)
        {
            System.out.println(
                    "Unable to open file '" +
                            filename + "'");
        } catch (IOException ex)
        {
            System.out.println(
                    "Error reading file '"
                            + filename + "'");
        }
    }
}