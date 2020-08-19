package com.asiczen.publish.socket.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConvertedMessage {

	private String vehicleNumber;
	private String vehicleType;
	private String imeiNumber;
	private Double longitude;
	private Double latitude;
	private boolean current;
	private String driverName;
	private String driverContact;
	private String dateTimestamp;
}
