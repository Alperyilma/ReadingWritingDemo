package be.intecbrussel;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class MyTest {

    public static void main(String[] args) {

        Path pathOfFile = Path.of("C:\\Users\\Gebruiker\\Documents\\FromAlperToPearl\\message.txt");
        Path pathOfDirectory = pathOfFile.getParent();

//        System.out.println(Files.notExists(pathOfFile));
//        System.out.println(Files.notExists(pathOfDirectory));


        try {
            if (Files.notExists(pathOfDirectory)) {
                Files.createDirectory(pathOfDirectory);
            }
            if (Files.notExists(pathOfFile)) {
                Files.createFile(pathOfFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (FileWriter fileWriter = new FileWriter("C:\\Users\\Gebruiker\\Documents\\FromAlperToPearl\\message.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
             bufferedWriter.write("Een vrouw vraagt de dokter:\n" +
                     "- Mijn man praat constant in zijn slaap. Welk medicijn kun je hem geven om beter te worden?\n" +
                     "De dokter antwoordt:\n" +
                     "- Geen medicijnen nodig. Geef je man gewoon de kans om te praten terwijl hij wakker is.");
             bufferedWriter.write("\n*********");
             bufferedWriter.write("\nPap, waar komt de mensheid vandaan?\n" +
                     "-de mensheid komt van apen\n" +
                     "Mam, waar komt de mensheid vandaan?\n" +
                     "-van Adam\n" +
                     "Maar mijn vader zei dat de mensheid van apen kwam\n" +
                     "-De familie van die vader gaat ons niets aan, zoon.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        try(BufferedReader bufferedReader =
                new BufferedReader(new FileReader("C:\\Users\\Gebruiker\\Documents\\FromAlperToPearl\\message.txt"))){
            String line;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}


