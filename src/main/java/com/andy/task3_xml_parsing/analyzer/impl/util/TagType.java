package com.andy.task3_xml_parsing.analyzer.impl.util;

public class TagType {

    private final static int EMPTY_RESULT = -1;
    private final static String RIGHT_BRACKET = ">";
    private final static String FORWARD_SLASH = "/";
    private final static int ELEMENT_AFTER_BRACKET = 1;

    public String getTagType(StringBuilder content){

        if (content.indexOf(RIGHT_BRACKET) != EMPTY_RESULT){
            return  "TEG_CONTENT";
        }

        if (content.indexOf(FORWARD_SLASH) == ELEMENT_AFTER_BRACKET){
            return  "CLOSE_TEG";
        }

        if (content.indexOf(FORWARD_SLASH) != EMPTY_RESULT){
            return  "NO_BODY_TEG";
        }

        return "OPEN_TEG";
    }
}
