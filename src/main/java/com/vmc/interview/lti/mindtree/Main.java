package com.vmc.interview.lti.mindtree;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
	public static void main(String[] args) {
        SubClass original = new SubClass("SuperDataValue A", "SubDataValue B");

        // Serialize the object
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("subclass.ser"))) {
            oos.writeObject(original);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize the object
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("subclass.ser"))) {
            SubClass deserialized = (SubClass) ois.readObject();
            System.out.println("Deserialized Object: " + deserialized);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
	
}


/*
Deserialized Object: SuperClass Data: SuperDataValue, SubClass Data: SubDataValue

Explanation

Superclass SuperClass:
Does not implement Serializable.
Provides a String field (superData).

Subclass SubClass:
Implements Externalizable.
Overrides writeExternal() and readExternal() methods for custom serialization.

Manually handles the serialization/deserialization of superData.

Key Points

Custom Serialization: Since SuperClass is not serializable, writeExternal() and readExternal() must manually serialize and deserialize superData.
Default Constructor: SuperClass must have a no-argument constructor for the deserialization process to work properly.
Control of Serialization: Externalizable provides complete control over the serialization process, making it possible to handle non-serializable fields explicitly.

*/