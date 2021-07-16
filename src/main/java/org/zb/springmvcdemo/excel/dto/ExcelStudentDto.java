package org.zb.springmvcdemo.excel.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ExcelStudentDto {
    @ExcelProperty("名称")
    private String name;
    @ExcelProperty("生日")
    private Date birthday;
    @ExcelProperty("薪水")
    private Double salary;
}
