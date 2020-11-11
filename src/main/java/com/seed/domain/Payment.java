package com.seed.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.seed.domain.enums.PaymentType;

@Entity
@Table(name = "payment")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private Integer paymentType;
	
	@OneToOne
	@JoinColumn(name = "order_id")
	@MapsId
	private Order order;
	
	public Payment() {
		super();
	}

	public Payment(Integer id, PaymentType paymentType, Order order) {
		super();
		this.id = id;
		this.paymentType = paymentType.getCode();
		this.order = order;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PaymentType getPaymentType() {
		return PaymentType.toEnum(paymentType);
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType.getCode();
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
