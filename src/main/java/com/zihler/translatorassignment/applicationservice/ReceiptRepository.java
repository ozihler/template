package com.zihler.translatorassignment.applicationservice;

import com.zihler.translatorassignment.dataaccess.ReceiptData;
import com.zihler.translatorassignment.domain.AssignmentContractReceipt;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface ReceiptRepository extends CrudRepository<ReceiptData, Long> {
    Collection<AssignmentContractReceipt> findByUserId(Long username);
}
