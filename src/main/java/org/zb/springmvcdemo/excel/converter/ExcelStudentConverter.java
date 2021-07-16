package org.zb.springmvcdemo.excel.converter;

import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.zb.springmvcdemo.excel.bean.ExcelStudent;
import org.zb.springmvcdemo.excel.dto.ExcelStudentDto;

public class ExcelStudentConverter {
    public static ExcelStudent toExcelStudent(ExcelStudentDto excelStudentDto){
        ExcelStudent excelStudent = new ExcelStudent();
        BeanUtils.copyProperties(excelStudentDto,excelStudent);
        return excelStudent;
    }
    public static ExcelStudentDto fromExcelStudent(ExcelStudent excelStudent){
        ExcelStudentDto excelStudentDto = new ExcelStudentDto();
        BeanUtils.copyProperties(excelStudent,excelStudentDto);
        return excelStudentDto;
    }
}
