package org.example.lecturaEscrituraJSON;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BinaryToJSON {
    public static void main(String[] args) {
        List<Game> games = new ArrayList<>();
        int numGames = 0;
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream("res/games.bin"))){
            while(true){
                Object o = reader.readObject();
                if(o instanceof Game){
                    games.add((Game) o);
                    System.out.println("Se ha leido un juego");
                    numGames++;
                }
            }

        }catch (EOFException e){
            System.out.println("Se terminó de leer el archivo, total de juegos: " + numGames);;
        }catch (IOException e) {
            System.out.println("Error al leer el archivo."+ e.getMessage());
        }catch (ClassNotFoundException e){
            System.out.println("No existe el archivo."+ e.getMessage());
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
