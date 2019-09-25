package io_and_no.tobias_motor_repairs.service_app.tracker;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Status {

    static public void updateRecord(PathOf.Work type) throws IOException{

        File statusFile = PathOf.STATUS.getPath().toFile();
        File tempStatusFile = new File("temp" + PathOf.STATUS.getPath().toFile().toString());

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


            }

        }

        bw.flush();
        bw.close();

        statusFile.delete();
        tempStatusFile.renameTo(statusFile);




    }

}
