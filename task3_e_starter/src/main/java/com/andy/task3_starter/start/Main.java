package com.andy.task3_starter.start;


import com.andy.task3_xml_parsing.analyzer.Analyzer;
import com.andy.task3_xml_parsing.analyzer.AnalyzerFactory;
import com.andy.task3_xml_parsing.model.Node;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        File file = new File("resources\\t.xml");
        InputStream inputStream = null;
        Analyzer analyzer;
        Node node;

        try {

            inputStream = new FileInputStream(file);
            AnalyzerFactory analyzerFactory = AnalyzerFactory.getInstance();
            analyzer = analyzerFactory.getXmlAnalyzer(inputStream);
            while(true){

                if ((node = analyzer.analyze()) != null) {
                    System.out.println(node);
                } else {
                    System.out.println("this is the end");
                    break;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("I can't find file");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.out.println("I can't close file");
            }
        }
    }
}
