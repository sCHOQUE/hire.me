package com.yagod.url_shortener_app.utils;

import org.springframework.stereotype.Component;

@Component
public class CalculateTimeProc {

    private static long startTime;
    private static long endTime;
    private static long time;

    public void StartTime(){
        startTime = System.currentTimeMillis();
    }

    public long Endtime( ){
        endTime = System.currentTimeMillis();
        time = endTime - startTime;
        startTime = 0;
        endTime = 0;
        return time;
    }
}
