package me.minelang.compiler.utils;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import me.minelang.compiler.lang.nodes.MineNode;
import me.minelang.compiler.lang.nodes.control.EmptyNodeFactory;
import me.minelang.compiler.lang.types.MineUndefined;

public final class ConditionUtil {
    /**
     * 测试条件节点是否为真，
     * bool: true/false，
     * MineNone: false，
     * String: 非空字符串为真，
     * 其余: 非零为真
     *
     * @param conditionNode 条件节点
     * @param frame         当前栈帧
     * @return 是否为真
     */
    public static boolean testCondition(MineNode conditionNode, VirtualFrame frame) {
        // 占位节点永远为真（死循环会用这个占条件节点位）
        if (conditionNode == EmptyNodeFactory.create()) {
            return true;
        }
        try {
            return conditionNode.executeBool(frame);
        } catch (UnexpectedResultException e1) {
            try {
                return conditionNode.executeUndefined(frame) == MineUndefined.SINGLETON;
            } catch (UnexpectedResultException e2) {
                try {
                    return conditionNode.executeString(frame).length() != 0;
                } catch (UnexpectedResultException e) {
                    var tmp = conditionNode.execute(frame);
                    return tmp != null && !tmp.equals(0);
                }
            }
        }
    }
}
