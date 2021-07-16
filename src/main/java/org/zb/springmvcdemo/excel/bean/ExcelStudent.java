package org.zb.springmvcdemo.excel.bean;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
@Data
@Entity
public class ExcelStudent implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ExcelProperty("名称")
    private String name;
    @ExcelProperty("生日")
    private Date birthday;
    @ExcelProperty("薪水")
    private Double salary;

}
