package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: DragGestureDetectorCopy.kt */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ag\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f26\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\u000eH\u0080@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a]\u0010\u0016\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u000e2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00050\u0018H\u0082Hø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a!\u0010\u001c\u001a\u00020\u001d*\u00020\u001e2\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a!\u0010!\u001a\u00020\u0005*\u00020\"2\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006%"}, d2 = {"defaultTouchSlop", "Landroidx/compose/ui/unit/Dp;", "F", "mouseSlop", "mouseToTouchSlopRatio", "", "awaitHorizontalPointerSlopOrCancellation", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "onPointerSlopReached", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "change", "overSlop", "", "awaitHorizontalPointerSlopOrCancellation-gDDlDlE", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitPointerSlopOrCancellation", "getDragDirectionValue", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "awaitPointerSlopOrCancellation-pn7EDYM", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isPointerUp", "", "Landroidx/compose/ui/input/pointer/PointerEvent;", "isPointerUp-DmW0f2w", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)Z", "pointerSlop", "Landroidx/compose/ui/platform/ViewConfiguration;", "pointerSlop-E8SPZFQ", "(Landroidx/compose/ui/platform/ViewConfiguration;I)F", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DragGestureDetectorCopyKt {
    private static final float mouseToTouchSlopRatio;
    private static final float mouseSlop = Dp.m5218constructorimpl((float) 0.125d);
    private static final float defaultTouchSlop = Dp.m5218constructorimpl(18);

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0025. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x01a5 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x014a -> B:17:0x009b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0195 -> B:12:0x019f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x01c3 -> B:17:0x009b). Please report as a decompilation issue!!! */
    /* renamed from: awaitHorizontalPointerSlopOrCancellation-gDDlDlE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m1497awaitHorizontalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope r23, long r24, int r26, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r27, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r28) {
        /*
            Method dump skipped, instructions count: 472
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DragGestureDetectorCopyKt.m1497awaitHorizontalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: awaitPointerSlopOrCancellation-pn7EDYM, reason: not valid java name */
    private static final Object m1498awaitPointerSlopOrCancellationpn7EDYM(AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dpn7EDYM, long pointerId, int pointerType, Function2<? super PointerInputChange, ? super Float, Unit> function2, Function1<? super Offset, Float> function1, Continuation<? super PointerInputChange> continuation) {
        Object it$iv;
        Object it$iv2;
        AwaitPointerEventScope awaitPointerEventScope = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM;
        PointerEventPass pointerEventPass = null;
        if (m1499isPointerUpDmW0f2w($this$awaitPointerSlopOrCancellation_u2dpn7EDYM.getCurrentEvent(), pointerId)) {
            return null;
        }
        float touchSlop = m1500pointerSlopE8SPZFQ($this$awaitPointerSlopOrCancellation_u2dpn7EDYM.getViewConfiguration(), pointerType);
        Ref.LongRef pointer = new Ref.LongRef();
        pointer.element = pointerId;
        float totalPositionChange = 0.0f;
        while (true) {
            InlineMarker.mark(0);
            Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, pointerEventPass, continuation, 1, pointerEventPass);
            InlineMarker.mark(1);
            PointerEvent event = (PointerEvent) awaitPointerEvent$default;
            List $this$fastForEach$iv$iv = event.getChanges();
            int size = $this$fastForEach$iv$iv.size();
            int index$iv$iv = 0;
            while (true) {
                if (index$iv$iv < size) {
                    List $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv;
                    Object item$iv$iv = $this$fastForEach$iv$iv2.get(index$iv$iv);
                    it$iv = item$iv$iv;
                    PointerInputChange it = (PointerInputChange) it$iv;
                    if (Boolean.valueOf(PointerId.m4051equalsimpl0(it.getId(), pointer.element)).booleanValue()) {
                        break;
                    }
                    index$iv$iv++;
                    $this$fastForEach$iv$iv = $this$fastForEach$iv$iv2;
                } else {
                    it$iv = null;
                    break;
                }
            }
            Intrinsics.checkNotNull(it$iv);
            PointerInputChange dragEvent = (PointerInputChange) it$iv;
            if (dragEvent.isConsumed()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(dragEvent)) {
                List $this$fastFirstOrNull$iv = event.getChanges();
                int index$iv$iv2 = 0;
                int size2 = $this$fastFirstOrNull$iv.size();
                while (true) {
                    if (index$iv$iv2 < size2) {
                        Object item$iv$iv2 = $this$fastFirstOrNull$iv.get(index$iv$iv2);
                        it$iv2 = item$iv$iv2;
                        PointerInputChange it2 = (PointerInputChange) it$iv2;
                        if (Boolean.valueOf(it2.getPressed()).booleanValue()) {
                            break;
                        }
                        index$iv$iv2++;
                    } else {
                        it$iv2 = null;
                        break;
                    }
                }
                PointerInputChange otherDown = (PointerInputChange) it$iv2;
                if (otherDown == null) {
                    return null;
                }
                pointer.element = otherDown.getId();
            } else {
                long currentPosition = dragEvent.getPosition();
                long previousPosition = dragEvent.getPreviousPosition();
                float positionChange = function1.invoke(Offset.m2699boximpl(currentPosition)).floatValue() - function1.invoke(Offset.m2699boximpl(previousPosition)).floatValue();
                totalPositionChange += positionChange;
                float inDirection = Math.abs(totalPositionChange);
                if (inDirection < touchSlop) {
                    PointerEventPass pointerEventPass2 = PointerEventPass.Final;
                    InlineMarker.mark(0);
                    awaitPointerEventScope.awaitPointerEvent(pointerEventPass2, continuation);
                    InlineMarker.mark(1);
                    if (dragEvent.isConsumed()) {
                        return null;
                    }
                } else {
                    function2.invoke(dragEvent, Float.valueOf(totalPositionChange - (Math.signum(totalPositionChange) * touchSlop)));
                    if (dragEvent.isConsumed()) {
                        return dragEvent;
                    }
                    totalPositionChange = 0.0f;
                }
            }
            awaitPointerEventScope = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM;
            pointerEventPass = null;
        }
    }

    /* renamed from: isPointerUp-DmW0f2w, reason: not valid java name */
    private static final boolean m1499isPointerUpDmW0f2w(PointerEvent $this$isPointerUp_u2dDmW0f2w, long pointerId) {
        Object it$iv;
        List $this$fastFirstOrNull$iv = $this$isPointerUp_u2dDmW0f2w.getChanges();
        int index$iv$iv = 0;
        int size = $this$fastFirstOrNull$iv.size();
        while (true) {
            if (index$iv$iv < size) {
                Object item$iv$iv = $this$fastFirstOrNull$iv.get(index$iv$iv);
                it$iv = item$iv$iv;
                PointerInputChange it = (PointerInputChange) it$iv;
                if (PointerId.m4051equalsimpl0(it.getId(), pointerId)) {
                    break;
                }
                index$iv$iv++;
            } else {
                it$iv = null;
                break;
            }
        }
        PointerInputChange pointerInputChange = (PointerInputChange) it$iv;
        boolean z = false;
        if (pointerInputChange != null && pointerInputChange.getPressed()) {
            z = true;
        }
        return !z;
    }

    static {
        float arg0$iv = mouseSlop;
        float other$iv = defaultTouchSlop;
        mouseToTouchSlopRatio = arg0$iv / other$iv;
    }

    /* renamed from: pointerSlop-E8SPZFQ, reason: not valid java name */
    public static final float m1500pointerSlopE8SPZFQ(ViewConfiguration pointerSlop, int pointerType) {
        Intrinsics.checkNotNullParameter(pointerSlop, "$this$pointerSlop");
        return PointerType.m4139equalsimpl0(pointerType, PointerType.INSTANCE.m4144getMouseT8wyACA()) ? pointerSlop.getTouchSlop() * mouseToTouchSlopRatio : pointerSlop.getTouchSlop();
    }
}
