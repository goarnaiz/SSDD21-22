import java.util.ArrayList;

public class Pregunta {

	private String enunciado;
	private ArrayList<Respuesta> respuestas;

	public Pregunta(String enunciado, ArrayList<Respuesta> respuestas) {
		this.enunciado = enunciado;
		this.respuestas = respuestas;
	}

	public String getEnunciado() {
		return this.enunciado;
	}

	public ArrayList<Respuesta> getRespuestas() {
		return this.respuestas;
	}

	public Respuesta getRespuesta(int n) {
		return this.respuestas.get(n);
	}

	public void anadeRespuesta(Respuesta r) {
		this.respuestas.add(r);
	}

	public void muestraPregunta() {
		System.out.println(enunciado);
		int numRespuesta = 1;
		for (Respuesta respuesta : this.respuestas) {
			System.out.println(numRespuesta + ". " + respuesta.getTexto());
			numRespuesta++;
		}
		System.out.println("");
	}

	public void muestraPreguntaVotada() {
		System.out.println(enunciado);
		int numRespuesta = 1;
		for (Respuesta respuesta : this.respuestas) {
			double porcentaje; 
			float votosRespuesta = respuesta.getVotos();
			float votosTotales = this.getTotalVotos();
			
			if (votosTotales == 0) {
				porcentaje = 0;
			} else {
				porcentaje = Math.round(votosRespuesta / votosTotales) * 100;
			}

			System.out.println(numRespuesta + " ." + respuesta.getTexto() + " " + respuesta.getVotos() + " votos" + " ("
					+ porcentaje + "%)");
			numRespuesta++;
		}
		System.out.println("");
	}

	public int getTotalVotos() {
		int votosTotales = 0;
		for (Respuesta r : this.respuestas) {
			votosTotales += r.getVotos();
		}

		return votosTotales;
	}

}
