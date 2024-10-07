package org.example.creacionficheros;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class XMLtoJson {
    public static void main(String[] args) {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Como se llama el archivo?");
            StringBuilder path = new StringBuilder();
            path.append("res/");
            path.append(scanner.nextLine());
            if (!Files.exists(Path.of(path.toString()))) {
                System.out.println("El archivo no existe. Verifica la ruta.");
                return;
            }
            if (Files.exists(Path.of(path.toString().replace(".xml", ".json")))) {
                System.out.println("El archivo ya existe.");
                return;
            }
            JsonNode node = xmlMapper.readTree(new File(path.toString()));
            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(path.toString().replace(".xml", ".json")),node);
        }catch (IOException e){
            System.out.println("No se ha encontrado el archivo, comprueba la ruta.");
        }
    }
}

