package com.java.mockito.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ListTest {

	@Test
	void listMock() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2);

		assertEquals(2, listMock.size());
		assertEquals(2, listMock.size());
		assertEquals(2, listMock.size());
		assertEquals(2, listMock.size());
	}

	@Test
	void listMockMultiple() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(3).thenReturn(4).thenReturn(5);

		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
		assertEquals(4, listMock.size());
		assertEquals(5, listMock.size());
	}

	@Test
	void listMockGET() {
		List listMock = mock(List.class);
		when(listMock.get(0)).thenReturn("java");

		assertEquals("java", listMock.get(0));
		assertEquals(null, listMock.get(1));
	}

	@Test
	void listMockGET2() {
		List listMock = mock(List.class);
		when(listMock.get(Mockito.anyInt())).thenReturn("java");

		assertEquals("java", listMock.get(0));
		assertEquals("java", listMock.get(1));
	}

	@Test
	void listMockGET_BDD() {
		// Given
		List<String> listMock = mock(List.class);
		when(listMock.get(Mockito.anyInt())).thenReturn("java");

		// When
		String str = listMock.get(0);

		// Then
		assertEquals(str, "java");

	}

	@Test()
	void listMockGETException() {
		List listMock = mock(List.class);
		when(listMock.get(Mockito.anyInt())).thenThrow(new RuntimeException("Exception Message"));

		Assertions.assertThrows(RuntimeException.class, () -> {
			listMock.get(Mockito.anyInt());
		});

	}

}
