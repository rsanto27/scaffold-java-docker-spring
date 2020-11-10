package com.seed.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.seed.domain.enums.PaymentType;

@Entity
@Table(name = "card_payment")
public class CardPayment extends Payment {
	
	private static final long serialVersionUID = 1L;
	
	private Integer installments;

	public CardPayment() {
		super();
	}

	public CardPayment(Integer id, PaymentType paymentType, Order order, Integer installments) {
		super(id, paymentType, order);
		this.installments = installments;
	}

	public Integer getInstallments() {
		return installments;
	}

	public void setInstallments(Integer installments) {
		this.installments = installments;
	}
}
