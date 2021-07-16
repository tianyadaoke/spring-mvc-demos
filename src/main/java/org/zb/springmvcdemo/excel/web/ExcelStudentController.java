package org.zb.springmvcdemo.excel.web;

import com.alibaba.excel.EasyExcel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.zb.springmvcdemo.excel.dto.ExcelStudentDto;
import org.zb.springmvcdemo.excel.service.ExcelStudentService;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

@RestController
@RequestMapping("/student")
@Slf4j
@Api(tags = "学生管理")
public class ExcelStudentController {
    @Autowired
    ExcelStudentService excelStudentService;

    @PostMapping(value = "/import")
    @ApiOperation("数据批量导入")
    public void batchImport(@RequestPart("file") MultipartFile file) {
        try {
            excelStudentService.importData(file.getInputStream());
            log.info("文件上传成功");
        } catch (IOException e) {
            log.info("文件上传失败");
        }
    }

    @GetMapping("/download")
    @ApiOperation("excel数据导出")
    public void download(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("测试", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), ExcelStudentDto.class).sheet("模板")
                .doWrite(excelStudentService.exportData());
    }
}
