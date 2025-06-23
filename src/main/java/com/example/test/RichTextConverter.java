package com.example.test;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class RichTextConverter {

    public static String convertToPlainText(String richText) {
        // 初始化Tika组件
        AutoDetectParser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler(-1); // -1表示无长度限制
        Metadata metadata = new Metadata();
        ParseContext context = new ParseContext();

        try (InputStream inputStream = new ByteArrayInputStream(
                richText.getBytes(StandardCharsets.UTF_8))) {

            // 执行解析
            parser.parse(inputStream, handler, metadata, context);

            // 返回去除首尾空格的纯文本
            return handler.toString().trim();

        } catch (IOException | TikaException | SAXException e) {
            e.printStackTrace();
            return "解析失败: " + e.getMessage();
        }
    }

    public static void main(String[] args) {

        String str = "\n4245367176194204230";

        str = str.trim();
        System.out.println(str);
    }
}
