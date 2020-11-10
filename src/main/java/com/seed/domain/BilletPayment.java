package com.seed.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.seed.domain.enums.PaymentType;

@Entity
@Table(name = "billet_payment")
public class BilletPayment extends Payment{
	
	private static final long serialVersionUID = 1L;
	
	private Date dueDate;
	private Date paymentDate;
	
	public BilletPayment() {
		super();
	}
	
	public BilletPayment(Integer id, PaymentType paymentType, Order order, Date dueDate, Date paymentDate) {
		super(id, paymentType, order);
		this.dueDate = dueDate;
		this.paymentDate = paymentDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
}
