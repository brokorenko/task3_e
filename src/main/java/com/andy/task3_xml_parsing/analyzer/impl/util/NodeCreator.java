package com.andy.task3_xml_parsing.analyzer.impl.util;

import com.andy.task3_xml_parsing.model.Node;

public class NodeCreator {

    private StringBuilder content = new StringBuilder();
    private TagType tagType = new TagType();

    public Node getNode(char contentPart, char limit){

        if (contentPart != limit) {
            content.append(contentPart);

        } else {
            Node node = new Node(Node.NodeType.valueOf(tagType.getTagType(content)), content.toString());
            content.setLength(0);
            return node;
        }

        return null;
    }
}
