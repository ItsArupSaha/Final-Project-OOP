import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JOptionPane;

public class ReadTextFile {
    private static ObjectInputStream input;
    
    public static void openFile(){
        try{
            input = new ObjectInputStream(Files.newInputStream(Paths.get("Students.ser")));
        }
        catch(IOException ioException){
            System.err.println("Error opening file.");
            System.exit(1);
        }
    }

    public static void readRecords(){
        try{
            while (true){
                    StudentInfo record = (StudentInfo) input.readObject();

                    // display record contents
                    System.out.printf("%-10d%-12s%-12s%10.2f%n",
                    record.name, record.id,
                    record.department, record.batch, record.section);
            }
        }catch (EOFException endOfFileException){
            System.out.printf("%No more records%n");

        }catch (ClassNotFoundException classNotFoundException){
            System.err.println("Invalid object type. Terminating.");

        }catch (IOException ioException){
            System.err.println("Error reading from file. Terminating.");

        }
    }

    public static void closeFile(){
        try{
            if (input != null)
                input.close();
                
        }catch (IOException ioException){
            System.err.println("Error closing file. Terminating.");
        }
    }
}
