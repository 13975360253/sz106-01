package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 包名:com.itheima.pojo
 *
 * @author Leevi
 * 日期2020-12-13  10:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account implements Serializable {
    private Integer aid;
    private Double money;
    private Integer uid;
}
