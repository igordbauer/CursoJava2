package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contracts {

	
	private Integer number;
	private Date date;
	private Double totalValue;
	
	List<Installment> installments = new ArrayList<>();
	
	public Contracts() {
	}

	public Contracts(Integer number, Date date, Double value) {
		
		this.number = number;
		this.date = date;
		this.totalValue = value;
		
		}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public List<Installment> getInstallments() {
		return installments;
	} 
	
}
