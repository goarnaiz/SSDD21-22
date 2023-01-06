import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (ServerSocket ss = new ServerSocket(6666)) {

			ExecutorService pool = Executors.newCachedThreadPool();

			// Cargo las encuestas de mi base de datos virtualizada
			// Preguntas encuesta política

			Encuesta politica = new Encuesta("politica", new ArrayList<Pregunta>());
			Encuesta economia = new Encuesta("economia", new ArrayList<Pregunta>());
			Encuesta cine = new Encuesta("cine", new ArrayList<Pregunta>());
			Encuesta ocio = new Encuesta("ocio", new ArrayList<Pregunta>());
			Encuesta deportes = new Encuesta("deportes", new ArrayList<Pregunta>());

			BDEncuestas bdEncuesta = new BDEncuestas(politica, economia, cine, ocio, deportes);

			while (true) {
				try {
					Socket s;
					s = ss.accept();
					DataOutputStream dos = new DataOutputStream(s.getOutputStream());
					DataInputStream dis = new DataInputStream(s.getInputStream());

					System.out.println("Hola cliente " + s.getInetAddress().getHostName());

					int numSeleccionado = Integer.parseInt(dis.readLine());

					// System.out.println(s.getPort());

					AtenderPeticion ap = new AtenderPeticion(numSeleccionado, bdEncuesta, s);
					pool.execute(ap);

					// pool.shutdown();

					// s.close();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}

