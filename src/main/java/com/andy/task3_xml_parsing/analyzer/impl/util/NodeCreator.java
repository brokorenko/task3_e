package com.andy.task3_xml_parsing.analyzer.impl.util;

import com.andy.task3_xml_parsing.model.Node;

public class NodeCreator {

    private boolean continueTegBlock;
    private boolean continueContentBlock;

    private StringBuilder content = new StringBuilder();
    private ContentCreator contentCreator = new ContentCreator();

    private final static char LEFT_BRACKET = '<';
    private final static char RIGHT_BRACKET = '>';

    public Node createNode(char element){

        if (element == LEFT_BRACKET || continueTegBlock) {

            continueTegBlock = true;

            if ((content = contentCreator.getContent(element, RIGHT_BRACKET)) != null){
                continueTegBlock = false;
                return getNode();
            }
        }

        if (element == RIGHT_BRACKET || continueContentBlock) {

            continueContentBlock = true;

            if ((content = contentCreator.getContent(element, LEFT_BRACKET)) != null){
                continueContentBlock = false;
                return getNode();
            }
        }

        return null;
    }

    private Node getNode() {
        Node node = new Node(Node.NodeType.valueOf(TagType.getTagType(content)), content.toString());
        content.setLength(0);
        return node;
    }
}
