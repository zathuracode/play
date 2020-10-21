package com.google.play.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class CalculatorServiceTest {	

	@Test
	public void sumarDosNumeros() {
		//Arrange
		double numero1=10.0;
		double numero2=5.0;
		double resultado=0.0;
		double esperado=15.0;
		
		//Act
		CalculadoraService calculadora=new CalculadoraService();
	
		resultado=calculadora.suma(numero1,numero2);
		
		//Assert
		assertEquals(esperado, resultado,0.1);
	}
	
	@Test
	public void sumarDosNumerosMatcher() {
		CalculadoraService calculadoraService=Mockito.mock(CalculadoraService.class);
		
		Mockito.when(calculadoraService.suma(Mockito.anyDouble(), Mockito.anyDouble()))
		.thenReturn(20.0);
		
		System.out.println(calculadoraService.suma(4, 2));		
	}
	
	@Test
	public void sumarDosNumerosMatcher2() {
		CalculadoraService calculadoraService=Mockito.mock(CalculadoraService.class);
		ArgumentCaptor<Double> captor=ArgumentCaptor.forClass(Double.class);
		
		Mockito.when(calculadoraService.suma(captor.capture(), captor.capture()))
		.thenReturn(20.0);
		
		calculadoraService.suma(4, 2);
		calculadoraService.suma(8, 78);
		
		System.out.println(captor.getAllValues());		
	}

}
