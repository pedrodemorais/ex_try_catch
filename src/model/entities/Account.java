package model.entities;

import model.exceptions.DomainExceptions;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {
		
	}
	
	public Account(Integer number, String holder, Double balance, Double withdrawLimit){
		
		
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}
	
	

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public Double getBalance() {
		return balance;
	}

	
	public void deposit(Double amount) {
		balance += amount;
		
		
	}
	
	//sacar
	public void withdraw(Double amount) throws DomainExceptions {
		
		if(amount > this.withdrawLimit) {
			throw new  DomainExceptions("Saque maior que o Limite permitido!");
			
			
		}else if ( amount > this.balance)  {
			throw new DomainExceptions ("Saque não Permitido! Conta não possui Saldo suficiente!");
			
		}else balance -= amount; 
		
	}

}
