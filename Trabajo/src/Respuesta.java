
public class Respuesta {

	private String texto;
	private int votos;

	public Respuesta(String texto, int votos) {
		this.texto = texto;
		this.votos = votos;
	}

	public String getTexto() {
		return this.texto;
	}

	public int getVotos() {
		return this.votos;
	}

	public void sumaVoto() {
		this.votos++;
	}

}
