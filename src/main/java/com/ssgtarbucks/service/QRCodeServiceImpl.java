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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
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
import com.ssgtarbucks.domain.ProductDTO;
import com.ssgtarbucks.domain.QRCodeDTO;
import com.ssgtarbucks.domain.StockLocationDTO;
import com.ssgtarbucks.domain.StorageDTO;
import com.ssgtarbucks.persistence.QRCodeRepository;

@Service
public class QRCodeServiceImpl implements QRCodeService {

	@Autowired
	private QRCodeRepository qrcodeRepository;

	@Value("${qrcode.path.url}")
	String qrcode_path;

	@Override
	public StorageDTO joinStroagebyQRCodeIdToSearch(int qrcode_id) {
		return qrcodeRepository.joinStroagebyQRCodeIdToSearch(qrcode_id);
	}

	@Override
	public void insertQrcodeToRegisterLocation(List<StockLocationDTO> resList) {
		QRCodeDTO qrDto = new QRCodeDTO();
		// 1. resList 정보 받아오기
		for (StockLocationDTO locationDto : resList) {
			String parsing_branch_value = locationDto.getLocation_code();
			String remove_path_Quotes = removeQuotes(qrcode_path);
			String qrcode_type = "location";
			String parsing_qrcode_path = remove_path_Quotes + qrcode_type + "\\" + parsing_branch_value + ".png";
			System.out.println("여기 >>>>>>>>>>>>>>> " + parsing_branch_value + "," + parsing_qrcode_path);

			qrDto.setQrcode_path(parsing_qrcode_path);
			qrDto.setQrcode_type(qrcode_type);
			qrDto.setQrcode_value(parsing_branch_value);
			// 2. SQL문 추가
			qrcodeRepository.insertQrcodeToRegisterLocation(qrDto);
			// 3. QR코드 생성
			try {
				generateQrCodeForLocation(parsing_qrcode_path,parsing_branch_value);
			} catch (WriterException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		//stock_locatin update(qrcode_id)추가 (id조회 후 추가)
			int qrcode_id = qrcodeRepository.selectQrcodeIdToFind(parsing_branch_value);
			locationDto.setQrcode_id(qrcode_id);
			qrcodeRepository.updateLocationToAddQrcodeId(locationDto);			
		}

	}

	// 큰따옴표 제거
	private static String removeQuotes(String words) {
		// replace 메서드를 사용하여 큰따옴표를 빈 문자열로 대체
		return words.replace("\"", "");
	}

	// QR생성
	public void generateQrCodeForLocation(String filePath, String qrcodeValue)
			throws WriterException, IOException {

		int width = 500;
		int height = 500;

		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(qrcodeValue, BarcodeFormat.QR_CODE, width, height);

		Path path = FileSystems.getDefault().getPath(filePath);
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

		// QR코드 (비트마틱스) -> 바이트스트림
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				bufferedImage.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
			}
		}
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ImageIO.write(bufferedImage, "png", outputStream);

		byte[] qrcodeBytes = outputStream.toByteArray();
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>qrcodeValue("+ qrcodeValue +")로 QR코드 생성");


	}

	@Override
	public ProductDTO selectProductByBranchId(String branch_id, String item_code) {
		return qrcodeRepository.selectProductByBranchId(branch_id, item_code);
	}

}
