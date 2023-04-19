package ejercicio.obligatorio2;

import java.io.*;

/**
 * 
 * @author Dani Dom
 *
 */
public class Main {
	/**
	 * Basic menu.
	 * 
	 * @return opcion.
	 */
	public static int menu() {
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
	 * Añadimos un nuevo registro.
	 */
	public static void nuevoRegistro() {
		String fecha = Entrada.pedirCadena("Introduzca la fecha");
		int tempMax = Entrada.pedirEntero("Indique la temperatura máxima");
		int tempMin = Entrada.pedirEntero("Indique la temperatura mínima");
		try (BufferedWriter escritor = new BufferedWriter(new FileWriter("10.24.txt", true))) {
			escritor.newLine();
			escritor.write(fecha + "\t\t " + tempMax + "\t\t\t " + tempMin);

		} catch (IOException e) {

		}
	}

	/**
	 * Nos muestra la lista de registros.
	 * 
	 * @param archivo Localización/Nombre del archivo del que queremos mostrar el
	 *                contenido.
	 * @throws FileNotFoundException : En caso de no encontrar el archivo.
	 * @throws IOException.          En caso de error de lectura.
	 */
	public static void muestraContenido(String archivo) throws FileNotFoundException, IOException {
		String cadena;
		BufferedReader lector = new BufferedReader(new FileReader(archivo));
		while ((cadena = lector.readLine()) != null) {
			System.out.println(cadena);
		}
		lector.close();
	}

	/**
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		// Opción del menu.
		int opcion;
		// Bandera de escape.
		boolean fin = false;

		// Menu.
		do {

			opcion = menu();
			switch (opcion) {
			case 1 -> {
				nuevoRegistro();
			}
			case 2 -> {
				try {
					muestraContenido("10.24.txt");
				} catch (FileNotFoundException e) {

					e.printStackTrace();
				} catch (IOException e) {

					e.printStackTrace();
				}

			}
			case 3 -> {
				System.out.println("Gracias por usar nuestro software, adios.");
				fin = true;
			}
			}
		} while (!fin);

	}

}
