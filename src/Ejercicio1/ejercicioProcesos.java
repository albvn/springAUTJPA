package Ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ejercicioProcesos {

	public static void main(String[] args) throws IOException, InterruptedException{
		
		
		

		ProcessBuilder pb1=new ProcessBuilder("gnome-terminal","ls");
		ProcessBuilder pb2=new ProcessBuilder("find","src");
		
		try {
			Process process1=pb1.start();
			Process process2=pb2.start();
			
			InputStream is = process1.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            
            while ((line = br.readLine()) != null) {
                process2.getOutputStream().write(line.getBytes());
                process2.getOutputStream().write(System.lineSeparator().getBytes());
            }
            
            br.close();
            process2.getOutputStream().close();
            
            int exitValue1 = process1.waitFor();
            int exitValue2 = process2.waitFor();
            
            System.out.println("Primer comando finalizado con código de salida: " + exitValue1);
            System.out.println("Segundo comando finalizado con código de salida: " + exitValue2);
		
			

}catch(IOException e) {
	
}
		
		
	
		
	}//final
}//final
