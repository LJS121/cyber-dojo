package com.mjy.cyber;

import com.google.common.collect.Maps;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class Friday13th {

    private int startYear = 1900;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    // 起点是1973年1月1号， 星期一
    public Map<Week, Integer> findAll13th() throws Exception {
        Map<Week, Integer> map = Maps.newHashMap();

        for (int year = startYear; year <= Calendar.getInstance().get(Calendar.YEAR); year++) {
            for (int month = 1; month <= 12; month++) {
                Week week = getWeekOfDate(sdf.parse(String.format("%s-%s-13", year, month)));
                if (map.get(week) != null) {
                    map.put(week, map.get(week) + 1);
                } else {
                    map.put(week, 1);
                }
            }
        }

        return map;
    }

    public static Week getWeekOfDate(Date date) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return Week.weekOf(weekDays[w]);
    }

    enum Week {

        Monday("星期一"),
        Tuesday("星期二"),
        Wednesday("星期三"),
        Thursday("星期四"),
        Friday("星期五"),
        Saturday("星期六"),
        Sunday("星期日");

        private String value;

        public static Week weekOf(String value) {
            switch (value) {
                case "星期一":
                    return Monday;
                case "星期二":
                    return Tuesday;
                case "星期三":
                    return Wednesday;
                case "星期四":
                    return Thursday;
                case "星期五":
                    return Friday;
                case "星期六":
                    return Saturday;
                case "星期日":
                    return Sunday;
                default:
                    throw new IllegalArgumentException();
            }
        }

        Week(String weekDay) {
            this.value = weekDay;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
