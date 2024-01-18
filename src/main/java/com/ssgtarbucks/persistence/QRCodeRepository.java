package com.ssgtarbucks.persistence;

import org.apache.ibatis.annotations.Mapper;

import com.ssgtarbucks.domain.QRCodeDTO;
import com.ssgtarbucks.domain.StorageDTO;

@Mapper
public interface QRCodeRepository {

	StorageDTO joinStroagebyQRCodeIdToSearch(int qrcode_id);

	int insertQrcodeToRegisterLocation(QRCodeDTO dto);

	int selectQrcodeIdToCount();
	
	
}
