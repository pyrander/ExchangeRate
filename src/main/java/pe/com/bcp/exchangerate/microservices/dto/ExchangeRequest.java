package pe.com.bcp.exchangerate.microservices.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ExchangeRequest {
	
	private BigDecimal monto;
	private String monedaOrigen;
	private String monedaDestino;

}
