package com.captainbern.doge.netty;

import com.captainbern.doge.utils.DisguiseUtils;
import net.minecraft.util.io.netty.channel.ChannelHandlerContext;
import net.minecraft.util.io.netty.channel.ChannelOutboundHandlerAdapter;
import net.minecraft.util.io.netty.channel.ChannelPromise;

public class DogeHandler extends ChannelOutboundHandlerAdapter {

    @Override
    public void write(ChannelHandlerContext ctx, Object packet, ChannelPromise promise) throws Exception {

        Object newPacket = DisguiseUtils.filterPacket(packet);

        super.write(ctx, newPacket, promise);
    }

}
