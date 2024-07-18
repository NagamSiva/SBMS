package in.ashokit.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import in.ashokit.entity.Product;
import in.ashokit.repository.ProductRepo;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

@Service
public class ProductService {
	

	@Autowired
	private ProductRepo repo;

	public void exportJasperReport(String format, HttpServletResponse response) throws JRException, IOException {

		
		// load images
		byte[] logo1 = Files.readAllBytes(new File("C:/SBMS-Batch/21-Springboot-Pdf-Excel-Report/src/main/resources/reports/logo1.png").toPath());
		byte[] logo2 = Files.readAllBytes(new File("C:/SBMS-Batch/21-Springboot-Pdf-Excel-Report/src/main/resources/reports/logo2.png").toPath());
		
		// Create map object
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("logo1", logo1);
		parameters.put("logo2", logo2);

		//get data from db
		List<Product> products = repo.findAll();

		// Get file and compile it
		File file = ResourceUtils.getFile("C:/SBMS-Batch/21-Springboot-Pdf-Excel-Report/src/main/resources/reports/productReport.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		
		//create dataSource
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(products);
		
		//Generate CurrentDateTime for file Name.
		 DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());

		// Fill Jasper report
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		
		  if ("pdf".equals(format)) {
	            response.setContentType("application/pdf");
	            response.setHeader("Content-Disposition", "attachment; filename=pdf_" + currentDateTime + ".pdf");

	            JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
	            
	        } else if ("excel".equals(format)) {
	            response.setContentType("application/vnd.ms-excel");
	            response.setHeader("Content-Disposition", "attachment; filename=Excel"+currentDateTime+".xlsx");

	            JRXlsxExporter exporter = new JRXlsxExporter();
	            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
	            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
	            SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
	            configuration.setDetectCellType(true);
	            configuration.setCollapseRowSpan(false);
	            exporter.setConfiguration(configuration);
	            exporter.exportReport();
	        } else {
	            throw new IllegalArgumentException("Invalid report format: " + format);
	        }
		
	}
}
