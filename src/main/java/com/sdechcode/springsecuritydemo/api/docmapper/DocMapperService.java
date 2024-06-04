package com.sdechcode.springsecuritydemo.api.docmapper;

import java.io.*;
import java.net.URLDecoder;
import java.util.List;
import java.util.UUID;

import lombok.extern.log4j.Log4j2;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class DocMapperService {

    public void replaceText() throws IOException {
        log.info(">>>> replaceText I");
        String p = getClass().getClassLoader()
                .getResource("Template_1.docx")
                .getPath();
        String filePath = URLDecoder.decode(p, "UTF-8"); // Protect the white space
        System.out.println(filePath);
        try (InputStream inputStream = new FileInputStream(filePath)) {
            XWPFDocument doc = new XWPFDocument(inputStream);
            doc = replaceText(doc, "Hi", "Hello");
            saveFile(UUID.randomUUID() + ".docx", doc);
            doc.close();
        }
    }

    private XWPFDocument replaceText(XWPFDocument doc, String originalText, String updatedText) {
        log.info(">>>> replaceText II");
        replaceTextInParagraphs(doc.getParagraphs(), originalText, updatedText);
        for (XWPFTable tbl : doc.getTables()) {
            for (XWPFTableRow row : tbl.getRows()) {
                for (XWPFTableCell cell : row.getTableCells()) {
                    replaceTextInParagraphs(cell.getParagraphs(), originalText, updatedText);
                }
            }
        }
        return doc;
    }

    private void replaceTextInParagraphs(List<XWPFParagraph> paragraphs, String originalText, String updatedText) {
        log.info(">>>> replaceTextInParagraphs I");
        paragraphs.forEach(paragraph -> replaceTextInParagraph(paragraph, originalText, updatedText));
    }

    private void replaceTextInParagraph(XWPFParagraph paragraph, String originalText, String updatedText) {
        log.info(">>>> replaceTextInParagraph II");
        List<XWPFRun> runs = paragraph.getRuns();
        for (XWPFRun run : runs) {
            String text = run.getText(0);
            if (text != null && text.contains(originalText)) {
                String updatedRunText = text.replace(originalText, updatedText);
                run.setText(updatedRunText, 0);
            }
        }
    }

    private void saveFile(String filePath, XWPFDocument doc) throws IOException {
        log.info(">>>> saveFile");
        try (FileOutputStream out = new FileOutputStream(filePath)) {
            doc.write(out);
        }
    }

}
