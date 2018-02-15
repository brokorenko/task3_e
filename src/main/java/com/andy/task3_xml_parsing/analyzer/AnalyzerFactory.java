package com.andy.task3_xml_parsing.analyzer;

import com.andy.task3_xml_parsing.analyzer.impl.XMLAnalyzerImpl;

import java.io.IOException;
import java.io.InputStream;

public class AnalyzerFactory {

    private static final AnalyzerFactory instance = new AnalyzerFactory();

    private AnalyzerFactory(){
    }

    public static AnalyzerFactory getInstance() {
        return instance;
    }

    public Analyzer getXmlAnalyzer(InputStream inputStream) throws IOException {
        return new XMLAnalyzerImpl(inputStream);
    }
}
