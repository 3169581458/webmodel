package com.example.mvcdemo2.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel(value = "消息对象")
public class Message {
    @ApiModelProperty(notes = "消息ID", name = "id", required = true, dataType = "Long", value = "1")
    private Long id;
    @ApiModelProperty(notes = "正文", name = "text", required = true, value = "正文")
    private String text;
    @ApiModelProperty(notes = "摘要", name = "summary", required = true, value = "摘要")
    private String summary;
}
