package logica;

import java.io.*;
import java.util.*;

public abstract class FileUtil {

	public static List<Premio> loadFilePremio(String nombreFicheroEntrada, List<Premio> listaCatalogo) {

		String linea;
		String[] datosPremio = null;

		try {
			BufferedReader fichero = new BufferedReader(new FileReader(nombreFicheroEntrada));
			while (fichero.ready()) {
				linea = fichero.readLine();
				datosPremio = linea.split("@");
				listaCatalogo.add(new Premio(datosPremio[0], datosPremio[1].charAt(0), datosPremio[2], datosPremio[3],
						Integer.parseInt(datosPremio[4])));
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
		return listaCatalogo;
	}

	public static void saveToFileCliente(String nombreFicheroSalida, List<Cliente> listaClientes) {
		try {
			BufferedWriter fichero = new BufferedWriter(new FileWriter("files/" + nombreFicheroSalida));
			String linea = "";
			for (Cliente c : listaClientes) {
				fichero.write(c.toStringFile());
			}
			fichero.write(linea);
			fichero.close();
		}

		catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido guardar");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida");
		}
	}

	public static void saveToFileEntrega(String nombreFicheroSalida, Entrega entrega) {
		try {
			BufferedWriter fichero = new BufferedWriter(new FileWriter("files/" + nombreFicheroSalida));
			String linea = entrega.toString();
			fichero.write(linea);
			fichero.close();
		}

		catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido guardar");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida");
		}
	}

	public static List<Cliente> loadFileCliente(String nombreFicheroEntrada, List<Cliente> listaCliente) {

		String linea;
		String[] datosCliente = null;

		try {
			BufferedReader fichero = new BufferedReader(new FileReader(nombreFicheroEntrada));
			while (fichero.ready()) {
				linea = fichero.readLine();
				datosCliente = linea.split("@");
				listaCliente.add(new Cliente(datosCliente[0], datosCliente[1], Integer.parseInt(datosCliente[2])));
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
		return listaCliente;
	}
}
