package com.employees.mgmnt.system.controller.representation;

import com.employees.mgmnt.system.model.EmployeeState;
import lombok.Data;

@Data
public class EmployeeStateRequest {
    private EmployeeState state;
}
