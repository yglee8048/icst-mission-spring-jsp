package com.lgcns.icst.mission.spring.jsp.hangma.order.biz;

import com.lgcns.icst.mission.spring.jsp.hangma.member.entity.EmpRank;

public class FixedDiscountPolicy implements DiscountPolicy {

    @Override
    public int getDiscountPrice(EmpRank empRank, int price) {
        if (empRank.equals(EmpRank.VIP) && price > 1000) {
            return 1000;
        }
        return 0;
    }
}
