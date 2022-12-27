package com.hust.doan.repository;

import com.hust.doan.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {
}
