package ejercicioobligatorio;

import java.io.*;

import javax.xml.bind.*;

/**
 * Main class
 *
 */
public class Main {
	/**
	 * Basic menu.
	 * 
	 * @return opcion.
	 */
	public static int menu() {
		// Opcion indicada por el usuario.
		int opcion = 0;

		do {
			System.out.println("1. Registrar nueva temperatura.");
			System.out.println("2. Mostrar historial de registros.");
			System.out.println("3. Salir");
			opcion = Entrada.pedirEntero("Escriba su opcion");
		} while ((opcion < 0) || (opcion > 3));
		return opcion;
	}

	/**
	 * Listado historial registros
	 * 
	 * @param String localización fichero
	 */
	private static void muestraContenido(String archivo) {

		try {

			JAXBContext contexto = JAXBContext.newInstance(Listado.class);
			Unmarshaller um = contexto.createUnmarshaller();
			Listado l = (Listado) um.unmarshal(new File(archivo));
			// Imprime
			System.out.println(l);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Añadimos un nuevo registro.
	 */
	public static Registry nuevoRegistro() {
		// Temperatura Minima
		int tempMin;
		// Temperatura Maxima
		int tempMax;
		// Fecha de registro
		String fecha;
		// Se solicita la fecha.
		fecha = Entrada.pedirCadena("Introduzca la fecha");
		// Se solicita temperatura maxima.
		tempMax = Entrada.pedirEntero("Indique la temperatura máxima");
		// Se solicita temperatura minima.
		do {
			tempMin = Entrada.pedirEntero("Indique la temperatura mínima");
		} while (tempMin > tempMax);
		// Crea un objeto Registry con las variables obtenidas.
		Registry r1 = new Registry(fecha, tempMax, tempMin);

		return r1;
	}

	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Opción del menu.
		int opcion;
		// Bandera de escape.
		boolean fin = false;
		Listado lista = new Listado();

		// Ejecución programa.
		do {

			opcion = menu();
			switch (opcion) {
			case 1 -> {
				try {
					JAXBContext contexto = JAXBContext.newInstance(Listado.class);
					Unmarshaller um = contexto.createUnmarshaller();
					lista = (Listado) um.unmarshal(new File("Registros.xml"));
					lista.nuevoRegistro(nuevoRegistro());
					Marshaller m = contexto.createMarshaller();
					m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
					m.marshal(lista, new FileWriter("Registros.xml"));
				} catch (JAXBException | IOException e) {
					e.printStackTrace();
				}
			}
			case 2 -> {
				try {
					// Llamada metodo muestraContenido.
					muestraContenido("Registros.xml");
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
			case 3 -> {
				// Mensaje finalización programa.
				System.out.println("Gracias por usar nuestro software, adios.");
				fin = true;
			}
			}
		} while (!fin);

	}

}
