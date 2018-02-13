package com.andy.task3_xml_parsing.analyzer.impl.util;

public class TagType {

    private String type;

    private final int EMPTY_RESULT = -1;
    private final String RIGHT_BRACKET = ">";
    private final String FORWARD_SLASH = "/";

    public String getTagType(StringBuilder content){

        //System.out.println(content);

        if (content.indexOf(RIGHT_BRACKET) != EMPTY_RESULT){
            type = "TEG_CONTENT";
        } else {
            type = "OPEN_TEG";
        }

        if (content.indexOf(FORWARD_SLASH) == 1){
            type = "CLOSE_TEG";
        } else if (content.indexOf(FORWARD_SLASH) != EMPTY_RESULT){
            type = "NO_BODY_TEG";
        }

        return type;
    }
}
