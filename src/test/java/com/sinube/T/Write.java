package com.sinube.T;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Write {

	/*
	public static void writeFile(String ruta) throwns FileNotFoundException,  IOException{
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(ruta), "utf-8");
			writer.write("Textito uwu");
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	*/
		
		private static BufferedWriter bw;

		public static void main(String []args) {
			
			try {
				bw = new BufferedWriter(
						new FileWriter("C:\\Users\\envaldez\\Documents\\sinubeT\\data.txt")
				);
				bw.write("Hola, ya funciona :' ");
				
				
			}catch (Exception e) {
				// TODO: handle exception
				return;
			}
			
		}

	
}