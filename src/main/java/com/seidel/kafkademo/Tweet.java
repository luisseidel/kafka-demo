package com.seidel.kafkademo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tweet implements Serializable {

	@Id
	private Long id;

	private String text;

	@Override
	public String toString() {
		return "Tweet{" +
				"id=" + id +
				", text='" + text + '\'' +
				'}';
	}
}
