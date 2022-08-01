package com.sinube.T;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class read {
	
	public ArrayList Leerfile(String ruta) throws IOException{
		
		Scanner leer = new Scanner(System.in);
		//ArrayList listOfPeople = new ArrayList();
		ArrayList<String> listOfPeople = new ArrayList<String>();
		String sspli = ",";
		int numFilas = 0;
		
		System.out.println("La longitud de la coleccion es " + listOfPeople.size() );
		
		try {
			BufferedReader bufferLector = new BufferedReader(new FileReader(ruta));
					
					String filas = bufferLector.readLine();

					while(filas != null) {
						String[] data= filas.split(sspli);
						numFilas ++;
			
						listOfPeople.add(filas);
						
						filas = bufferLector.readLine();
					}

					bufferLector.close();
					return listOfPeople;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listOfPeople;

	}
	

}
