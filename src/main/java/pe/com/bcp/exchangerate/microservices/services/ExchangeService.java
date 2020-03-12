package pe.com.bcp.exchangerate.microservices.services;

import io.reactivex.Single;
import pe.com.bcp.exchangerate.microservices.dto.ExchangeRequest;
import pe.com.bcp.exchangerate.microservices.dto.ExchangeResponse;

public interface ExchangeService {
	
	Single<ExchangeResponse> applyRate(ExchangeRequest exchangeRequest);

}
