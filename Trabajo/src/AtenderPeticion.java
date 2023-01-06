import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class AtenderPeticion implements Runnable{

	private int numSeleccionado;
	private BDEncuestas bdEncuesta;
	private final Socket socket;
	
	
	public AtenderPeticion(int numSeleccionado, BDEncuestas bdEncuesta, Socket socket) {
		this.numSeleccionado = numSeleccionado;
		this.bdEncuesta = bdEncuesta;
		this.socket = socket;
	}

	@Override
	public void run() {
		
		Socket conexion = this.socket;
		try (DataInputStream dis = new DataInputStream(conexion.getInputStream());
				DataOutputStream dos = new DataOutputStream(conexion.getOutputStream());){
			
			System.out.println("El número seleccionado ha sido " + numSeleccionado);
			Encuesta elegida = bdEncuesta.getEncuesta(numSeleccionado);
			

			Scanner entrada = new Scanner(System.in);
			
			for (Pregunta p : elegida.getPreguntas()) {
				p.muestraPregunta();
				int voto = Integer.parseInt(entrada.nextLine());
				//int voto = Integer.parseInt(dis.readLine());
				System.out.println("Has votado la opción " + voto);
				p.getRespuesta(voto-1).sumaVoto();
			}
			
			System.out.println("Ha terminado la encuesta");
			System.out.println("Consulte los resultados de las votaciones realizadas hasta ahora");
			
			for (Pregunta p : elegida.getPreguntas()) {
				p.muestraPreguntaVotada();
			}
			
			System.out.println("Adiós cliente " + conexion.getInetAddress().getHostName());
			conexion.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}

