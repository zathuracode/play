package com.google.play.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class CalculatorServiceMockTest {
	
	@Mock
	CalculadoraService calculadoraServiceMock;
	
	@Spy
	CalculadoraService calculadoraServiceSpy;
	
	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
	}
	
	
	

	@Test
	public void sumarDosNumerosMockSpy() {
		//Arrange		
		Mockito.when(calculadoraServiceMock.suma(2.0, 2.0))
		.thenReturn(4.0);
		
		
		Mockito.when(calculadoraServiceSpy.suma(2.0, 2.0))
		.thenReturn(4.0);
		
		
		assertEquals(4.0,calculadoraServiceMock.suma(2.0, 2.0),0.1);
		assertEquals(4.0,calculadoraServiceSpy.suma(2.0, 2.0),0.1);
		
		assertEquals(0.0,calculadoraServiceMock.suma(10.0, 2.0),0.1);
		assertEquals(5.0,calculadoraServiceSpy.suma(3.0, 2.0),0.1);
		
		
		
		Mockito.when(calculadoraServiceMock.suma(5.0, 2.0))
		.thenCallRealMethod();
		
		System.out.println(calculadoraServiceMock.suma(5.0, 2.0));
		
		
	}
	
	

}
