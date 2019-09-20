package io_and_no.tobias_motor_repairs.service_app.tracker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void sortBrand(){}



    public static void main(String[] args) {
        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();
            Path path = Paths.get("src/main/java/io_and_no/tobias_motor_repairs/service_app/service");
            path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
            watchService.poll(5, TimeUnit.SECONDS);

//            File file;

            WatchKey watchKey;
            while ((watchKey = watchService.take()) != null){
                for(WatchEvent<?> event : watchKey.pollEvents()){

                }
            }


        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
