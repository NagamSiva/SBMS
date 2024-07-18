package in.ashokit.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Employees;
import in.ashokit.model.EmployeeModel;
import in.ashokit.repository.EmployeeRepo;

@Service
public class ReportService {

	@Autowired
	private EmployeeRepo employeeRepo;

	public void generateExcel(HttpServletResponse response) throws Exception {

		List<Employees> employees = employeeRepo.findAll();
		
		for(Employees emp:employees) {
			System.out.println(emp);
		}

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Employee Info");
		HSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue("EmployeeNumber");
		row.createCell(1).setCellValue("LastName");
		row.createCell(2).setCellValue("FirstName");
		row.createCell(3).setCellValue("Extension");
		row.createCell(4).setCellValue("Email");
		row.createCell(5).setCellValue("OfficeCode");
		row.createCell(6).setCellValue("ReportsTo");
		row.createCell(7).setCellValue("JobTitle");

		
		int dataRowIndex = 1;
		for (Employees emp : employees) {
			HSSFRow dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(emp.getEmployeeNumber());
			dataRow.createCell(1).setCellValue(emp.getLastName());
			dataRow.createCell(2).setCellValue(emp.getFirstName());
			dataRow.createCell(3).setCellValue(emp.getExtension());
			dataRow.createCell(4).setCellValue(emp.getEmail());
			dataRow.createCell(5).setCellValue(emp.getOfficeCode());
			dataRow.createCell(6).setCellValue(emp.getReportsTo());
			dataRow.createCell(7).setCellValue(emp.getJobTitle());

			dataRowIndex++;
		}

		ServletOutputStream ops = response.getOutputStream();
		workbook.write(ops);
		workbook.close();
		ops.close();

	}

}
