package spring3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //스프링 부트 초기 셋팅 : 1. 내장 톰캣 셋팅 2. MVC 셋팅 3. Restful 셋팅
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);
    }
}

/*
    MVC2 : 작업파일 패키지 업무분담[JAP] . 설계 디자인
        * 안전성 보장 [ view -> controller // controller -> service : PARAM, DTO, VO]
        //DTO : 데이터 이동 객체 (읽기/수정 모드)[CONTROLLER ->SERVICE]
        //VO : 데이터 이동 객체 (읽기모드)
        //entity : DB 테이블과 매핑된 객체 (SERVICE 에서만 사용 권장)

    VIEW -----------AJAX DTO-------------> CONTROLLER -------DTO-----------> SERVICE ---------JPA-------------------> DB
    화면                           제어 (VIEW <---> SERVICE)          로직                    entity--------매핑------->table
    - 통신방식 : AJAX                                                                       Entity조작(CRUD) : JPARepository
        -URL : create             @[METHOD]GetMapping(URL)                                  DTO --> Entity 형변환
        -METHOD : get
                                        SERVICE 메소드 호출              기능구현 로직
                                **controll 에서 entity 쓰지 XX
    JDBC : JAVA DATABASE CONNECTION 종류
        1.DAO [JAVAFX, JSP]
        2.JPA [SPRING]

    *JPA : 매핑[연결]
        //목적 : SQL 최소화 [SQL 반복작성 최소화] -> JAVA 함수[한 번 만들어 두면 반복 사용 가능]
        //매핑 : Entity(JAVA 클래스) -------------> DB(테이블_

    *
 */