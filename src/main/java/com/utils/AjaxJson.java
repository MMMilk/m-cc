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

    private String msg = null; // 提示信息
    private Object data = null; // 其他信息
    private long totalCount = 0; // 总数
    private long count = 0; // 当前页显示条数
    private Integer pageSize = 10; // 每页大小
    private Integer totalPages = 1; // 总页数
    private Integer pageNum = 1; // 第几页



    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setObj(Object data) {
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
    public void setPageInfo(int totalCount, int pageSize, int pageNum,int totalPages,Object obj){
        this.data = obj;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.totalPages = totalPages;
    }




}
