package org.nuclei.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class DeserializeData<T> {

    public List<T> deserializeData( String filename ) throws IOException, ClassNotFoundException {

        FileInputStream file = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(file);

        List<T> obj = (List<T>) in.readObject();
        in.close();
        file.close();
        return obj;

    }

}
