package com.andy.task3_xml_parsing.analyzer.impl.util;

public class NodeContentCleaner {

    private final String TAGS = "[<>/]";
    private final String EMPTY_ELEMENT = "";

    public String clean(String content) {
        return content.replaceAll(TAGS, EMPTY_ELEMENT);
    }
}
