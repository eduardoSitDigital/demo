package com.sit.digital.demo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.opencsv.CSVReader;
import com.sit.digital.demo.person.Gender;
import com.sit.digital.demo.person.Person;

/*
 * programa para leer un archivo .csv y generar un archivo txt
 */
public class App {
	private final static Logger LOGGER = Logger.getLogger(App.class);

	public static void main(String[] args) {

		try {
			
			//fix 1
			//fix 2

			Reader reader = Files.newBufferedReader(Paths.get(ClassLoader.getSystemResource("csv/input.csv").toURI()));

			CSVReader csvReader = new CSVReader(reader);
			List<String[]> list = new ArrayList<String[]>();
			list = csvReader.readAll();
			reader.close();
			csvReader.close();

			List<Person> personList = getPersonList(list);
			JSONObject jo;

			try {
				FileWriter myWriter = new FileWriter("output_file.txt");

				for (Person person : personList) {
					jo = new JSONObject(person);
					myWriter.write(jo.toString());
				}

				myWriter.close();
				
				LOGGER.info("Successfully wrote to the file.");
			} catch (IOException ex) {
				LOGGER.error("An error occurred.", ex);

			}

		} catch (Exception ex) {
			LOGGER.error("ERROR", ex);
		}

	}

	private static List<Person> getPersonList(List<String[]> list) {

		List<Person> personList = new ArrayList<Person>();

		Person person;

		for (String[] element : list) {
			person = new Person();
			person.setName(clean(element[0]));
			person.setFirstName(clean(element[1]));
			person.setSecondName(clean(element[2]));
			person.setAge(Integer.parseInt(clean(element[3])));
			person.setGender(Gender.valuOfLabel(clean(element[4])));

			LOGGER.debug(person.toString());

			personList.add(person);

		}
		return personList;
	}

	private static String clean(String data) {
		return data.replace("\t", "").replace(" ", "").toUpperCase();
	}
}
