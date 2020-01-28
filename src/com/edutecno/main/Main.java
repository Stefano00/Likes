package com.edutecno.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Main {
	

	public static void main(String... args) {
		    String nombre = "Data"; 
			FileReader fr = null;
			BufferedReader br = null;
			String data = "";
			int varmax=0;
			int varmin=0;
			ArrayList<String> arreglo = new ArrayList<String>();
			ArrayList<String> arregloejer1 = new ArrayList<String>();
			ArrayList<String> arreglofotos = new ArrayList<String>();
			ArrayList<String> frecuencia = new ArrayList<String>();
			ArrayList<Integer> frecuenciaint = new ArrayList<Integer>();
			int suma = 0;
			

			try {
				fr = new FileReader(nombre);
				br=new BufferedReader(fr);
				data = br.readLine();

				while (data != null) {
					arreglo = new ArrayList<String>(Arrays.asList(data.split(" ")));
					for(String fotos:arreglo) {
						arregloejer1.add(fotos);
					}
					data = br.readLine();
				}
				arreglofotos = (ArrayList<String>) arregloejer1.stream().distinct().collect(Collectors.toList());
				Collections.sort(arreglofotos);
				System.out.println(arreglofotos);   // ejercicio Crear un arreglo con los nombres de las fotos (sin repetir) y ordenarlas de menor a mayor
			
				
				frecuencia=arregloejer1;
				
				
				for(int i=0; i<arreglofotos.size(); i++) {
					System.out.println("foto" + (i+1) + ": " + (Collections.frequency(frecuencia, "foto"+ (i+1)) + " likes"));
					frecuenciaint.add(Collections.frequency(frecuencia, "foto"+ (i+1)));		
					
				}
				varmax=Collections.max(frecuenciaint);
				for(int i=0; i<arreglofotos.size();i++){
					if(varmax==frecuenciaint.get(i)) {
						varmax=i+1;
						//System.out.println(varmax);
						i=arreglofotos.size();
					}
				}
				varmin=Collections.min(frecuenciaint);
				for(int i=0; i<arreglofotos.size();i++){
					if(varmin==frecuenciaint.get(i)) {
						varmin=i+1;
						//System.out.println(varmin);
						i=arreglofotos.size();
					}
				}
				 // número mayor
				System.out.println("La foto con más likes es: foto" + varmax + " con "+ (Collections.max(frecuenciaint))+ " likes");
				
				 // número menor
				System.out.println("La foto con menos likes es: foto" + varmin +" con "+ (Collections.min(frecuenciaint))+ " likes");
			
				// promedio
								
				for(int temp1 : frecuenciaint) {
					suma += temp1;
				}
				
				System.out.println("El promedio de likes es de: "+ suma/frecuenciaint.size());		
				br.close();
				fr.close();
			}
	
			catch (Exception e){
				System.out.println("Excepcion leyendo fichero "+ nombre + ": " + e);
			}


	}

}