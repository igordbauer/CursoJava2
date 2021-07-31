package services;

import java.util.Calendar;
import java.util.Date;

import entities.Contracts;
import entities.Installment;

public class ContractService {

	private OnlinePaymentService onlinePaymentService;

	public ContractService(OnlinePaymentService onlinePaymentService) {// injeção de dependencia injetada!
		this.onlinePaymentService = onlinePaymentService;

	}

	public void proccessContract(Contracts contract, int month) {

		double basicValue = contract.getTotalValue()/month;
		for(int i=1; i<=month; i++) {
			double updatedValue = basicValue + onlinePaymentService.interest(basicValue, i);
			
			double fullValue = updatedValue + onlinePaymentService.paymentFee(updatedValue);
			
			Date dueDate = addMonths(contract.getDate(), i);
			contract.getInstallments().add(new Installment(dueDate, fullValue));
		}
	}
	
	private Date addMonths(Date date, int n) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, n);
		return calendar.getTime();
		}
}
