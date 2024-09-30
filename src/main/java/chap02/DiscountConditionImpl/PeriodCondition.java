package chap02.DiscountConditionImpl;

import chap02.DiscountCondition;
import chap02.Screening;
import java.time.DayOfWeek;
import java.time.LocalTime;

public class PeriodCondition implements DiscountCondition {

    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return this.dayOfWeek.equals(screening.getStartTime().getDayOfWeek())
                && !this.startTime.isAfter(screening.getStartTime().toLocalTime())
                && !this.endTime.isBefore(screening.getStartTime().toLocalTime());
    }
}
