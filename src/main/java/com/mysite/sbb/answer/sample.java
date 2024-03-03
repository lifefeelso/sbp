//되새김 문제, URL 오류 수정 P173

package com.mysite.sbb.answer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping ("/sample")
@Controller
public class sample {

    @GetMapping ("/hello")
    @ResponseBody
    public String hello() {
        return "hello sample";
    }
}
