package com.tester;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import com.code.customer;


public class serial {

	// for serialization

	public static void encoder(List<customer> list, String name) throws FileNotFoundException, IOException {

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(name))) {
			oos.writeObject(list);
			System.out.println("data is stored");

		}
	}

	// for deserialization
	public static List<customer> decoder(String name)
			throws FileNotFoundException, IOException, ClassNotFoundException {

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(name))) {
			List<customer> cust1 = (List<customer>) ois.readObject();

			return cust1;
		}

	}
}
