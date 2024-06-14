import bin.BinUtiles;
import json.JsonUtiles;
import org.json.JSONArray;
import org.json.JSONException;
import java.util.ArrayList;
/**
 * La clase {@code Main} testea las funciones de escritura y lectura de .bin y .json.
 * @author Agustin Rojas
 */
public class Main {
    /**
     * {@link #main main()} se encarga de llamar a las funciones que estan mas abajo para testear la escritura y lectura de .bin y .json.
     */
    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<>();
        cargarArregloInt(ints);
        cargarBinInt(ints);
        ArrayList<Integer> intsBin = descargarBinInt();
        System.out.println("Enteros del .bin: " + intsBin);
        cargarJsonInt(ints);
        ArrayList<Integer> intsJson = descargarJsonInt();
        System.out.println("Enteros del .json: " + intsJson);
        ArrayList<String> strings = new ArrayList<>();
        cargarArregloString(strings);
        cargarBinString(strings);
        ArrayList<String> stringsBin = descargarBinString();
        System.out.println("Strings del .bin: " + stringsBin);
        cargarJsonString(strings);
        ArrayList<String> stringsJson = descargarJsonString();
        System.out.println("Strings del .json: " + stringsJson);
    }
    /**
     * {@link #cargarArregloInt(ArrayList) cargarArregloInt()} carga automaticamente un arraylist de enteros.
     */
    private static void cargarArregloInt(ArrayList<Integer> ints) {
        for(int i = 1; i < 6; i++) {
            ints.add(i);
        }
    }
    /**
     * {@link #cargarBinInt(ArrayList) cargarBinInt()} recibe un arraylist de enteros.
     * <p>Carga los valores del arraylist en un archivo .bin.
     */
    private static void cargarBinInt(ArrayList<Integer> ints) {
        BinUtiles.intsToBin(ints, "ints");
    }
    /**
     * {@link #descargarBinInt() descargarBinInt()} retorna un arraylist de enteros desde un archivo .bin.
     */
    private static ArrayList<Integer> descargarBinInt() {
        return BinUtiles.binToInts("ints");
    }
    /**
     * {@link #cargarJsonInt(ArrayList) cargarJsonInt()} recibe un arraylist de enteros.
     * <p>Carga los valores del arraylist en un archivo .json.
     */
    private static void cargarJsonInt(ArrayList<Integer> ints) {
        JSONArray jaInts = new JSONArray();
        for(int anInt : ints) {
            jaInts.put(anInt);
        }
        JsonUtiles.grabar(jaInts, "ints");
    }
    /**
     * {@link #descargarJsonInt() descargarJsonInt()} retorna un arraylist de enteros desde un archivo .json.
     */
    private static ArrayList<Integer> descargarJsonInt() {
        ArrayList<Integer> ints = new ArrayList<>();
        try {
            JSONArray jaIntsJson = new JSONArray(JsonUtiles.leer("ints"));
            for(int i = 0; i < jaIntsJson.length(); i++) {
                ints.add(jaIntsJson.getInt(i));
            }

        }
        catch(JSONException ex) {
            System.out.println("JSONException: " + ex.getMessage());
        }
        return ints;
    }
    /**
     * {@link #cargarArregloString(ArrayList) cargarArregloString()} carga automaticamente un arraylist de strings.
     */
    private static void cargarArregloString(ArrayList<String> strings) {
        for(int i = 1; i < 6; i++) {
            strings.add("" + i);
        }
    }
    /**
     * {@link #cargarBinString(ArrayList) cargarBinString()} recibe un arraylist de strings.
     * <p>Carga los valores del arraylist en un archivo .bin.
     */
    private static void cargarBinString(ArrayList<String> strings) {
        BinUtiles.stringsToBin(strings, "strings");
    }
    /**
     * {@link #descargarBinString() descargarBinString()} retorna un arraylist de strings desde un archivo .bin.
     */
    private static ArrayList<String> descargarBinString() {
        return BinUtiles.binToStrings("strings");
    }
    /**
     * {@link #cargarJsonString(ArrayList) cargarJsonString()} recibe un arraylist de strings.
     * <p>carga los valores del arraylist en un archivo .json.
     */
    private static void cargarJsonString(ArrayList<String> strings) {
        JSONArray jaStrings = new JSONArray();
        for(String string : strings) {
            jaStrings.put(string);
        }
        JsonUtiles.grabar(jaStrings, "strings");
    }
    /**
     * {@link #descargarJsonString() descargarJsonString()} retorna un arraylist de strings desde un archivo .json.
     */
    private static ArrayList<String> descargarJsonString() {
        ArrayList<String> strings = new ArrayList<>();
        try {
            JSONArray jaStringsJson = new JSONArray(JsonUtiles.leer("strings"));
            for(int i = 0; i < jaStringsJson.length(); i++) {
                strings.add(jaStringsJson.getString(i));
            }
        }
        catch(JSONException ex) {
            System.out.println("JSONException: " + ex.getMessage());
        }
        return strings;
    }
}