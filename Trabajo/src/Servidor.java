import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExecutorService pool = Executors.newCachedThreadPool();
		HashMap<String, String> listaVotos = new HashMap<String, String>();

		try (ServerSocket ss = new ServerSocket(6666)) {

			// Cargo las encuestas de mi base de datos virtualizada

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
					DataInputStream dis = new DataInputStream(s.getInputStream());

					String hostName = s.getInetAddress().getHostName();

					System.out.println("Hola cliente " + hostName);

					// compruebo que el host no ha realizado ningún voto, a excepción de localhost
					// que puede realizar los votos que quiera (para realizar pruebas)
					if (!listaVotos.containsValue(hostName) || hostName.equals("127.0.0.1")) {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
						String fecha = sdf.format(new Date());
						listaVotos.put(fecha, s.getInetAddress().getHostName());

						int numSeleccionado = Integer.parseInt(dis.readLine());

						System.out.println("Lista de usuarios que han votado");
						for (String clave : listaVotos.keySet()) {
							System.out.println("Fecha " + clave + "\tHost: " + listaVotos.get(clave));
						}

						AtenderPeticion ap = new AtenderPeticion(numSeleccionado, bdEncuesta, s);
						pool.execute(ap);

					} else {
						System.out.println("Ya se ha realizado un voto desde este host");
						// s.close();
					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			pool.shutdown();
		}

	}

}
