/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myseti.framework.monitor.net;

import com.myseti.framework.core.protocol.ProtocolEntity;
import com.myseti.framework.monitor.utils.Utility;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 *
 * @author blue
 */
public class MonitorServerHandler extends SimpleChannelInboundHandler<ProtocolEntity> {

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.print("channel Inactive!");
        super.channelInactive(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.print("channel active!");
        super.channelActive(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void channelRead0(ChannelHandlerContext chc, ProtocolEntity pe) throws Exception {

        Utility.TipTableModel.addRow(new String[]{"1","2","3","4","5",pe.Serial,"7"});
        
        
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause); //To change body of generated methods, choose Tools | Templates.
    }
    
}
