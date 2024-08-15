package com.edu.zhy.api.api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by w_zhanghongyi
 * Time 2024/8/12 16:28
 * Desc 文件描述
 */
@Data
public class ShopConfigDTO implements Serializable {

	private static final long serialVersionUID = 7221052991753958627L;
	/**
	 * 店铺kdtId
	 */
	private long kdtId;

	/**
	 * 配置项key
	 */
	private String key;

	/**
	 * 配置项value
	 */
	private String value;
}
