package com.redis.logging;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Logger {

    private final String logDir;

    public Logger(String logDir) {
        this.logDir = logDir;
    }

    public void log(String message) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(this.logDir);
            BufferedWriter buffer = new BufferedWriter(writer);
            buffer.write(message);
            writer.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
