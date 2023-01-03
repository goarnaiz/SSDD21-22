import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(Socket s = new Socket("localhost", 6666);
				DataOutputStream dos = new DataOutputStream(s.getOutputStream());
				DataInputStream dis = new DataInputStream(s.getInputStream());){
			
			int numEncuesta = 0;
			Scanner sc = new Scanner(System.in);
			
			do {
				System.out.println("Seleccione el tema del que quiere realizar la encuesta");
				System.out.println("1. Política");
				System.out.println("2. Economía");
				System.out.println("3. Cine");
				System.out.println("4. Ocio");
				System.out.println("5. Deportes");
				System.out.println("0. Salir");
				
				int seleccionado = sc.nextInt();
				
				dos.writeBytes(seleccionado + "\r\n");
				
			}while(numEncuesta != 0);
			
			
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
