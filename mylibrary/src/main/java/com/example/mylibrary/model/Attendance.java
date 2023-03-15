package com.example.mylibrary.model;

public class Attendance {

    private String id; // attendanceId

    private String employeeName; // userName
    private String employeeId; // userId

    private Long timeIn, timeOut;
    private String coordinate;

    private String note;
    private String proofImage;

    private int status; // attendance status

    public Attendance(){}

    public Attendance(String id, String employeeName, String employeeId, Long timeIn, Long timeOut, String coordinate, String note, String proofImage, int status) {
        this.id = id;
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.coordinate = coordinate;
        this.note = note;
        this.proofImage = proofImage;
        this.status = status;
    }

    public void setTimeOut(Long timeOut) {
        this.timeOut = timeOut;
    }

    public String getId() {
        return id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public Long getTimeIn() {
        return timeIn;
    }

    public Long getTimeOut() {
        return timeOut;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public String getNote() {
        return note;
    }

    public String getProofImage() {
        return proofImage;
    }

    public int getStatus() {
        return status;
    }
}
