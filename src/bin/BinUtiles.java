package bin;
import java.io.*;
import java.util.ArrayList;
/**
 * La clase {@code BinUtiles} permite el manejo de archivos .bin, tanto para la escritura como para la lectura.
 * @author Agustin Rojas
 */
public class BinUtiles {
    /**
     * {@link #objectToBin objectToBin()} recibe un objeto y el nombre de un archivo.
     * <p>Guarda el objeto en un archivo .bin.
     */
    public static void objectToBin(Object aux, String archivo) { //cambiar el parametro por la clase que corresponda al archivo
        ObjectOutputStream objectOutputStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("bin\\" + archivo + ".bin");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(aux);
        }
        catch(FileNotFoundException ex) {
            System.out.println("FileNotFoundException: " + ex.getMessage());
        }
        catch(IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        }
        finally {
            try {
                assert objectOutputStream != null;
                objectOutputStream.close();
            }
            catch(IOException ex) {
                System.out.println("IOException: " + ex.getMessage());
            }
        }
    }
    /**
     * {@link #intsToBin intsToBin()} recibe un arraylist de enteros y el nombre de un archivo.
     * <p>Guarda los valores del arraylist en un archivo .bin.
     */
    public static void intsToBin(ArrayList<Integer> aux, String archivo) { //cambiar el parametro del arraylist por la clase que corresponda al archivo
        DataOutputStream dataOutputStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("bin\\" + archivo + ".bin");
            dataOutputStream = new DataOutputStream(fileOutputStream);
            for(int i : aux) {
                dataOutputStream.writeInt(i); //cambiar el write por el tipo de dato que corresponda
            }
        }
        catch(FileNotFoundException ex) {
            System.out.println("FileNotFoundException: " + ex.getMessage());
        }
        catch(IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        }
        finally {
            try {
                assert dataOutputStream != null;
                dataOutputStream.close();
            }
            catch(IOException ex) {
                System.out.println("IOException: " + ex.getMessage());
            }
        }
    }
    /**
     * {@link #stringsToBin stringsToBin()} recibe un arraylist de strings y el nombre de un archivo.
     * <p>Guarda los valores del arraylist en un archivo .bin.
     */
    public static void stringsToBin(ArrayList<String> aux, String archivo) { //cambiar el parametro del arraylist por la clase que corresponda al archivo
        DataOutputStream dataOutputStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("bin\\" + archivo + ".bin");
            dataOutputStream = new DataOutputStream(fileOutputStream);
            for(String s : aux) {
                dataOutputStream.writeUTF(s); //cambiar el write por el tipo de dato que corresponda
            }
        }
        catch(FileNotFoundException ex) {
            System.out.println("FileNotFoundException: " + ex.getMessage());
        }
        catch(IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        }
        finally {
            try {
                assert dataOutputStream != null;
                dataOutputStream.close();
            }
            catch(IOException ex) {
                System.out.println("IOException: " + ex.getMessage());
            }
        }
    }
    /**
     * {@link #binToObject binToObject()} recibe el nombre de un archivo, y retorna un objeto.
     * <p>Descarga un objeto desde un archivo .bin.
     */
    public static Object binToObject(String archivo) { //cambiar el return por la clase que corresponda al archivo
        Object aux = null; //cambiar por la clase que corresponda al archivo
        ObjectInputStream objectInputStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("bin\\" + archivo + ".bin");
            objectInputStream = new ObjectInputStream(fileInputStream);
            aux = (Object) objectInputStream.readObject(); //cambiar el casteo por la clase que corresponda al archivo
        }
        catch(FileNotFoundException ex) {
            System.out.println("FileNotFoundException: " + ex.getMessage());
        }
        catch(IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        }
        catch(ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException: " + ex.getMessage());
        }
        finally {
            try {
                assert objectInputStream != null;
                objectInputStream.close();
            }
            catch(IOException ex) {
                System.out.println("IOException: " + ex.getMessage());
            }
        }
        return aux;
    }
    /**
     * {@link #binToInts binToInts()} recibe el nombre de un archivo, y retorna un arraylist de enteros.
     * <p>Descarga enteros desde un archivo .bin y los guarda en un arraylist.
     */
    public static ArrayList<Integer> binToInts(String archivo) { //cambiar el parametro del arraylist del return por la clase que corresponda al archivo
        ArrayList<Integer> aux = new ArrayList<>(); //cambiar por la clase que corresponda al archivo
        DataInputStream dataInputStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("bin\\" + archivo + ".bin");
            dataInputStream = new DataInputStream(fileInputStream);
            while(true) {
                aux.add(dataInputStream.readInt()); //cambiar el read por el tipo de dato que corresponda
            }
        }
        catch(EOFException ex) {
            System.out.println();
        }
        catch(FileNotFoundException ex) {
            System.out.println("FileNotFoundException: " + ex.getMessage());
        }
        catch(IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        }
        finally {
            try {
                assert dataInputStream != null;
                dataInputStream.close();
            }
            catch(IOException ex) {
                System.out.println("IOException: " + ex.getMessage());
            }
        }
        return aux;
    }
    /**
     * {@link #binToStrings binToStrings()} recibe el nombre de un archivo, y retorna un arraylist de strings.
     * <p>Descarga strings desde un archivo .bin y los guarda en un arraylist.
     */
    public static ArrayList<String> binToStrings(String archivo) { //cambiar el parametro del arraylist del return por la clase que corresponda al archivo
        ArrayList<String> aux = new ArrayList<>(); //cambiar por la clase que corresponda al archivo
        DataInputStream dataInputStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("bin\\" + archivo + ".bin");
            dataInputStream = new DataInputStream(fileInputStream);
            while(true) {
                aux.add(dataInputStream.readUTF()); //cambiar el read por el tipo de dato que corresponda
            }
        }
        catch(EOFException ex) {
            System.out.println();
        }
        catch(FileNotFoundException ex) {
            System.out.println("FileNotFoundException: " + ex.getMessage());
        }
        catch(IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        }
        finally {
            try {
                assert dataInputStream != null;
                dataInputStream.close();
            }
            catch(IOException ex) {
                System.out.println("IOException: " + ex.getMessage());
            }
        }
        return aux;
    }
}