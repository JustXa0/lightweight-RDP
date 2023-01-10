import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class RDPFileGenerator{
	
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
	static LocalDateTime now = LocalDateTime.now();
	static File file = new File("C:\\Users\\offic\\Desktop\\TempFiles\\encrp_"+dtf.format(now)+".txt");
	
	public RDPFileGenerator() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void SaveFile(String text) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(file, true));
		out.println(text);
		out.close();
	}
	
	
	
	
	

}