package com.edu.zhy.text;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by w_zhanghongyi
 * Time 2024/6/19 17:30
 * Desc 文件描述 直播回放上传参数入参
 */
@Data
public class EduLiveVideoFetchRequest implements Serializable {
	private static final long serialVersionUID = -7308805631819864350L;
	/**
	 * 单个url链接
	 * 建议使用单个链接
	 */
	private String url;

	/**
	 * 文件存储的 key,不传则使用文件 hash 作为 key
	 */
	private String key;

	/**
	 * 效验key
	 * 默认为false 如果已存在同名⽂会重试抓取。当为 true 时，如果空间中已经存在同名文件则放弃本次抓取(仅对比 key，不校验文件内容)。
	 */
	private Boolean checkKey;


	//
	/**
	 * 查询的抓取进度id （上传不需要,查询需要）
	 */
	private String id;



	private Map<String,Object> requestBody;

	private Map<String,Object> headers;


}

