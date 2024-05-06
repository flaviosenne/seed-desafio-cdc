package com.seed.desafio.cdc.utils;

import java.util.Date;

public class DateUtils {

    public static Date getOnlyDateNow(){
        Date nowOnlyDate = new Date();
        nowOnlyDate.setHours(0);
        nowOnlyDate.setMinutes(0);
        nowOnlyDate.setSeconds(0);
        return nowOnlyDate;
    }
}
