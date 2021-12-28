package br.com.cambioservice.models;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Cambio implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String from;
	private String to;
	private BigDecimal convertionFactor;
	private BigDecimal convertedValue;
	private String environment;
}
