package com.hzy.service.impl;

import com.hzy.mapper.BrandMapper;
import com.hzy.pojo.Brand;
import com.hzy.pojo.PageBean;
import com.hzy.service.BrandService;
import com.hzy.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @title: BrandServiceImpl
 * @Author zxwyhzy
 * @Date: 2022/11/12 18:41
 * @Version 1.0
 */
public class BrandServiceImpl implements BrandService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();



    /**
     * 修改数据
     */
    @Override
    public void modifyById(Brand brand) {
        //获取 sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取 BrandDemoMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.updateById(brand);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 删除
     */
    @Override
    public void deleteById(int id) {
        //获取 sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取 BrandDemoMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteById(id);

        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    public void deleteByIds(int[] ids) {
        //获取 sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取 BrandDemoMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteByIds(ids);

        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 分页查询
     * @param currentPage
     * @param sizePage
     * @return
     */
    public PageBean<Brand> selectByPage(int currentPage, int sizePage, Brand brand) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);


        //4. 计算开始索引
        int begin = (currentPage - 1) * sizePage;
        // 计算查询条目数
        int size = sizePage;

        // 处理brand条件，模糊表达式
        String brandName = brand.getBrandName();
        if (brandName != null && brandName.length() > 0) {
            brand.setBrandName("%" + brandName + "%");
        }

        String companyName = brand.getCompanyName();
        if (companyName != null && companyName.length() > 0) {
            brand.setCompanyName("%" + companyName + "%");
        }


        //5. 查询当前页数据
        List<Brand> rows = mapper.selectPage(begin,size,brand);
        System.out.println(rows);
        //6. 查询总记录数
        int totalCount = mapper.selectCount(brand);

        //7. 封装PageBean对象
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);


        //8. 释放资源
        sqlSession.close();

        return pageBean;

    }

    public int selectCount(Brand brand) {
        //获取 sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取 BrandDemoMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        sqlSession.close();
        return mapper.selectCount(brand);
    }

    /**
     * 添加数据
     * @param brand
     */
    public void addBrand(Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.add(brand);
        sqlSession.commit();
        sqlSession.close();
    }
}

