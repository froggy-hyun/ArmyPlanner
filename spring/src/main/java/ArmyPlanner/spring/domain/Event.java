package ArmyPlanner.spring.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "event")
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    private String eventType;

    @Column(nullable = false)
    private String title;

//  식단 -----------------------
    private String food_name;
    private String kcal;
    private String carbohydrate;
    private String protein;
    private String fat;
    private String sugar;
    private String salt;
    private String cholesterol;
    private String saturatedFattyAcids;
    private String transFattyAcids;

//  소비 기록 --------------------
    private String shopping_name;
    private String total_price;
//  장소 --------------------
    private String placeName;
    private String address;
    private String x;
    private String y;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+9")
    private LocalDateTime start;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+9")
    private String startDate; //for 소비, 식단, 장소

    @DateTimeFormat(pattern = "yyyy-MM")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+9")
    private String startMonth; //for 월 소비

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+9")
    private LocalDateTime end;

    private boolean allDay;

    @ManyToOne
    private Member member;

}