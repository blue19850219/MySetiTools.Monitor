/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myseti.framework.monitor.net;

import com.myseti.framework.core.protocol.ProtocolEntity;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 *
 * @author blue
 */
public class EncodeProtocol extends MessageToByteEncoder<ProtocolEntity> {

    @Override
    protected void encode(ChannelHandlerContext chc, ProtocolEntity entity, ByteBuf bb) throws Exception {
      System.out.print("EncodeProtocol active!\n");
    }
    
}
