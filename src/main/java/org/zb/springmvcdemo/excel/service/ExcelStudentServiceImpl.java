package org.zb.springmvcdemo.excel.service;

import com.alibaba.excel.EasyExcel;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zb.springmvcdemo.excel.bean.ExcelStudent;
import org.zb.springmvcdemo.excel.converter.ExcelStudentConverter;
import org.zb.springmvcdemo.excel.dao.ExcelStudentRepository;
import org.zb.springmvcdemo.excel.dto.ExcelStudentDto;
import org.zb.springmvcdemo.excel.listener.ExcelStudentDtoListener;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ExcelStudentServiceImpl implements ExcelStudentService{

    @Autowired
    ExcelStudentRepository excelStudentRepository;

    @Override
    public void importData(InputStream inputStream) {
        EasyExcel.read(inputStream, ExcelStudentDto.class,new ExcelStudentDtoListener(excelStudentRepository)).sheet().doRead();
        log.info("导入成功");
    }

    @Override
    public List<ExcelStudentDto> exportData() {
        List<ExcelStudent> studentList = excelStudentRepository.findAll();
        return studentList.stream().map(s->ExcelStudentConverter.fromExcelStudent(s))
                .collect(Collectors.toList());
    }
}
