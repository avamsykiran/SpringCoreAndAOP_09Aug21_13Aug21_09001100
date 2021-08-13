package com.cts.bta.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.cts.bta.model.Transaction;

@Repository
public class FileBasedTransactionsRepoImpl implements TransactionsRepo{
	
	@Value("${bta.data.file}")
	private String dataFileName;
	
	public FileBasedTransactionsRepoImpl() {
		
	}
	
	private Map<Long,Transaction>  readData() {
		Map<Long,Transaction> txns=null;
		File file = new File(dataFileName);
		if(file.exists()) {
			try(ObjectInputStream fin = new ObjectInputStream(new FileInputStream(file))){
				txns = (Map<Long, Transaction>) fin.readObject();
			} catch (IOException | ClassNotFoundException e) {
				//log the exception 
				System.err.println(e.getMessage());
			}
		}else {
			txns = new TreeMap<>();
		}
		return txns;
	}
	
	private void saveData(Map<Long,Transaction> txns) {
		try(ObjectOutputStream fout = new ObjectOutputStream(new FileOutputStream(dataFileName))){
			fout.writeObject(txns);			
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public List<Transaction> getAll() {
		return new ArrayList<>(readData().values());
	}

	@Override
	public Transaction getById(Long txId) {
		return readData().get(txId);
	}

	@Override
	public Transaction add(Transaction txn) {
		Map<Long,Transaction> txns = readData();
		txns.put(txn.getTxId(), txn);
		saveData(txns);
		return txn;
	}

	@Override
	public void delete(Long txId) {
		Map<Long,Transaction> txns = readData();
		txns.remove(txId);
		saveData(txns);
	}

}
