package com.andy.task3_xml_parsing.analyzer.impl.util;

import com.andy.task3_xml_parsing.model.Node;

public class NodeContentCleaner {

    private final static String SLASH_AND_BRACKETS = "[<>/]";
    private final static String BRACKETS = "[<>]";
    private final static String EMPTY_ELEMENT = "";
    private final static String XML_DECLARATION = "<?xml version";

    public Node getCleanNode(Node node){

        if (node.getContent().startsWith(XML_DECLARATION)){
            node.setContent("");
        }

        if (node.getNodeType() == Node.NodeType.TEG_CONTENT){
            node.setContent(node.getContent().replaceAll(BRACKETS, EMPTY_ELEMENT).trim());
        } else {
            node.setContent(node.getContent().replaceAll(SLASH_AND_BRACKETS, EMPTY_ELEMENT).trim());
        }

        return node;
    }
}
