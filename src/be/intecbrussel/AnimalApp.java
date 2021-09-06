package be.intecbrussel;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class AnimalApp {
    public static void main(String[] args) {


        Animal animal = new Animal("Coco" , false);

        try(ObjectOutputStream objectOutputStream
                = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Gebruiker\\Documents\\FromAlperToPearl\\animal.txt"))){

            objectOutputStream.writeObject(animal);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try(ObjectInputStream objectInputStream
                    = new ObjectInputStream(new FileInputStream("C:\\Users\\Gebruiker\\Documents\\FromAlperToPearl\\animal.txt"))){

            Animal animal1;

            while ((animal1 = (Animal) objectInputStream.readObject()) != null){
                System.out.println(animal1);
            }

        } catch (IOException e) {
            System.out.println("End of the file");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}
