package com.ssgtarbucks.persistence;

import org.apache.ibatis.annotations.Mapper;

import com.ssgtarbucks.domain.StorageDTO;

@Mapper
public interface QRCodeRepository {

	StorageDTO joinStroagebyQRCodeIdToSearch(int qrcode_id);
	
	
}
