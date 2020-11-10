package com.seed.domain.enums;

public enum PaymentType {
	
	PENDING(1, "Pending"),
	PAID(2, "Paid"),
	CANCELLED(3, "Caencelled");

	private int code;
	private String description;

	private PaymentType(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
	
	public static PaymentType toEnum(Integer code) {
		if(code == null) {
			return null;
		}
		
		for(PaymentType pt : PaymentType.values()) {
			if(code.equals(pt.getCode())) {
				return pt;
			}
		}
		
		throw new IllegalArgumentException("Invalid payment type: " + code);
	}
}
