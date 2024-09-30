package chap02.DiscountPolicyImpl;

import chap02.DiscountPolicy;
import chap02.Money;
import chap02.Screening;

public class NonDiscountPolicy implements DiscountPolicy {

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
