package excel;

import com.alibaba.excel.EasyExcel;
import org.junit.jupiter.api.Test;
import org.zb.springmvcdemo.excel.dto.ExcelStudentDto;
import org.zb.springmvcdemo.excel.listener.ExcelStudentDtoListener;

public class ExcelReadTest {
    @Test
    void simpleReadXlsx(){
        String fileName="c:/temp/simpleWrite1626301197411.xlsx";
        EasyExcel.read(fileName, ExcelStudentDto.class,new ExcelStudentDtoListener()).sheet().doRead();
    }
}
