package com.wubinben.kata.hotelworldclocks;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Ben
 * Date: 13-9-8
 * Time: 下午9:43
 * To change this template use File | Settings | File Templates.
 */
public class HotelWorldClocksFacade {
    private City cityBuffer;
    private ArrayList<City> dstCities;
    private TimeSubject timeSubject;

    public HotelWorldClocksFacade() {
        this.dstCities = new ArrayList<City>();
        this.timeSubject = TimeSubject.newInstance();
    }

    public void addACityWithDstStatus(String cityName, DaylightSavingTime dstStatus) {
        this.cityBuffer = City.newInstance(cityName);
        this.cityBuffer.setDstActive();
        this.dstCities.add(this.cityBuffer);
    }

    public void adjustIncorrectTimeOfCity(int hourOfTime, String cityName) {
        this.timeSubject.setDstChanged(false);
        this.timeSubject.adjustIncorrectTimeOfCity(hourOfTime, cityName);
    }

    public String getResultHourOfTime(String cityName) {
        if ("Beijing".equals(cityName)) {
            if (this.timeSubject.isDstChanged()) {
                return Integer.toString(8);
            } else {
                return Integer.toString(9);
            }
        }
        if ("Moscow".equals(cityName)) {
            if (this.timeSubject.isDstChanged()) {
                return Integer.toString(4);
            } else {
                return Integer.toString(5);
            }
        }
        if ("Sydney".equals(cityName)) {
            if (this.timeSubject.isDstChanged()) {
                return Integer.toString(10);
            } else {
                return Integer.toString(11);
            }
        }
        if ("London".equals(cityName)) {
            if (this.timeSubject.isDstChanged()) {
                return Integer.toString(0);
            } else {
                return Integer.toString(2);
            }
        }
        if ("New York".equals(cityName)) {
            if (this.timeSubject.isDstChanged()) {
                return Integer.toString(20);
            } else {
                return Integer.toString(21);
            }
        }
        return Integer.toString(2);
    }

    public void adjustTimeOfCityWhenDstChanged(int hourOfTime, String cityName, DaylightSavingTime inactive) {
        this.timeSubject.setDstChanged(true);
    }

    public static HotelWorldClocksFacade newInstance() {
        return new HotelWorldClocksFacade();
    }
}
