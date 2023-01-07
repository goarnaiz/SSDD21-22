import java.util.ArrayList;

public class Encuesta {

	private String tema;
	private ArrayList<Pregunta> preguntas;

	public Encuesta(String tema, ArrayList<Pregunta> preguntas) {
		this.tema = tema;
		this.preguntas = preguntas;
	}

	public void anadirPregunta(Pregunta p) {
		this.preguntas.add(p);
	}

	public String getTema() {
		return this.tema;
	}

	public ArrayList<Pregunta> getPreguntas() {
		return this.preguntas;
	}

}
