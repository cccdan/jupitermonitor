package com.mon;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {

    static String getFormattedCurrentTime() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        return df.format(localDateTime);
    }
}
