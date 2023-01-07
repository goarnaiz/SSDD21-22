import java.util.ArrayList;

public class BDEncuestas {

	private Encuesta politica;
	private Encuesta economia;
	private Encuesta cine;
	private Encuesta ocio;
	private Encuesta deportes;

	public BDEncuestas(Encuesta e1, Encuesta e2, Encuesta e3, Encuesta e4, Encuesta e5) {
		this.politica = e1;
		this.economia = e2;
		this.cine = e3;
		this.ocio = e4;
		this.deportes = e5;
		inicializaEncuestas(e1, e2, e3, e4, e5);

	}

	public Encuesta getEncuesta(int numEncuesta) {

		Encuesta e = null;

		switch (numEncuesta) {
		case 1: {
			e = getEncuestaPolitica();
			return e;
		}
		case 2: {
			e = getEncuestaEconomia();
			return e;
		}
		case 3: {
			e = getEncuestaCine();
			return e;
		}
		case 4: {
			e = getEncuestaOcio();
			return e;
		}
		case 5: {
			e = getEncuestaDeportes();
			return e;
		}

		}

		return e;

	}

	public static void anadePregunta(Encuesta e, Pregunta p) {

	}

	private Encuesta getEncuestaPolitica() {
		return politica;
	}

	private Encuesta getEncuestaEconomia() {
		return economia;
	}

	private Encuesta getEncuestaCine() {
		return cine;
	}

	private Encuesta getEncuestaOcio() {
		return ocio;
	}

	private Encuesta getEncuestaDeportes() {
		return deportes;
	}

	public void inicializaEncuestas(Encuesta e1, Encuesta e2, Encuesta e3, Encuesta e4, Encuesta e5) {

		// Preguntas encuesta política
		ArrayList<Pregunta> preguntasVacia = new ArrayList<Pregunta>();
		ArrayList<String> listaRespuestasVacia = new ArrayList<String>();

		Pregunta p1 = new Pregunta(
				"¿Crees que el gobierno actual va en la dirección correcta para beneficiar a la población del país?",
				new ArrayList<Respuesta>());
		p1.anadeRespuesta(new Respuesta("Sí", 0));
		p1.anadeRespuesta(new Respuesta("No", 0));

		Pregunta p2 = new Pregunta("¿Estás inscrito para votar en la dirección actual en la que resides?",
				new ArrayList<Respuesta>());
		p2.anadeRespuesta(new Respuesta("Sí", 0));
		p2.anadeRespuesta(new Respuesta("No", 0));

		Pregunta p3 = new Pregunta("¿Qué probabilidades hay de que votes en las próximas elecciones?",
				new ArrayList<Respuesta>());
		p3.anadeRespuesta(new Respuesta("Muchas probabilidades de votar", 0));
		p3.anadeRespuesta(new Respuesta("Pocas probabilidades de votar", 0));
		p3.anadeRespuesta(new Respuesta("No votaré", 0));
		p3.anadeRespuesta(new Respuesta("No lo sé", 0));

		e1.anadirPregunta(p1);
		e1.anadirPregunta(p2);
		e1.anadirPregunta(p3);

		// Preguntas encuesta economía

		Pregunta pe1 = new Pregunta("¿La crisis ha llegado a su cartera?", new ArrayList<Respuesta>());
		pe1.anadeRespuesta(new Respuesta("Sí", 0));
		pe1.anadeRespuesta(new Respuesta("No", 0));

		Pregunta pe2 = new Pregunta("¿Tiene problemas para llegar a fin de mes?", new ArrayList<Respuesta>());
		pe2.anadeRespuesta(new Respuesta("Sí", 0));
		pe2.anadeRespuesta(new Respuesta("No", 0));

		Pregunta pe3 = new Pregunta("¿Ha tenido que recurrir a algún préstamo", new ArrayList<Respuesta>());
		pe3.anadeRespuesta(new Respuesta("Sí", 0));
		pe3.anadeRespuesta(new Respuesta("No", 0));

		e2.anadirPregunta(pe1);
		e2.anadirPregunta(pe2);
		e2.anadirPregunta(pe3);

		// Preguntas encuesta cine

		Pregunta pc1 = new Pregunta("¿Crees que debería haber cines públicos financiados por el Estado?",
				new ArrayList<Respuesta>());
		pc1.anadeRespuesta(new Respuesta("Sí", 0));
		pc1.anadeRespuesta(new Respuesta("No", 0));

		Pregunta pc2 = new Pregunta("¿Qué tipos de película te gustan?", new ArrayList<Respuesta>());
		pc2.anadeRespuesta(new Respuesta("Aventuras", 0));
		pc2.anadeRespuesta(new Respuesta("Animación", 0));
		pc2.anadeRespuesta(new Respuesta("Comedia", 0));
		pc2.anadeRespuesta(new Respuesta("Drama", 0));

		Pregunta pc3 = new Pregunta("¿Cuántas veces has visto tu película favorita?", new ArrayList<Respuesta>());
		pc3.anadeRespuesta(new Respuesta("1-4 veces", 0));
		pc3.anadeRespuesta(new Respuesta("5-10 veces", 0));
		pc3.anadeRespuesta(new Respuesta("10-15 veces", 0));
		pc3.anadeRespuesta(new Respuesta("Más de 15 veces", 0));

		e3.anadirPregunta(pc1);
		e3.anadirPregunta(pc2);
		e3.anadirPregunta(pc3);

		// Preguntas encuesta ocio

		Pregunta po1 = new Pregunta("¿Cuántas horas dedicas al ocio semanalmente?", new ArrayList<Respuesta>());
		po1.anadeRespuesta(new Respuesta("Ninguna", 0));
		po1.anadeRespuesta(new Respuesta("Entre 2 y 5", 0));
		po1.anadeRespuesta(new Respuesta("Entre 5 y 10", 0));
		po1.anadeRespuesta(new Respuesta("Más de 10", 0));

		Pregunta po2 = new Pregunta("¿Cómo gastas tu tiempo libre?", new ArrayList<Respuesta>());
		po2.anadeRespuesta(new Respuesta("Series y películas", 0));
		po2.anadeRespuesta(new Respuesta("Deporte outdoor", 0));
		po2.anadeRespuesta(new Respuesta("Leer un libro", 0));
		po2.anadeRespuesta(new Respuesta("Quedadas con amigos", 0));

		Pregunta po3 = new Pregunta("¿Tienes algún hobby?", new ArrayList<Respuesta>());
		po3.anadeRespuesta(new Respuesta("Sí", 0));
		po3.anadeRespuesta(new Respuesta("No", 0));

		e4.anadirPregunta(po1);
		e4.anadirPregunta(po2);
		e4.anadirPregunta(po3);

		// Preguntas encuesta deportes

		Pregunta pd1 = new Pregunta("¿Con qué frecuencia haces ejercicio?", new ArrayList<Respuesta>());
		pd1.anadeRespuesta(new Respuesta("Nunca", 0));
		pd1.anadeRespuesta(new Respuesta("1 día a la semana", 0));
		pd1.anadeRespuesta(new Respuesta("Pocas veces al mes", 0));
		pd1.anadeRespuesta(new Respuesta("3 a 5 días a la semana", 0));

		Pregunta pd2 = new Pregunta("¿Por qué razón haces ejercicio?", new ArrayList<Respuesta>());
		pd2.anadeRespuesta(new Respuesta("Por salud", 0));
		pd2.anadeRespuesta(new Respuesta("Lo disfruto", 0));
		pd2.anadeRespuesta(new Respuesta("Por trabajo", 0));
		pd2.anadeRespuesta(new Respuesta("para verme bien", 0));

		Pregunta pd3 = new Pregunta("¿Tienes alguna rutina en especial?", new ArrayList<Respuesta>());
		pd3.anadeRespuesta(new Respuesta("Sí", 0));
		pd3.anadeRespuesta(new Respuesta("No", 0));

		e5.anadirPregunta(pd1);
		e5.anadirPregunta(pd2);
		e5.anadirPregunta(pd3);

	}
}
