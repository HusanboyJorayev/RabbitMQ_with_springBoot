package org.example.rabbitmq_with_springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dto {
    private Integer id;
    private String name;
    private Integer age;
    private String address;
}
