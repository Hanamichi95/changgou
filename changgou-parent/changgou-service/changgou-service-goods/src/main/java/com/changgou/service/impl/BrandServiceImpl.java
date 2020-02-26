package com.changgou.service.impl;

import com.changgou.dao.BrandMapper;
import com.changgou.goods.pojo.Brand;
import com.changgou.service.BrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author: KSJ
 * @Date: Creat in 1:25 2020/2/27
 */

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Override
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    /**
     * 增加品牌
     */
    @Override
    public void add(Brand brand) {
        brandMapper.insertSelective(brand);
    }

    /**
     * 根据id修改品牌信息
     */
    @Override
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    /**
     * 根据id删除商品
     */
    @Override
    public void delete(Integer id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    /**
     * 条件构建
     */
    public Example createExample(Brand brand) {
        //自定义条件搜索对象 Example
        Example example = new Example(Brand.class);
        //条件构造器
        Example.Criteria criteria = example.createCriteria();

        if (brand != null) {
            //brand.name!=null 根据名字模糊搜索
            if (!StringUtils.isEmpty(brand.getName())) {
                criteria.andLike("name", "%" + brand.getName() + "%");
            }

            //brand.letter!=null 根据字母搜索
            if (!StringUtils.isEmpty(brand.getLetter())) {
                criteria.andLike("letter", brand.getLetter());
            }

        }

        return example;

    }

    /**
     * 根据品牌信息多条件搜索
     */
    @Override
    public List<Brand> findList(Brand brand) {

        Example example = createExample(brand);

        return brandMapper.selectByExample(example);
    }

    /**
     * 分页查询
     */
    @Override
    public PageInfo<Brand> findPage(Integer page, Integer size) {

        PageHelper.startPage(page,size);

        List<Brand> brands = brandMapper.selectAll();

        return new PageInfo<Brand>(brands);
    }

    /**
     * 分页+条件搜索
     */
    @Override
    public PageInfo<Brand> findPage(Brand brand, Integer page, Integer size) {

        PageHelper.startPage(page,size);

        Example example = createExample(brand);

        List<Brand> brands = brandMapper.selectByExample(example);

        return new PageInfo<Brand>(brands);
    }
}
