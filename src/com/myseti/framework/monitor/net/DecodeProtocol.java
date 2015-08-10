/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myseti.framework.monitor.net;

import com.myseti.framework.core.protocol.ProtocolEntity;
import com.myseti.framework.monitor.utils.Utility;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;

/**
 *
 * @author blue
 */
public class DecodeProtocol extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext chc, ByteBuf bb, List<Object> list) throws Exception {

        if (bb.readableBytes() < Utility.PACKAGE_LENGTH) {
            return;
        } else {

            bb.markReaderIndex();
            ByteBufInputStream stream = new ByteBufInputStream(bb);
            try {
                byte[] len = new byte[4];
                stream.read(len, 0, 4);
                int length = com.myseti.framework.core.HexTools.byte2Int(len);
                System.out.print("收到包长度：" + length + "\n");
                byte[] result = new byte[length - 4];
                stream.read(result, 0, length - 4);
                ProtocolEntity entity = new ProtocolEntity(result);
                list.add(entity);
                System.out.print("DecodeProtocol active! add a new entity \n");
            } catch (Exception ex) {
                System.out.print(ex.toString());
            }
        }

    }

}
