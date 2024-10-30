package chap02;

import chap02.DiscountConditionImpl.PeriodCondition;
import chap02.DiscountConditionImpl.SequenceCondition;
import chap02.DiscountPolicyImpl.AmountDiscountPolicy;
import chap02.DiscountPolicyImpl.NonDiscountPolicy;
import chap02.DiscountPolicyImpl.PercentDiscountPolicy;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

public class chap_02_main {

    public static void main(String[] args) {
        Movie avatar = new Movie(
                "Avatar",
                Duration.ofMinutes(120),
                Money.wons(10000),
                new AmountDiscountPolicy(
                        Money.wons(800),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0),
                                LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0),
                                LocalTime.of(20, 59))
                )
        );

        Movie titanic = new Movie(
                "Titanic",
                Duration.ofMinutes(180),
                Money.wons(11000),
                new PercentDiscountPolicy(
                        0.1,
                        new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0),
                                LocalTime.of(16, 59)),
                        new SequenceCondition(2),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0),
                                LocalTime.of(13, 59))
                )
        );

        Movie starWars = new Movie(
                "StarWars",
                Duration.ofMinutes(210),
                Money.wons(10000),
                new NonDiscountPolicy()
        );
    }

}
