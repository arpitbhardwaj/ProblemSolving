package com.ab.misc;

import java.time.LocalDateTime;

public class SafeTimeToKill {

    enum Service{
        EMDW(15,10),
        OPSI(30,20),
        LA(60,20),
        EMDW_CONFIG(1440,10);

        int freq;
        int timeout;

        Service(int freq, int timeout) {
            this.freq = freq;
            this.timeout = timeout;
        }
    }

    public static void main(String[] args) {
        //Next Schedules
        LocalDateTime emdwS = LocalDateTime.now();
        LocalDateTime opsiS = LocalDateTime.now().plusMinutes(20);
        LocalDateTime laS = LocalDateTime.now().plusMinutes(30);
        LocalDateTime emdwConfigS = LocalDateTime.now().plusMinutes(45);

    }
}
