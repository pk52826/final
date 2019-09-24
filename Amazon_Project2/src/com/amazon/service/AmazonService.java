package com.amazon.service;


import com.amazon.dao.AmazonDao;
import com.amazon.dao.AmazonDaoInterface;
import com.amazon.entity.Amazon1Customer;

public class AmazonService implements AmazonServiceInterface{
public static AmazonServiceInterface createServiceObject() {
		
		return new AmazonService();
}
public int createProfile(Amazon1Customer ac) {
	AmazonDaoInterface ad=AmazonDao.createDaoObject();
	return ad.createProfileDao(ac) ;
}
}