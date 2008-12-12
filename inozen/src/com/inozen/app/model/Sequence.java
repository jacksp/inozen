package com.inozen.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="tbl_sequence")
@SequenceGenerator(name="sequence_seqNo_seq", sequenceName="sequence_seqNo_seq")
public class Sequence {
	
	@Id @GeneratedValue(generator="sequence_seqNo_seq")
	@Column(name="seq_code")
	private long seqCode;
	
	@Column(name="seq_no")
	private long seqNo;
	
	@Column(name="seq_kind")
	private String seqKind;
	
	@Column(name="seq_type")
	private String seqType;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	private Date createdDate;
	
	public long getSeqNo() {
		return seqNo;
	}
	
	public String getSeqKind() {
		return seqKind;
	}
	
	public String getSeqType() {
		return seqType;
	}
	
	public Date getCreatedDate() {
		return createdDate;
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
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public void setSeqCode(long seqCode) {
		this.seqCode = seqCode;
	}

	public long getSeqCode() {
		return seqCode;
	}

}
