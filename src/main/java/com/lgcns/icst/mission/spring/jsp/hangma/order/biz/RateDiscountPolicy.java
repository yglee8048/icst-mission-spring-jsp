package com.lgcns.icst.mission.spring.jsp.hangma.order.biz;

import com.lgcns.icst.mission.spring.jsp.hangma.member.entity.EmpRank;

public class RateDiscountPolicy implements DiscountPolicy {

    @Override
    public int getDiscountPrice(EmpRank empRank, int price) {
        if (empRank.equals(EmpRank.VIP)) {
            return (int) (price * 0.1);
        }
        return 0;
    }
}
