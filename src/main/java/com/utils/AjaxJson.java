package com.utils;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@ToString
public class AjaxJson implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer code = 0;
    private boolean success = false; // 是否成功
    private String msg = null; // 提示信息
    private Object data = null; // 其他信息
    private Object account = null; // 登录用户名
    private Object pwd = null; // 登陆密码
    private Map<String, Object> attributes = new HashMap<>(); // 其他参数

    private long totalCount = 0; // 总数
    private long count = 0; // 当前页显示条数
    private Integer pageSize = 10; // 每页大小
    private Integer totalPages = 1; // 总页数
    private Integer pageNum = 1; // 第几页


    public void isSuccess(boolean success) {
        this.success = success;
        if (success) {
            this.code = 0;
        } else {
            this.code = 400;
        }
    }

    public void setMsg(String msg) {
        this.code = 400;
        this.count = 0;
        this.msg = msg;
    }

    public void setObj(Object data) {
        this.code = 0;
        this.data = data;
    }

    /**
     * 分页
     * @param totalCount 总记录数
     * @param pageSize 每页大小
     * @param pageNum 第几页
     * @param obj 分页数据
     *
     * */
    public void setPageInfo(int totalCount, int pageSize, int pageNum, Object obj) throws Exception {
        this.data = obj;
        if (totalCount < 0 || pageSize <= 0 || pageNum <= 0) {
            throw new Exception("非法参数！");
        }
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        int m = totalCount / pageNum;
        int n = totalCount % pageNum;

        /* 第一页情况 */
        if (m == 0) {
            this.count = totalCount;
            this.totalPages = 1;
        } else {
            /* 不是首页情况 */
            // 正好能被整除情况
            if (n == 0) {
                this.totalPages = m;
            } else {
                this.totalPages = m + 1;
            }
            // 尾页情况
            if (pageNum == this.totalPages) {
                this.count = n;
            } else {
                this.count = pageSize;
            }
        }
    }




}
