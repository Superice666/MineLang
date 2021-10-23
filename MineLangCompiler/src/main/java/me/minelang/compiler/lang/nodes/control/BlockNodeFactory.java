package me.minelang.compiler.lang.nodes.control;

import com.oracle.truffle.api.frame.FrameDescriptor;
import me.minelang.compiler.lang.nodes.MineNode;
import me.minelang.compiler.lang.types.MineNone;

public class BlockNodeFactory {
    public static BlockNode create(FrameDescriptor descriptor, MineNode... bodyNodes) {
        return new BlockNode(descriptor, bodyNodes);
    }

    public static BlockNode create(MineNode... bodyNodes) {
        return new BlockNode(new FrameDescriptor(MineNone.SINGLETON), bodyNodes);
    }
}