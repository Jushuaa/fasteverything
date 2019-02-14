package com.jushuaa.fasteverything.core.model;
import lombok.Data;
/**
 * 文件类型索引之后的记录
 */

public class Thing {
    /**
     * 文件名称
     */
    private String name;
    /**
     * 文件深度
     */
    private Integer depth;
    /**
     * 文件路径
     */
    private String path;
    /**
     * 文件类型
     */
    private FileType fileType;
}
