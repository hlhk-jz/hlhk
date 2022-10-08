package com.pojo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;
@Data
public class VehiclePojo {
    private String id;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
}
