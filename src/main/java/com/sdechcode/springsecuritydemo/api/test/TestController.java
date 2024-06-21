package com.sdechcode.springsecuritydemo.api.test;

import com.sdechcode.springsecuritydemo.client.KhmerlangClient;
import com.sdechcode.springsecuritydemo.dto.khmerlang.KhmerLangRequestDto;
import com.sdechcode.springsecuritydemo.dto.khmerlang.KhmerLangResponseDto;
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

    // Return a file after processed
    @GetMapping(value = "/return-file")
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

    }

}
