package com.cts.bta.dao;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.cts.bta.model.Transaction;

@Repository
@Primary
public class SpringJdbcTransactionsRepoImpl implements TransactionsRepo{

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
	
}
