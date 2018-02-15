package com.andy.task3_xml_parsing.analyzer.impl.util;

import com.andy.task3_xml_parsing.model.Node;

public class AnalyzerHelper {

    private int i = 0;
    private NodeCreator nodeCreator = new NodeCreator();

    private Node node;

    public Node analyzeSymbols(byte[] symbols) {

        if (i > symbols.length - 1){
            i = 0;
        }

        for ( ; i < symbols.length; i++) {

            if((node = nodeCreator.createNode((char)symbols[i])) != null){
                return node;
            }
        }
        return null;
    }
}