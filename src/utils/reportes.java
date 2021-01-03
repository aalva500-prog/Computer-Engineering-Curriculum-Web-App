package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import clases.Asignatura;
import connection.PSQLConnection;




public class reportes {

private String reportType;
private Asignatura asignatura= new Asignatura();
private String directory;	
	
	public reportes() {
	super();
}


	public Asignatura getAsignatura() {
		return asignatura;
	}


	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}


	public reportes(String reportType,String directory) {
	super();
	this.reportType = reportType;
	this.directory=directory;
}

	

	public String getDirectory() {
		return directory;
	}


	public void setDirectory(String directory) {
		this.directory = directory;
	}


	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	
    
  public String valorEvaluacion ()
  {
	  Connection conn = null;
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
			InputStream jasperInputStream = context.getExternalContext().getResourceAsStream(directory);//"/reports/PersonList.jasper"
			ServletOutputStream outputStream = response.getOutputStream();
			conn = PSQLConnection.getConn();
			

			Map requestMap = context.getExternalContext().getRequestParameterMap(); 
			String value = (String)requestMap.get("repo:evalu"); 
			int evaluacion=Integer.parseInt(value);

			
			if ("pdf".equals(reportType)) {
				HashMap<String, Integer> map= new HashMap<String, Integer>();
				map.put("eva",evaluacion);
				JasperRunManager.runReportToPdfStream(jasperInputStream, outputStream, map, conn);
				response.setContentType("application/pdf");
				response.setHeader("Content-Disposition", "attachment; filename=" + "Reporte.pdf");
			} else {
				File rtfFile = File.createTempFile("Reporte", ".rtf");
				JasperPrint jasperPrint = JasperFillManager.fillReport(jasperInputStream, null, conn);
				
				JRRtfExporter rtfExporter = new JRRtfExporter();
				rtfExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
				rtfExporter.setParameter(JRExporterParameter.OUTPUT_FILE, rtfFile);
				rtfExporter.exportReport();
				
				response.setContentType("application/rtf");
				response.setHeader("Content-Disposition", "attachment; filename=" + "Reporte.rtf");
				
				int read = 0;
				byte[] content = new byte[1024];
				InputStream rtfInputStream = new FileInputStream(rtfFile);
				while((read = rtfInputStream.read(content)) != -1){
					outputStream.write(content, 0, read);
				}
				rtfInputStream.close();
				rtfFile.delete();
			}
			outputStream.flush();
			outputStream.close();
			context.responseComplete();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			PSQLConnection.close(conn);
		}
		return null;
  }
  

  public String valorMalla ()
  {
	  Connection conn = null;
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
			InputStream jasperInputStream = context.getExternalContext().getResourceAsStream(directory);//"/reports/PersonList.jasper"
			ServletOutputStream outputStream = response.getOutputStream();
			conn = PSQLConnection.getConn();

			Map requestMap = context.getExternalContext().getRequestParameterMap(); 
			String value = (String)requestMap.get("repo:mallareport"); 
			int malla=Integer.parseInt(value);
			
			
			if ("pdf".equals(reportType)) {
				HashMap<String, Integer> map= new HashMap<String, Integer>();
				map.put("codcarr",malla);
				JasperRunManager.runReportToPdfStream(jasperInputStream, outputStream, map, conn);
				response.setContentType("application/pdf");
				response.setHeader("Content-Disposition", "attachment; filename=" + "Reporte.pdf");
			} else {
				File rtfFile = File.createTempFile("Reporte", ".rtf");
				JasperPrint jasperPrint = JasperFillManager.fillReport(jasperInputStream, null, conn);
				
				JRRtfExporter rtfExporter = new JRRtfExporter();
				rtfExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
				rtfExporter.setParameter(JRExporterParameter.OUTPUT_FILE, rtfFile);
				rtfExporter.exportReport();
				
				response.setContentType("application/rtf");
				response.setHeader("Content-Disposition", "attachment; filename=" + "Reporte.rtf");
				
				int read = 0;
				byte[] content = new byte[1024];
				InputStream rtfInputStream = new FileInputStream(rtfFile);
				while((read = rtfInputStream.read(content)) != -1){
					outputStream.write(content, 0, read);
				}
				rtfInputStream.close();
				rtfFile.delete();
			}
			outputStream.flush();
			outputStream.close();
			context.responseComplete();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			PSQLConnection.close(conn);
		}
		return null;
  }
  
  
   
	public String generateReport() {
		Connection conn = null;
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
			InputStream jasperInputStream = context.getExternalContext().getResourceAsStream(directory);//"/reports/PersonList.jasper"
			ServletOutputStream outputStream = response.getOutputStream();
			conn = PSQLConnection.getConn();
			
			if ("pdf".equals(reportType)) {
				JasperRunManager.runReportToPdfStream(jasperInputStream, outputStream, null, conn);
				response.setContentType("application/pdf");
				response.setHeader("Content-Disposition", "attachment; filename=" + "Reporte.pdf");
			} else {
				File rtfFile = File.createTempFile("Reporte", ".rtf");
				JasperPrint jasperPrint = JasperFillManager.fillReport(jasperInputStream, null, conn);
				
				JRRtfExporter rtfExporter = new JRRtfExporter();
				rtfExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
				rtfExporter.setParameter(JRExporterParameter.OUTPUT_FILE, rtfFile);
				rtfExporter.exportReport();
				
				response.setContentType("application/rtf");
				response.setHeader("Content-Disposition", "attachment; filename=" + "Reporte.rtf");
				
				int read = 0;
				byte[] content = new byte[1024];
				InputStream rtfInputStream = new FileInputStream(rtfFile);
				while((read = rtfInputStream.read(content)) != -1){
					outputStream.write(content, 0, read);
				}
				rtfInputStream.close();
				rtfFile.delete();
			}
			outputStream.flush();
			outputStream.close();
			context.responseComplete();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			PSQLConnection.close(conn);
		}
		return null;
	}
		
	
	
	
	public String Precedente ()
	  {
		  Connection conn = null;
			try {
				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
				InputStream jasperInputStream = context.getExternalContext().getResourceAsStream(directory);//"/reports/PersonList.jasper"
				ServletOutputStream outputStream = response.getOutputStream();
				conn = PSQLConnection.getConn();
				

				Map requestMap = context.getExternalContext().getRequestParameterMap(); 
				String value = (String)requestMap.get("repo:pre"); 
				int prece=Integer.parseInt(value);

				
				if ("pdf".equals(reportType)) {
					HashMap<String, Integer> map= new HashMap<String, Integer>();
					map.put("codPre",prece);
					JasperRunManager.runReportToPdfStream(jasperInputStream, outputStream, map, conn);
					response.setContentType("application/pdf");
					response.setHeader("Content-Disposition", "attachment; filename=" + "Reporte.pdf");
				} else {
					File rtfFile = File.createTempFile("Reporte", ".rtf");
					JasperPrint jasperPrint = JasperFillManager.fillReport(jasperInputStream, null, conn);
					
					JRRtfExporter rtfExporter = new JRRtfExporter();
					rtfExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
					rtfExporter.setParameter(JRExporterParameter.OUTPUT_FILE, rtfFile);
					rtfExporter.exportReport();
					
					response.setContentType("application/rtf");
					response.setHeader("Content-Disposition", "attachment; filename=" + "Reporte.rtf");
					
					int read = 0;
					byte[] content = new byte[1024];
					InputStream rtfInputStream = new FileInputStream(rtfFile);
					while((read = rtfInputStream.read(content)) != -1){
						outputStream.write(content, 0, read);
					}
					rtfInputStream.close();
					rtfFile.delete();
				}
				outputStream.flush();
				outputStream.close();
				context.responseComplete();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				PSQLConnection.close(conn);
			}
			return null;
	  }
	
	
	public String ProgramaAnalitico ()
	  {
		  Connection conn = null;
			try {
				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
				InputStream jasperInputStream = context.getExternalContext().getResourceAsStream(directory);//"/reports/PersonList.jasper"
				ServletOutputStream outputStream = response.getOutputStream();
				conn = PSQLConnection.getConn();
				

				Map requestMap = context.getExternalContext().getRequestParameterMap(); 
				String value = (String)requestMap.get("repo:programa"); 
				int pro=Integer.parseInt(value);

				
				if ("pdf".equals(reportType)) {
					HashMap<String, Integer> map= new HashMap<String, Integer>();
					map.put("codAsig",pro);
					JasperRunManager.runReportToPdfStream(jasperInputStream, outputStream, map, conn);
					response.setContentType("application/pdf");
					response.setHeader("Content-Disposition", "attachment; filename=" + "Reporte.pdf");
				} else {
					File rtfFile = File.createTempFile("Reporte", ".rtf");
					JasperPrint jasperPrint = JasperFillManager.fillReport(jasperInputStream, null, conn);
					
					JRRtfExporter rtfExporter = new JRRtfExporter();
					rtfExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
					rtfExporter.setParameter(JRExporterParameter.OUTPUT_FILE, rtfFile);
					rtfExporter.exportReport();
					
					response.setContentType("application/rtf");
					response.setHeader("Content-Disposition", "attachment; filename=" + "Reporte.rtf");
					
					int read = 0;
					byte[] content = new byte[1024];
					InputStream rtfInputStream = new FileInputStream(rtfFile);
					while((read = rtfInputStream.read(content)) != -1){
						outputStream.write(content, 0, read);
					}
					rtfInputStream.close();
					rtfFile.delete();
				}
				outputStream.flush();
				outputStream.close();
				context.responseComplete();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				PSQLConnection.close(conn);
			}
			return null;
	  }
	
	
	public String SecuenciaActi ()
	  {
		  Connection conn = null;
			try {
				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
				InputStream jasperInputStream = context.getExternalContext().getResourceAsStream(directory);//"/reports/PersonList.jasper"
				ServletOutputStream outputStream = response.getOutputStream();
				conn = PSQLConnection.getConn();
				

				Map requestMap = context.getExternalContext().getRequestParameterMap(); 
				String value = (String)requestMap.get("repo:secuencia"); 
				int sec=Integer.parseInt(value);

				
				if ("pdf".equals(reportType)) {
					HashMap<String, Integer> map= new HashMap<String, Integer>();
					map.put("codAsig",sec);
					JasperRunManager.runReportToPdfStream(jasperInputStream, outputStream, map, conn);
					response.setContentType("application/pdf");
					response.setHeader("Content-Disposition", "attachment; filename=" + "Reporte.pdf");
				} else {
					File rtfFile = File.createTempFile("Reporte", ".rtf");
					JasperPrint jasperPrint = JasperFillManager.fillReport(jasperInputStream, null, conn);
					
					JRRtfExporter rtfExporter = new JRRtfExporter();
					rtfExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
					rtfExporter.setParameter(JRExporterParameter.OUTPUT_FILE, rtfFile);
					rtfExporter.exportReport();
					
					response.setContentType("application/rtf");
					response.setHeader("Content-Disposition", "attachment; filename=" + "Reporte.rtf");
					
					int read = 0;
					byte[] content = new byte[1024];
					InputStream rtfInputStream = new FileInputStream(rtfFile);
					while((read = rtfInputStream.read(content)) != -1){
						outputStream.write(content, 0, read);
					}
					rtfInputStream.close();
					rtfFile.delete();
				}
				outputStream.flush();
				outputStream.close();
				context.responseComplete();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				PSQLConnection.close(conn);
			}
			return null;
	  }
	
	
	
	public String Plan ()
	  {
		  Connection conn = null;
			try {
				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
				InputStream jasperInputStream = context.getExternalContext().getResourceAsStream(directory);//"/reports/PersonList.jasper"
				ServletOutputStream outputStream = response.getOutputStream();
				conn = PSQLConnection.getConn();
				

				Map requestMap = context.getExternalContext().getRequestParameterMap(); 
				String value = (String)requestMap.get("repo:plan"); 
				int sec=Integer.parseInt(value);

				
				if ("pdf".equals(reportType)) {
					HashMap<String, Integer> map= new HashMap<String, Integer>();
					map.put("codAsig",sec);
					JasperRunManager.runReportToPdfStream(jasperInputStream, outputStream, map, conn);
					response.setContentType("application/pdf");
					response.setHeader("Content-Disposition", "attachment; filename=" + "Reporte.pdf");
				} else {
					File rtfFile = File.createTempFile("Reporte", ".rtf");
					JasperPrint jasperPrint = JasperFillManager.fillReport(jasperInputStream, null, conn);
					
					JRRtfExporter rtfExporter = new JRRtfExporter();
					rtfExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
					rtfExporter.setParameter(JRExporterParameter.OUTPUT_FILE, rtfFile);
					rtfExporter.exportReport();
					
					response.setContentType("application/rtf");
					response.setHeader("Content-Disposition", "attachment; filename=" + "Reporte.rtf");
					
					int read = 0;
					byte[] content = new byte[1024];
					InputStream rtfInputStream = new FileInputStream(rtfFile);
					while((read = rtfInputStream.read(content)) != -1){
						outputStream.write(content, 0, read);
					}
					rtfInputStream.close();
					rtfFile.delete();
				}
				outputStream.flush();
				outputStream.close();
				context.responseComplete();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				PSQLConnection.close(conn);
			}
			return null;
	  }
	
}
