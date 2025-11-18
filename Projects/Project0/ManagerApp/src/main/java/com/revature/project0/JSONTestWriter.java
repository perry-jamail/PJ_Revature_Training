package com.revature.project0;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.IOException;

public class JSONTestWriter {
    static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode jsonNode = objectMapper.createObjectNode();
        jsonNode.put("name", "Perry");
        jsonNode.put("age", 25);
        jsonNode.put("city", "Frisco");
        jsonNode.put("state", "Texas");
        jsonNode.put("country", "United States");
        objectMapper.writeValue(new File("mydata.json"), jsonNode);
    }
}
