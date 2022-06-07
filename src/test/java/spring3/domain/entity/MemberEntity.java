package spring3.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity //일반 클래스 -> 엔티티로 사용
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer no;
    
    @Column
    public String name;
    
    @Column
    public String phone;
    
    @Column
    public String memo;
}
