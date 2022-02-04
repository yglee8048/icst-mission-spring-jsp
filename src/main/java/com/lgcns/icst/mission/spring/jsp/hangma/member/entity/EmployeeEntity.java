package com.lgcns.icst.mission.spring.jsp.hangma.member.entity;

public class EmployeeEntity {

    private Integer empNo;
    private String empNm;

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

    public void setEmpNm(String empNm) {
        this.empNm = empNm;
    }
}
