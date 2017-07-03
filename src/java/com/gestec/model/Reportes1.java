/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.model;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter;

/**
 *
 * @author Sena
 */

public class Reportes1 {
    
    public void getDoc(HttpServletRequest request, HttpServletResponse response, Map parametros) throws IOException, ClassNotFoundException, SQLException, JRException {
        System.out.println("Entro");
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"reporte_servicios.doc\";");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        ServletOutputStream out = response.getOutputStream();
        Map parametro = parametros;
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbgestec", "root", "");//Cambiar conexion "gestec",123
        JasperPrint jasperPrint = JasperFillManager.fillReport(new File(request.getRealPath("Reportes/tipoServicio.jasper")).getPath(), parametro, conexion);
        JRDocxExporter exporter = new JRDocxExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
        exporter.exportReport();
        out.flush();
    }

    public void getPdf(HttpServletRequest request, HttpServletResponse response, Map parametros) throws IOException, ClassNotFoundException, SQLException, JRException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"reporte_servicios.pdf\";");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        try (ServletOutputStream out = response.getOutputStream()) {
            Map parametro = parametros;
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbgestec", "root", "");
            JasperPrint jasperPrint = JasperFillManager.fillReport(new File(request.getRealPath("Reportes/tipoServicio.jasper")).getPath(), parametro, conexion);
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
            exporter.exportReport();
            out.flush();
        }
    }

    public void getXsl(HttpServletRequest request, HttpServletResponse response, Map parametros) throws IOException, ClassNotFoundException, SQLException, JRException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"reporte_servicios.xls\";");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        try (ServletOutputStream out = response.getOutputStream()) {
            Map parametro = parametros;
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbgestec", "root", "");
            JasperPrint jasperPrint = JasperFillManager.fillReport(new File(request.getRealPath("Reportes/tipoServicio.jasper")).getPath(), parametro, conexion);
            JRXlsExporter exporter = new JRXlsExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
            exporter.exportReport();
            out.flush();
        }
    }

    public void getPpt(HttpServletRequest request, HttpServletResponse response, Map parametros) throws IOException, ClassNotFoundException, SQLException, JRException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"reporte_servicios.ppt\";");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        try (ServletOutputStream out = response.getOutputStream()) {
            Map parametro = parametros;
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbgestec", "root", "");
            JasperPrint jasperPrint = JasperFillManager.fillReport(new File(request.getRealPath("Reportes/tipoServicio.jasper")).getPath(), parametro, conexion);
            JRPptxExporter exporter = new JRPptxExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
            exporter.exportReport();
            out.flush();
        }
    }

    public void getHtml(HttpServletRequest request, HttpServletResponse response, Map parametros) throws IOException, ClassNotFoundException, SQLException, JRException {
        response.setContentType("application/pdf");
        try (ServletOutputStream out = response.getOutputStream()) {
            Map parametro = parametros;
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbgestec", "root", "");
            byte[] bytes = JasperRunManager.runReportToPdf(new File(request.getRealPath("Reportes/tipoServicio.jasper")).getPath(),
                    parametro, conexion);
            response.setContentLength(bytes.length);
            out.write(bytes, 0, bytes.length);
            out.flush();
        }
    }
    
}
