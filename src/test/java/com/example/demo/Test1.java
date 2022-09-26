package com.example.demo;


import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {

    public static void main(String[] args) throws IOException {
        AA aa = new AA();
        Map<String, String> map = new HashMap<>();
        map.put("infoProductName","现金宝");
        map.put("infoMoney","10.00");
        map.put("infoDate","2022-08-22 14:03:33");
        map.put("infoResultDesc","确认成功");
        aa.setProperties(map);
        System.out.println(JSONObject.toJSONString(aa));


    }
}
