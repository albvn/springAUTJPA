package Ejercicio1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ejercicioProcesos1Corregido {

	public static void main(String[] args) {
		

		ProcessBuilder pb1=new ProcessBuilder("gnome-terminal","ls");
		ProcessBuilder pb2=new ProcessBuilder("find","src");
		//ProcessBuilder pb3=new ProcessBuilder("cmd-exe","echo","hemos terminado");
		
		/*
		 * si queremos un tercer proceso que cuando acaben los procesos muestre un mensaje
		 * lo que hariamos es crear un tercer proceso y cuando acabe el segundo proceso.
		 * 		Si lo que queremos mostras es la salida del proceso p2
		 * habria que crear el pb3 al finalizar el pb2 y ahí introducimos en una variable String
		 * la linea del pb2 y lo introducimos en ProcessBuilder pb3=new ProcessBuilder("echo","linea");
		 */
		
		try {
			Process process1=pb1.start();
			Process process2=pb2.start();
			
			
			InputStream is = process1.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            
            while ((line = br.readLine()) != null) {
                process2.getOutputStream().write(line.getBytes());
                
            }
            
            int exitValue1 = process1.waitFor();
            
            br.close();
            process2.getOutputStream().close();
            
                        
            
            
            //recuperamos la salida del proceso 2 (getinputStream)
            
            InputStream is2=process2.getInputStream();
            BufferedReader br2 = new BufferedReader(new InputStreamReader(is2));
           
            
            while((line=br2.readLine())!=null) {
            	System.out.println(line);
            }
            int exitValue2=process2.waitFor();
           
            //PUNTO DONDE CREARIAMOS EL PB3
            
            System.out.println("Primer comando finalizado con código de salida: " + exitValue1);
            System.out.println("Segundo comando finalizado con código de salida: " + exitValue2);
		
			

}catch(IOException e) {
	
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		
		
		
		
		
		
	}//final

}//final
