package pl.com.aay.testData.dataReaders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.google.gson.Gson;

import pl.com.aay.testData.model.Login;
import pl.com.aay.testData.model.Registration;


import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.snakeyaml.Yaml;

public class TestDataReader {
	
	public static final String pathToTestData = "./src/test/resources/pl/com/aay/test_data/";
	public static final String propertiesName="aplication.properties";
	public static final String json1Name="registration1.json";
	public static final String json2Name="registration2.json";
	public static final String excelName="registration.xlsx";
	public static final String xmlName="registration.xml";
	public static final String yamlName="Login.yaml";
	
	public TestDataReader (){
		
	}
	
	public Login readLoginDataFromPoperties (){
		Login login = new Login ();
		
		try (InputStream input = new FileInputStream(pathToTestData+propertiesName)) {

            Properties prop = new Properties();
            prop.load(input);

            login.setUrl(prop.getProperty("url"));
            login.setLogin(prop.getProperty("login"));
            login.setPassword(prop.getProperty("password"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
		
		return login;
	}
	
	public Login readLoginDataFromYaml (){
		Login login=null;

		
		File file = new File(pathToTestData+yamlName); 
		System.out.println(pathToTestData+yamlName) ; 
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} 
		  
		String s = null;
		StringBuilder yamlBuilder = new StringBuilder();
		try {
			while ((s = br.readLine()) != null) {
				yamlBuilder.append(s).append("\n"); 
			}
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
		System.out.println(yamlBuilder.toString());
		
		Yaml yaml = new Yaml(); 
		login = yaml.loadAs(yamlBuilder.toString(),Login.class);
		
		return login;
	}
	
	public Registration readDataFromJsonGson (){
		Gson gson = new Gson();
		Registration registration = null;
		
		try {
			registration = gson.fromJson(new FileReader(pathToTestData+json1Name), Registration.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		
		return registration;
	}
	
	public Registration readDataFromJsonJackson (){
		Registration registration = new Registration ();
		
		File file = new File(pathToTestData+json2Name); 
		  
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} 
		  
		String s;
		StringBuilder jsonBuilder = new StringBuilder();
		try {
			while ((s = br.readLine()) != null) {
				jsonBuilder.append(s).append("\n"); 
			}
		} catch (IOException e2) {
			e2.printStackTrace();
		} 
	    
	    JsonNode rootNode = null;
	    
		ObjectMapper mapper = new ObjectMapper();
		try {
			rootNode = mapper.readTree(jsonBuilder.toString());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		registration.firstName = rootNode.findValue("firstName").asText();
		registration.lastName = rootNode.findValue("lastName").asText();
		registration.maritalStatus = rootNode.findValue("maritalStatus").asText();
		registration.hobby = rootNode.findValue("hobby").asText();
		registration.country = rootNode.findValue("country").asText();
		registration.month = rootNode.findValue("month").asText();
		registration.day = rootNode.findValue("day").asText();
		registration.year = rootNode.findValue("year").asText();
		registration.phoneNumber = rootNode.findValue("phoneNumber").asText();
		registration.userName = rootNode.findValue("userName").asText();
		registration.email = rootNode.findValue("email").asText();
		registration.about = rootNode.findValue("about").asText();
		registration.password = rootNode.findValue("password").asText();
		registration.confirmPassword = rootNode.findValue("confirmPassword").asText();

		return registration;
	}
	
	public Registration readDataFromExcel (){
		Registration registration = new Registration ();
		
		try {

            FileInputStream excel = new FileInputStream(new File(pathToTestData+excelName));
            Workbook workbook = new XSSFWorkbook(excel);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> iteratorSheet = sheet.iterator();

            while (iteratorSheet.hasNext()) {

                Row currentRow = iteratorSheet.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                String name = currentRow.getCell(0).getStringCellValue();
                String value = currentRow.getCell(1).getStringCellValue();
                switch(name) { 
	                case "first name": 
	                	registration.firstName=value; 
	                    break; 
	                case "last name": 
	                	registration.lastName=value;                        
	                	break; 
	                case "marital status": 
	                	registration.maritalStatus=value;                        
	                	break; 
	                case "hobby": 
	                	registration.hobby=value;                        
	                	break;
	                case "country": 
	                	registration.country=value;                        
	                	break;
	                case "month": 
	                	registration.month=value;                        
	                	break;
	                case "day": 
	                	registration.day=value;                        
	                	break;
	                case "year": 
	                	registration.year=value;                        
	                	break;
	                case "phone number": 
	                	registration.phoneNumber=value;                        
	                	break;
	                case "user name": 
	                	registration.userName=value;                        
	                	break;
	                case "email": 
	                	registration.email=value;                        
	                	break;
	                case "about": 
	                	registration.about=value;                        
	                	break;
	                case "password": 
	                	registration.password=value;                        
	                	break;
	                case "confirm password": 
	                	registration.confirmPassword=value;                        
	                	break;
	                default: 
	                    System.out.println("no match");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return registration;
	}
	
	public Registration readDataFromXML (){
		Registration registration = new Registration ();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		Document document = null;
		try {
			builder = factory.newDocumentBuilder();
			document = builder.parse(new File(pathToTestData+xmlName));
		} 
		catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}		 
		document.getDocumentElement().normalize();
		
		Element root = document.getDocumentElement();
		registration.firstName=root.getElementsByTagName("first_name").item(0).getTextContent();
		registration.lastName=root.getElementsByTagName("last_name").item(0).getTextContent();
		registration.maritalStatus=root.getElementsByTagName("marital_status").item(0).getTextContent();
		registration.hobby=root.getElementsByTagName("hobby").item(0).getTextContent();
		registration.country=root.getElementsByTagName("country").item(0).getTextContent();
		registration.month=root.getElementsByTagName("month").item(0).getTextContent();
		registration.day=root.getElementsByTagName("day").item(0).getTextContent();
		registration.year=root.getElementsByTagName("year").item(0).getTextContent();
		registration.phoneNumber=root.getElementsByTagName("phone_number").item(0).getTextContent();
		registration.userName=root.getElementsByTagName("user_name").item(0).getTextContent();
		registration.email=root.getElementsByTagName("email").item(0).getTextContent();
		registration.about=root.getElementsByTagName("about").item(0).getTextContent();
		registration.password=root.getElementsByTagName("password").item(0).getTextContent();
		registration.confirmPassword=root.getElementsByTagName("confirm_password").item(0).getTextContent();

		return registration;
	}
	
	/*
	 * 
	 * Przyk�adowa tabela w bazie danych nazywa�aby si� registration
	 * Posiada�aby ona dwie kolumny: 
	 * Pierwsza kolumna mia�aby nazwe field. Kolumna ta przekchowuje nazwy danych testowyxh 
	 * Drugia kolumna nazwya�aby si� value. Kolumna ta przechowuje warto�ci danych testowych
	 * 
	 */
	public Registration readDataFromDB (){
		
		Registration registration = new Registration ();
		
		try {
            String url = "jdbc:msql://1270.0.0.1:1114/Registration";
            Connection conn = DriverManager.getConnection(url,"","");
            Statement stmt = conn.createStatement();
            ResultSet rs;
 
            rs = stmt.executeQuery("SELECT * FROM registration");
            while ( rs.next() ) {
                String pole = rs.getString("pole");
                String value = rs.getString("value");
                switch(pole) { 
                    case "firstName": 
                    	registration.firstName=value; 
                        break; 
                    case "lastName": 
                    	registration.lastName=value;                        
                    	break; 
                    case "maritalStatus": 
                    	registration.maritalStatus=value;                        
                    	break; 
                    case "hobby": 
                    	registration.hobby=value;                        
                    	break;
                    case "country": 
                    	registration.country=value;                        
                    	break;
                    case "month": 
                    	registration.month=value;                        
                    	break;
                    case "day": 
                    	registration.day=value;                        
                    	break;
                    case "year": 
                    	registration.year=value;                        
                    	break;
                    case "phoneNumber": 
                    	registration.phoneNumber=value;                        
                    	break;
                    case "userName": 
                    	registration.userName=value;                        
                    	break;
                    case "email": 
                    	registration.email=value;                        
                    	break;
                    case "about": 
                    	registration.about=value;                        
                    	break;
                    case "password": 
                    	registration.password=value;                        
                    	break;
                    case "confirmPassword": 
                    	registration.confirmPassword=value;                        
                    	break;
                    default: 
                        System.out.println("no match"); 
                } 
            }
            conn.close();
        } catch (Exception e) {
            
            System.err.println(e.getMessage());
        }
		
		return registration;
	}

}
