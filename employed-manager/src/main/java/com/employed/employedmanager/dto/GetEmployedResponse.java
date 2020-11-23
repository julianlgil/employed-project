package com.employed.employedmanager.dto;

public class GetEmployedResponse {

    private DeltaDateDto hiringTime;
    private DeltaDateDto age;

    public GetEmployedResponse() {
    }

    public GetEmployedResponse(DeltaDateDto hiringTime, DeltaDateDto age) {
        this.hiringTime = hiringTime;
        this.age = age;
    }

    public DeltaDateDto getHiringTime() {
        return hiringTime;
    }

    public void setHiringTime(DeltaDateDto hiringTime) {
        this.hiringTime = hiringTime;
    }

    public DeltaDateDto getAge() {
        return age;
    }

    public void setAge(DeltaDateDto age) {
        this.age = age;
    }
}
