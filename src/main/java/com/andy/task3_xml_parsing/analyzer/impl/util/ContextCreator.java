package com.andy.task3_xml_parsing.analyzer.impl.util;

public class ContextCreator {

    private boolean newTag = false;
    private StringBuilder content = new StringBuilder();

    public StringBuilder getContext(char contentPart, char limit) {

        if (newTag){
            content.setLength(0);
            newTag = false;
        }

        if (contentPart != limit) {
            content.append(contentPart);

        } else {
            newTag = true;
            return content;
        }
        return null;
    }
}
