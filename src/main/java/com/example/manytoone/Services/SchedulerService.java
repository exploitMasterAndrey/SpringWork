package com.example.manytoone.Services;

import lombok.SneakyThrows;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;

@EnableScheduling
@Service
public class SchedulerService{
    private static final String dump_path = "D:\\JavaProjects2\\ManyToOne\\cron_BD";

    private void clearDirectory() {
        File[] allContents = new File(dump_path).listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                file.delete();
            }
        }
    }

    @SneakyThrows
    @Scheduled(cron = "0 * * * * *")
    @ManagedOperation
    public void dumpDB(){
        clearDirectory();

        ProcessBuilder pb = new ProcessBuilder(
                "C:\\Program Files\\PostgreSQL\\14\\bin\\pg_dumpall.exe",
                "--dbname=postgresql://postgres:postgres@localhost:5432/football",
                "--verbose",
                "--file=D:\\JavaProjects2\\ManyToOne\\cron_BD\\db.backup");
        pb.start();

    }

}
