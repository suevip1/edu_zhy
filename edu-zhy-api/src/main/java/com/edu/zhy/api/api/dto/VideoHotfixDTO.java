package com.edu.zhy.api.api.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by w_zhanghongyi
 * Time 2024/8/13 17:26
 * Desc 文件描述
 */
@Data
public class VideoHotfixDTO implements Serializable {
	private static final long serialVersionUID = 1866696531115314743L;

	@ExcelProperty("店铺Id")
	private String kdtId;
	@ExcelProperty("频道号")
	private String channelId;
	@ExcelProperty("点播VID")
	private String vidId;
	@ExcelProperty("直播类型(1:三分屏;2:普通视频直播;0:历史老的,为空也是历史老的)")
	private String type;
	@ExcelProperty("生成年份")
	private String month;
	@ExcelProperty("具体时间")
	private String time;
	@ExcelProperty("文件大小(byte)")
	private String byteSize;


	@ExcelProperty("下载链接")
	private String url;
	@ExcelProperty("21年6月前的普通直播回放名单(有值的话就是)")
	private String videoBlack;




}
