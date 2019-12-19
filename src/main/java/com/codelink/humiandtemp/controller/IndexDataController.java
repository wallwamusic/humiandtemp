package com.codelink.humiandtemp.controller;

import com.codelink.humiandtemp.bean.HumiAndTemp;
import com.codelink.humiandtemp.service.IndexServiceInf;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexDataController {
    @Autowired
    private IndexServiceInf indexServiceInf;

    @RequestMapping("/index.action")
    @ResponseBody
    public Map<String, Object> getIndex(@RequestParam(value = "currentPage",defaultValue = "1") Integer currentPage){
        List<HumiAndTemp> list = indexServiceInf.getIndexData((currentPage -1) * 10);
        int pageCount = indexServiceInf.getpageCount();
        HashMap<String, Object> map = new HashMap<>();
        map.put("pageCount", pageCount);
        map.put("currentPage", currentPage);
        map.put("indexData", list);
        return map;
    }

    @RequestMapping("/indexGraph.action")
    @ResponseBody
    public List<Object> getIndexGraph() throws Exception {
        List<HumiAndTemp> list = indexServiceInf.getIndexDataGraph();
        String[] timeArray = new String[10];
        String[] tempArray = new String[10];
        String[] humiArray = new String[10];
        for (int i = 9 ; i >= 0 ; i--) {
            timeArray[9-i] = list.get(i).getValuetime().toString().substring(5, 19);
            tempArray[9-i] = list.get(i).getTempvalue();
            humiArray[9-i] = list.get(i).getHumivalue();
        }
        List<Object> listgraph = new ArrayList<>();
        listgraph.add(timeArray);
        listgraph.add(tempArray);
        listgraph.add(humiArray);
        return listgraph;
    }
}
