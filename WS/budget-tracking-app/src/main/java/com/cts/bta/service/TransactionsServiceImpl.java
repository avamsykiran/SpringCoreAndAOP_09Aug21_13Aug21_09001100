package com.cts.bta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.bta.dao.TransactionsRepo;
import com.cts.bta.model.Transaction;
import com.cts.bta.model.TransactionType;

@Service
public class TransactionsServiceImpl implements TransactionsService{

	@Autowired
	private TransactionsRepo txnRepo;
	
	@Override
	public List<Transaction> getAll() {
		return txnRepo.getAll();
	}

	@Override
	public Transaction getById(Long txId) {
		return txnRepo.getById(txId);
	}

	@Override
	public Transaction add(Transaction txn) {
		return txnRepo.add(txn);
	}

	@Override
	public void delete(Long txId) {
		txnRepo.delete(txId);
	}

	@Override
	public double getTotalIncome() {
		return getAll().stream()
				.filter(t -> t.getType()==TransactionType.INCOME)
				.map(t -> t.getAmount())
				.reduce((a1,a2)->a1+a2).orElse(0.0);
	}

	@Override
	public double getTotalExpendeture() {
		return getAll().stream()
				.filter(t -> t.getType()==TransactionType.EXPENSE)
				.map(t -> t.getAmount())
				.reduce((a1,a2)->a1+a2).orElse(0.0);
	}

	@Override
	public double getCurrentBalance() {
		return getTotalIncome()-getTotalExpendeture();
	}

}
