package com.epam.paymentsystem.service.repository;

import com.epam.paymentsystem.service.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {
}
