package com.codelink.humiandtemp.service.impl;

import com.codelink.humiandtemp.bean.HumiAndTemp;
import com.codelink.humiandtemp.dao.IndexDao;
import com.codelink.humiandtemp.service.IndexServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service(value = "IndexServiceImpl")
public class IndexServiceImpl implements IndexServiceInf {
    @Autowired
    private IndexDao indexDao;
    @Override
    public List<HumiAndTemp> getIndexData(Integer currentPage) {
        return indexDao.getIndexData(currentPage);
    }

    @Override
    public int getpageCount() {
        int i = indexDao.getpageCount();
        if(0 == i % 10){
            return i/10;
        }else{
            return i/10 + 1;
        }
    }

    @Override
    public List<HumiAndTemp> getIndexDataGraph() {
        return indexDao.getIndexDataGraph();
    }
}
