package com.wubinben.kata.hotelworldclocks;

/**
 * Created with IntelliJ IDEA.
 * User: Ben
 * Date: 13-9-8
 * Time: 下午10:59
 * To change this template use File | Settings | File Templates.
 */
public abstract class CityObserver {
    public static final int INVALID_HOUR_OF_TIME = 100;

    public abstract void setStateOfTimeSubjectWithUtcZeroHourOfTime(int hourOfTime);

    public abstract void updateCityWithUtcZeroHourOfTime(int utcZeroHourOfTime);

    protected int convertLocalTimeToUtcZeroTime(int hourOfTime, int utcOffset, DaylightSavingTime dstStatus) {
        switch (dstStatus) {
            case INACTIVE:
                return hourOfTime - utcOffset;
            case ACTIVE:
                return hourOfTime - utcOffset - 1;
        }
        return CityObserver.INVALID_HOUR_OF_TIME;
    }

    protected int convertUtcZeroTimeToLocalTime(int utcZeroHourOfTime, int utcOffset, DaylightSavingTime dstStatus) {
        switch (dstStatus) {
            case INACTIVE:
                return withinTwentyFourHours(utcZeroHourOfTime + utcOffset);
            case ACTIVE:
                return withinTwentyFourHours(utcZeroHourOfTime + utcOffset + 1);
        }
        return CityObserver.INVALID_HOUR_OF_TIME;
    }

    private int withinTwentyFourHours(int hourOfTime) {
        if (hourOfTime < 0) {
            return hourOfTime + 24;
        }
        if (hourOfTime > 24) {
            return hourOfTime - 24;
        }
        return hourOfTime;
    }

    public abstract String printCityName();

    public abstract String getLocalHourOfTime();
}
