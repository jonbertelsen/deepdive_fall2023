package dat;

import java.io.*;

public class FileStorage<T> implements DataStorage<T>
{
    public FileStorage(String filename)
    {
        this.filename = filename;
    }

    private String filename;

    public void store(T data) {
        saveDataToFile(data);
    }

    public T retrieve() {
        return loadObjectFromFile(filename);
    }

    // Save object to file
    public void saveDataToFile(T data)
    {
        try (final FileOutputStream fout = new FileOutputStream(filename);
             final ObjectOutputStream out = new ObjectOutputStream(fout)) {
            out.writeObject(data);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public T loadObjectFromFile(String fileName)
    {
        try (final FileInputStream fin = new FileInputStream(fileName);
             final ObjectInputStream in = new ObjectInputStream(fin)) {
            return (T) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
