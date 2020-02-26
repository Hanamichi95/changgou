package com.changgou.service;

import com.changgou.goods.pojo.Brand;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author: KSJ
 * @Date: Creat in 1:26 2020/2/27
 */
public interface BrandService {

    /**
     * 查询所有
     */
    List<Brand> findAll();

    /**
     * 根据id查询
     */
    Brand findById(Integer id);

    /**
     * 增加品牌
     */
    void add(Brand brand);

    /**
     * 根据id修改品牌信息
     */
    void update(Brand brand);

    /**
     * 根据id删除品牌
     */
    void delete(Integer id);

    /**
     * 根据品牌信息多条件搜索
     */
    List<Brand> findList(Brand brand);

    /**
     * 分页查询
     */
    PageInfo<Brand> findPage(Integer page,Integer size);

    /**
     * 分页+条件搜索
     */
    PageInfo<Brand> findPage(Brand brand,Integer page,Integer size);

}
