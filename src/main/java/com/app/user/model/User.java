package com.app.user.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "th_user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String email;

	private String password;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate birthDate;
	
	@Enumerated(EnumType.STRING)
	private Profession profession;
	
	@Enumerated(EnumType.STRING)
	private MaritalStatus maritalStatus;

	private String note;
}
