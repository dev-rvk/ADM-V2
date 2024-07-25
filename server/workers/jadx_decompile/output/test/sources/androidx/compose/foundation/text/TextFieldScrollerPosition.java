package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextRange;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextFieldScroll.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\b\u0001\u0018\u0000 22\u00020\u0001:\u00012B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020)H\u0000¢\u0006\u0002\b*J\u001b\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\u001eø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010.J&\u0010/\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020)2\u0006\u00101\u001a\u00020)R+\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00068F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR+\u0010\u0010\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00068F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\rR+\u0010\u0014\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R%\u0010\u001d\u001a\u00020\u001eX\u0086\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00063"}, d2 = {"Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "", "()V", "initialOrientation", "Landroidx/compose/foundation/gestures/Orientation;", "initial", "", "(Landroidx/compose/foundation/gestures/Orientation;F)V", "<set-?>", "maximum", "getMaximum", "()F", "setMaximum", "(F)V", "maximum$delegate", "Landroidx/compose/runtime/MutableFloatState;", "offset", "getOffset", "setOffset", "offset$delegate", "orientation", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "setOrientation", "(Landroidx/compose/foundation/gestures/Orientation;)V", "orientation$delegate", "Landroidx/compose/runtime/MutableState;", "previousCursorRect", "Landroidx/compose/ui/geometry/Rect;", "previousSelection", "Landroidx/compose/ui/text/TextRange;", "getPreviousSelection-d9O1mEE", "()J", "setPreviousSelection-5zc-tL8", "(J)V", "J", "coerceOffset", "", "cursorStart", "cursorEnd", "containerSize", "", "coerceOffset$foundation_release", "getOffsetToFollow", "selection", "getOffsetToFollow-5zc-tL8", "(J)I", "update", "cursorRect", "textFieldSize", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextFieldScrollerPosition {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Saver<TextFieldScrollerPosition, Object> Saver = ListSaverKt.listSaver(new Function2<SaverScope, TextFieldScrollerPosition, List<? extends Object>>() { // from class: androidx.compose.foundation.text.TextFieldScrollerPosition$Companion$Saver$1
        @Override // kotlin.jvm.functions.Function2
        public final List<Object> invoke(SaverScope listSaver, TextFieldScrollerPosition it) {
            Intrinsics.checkNotNullParameter(listSaver, "$this$listSaver");
            Intrinsics.checkNotNullParameter(it, "it");
            return CollectionsKt.listOf(Float.valueOf(it.getOffset()), Boolean.valueOf(it.getOrientation() == Orientation.Vertical));
        }
    }, new Function1<List<? extends Object>, TextFieldScrollerPosition>() { // from class: androidx.compose.foundation.text.TextFieldScrollerPosition$Companion$Saver$2
        @Override // kotlin.jvm.functions.Function1
        public final TextFieldScrollerPosition invoke(List<? extends Object> restored) {
            Intrinsics.checkNotNullParameter(restored, "restored");
            Object obj = restored.get(1);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            Orientation orientation = ((Boolean) obj).booleanValue() ? Orientation.Vertical : Orientation.Horizontal;
            Object obj2 = restored.get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Float");
            return new TextFieldScrollerPosition(orientation, ((Float) obj2).floatValue());
        }
    });

    /* renamed from: maximum$delegate, reason: from kotlin metadata */
    private final MutableFloatState maximum;

    /* renamed from: offset$delegate, reason: from kotlin metadata */
    private final MutableFloatState offset;

    /* renamed from: orientation$delegate, reason: from kotlin metadata */
    private final MutableState orientation;
    private Rect previousCursorRect;
    private long previousSelection;

    public TextFieldScrollerPosition(Orientation initialOrientation, float initial) {
        Intrinsics.checkNotNullParameter(initialOrientation, "initialOrientation");
        this.offset = PrimitiveSnapshotStateKt.mutableFloatStateOf(initial);
        this.maximum = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.previousCursorRect = Rect.INSTANCE.getZero();
        this.previousSelection = TextRange.INSTANCE.m4731getZerod9O1mEE();
        this.orientation = SnapshotStateKt.mutableStateOf(initialOrientation, SnapshotStateKt.structuralEqualityPolicy());
    }

    public /* synthetic */ TextFieldScrollerPosition(Orientation orientation, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(orientation, (i & 2) != 0 ? 0.0f : f);
    }

    public TextFieldScrollerPosition() {
        this(Orientation.Vertical, 0.0f, 2, null);
    }

    public final float getOffset() {
        FloatState $this$getValue$iv = this.offset;
        return $this$getValue$iv.getFloatValue();
    }

    public final void setOffset(float f) {
        MutableFloatState $this$setValue$iv = this.offset;
        $this$setValue$iv.setFloatValue(f);
    }

    private final void setMaximum(float f) {
        MutableFloatState $this$setValue$iv = this.maximum;
        $this$setValue$iv.setFloatValue(f);
    }

    public final float getMaximum() {
        FloatState $this$getValue$iv = this.maximum;
        return $this$getValue$iv.getFloatValue();
    }

    /* renamed from: getPreviousSelection-d9O1mEE, reason: not valid java name and from getter */
    public final long getPreviousSelection() {
        return this.previousSelection;
    }

    /* renamed from: setPreviousSelection-5zc-tL8, reason: not valid java name */
    public final void m827setPreviousSelection5zctL8(long j) {
        this.previousSelection = j;
    }

    public final Orientation getOrientation() {
        State $this$getValue$iv = this.orientation;
        return (Orientation) $this$getValue$iv.getValue();
    }

    public final void setOrientation(Orientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "<set-?>");
        MutableState $this$setValue$iv = this.orientation;
        $this$setValue$iv.setValue(orientation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0037, code lost:
    
        if ((r7.getTop() == r5.previousCursorRect.getTop()) == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void update(androidx.compose.foundation.gestures.Orientation r6, androidx.compose.ui.geometry.Rect r7, int r8, int r9) {
        /*
            r5 = this;
            java.lang.String r0 = "orientation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "cursorRect"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            int r0 = r9 - r8
            float r0 = (float) r0
            r5.setMaximum(r0)
            float r1 = r7.getLeft()
            androidx.compose.ui.geometry.Rect r2 = r5.previousCursorRect
            float r2 = r2.getLeft()
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L23
            r1 = r2
            goto L24
        L23:
            r1 = r3
        L24:
            if (r1 == 0) goto L39
            float r1 = r7.getTop()
            androidx.compose.ui.geometry.Rect r4 = r5.previousCursorRect
            float r4 = r4.getTop()
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 != 0) goto L36
            r1 = r2
            goto L37
        L36:
            r1 = r3
        L37:
            if (r1 != 0) goto L5b
        L39:
            androidx.compose.foundation.gestures.Orientation r1 = androidx.compose.foundation.gestures.Orientation.Vertical
            if (r6 != r1) goto L3e
            goto L3f
        L3e:
            r2 = r3
        L3f:
            r1 = r2
            if (r1 == 0) goto L47
            float r2 = r7.getTop()
            goto L4b
        L47:
            float r2 = r7.getLeft()
        L4b:
            if (r1 == 0) goto L52
            float r3 = r7.getBottom()
            goto L56
        L52:
            float r3 = r7.getRight()
        L56:
            r5.coerceOffset$foundation_release(r2, r3, r8)
            r5.previousCursorRect = r7
        L5b:
            float r1 = r5.getOffset()
            r2 = 0
            float r1 = kotlin.ranges.RangesKt.coerceIn(r1, r2, r0)
            r5.setOffset(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextFieldScrollerPosition.update(androidx.compose.foundation.gestures.Orientation, androidx.compose.ui.geometry.Rect, int, int):void");
    }

    public final void coerceOffset$foundation_release(float cursorStart, float cursorEnd, int containerSize) {
        float offsetDifference;
        float startVisibleBound = getOffset();
        float endVisibleBound = containerSize + startVisibleBound;
        if (cursorEnd > endVisibleBound) {
            offsetDifference = cursorEnd - endVisibleBound;
        } else if (cursorStart < startVisibleBound && cursorEnd - cursorStart > containerSize) {
            offsetDifference = cursorEnd - endVisibleBound;
        } else if (cursorStart < startVisibleBound && cursorEnd - cursorStart <= containerSize) {
            offsetDifference = cursorStart - startVisibleBound;
        } else {
            offsetDifference = 0.0f;
        }
        setOffset(getOffset() + offsetDifference);
    }

    /* renamed from: getOffsetToFollow-5zc-tL8, reason: not valid java name */
    public final int m825getOffsetToFollow5zctL8(long selection) {
        return TextRange.m4726getStartimpl(selection) != TextRange.m4726getStartimpl(this.previousSelection) ? TextRange.m4726getStartimpl(selection) : TextRange.m4721getEndimpl(selection) != TextRange.m4721getEndimpl(this.previousSelection) ? TextRange.m4721getEndimpl(selection) : TextRange.m4724getMinimpl(selection);
    }

    /* compiled from: TextFieldScroll.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/text/TextFieldScrollerPosition$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<TextFieldScrollerPosition, Object> getSaver() {
            return TextFieldScrollerPosition.Saver;
        }
    }
}
