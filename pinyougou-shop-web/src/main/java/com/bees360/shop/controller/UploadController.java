package com.bees360.shop.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bees360.entity.Result;
import com.bees360.utils.FastDFSClient;

/**
 * 文件上传
 * 
 * @author LHF
 *
 */
@RestController
public class UploadController {
	@Value("${FILE_SERVER_URL}")
	private String file_server_url;// 文件服务器地址

	@RequestMapping("/upload")
	public Result upload(MultipartFile file) {
		String originalFilename = file.getOriginalFilename();// 获取文件名
		System.out.println("originalFilename：" + originalFilename);
		String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);// 获取文件扩展名
		System.out.println("extName：" + extName);
		try {
			// 创建一个FastDFS客户端
			FastDFSClient fastDFSClient = new FastDFSClient("classpath:config/fdfs_client.conf");
			// 执行上传处理
			String path = fastDFSClient.uploadFile(file.getBytes(), extName);
			System.out.println("path:" + path);
			// 拼接返回URL和IP地址，拼接完整的url
			String url = file_server_url + path;
			System.out.println("url:" + url);
			return new Result(true, url);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "上传失败");
		}
	}
}
