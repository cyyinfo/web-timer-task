package com.cyy.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import java.security.PublicKey;

/**
 * Created by Administrator on 2017/8/23.
 */
public class BaseService {


    public void setPage(int currPage,int pageSize){
        currPage = currPage <= 0 ? 0 : currPage;
        pageSize = pageSize >= 100 ? 100 : pageSize;
        PageHelper.offsetPage(currPage,pageSize);
    }

}
