package com.ssgtarbucks.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
import com.ssgtarbucks.domain.QRCodeDTO;
import com.ssgtarbucks.domain.StockLocationDTO;
import com.ssgtarbucks.domain.StorageDTO;
import com.ssgtarbucks.persistence.QRCodeRepository;

@Service
public class QRCodeServiceImpl implements QRCodeService {
	
    @Autowired
    private QRCodeRepository qrcodeRepository;

	@Override
	public StorageDTO joinStroagebyQRCodeIdToSearch(int qrcode_id) {
		return qrcodeRepository.joinStroagebyQRCodeIdToSearch(qrcode_id);
	}
	
	@Override
	public Map<String, Object> generateQrCode(StorageDTO storageDTO, int qrcode_id)
			throws WriterException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> generateQrCode2(StockLocationDTO stockLocationDTO, int qrcode_id)
			throws WriterException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> generateQrCode3() throws WriterException, IOException {
		// TODO Auto-generated method stub
		return null;
	}



}
