package com.redis.logging;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    private final String logDir;

    public Logger(String logDir) {
        this.logDir = logDir;
    }

    public void log(String message) {
        System.out.println(message);
        File file = new File(this.logDir);
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {

            }
        }
        FileWriter writer;
        try {
            writer = new FileWriter(this.logDir, true);
            BufferedWriter buffer = new BufferedWriter(writer);
            buffer.write(message);
            buffer.write("\n");
            buffer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
