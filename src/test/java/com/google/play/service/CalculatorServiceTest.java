package com.google.play.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorServiceTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	

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

}
