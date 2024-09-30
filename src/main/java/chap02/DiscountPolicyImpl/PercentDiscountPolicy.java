package chap02.DiscountPolicyImpl;

import chap02.DefaultDiscountPolicy;
import chap02.DiscountCondition;
import chap02.Money;
import chap02.Screening;

public class PercentDiscountPolicy extends DefaultDiscountPolicy {

    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
