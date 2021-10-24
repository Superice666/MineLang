package me.minelang.compiler.lang.exceptions;

import com.oracle.truffle.api.nodes.ControlFlowException;
import me.minelang.compiler.lang.types.MineNone;

import java.io.Serial;

public final class LoopBreakException extends ControlFlowException {
    @Serial
    private static final long serialVersionUID = -8562545277317690467L;
    public static final LoopBreakException SINGLETON = new LoopBreakException(MineNone.SINGLETON);

    private final Object returnValue;

    private LoopBreakException(Object returnValue) {
        this.returnValue = returnValue;
    }

    public Object getReturnValue() {
        return returnValue;
    }

    public static LoopBreakException create(Object returnValue) {
        if (returnValue == MineNone.SINGLETON) {
            return SINGLETON;
        } else {
            return new LoopBreakException(returnValue);
        }
    }

    public static LoopBreakException create() {
        return SINGLETON;
    }

}
