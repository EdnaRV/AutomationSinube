package com.sinube.T;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.RegEx;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.Rule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.sdk.metrics.data.Data;

import org.apache.commons.compress.harmony.pack200.NewAttribute;
import org.apache.commons.io.FileUtils;
import org.hamcrest.Description;
import org.openqa.selenium.TakesScreenshot;

import java.io.FileReader;
import java.util.Iterator;
import com.opencsv.CSVReader;
import java.util.Scanner;
import java.awt.print.Printable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.io.File;


public class SinubeAuto {
	WebDriver driver;
	//By text = By.tagName("h1");
	//By nInput = By.name("txtNombres");
	//	By dayLocator = By.xpath("//span[contains(text(),' 14 ')]");
	//By monthFromFile = By.xpath("//*[contains(text(), '" + monthFile + " ')]  ");
	//"//div[@class='class="igx-dialog__window-actions ng-star-inserted']" 
	//button[@class="igx-button--flat igx-button--compact ng-star-inserted"]
	//By okEClose = By.xpath("//button[@type = 'button'][contains(text(), 'OK')]");
	/*
	By pselected = By.xpath("//*[@id = \"igx-icon-1\"]");
	By lnacimiento = By.xpath("//input[@class='input igx-input-group__input']");
	*/
	
	By nInputx = By.xpath("//input[@name = 'txtNombres']");
	By apInput = By.xpath("//input[@name = 'txtApPaterno']");
	By amInput = By.xpath("//input[@name = 'txtApMaterno']");
	By calendarIcon = By.xpath("/html/body/app-root/app-calcula-curp/div/div[4]/igx-date-picker/igx-input-group/div[1]/igx-prefix/igx-icon");
	By btnDeleteCalendar = By.xpath("/html/body/app-root/app-calcula-curp/div/div[4]/igx-date-picker/igx-input-group/div[1]/igx-suffix/igx-icon");
	By writeCalendar = By.xpath("/html/body/app-root/app-calcula-curp/div/div[4]/igx-date-picker/igx-input-group/div[1]/div/input");
	By btn = By.xpath("/html/body/div/div/div/div[2]");
	By pl = By.xpath("/html/body/app-root/app-calcula-curp/div/igx-select/igx-input-group/div[1]/igx-suffix/igx-icon");
	By direct = By.xpath("//*[@id=\"igx-input-group-5\"]/div[1]/div/input");	
	By radioGenderM = By.xpath("//span[contains(text(), 'Mujer')]");
	By radioGenderH = By.xpath("//span[contains(text(), 'Hombre')]");
	By generateButton = By.xpath("/html/body/app-root/app-calcula-curp/div/div[5]/button");	
	By calendarAño = By.xpath("/html/body/div/div/div/igx-calendar-container/igx-calendar/div/div[1]/div[2]/span[2]");
	By currentAñoLocator = By.xpath("/html/body/div/div/div/igx-calendar-container/igx-calendar/igx-years-view/div/div/span[4]");
	By yearWindow = By.xpath("/html/body/div/div/div/igx-calendar-container/igx-calendar/igx-years-view");
	By monthLocator = By.xpath("//div[@class='igx-calendar__month ng-star-inserted'][contains(text(),' Sept ')]");
	By monthClick = By.xpath("/html/body/div/div/div/igx-calendar-container/igx-calendar/div/div[1]/div[2]/span[1]");
	By getTextCurp = By.xpath("//*[@id=\"igx-input-group-3\"]/div[1]/div/input");
	By CURPGenerated = By.xpath("//div[@class='igx-input-group__bundle-main']//input[@name=\"txtCurp\"]");
	By RFCGenerated = By.xpath("//button[@class=\"igx-button--outlined igx-button--outlined-compact\"]");
	
	private read archivo;
	//private String rutaArchivo = "C:\\Users\\envaldez\\Documents\\sinubeT\\data.txt";
	//private String rutaArchivo = "C:\\Users\\envaldez\\Documents\\sinubeT\\fullData.csv";


	
	@BeforeMethod
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/driver/chromedriver100.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.sinube.mx/calcula-tu-rfc-y-curp");
	}
	
//@Test
	
	public void test() throws InterruptedException, FileNotFoundException {
		int añoDeseado = 0;
		String monthFromFile = "";
		String ddFromFile = "";
		String fnFromFile = "";
		String genFromFile = "";
		
		//if(driver.findElement(text) != null)	
		String dd = "00";
		String mm = "00";
		String aaaa = "0000";
		String nac = "ZACATECAS";
		String añocurrent = "";
		//int añoDeseado = 1996;
		//1 Mujer 0 Hombre
		int genderM = 1;
		int genderH = 0;
		int current = 0;
		
		String line = "";
		String splitBy= ",";
		int numFilas = 0;
		
		String msg = "Hp_"; 
		
		Scanner sc = new Scanner(new File("C:\\Users\\envaldez\\Documents\\sinubeT\\fullData.csv"));

		
		//ArrayList listOfElements = new ArrayList();
		try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\envaldez\\Documents\\sinubeT\\fullData.csv"));
			
			while ((line = br.readLine()) != null) {
				
				driver.navigate().refresh(); //:D
				Thread.sleep(280);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,300)");
				driver.switchTo().frame(1);
				Thread.sleep(2000);
				
				String[] employee = line.split(splitBy);
				// My refactored code
                //System.out.println("Employee [Name=" + employee[0] + ", Fathers Last Name=" + employee[1] + ", Mothers Last Name=" + employee[2] + ", Year Of Birth=" + employee[3] + ", Month Of Birth= " + employee[4] + ", Day Of Birth= " + employee[5] + ", Place Of Birth= " + employee[6] +", Gender= " + employee[7] +"]");
				
				driver.findElement(nInputx).sendKeys(employee[0].toString());
				driver.findElement(apInput);
				System.out.println("Hola! se va a volver a repetir :'");
				System.out.println("\n");
				numFilas ++;
				
				System.out.println("Apellido paterno!\n");
				driver.findElement(apInput).sendKeys(employee[1].toString());
				Thread.sleep(280);
				
				System.out.println("Ahora va el apellido paterno!\n");
				driver.findElement(amInput).sendKeys(employee[2].toString());
				Thread.sleep(280);
				
				añoDeseado = Integer.parseInt(employee[3].toString());
				
				System.out.println("Calendar!\n");
				driver.findElement(calendarIcon).click();
				Thread.sleep(280);
				driver.findElement(calendarAño).click();
				Thread.sleep(280);
				
				añocurrent = driver.findElement(currentAñoLocator).getText();
				int añonc = Integer.parseInt(añocurrent);
				
				//2022         2021 ---- 1996 --        
				for(int i = añonc ; i >= (añoDeseado+1) ; --i  ) {
					driver.findElement(yearWindow).sendKeys(Keys.ARROW_UP);
					Thread.sleep(28);
				}
				driver.findElement(yearWindow).sendKeys(Keys.ENTER);
				Thread.sleep(500);
//---------------------------------------------------------------------------				
				monthFromFile = employee[4].toString();
				By monthLocator = By.xpath("//*[contains(text(), '" + monthFromFile + " ')]  ");

				
				driver.findElement(monthClick).click();
				Thread.sleep(280);
				driver.findElement(monthLocator).click();
				Thread.sleep(280);
//---------------------------------------------------------------------------				
				ddFromFile = employee[5].toString();
				System.out.println(ddFromFile);
				//By ddLocator = By.xpath("//span[contains(text(),' " + ddFromFile +" ')]");
				//div[@class='igx-calendar__body-row ng-star-inserted']//span[contains(text(),' 14 ')]
				By ddLocator = By.xpath("//div[@class='igx-calendar__body-row ng-star-inserted']//span[contains(text(),' "+ ddFromFile +" ')]");
				
				driver.findElement(ddLocator).click();
				
				Thread.sleep(280);
				
//---------------------------------------------------------------------------				
				fnFromFile = employee[6].toString();
				
				System.out.println("Hola desde c6!\n");
				Thread.sleep(280);
				//driver.findElement(pselected).click();
				//Thread.sleep(280);
				driver.findElement(direct).sendKeys(fnFromFile);
				Thread.sleep(280);
				
//---------------------------------------------------------------------------				
				System.out.println("Hola desde c7!\n");
				Thread.sleep(280);
				genFromFile = employee[7].toString();
				
				System.out.print(genFromFile);
				Thread.sleep(280);
				if(genFromFile.equals("Mujer") ) {
					driver.findElement(radioGenderM).click();
					
				}else if (genFromFile.equals("Hombre")) {
					driver.findElement(radioGenderH).click();

				} else {
					System.out.print("No es ninguno, plis try again");
				}
					
				Thread.sleep(280);
				driver.findElement(generateButton).click();	
				
				//Valida que no sea consonante xyz
				
//---------------------------------------------------------------------------	
				String caption = "CURPCorrecto";
				ScreenShot(caption,msg);
				
//---------------------------------------------------------------------------					
				
				Thread.sleep(1000);	
				
			}
			
			System.out.println(numFilas);
			

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("No se encontró el archivo");
		}
		
		
		
		//driver.findElement(nInputx).sendKeys("Edna Nemesis");

		
		//driver.findElement(apInput).sendKeys("Rosales");
		//Thread.sleep(500);
		
		//driver.findElement(amInput).sendKeys("Valdez");
		//Thread.sleep(500);
		
		//driver.findElement(calendarIcon).click();
		//Thread.sleep(500);
		
		/*
		driver.findElement(writeCalendar).click();
		Thread.sleep(2000);
		//Validaciones fecha de nacimiento
		//Rangos en dias(dependiendo el mes)
		
		//Mes hasta 12
		
		//Año no es menor que 19xx
		driver.findElement(writeCalendar).sendKeys(dd);
		Thread.sleep(2000);
		driver.findElement(writeCalendar).sendKeys(mm);
		Thread.sleep(2000);
		driver.findElement(writeCalendar).sendKeys(aaaa);
		Thread.sleep(2000);
		
		*/
		
		/*
		driver.findElement(calendarAño).click();
		Thread.sleep(500);
		driver.findElement(dayLocator).click();
		Thread.sleep(500);
		driver.findElement(calendarAño).click();
		Thread.sleep(500);
		driver.findElement(monthClick).click();
		Thread.sleep(500);
		driver.findElement(monthLocator).click();
		Thread.sleep(500);
		*/

	/*	
		añocurrent = driver.findElement(currentAñoLocator).getText();
		int añonc = Integer.parseInt(añocurrent);
		//2022         2021 ---- 1996 --        
		for(int i = añonc ; i >= (añoDeseado+1) ; --i  ) {
			driver.findElement(yearWindow).sendKeys(Keys.ARROW_UP);
			Thread.sleep(28);
		}

		//****
		driver.findElement(yearWindow).sendKeys(Keys.ENTER);
		Thread.sleep(500);
	*/		
		/*
		driver.findElement(monthClick).click();
		Thread.sleep(500);
		driver.findElement(monthLocator).click();
		Thread.sleep(500);
*/
		/*
		driver.findElement(By.xpath("//span[contains(text(),' " + dd +" ')]")).click();
		Thread.sleep(500);
		*/
		
		//driver.findElement(calendarIcon).click();
				
		//-----------------------------------------------------
		/*
		Thread.sleep(500);
		driver.findElement(lnacimiento).click();
		Thread.sleep(500);
		driver.findElement(lnacimiento).sendKeys(nac);
		Thread.sleep(500);
		driver.findElement(lnacimiento).sendKeys(Keys.ENTER);
		Thread.sleep(500);
		*/
		//driver.findElement(lnacimiento).click();
		//-----------------------------------------------------ingresar fecha de nacimiento
/*
		
		driver.findElement(pl).click();
		Thread.sleep(2000);
		
		driver.findElement(pl).click();
		Thread.sleep(2000);
	*/	
		
/*		sendKeysToElement("p4ss", passC);
		sendKeysToElement("p4ss", pass2C);
		click(enviar);

		
		
	*/	
		/*
		//click radio if string es mujer/ hombre
		driver.findElement(radioGenderM).click();
		
		driver.findElement(generateButton).click();	
		*/
		

	/*	
		try {
			String Curp = driver.findElement(CURPGenerated).getAttribute("value");
			System.out.println("Curp: " + Curp);
			
			String RFC = driver.findElement(RFCGenerated).getAttribute("value");
			System.out.println("RFC: " + RFC);
			
			File file = new File(rutaArchivo);
			BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile(), true));
			bw.newLine();
			bw.append(Curp);
			bw.newLine();
			bw.append(RFC);
			bw.newLine();
			bw.write("misterio resuelto :D");
			System.out.println("información agregada!");
			bw.flush(); //just makes sure that any buffered data is written to disk
			bw.close(); //flushes the data and indicates that there isn't any more data.
			
			//Condicion, si la info ya está escrita(primero la lee y compara strings)
			//entonces ya no la vuelve a escribir
			
		}catch(Exception e) {
			e.printStackTrace();
		}
*/		
		Thread.sleep(280);
		
		
	

}

@Test
	public void testWrongData() throws InterruptedException, FileNotFoundException {
	int añoDeseado = 0;
	String monthFromFile = "";
	String ddFromFile = "";
	String fnFromFile = "";
	String genFromFile = "";
	
	//if(driver.findElement(text) != null)	
	String dd = "00";
	String mm = "00";
	String aaaa = "0000";
	String nac = "ZACATECAS";
	String añocurrent = "";
	//int añoDeseado = 1996;
	//1 Mujer 0 Hombre
	int genderM = 1;
	int genderH = 0;
	int current = 0;
	
	String line = "";
	String splitBy= ",";
	int numFilas = 0;
	
		
		Scanner sc = new Scanner(new File("C:\\Users\\envaldez\\Documents\\sinubeT\\wrongFullData.csv"));

		try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\envaldez\\Documents\\sinubeT\\wrongFullData.csv"));
			
			while ((line = br.readLine()) != null) {
				
				driver.navigate().refresh(); //:D
				Thread.sleep(280);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,300)");
				driver.switchTo().frame(1);
				Thread.sleep(2000);
				
				String[] employee = line.split(splitBy);
				// My refactored code
                //System.out.println("Employee [Name=" + employee[0] + ", Fathers Last Name=" + employee[1] + ", Mothers Last Name=" + employee[2] + ", Year Of Birth=" + employee[3] + ", Month Of Birth= " + employee[4] + ", Day Of Birth= " + employee[5] + ", Place Of Birth= " + employee[6] +", Gender= " + employee[7] +"]");
				
				driver.findElement(nInputx).sendKeys(employee[0].toString());
				driver.findElement(apInput);
				System.out.println("Hola! se va a volver a repetir :'");
				System.out.println("\n");
				numFilas ++;
				
				System.out.println("Apellido paterno!\n");
				driver.findElement(apInput).sendKeys(employee[1].toString());
				Thread.sleep(280);
				
				System.out.println("Ahora va el apellido paterno!\n");
				driver.findElement(amInput).sendKeys(employee[2].toString());
				Thread.sleep(280);
				
				String añoFromFile = employee[3].toString() ;
				añoDeseado = Integer.parseInt(añoFromFile);
				
				System.out.println("Calendar!\n");
				driver.findElement(calendarIcon).click();
				Thread.sleep(280);
				driver.findElement(calendarAño).click();
				Thread.sleep(280);
				
				añocurrent = driver.findElement(currentAñoLocator).getText();
				int añonc = Integer.parseInt(añocurrent);
				
				//2022         2021 ---- 1996 --        
				for(int i = añonc ; i >= (añoDeseado+1) ; --i  ) {
					driver.findElement(yearWindow).sendKeys(Keys.ARROW_UP);
					Thread.sleep(28);
				}
				driver.findElement(yearWindow).sendKeys(Keys.ENTER);
				Thread.sleep(500);
//---------------------------------------------------------------------------				
				monthFromFile = employee[4].toString();
				By monthLocator = By.xpath("//*[contains(text(), '" + monthFromFile + " ')]  ");

				

//---------------------------------------------------------------------------				
				ddFromFile = employee[5].toString();
				int ddFromFileDeseado = Integer.parseInt(ddFromFile);
				System.out.println(ddFromFile);
				//By ddLocator = By.xpath("//span[contains(text(),' " + ddFromFile +" ')]");
				//div[@class='igx-calendar__body-row ng-star-inserted']//span[contains(text(),' 14 ')]

//--------------------------------------------------------------------------
				// añoDeseado ddFromFileDeseado monthFromFile
				
				int nb1 = 100;
		        int nb2 = 400;
		        int nb3 = 4;
		        //2024
		        //int yFromFile = 2020;
		        //int day = 29;
		        //String month = "Feb";
		        int yDate = getDateYear();
		        
		        if( ((monthFromFile.equals("Ene")) || (monthFromFile.equals("Mar")) || (monthFromFile.equals("May")) || (monthFromFile.equals("Jul")) || (monthFromFile.equals("Ago")) || (monthFromFile.equals("Oct")) || (monthFromFile.equals("Dic")) ) & (ddFromFileDeseado == 31) & ((añoDeseado > 1 ) & (añoDeseado <= yDate ) & (añoDeseado >= (yDate - 120 )) ) ){
		            System.out.println("Día y mes correctos segun calendario");
					By ddLocator = By.xpath("//div[@class='igx-calendar__body-row ng-star-inserted']//span[contains(text(),' "+ ddFromFile +" ')]");
					
					driver.findElement(monthClick).click();
					Thread.sleep(280);
					driver.findElement(monthLocator).click();
					Thread.sleep(280);
					
					driver.findElement(ddLocator).click();
					
					Thread.sleep(280);
					
		        } else if ( ( (monthFromFile.equals("Abr")) || (monthFromFile.equals("Jun")) || (monthFromFile.equals("Sept")) || (monthFromFile.equals("Nov")) ) & (ddFromFileDeseado == 30) & (ddFromFileDeseado == 31) & ((añoDeseado > 1 ) & (añoDeseado <= yDate ) & (añoDeseado >= (yDate - 120 )) )) {
		            System.out.println("Día y mes correctos segun calendario");
					By ddLocator = By.xpath("//div[@class='igx-calendar__body-row ng-star-inserted']//span[contains(text(),' "+ ddFromFile +" ')]");
					
					driver.findElement(monthClick).click();
					Thread.sleep(280);
					driver.findElement(monthLocator).click();
					Thread.sleep(280);
					
					driver.findElement(ddLocator).click();
					
					Thread.sleep(280);

		        } else if ( ( (monthFromFile.equals("Feb")) ) & (ddFromFileDeseado == 28) & (ddFromFileDeseado == 31) & ((añoDeseado > 1 ) & (añoDeseado <= yDate ) & (añoDeseado >= (yDate - 120 )) )) {
		            System.out.println("Día y mes correctos segun calendario");
					By ddLocator = By.xpath("//div[@class='igx-calendar__body-row ng-star-inserted']//span[contains(text(),' "+ ddFromFile +" ')]");
					
					driver.findElement(monthClick).click();
					Thread.sleep(280);
					driver.findElement(monthLocator).click();
					Thread.sleep(280);
					
					driver.findElement(ddLocator).click();
					
					Thread.sleep(280);
		       
		        } else if ((ddFromFileDeseado == 29) & (monthFromFile.equals("Feb")) & (((añoDeseado % nb1 ) == 0) || ((añoDeseado % nb2 ) == 0) || ((añoDeseado % nb3 ) == 0)) & ((añoDeseado > 1 ) & (añoDeseado <= yDate ) & (añoDeseado >= (yDate - 120 )) ) ){
		            System.out.println("Es un año bisciesto, la fecha es correcta c:");
		            //Se sigue con el programa
					driver.findElement(writeCalendar).click();
					Thread.sleep(280);
					driver.findElement(writeCalendar).sendKeys(ddFromFile);
					Thread.sleep(280);
					driver.findElement(writeCalendar).sendKeys(monthFromFile);
					Thread.sleep(280);
					driver.findElement(writeCalendar).sendKeys(añoFromFile);

					Thread.sleep(280);
					
		        } else if ((ddFromFileDeseado > 1) || (ddFromFileDeseado < 31) & (añoDeseado >= (yDate - 120 ))  ){
		            System.out.println("Nuestros ancestros ...");
		            //Mandar a llamar Screenshot(String msg = Fecha ingresada inválida) --- para que la imprima en la captura de pantalla

		            //*******++++
		            //Activar una bandera(booblean false or true)

		            //***********
					driver.findElement(writeCalendar).click();
					Thread.sleep(280);
					driver.findElement(writeCalendar).sendKeys(dd);
					Thread.sleep(280);
					driver.findElement(writeCalendar).sendKeys(mm);
					Thread.sleep(280);
					driver.findElement(writeCalendar).sendKeys(aaaa);
					
		        } else if (añoDeseado > yDate) {
		            System.out.println("Bienvenido viajero del futuro, no podemos asignarte CURP c:");
		            String msg = "Viajero del futuro";
		            
					driver.findElement(writeCalendar).click();
					Thread.sleep(280);
					driver.findElement(writeCalendar).sendKeys(dd);
					Thread.sleep(280);
					driver.findElement(writeCalendar).sendKeys(mm);
					Thread.sleep(280);
					driver.findElement(writeCalendar).sendKeys(aaaa);

		        } else {
		            System.out.println("No es una fecha válida");
		            System.out.println("Algo pasó pero meteremos la fecha");
					By ddLocator = By.xpath("//div[@class='igx-calendar__body-row ng-star-inserted']//span[contains(text(),' "+ ddFromFile +" ')]");
					
					driver.findElement(monthClick).click();
					Thread.sleep(280);
					driver.findElement(monthLocator).click();
					Thread.sleep(280);
					
					driver.findElement(ddLocator).click();
					
					Thread.sleep(280);

		        }
				
				
				
//---------------------------------------------------------------------------				
				fnFromFile = employee[6].toString();
				
				System.out.println("Hola desde c6!\n");
				Thread.sleep(280);
				//driver.findElement(pselected).click();
				//Thread.sleep(280);
				driver.findElement(direct).sendKeys(fnFromFile);
				Thread.sleep(280);
				
//---------------------------------------------------------------------------				
				System.out.println("Hola desde c7!\n");
				Thread.sleep(280);
				genFromFile = employee[7].toString();
				
				System.out.print(genFromFile);
				Thread.sleep(280);
				if(genFromFile.equals("Mujer") ) {
					driver.findElement(radioGenderM).click();
					
				}else if (genFromFile.equals("Hombre")) {
					driver.findElement(radioGenderH).click();

				} else {
					System.out.print("No es ninguno, plis try again");
				}
					
				Thread.sleep(280);
				driver.findElement(generateButton).click();	
				Thread.sleep(350);
//---------------------------------------------------------------------------		
				String caption = "Empty_";
										
//---------------------------------------------------------------------------
				
				String msgErrorSinube = "";
				String splitByEsp= " ";
				String newShortMsg = "";
				
				By errorMsg = By.xpath("//div[@class='igx-dialog__window-content ng-star-inserted']");
				Thread.sleep(280);
				By okEClose = By.xpath("//button[@type = 'button'][contains(text(), 'OK')]");
				Thread.sleep(280);
				
				if(driver.findElement(errorMsg).isDisplayed()) {
					Thread.sleep(280);
					msgErrorSinube= driver.findElement(errorMsg).getText();
					
					String[] msgError = msgErrorSinube.split(splitByEsp);
					int size = msgError.length;
					
					//concatenarString
					for (int i = 9; i <= size-2 ; i++ ) {
						
						 newShortMsg= newShortMsg.concat(msgError[i]+"_");
						
					}
					
					ScreenShot(caption, newShortMsg);
					
					System.out.println(msgError);
				}else {
					System.out.println("No se encuentra el elemento :) , el test salió bien");
				}
				
				
				if(driver.findElement(okEClose).isDisplayed()) {
					Thread.sleep(280);
					driver.findElement(okEClose).click();
				}else {
					System.out.println("No se encuentra el elemento :) , el test salió bien");
				}
				
				
			
//---------------------------------------------------------------------------					
				
				Thread.sleep(1000);	
				
			}
			
			System.out.println(numFilas);
			

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("No se encontró el archivo");
		}
			
		Thread.sleep(280);
}	

	public String getDate() {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy mm-ss");
		return dateFormat.format(new Date() );
	}
	
	public String getDateDay() {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy");
		return dateFormat.format(new Date() );
	}
	
	public int getDateYear() {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		return Integer.parseInt(dateFormat.format(new Date()));
	}

	public String getDateTime() {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH-mm-ss");
		return dateFormat.format(new Date() );
	}


	public void ScreenShot(String caption, String msgError) throws InterruptedException {
		//exist raiz directory path
		//dia de hoy
		//lo tomo como ruta relativa
		
		/*
		String directoryTodaysName = "_Date_"+ getDateDay() + "\\" ;
        String picFile = caption + "_" + msgError + "_" + getDateTime() + ".png" ;

        String existRDPath = "C:\\Users\\envaldez\\Documents\\si nubeT\\Evidencias\\";
        String notExistRDPath = "";
        String existDPath = "C:\\Users\\envaldez\\Documents\\sinubeT\\Evidencias" + directoryTodaysName;
        String notExistDPath = "C:\\Users\\envaldez\\Documents\\sinubeT\\Evidencias" +"Date"+ getDateYear();
        
        File raiz = new File(existRDPath);
        File cPerDay = new File(existDPath);
        
        //if ! x carpeta & x archivo Existen   entonces
        if((!raiz.exists()) & (!cPerDay.exists()) ){
        	System.out.print("\n No existen los directorios");
        	
        	File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    		try {
    			Thread.sleep(1000);
    			FileUtils .copyFile(screenshotFile, new File(existDPath + picFile ));
    			
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		Timeouts implicitlyWait = driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    		System.out.println("ScreenShot Tomada\n");

        }else if((raiz.exists()) & (cPerDay.exists()) ) {
        	File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    		try {
    			Thread.sleep(1000);
    			FileUtils .copyFile(screenshotFile, new File("/Evidencias" + directoryTodaysName , picFile ));
    			
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		Timeouts implicitlyWait = driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    		System.out.println("ScreenShot Tomada\n");
        	
        }
            //Crealos porfas(osea que les paso el path)

        //sino, en el path existente creo los x archivos

		*/
		String directoryTodaysName = "Screenshots_Date_"+ getDateDay()  ;
        String picFile = caption  + msgError  + getDateTime() + ".png" ;
        String raizCarpetas = "C:\\Users\\envaldez\\Documents\\sinubeT\\Evidencias\\" + directoryTodaysName ;

        
		
		//String picFile = caption  + "_" + getDateTime() + ".png" ;
		Thread.sleep(1000);

		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Thread.sleep(1000);
		//hi

		try {
			Thread.sleep(1000);
			FileUtils .copyFile(screenshotFile, new File(raizCarpetas , picFile ));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Timeouts implicitlyWait = driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("\n ScreenShot Tomada\n");
		System.out.println("\n" + msgError);
//hi
	} 

	
	
	public void dataErrorButtonMessage() {
		/*By okEClose = By.xpath("//button[@type = 'button'][contains(text(), 'OK')]");
		if(driver.findElement(okEClose).isDisplayed()) {
			driver.findElement(okEClose).click();
		}
		*/
	}
/*	
	public String checkInput(int data) {
		
		return True;
	}
*/	
	

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(500);
		driver.close();
	}
}
