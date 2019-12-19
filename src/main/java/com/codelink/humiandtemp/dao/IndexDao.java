package com.codelink.humiandtemp.dao;

import com.codelink.humiandtemp.bean.HumiAndTemp;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IndexDao {
    List<HumiAndTemp> getIndexData(Integer currentPage);

    int getpageCount();

    List<HumiAndTemp> getIndexDataGraph();
}
