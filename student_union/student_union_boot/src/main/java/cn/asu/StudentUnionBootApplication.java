package cn.asu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.asu.mybatisplus.mapper")
@SpringBootApplication
public class StudentUnionBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentUnionBootApplication.class, args);
    }

}
