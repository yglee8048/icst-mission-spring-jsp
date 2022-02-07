package com.lgcns.icst.mission.spring.jsp.hangma.order.biz;

import com.lgcns.icst.mission.spring.jsp.hangma.member.entity.EmpRank;

public interface DiscountPolicy {

    int getDiscountPrice(EmpRank empRank, int price);
}
