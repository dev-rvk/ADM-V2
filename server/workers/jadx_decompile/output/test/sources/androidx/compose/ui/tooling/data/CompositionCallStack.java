package androidx.compose.ui.tooling.data;

import androidx.autofill.HintConstants;
import androidx.compose.runtime.tooling.CompositionGroup;
import androidx.compose.ui.unit.IntRect;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SlotTree.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BC\u0012&\u0010\u0003\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0004\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b¢\u0006\u0002\u0010\u000bJ\u0012\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\tH\u0002J$\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00152\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u000000J\u0010\u00101\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u0005H\u0002J\u0012\u00102\u001a\u0004\u0018\u00010\u00052\u0006\u00103\u001a\u00020\u0015H\u0002J\b\u00104\u001a\u00020\u0005H\u0002J\u0010\u00105\u001a\u0002062\u0006\u0010-\u001a\u00020\u0005H\u0002R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R.\u0010\u0003\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001bR\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050(X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Landroidx/compose/ui/tooling/data/CompositionCallStack;", "T", "Landroidx/compose/ui/tooling/data/SourceContext;", "factory", "Lkotlin/Function3;", "Landroidx/compose/runtime/tooling/CompositionGroup;", "", "contexts", "", "", "", "(Lkotlin/jvm/functions/Function3;Ljava/util/Map;)V", "<set-?>", "Landroidx/compose/ui/unit/IntRect;", "bounds", "getBounds", "()Landroidx/compose/ui/unit/IntRect;", "current", "getCurrent", "()Landroidx/compose/runtime/tooling/CompositionGroup;", "currentCallIndex", "", "depth", "getDepth", "()I", "isInline", "", "()Z", "location", "Landroidx/compose/ui/tooling/data/SourceLocation;", "getLocation", "()Landroidx/compose/ui/tooling/data/SourceLocation;", HintConstants.AUTOFILL_HINT_NAME, "getName", "()Ljava/lang/String;", "parameters", "Landroidx/compose/ui/tooling/data/ParameterInformation;", "getParameters", "()Ljava/util/List;", "stack", "Lkotlin/collections/ArrayDeque;", "contextOf", "Landroidx/compose/ui/tooling/data/SourceInformationContext;", "information", "convert", "group", "callIndex", "out", "", "isCall", "parentGroup", "parentDepth", "pop", "push", "", "ui-tooling-data_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class CompositionCallStack<T> implements SourceContext {
    private IntRect bounds;
    private final Map<String, Object> contexts;
    private int currentCallIndex;
    private final Function3<CompositionGroup, SourceContext, List<? extends T>, T> factory;
    private final ArrayDeque<CompositionGroup> stack;

    /* JADX WARN: Multi-variable type inference failed */
    public CompositionCallStack(Function3<? super CompositionGroup, ? super SourceContext, ? super List<? extends T>, ? extends T> factory, Map<String, Object> contexts) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(contexts, "contexts");
        this.factory = factory;
        this.contexts = contexts;
        this.stack = new ArrayDeque<>();
        this.bounds = SlotTreeKt.getEmptyBox();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0055, code lost:
    
        r3 = androidx.compose.ui.tooling.data.SlotTreeKt.boundsOfLayoutNode(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.compose.ui.unit.IntRect convert(androidx.compose.runtime.tooling.CompositionGroup r11, int r12, java.util.List<T> r13) {
        /*
            r10 = this;
            java.lang.String r0 = "group"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "out"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r0 = (java.util.List) r0
            r1 = 0
            androidx.compose.ui.unit.IntRect r1 = androidx.compose.ui.tooling.data.SlotTreeKt.getEmptyBox()
            r10.push(r11)
            r2 = 0
            java.lang.Iterable r3 = r11.getCompositionGroups()
            r4 = 0
            java.util.Iterator r5 = r3.iterator()
        L25:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L46
            java.lang.Object r6 = r5.next()
            r7 = r6
            androidx.compose.runtime.tooling.CompositionGroup r7 = (androidx.compose.runtime.tooling.CompositionGroup) r7
            r8 = 0
            androidx.compose.ui.unit.IntRect r9 = r10.convert(r7, r2, r0)
            androidx.compose.ui.unit.IntRect r1 = androidx.compose.ui.tooling.data.SlotTreeKt.union(r1, r9)
            boolean r9 = r10.isCall(r7)
            if (r9 == 0) goto L43
            int r2 = r2 + 1
        L43:
            goto L25
        L46:
            java.lang.Object r3 = r11.getNode()
            boolean r4 = r3 instanceof androidx.compose.ui.layout.LayoutInfo
            if (r4 == 0) goto L52
            androidx.compose.ui.layout.LayoutInfo r3 = (androidx.compose.ui.layout.LayoutInfo) r3
            goto L53
        L52:
            r3 = 0
        L53:
            if (r3 == 0) goto L5c
            r4 = 0
            androidx.compose.ui.unit.IntRect r3 = androidx.compose.ui.tooling.data.SlotTreeKt.access$boundsOfLayoutNode(r3)
            if (r3 != 0) goto L5d
        L5c:
            r3 = r1
        L5d:
            r1 = r3
            r10.currentCallIndex = r12
            r10.bounds = r1
            kotlin.jvm.functions.Function3<androidx.compose.runtime.tooling.CompositionGroup, androidx.compose.ui.tooling.data.SourceContext, java.util.List<? extends T>, T> r3 = r10.factory
            java.lang.Object r3 = r3.invoke(r11, r10, r0)
            if (r3 == 0) goto L6e
            r4 = 0
            r13.add(r3)
        L6e:
            r10.pop()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.data.CompositionCallStack.convert(androidx.compose.runtime.tooling.CompositionGroup, int, java.util.List):androidx.compose.ui.unit.IntRect");
    }

    @Override // androidx.compose.ui.tooling.data.SourceContext
    public String getName() {
        int startIndex;
        String info = getCurrent().getSourceInfo();
        if (info == null) {
            return null;
        }
        if (StringsKt.startsWith$default(info, "CC(", false, 2, (Object) null)) {
            startIndex = 3;
        } else {
            if (!StringsKt.startsWith$default(info, "C(", false, 2, (Object) null)) {
                return null;
            }
            startIndex = 2;
        }
        int endIndex = StringsKt.indexOf$default((CharSequence) info, ')', 0, false, 6, (Object) null);
        if (endIndex <= 2) {
            return null;
        }
        String substring = info.substring(startIndex, endIndex);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @Override // androidx.compose.ui.tooling.data.SourceContext
    public boolean isInline() {
        String sourceInfo = getCurrent().getSourceInfo();
        return sourceInfo != null && StringsKt.startsWith$default(sourceInfo, "CC", false, 2, (Object) null);
    }

    @Override // androidx.compose.ui.tooling.data.SourceContext
    public IntRect getBounds() {
        return this.bounds;
    }

    @Override // androidx.compose.ui.tooling.data.SourceContext
    public SourceLocation getLocation() {
        String it;
        SourceInformationContext context;
        String it2;
        CompositionGroup parentGroup = parentGroup(1);
        if (parentGroup == null || (it = parentGroup.getSourceInfo()) == null || (context = contextOf(it)) == null) {
            return null;
        }
        SourceInformationContext parentContext = context;
        int index = 2;
        while (index < this.stack.size()) {
            if ((parentContext != null ? parentContext.getSourceFile() : null) != null) {
                break;
            }
            int index2 = index + 1;
            CompositionGroup parentGroup2 = parentGroup(index);
            parentContext = (parentGroup2 == null || (it2 = parentGroup2.getSourceInfo()) == null) ? null : contextOf(it2);
            index = index2;
        }
        return context.sourceLocation(this.currentCallIndex, parentContext);
    }

    @Override // androidx.compose.ui.tooling.data.SourceContext
    public List<ParameterInformation> getParameters() {
        SourceInformationContext context;
        List<ParameterInformation> extractParameterInfo;
        CompositionGroup group = getCurrent();
        String it = group.getSourceInfo();
        if (it == null || (context = contextOf(it)) == null) {
            return CollectionsKt.emptyList();
        }
        List data = new ArrayList();
        CollectionsKt.addAll(data, group.getData());
        extractParameterInfo = SlotTreeKt.extractParameterInfo(data, context);
        return extractParameterInfo;
    }

    @Override // androidx.compose.ui.tooling.data.SourceContext
    public int getDepth() {
        return this.stack.size();
    }

    private final void push(CompositionGroup group) {
        this.stack.addLast(group);
    }

    private final CompositionGroup pop() {
        return this.stack.removeLast();
    }

    private final CompositionGroup getCurrent() {
        return this.stack.last();
    }

    private final CompositionGroup parentGroup(int parentDepth) {
        if (this.stack.size() > parentDepth) {
            return this.stack.get((this.stack.size() - parentDepth) - 1);
        }
        return null;
    }

    private final SourceInformationContext contextOf(String information) {
        Object answer$iv;
        Map $this$getOrPut$iv = this.contexts;
        Object value$iv = $this$getOrPut$iv.get(information);
        if (value$iv == null) {
            answer$iv = SlotTreeKt.sourceInformationContextOf$default(information, null, 2, null);
            $this$getOrPut$iv.put(information, answer$iv);
        } else {
            answer$iv = value$iv;
        }
        if (answer$iv instanceof SourceInformationContext) {
            return (SourceInformationContext) answer$iv;
        }
        return null;
    }

    private final boolean isCall(CompositionGroup group) {
        String sourceInfo = group.getSourceInfo();
        if (sourceInfo != null) {
            return StringsKt.startsWith$default(sourceInfo, "C", false, 2, (Object) null);
        }
        return false;
    }
}
