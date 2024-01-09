package com.fly.web.model.dto.generator;

import com.fly.web.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 用户查询请求
 */
@EqualsAndHashCode( callSuper = true )
@Data
public class GeneratorQueryRequest extends PageRequest implements Serializable {
    /**
     * id
     */
    private Long id;


    /**
     * 用户昵称
     */
    private Long notId;

    /**
     * 简介
     */
    private String searchText;

    /**
     * 标签列表
     */
    private List<String> tags;

    /**
     * 至少有一个标签
     */
    private List<String> orTags;

    /**
     * 用户id
     */
    private Long userId;


    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 基础包
     */
    private String basePackage;

    /**
     * 版本
     */
    private String version;

    /**
     * 作者
     */
    private String author;

    /**
     * 代码生成器产物路径
     */
    private String distPath;

    /**
     * 状态
     */
    private Integer status;


    private static final long serialVersionUID = 1L;
}