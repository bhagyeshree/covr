package com.cognizant.covr;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public final class CovrApplicationTests {


	@Autowired
	private MockMvc mockMvc;

	@Test
	public void listReturnEmptyList() throws Exception{


		//Exercise
		final String  responseContent = mockMvc.perform(get("/api/restaurants"))
				.andExpect(status().isOk())
				.andReturn()
				.getResponse()
				.getContentAsString();

		//Assert
		assertThat(responseContent, is("[]"));
	}

}

