package pe.com.bcp.exchangerate.microservices.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class RateId implements Serializable{
	
	@Column(name = "moneda_origen", nullable = false)
	private String monedaOrigen;
	@Column(name = "moneda_destino", nullable = false)
	private String monedaDestino;

}
