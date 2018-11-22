package com.bees360.sellergoods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.bees360.entity.PageResult;
import com.bees360.entity.Result;
import com.bees360.mapper.TbBrandMapper;
import com.bees360.pojo.TbBrand;
import com.bees360.pojo.TbBrandExample;
import com.bees360.pojo.TbBrandExample.Criteria;
import com.bees360.sellergoods.service.BrandService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private TbBrandMapper tbBrandMapper;
	
	@Override
	public List<TbBrand> findAll() {

		return tbBrandMapper.selectByExample(null);
	}

	
	/**
	 * 品牌列表分页
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<TbBrand> page = (Page<TbBrand>) tbBrandMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}


	@Override
	public void add(TbBrand tbBrand) {
		TbBrand tbBrandByName = tbBrandMapper.selectByName(tbBrand.getName());
		if(tbBrandByName==null){
			tbBrandMapper.insert(tbBrand);
			System.out.println("插入品牌数据成功！");
		}else{
			System.out.println("插入品牌数据失败！");
		}
		
//		tbBrandMapper.insert(tbBrand);
	}


	@Override
	public TbBrand findById(Long id) {
		return tbBrandMapper.selectByPrimaryKey(id);
	}


	@Override
	public void update(TbBrand tbBrand) {
		tbBrandMapper.updateByPrimaryKey(tbBrand);
		
	}


	@Override
	public void delete(Long[] ids) {
		for (Long id : ids) {
			tbBrandMapper.deleteByPrimaryKey(id);
		}
	}


	//条件查询重载品牌列表分页方法
	@Override
	public PageResult findPage(TbBrand tbBrand, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		TbBrandExample example = new TbBrandExample();
		Criteria criteria = example.createCriteria();
		if(tbBrand!=null){
			if(tbBrand.getName()!=null&&tbBrand.getName().length()>0){
				criteria.andNameLike("%"+tbBrand.getName()+"%");
			}
			if(tbBrand.getFirstChar()!=null&&tbBrand.getFirstChar().length()>0){
				criteria.andFirstCharLike("%"+tbBrand.getFirstChar()+"%");
			}
		}
		Page<TbBrand> page = (Page<TbBrand>) tbBrandMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}


}
