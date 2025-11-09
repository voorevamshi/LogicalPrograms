package com.interview.lti.mindtree;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class SubClass extends SuperClass implements Externalizable {
    private String subData;

    public SubClass() {
        super(); // Default constructor
    }

    public SubClass(String superData, String subData) {
        super(superData); // Initialize superclass data
        this.subData = subData;
    }

    public String getSubData() {
        return subData;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        // Write subclass data
        out.writeUTF(subData);

        // Write superclass data manually
        out.writeUTF(getSuperData());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        // Read subclass data
        subData = in.readUTF();
        String superData = in.readUTF();
        // Read superclass data manually
        
        // Manually call the constructor to set superclass data
        // Note: Superclass's constructor is automatically invoked before this
    }

    @Override
    public String toString() {
        return "SuperClass Data: " + getSuperData() + ", SubClass Data: " + subData;
    }
}