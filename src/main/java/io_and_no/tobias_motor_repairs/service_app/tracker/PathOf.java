package io_and_no.tobias_motor_repairs.service_app.tracker;

import java.nio.file.Path;
import java.nio.file.Paths;

public enum PathOf {
    COMPLETED("completed"),
    SERVICE("service"),
    SERVICE_COMPLETED("service_completed"),
    RECORD("record.txt"),
    SERVICED("serviced.txt"),
    STATUS("status.txt"),
    WORK("work");

    private Path path;

     PathOf(String loc){
        this.path = Paths.get("src/main/java/io_and_no/tobias_motor_repairs/service_app/" + loc);
    }

    public Path getPath() {
        return path;
    }

    public enum Work{
        NISSAN("nissan"),
        FORD("ford"),
        TOYOTA("toyota"),
        OTHER("other");

        private Path path;
        Work(String loc){
            this.path = Paths.get("src/main/java/io_and_no/tobias_motor_repairs/service_app/work/" + loc);
        }

        public Path getPath() {
            return path;
        }
    }

    public enum Service{
        TODO("todo"),
        DONE("done");

        private Path path;
        Service(String loc){
            this.path = Paths.get("src/main/java/io_and_no/tobias_motor_repairs/service_app/service/" + loc);
        }

        public Path getPath() {
            return path;
        }
    }

}
