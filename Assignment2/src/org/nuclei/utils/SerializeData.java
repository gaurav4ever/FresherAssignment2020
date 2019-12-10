package org.nuclei.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class SerializeData<T> {

    public void serializeData(List<T> objectList, String filename) throws IOException {

        FileOutputStream file = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(objectList);
        out.close();
        file.close();

    }

}
