package org.example;

import java.io.*;

/**
 * Provides methods for serializing and deserializing objects to and from files
 * for persistent storage.
 */
public final class SerializationManager {
    /**
     * Serializes an object and writes it to a file.
     * @param obj the object to be written
     * @param fileName the path to the file to write to
     */
    public static void write(Object obj, String fileName) throws IOException {
        // try-with-resources statement closes resources upon completion
        // https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
        try (FileOutputStream   fileOutput   = new FileOutputStream(fileName);
             ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput)) {

            objectOutput.writeObject(obj);
        }
    }

    /**
     * Reads ano object and  deserializes it.
     * @return the deserialized object
     * @param fileName the path to the file to read from
     */
    public static Object read(String fileName) throws IOException, ClassNotFoundException {
        try (FileInputStream   fileInput   = new FileInputStream(fileName);
             ObjectInputStream objectInput = new ObjectInputStream(fileInput)) {

            return objectInput.readObject();
        }
    }
}
