package com.wubinben.kata.hotelworldclocks;

/**
 * A concrete observer.
 * User: Ben
 * Date: 13-9-8
 * Time: 下午11:10
 * To change this template use File | Settings | File Templates.
 */
public class Moscow extends CityObserver {

    private static final int UTC_OFFSET = 4;

    private Moscow(DaylightSavingTime dstStatus, TimeSubject timeSubject) {
        super(timeSubject, dstStatus);
    }

    public static Moscow newInstance(DaylightSavingTime dstStatus, TimeSubject timeSubject) {
        return new Moscow(dstStatus, timeSubject);
    }

    @Override
    public void setTimeToTimeSubject(int localHour) {
        super.localHour = localHour;
        super.timeSubject.setHourUtcZero(convertLocalTimeToUtcZeroTime(super.localHour,
                Moscow.UTC_OFFSET, super.dstStatus));
    }

    @Override
    public void updateTimeOfCity(int hourUtcZero) {
        super.localHour = convertUtcZeroTimeToLocalTime(hourUtcZero, Moscow.UTC_OFFSET, super.dstStatus);
    }

    @Override
    public String getLocalHour() {
        return Integer.toString(super.localHour);
    }
}
