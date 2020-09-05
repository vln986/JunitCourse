package com.java.mockito.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import com.java.junit.TodoServiceStub;
import com.java.mockito.service.TodoService;

class TodoBusinessImplMockTest {

	@Test
	void retrieveTodosMockTest() {
		TodoService todoServiceMock = mock(TodoService.class);

		List<String> todos = Arrays.asList("SpringMVC", "SpringBoot", "RestApi");

		List<String> list = todoServiceMock.retrieveTodos("dummy");

		when(todoServiceMock.retrieveTodos("dummy")).thenReturn(todos);

		TodoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);

		List<String> filteredTodos = todoBusinessImpl.retrieveTodoRelatedToSpring("Dummy");

		assertEquals(2, filteredTodos.size());

	}

	@Test
	void retrieveTodosMockBDDTest() {

		// Given
		TodoService todoServiceMock = mock(TodoService.class);

		List<String> todos = Arrays.asList("SpringMVC", "SpringBoot", "RestApi");

		List<String> list = todoServiceMock.retrieveTodos("dummy");

		given(todoServiceMock.retrieveTodos("dummy")).willReturn(todos);

		TodoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);

		// When
		List<String> filteredTodos = todoBusinessImpl.retrieveTodoRelatedToSpring("Dummy");

		// Then
		assertEquals(2, filteredTodos.size());

	}
	
	@Test
	public void deleteTodoNotRelatedToSpringTest() {
		
		ArgumentCaptor<String> argumentCapture = ArgumentCaptor.forClass(String.class);

		// Given
		TodoService todoServiceMock = mock(TodoService.class);
		
		List<String> todos = Arrays.asList("SpringMVC", "SpringBoot", "RestApi");
		
		given(todoServiceMock.retrieveTodos("dummy")).willReturn(todos);

		
		TodoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);

		// When
		todoBusinessImpl.deleteTodoNotRelatedToSpring("Dummy");

		// Then
		verify(todoServiceMock,atLeast(1)).deleteTodo("RestApi");
		
		verify(todoServiceMock, never()).deleteTodo("SpringBoot");
		
		verify(todoServiceMock, never()).deleteTodo("SpringMVC");

		//Argument capture
		verify(todoServiceMock, never()).deleteTodo(argumentCapture.capture());
		
		assertThat(argumentCapture.getValue(), is("RestApi"));
	}

}
