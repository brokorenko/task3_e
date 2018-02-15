package com.andy.task3_xml_parsing.analyzer.impl.util;

import com.andy.task3_xml_parsing.model.Node;

public class NodeCreator {

    private boolean continueTegBlock;
    private boolean continueContentBlock;
    private Node node;

    private StringBuilder content = new StringBuilder();
    private ContextCreator contextCreator = new ContextCreator();
    private TagType tagType = new TagType();

    private final static char LEFT_BRACKET = '<';
    private final static char RIGHT_BRACKET = '>';

    public Node createNode(char element){

        if (element == LEFT_BRACKET || continueTegBlock) {

            continueTegBlock = true;

            if ((content = contextCreator.getContext(element, RIGHT_BRACKET)) != null){
                continueTegBlock = false;
                node = new Node(Node.NodeType.valueOf(tagType.getTagType(content)), content.toString());
                content.setLength(0);
                return node;
            }
        }

        if (element == RIGHT_BRACKET || continueContentBlock) {

            continueContentBlock = true;

            if ((content = contextCreator.getContext(element, LEFT_BRACKET)) != null){
                continueContentBlock = false;
                node = new Node(Node.NodeType.valueOf(tagType.getTagType(content)), content.toString());
                content.setLength(0);
                return node;
            }
        }

        return null;
    }
}
