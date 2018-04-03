package com.xiaoyu.suspense.service.impl;

import org.springframework.stereotype.Service;

import com.xiaoyu.suspense.service.ImageManageService;
import com.xiaoyu.suspense.util.FileConstants;
import com.xiaoyu.suspense.util.FileUtil;

@Service("imageManageService")
public class ImageManageServiceImpl implements ImageManageService {

	@Override
	public byte[] getAccountHeadPic(String picName) {
		return FileUtil.getBytes(FileConstants.HEAD_PICTURE, picName);
	}
	
	@Override
	public byte[] getFunPic(String picName) {
		return FileUtil.getBytes(FileConstants.POST_PICTURE, picName);
	}

	@Override
	public void saveAccountHeadPic(String picName, byte[] picture) {
		FileUtil.writeBytes(picture, FileConstants.HEAD_PICTURE, picName);
	}

	@Override
	public void saveFunPic(String picName, byte[] picture) {
		FileUtil.writeBytes(picture, FileConstants.POST_PICTURE, picName);
	}

}