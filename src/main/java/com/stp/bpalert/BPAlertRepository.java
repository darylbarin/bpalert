package com.stp.bpalert;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BPAlertRepository extends JpaRepository<BPAlertModel, String>{

}
