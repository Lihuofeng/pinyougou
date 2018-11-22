package com.bees360.manager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bees360.entity.PageResult;
import com.bees360.entity.Result;
import com.bees360.pojo.TbBrand;
import com.bees360.sellergoods.service.BrandService;

@RestController
@RequestMapping("/brand")
public class BrandController {
	@Reference //远程注入
	private BrandService brandService;
	
	@RequestMapping("/findAll") 
	public List<TbBrand> findAll(){
		return brandService.findAll();
	}
	
	@RequestMapping("/findPage")
	public PageResult findPage(int page,int size){
		return brandService.findPage(page, size);
	}
	
	//添加品牌
	@RequestMapping("/add")
	public Result add(@RequestBody TbBrand tbBrand){
		 try {
			brandService.add(tbBrand);
			return new Result(true, "添加品牌成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "添加品牌失败！");
		}
	}
	
	
	@RequestMapping("findById")
	public TbBrand findById(Long id){
		return brandService.findById(id);
	}
	
	//修改品牌
	@RequestMapping("update")
	public Result update(@RequestBody TbBrand tbBrand){
		try {
			brandService.update(tbBrand);
			return new Result(true, "修改品牌成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改品牌失败！");
		}
	}
	
	//添加品牌和修改品牌结合
	@RequestMapping("save")
	public Result save(@RequestBody TbBrand tbBrand){
		TbBrand findById = brandService.findById(tbBrand.getId());
		try {
			if(findById!=null){
				brandService.update(tbBrand);
			}else{
				brandService.add(tbBrand);
			}
			return new Result(true, "保存品牌成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "保存品牌失败！");
		}
	}
	
	//删除品牌
	@RequestMapping("delete")
	public Result delete(Long[] ids){
		try {
			brandService.delete(ids);
			return new Result(true, "删除品牌成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除品牌失败！");
		}
	}
	
	//条件查询
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbBrand tbBrand,int page,int size){
		return brandService.findPage(tbBrand, page, size);
	}
	
}
