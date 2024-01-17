package com.ssgtarbucks.service;

import java.io.IOException;
import java.util.Map;


import com.google.zxing.WriterException;
import com.ssgtarbucks.domain.StockLocationDTO;
import com.ssgtarbucks.domain.StorageDTO;

public interface QRCodeService {
	//search
	StorageDTO joinStroagebyQRCodeIdToSearch(int qrcode_id);
	
	//not db
	public Map<String,Object> generateQrCode(StorageDTO storageDTO, int qrcode_id) throws WriterException, IOException;
	public Map<String, Object> generateQrCode2(StockLocationDTO stockLocationDTO, int qrcode_id) throws WriterException, IOException;
	public Map<String, Object> generateQrCode3() throws WriterException, IOException;

}
