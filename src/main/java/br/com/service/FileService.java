package br.com.service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class FileService {
	public List<String> getLinesFromPdf(File file) throws IOException {
		PDDocument doc = PDDocument.load(file);
	    return Arrays.asList(new PDFTextStripper().getText(doc).split(System.getProperty("line.separator")));
	}
}
