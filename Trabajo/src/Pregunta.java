import java.util.ArrayList;

public class Pregunta {
	
	private String enunciado;
	private ArrayList<String> respuestas;
	
	public Pregunta(String enunciado, ArrayList<String> respuestas) {
		this.enunciado = enunciado;
		this.respuestas = respuestas;
	}
	
	public String getEnunciado() {
		return this.enunciado;
	}
	
	public ArrayList<String> getRespuestas(){
		return this.respuestas;
	}

}
