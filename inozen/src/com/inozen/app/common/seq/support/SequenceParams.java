package com.inozen.app.common.seq.support;

public class SequenceParams {
	private long seqNo;
	private String seqKind;
	private String seqType;
	
	public long getSeqNo() {
		return seqNo;
	}
	
	public String getSeqKind() {
		return seqKind;
	}
	
	public String getSeqType() {
		return seqType;
	}
	
	public void setSeqNo(long seqNo) {
		this.seqNo = seqNo;
	}
	
	public void setSeqKind(String seqKind) {
		this.seqKind = seqKind;
	}
	
	public void setSeqType(String seqType) {
		this.seqType = seqType;
	}
}
