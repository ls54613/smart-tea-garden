package com.wanou.project.webSocket.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author txh
 * @date 2021/8/16 21:36
 */
@Data
public class WsMessageObj implements Serializable {
    private static final long serialVersionUID = 1134101122839876785L;

    private String type; //消息类型
    private Object data; //消息（或对象）
}
