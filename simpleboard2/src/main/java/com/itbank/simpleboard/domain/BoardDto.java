package com.itbank.simpleboard.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class BoardDto {
    // member의 id
    private Long memberId;

    // board의 id
    private Long Id;
    private String title;
    private String content;
    private LocalDateTime wdate;
    private Member writer;

//    private String userid;

}
