package com;

import com.dao.CustomerDao;

/**
 * @version 0.1
 * @Author: oliver chen
 * @Description:
 * @Date:Create：in 2021/3/13 9:25
 * @Modified By：
 */
public class CustomerDaoImp implements CustomerDao {
    @Override
    public void add() {
        System.out.println("增加信息了");
        //int i=1/0;
    }

    @Override
    public void delete() {
        System.out.println("删除信息了");
    }

    @Override
    public void updata() {
        System.out.println("修改信息了");
    }

    @Override
    public void find() {
        System.out.println("查询信息了");
    }
}
