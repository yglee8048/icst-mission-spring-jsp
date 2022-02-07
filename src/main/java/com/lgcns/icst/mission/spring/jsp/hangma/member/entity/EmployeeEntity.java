package com.lgcns.icst.mission.spring.jsp.hangma.member.entity;

public class EmployeeEntity {

    private Integer empNo;
    private String empNm;
    private EmpRank empRank;

    public EmployeeEntity(Integer empNo, String empNm) {
        this.empNo = empNo;
        this.empNm = empNm;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public String getEmpNm() {
        return empNm;
    }

    public EmpRank getEmpRank() {
        return empRank;
    }
}
