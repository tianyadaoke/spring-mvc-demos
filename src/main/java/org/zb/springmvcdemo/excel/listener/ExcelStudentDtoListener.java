package org.zb.springmvcdemo.excel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.extern.slf4j.Slf4j;
import org.zb.springmvcdemo.excel.bean.ExcelStudent;
import org.zb.springmvcdemo.excel.converter.ExcelStudentConverter;
import org.zb.springmvcdemo.excel.dao.ExcelStudentRepository;
import org.zb.springmvcdemo.excel.dto.ExcelStudentDto;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ExcelStudentDtoListener extends AnalysisEventListener<ExcelStudentDto> {
    private List<ExcelStudent> list = new ArrayList<>();
    private final static int BATCH_COUNT=5;
    ExcelStudentRepository excelStudentRepository;

    public ExcelStudentDtoListener() {
    }

    public ExcelStudentDtoListener(ExcelStudentRepository excelStudentRepository) {
        this.excelStudentRepository = excelStudentRepository;
    }

    @Override
    public void invoke(ExcelStudentDto data, AnalysisContext analysisContext) {
        log.info("解析到一条记录,{}",data);
        list.add(ExcelStudentConverter.toExcelStudent(data));
        if (list.size()>=BATCH_COUNT){
            //保存到数据库
            saveData();
            list.clear();
        }
    }


    private void saveData() {
        log.info("{} 条数据被存储到数据库",list.size());
        // 存储 save list
        excelStudentRepository.saveAll(list);
        log.info("{}条数据保存成功",list.size());
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // 不足五条在此处存储
        saveData();
        log.info("所有数据解析完成");
    }
}
