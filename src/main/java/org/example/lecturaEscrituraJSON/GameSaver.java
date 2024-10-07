package org.example.lecturaEscrituraJSON;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class GameSaver {
    public static void main(String[] args) {
        List<Game> gameList = new ArrayList<Game>();
        Game game1 = new Game("The Binding of Isaac");
        game1.setDescription("The Binding of Isaac es un videojuego de rol de acción, " +
                "videojuego de mazmorras, y videojuego de disparos de palancas gemelas, " +
                "creado como concepto por Edmund McMillen como un proyecto secundario mientras seguía " +
                "trabajando en Super Meat Boy junto con Tommy Refenes.");
        game1.addLanguages("English");
        game1.addLanguages("Español");
        game1.addLanguages("Chino");
        game1.addLanguages("Japones");
        Game game2 = new Game("Overwatch 2");
        game2.setDescription("Overwatch 2 es un videojuego de disparos en primera persona. " +
                "Fue desarrollado y publicado por Blizzard Entertainment. " +
                "Es una secuela del hero shooter de 2016 Overwatch. " +
                "El videojuego se diseñó para tener un entorno compartido para los modos de jugador " +
                "contra jugador (JcJ) con el primer videojuego al tiempo " +
                "que presenta modos cooperativos persistentes.");
        game2.addLanguages("English");
        game2.addLanguages("Español");
        game2.addLanguages("Japones");
        game2.addLanguages("Vietnamita");

        gameList.add(game1);
        gameList.add(game2);
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("res/games.bin"))) {
            for (Game game : gameList) {
                writer.writeObject(game);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage() + "No se han guardado los juegos.");
        }
    }
}