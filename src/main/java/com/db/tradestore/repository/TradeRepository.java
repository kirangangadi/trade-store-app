package com.db.tradestore.repository;

import com.db.tradestore.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface TradeRepository extends JpaRepository<Trade, String> {

	Trade getTradesByTradeId(String tradeId);

	@Modifying
	@Query("update Trade t set t.expired = 'Y' where t.maturityDate < current_date() and expired = 'N'")
	void updateExpiredTrades();
}
