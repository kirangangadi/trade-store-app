package com.db.tradestore.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TRADE")
@ToString
@JsonPropertyOrder({ "tradeId", "counterPartId", "bookId", "maturityDate", "expired", "version", "createdDate" })
public class Trade extends StatefulEntity {

	private String tradeId;
	private String counterPartyId;
	private String bookId;
	private Date maturityDate;
	private String expired;
	private Integer version;

	@Id
	@Column(name = "TRADE_ID")
	public String getTradeId() {
		return tradeId;
	}

	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	@Column(name = "COUNTER_PARTY_ID")
	public String getCounterPartyId() {
		return counterPartyId;
	}

	public void setCounterPartyId(String counterPartId) {
		this.counterPartyId = counterPartId;
	}

	@Column(name = "BOOK_ID")
	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
	@Column(name = "MATURITY_DATE")
	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	@Column(name = "EXPIRED")
	public String getExpired() {
		return expired;
	}

	public void setExpired(String expired) {
		this.expired = expired;
	}

	@Version
	@Column(name = "VERSION")
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}
