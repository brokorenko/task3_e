package com.andy.task3_xml_parsing.analyzer.impl.util;

import com.andy.task3_xml_parsing.model.Node;

public class AnalyzerHelper {

    private int i = 0;
    private NodeCreator nodeCreator = new NodeCreator();
    private Node node;
    private boolean tegBlock;
    private boolean contentBlock;

    private final char LEFT_BRACKET = '<';
    private final char RIGHT_BRACKET = '>';

    public Node help(byte[] masC) {

        if (i > masC.length - 1){
            i = 0;
        }

        for ( ; i < masC.length; i++) {

            if ((char)masC[i] == LEFT_BRACKET || tegBlock) {

                tegBlock = true;

                if ((node = nodeCreator.getNode((char)masC[i], RIGHT_BRACKET)) != null) {
                    tegBlock = false;
                    return node;
                }
            }

            if ((char)masC[i] == RIGHT_BRACKET || contentBlock) {

                contentBlock = true;

                if ((node = nodeCreator.getNode((char)masC[i], LEFT_BRACKET)) != null) {
                    contentBlock = false;
                    return node;
                }
            }
        }
        return null;
    }
}