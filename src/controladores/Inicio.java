package controladores;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Inicio {
	 static Scanner sc = new Scanner (System.in);
	static String rutaArchivo = "C:\\Users\\Usuario\\eclipse-workspace\\ejercicio4FicherosJava\\" + "ficheros5.txt";
	public static void main(String[] args) {
		
		contenidoInicial();
		seleccionModificar();
	}
	
	public static void contenidoInicial() {
		try {
			FileWriter escritor = new FileWriter(rutaArchivo);

			System.out.println("Añada contenido al archivo");
			String contenido = sc.nextLine();
			escritor.write(contenido + "\n");
			escritor.write("Este es un ejemplo de escritura en un archivo utilizando Java.\n");
			escritor.close();

			FileWriter escritorNuevo = new FileWriter(rutaArchivo, true);

			System.out.println("Añada más contenido al archivo");
			String contenidoNuevo = sc.nextLine();
			escritorNuevo.write(contenidoNuevo);

			escritorNuevo.close();
		}
		catch (IOException e) {
			System.out.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	public static void seleccionModificar() {
		 System.out.println("Indica 'L' si deseas modificar una linea o 'P' si desees añadir una modificacion a partir de una posicion");
         String modificacion =sc.next();
         if (modificacion == "L")
         {
             System.out.println("Introduce el numero de la linea en la que deseas añadir el texto");
             int numeroLinea = sc.nextInt();
             System.out.println("Introduce el texto que deseas añadir");
             String textoNuevo =sc.next();

             try
             {
            	 BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo));
            	 StringBuilder nuevo = new StringBuilder();
     			String lineaActual;
     			int contador = 0;
     			while ((lineaActual = lector.readLine()) != null) {
    				contador++;
                 if (contador == numeroLinea)
                 {
                     nuevo.append(lineaActual).append(textoNuevo);
                 }else {
                	 nuevo.append(lineaActual);
                	 System.out.println("El texto se ha escrito correctamente en la línea especificada.");
                 }
 				
 				nuevo.append(System.lineSeparator());
 				lector.close();
     			} 
              
             }
             catch (IOException e) {
     			System.out.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
     			e.printStackTrace();
     		}
     		
         }
         else
         {
        	 System.out.println("Indique la linea que desea modificar");
 			int numeroDeLinea = sc.nextInt();
        	 System.out.println("Introduce la posicion en la que deseas añadir el texto");
             int posicionDeInicio =sc.nextInt();
             System.out.println("Introduce el texto que deseas añadir");
             String textoAInsertar = sc.next();

             try {
                 // Leer el archivo línea por línea y guardar cada línea en un StringBuilder
                 BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo));
                 StringBuilder contenido = new StringBuilder();
                 String lineaActual;
                 int contador = 0;
                 while ((lineaActual = lector.readLine()) != null) {
                     contador++;
                     if (contador == numeroDeLinea) {
                         // Modificar la línea deseada
                         contenido.append(lineaActual.substring(0, posicionDeInicio)).append(textoAInsertar)
                                 .append(lineaActual.substring(posicionDeInicio));
                     } else {
                         contenido.append(lineaActual);
                     }
                     contenido.append(System.lineSeparator());
                 }
                 lector.close();

                 // Escribir el contenido modificado en el archivo
                 BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaArchivo));
                 escritor.write(contenido.toString());
                 escritor.close();

                 System.out.println("Se ha escrito en la posición específica de la línea exitosamente.");
             } catch (IOException e) {
                 System.out.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
                 e.printStackTrace();
             }
	}
	
	}
}
