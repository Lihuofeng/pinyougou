package com.bees360.sellergoods.service;

import java.util.List;
import java.util.Map;

import com.bees360.entity.PageResult;
import com.bees360.pojo.TbBrand;

/**
 * 品牌接口
 * 
 * @author Lihuofeng
 *
 */
public interface BrandService {
	public List<TbBrand> findAll();

	// 品牌列表分页
	public PageResult findPage(int pageNum, int pageSize);

	// 添加品牌
	public void add(TbBrand tbBrand);

	// 根据ID查品牌
	public TbBrand findById(Long id);

	// 更新品牌
	public void update(TbBrand tbBrand);

	// 删除品牌
	public void delete(Long[] ids);

	// 条件查询重载品牌列表分页方法
	public PageResult findPage(TbBrand tbBrand, int pageNum, int pageSize);

	// 品牌下拉框数据
	public List<Map> selectOptionList();

}
