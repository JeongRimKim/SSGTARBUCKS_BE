package com.ssgtarbucks.persistence;

import org.apache.ibatis.annotations.Mapper;

import com.ssgtarbucks.domain.ProductDTO;
import com.ssgtarbucks.domain.QRCodeDTO;
import com.ssgtarbucks.domain.StockLocationDTO;
import com.ssgtarbucks.domain.StorageDTO;

@Mapper
public interface QRCodeRepository {

	StorageDTO joinStroagebyQRCodeIdToSearch(int qrcode_id);

	int insertQrcodeToRegisterLocation(QRCodeDTO dto);

	int selectQrcodeIdToCount();

	int selectQrcodeIdToFind(String qrcode_value);

	int updateLocationToAddQrcodeId(StockLocationDTO dto);
	
	ProductDTO selectProductByBranchId(String branch_id, String item_code);

	
}
