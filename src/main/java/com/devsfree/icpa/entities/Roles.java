package com.devsfree.icpa.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.devsfree.icpa.enums.RolesEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** @author Samuel **/

@Entity
@Data
@Table(name = "tb_roles")
@AllArgsConstructor
@NoArgsConstructor
public class Roles implements GrantedAuthority, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Enumerated(EnumType.STRING)
	private RolesEnum rolesEnum;

	@Override
	public String getAuthority() {
		return this.rolesEnum.toString();
	}

}
