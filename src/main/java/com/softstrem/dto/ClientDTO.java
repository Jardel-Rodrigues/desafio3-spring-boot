package com.softstrem.dto;

import java.time.LocalDate;

import com.softstrem.entities.Client;
import com.softstrem.valitations.UniquiValue;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

public class ClientDTO {

	private Long id;
	
	@NotBlank(message = "Campo obrigatório")
	@Size(min = 3, message = "O campo name precisa ter no minimo 3 caracteres")
	private String name;
	
	@NotBlank(message = "Campo obrigatório")
	@Size(min = 11, max = 11, message = "Campo CPF precisa ter exatamente 11 caracteres")
	@UniquiValue (message = "O CPF informado já existe na base de dados")
	private String cpf;
	
	private Double income;
	
	@PastOrPresent(message = "O campo birthDate não pode ser uma data futura")
	private LocalDate birthDate;
	
	private Integer childern;

	public ClientDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer childern) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.income = income;
		this.birthDate = birthDate;
		this.childern = childern;
	}
	
	public ClientDTO(Client entity) {
		id = entity.getId();
		name = entity.getName();
		cpf = entity.getCpf();
		income = entity.getIncome();
		birthDate = entity.getBirthDate();
		childern = entity.getChildern();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Integer getChildern() {
		return childern;
	}

	public void setChildern(Integer childern) {
		this.childern = childern;
	}

}
