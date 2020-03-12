package pe.com.bcp.exchangerate.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import pe.com.bcp.exchangerate.microservices.dto.ExchangeRequest;
import pe.com.bcp.exchangerate.microservices.services.ExchangeService;
import pe.com.bcp.exchangerate.microservices.web.BaseWebResponse;

@Controller
@RequestMapping(value = "/api/exchange")
public class ExchangeRateController {

	@Autowired
	ExchangeService exchangeService;

	@SuppressWarnings("rawtypes")
	@PostMapping(value="/apply",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Single<ResponseEntity<BaseWebResponse>> applyRate(@RequestBody ExchangeRequest exchangeRequest) {
		return exchangeService.applyRate(exchangeRequest).subscribeOn(Schedulers.io())
				.map(applyResponse -> ResponseEntity.ok(BaseWebResponse.successWithData(applyResponse)));
	}
}
