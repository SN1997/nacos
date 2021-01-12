package com.demo.nacos.util;

import com.aspose.words.Document;
import com.aspose.words.ExportHeadersFootersMode;
import com.aspose.words.HtmlSaveOptions;

import java.io.ByteArrayOutputStream;

/**
 * @author lsz
 * @date 2021/1/4 15:10
 */
public class WordToPdf {
    /**
     * word转html文本
     * @param doc 需要转换的doc文件对象
     * @return
     */
    public static String parseWord2Html(Document doc){
        HtmlSaveOptions saveOptions = new HtmlSaveOptions();
        saveOptions.setExportHeadersFootersMode(ExportHeadersFootersMode.NONE); // HtmlSaveOptions的其他设置信息请参考相关API
        ByteArrayOutputStream htmlStream = new ByteArrayOutputStream();
        String htmlText = "";
        try {
            doc.save(htmlStream, saveOptions);
            htmlText = new String(htmlStream.toByteArray(),"UTF-8");
            htmlStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return htmlText;
    }

}
