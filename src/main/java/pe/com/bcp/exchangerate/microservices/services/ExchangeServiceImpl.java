package pe.com.bcp.exchangerate.microservices.services;

import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.reactivex.Single;
import pe.com.bcp.exchangerate.microservices.dto.ExchangeRequest;
import pe.com.bcp.exchangerate.microservices.dto.ExchangeResponse;
import pe.com.bcp.exchangerate.microservices.entity.Rate;
import pe.com.bcp.exchangerate.microservices.entity.RateId;
import pe.com.bcp.exchangerate.microservices.repository.RateRepository;

@Service
public class ExchangeServiceImpl implements ExchangeService {
	
	@Autowired
	RateRepository rateRepository;

	@Override
	public Single<ExchangeResponse> applyRate(ExchangeRequest exchangeRequest) {
		
		return Single.create(singleSubscriber -> {
			RateId rateId = new RateId(exchangeRequest.getMonedaOrigen(), exchangeRequest.getMonedaDestino());
			Rate rate = rateRepository.findById(rateId);
			ExchangeResponse response = new ExchangeResponse();
			response.setMonto(exchangeRequest.getMonto());
			response.setMonedaOrigen(exchangeRequest.getMonedaOrigen());
			response.setMonedaDestino(exchangeRequest.getMonedaDestino());
			response.setTipoCambio(rate.getTipoCambio());
			response.setMontoTipoCambio(response.getMonto().divide(rate.getTipoCambio(),4,RoundingMode.HALF_UP));
			singleSubscriber.onSuccess(response);
		});
	}

}
