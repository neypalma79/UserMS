package com.angular.ms.codes;

public class ErrorCode {
	private int codeId;
	private String codeDescription;
	
	public ErrorCode(int codeId, String codeDescription) {
		this.codeId=codeId;
		this.codeDescription=codeDescription;
	}

	public int getCodeId() {
		return codeId;
	}

	public void setCodeId(int codeId) {
		this.codeId = codeId;
	}

	public String getCodeDescription() {
		return codeDescription;
	}

	public void setCodeDescription(String codeDescription) {
		this.codeDescription = codeDescription;
	}
}
