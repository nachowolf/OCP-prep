package io_and_no.io_examples;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IOBasics {
    public static void main(String[] args) {
        try{
            File file = new File("src/main/java/io_and_no/io_examples/out/filewrite.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write("i am a file");
            bufferedWriter.newLine();
            bufferedWriter.write("A very new line");
            bufferedWriter.flush();
            bufferedWriter.close();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while(bufferedReader.ready()){
                System.out.println(bufferedReader.readLine());
            }

            Path mani = Paths.get("src/main/java/io_and_no/io_examples/out");
            Path example = Paths.get("out/tables");
            Path ex = example.relativize(mani);

            System.out.println(Files.exists(ex));
            if(!Files.exists(ex)){
//                Files.createDirectory(ex);
//                Files.createFile(ex);
            }
            System.out.println(ex.toString());
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
