package org.zb.springmvcdemo.excel.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.zb.springmvcdemo.excel.dto.ExcelStudentDto;

import java.io.InputStream;
import java.util.List;

@Service
public interface ExcelStudentService {
    void importData(InputStream inputStream);

    List<ExcelStudentDto> exportData();
}
