import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numEncuesta = 0;
		Scanner sc = new Scanner(System.in);
		int seleccionado = 0;
		do {
			System.out.println("Seleccione el tema del que quiere realizar la encuesta");
			System.out.println("1. Política");
			System.out.println("2. Economía");
			System.out.println("3. Cine");
			System.out.println("4. Ocio");
			System.out.println("5. Deportes");
			System.out.println("0. Salir");
			seleccionado = sc.nextInt();

			if (seleccionado >= 0 && seleccionado <= 5) {
				try (Socket s = new Socket("localhost", 6666);
						DataOutputStream dos = new DataOutputStream(s.getOutputStream());) {

					dos.writeBytes(seleccionado + "\r\n");

					// Primer voto
					int voto1 = sc.nextInt();
					dos.writeBytes(voto1 + "\r\n");
					dos.flush();

					// Segunto voto
					int voto2 = sc.nextInt();
					dos.writeBytes(voto2 + "\r\n");
					dos.flush();

					// Tercer voto
					int voto3 = sc.nextInt();
					dos.writeBytes(voto3 + "\r\n");
					dos.flush();

					s.close();

				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}

		} while (seleccionado > 5 || seleccionado < 0);

	}

}
