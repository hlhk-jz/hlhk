package com.command;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class TestCommand {
  /*  @NotBlank(message = "姓名不能为空name")
    private String name;*/

  /*  @Max(value = 100,message = "年龄不能大于100")
    @Min(value = 1,message = "年龄不能小于1")
    @NotBlank(message = "年龄不能为空name")
    private String age;*/

  /*@Length(max = 1,min = 1,message = "类型长度不能大于或小于1")
  @NotBlank(message = "类型不能为空")
  private String type;*/
}
