package com.hzy.service;

import com.hzy.mapper.BrandMapper;
import com.hzy.pojo.Brand;
import com.hzy.pojo.PageBean;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public interface BrandService {




    void modifyById(Brand brand);
    /**
     * 删除
     */
    void deleteById(int id);
    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds(int[] ids);
    /**
     * 分页查询
     * @return
     */
    PageBean<Brand> selectByPage(int currentPage, int sizePage,Brand brand);

    /**
     * 查询总数据数
     * @return
     */
    int selectCount(Brand brand);

    /**
     *
     * @param brand
     */
    void addBrand(Brand brand);





}
