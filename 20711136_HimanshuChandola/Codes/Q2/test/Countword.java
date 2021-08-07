import java.io.FileWriter;    
import java.io.IOException;   
import java.io.File;   
import java.io.BufferedReader;  
import java.io.FileReader;  
public class Countword {
  public static void main(String[] args) {
	  
	  String line;  
        int count = 0;  
    try {
      FileWriter myWriter = new FileWriter("filename.txt");
      myWriter.write("My name is Himanshu Chandola from GEHU");
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
	
	
	
	try  
	{  
File file=new File("filename.txt");  
FileReader fr=new FileReader(file);   
BufferedReader br=new BufferedReader(fr);   
StringBuffer sb=new StringBuffer();  

while((line=br.readLine())!=null)  
{  
String words[] = line.split(" ");      
    count = count + words.length;  
}  
fr.close();  
  
 System.out.println("Number of words present in given file: " + count);    
}  
catch(IOException e)  
{  
e.printStackTrace();  
}  
 
	
	
  }
}