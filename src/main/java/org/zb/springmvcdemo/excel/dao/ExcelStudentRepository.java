package org.zb.springmvcdemo.excel.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zb.springmvcdemo.excel.bean.ExcelStudent;

public interface ExcelStudentRepository extends JpaRepository<ExcelStudent,Long> {
}
