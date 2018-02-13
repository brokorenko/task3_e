package com.andy.task3_xml_parsing.analyzer;

import com.andy.task3_xml_parsing.model.Node;

import java.io.IOException;

public interface Analyzer {
    Node analyze() throws IOException;
}
