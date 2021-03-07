package com.chinasoft.springcloud_util.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;


/*
 * 关于文件IO具体操作的 工具类
 * */
public class FilesUtil {

	/*注意上传工具方法 一定是public static通用静态前缀 并返回字符串变量
	 * 记录文件上传的相对路径*/
	public static  String  uploadFile(HttpServletRequest  request,MultipartFile attach){
		/*设置一个新的img文件名称  UUID随机性 保证文件名不重复
		 * 后缀名保证一致性*/
		/*uuid 生成唯一随机不重复的字符串
		 * 拼接一个 .  点号后面继续拼接上传文件的 原后缀名
		 * 根据 getOriginalFilename获取原文件文件名
		 * 然后subString切割原文件名  根据原文件名 . 号字符数位进行切割
		 *最终切割 获取文件后缀名 与UUID一同组成了 新文件名称 */
		String imgStr=UUID.randomUUID().toString()+"."+
				attach.getOriginalFilename().substring(attach.getOriginalFilename().lastIndexOf(".")+1);
		/*根据新的预设文件名  获取项目上传文件夹的相对路径 并进行指向拼接
		 * 相对路径+新文件名  组成一个完整的 上传指向目录*/
		String imgPath=request.getSession().getServletContext().getRealPath("/upload")+"/"+imgStr;
		/*根据拼接的新路径 实例化新文件对象*/
		File imgFile=new File(imgPath);
		try {     /*将上传原有文件  内容 复制给新文件对象*/
			attach.transferTo(imgFile);
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/*如果抛出异常 则有报错*/
			imgStr="暂无图片路径";
			System.out.println("上传失败！！");
		}  
		/*上传文件后 返回上传的相对路径*/
		return "/"+imgStr;
	}
	
	/*工具方法 迭代删除IO文件*/
	public static  void  deleteFile(List<Map<String,Object>> list,HttpServletRequest request){
		/*获取项目upload文件夹 根目录*/
		String url=request.getSession().getServletContext().getRealPath("/upload");
		for (Map<String,Object> map:list) {
			/*迭代中 依次实例化 每行的文件对象 并判断文件是否存在*/
			File file=new File(url+map.get("couponImg"));
			if(file.exists()){
				/*如果该文件对象 真的确实存在 就删掉 不存在就给提示
				 * 如果文件不存在就不能删除  否则会破坏文件夹*/
				file.delete();
			}else{
				System.out.println("文件不存在，无法删除！");	
			}
		}
		
	}
	
	/*文件修改 需要返回新文件的 修改目录*/
	public static String updateFile(Map<String,Object> map,HttpServletRequest request,MultipartFile attach){
		/*因为暂时没有io流的  直接性文件覆盖 工具方法*/
		/*则需要先删除文件 在upload上传新文件 调用同级的static工具方法 实现*/
		/*调用删除方法时 需要传递一个list 则新建一个arrayList 泛型map 此list只有1个下标元素 但也可迭代删除文件*/
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		list.add(map);/*用单行数据 封装成list 调用多行数据文件删除 实现删除方法 代码复用*/
		deleteFile(list, request);
		/*工具方法级联调用工具方法
		 * 工具方法之间的参数与返回值 也是可以通用的*/
		return uploadFile(request,attach);
	}
	
	
}
