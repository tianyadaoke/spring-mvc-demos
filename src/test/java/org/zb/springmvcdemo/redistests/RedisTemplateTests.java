package org.zb.springmvcdemo.redistests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.zb.springmvcdemo.excel.bean.ExcelStudent;
import org.zb.springmvcdemo.excel.dao.ExcelStudentRepository;


import java.util.concurrent.TimeUnit;

@SpringBootTest
public class RedisTemplateTests {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    ExcelStudentRepository excelStudentRepository;

    @Test
    void saveDict(){
        ExcelStudent excelStudent = excelStudentRepository.findById(1L).get();
        redisTemplate.opsForValue().set("excelStudent",excelStudent,1, TimeUnit.MINUTES);
    }
}
