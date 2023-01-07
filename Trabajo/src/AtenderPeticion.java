import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

public class AtenderPeticion implements Runnable {

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
		try (DataInputStream dis = new DataInputStream(conexion.getInputStream());) {
			System.out.println("El número seleccionado ha sido " + numSeleccionado);
			Encuesta elegida = bdEncuesta.getEncuesta(numSeleccionado);

			Scanner entrada = new Scanner(System.in);

			for (Pregunta p : elegida.getPreguntas()) {
				int numRespuestasPregunta = p.getRespuestas().size();
				int voto = 0;
				do {
					p.muestraPregunta();
					try {
						voto = Integer.parseInt(entrada.nextLine());
					} catch (NumberFormatException e) {
						e.printStackTrace();
					}

				} while (voto > numRespuestasPregunta || voto < 1);

				// int voto = Integer.parseInt(dis.readLine());
				System.out.println("Has votado la opción " + voto);
				p.getRespuesta(voto - 1).sumaVoto();
			}

			System.out.println("Ha terminado la encuesta");
			System.out.println("Consulte los resultados de las votaciones realizadas hasta ahora");

			for (Pregunta p : elegida.getPreguntas()) {
				p.muestraPreguntaVotada();
			}

			System.out.println("Adiós cliente " + conexion.getInetAddress().getHostName() + ", gracias por votar.");
			conexion.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
