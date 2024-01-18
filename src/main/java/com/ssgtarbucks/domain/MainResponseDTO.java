package com.ssgtarbucks.domain;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Alias("MainResponseDTO")
public class MainResponseDTO {
	 private List<TotalDTO> totalList;
	 private List<ProductDTO> lastProductList;
}
