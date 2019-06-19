package com.view;

import lombok.*;

/**
 * AllArgsConstructor 全参构造函数
 * NoArgsConstructor 无参构造函数
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoView {

    private String id;

    private String username;

    private String password;

    private String authority;

    private String sex;

}
