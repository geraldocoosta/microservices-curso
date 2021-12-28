package br.com.geraldo.bookservice.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

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
@Entity
public class Book implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, length = 180)
	private String author;
	@Column(nullable = false, length = 250)
	private String title;
	@Column(nullable = false, columnDefinition = "TIMESTAMP")
	private LocalDateTime launchDate;
	@Column(nullable = false)
	private BigDecimal price;
	@Transient
	private String currency;
	@Transient
	private String environment;
}
