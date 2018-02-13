package com.andy.task3_xml_parsing.analyzer.impl;

import com.andy.task3_xml_parsing.analyzer.Analyzer;
import com.andy.task3_xml_parsing.analyzer.impl.util.AnalyzerHelper;
import com.andy.task3_xml_parsing.analyzer.impl.util.NodeContentCleaner;
import com.andy.task3_xml_parsing.model.Node;

import java.io.IOException;
import java.io.InputStream;

public class XMLAnalyzerImpl implements Analyzer {

    private InputStream xml;
    private AnalyzerHelper analyzerHelper;
    private Node node;
    byte[] symbols;
    private NodeContentCleaner nodeContentCleaner;
    private boolean end;

    private final int SYMBOLS_SIZE = 10;
    private final int FILE_END = -1;
    private final int OFFSET = 0;


    public XMLAnalyzerImpl(InputStream xml) throws IOException {
        this.xml = xml;
        analyzerHelper = new AnalyzerHelper();
        node = null;
        nodeContentCleaner = new NodeContentCleaner();
        symbols = new byte[SYMBOLS_SIZE];
        end = false;
    }

    public Node analyze() throws IOException {

        while (true) {

            if (node == null) {
                if (xml.read(symbols, OFFSET, SYMBOLS_SIZE) == FILE_END){
                    end = true;
                }
            }

            node = analyzerHelper.help(symbols);

            if (node != null) {
                node.setContent(nodeContentCleaner.clean(node.getContent()).trim());

                if (node.getContent().length() != 0) {
                    return node;
                }
            }

            if (end){
                return null;
            }
        }
    }
}