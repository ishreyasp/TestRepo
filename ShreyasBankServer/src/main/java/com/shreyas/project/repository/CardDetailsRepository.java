package com.shreyas.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.shreyas.project.model.CardDetails;

/**@Author Shreyas Purkar */

@Repository
public interface CardDetailsRepository extends JpaRepository<CardDetails, Integer> {
		
	
	  @Query(value = "select carddetails.id, carddetails.cardnumber, carddetails.cardname, carddetails.cvv, carddetails.expirydate, carddetails.amountlimit, cardtype.cardtype from carddetails inner join cardtype on cardtype.cardtypeid = carddetails.cardtypeid where cvv=?1", nativeQuery =true) 
	  public CardDetails findCardDetails(int cvv);
}
