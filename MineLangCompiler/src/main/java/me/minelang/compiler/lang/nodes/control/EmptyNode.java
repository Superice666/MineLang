package me.minelang.compiler.lang.nodes.control;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import me.minelang.compiler.lang.nodes.MineNode;
import me.minelang.compiler.lang.types.MineUndefined;

@NodeInfo(language = "MineLang", shortName = "empty", description = "A node always returns a None.")
public final class EmptyNode extends MineNode {
    EmptyNode() {

    }

    @Override
    public Object execute(VirtualFrame frame) {
        return MineUndefined.SINGLETON;
    }

    @Override
    public MineUndefined executeUndefined(VirtualFrame frame) {
        return MineUndefined.SINGLETON;
    }
}
