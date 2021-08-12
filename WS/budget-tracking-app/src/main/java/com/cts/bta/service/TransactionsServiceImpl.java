package com.cts.bta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.bta.dao.TransactionsRepo;
import com.cts.bta.model.Transaction;

@Service
public class TransactionsServiceImpl implements TransactionsService{

	@Autowired
	private TransactionsRepo txnRepo;
	
	@Override
	public List<Transaction> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction getById(Long txId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction add(Transaction txn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long txId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getTotalIncome() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTotalExpendeture() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getCurrentBalance() {
		// TODO Auto-generated method stub
		return 0;
	}

}
