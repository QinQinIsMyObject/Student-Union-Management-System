package cn.asu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Celery
 */
@SpringBootApplication
@MapperScan("cn.asu.mybatisplus.mapper")
public class StudentUnionApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentUnionApplication.class, args);
    }

}
