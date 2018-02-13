package com.andy.task3_xml_parsing.model;

public class Node {
    public enum NodeType {OPEN_TEG, CLOSE_TEG, TEG_CONTENT, NO_BODY_TEG}

    private NodeType nodeType;
    private String content;

    public Node(NodeType nodeType, String content) {
        this.nodeType = nodeType;
        this.content = content;
    }

    public NodeType getNodeType() {
        return nodeType;
    }

    public void setNodeType(NodeType nodeType) {
        this.nodeType = nodeType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;

        Node node = (Node) o;

        if (nodeType != node.nodeType) return false;
        return content != null ? content.equals(node.content) : node.content == null;
    }

    @Override
    public int hashCode() {
        int result = nodeType != null ? nodeType.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Node{" +
                "nodeType=" + nodeType +
                ", content=" + content +
                '}';
    }
}
