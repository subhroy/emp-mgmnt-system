package com.employees.mgmnt.system;

import com.employees.mgmnt.system.controller.representation.EmployeeRequest;
import com.employees.mgmnt.system.controller.representation.EmployeeStateRequest;
import com.employees.mgmnt.system.exceptions.ServiceExceptionMessage;
import com.employees.mgmnt.system.model.EmployeeState;
import com.employees.mgmnt.system.repository.EmployeeRepository;
import com.employees.mgmnt.system.repository.entity.EmployeeEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EmpMgmntSystemApplicationTests {
  private static final String BASE_URL = "/emp-management/api/v1/employees";
  @Autowired private MockMvc mockMvc;

  @Autowired private ObjectMapper objectMapper;

  @Autowired private EmployeeRepository employeeRepository;

  @AfterEach
  void afterEachSetUp() {
    employeeRepository.deleteAll();
  }

  @Test
  @DisplayName("Should insert Employee into Database")
  public void shouldInsertEmployeeDataInDatabase() throws Exception {
    // Given
    EmployeeRequest employeeRequest = getEmployeeRequest();

    // When
    mockMvc
        .perform(
            post(BASE_URL + "/add")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(employeeRequest)))
        .andExpect(status().isCreated());

    List<EmployeeEntity> employeeList = employeeRepository.findAll();
    EmployeeEntity actualEmployee = employeeList.get(0);

    // Then
    assertThat(employeeList).hasSize(1);
    assertThat(actualEmployee.getEmpId()).isPositive();
    assertThat(actualEmployee.getName()).isEqualTo(employeeRequest.getName());
    assertThat(actualEmployee.getAge()).isEqualTo(employeeRequest.getAge());
    assertThat(actualEmployee.getPhoneNo()).isEqualTo(employeeRequest.getPhoneNo());
    assertThat(actualEmployee.getState()).isEqualTo(EmployeeState.ADDED);
  }

  @Test
  @DisplayName("Should update Employee state in Database")
  public void shouldUpdateEmployeeStateInDatabase() throws Exception {
    // Given
    EmployeeEntity existingEmployee = addEmployeeToDatabase();

    EmployeeStateRequest employeeStateRequest = new EmployeeStateRequest();
    employeeStateRequest.setState(EmployeeState.IN_CHECK);

    // When
    mockMvc
        .perform(
            patch(BASE_URL + "/" + existingEmployee.getEmpId())
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(employeeStateRequest)))
        .andExpect(status().isNoContent());

    List<EmployeeEntity> employeeList = employeeRepository.findAll();
    EmployeeEntity actualEmployee = employeeList.get(0);

    // Then
    assertThat(employeeList).hasSize(1);
    assertThat(actualEmployee.getState()).isEqualTo(EmployeeState.IN_CHECK);
  }

  @Test
  @DisplayName("Should return Not found error when employee id doesn't exist in Database")
  public void shouldReturn404ErrorWhenEmployeeIdDoesntExistInDatabase() throws Exception {
    // Given
    long empId = 121;

    EmployeeStateRequest employeeStateRequest = new EmployeeStateRequest();
    employeeStateRequest.setState(EmployeeState.IN_CHECK);

    // When
    String response =
        mockMvc
            .perform(
                patch(BASE_URL + "/" + empId)
                    .contentType("application/json")
                    .content(objectMapper.writeValueAsString(employeeStateRequest)))
            .andExpect(status().isNotFound())
            .andReturn()
            .getResponse()
            .getContentAsString();

    ServiceExceptionMessage errorResponse = objectMapper.readValue(response, ServiceExceptionMessage.class);

    // Then
    assertThat(errorResponse.getStatusCode()).isEqualTo(404);
    assertThat(errorResponse.getMessage()).isEqualTo("Employee 121 not found!");
  }

  private EmployeeEntity addEmployeeToDatabase() throws Exception {
    EmployeeEntity employeeEntity =
        EmployeeEntity.builder()
            .name("John Wick")
            .age(28)
            .phoneNo("123908989")
            .state(EmployeeState.ADDED)
            .build();
    return employeeRepository.save(employeeEntity);
  }

  private EmployeeRequest getEmployeeRequest() {
    EmployeeRequest employeeRequest = new EmployeeRequest();
    employeeRequest.setName("John Wick");
    employeeRequest.setAge(34);
    employeeRequest.setPhoneNo("+91-123906767");

    return employeeRequest;
  }
}
