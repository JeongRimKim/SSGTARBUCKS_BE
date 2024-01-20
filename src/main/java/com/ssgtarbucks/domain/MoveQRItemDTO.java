package com.ssgtarbucks.domain;

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
@Alias("MoveQRItemDTO")
public class MoveQRItemDTO {
	String branch_id;
	String location_qrcode_value;
	List<String> item_qrcode_value_list;
	
	  public List<String> getList() {
	        return item_qrcode_value_list;
	    }

}
