package com.codelink.humiandtemp.service;

import com.codelink.humiandtemp.bean.HumiAndTemp;

import java.util.List;

public interface IndexServiceInf {
    List<HumiAndTemp> getIndexData(Integer currentPage);

    int getpageCount();

    List<HumiAndTemp> getIndexDataGraph();
}
