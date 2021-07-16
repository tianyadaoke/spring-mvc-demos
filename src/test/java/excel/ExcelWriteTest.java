package excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.junit.jupiter.api.Test;
import org.zb.springmvcdemo.excel.dto.ExcelStudentDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExcelWriteTest {
    @Test
    void simpleWriteTest(){
        String fileName="c:/temp/simpleWrite"+System.currentTimeMillis()+".xlsx";
        EasyExcel.write(fileName,ExcelStudentDto.class).sheet("模板").doWrite(data());
    }
    @Test
    void simpleWriteXlsTest(){
        String fileName="c:/temp/simpleWrite"+System.currentTimeMillis()+".xls";
        EasyExcel.write(fileName,ExcelStudentDto.class).excelType(ExcelTypeEnum.XLS).sheet("模板").doWrite(data());
    }
    private List<ExcelStudentDto> data() {
        List<ExcelStudentDto> list = new ArrayList<ExcelStudentDto>();
        for (int i = 0; i < 10; i++) {
            ExcelStudentDto data = new ExcelStudentDto();
            data.setName("字符串" + i);
            data.setBirthday(new Date());
            data.setSalary(0.56);
            list.add(data);
        }
        return list;
    }
}
