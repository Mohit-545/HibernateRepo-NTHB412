//Stock.java
package com.nt.entity;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Stock {
	private Integer stockId;
	@NonNull
	private String stockName;
	@NonNull
	private Double price;
	@NonNull
	private String exchange;
	//for object timestamping
	private Timestamp lastUpdated;

}//class
