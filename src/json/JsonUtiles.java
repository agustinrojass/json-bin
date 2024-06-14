package json;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONArray;
import org.json.JSONObject;
/**
 * La clase {@code JsonUtiles} permite el manejo de archivos .json, tanto para la escritura como para la lectura.
 * @author Agustin Rojas
 */
public class JsonUtiles {
    /**
     * {@link #grabar grabar()} recibe un jsonarray y el nombre de un archivo.
     * <p>Guarda el jsonarray en un archivo .json.
     */
    public static void grabar(JSONArray ja, String archivo) {
        try {
            FileWriter file = new FileWriter("json\\" + archivo + ".json");
            file.write(ja.toString());
            file.flush();
            file.close();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * {@link #grabar grabar()} recibe un jsonobject y el nombre de un archivo.
     * <p>Guarda el jsonobject en un archivo .json.
     */
    public static void grabar(JSONObject jo, String archivo) {
        try {
            FileWriter file = new FileWriter("json\\" + archivo + ".json");
            file.write(jo.toString());
            file.flush();
            file.close();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * {@link #leer leer()} recibe el nombre de un archivo, y retorna un string.
     * <p>Descarga un string con formato json desde un archivo .json.
     */
    public static String leer(String archivo) {
        String contenido = "";
        try {
            contenido = new String(Files.readAllBytes(Paths.get("json\\" + archivo + ".json")));
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        return contenido;
    }
}