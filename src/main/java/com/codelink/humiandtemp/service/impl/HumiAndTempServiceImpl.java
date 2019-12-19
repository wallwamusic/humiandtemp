package com.codelink.humiandtemp.service.impl;

import com.codelink.humiandtemp.bean.HumiAndTemp;
import com.codelink.humiandtemp.dao.HumiAndTempDao;
import com.codelink.humiandtemp.service.HumiAndTempServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "HumiAndTempServiceImpl")
public class HumiAndTempServiceImpl implements HumiAndTempServiceInf {

    @Autowired
    private HumiAndTempDao humiAndTempDao;

    @Override
    @Transactional
    public int uploadData(HumiAndTemp humiAndTemp) {
        return humiAndTempDao.uploadData(humiAndTemp);
    }
}
