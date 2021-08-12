package com.cts.bta.service;

import java.util.List;

import com.cts.bta.model.Transaction;

public interface TransactionsService {

	List<Transaction> getAll();
	Transaction getById(Long txId);
	Transaction add(Transaction txn);
	void delete(Long txId);
	
	double getTotalIncome();
	double getTotalExpendeture();
	double getCurrentBalance();
}
