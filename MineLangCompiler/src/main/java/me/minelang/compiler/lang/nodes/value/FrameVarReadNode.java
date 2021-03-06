package me.minelang.compiler.lang.nodes.value;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.FrameSlotTypeException;
import com.oracle.truffle.api.frame.MaterializedFrame;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeInfo(language = "MineLang", shortName = "lookUpVarRead"
        , description = "Read the value stored in a local variable in outer scopes.")
@NodeField(name = "frame", type = MaterializedFrame.class)
public abstract class FrameVarReadNode extends AbstractVarNode {
    private boolean hasOwnership = false;
    private boolean ownershipChecked = false;
    abstract MaterializedFrame getFrame();
    
    @Specialization(guards = "checkOwnership()", rewriteOn = {FrameSlotTypeException.class, IllegalArgumentException.class})
    byte readByte(VirtualFrame virtualFrame)
            throws FrameSlotTypeException {
        return getFrame().getByte(getSlot());
    }

    @Specialization(guards = "checkOwnership()", rewriteOn = {FrameSlotTypeException.class, IllegalArgumentException.class})
    int readInt(VirtualFrame virtualFrame)
            throws FrameSlotTypeException {
        return getFrame().getInt(getSlot());
    }

    @Specialization(guards = "checkOwnership()", rewriteOn = {FrameSlotTypeException.class, IllegalArgumentException.class})
    long readLong(VirtualFrame virtualFrame)
            throws FrameSlotTypeException {
        return getFrame().getLong(getSlot());
    }

    @Specialization(guards = "checkOwnership()", rewriteOn = {FrameSlotTypeException.class, IllegalArgumentException.class})
    boolean readBoolean(VirtualFrame virtualFrame)
            throws FrameSlotTypeException {
        return getFrame().getBoolean(getSlot());
    }

    @Specialization(guards = "checkOwnership()", rewriteOn = {FrameSlotTypeException.class, IllegalArgumentException.class})
    float readFloat(VirtualFrame virtualFrame)
            throws FrameSlotTypeException {
        return getFrame().getFloat(getSlot());
    }

    @Specialization(guards = "checkOwnership()", rewriteOn = {FrameSlotTypeException.class, IllegalArgumentException.class})
    double readDouble(VirtualFrame virtualFrame)
            throws FrameSlotTypeException {
        return getFrame().getDouble(getSlot());
    }

    @Specialization(guards = "checkOwnership()", rewriteOn = {FrameSlotTypeException.class, IllegalArgumentException.class})
    Object readObject(VirtualFrame virtualFrame)
            throws FrameSlotTypeException {
        return getFrame().getObject(getSlot());
    }

    @Specialization(replaces = {"readByte", "readInt", "readLong", "readBoolean", "readFloat", "readDouble", "readObject"})
    Object read(VirtualFrame virtualFrame) {
        if(getFrame().getArguments().length > 0){
            if(getFrame().getArguments()[0] instanceof MaterializedFrame outerFrame){
                CompilerDirectives.transferToInterpreterAndInvalidate();
                var newReadNode = FrameVarReadNodeFactory.create(getSlot(), outerFrame);
                return this.replace(newReadNode).execute(getFrame());
            }
        }
        return getFrame().getValue(getSlot());
    }

    boolean checkOwnership() {
        if (!ownershipChecked) {
            ownershipChecked = true;
            try {
                getFrame().getFrameDescriptor().getFrameSlotKind(getSlot());
                hasOwnership = true;
            } catch (AssertionError e) {
                hasOwnership = false;
            }
        }
        return hasOwnership;
    }
}
