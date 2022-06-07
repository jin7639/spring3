package spring3.domain.DTO;


import lombok.*;
import spring3.domain.entity.MemberEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class MemberDTO {
    public Integer no;
    public String name;
    public String phone;
    public String memo;

    //설계 관련 API :롬복 (생성자, getter, setter 등 어노테이션 제공)

    //1.DTO ->entity 변환 메소드
    public MemberEntity changeEntity(){
        MemberEntity memberEntity = MemberEntity.builder()
                .name(this.name)
                .phone(this.phone)
                .memo(this.memo)
                .build();
        return memberEntity;
    }



}
