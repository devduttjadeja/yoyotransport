package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.OutputStream;
import java.io.Serializable;

public class Singleton_With_Serialization implements Serializable {

	private static final long serialVersionUID = 1L;

	private static Singleton_With_Serialization INSTANCE = null;

	// constructor
	private Singleton_With_Serialization() {
		System.out.println(" inside constructor object created...");
	}

	// method returns instance of Singleton class.
	public static Singleton_With_Serialization getInstance() {
		if (INSTANCE == null) {
			synchronized (Singleton_With_Serialization.class) {
				INSTANCE = new Singleton_With_Serialization();
			}
		}
		return INSTANCE;
	}

	/**
	 * customize Serialization process.
	 */
	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		System.out.println("in readObject()");
		ois.defaultReadObject();
		synchronized (Singleton_With_Serialization.class) {
			if (INSTANCE == null) {
				INSTANCE = this;
			}
		}
	}

	/**
	 * Method ensures that we don't break singleton pattern during DeSerialization
	 * process- method must not be called other than DeSerialization time.
	 */
	private Object readResolve() throws ObjectStreamException {
		System.out.println("in readResolve()");
		return INSTANCE;
	}

	public static void main(String[] args) throws Throwable {
		System.out.println("Are objects same before serialization : " + (getInstance() == getInstance()));

		OutputStream fout = new FileOutputStream("ser.txt");
		ObjectOutput oout = new ObjectOutputStream(fout);
		System.out.println("Serialization process has started...");
		oout.writeObject(getInstance());
		fout.close();
		oout.close();
		System.out.println("Object Serialization completed.");

		// DeSerialization process >>>>>>>.

		InputStream fin = new FileInputStream("ser.txt");
		ObjectInput oin = new ObjectInputStream(fin);
		System.out.println("\nDeSerialization process has started...");
		Singleton_With_Serialization deSerializedObj = (Singleton_With_Serialization) oin.readObject();
		fin.close();
		oin.close();
		System.out.println("Object DeSerialization completed.");
		System.out.println("Are objects same after serialization : " + (deSerializedObj == getInstance()));

	}

}
