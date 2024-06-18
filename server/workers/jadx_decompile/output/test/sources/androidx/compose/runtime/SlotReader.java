package androidx.compose.runtime;

import androidx.autofill.HintConstants;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SlotTable.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u0015\n\u0002\b\u0010\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010;\u001a\u00020<2\b\b\u0002\u0010=\u001a\u00020\nJ\u0006\u0010>\u001a\u00020?J\u0006\u0010@\u001a\u00020?J\u000e\u0010A\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\nJ\u0006\u0010B\u001a\u00020?J\u0006\u0010C\u001a\u00020?J\f\u0010D\u001a\b\u0012\u0004\u0012\u00020F0EJO\u0010G\u001a\u00020?2\u0006\u0010H\u001a\u00020\n28\u0010I\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(=\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(M\u0012\u0004\u0012\u00020?0JH\u0000¢\u0006\u0002\bNJ\u0010\u0010O\u001a\u0004\u0018\u00010\u00012\u0006\u0010=\u001a\u00020\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00012\u0006\u0010=\u001a\u00020\nJ\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nJ\u0010\u0010P\u001a\u0004\u0018\u00010\u00012\u0006\u0010=\u001a\u00020\nJ\u0018\u0010P\u001a\u0004\u0018\u00010\u00012\u0006\u0010H\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nJ\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010;\u001a\u00020<J\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u00012\u0006\u0010=\u001a\u00020\nJ\u000e\u0010\u001e\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nJ\u000e\u0010Q\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\nJ\u000e\u0010R\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\nJ\u000e\u0010*\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\nJ\b\u0010S\u001a\u0004\u0018\u00010\u0001J\u0010\u0010T\u001a\u0004\u0018\u00010\u00012\u0006\u0010=\u001a\u00020\nJ\u000e\u0010+\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nJ\u000e\u0010-\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nJ\u000e\u0010U\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nJ\u000e\u0010V\u001a\u00020?2\u0006\u0010=\u001a\u00020\nJ\u000e\u0010W\u001a\u00020?2\u0006\u0010=\u001a\u00020\nJ\u0006\u0010X\u001a\u00020\nJ\u0006\u0010Y\u001a\u00020?J\u0006\u0010Z\u001a\u00020?J\u0006\u0010[\u001a\u00020?J\b\u0010\\\u001a\u00020]H\u0016J\u0016\u0010^\u001a\u0004\u0018\u00010\u0001*\u00020%2\u0006\u0010=\u001a\u00020\nH\u0002J\u0016\u0010T\u001a\u0004\u0018\u00010\u0001*\u00020%2\u0006\u0010=\u001a\u00020\nH\u0002J\u0016\u0010_\u001a\u0004\u0018\u00010\u0001*\u00020%2\u0006\u0010=\u001a\u00020\nH\u0002R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\rR\u0011\u0010\u0018\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\rR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0015R\u0011\u0010\u001e\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\rR\u0011\u0010 \u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b!\u0010\rR\u0011\u0010\"\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b#\u0010\rR\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010'\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b(\u0010\tR\u0011\u0010)\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b)\u0010\tR\u0011\u0010*\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b*\u0010\tR\u0011\u0010+\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b,\u0010\rR\u001e\u0010-\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\rR\u0011\u0010/\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b0\u0010\rR\u0011\u00101\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b2\u0010\rR\u0011\u00103\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b4\u0010\rR\u0018\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000106X\u0082\u0004¢\u0006\u0004\n\u0002\u00107R\u000e\u00108\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:¨\u0006`"}, d2 = {"Landroidx/compose/runtime/SlotReader;", "", "table", "Landroidx/compose/runtime/SlotTable;", "(Landroidx/compose/runtime/SlotTable;)V", "<set-?>", "", "closed", "getClosed", "()Z", "", "currentEnd", "getCurrentEnd", "()I", "currentGroup", "getCurrentGroup", "currentSlot", "currentSlotEnd", "emptyCount", "groupAux", "getGroupAux", "()Ljava/lang/Object;", "groupEnd", "getGroupEnd", "groupKey", "getGroupKey", "groupNode", "getGroupNode", "groupObjectKey", "getGroupObjectKey", "groupSize", "getGroupSize", "groupSlotCount", "getGroupSlotCount", "groupSlotIndex", "getGroupSlotIndex", "groups", "", "groupsSize", "inEmpty", "getInEmpty", "isGroupEnd", "isNode", "nodeCount", "getNodeCount", "parent", "getParent", "parentNodes", "getParentNodes", "size", "getSize", "slot", "getSlot", "slots", "", "[Ljava/lang/Object;", "slotsSize", "getTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "anchor", "Landroidx/compose/runtime/Anchor;", "index", "beginEmpty", "", "close", "containsMark", "endEmpty", "endGroup", "extractKeys", "", "Landroidx/compose/runtime/KeyInfo;", "forEachData", "group", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "data", "forEachData$runtime_release", "get", "groupGet", "hasMark", "hasObjectKey", "next", "node", "parentOf", "reposition", "restoreParent", "skipGroup", "skipToGroupEnd", "startGroup", "startNode", "toString", "", "aux", "objectKey", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SlotReader {
    private boolean closed;

    /* renamed from: currentEnd, reason: from kotlin metadata and from toString */
    private int end;

    /* renamed from: currentGroup, reason: from kotlin metadata and from toString */
    private int current;
    private int currentSlot;
    private int currentSlotEnd;
    private int emptyCount;
    private final int[] groups;
    private final int groupsSize;
    private int parent;
    private final Object[] slots;
    private final int slotsSize;
    private final SlotTable table;

    public SlotReader(SlotTable table) {
        Intrinsics.checkNotNullParameter(table, "table");
        this.table = table;
        this.groups = this.table.getGroups();
        this.groupsSize = this.table.getGroupsSize();
        this.slots = this.table.getSlots();
        this.slotsSize = this.table.getSlotsSize();
        this.end = this.groupsSize;
        this.parent = -1;
    }

    /* renamed from: getTable$runtime_release, reason: from getter */
    public final SlotTable getTable() {
        return this.table;
    }

    public final boolean getClosed() {
        return this.closed;
    }

    /* renamed from: getCurrentGroup, reason: from getter */
    public final int getCurrent() {
        return this.current;
    }

    /* renamed from: getCurrentEnd, reason: from getter */
    public final int getEnd() {
        return this.end;
    }

    public final int getParent() {
        return this.parent;
    }

    /* renamed from: getSize, reason: from getter */
    public final int getGroupsSize() {
        return this.groupsSize;
    }

    public final int getSlot() {
        int slotAnchor;
        int i = this.currentSlot;
        slotAnchor = SlotTableKt.slotAnchor(this.groups, this.parent);
        return i - slotAnchor;
    }

    public final int parent(int index) {
        int parentAnchor;
        parentAnchor = SlotTableKt.parentAnchor(this.groups, index);
        return parentAnchor;
    }

    public final boolean isNode() {
        boolean isNode;
        isNode = SlotTableKt.isNode(this.groups, this.current);
        return isNode;
    }

    public final boolean isNode(int index) {
        boolean isNode;
        isNode = SlotTableKt.isNode(this.groups, index);
        return isNode;
    }

    public final int getNodeCount() {
        int nodeCount;
        nodeCount = SlotTableKt.nodeCount(this.groups, this.current);
        return nodeCount;
    }

    public final int nodeCount(int index) {
        int nodeCount;
        nodeCount = SlotTableKt.nodeCount(this.groups, index);
        return nodeCount;
    }

    public final Object node(int index) {
        boolean isNode;
        isNode = SlotTableKt.isNode(this.groups, index);
        if (isNode) {
            return node(this.groups, index);
        }
        return null;
    }

    public final boolean isGroupEnd() {
        return getInEmpty() || this.current == this.end;
    }

    public final boolean getInEmpty() {
        return this.emptyCount > 0;
    }

    public final int getGroupSize() {
        int groupSize;
        groupSize = SlotTableKt.groupSize(this.groups, this.current);
        return groupSize;
    }

    public final int groupSize(int index) {
        int groupSize;
        groupSize = SlotTableKt.groupSize(this.groups, index);
        return groupSize;
    }

    public final int getGroupEnd() {
        return this.end;
    }

    public final int groupEnd(int index) {
        int groupSize;
        groupSize = SlotTableKt.groupSize(this.groups, index);
        return groupSize + index;
    }

    public final int getGroupKey() {
        int key;
        if (this.current < this.end) {
            key = SlotTableKt.key(this.groups, this.current);
            return key;
        }
        return 0;
    }

    public final int groupKey(int index) {
        int key;
        key = SlotTableKt.key(this.groups, index);
        return key;
    }

    public final int getGroupSlotIndex() {
        int slotAnchor;
        int i = this.currentSlot;
        slotAnchor = SlotTableKt.slotAnchor(this.groups, this.parent);
        return i - slotAnchor;
    }

    public final boolean hasObjectKey(int index) {
        boolean hasObjectKey;
        hasObjectKey = SlotTableKt.hasObjectKey(this.groups, index);
        return hasObjectKey;
    }

    public final Object getGroupObjectKey() {
        if (this.current < this.end) {
            return objectKey(this.groups, this.current);
        }
        return null;
    }

    public final Object groupObjectKey(int index) {
        return objectKey(this.groups, index);
    }

    public final Object getGroupAux() {
        if (this.current < this.end) {
            return aux(this.groups, this.current);
        }
        return 0;
    }

    public final Object groupAux(int index) {
        return aux(this.groups, index);
    }

    public final Object getGroupNode() {
        if (this.current < this.end) {
            return node(this.groups, this.current);
        }
        return null;
    }

    public final int groupKey(Anchor anchor) {
        int key;
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        if (!anchor.getValid()) {
            return 0;
        }
        key = SlotTableKt.key(this.groups, this.table.anchorIndex(anchor));
        return key;
    }

    public final boolean hasMark(int index) {
        boolean hasMark;
        hasMark = SlotTableKt.hasMark(this.groups, index);
        return hasMark;
    }

    public final boolean containsMark(int index) {
        boolean containsMark;
        containsMark = SlotTableKt.containsMark(this.groups, index);
        return containsMark;
    }

    public final int getParentNodes() {
        int nodeCount;
        if (this.parent < 0) {
            return 0;
        }
        nodeCount = SlotTableKt.nodeCount(this.groups, this.parent);
        return nodeCount;
    }

    public final int parentOf(int index) {
        int parentAnchor;
        if (index >= 0 && index < this.groupsSize) {
            parentAnchor = SlotTableKt.parentAnchor(this.groups, index);
            return parentAnchor;
        }
        throw new IllegalArgumentException(("Invalid group index " + index).toString());
    }

    public final int getGroupSlotCount() {
        int start;
        int current = this.current;
        start = SlotTableKt.slotAnchor(this.groups, current);
        int next = current + 1;
        int end = next < this.groupsSize ? SlotTableKt.dataAnchor(this.groups, next) : this.slotsSize;
        return end - start;
    }

    public final Object get(int index) {
        int slotIndex = this.currentSlot + index;
        return slotIndex < this.currentSlotEnd ? this.slots[slotIndex] : Composer.INSTANCE.getEmpty();
    }

    public final Object groupGet(int index) {
        return groupGet(this.current, index);
    }

    public final Object groupGet(int group, int index) {
        int start;
        start = SlotTableKt.slotAnchor(this.groups, group);
        int next = group + 1;
        int end = next < this.groupsSize ? SlotTableKt.dataAnchor(this.groups, next) : this.slotsSize;
        int address = start + index;
        return address < end ? this.slots[address] : Composer.INSTANCE.getEmpty();
    }

    public final Object next() {
        if (this.emptyCount > 0 || this.currentSlot >= this.currentSlotEnd) {
            return Composer.INSTANCE.getEmpty();
        }
        Object[] objArr = this.slots;
        int i = this.currentSlot;
        this.currentSlot = i + 1;
        return objArr[i];
    }

    public final void beginEmpty() {
        this.emptyCount++;
    }

    public final void endEmpty() {
        if (!(this.emptyCount > 0)) {
            throw new IllegalArgumentException("Unbalanced begin/end empty".toString());
        }
        this.emptyCount--;
    }

    public final void close() {
        this.closed = true;
        this.table.close$runtime_release(this);
    }

    public final void startGroup() {
        int parentAnchor;
        int groupSize;
        int slotAnchor;
        int dataAnchor;
        if (this.emptyCount <= 0) {
            parentAnchor = SlotTableKt.parentAnchor(this.groups, this.current);
            if (!(parentAnchor == this.parent)) {
                throw new IllegalArgumentException("Invalid slot table detected".toString());
            }
            this.parent = this.current;
            int i = this.current;
            groupSize = SlotTableKt.groupSize(this.groups, this.current);
            this.end = i + groupSize;
            int current = this.current;
            this.current = current + 1;
            slotAnchor = SlotTableKt.slotAnchor(this.groups, current);
            this.currentSlot = slotAnchor;
            if (current < this.groupsSize - 1) {
                dataAnchor = SlotTableKt.dataAnchor(this.groups, current + 1);
            } else {
                dataAnchor = this.slotsSize;
            }
            this.currentSlotEnd = dataAnchor;
        }
    }

    public final void startNode() {
        boolean isNode;
        if (this.emptyCount <= 0) {
            isNode = SlotTableKt.isNode(this.groups, this.current);
            if (!isNode) {
                throw new IllegalArgumentException("Expected a node group".toString());
            }
            startGroup();
        }
    }

    public final int skipGroup() {
        boolean isNode;
        int groupSize;
        boolean value$iv = this.emptyCount == 0;
        if (value$iv) {
            isNode = SlotTableKt.isNode(this.groups, this.current);
            int count = isNode ? 1 : SlotTableKt.nodeCount(this.groups, this.current);
            int i = this.current;
            groupSize = SlotTableKt.groupSize(this.groups, this.current);
            this.current = i + groupSize;
            return count;
        }
        ComposerKt.composeRuntimeError("Cannot skip while in an empty region".toString());
        throw new KotlinNothingValueException();
    }

    public final void skipToGroupEnd() {
        boolean value$iv = this.emptyCount == 0;
        if (value$iv) {
            this.current = this.end;
        } else {
            ComposerKt.composeRuntimeError("Cannot skip the enclosing group while in an empty region".toString());
            throw new KotlinNothingValueException();
        }
    }

    public final void reposition(int index) {
        int groupSize;
        boolean value$iv = this.emptyCount == 0;
        if (value$iv) {
            this.current = index;
            int parent = index < this.groupsSize ? SlotTableKt.parentAnchor(this.groups, index) : -1;
            this.parent = parent;
            if (parent >= 0) {
                groupSize = SlotTableKt.groupSize(this.groups, parent);
                this.end = groupSize + parent;
            } else {
                this.end = this.groupsSize;
            }
            this.currentSlot = 0;
            this.currentSlotEnd = 0;
            return;
        }
        ComposerKt.composeRuntimeError("Cannot reposition while in an empty region".toString());
        throw new KotlinNothingValueException();
    }

    public final void restoreParent(int index) {
        int groupSize;
        groupSize = SlotTableKt.groupSize(this.groups, index);
        int newCurrentEnd = groupSize + index;
        int current = this.current;
        boolean value$iv = current >= index && current <= newCurrentEnd;
        if (!value$iv) {
            Object message$iv = "Index " + index + " is not a parent of " + current;
            ComposerKt.composeRuntimeError(message$iv.toString());
            throw new KotlinNothingValueException();
        }
        this.parent = index;
        this.end = newCurrentEnd;
        this.currentSlot = 0;
        this.currentSlotEnd = 0;
    }

    public final void endGroup() {
        int parent;
        int groupSize;
        int i;
        if (this.emptyCount == 0) {
            boolean value$iv = this.current == this.end;
            if (value$iv) {
                parent = SlotTableKt.parentAnchor(this.groups, this.parent);
                this.parent = parent;
                if (parent >= 0) {
                    groupSize = SlotTableKt.groupSize(this.groups, parent);
                    i = groupSize + parent;
                } else {
                    i = this.groupsSize;
                }
                this.end = i;
                return;
            }
            ComposerKt.composeRuntimeError("endGroup() not called at the end of a group".toString());
            throw new KotlinNothingValueException();
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:7:0x0012 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<androidx.compose.runtime.KeyInfo> extractKeys() {
        /*
            r10 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r0 = (java.util.List) r0
            int r1 = r10.emptyCount
            if (r1 <= 0) goto Lc
            return r0
        Lc:
            r1 = 0
            int r2 = r10.current
            r8 = r1
        L10:
            int r1 = r10.end
            if (r2 >= r1) goto L48
        L15:
            androidx.compose.runtime.KeyInfo r1 = new androidx.compose.runtime.KeyInfo
            int[] r3 = r10.groups
            int r4 = androidx.compose.runtime.SlotTableKt.access$key(r3, r2)
            int[] r3 = r10.groups
            java.lang.Object r5 = r10.objectKey(r3, r2)
            int[] r3 = r10.groups
            boolean r3 = androidx.compose.runtime.SlotTableKt.access$isNode(r3, r2)
            if (r3 == 0) goto L2e
            r3 = 1
            goto L34
        L2e:
            int[] r3 = r10.groups
            int r3 = androidx.compose.runtime.SlotTableKt.access$nodeCount(r3, r2)
        L34:
            r7 = r3
            int r9 = r8 + 1
            r3 = r1
            r6 = r2
            r3.<init>(r4, r5, r6, r7, r8)
            r0.add(r1)
            int[] r1 = r10.groups
            int r1 = androidx.compose.runtime.SlotTableKt.access$groupSize(r1, r2)
            int r2 = r2 + r1
            r8 = r9
            goto L10
        L48:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SlotReader.extractKeys():java.util.List");
    }

    public final void forEachData$runtime_release(int group, Function2<? super Integer, Object, Unit> block) {
        int start;
        Intrinsics.checkNotNullParameter(block, "block");
        start = SlotTableKt.slotAnchor(this.groups, group);
        int end = group + 1 < this.table.getGroupsSize() ? SlotTableKt.dataAnchor(this.table.getGroups(), group + 1) : this.table.getSlotsSize();
        for (int index = start; index < end; index++) {
            block.invoke(Integer.valueOf(index - start), this.slots[index]);
        }
    }

    public String toString() {
        return "SlotReader(current=" + this.current + ", key=" + getGroupKey() + ", parent=" + this.parent + ", end=" + this.end + ')';
    }

    public static /* synthetic */ Anchor anchor$default(SlotReader slotReader, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = slotReader.current;
        }
        return slotReader.anchor(i);
    }

    public final Anchor anchor(int index) {
        ArrayList $this$getOrAdd$iv = this.table.getAnchors$runtime_release();
        int effectiveSize$iv = this.groupsSize;
        int location$iv = SlotTableKt.search($this$getOrAdd$iv, index, effectiveSize$iv);
        if (location$iv < 0) {
            Anchor anchor$iv = new Anchor(index);
            $this$getOrAdd$iv.add(-(location$iv + 1), anchor$iv);
            return anchor$iv;
        }
        Anchor anchor = $this$getOrAdd$iv.get(location$iv);
        Intrinsics.checkNotNullExpressionValue(anchor, "get(location)");
        return anchor;
    }

    private final Object node(int[] $this$node, int index) {
        boolean isNode;
        int nodeIndex;
        isNode = SlotTableKt.isNode($this$node, index);
        if (isNode) {
            Object[] objArr = this.slots;
            nodeIndex = SlotTableKt.nodeIndex($this$node, index);
            return objArr[nodeIndex];
        }
        return Composer.INSTANCE.getEmpty();
    }

    private final Object aux(int[] $this$aux, int index) {
        boolean hasAux;
        int auxIndex;
        hasAux = SlotTableKt.hasAux($this$aux, index);
        if (hasAux) {
            Object[] objArr = this.slots;
            auxIndex = SlotTableKt.auxIndex($this$aux, index);
            return objArr[auxIndex];
        }
        return Composer.INSTANCE.getEmpty();
    }

    private final Object objectKey(int[] $this$objectKey, int index) {
        boolean hasObjectKey;
        int objectKeyIndex;
        hasObjectKey = SlotTableKt.hasObjectKey($this$objectKey, index);
        if (hasObjectKey) {
            Object[] objArr = this.slots;
            objectKeyIndex = SlotTableKt.objectKeyIndex($this$objectKey, index);
            return objArr[objectKeyIndex];
        }
        return null;
    }
}
