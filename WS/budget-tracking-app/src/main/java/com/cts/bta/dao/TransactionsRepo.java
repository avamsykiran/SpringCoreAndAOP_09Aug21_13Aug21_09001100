package com.cts.bta.dao;

import java.util.List;

import com.cts.bta.model.Transaction;

public interface TransactionsRepo {

	List<Transaction> getAll();
	Transaction getById(Long txId);
	Transaction add(Transaction txn);
	void delete(Long txId);
}
