package pe.com.bcp.exchangerate.microservices.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "rate")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rate {

	@EmbeddedId
    private RateId id;
	@Column(name = "tipo_cambio", nullable = false)
	private BigDecimal tipoCambio;
}
