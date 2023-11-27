package com.abo2.recode.domain.studymember;

import com.abo2.recode.domain.studyroom.StudyRoom;
import com.abo2.recode.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class StudyMember {

    @Id
    @Column(name="study_member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id; //스터디 룸 member 일련번호

    @ManyToOne
    @JoinColumn(name = "study_room_id")
    private StudyRoom studyRoom;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false,length = 50)
    private Integer status;

    @Builder
    public StudyMember(StudyRoom studyRoom, User user, Integer status) {
        this.studyRoom = studyRoom;
        this.user = user;
        this.status = status;
    }

}