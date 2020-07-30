package com.cts.airline.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.airline.model.Booking_record;

public interface BookingRecordDao<T> extends JpaRepository<Booking_record, Integer> {
	
	
}
