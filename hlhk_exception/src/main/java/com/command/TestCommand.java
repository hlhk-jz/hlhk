package com.command;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TestCommand {
    @NotBlank(message = "姓名不能为空")
    private String name;
}
