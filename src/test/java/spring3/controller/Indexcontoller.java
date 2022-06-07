package spring3.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring3.domain.DTO.MemberDTO;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class Indexcontoller {

        //RESTFUL 정의
            //1.자원 (URL)
            //2.행위(HTTP Method)     CRUD    차이[먹등성 ==기록 O/X]
                //1.@PostMapping        C       X
                //2.@GetMapping         R       O
                //3.@PutMapping         U       O
                //4.@DeleteMapping      D       O
                    //여러번 호출했을 때 차이 : POST는 호출할 때 마다 데이터 새로 생성 [나머지는 있는 기록 끌어다 씀]
                                // ----> 보안은 좋지만 시간 오래걸림.
                        //AJAX ------------------------> Control
                        //Ajax method: POST --------------->
            //3.표현
    //static indexservice indexservice = new Indexservixe();
    
    @Autowired //자동 빈 생성 // new 생성하지 않아도 메모리 할당
    spring3.service.indexservice indexservice;

    @GetMapping("/")
    public String Index(){
        return "main";
    }
    @PostMapping("/create")
    @ResponseBody
    public Boolean create(@RequestParam("name") String name, @RequestParam("phone")  String phone, @RequestParam("memo")  String memo){
        //1.DTO 풀생성자 사용
       // MemberDTO memberDTO = new MemberDTO(0, name, phone, memo);
        //2. DTO 빈생성자 사용
       /* MemberDTO memberDTO2 = new MemberDTO();
            memberDTO2.setNo(0);
            memberDTO2.setName(1);
            memberDTO2.setPhone(2);
            memberDTO2.setMemo(3);*/
        //3. builder 사용시
        MemberDTO memberDTO3 = MemberDTO.builder()
                .name(name)
                .phone(phone)
                .memo(memo)
                .build();
        //빌더 : 안정성 보장
            //생성자 인수 순서, 개수 안 맞춰도 됨 [빈 곳은 null값 들어감]
        System.out.println(memberDTO3.toString());
        boolean result = indexservice.create( memberDTO3);
        return result;
    }
    @GetMapping("/read")
    public void read(HttpServletResponse responese) {
        List<MemberDTO> memberDTO = indexservice.read();
        JSONArray jsonArray = new JSONArray();
        for(MemberDTO dto : memberDTO){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("no",dto.getNo());
            jsonObject.put("name",dto.getName());
            jsonObject.put("phone",dto.getPhone());
            jsonObject.put("memo",dto.getMemo());
            jsonArray.put(jsonObject);
        }
        try {
            responese.setCharacterEncoding("UTF-8");
            responese.setContentType("application/json");
            responese.getWriter().print(jsonArray);
        }catch (Exception e) {
            System.out.println("read 오류 : " + e);
        }
    }
    @PutMapping("/update")
    @ResponseBody
    public String update(){
        indexservice.update();
        return "update success";
    }
    @DeleteMapping ("/delete")
    @ResponseBody
    public String delete(){
        indexservice.delete();
        return "delete success";
    }
}
