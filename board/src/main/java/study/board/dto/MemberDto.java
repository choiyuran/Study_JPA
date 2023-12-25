package study.board.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberDto {
    private Long member_id;
    private String username;
    private String userid;
    private String userpw;

    @QueryProjection
    public MemberDto(String username, int age) {
        this.username = username;
        this.userid = userid;
        this.userpw = userpw;
    }



}
