package com.cts.bta.dao;

import java.sql.Date;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cts.bta.model.Transaction;
import com.cts.bta.model.TransactionType;

@Repository
@Primary
public class SpringJdbcTransactionsRepoImpl implements TransactionsRepo{

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	
	public static final String GET_ALL_QRY = "select txId,header,amount,dot,type from transactions";
	public static final String GET_BY_ID_QRY = "select txId,header,amount,dot,type from transactions where txId=:txId";
	public static final String INS_QRY = "insert into transactions values(:txId,:header,:amount,:dot,:type)";
	public static final String DEL_QRY = "delete from transactions where txId=:txId";
	
	public RowMapper<Transaction> rowMapper(){
		return (rs,index) -> {
			Transaction txn = new Transaction();
			txn.setTxId(rs.getLong(1));
			txn.setHeader(rs.getString(2));
			txn.setAmount(rs.getDouble(3));
			txn.setDateOfTransaction(rs.getDate(4).toLocalDate());
			txn.setType(TransactionType.valueOf(rs.getString(5)));
			return txn;
		};
	}
	
	@Override
	public List<Transaction> getAll() {
		return template.query(GET_ALL_QRY, rowMapper());
	}

	@Override
	public Transaction getById(Long txId) {
		return template.queryForObject(GET_BY_ID_QRY, Collections.singletonMap("txId", txId), 
				rowMapper());
	}

	@Override
	public Transaction add(Transaction txn) {
		Map paramMap = new HashMap();
		paramMap.put("txId",txn.getTxId());
		paramMap.put("header",txn.getHeader());
		paramMap.put("amount",txn.getAmount());
		paramMap.put("dot",Date.valueOf(txn.getDateOfTransaction()));
		paramMap.put("type",txn.getType().toString());
		template.execute(INS_QRY, paramMap, null);
		return txn;
	}

	@Override
	public void delete(Long txId) {
		template.execute(DEL_QRY, Collections.singletonMap("txId", txId), null);
	}
	
}
