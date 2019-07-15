package com.sankuai.bi.databook.api.util;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by litianshuo on 18/1/16.
 */

public class TimeUtil {

    private static Logger logger = LoggerFactory.getLogger(TimeUtil.class);

    public static String timestamp2Date(long timestamp){
        return timestamp2Date(timestamp, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * @Description: unix时间戳转标准时间
     * @Params:
     * @Return:
     */

    public static String timestamp2Date(long timestamp, String format){
        if (0 == timestamp) {
            return "0";
        }
        String date = new SimpleDateFormat(format).format(new Date(timestamp));
        return date;
    }

    public static Long string2Timestamp2(String timeStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (StringUtils.isNotEmpty(timeStr)) {
            try {
                Date parse = dateFormat.parse(timeStr);
                return parse.getTime();
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        return -1L;
    }

    public static String getCurrentTime() {

        return TimeUtil.timestamp2Date(System.currentTimeMillis(),"yyyy-MM-dd HH:mm:ss");

    }

    public static long getCurrentTimestamp(){

        return System.currentTimeMillis();
    }

    /*
    * 查找当前时间向前回溯k天的信息
    * */
    public static long getReverseTimestamp(int k){

        return System.currentTimeMillis() - k *  24 * 3600000;
    }
}