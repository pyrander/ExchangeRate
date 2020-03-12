package pe.com.bcp.exchangerate.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.bcp.exchangerate.microservices.entity.Rate;
import pe.com.bcp.exchangerate.microservices.entity.RateId;

@Repository
public interface  RateRepository extends JpaRepository<Rate, String> {

	Rate findById(RateId id);

}
