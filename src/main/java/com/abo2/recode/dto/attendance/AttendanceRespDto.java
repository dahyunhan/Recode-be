package com.abo2.recode.dto.attendance;

import com.abo2.recode.domain.attendance.Attendance;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class AttendanceRespDto {

    private Attendance attendance;

    public AttendanceRespDto(Attendance attendance) {
        this.attendance = attendance;
    }

    @Getter
    @Setter
    public static class markAttendanceRespDto {
        private Long id;
        private Long studyId;
        private Long userId;
        private LocalDateTime attendanceDate;
        private String status;

    }
}
