package org.example.lecturaEscrituraJSON;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BinaryToJSON {
    public static void main(String[] args) {
        List<Game> games = new ArrayList<>();

        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream("res/games.bin"))){
            while(true){
                Object o = reader.readObject();
                if(o instanceof Game){
                    games.add((Game) o);
                }
            }
        }catch (EOFException e){
            System.out.println("Se han leido los objetos");
        }catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }catch (ClassNotFoundException e){
            System.out.println("No existe el archivo.");
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("res/games.json"),games);
        }
        catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }catch (IOException e){
            System.out.println("Error en la escritura del archivo.");
        }
    }
}
