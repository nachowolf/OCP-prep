package io_and_no.tobias_motor_repairs.service_app.tracker;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static io_and_no.tobias_motor_repairs.service_app.tracker.PathOf.*;
import static io_and_no.tobias_motor_repairs.service_app.tracker.PathOf.Work.*;
import static io_and_no.tobias_motor_repairs.service_app.tracker.PathOf.Service.*;

import static java.nio.file.StandardWatchEventKinds.*;

public class Main {

    static public void updateRecord() throws IOException{

        Path completedServices = DONE.getPath();
        File recordFile = RECORD.getPath().toFile();

        BufferedWriter bufferedWriter =  new BufferedWriter( new FileWriter(recordFile));

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate today = LocalDate.now();

        TemporalField weekOfMonth = WeekFields.of(Locale.getDefault()).weekOfMonth();
        int weekNumberToday = today.get(weekOfMonth);
        int monthNumberToday = today.getMonthValue();

        int day = 0,
                week = 0,
                month = 0;

        for(String fileName : completedServices.toFile().list()) {
            File file = new File(DONE.getPath().toString() + "/" + fileName);
            LocalDate lastModified = LocalDate.parse(sdf.format(file.lastModified()), dateFormat);
            int weekNumberLastModified = lastModified.get(weekOfMonth);
            int monthNumberLastModified = lastModified.getMonthValue();

            if (monthNumberLastModified == monthNumberToday) {
                if (weekNumberLastModified == weekNumberToday) {
                    if (today.minusDays(1).equals(lastModified)) {
                        day++;
                    } else {
                        week++;
                    }
                } else {
                    month++;
                }
            }

        }
        bufferedWriter.write(String.format("last day %s cars", day));
        bufferedWriter.newLine();
        bufferedWriter.write(String.format("last week %s cars", week));
        bufferedWriter.newLine();
        bufferedWriter.write(String.format("last month %s cars", month));

        bufferedWriter.flush();
        bufferedWriter.close();

    }

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

    static public void updateServiced(Vehicle vehicle) throws IOException{

        File servicedFile =  SERVICED.getPath().toFile();
        File tempServicedFile = new File(SERVICED.getPath().toFile().toString().replace("serviced", "tempServiced"));
        tempServicedFile.createNewFile();

        BufferedReader br = new BufferedReader(new FileReader(servicedFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(tempServicedFile));

        while(br.ready()){
            bw.write(br.readLine());
            bw.newLine();
        }
        br.close();
        bw.write(String.format("%s,%s,%s", vehicle.getModel(), vehicle.getRegistration(), vehicle.getColour()));
//        bw.newLine();
        bw.flush();
        bw.close();

        servicedFile.delete();
        tempServicedFile.renameTo(servicedFile);
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

// ###| USED TO MODIFY DATE OF LAST MODIFY FOR TESTING
// File f = new File(mainPath + "/tester2.csv");
//    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
// f.setLastModified(sdf.parse("29-09-2019").getTime());


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
                        updateServiced(vehicle);
                        ois.flush();
                        ois.close();
                }

                if(currentDoneFile.exists()){
                    String model =  new BufferedReader(new FileReader(currentDoneFile)).readLine().split(",")[0].toLowerCase();
                    File currentFile = new File(OTHER.getPath().toString() +"/"+currentDoneFile.getName().replace(".csv", ".txt"));
                    for(Work i : Work.values()){
                        if(i.toString().equalsIgnoreCase(model)){
                            currentFile = new File(i.getPath().toString() +"/"+currentDoneFile.getName().replace(".csv", ".txt"));
                            break;
                        }
                        else {continue;}
                    }


//                    folder = Arrays.asList(Work.values()).contains(model.toLowerCase()) ? Work.valueOf(model.toUpperCase()) : OTHER;

//                    File currentFile =  new File((folder.getPath().toString() + "/" + currentDoneFile.getName()).replace(".csv", ".txt"));
                    System.out.println(currentDoneFile);
                    System.out.println(currentFile);
                    if(currentFile.exists()){
                      Path targetMove = Paths.get((SERVICE_COMPLETED.getPath().toString() + "/" +currentDoneFile.getName()).replace(".csv", ".txt"));
                      if(!targetMove.toFile().exists()){
                        System.out.println(targetMove);
                          Files.move(currentFile.toPath(), targetMove);
                          System.out.println("out");
                      }
                            }
                    updateRecord();
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
