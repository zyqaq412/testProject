package com.hzy.mapper;

import com.hzy.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {



    @Insert("insert into tb_brand values(null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void add(Brand brand);



    /**
     * 分页查询
     * @param begin
     * @param size
     * @return
     */


    List<Brand> selectPage(@Param("begin") int begin,@Param("size") int size,@Param("brand") Brand brand);
    /**
     * 查询数据个数
     */

    int selectCount(Brand brand);

    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds(@Param("ids") int[] ids);
    /**
     * 删除
     */
    @Delete("delete from tb_brand where id = #{id}")
    void deleteById(int id);

    @Update("update tb_brand set brand_name = #{brandName},company_name = #{companyName},ordered = #{ordered},description = #{description},status = #{status} where id = #{id}")
    void updateById(Brand brand);

}
