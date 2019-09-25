package io_and_no.tobias_motor_repairs.service_app.tracker;

import java.io.*;
import java.nio.file.*;
import java.util.StringTokenizer;

import static io_and_no.tobias_motor_repairs.service_app.tracker.PathOf.*;
import static io_and_no.tobias_motor_repairs.service_app.tracker.PathOf.Work.*;
import static io_and_no.tobias_motor_repairs.service_app.tracker.PathOf.Service.*;

import static java.nio.file.StandardWatchEventKinds.*;

public class Main {

    static public void updateStatus(PathOf.Work type) throws IOException{

        File statusFile = STATUS.getPath().toFile();
        File tempStatusFile = new File(STATUS.getPath().toFile().toString().replace("status", "tempStatus"));
        tempStatusFile.createNewFile();

        BufferedReader br = new BufferedReader( new FileReader(statusFile));
        BufferedWriter bw = new BufferedWriter( new FileWriter(tempStatusFile));


        while (br.ready()){
            StringTokenizer st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()){
                String model = st.nextToken(), total = st.nextToken();
                if(model.equalsIgnoreCase(type.toString())){
                    total = Integer.toString(Integer.parseInt(total) + 1);
                }

                bw.write(String.format("%s %s", model, total));
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
        br.close();

        statusFile.delete();
        tempStatusFile.renameTo(statusFile);
    }

    static public void updateRecord(Vehicle vehicle) throws IOException{

        File recordFile =  RECORD.getPath().toFile();
        File tempRecordFile = new File(RECORD.getPath().toFile().toString().replace("record", "tempRecord"));
        tempRecordFile.createNewFile();

        BufferedReader br = new BufferedReader(new FileReader())
        BufferedWriter bw = new BufferedWriter(new FileWriter(tempRecordFile));


        bw.write(String.format("%s,%s,%s", vehicle.getModel(), vehicle.getRegistration(), vehicle.getColour()));
        bw.newLine();
        bw.flush();
        bw.close();
    }



    public static void main(String[] args) {
try{
    String mainPath = "src/main/java/io_and_no/tobias_motor_repairs/service_app/";
    WatchService watchService = FileSystems.getDefault().newWatchService();
 COMPLETED.getPath().register(watchService, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);
 SERVICE.getPath().register(watchService, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);
 TODO.getPath().register(watchService, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);
 DONE.getPath().register(watchService, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);
 SERVICE_COMPLETED.getPath().register(watchService, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);
 WORK.getPath().register(watchService, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);
//    watchService.poll(5, TimeUnit.SECONDS);

    while (true){

        WatchKey watchKey = watchService.take();

        for(WatchEvent<?> event : watchKey.pollEvents()){

            if(event.kind().equals(ENTRY_CREATE)){

                String fileName = event.context().toString();
                File currentTodoFile = new File(TODO.getPath().toString() + "/" +fileName);
                File currentDoneFile = new File(DONE.getPath().toString() + "/" + fileName);

                if(currentTodoFile.exists()){
                        System.out.println(currentTodoFile);
                        BufferedReader buffReader =  new BufferedReader(new FileReader(currentTodoFile));
                        Vehicle vehicle = new Vehicle(buffReader.readLine());
                        buffReader.close();

                        Path storePath;
                        switch (vehicle.getModel()){
                            case "ford" :
                                storePath = FORD.getPath();
                               updateStatus(FORD);
                                break;
                            case "nissan" :
                                storePath = NISSAN.getPath();
                                updateStatus(NISSAN);
                                break;
                            case "toyota" :
                                storePath = TOYOTA.getPath();
                                updateStatus(TOYOTA);
                                break;
                            default:
                                storePath = OTHER.getPath();
                                updateStatus(OTHER);
                                break;
                        }

                        FileOutputStream fos = new FileOutputStream(storePath.toString() + "/" + fileName.replace(".csv", ".txt"));
                        ObjectOutputStream ois = new ObjectOutputStream(fos);
                        ois.writeObject(vehicle);
                        updateRecord(vehicle);
                        ois.flush();
                        ois.close();




                }

                if(currentDoneFile.exists()){
                    String model =  new BufferedReader(new FileReader(currentDoneFile)).readLine().split(",")[0].toLowerCase();
                    Work folder = Work.valueOf(model.toUpperCase());
                    File currentFile =  new File((folder.getPath().toString() + "/" + currentDoneFile.getName()).replace(".csv", ".txt"));
                    if(currentFile.exists()){
                      Files.move(currentFile.toPath(), Paths.get((SERVICE_COMPLETED.getPath().toString() + "/" +currentDoneFile.getName()).replace(".csv", ".txt")));
                            }
                        }



                }



        }
        watchKey.reset();
    }
}
catch(Exception ex){
    ex.printStackTrace();
}


    }
}
