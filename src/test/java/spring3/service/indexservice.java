package spring3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring3.domain.DTO.MemberDTO;
import spring3.domain.entity.MemberEntity;
import spring3.domain.entity.MemberRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class indexservice {//자바 로직 실행되는 클래스
    @Autowired
    MemberRepository memberRepository;

    //1.생성

    public boolean create(MemberDTO memberDTO){
        MemberEntity memberEntity = memberDTO.changeEntity();
        int no = memberRepository.save(memberEntity).getNo();
        System.out.println("no");
        if(no>0){return true;}
        else {return false;}
    }

    //2.호출
    public List<MemberDTO>read(){

        List<MemberEntity> entities = memberRepository.findAll();
        List<MemberDTO> memberDTO = new ArrayList<>();

        for (MemberEntity entity : entities) {
            memberDTO.add(MemberDTO.builder()
                    .no(entity.getNo())
                    .name(entity.getName())
                    .phone(entity.getPhone())
                    .memo(entity.getMemo())
                    .build()
            );
        }
        return memberDTO;
    }
    //3.수정
    public void update(){}

    //4.삭제
    public void delete(){}

}
