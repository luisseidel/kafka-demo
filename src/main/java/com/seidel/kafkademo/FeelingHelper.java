package com.seidel.kafkademo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FeelingHelper {

	private static final Set<String> positivos = new HashSet<>(Arrays.asList("bom", "excelente", "ótimo", "otimo", "ok"));
	private static final Set<String> negativos = new HashSet<>(Arrays.asList("ruim", "péssimo", "pessimo", "horrível", "horrivel"));

	public Set<String> getPositivos() {
		return positivos;
	}

	public Set<String> getNegativos() {
		return negativos;
	}
}
