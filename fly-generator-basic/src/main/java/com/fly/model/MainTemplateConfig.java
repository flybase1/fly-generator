package com.fly.model;

import lombok.Data;

/**
 * 配置文件
 */
@Data
public class MainTemplateConfig {

    /**
     * 作者注释
     */
    private String author = "fly";

    /**
     * 输出文字
     */
    private String outputText = "sum= ";

    /**
     * 是否循环
     */
    private Boolean loop = true;
}
