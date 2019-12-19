package com.codelink.humiandtemp.dao;

import com.codelink.humiandtemp.bean.HumiAndTemp;
import org.springframework.stereotype.Repository;

@Repository
public interface HumiAndTempDao {

    int uploadData(HumiAndTemp humiAndTemp);

}
