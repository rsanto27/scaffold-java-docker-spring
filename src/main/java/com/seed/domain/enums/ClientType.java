package com.seed.domain.enums;

public enum ClientType {
	
	PHYSICAL_PERSON(1, "Physical Person"),
	BUSINESS_ENTITY(2, "Business Entity");
	
	private int code;
	private String description;

	private ClientType(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
	
	public static ClientType toEnum(Integer code) {
		if(code == null) {
			return null;
		}
		
		for(ClientType ct : ClientType.values()) {
			if(code.equals(ct.getCode())) {
				return ct;
			}
		}
		
		throw new IllegalArgumentException("Invalid client type: " + code);
	}
}
