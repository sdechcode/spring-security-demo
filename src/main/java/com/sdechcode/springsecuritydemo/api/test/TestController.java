package com.sdechcode.springsecuritydemo.api.test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sdechcode.springsecuritydemo.client.KhmerlangClient;
import com.sdechcode.springsecuritydemo.dto.khmerlang.KhmerLangRequestDto;
import com.sdechcode.springsecuritydemo.dto.khmerlang.KhmerLangResponseDto;
import com.sdechcode.springsecuritydemo.system.Result;
import com.sdechcode.springsecuritydemo.util.JsonUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

@RestController
@RequestMapping(value = "${api.endpoint.base-url}/test")
@Slf4j
public class TestController {

    @Autowired
    private KhmerlangClient khmerlangClient;

    @GetMapping(value = "")
    public String test() {
        return "testing...!";
    }

    /*@PostMapping
    public void jsonTest(@RequestBody Object object) {
        JsonNode original = JsonUtil.object2Node(object);
        log.info("JsonNode Original {} ", original);

        JsonNode updated = searchForTextArea(original);
        log.info("JsonNode Update {} ", updated);
    }*/

    /*private JsonNode searchForTextArea(JsonNode node) {
        if (node.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                String key = entry.getKey();
                JsonNode value = entry.getValue();
                if ("type".equals(key) && "textarea".equals(value.asText())) {
                    String txt = String.valueOf(node.get("value"));
                    String replaceTxt = txt.replaceAll(" ", "␣");

                    KhmerLangRequestDto khmerLangRequestDto = new KhmerLangRequestDto(replaceTxt, false);
                    KhmerLangResponseDto khmerLangResponseDto = khmerlangClient.wordSegmentation(khmerLangRequestDto);

                    String joinString = String.join("​", khmerLangResponseDto.results());
                    String finalResult = joinString.replaceAll("␣", " ");

                    ((ObjectNode) node).put("value", finalResult);
                    log.info(String.valueOf(node.get("value")));
                }
                // Recursively search nested objects and update them
                JsonNode updatedChild = searchForTextArea(value);
                if (updatedChild != null) {
                    ((ObjectNode) node).set(key, updatedChild);
                }
            }
            return node;
        } else if (node.isArray()) {
            ArrayNode arrayNode = (ArrayNode) node;
            for (int i = 0; i < arrayNode.size(); i++) {
                JsonNode updatedArrayElement = searchForTextArea(arrayNode.get(i));
                if (updatedArrayElement != null) {
                    arrayNode.set(i, updatedArrayElement);
                }
            }
            return node;
        }
        return null; // Or handle the case where node is neither object nor array
    }*/

    /*private static void searchForTextArea(JsonNode node) {
        if (node.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                String key = entry.getKey();
                JsonNode value = entry.getValue();
                if ("type".equals(key) && "textarea".equals(value.asText())) {
                    ((ObjectNode) node).put("value", "khmer test");
                    log.info(String.valueOf(node.get("value")));
                }
                searchForTextArea(value); // Recursively search nested objects
            }
        } else if (node.isArray()) {
            for (JsonNode arrayNode : node) {
                searchForTextArea(arrayNode); // Recursively search elements in arrays
            }
        }
    }*/

    /*@GetMapping(value = "/return-file")
    public void testFile(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("CERTIFICATE.docx");
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }

    @PostMapping(value = "/test-json")
    public void testjson(@RequestBody Object object) {
        String s = JsonUtil.object2Json(object);
        log.info("object2Json Value {} ", s);

        Map<String, Object> stringObjectMap = JsonUtil.object2Map(object);
        Collection<Object> values = stringObjectMap.values();
        for (Object obj : values) {
            if (String.valueOf(obj).contains("type=textarea")) {
                Map<String, Object> map = JsonUtil.object2Map(obj);
                Collection<Object> val = map.values();
                for (Object o : val) {
                    if(String.valueOf(o).contains("value=")) {
                        Map<String, Object> map1 = JsonUtil.object2Map(o);
                        String txt = map1.get("value").toString();
                        if (!txt.isEmpty()) {
                            String replaceTxt = txt.replaceAll(" ", "␣");

                            KhmerLangRequestDto khmerLangRequestDto = new KhmerLangRequestDto(replaceTxt, false);
                            KhmerLangResponseDto khmerLangResponseDto = this.khmerlangClient.wordSegmentation(khmerLangRequestDto);

                            String joinString = String.join("​", khmerLangResponseDto.results());
                            String finalResult = joinString.replaceAll("␣", " ");
                            map1.put("value", finalResult);

                            System.out.println(map1.get("value"));
                        }
                    }
                }
            }
        }
    }*/

}
