package androidx.compose.foundation.gestures;

import androidx.autofill.HintConstants;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: DragGestureDetector.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a;\u0010\u0013\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00160\u0015H\u0082Hø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a'\u0010\u0019\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0012\u001ag\u0010\u001b\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d26\u0010\u001e\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020$0\u001fH\u0080@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a_\u0010'\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001026\u0010(\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020$0\u001fH\u0086@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a'\u0010+\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b,\u0010\u0012\u001a]\u0010-\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010.\u001a\u00020\u00012\b\b\u0002\u0010/\u001a\u00020\u00162\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020$0\u001fH\u0080Hø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a_\u00103\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001026\u0010(\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u001100¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020$0\u001fH\u0086@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b4\u0010*\u001a'\u00105\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b6\u0010\u0012\u001ag\u00107\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d26\u0010(\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020$0\u001fH\u0080@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b8\u0010&\u001a_\u00109\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001026\u0010(\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020$0\u001fH\u0086@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b:\u0010*\u001a\u0086\u0001\u0010;\u001a\u00020$*\u00020<2\u0014\b\u0002\u0010=\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020$0\u00152\u000e\b\u0002\u0010>\u001a\b\u0012\u0004\u0012\u00020$0?2\u000e\b\u0002\u0010@\u001a\b\u0012\u0004\u0012\u00020$0?26\u0010A\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u001100¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020$0\u001fH\u0086@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010C\u001a\u0086\u0001\u0010D\u001a\u00020$*\u00020<2\u0014\b\u0002\u0010=\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020$0\u00152\u000e\b\u0002\u0010>\u001a\b\u0012\u0004\u0012\u00020$0?2\u000e\b\u0002\u0010@\u001a\b\u0012\u0004\u0012\u00020$0?26\u0010A\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u001100¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020$0\u001fH\u0086@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010C\u001a\u0086\u0001\u0010E\u001a\u00020$*\u00020<2\u0014\b\u0002\u0010=\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020$0\u00152\u000e\b\u0002\u0010>\u001a\b\u0012\u0004\u0012\u00020$0?2\u000e\b\u0002\u0010@\u001a\b\u0012\u0004\u0012\u00020$0?26\u0010F\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020$0\u001fH\u0086@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010C\u001a\u0086\u0001\u0010G\u001a\u00020$*\u00020<2\u0014\b\u0002\u0010=\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020$0\u00152\u000e\b\u0002\u0010>\u001a\b\u0012\u0004\u0012\u00020$0?2\u000e\b\u0002\u0010@\u001a\b\u0012\u0004\u0012\u00020$0?26\u0010H\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020$0\u001fH\u0086@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010C\u001a9\u0010I\u001a\u00020\u0016*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020$0\u0015H\u0086@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\bJ\u0010\u0018\u001ac\u0010I\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020$0\u00152\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\u00152\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00160\u0015H\u0080Hø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\bM\u0010N\u001a9\u0010O\u001a\u00020\u0016*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020$0\u0015H\u0086@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\bP\u0010\u0018\u001a!\u0010Q\u001a\u00020\u0016*\u00020R2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bS\u0010T\u001a!\u0010U\u001a\u00020\u000b*\u00020V2\u0006\u0010\u001c\u001a\u00020\u001dH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bW\u0010X\u001a\f\u0010Y\u001a\u00020\u0001*\u00020ZH\u0000\u001a9\u0010[\u001a\u00020\u0016*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020$0\u0015H\u0086@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\\\u0010\u0018\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u0013\u0010\u0006\u001a\u00020\u0007X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\b\"\u0013\u0010\t\u001a\u00020\u0007X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\b\"\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006]"}, d2 = {"HorizontalPointerDirectionConfig", "Landroidx/compose/foundation/gestures/PointerDirectionConfig;", "getHorizontalPointerDirectionConfig", "()Landroidx/compose/foundation/gestures/PointerDirectionConfig;", "VerticalPointerDirectionConfig", "getVerticalPointerDirectionConfig", "defaultTouchSlop", "Landroidx/compose/ui/unit/Dp;", "F", "mouseSlop", "mouseToTouchSlopRatio", "", "awaitDragOrCancellation", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "awaitDragOrCancellation-rnUCldI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDragOrUp", "hasDragged", "Lkotlin/Function1;", "", "awaitDragOrUp-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitHorizontalDragOrCancellation", "awaitHorizontalDragOrCancellation-rnUCldI", "awaitHorizontalPointerSlopOrCancellation", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "onPointerSlopReached", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "change", "overSlop", "", "awaitHorizontalPointerSlopOrCancellation-gDDlDlE", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitHorizontalTouchSlopOrCancellation", "onTouchSlopReached", "awaitHorizontalTouchSlopOrCancellation-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitLongPressOrCancellation", "awaitLongPressOrCancellation-rnUCldI", "awaitPointerSlopOrCancellation", "pointerDirectionConfig", "triggerOnMainAxisSlop", "Landroidx/compose/ui/geometry/Offset;", "awaitPointerSlopOrCancellation-wtdNQyU", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILandroidx/compose/foundation/gestures/PointerDirectionConfig;ZLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitTouchSlopOrCancellation", "awaitTouchSlopOrCancellation-jO51t88", "awaitVerticalDragOrCancellation", "awaitVerticalDragOrCancellation-rnUCldI", "awaitVerticalPointerSlopOrCancellation", "awaitVerticalPointerSlopOrCancellation-gDDlDlE", "awaitVerticalTouchSlopOrCancellation", "awaitVerticalTouchSlopOrCancellation-jO51t88", "detectDragGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onDragStart", "onDragEnd", "Lkotlin/Function0;", "onDragCancel", "onDrag", "dragAmount", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectDragGesturesAfterLongPress", "detectHorizontalDragGestures", "onHorizontalDrag", "detectVerticalDragGestures", "onVerticalDrag", "drag", "drag-jO51t88", "motionFromChange", "motionConsumed", "drag-VnAYq1g", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "horizontalDrag", "horizontalDrag-jO51t88", "isPointerUp", "Landroidx/compose/ui/input/pointer/PointerEvent;", "isPointerUp-DmW0f2w", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)Z", "pointerSlop", "Landroidx/compose/ui/platform/ViewConfiguration;", "pointerSlop-E8SPZFQ", "(Landroidx/compose/ui/platform/ViewConfiguration;I)F", "toPointerDirectionConfig", "Landroidx/compose/foundation/gestures/Orientation;", "verticalDrag", "verticalDrag-jO51t88", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DragGestureDetectorKt {
    private static final float mouseToTouchSlopRatio;
    private static final PointerDirectionConfig HorizontalPointerDirectionConfig = new PointerDirectionConfig() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$HorizontalPointerDirectionConfig$1
        @Override // androidx.compose.foundation.gestures.PointerDirectionConfig
        /* renamed from: mainAxisDelta-k-4lQ0M, reason: not valid java name */
        public float mo281mainAxisDeltak4lQ0M(long offset) {
            return Offset.m2710getXimpl(offset);
        }

        @Override // androidx.compose.foundation.gestures.PointerDirectionConfig
        /* renamed from: crossAxisDelta-k-4lQ0M, reason: not valid java name */
        public float mo280crossAxisDeltak4lQ0M(long offset) {
            return Offset.m2711getYimpl(offset);
        }

        @Override // androidx.compose.foundation.gestures.PointerDirectionConfig
        /* renamed from: offsetFromChanges-dBAh8RU, reason: not valid java name */
        public long mo282offsetFromChangesdBAh8RU(float mainChange, float crossChange) {
            return OffsetKt.Offset(mainChange, crossChange);
        }
    };
    private static final PointerDirectionConfig VerticalPointerDirectionConfig = new PointerDirectionConfig() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$VerticalPointerDirectionConfig$1
        @Override // androidx.compose.foundation.gestures.PointerDirectionConfig
        /* renamed from: mainAxisDelta-k-4lQ0M */
        public float mo281mainAxisDeltak4lQ0M(long offset) {
            return Offset.m2711getYimpl(offset);
        }

        @Override // androidx.compose.foundation.gestures.PointerDirectionConfig
        /* renamed from: crossAxisDelta-k-4lQ0M */
        public float mo280crossAxisDeltak4lQ0M(long offset) {
            return Offset.m2710getXimpl(offset);
        }

        @Override // androidx.compose.foundation.gestures.PointerDirectionConfig
        /* renamed from: offsetFromChanges-dBAh8RU */
        public long mo282offsetFromChangesdBAh8RU(float mainChange, float crossChange) {
            return OffsetKt.Offset(crossChange, mainChange);
        }
    };
    private static final float mouseSlop = Dp.m5218constructorimpl((float) 0.125d);
    private static final float defaultTouchSlop = Dp.m5218constructorimpl(18);

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0025. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x01f9 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00d5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0127 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0183 -> B:17:0x00b9). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x01e8 -> B:12:0x01f3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x023c -> B:17:0x00b9). Please report as a decompilation issue!!! */
    /* renamed from: awaitTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m269awaitTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r25, long r26, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super androidx.compose.ui.geometry.Offset, kotlin.Unit> r28, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r29) {
        /*
            Method dump skipped, instructions count: 594
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m269awaitTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0023. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x004f -> B:12:0x0052). Please report as a decompilation issue!!! */
    /* renamed from: drag-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m275dragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r7, long r8, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, kotlin.Unit> r10, kotlin.coroutines.Continuation<? super java.lang.Boolean> r11) {
        /*
            boolean r0 = r11 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1
            if (r0 == 0) goto L14
            r0 = r11
            androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1 r0 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1 r0 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1
            r0.<init>(r11)
        L19:
            r11 = r0
            java.lang.Object r0 = r11.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r11.label
            r3 = 1
            switch(r2) {
                case 0: goto L3b;
                case 1: goto L2e;
                default: goto L26;
            }
        L26:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L2e:
            java.lang.Object r7 = r11.L$1
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.lang.Object r8 = r11.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
            kotlin.ResultKt.throwOnFailure(r0)
            r9 = r0
            goto L52
        L3b:
            kotlin.ResultKt.throwOnFailure(r0)
            r4 = r8
            r8 = r7
            r7 = r10
        L41:
            r11.L$0 = r8
            r11.L$1 = r7
            r11.label = r3
            java.lang.Object r9 = m260awaitDragOrCancellationrnUCldI(r8, r4, r11)
            if (r9 != r1) goto L4f
            return r1
        L4f:
            r6 = r0
            r0 = r9
            r9 = r6
        L52:
            androidx.compose.ui.input.pointer.PointerInputChange r0 = (androidx.compose.ui.input.pointer.PointerInputChange) r0
            if (r0 != 0) goto L5c
            r10 = 0
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r10)
            return r10
        L5c:
            r10 = r0
            boolean r0 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r10)
            if (r0 == 0) goto L68
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r0
        L68:
            r7.invoke(r10)
            long r4 = r10.getId()
            r0 = r9
            goto L41
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m275dragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ff, code lost:
    
        if (androidx.compose.ui.input.pointer.PointerEventKt.positionChangedIgnoreConsumed(r2) != false) goto L46;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0026. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0113 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x006e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x006f -> B:12:0x0078). Please report as a decompilation issue!!! */
    /* renamed from: awaitDragOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m260awaitDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r20, long r21, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r23) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m260awaitDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object detectDragGestures(PointerInputScope $this$detectDragGestures, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture($this$detectDragGestures, new DragGestureDetectorKt$detectDragGestures$5(function1, function2, function02, function0, null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    public static final Object detectDragGesturesAfterLongPress(PointerInputScope $this$detectDragGesturesAfterLongPress, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture($this$detectDragGesturesAfterLongPress, new DragGestureDetectorKt$detectDragGesturesAfterLongPress$5(function1, function0, function02, function2, null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0025. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x01fa A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00d6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0128 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0184 -> B:17:0x00ba). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x01e9 -> B:12:0x01f4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x024a -> B:17:0x00ba). Please report as a decompilation issue!!! */
    /* renamed from: awaitVerticalTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m272awaitVerticalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r25, long r26, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r28, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r29) {
        /*
            Method dump skipped, instructions count: 610
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m272awaitVerticalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0025. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x01f2 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00cf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0121 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x017d -> B:17:0x00b3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x01e3 -> B:12:0x01ec). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x0242 -> B:17:0x00b3). Please report as a decompilation issue!!! */
    /* renamed from: awaitVerticalPointerSlopOrCancellation-gDDlDlE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m271awaitVerticalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope r24, long r25, int r27, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r28, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r29) {
        /*
            Method dump skipped, instructions count: 604
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m271awaitVerticalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x013e, code lost:
    
        if ((!(androidx.compose.ui.geometry.Offset.m2711getYimpl(androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r2)) == 0.0f)) != false) goto L51;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0026. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x008d -> B:12:0x0099). Please report as a decompilation issue!!! */
    /* renamed from: verticalDrag-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m279verticalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r22, long r23, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, kotlin.Unit> r25, kotlin.coroutines.Continuation<? super java.lang.Boolean> r26) {
        /*
            Method dump skipped, instructions count: 400
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m279verticalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0112, code lost:
    
        if ((!(androidx.compose.ui.geometry.Offset.m2711getYimpl(androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r3)) == 0.0f)) != false) goto L50;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0026. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0124 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x006e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x006f -> B:12:0x0078). Please report as a decompilation issue!!! */
    /* renamed from: awaitVerticalDragOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m270awaitVerticalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r20, long r21, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r23) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m270awaitVerticalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object detectVerticalDragGestures(PointerInputScope $this$detectVerticalDragGestures, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture($this$detectVerticalDragGestures, new DragGestureDetectorKt$detectVerticalDragGestures$5(function1, function2, function0, function02, null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0025. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x01fa A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00d6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0128 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0184 -> B:17:0x00ba). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x01e9 -> B:12:0x01f4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x024a -> B:17:0x00ba). Please report as a decompilation issue!!! */
    /* renamed from: awaitHorizontalTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m264awaitHorizontalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r25, long r26, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r28, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r29) {
        /*
            Method dump skipped, instructions count: 610
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m264awaitHorizontalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0025. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x01f2 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00cf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0121 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x017d -> B:17:0x00b3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x01e3 -> B:12:0x01ec). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x0242 -> B:17:0x00b3). Please report as a decompilation issue!!! */
    /* renamed from: awaitHorizontalPointerSlopOrCancellation-gDDlDlE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m263awaitHorizontalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope r24, long r25, int r27, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r28, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r29) {
        /*
            Method dump skipped, instructions count: 604
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m263awaitHorizontalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x013e, code lost:
    
        if ((!(androidx.compose.ui.geometry.Offset.m2710getXimpl(androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r2)) == 0.0f)) != false) goto L51;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0026. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x008d -> B:12:0x0099). Please report as a decompilation issue!!! */
    /* renamed from: horizontalDrag-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m276horizontalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r22, long r23, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, kotlin.Unit> r25, kotlin.coroutines.Continuation<? super java.lang.Boolean> r26) {
        /*
            Method dump skipped, instructions count: 400
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m276horizontalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0112, code lost:
    
        if ((!(androidx.compose.ui.geometry.Offset.m2710getXimpl(androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r3)) == 0.0f)) != false) goto L50;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0026. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0124 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x006e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x006f -> B:12:0x0078). Please report as a decompilation issue!!! */
    /* renamed from: awaitHorizontalDragOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m262awaitHorizontalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r20, long r21, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r23) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m262awaitHorizontalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object detectHorizontalDragGestures(PointerInputScope $this$detectHorizontalDragGestures, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture($this$detectHorizontalDragGestures, new DragGestureDetectorKt$detectHorizontalDragGestures$5(function1, function2, function0, function02, null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0026. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x015c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ef A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x009c -> B:12:0x00aa). Please report as a decompilation issue!!! */
    /* renamed from: drag-VnAYq1g, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m273dragVnAYq1g(androidx.compose.ui.input.pointer.AwaitPointerEventScope r23, long r24, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, kotlin.Unit> r26, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Float> r27, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Boolean> r28, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r29) {
        /*
            Method dump skipped, instructions count: 420
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m273dragVnAYq1g(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: drag-VnAYq1g$$forInline, reason: not valid java name */
    private static final Object m274dragVnAYq1g$$forInline(AwaitPointerEventScope $this$drag_u2dVnAYq1g, long pointerId, Function1<? super PointerInputChange, Unit> function1, Function1<? super PointerInputChange, Float> function12, Function1<? super PointerInputChange, Boolean> function13, Continuation<? super PointerInputChange> continuation) {
        int i;
        AwaitPointerEventScope $this$awaitDragOrUp_u2djO51t88$iv;
        Object it$iv$iv;
        PointerInputChange dragEvent$iv;
        Object it$iv$iv2;
        int i2 = 0;
        PointerEventPass pointerEventPass = null;
        if (m277isPointerUpDmW0f2w($this$drag_u2dVnAYq1g.getCurrentEvent(), pointerId)) {
            return null;
        }
        long pointer = pointerId;
        while (true) {
            AwaitPointerEventScope $this$awaitDragOrUp_u2djO51t88$iv2 = $this$drag_u2dVnAYq1g;
            Ref.LongRef pointer$iv = new Ref.LongRef();
            pointer$iv.element = pointer;
            while (true) {
                InlineMarker.mark(0);
                Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitDragOrUp_u2djO51t88$iv2, pointerEventPass, continuation, 1, pointerEventPass);
                InlineMarker.mark(1);
                PointerEvent event$iv = (PointerEvent) awaitPointerEvent$default;
                List $this$fastFirstOrNull$iv$iv = event$iv.getChanges();
                int size = $this$fastFirstOrNull$iv$iv.size();
                int index$iv$iv$iv = 0;
                while (true) {
                    if (index$iv$iv$iv >= size) {
                        i = i2;
                        $this$awaitDragOrUp_u2djO51t88$iv = $this$awaitDragOrUp_u2djO51t88$iv2;
                        it$iv$iv = null;
                        break;
                    }
                    Object item$iv$iv$iv = $this$fastFirstOrNull$iv$iv.get(index$iv$iv$iv);
                    it$iv$iv = item$iv$iv$iv;
                    PointerInputChange it$iv = (PointerInputChange) it$iv$iv;
                    i = i2;
                    $this$awaitDragOrUp_u2djO51t88$iv = $this$awaitDragOrUp_u2djO51t88$iv2;
                    if (Boolean.valueOf(PointerId.m4051equalsimpl0(it$iv.getId(), pointer$iv.element)).booleanValue()) {
                        break;
                    }
                    index$iv$iv$iv++;
                    i2 = i;
                    $this$awaitDragOrUp_u2djO51t88$iv2 = $this$awaitDragOrUp_u2djO51t88$iv;
                }
                PointerInputChange pointerInputChange = (PointerInputChange) it$iv$iv;
                if (pointerInputChange == null) {
                    dragEvent$iv = null;
                    break;
                }
                dragEvent$iv = pointerInputChange;
                if (PointerEventKt.changedToUpIgnoreConsumed(dragEvent$iv)) {
                    List $this$fastFirstOrNull$iv$iv2 = event$iv.getChanges();
                    int index$iv$iv$iv2 = 0;
                    int size2 = $this$fastFirstOrNull$iv$iv2.size();
                    while (true) {
                        if (index$iv$iv$iv2 >= size2) {
                            it$iv$iv2 = null;
                            break;
                        }
                        Object item$iv$iv$iv2 = $this$fastFirstOrNull$iv$iv2.get(index$iv$iv$iv2);
                        it$iv$iv2 = item$iv$iv$iv2;
                        PointerInputChange it$iv2 = (PointerInputChange) it$iv$iv2;
                        if (Boolean.valueOf(it$iv2.getPressed()).booleanValue()) {
                            break;
                        }
                        index$iv$iv$iv2++;
                    }
                    PointerInputChange otherDown$iv = (PointerInputChange) it$iv$iv2;
                    if (otherDown$iv == null) {
                        break;
                    }
                    pointer$iv.element = otherDown$iv.getId();
                    i2 = i;
                    $this$awaitDragOrUp_u2djO51t88$iv2 = $this$awaitDragOrUp_u2djO51t88$iv;
                    pointerEventPass = null;
                } else {
                    PointerInputChange it = dragEvent$iv;
                    if (Boolean.valueOf(!(function12.invoke(it).floatValue() == 0.0f)).booleanValue()) {
                        break;
                    }
                    i2 = i;
                    $this$awaitDragOrUp_u2djO51t88$iv2 = $this$awaitDragOrUp_u2djO51t88$iv;
                    pointerEventPass = null;
                }
            }
            if (dragEvent$iv == null || function13.invoke(dragEvent$iv).booleanValue()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(dragEvent$iv)) {
                return dragEvent$iv;
            }
            function1.invoke(dragEvent$iv);
            pointer = dragEvent$iv.getId();
            i2 = i;
            pointerEventPass = null;
        }
    }

    /* renamed from: awaitDragOrUp-jO51t88, reason: not valid java name */
    private static final Object m261awaitDragOrUpjO51t88(AwaitPointerEventScope $this$awaitDragOrUp_u2djO51t88, long pointerId, Function1<? super PointerInputChange, Boolean> function1, Continuation<? super PointerInputChange> continuation) {
        PointerEvent event;
        Object it$iv;
        Object obj;
        Ref.LongRef pointer = new Ref.LongRef();
        pointer.element = pointerId;
        while (true) {
            InlineMarker.mark(0);
            Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitDragOrUp_u2djO51t88, null, continuation, 1, null);
            InlineMarker.mark(1);
            PointerEvent event2 = (PointerEvent) awaitPointerEvent$default;
            List $this$fastFirstOrNull$iv = event2.getChanges();
            int index$iv$iv = 0;
            int size = $this$fastFirstOrNull$iv.size();
            while (true) {
                if (index$iv$iv >= size) {
                    event = event2;
                    it$iv = null;
                    break;
                }
                it$iv = $this$fastFirstOrNull$iv.get(index$iv$iv);
                PointerInputChange it = (PointerInputChange) it$iv;
                event = event2;
                if (Boolean.valueOf(PointerId.m4051equalsimpl0(it.getId(), pointer.element)).booleanValue()) {
                    break;
                }
                index$iv$iv++;
                event2 = event;
            }
            PointerInputChange dragEvent = (PointerInputChange) it$iv;
            if (dragEvent == null) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(dragEvent)) {
                List $this$fastFirstOrNull$iv2 = event.getChanges();
                int index$iv$iv2 = 0;
                int size2 = $this$fastFirstOrNull$iv2.size();
                while (true) {
                    if (index$iv$iv2 >= size2) {
                        obj = null;
                        break;
                    }
                    Object item$iv$iv = $this$fastFirstOrNull$iv2.get(index$iv$iv2);
                    PointerInputChange it2 = (PointerInputChange) item$iv$iv;
                    if (Boolean.valueOf(it2.getPressed()).booleanValue()) {
                        obj = item$iv$iv;
                        break;
                    }
                    index$iv$iv2++;
                }
                PointerInputChange otherDown = (PointerInputChange) obj;
                if (otherDown == null) {
                    return dragEvent;
                }
                pointer.element = otherDown.getId();
            } else if (function1.invoke(dragEvent).booleanValue()) {
                return dragEvent;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0025. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x01e6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00cd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x011d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0170 -> B:17:0x00b1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x01d4 -> B:12:0x01e0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0227 -> B:17:0x00b1). Please report as a decompilation issue!!! */
    /* renamed from: awaitPointerSlopOrCancellation-wtdNQyU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m266awaitPointerSlopOrCancellationwtdNQyU(androidx.compose.ui.input.pointer.AwaitPointerEventScope r23, long r24, int r26, androidx.compose.foundation.gestures.PointerDirectionConfig r27, boolean r28, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super androidx.compose.ui.geometry.Offset, kotlin.Unit> r29, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r30) {
        /*
            Method dump skipped, instructions count: 572
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m266awaitPointerSlopOrCancellationwtdNQyU(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, androidx.compose.foundation.gestures.PointerDirectionConfig, boolean, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: awaitPointerSlopOrCancellation-wtdNQyU$default, reason: not valid java name */
    public static /* synthetic */ Object m268awaitPointerSlopOrCancellationwtdNQyU$default(AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default, long pointerId, int pointerType, PointerDirectionConfig pointerDirectionConfig, boolean triggerOnMainAxisSlop, Function2 onPointerSlopReached, Continuation $completion, int i, Object obj) {
        Object it$iv;
        Object it$iv2;
        long offset;
        AwaitPointerEventScope awaitPointerEventScope = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default;
        Continuation continuation = $completion;
        PointerDirectionConfig pointerDirectionConfig2 = (i & 4) != 0 ? getHorizontalPointerDirectionConfig() : pointerDirectionConfig;
        boolean triggerOnMainAxisSlop2 = (i & 8) != 0 ? true : triggerOnMainAxisSlop;
        float inDirection = 0.0f;
        PointerEventPass pointerEventPass = null;
        if (m277isPointerUpDmW0f2w($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default.getCurrentEvent(), pointerId)) {
            return null;
        }
        float touchSlop = m278pointerSlopE8SPZFQ($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default.getViewConfiguration(), pointerType);
        long pointer = pointerId;
        float totalMainPositionChange = 0.0f;
        float totalCrossPositionChange = 0.0f;
        while (true) {
            InlineMarker.mark(0);
            Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, pointerEventPass, continuation, 1, pointerEventPass);
            InlineMarker.mark(1);
            PointerEvent event = (PointerEvent) awaitPointerEvent$default;
            List $this$fastForEach$iv$iv = event.getChanges();
            int size = $this$fastForEach$iv$iv.size();
            int index$iv$iv = 0;
            while (true) {
                if (index$iv$iv >= size) {
                    it$iv = null;
                    break;
                }
                List $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv;
                Object item$iv$iv = $this$fastForEach$iv$iv2.get(index$iv$iv);
                it$iv = item$iv$iv;
                PointerInputChange it = (PointerInputChange) it$iv;
                if (PointerId.m4051equalsimpl0(it.getId(), pointer)) {
                    break;
                }
                index$iv$iv++;
                $this$fastForEach$iv$iv = $this$fastForEach$iv$iv2;
            }
            PointerInputChange dragEvent = (PointerInputChange) it$iv;
            if (dragEvent == null || dragEvent.isConsumed()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(dragEvent)) {
                List $this$fastFirstOrNull$iv = event.getChanges();
                float f = inDirection;
                int size2 = $this$fastFirstOrNull$iv.size();
                int index$iv$iv2 = 0;
                while (true) {
                    if (index$iv$iv2 >= size2) {
                        it$iv2 = null;
                        break;
                    }
                    Object item$iv$iv2 = $this$fastFirstOrNull$iv.get(index$iv$iv2);
                    it$iv2 = item$iv$iv2;
                    PointerInputChange it2 = (PointerInputChange) it$iv2;
                    if (it2.getPressed()) {
                        break;
                    }
                    index$iv$iv2++;
                }
                PointerInputChange otherDown = (PointerInputChange) it$iv2;
                if (otherDown == null) {
                    return null;
                }
                pointer = otherDown.getId();
                inDirection = f;
                pointerEventPass = null;
            } else {
                float f2 = inDirection;
                long currentPosition = dragEvent.getPosition();
                long previousPosition = dragEvent.getPreviousPosition();
                float mainPositionChange = pointerDirectionConfig2.mo281mainAxisDeltak4lQ0M(currentPosition) - pointerDirectionConfig2.mo281mainAxisDeltak4lQ0M(previousPosition);
                float crossPositionChange = pointerDirectionConfig2.mo280crossAxisDeltak4lQ0M(currentPosition) - pointerDirectionConfig2.mo280crossAxisDeltak4lQ0M(previousPosition);
                totalMainPositionChange += mainPositionChange;
                totalCrossPositionChange += crossPositionChange;
                float inDirection2 = triggerOnMainAxisSlop2 ? Math.abs(totalMainPositionChange) : Offset.m2708getDistanceimpl(pointerDirectionConfig2.mo282offsetFromChangesdBAh8RU(totalMainPositionChange, totalCrossPositionChange));
                if (inDirection2 < touchSlop) {
                    PointerEventPass pointerEventPass2 = PointerEventPass.Final;
                    InlineMarker.mark(0);
                    awaitPointerEventScope.awaitPointerEvent(pointerEventPass2, continuation);
                    InlineMarker.mark(1);
                    if (dragEvent.isConsumed()) {
                        return null;
                    }
                    inDirection = f2;
                    pointerEventPass = null;
                } else {
                    if (triggerOnMainAxisSlop2) {
                        float finalMainPositionChange = totalMainPositionChange - (Math.signum(totalMainPositionChange) * touchSlop);
                        offset = pointerDirectionConfig2.mo282offsetFromChangesdBAh8RU(finalMainPositionChange, totalCrossPositionChange);
                    } else {
                        long offset2 = pointerDirectionConfig2.mo282offsetFromChangesdBAh8RU(totalMainPositionChange, totalCrossPositionChange);
                        long touchSlopOffset = Offset.m2717timestuRUvjQ(Offset.m2705divtuRUvjQ(offset2, inDirection2), touchSlop);
                        offset = Offset.m2714minusMKHz9U(offset2, touchSlopOffset);
                    }
                    long touchSlopOffset2 = offset;
                    onPointerSlopReached.invoke(dragEvent, Offset.m2699boximpl(touchSlopOffset2));
                    if (dragEvent.isConsumed()) {
                        return dragEvent;
                    }
                    totalMainPositionChange = 0.0f;
                    totalCrossPositionChange = 0.0f;
                    awaitPointerEventScope = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default;
                    inDirection = f2;
                    continuation = $completion;
                    pointerEventPass = null;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: awaitPointerSlopOrCancellation-wtdNQyU$$forInline, reason: not valid java name */
    private static final Object m267awaitPointerSlopOrCancellationwtdNQyU$$forInline(AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dwtdNQyU, long pointerId, int pointerType, PointerDirectionConfig pointerDirectionConfig, boolean triggerOnMainAxisSlop, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        Object it$iv;
        int i;
        long offset;
        Object it$iv2;
        Continuation<? super PointerEvent> continuation2 = continuation;
        int i2 = 0;
        PointerEventPass pointerEventPass = null;
        if (m277isPointerUpDmW0f2w($this$awaitPointerSlopOrCancellation_u2dwtdNQyU.getCurrentEvent(), pointerId)) {
            return null;
        }
        float touchSlop = m278pointerSlopE8SPZFQ($this$awaitPointerSlopOrCancellation_u2dwtdNQyU.getViewConfiguration(), pointerType);
        Ref.LongRef pointer = new Ref.LongRef();
        pointer.element = pointerId;
        float totalMainPositionChange = 0.0f;
        float totalCrossPositionChange = 0.0f;
        while (true) {
            InlineMarker.mark(0);
            Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerSlopOrCancellation_u2dwtdNQyU, pointerEventPass, continuation2, 1, pointerEventPass);
            InlineMarker.mark(1);
            PointerEvent event = (PointerEvent) awaitPointerEvent$default;
            List $this$fastForEach$iv$iv = event.getChanges();
            int size = $this$fastForEach$iv$iv.size();
            int index$iv$iv = 0;
            while (true) {
                if (index$iv$iv >= size) {
                    it$iv = null;
                    break;
                }
                List $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv;
                Object item$iv$iv = $this$fastForEach$iv$iv2.get(index$iv$iv);
                it$iv = item$iv$iv;
                PointerInputChange it = (PointerInputChange) it$iv;
                if (Boolean.valueOf(PointerId.m4051equalsimpl0(it.getId(), pointer.element)).booleanValue()) {
                    break;
                }
                index$iv$iv++;
                $this$fastForEach$iv$iv = $this$fastForEach$iv$iv2;
            }
            PointerInputChange dragEvent = (PointerInputChange) it$iv;
            if (dragEvent == null || dragEvent.isConsumed()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(dragEvent)) {
                List $this$fastFirstOrNull$iv = event.getChanges();
                int index$iv$iv2 = 0;
                int size2 = $this$fastFirstOrNull$iv.size();
                while (true) {
                    if (index$iv$iv2 >= size2) {
                        it$iv2 = null;
                        break;
                    }
                    Object item$iv$iv2 = $this$fastFirstOrNull$iv.get(index$iv$iv2);
                    it$iv2 = item$iv$iv2;
                    PointerInputChange it2 = (PointerInputChange) it$iv2;
                    if (Boolean.valueOf(it2.getPressed()).booleanValue()) {
                        break;
                    }
                    index$iv$iv2++;
                }
                PointerInputChange otherDown = (PointerInputChange) it$iv2;
                if (otherDown == null) {
                    return null;
                }
                pointer.element = otherDown.getId();
                i = i2;
            } else {
                long currentPosition = dragEvent.getPosition();
                long previousPosition = dragEvent.getPreviousPosition();
                float mainPositionChange = pointerDirectionConfig.mo281mainAxisDeltak4lQ0M(currentPosition) - pointerDirectionConfig.mo281mainAxisDeltak4lQ0M(previousPosition);
                float crossPositionChange = pointerDirectionConfig.mo280crossAxisDeltak4lQ0M(currentPosition) - pointerDirectionConfig.mo280crossAxisDeltak4lQ0M(previousPosition);
                totalMainPositionChange += mainPositionChange;
                totalCrossPositionChange += crossPositionChange;
                float inDirection = triggerOnMainAxisSlop ? Math.abs(totalMainPositionChange) : Offset.m2708getDistanceimpl(pointerDirectionConfig.mo282offsetFromChangesdBAh8RU(totalMainPositionChange, totalCrossPositionChange));
                if (inDirection < touchSlop) {
                    i = i2;
                    PointerEventPass pointerEventPass2 = PointerEventPass.Final;
                    InlineMarker.mark(0);
                    $this$awaitPointerSlopOrCancellation_u2dwtdNQyU.awaitPointerEvent(pointerEventPass2, continuation2);
                    InlineMarker.mark(1);
                    if (dragEvent.isConsumed()) {
                        return null;
                    }
                } else {
                    i = i2;
                    if (triggerOnMainAxisSlop) {
                        float finalMainPositionChange = totalMainPositionChange - (Math.signum(totalMainPositionChange) * touchSlop);
                        offset = pointerDirectionConfig.mo282offsetFromChangesdBAh8RU(finalMainPositionChange, totalCrossPositionChange);
                    } else {
                        long offset2 = pointerDirectionConfig.mo282offsetFromChangesdBAh8RU(totalMainPositionChange, totalCrossPositionChange);
                        long touchSlopOffset = Offset.m2717timestuRUvjQ(Offset.m2705divtuRUvjQ(offset2, inDirection), touchSlop);
                        offset = Offset.m2714minusMKHz9U(offset2, touchSlopOffset);
                    }
                    function2.invoke(dragEvent, Offset.m2699boximpl(offset));
                    if (dragEvent.isConsumed()) {
                        return dragEvent;
                    }
                    totalCrossPositionChange = 0.0f;
                    totalMainPositionChange = 0.0f;
                }
            }
            continuation2 = continuation;
            i2 = i;
            pointerEventPass = null;
        }
    }

    static {
        float arg0$iv = mouseSlop;
        float other$iv = defaultTouchSlop;
        mouseToTouchSlopRatio = arg0$iv / other$iv;
    }

    public static final PointerDirectionConfig getHorizontalPointerDirectionConfig() {
        return HorizontalPointerDirectionConfig;
    }

    public static final PointerDirectionConfig getVerticalPointerDirectionConfig() {
        return VerticalPointerDirectionConfig;
    }

    public static final PointerDirectionConfig toPointerDirectionConfig(Orientation $this$toPointerDirectionConfig) {
        Intrinsics.checkNotNullParameter($this$toPointerDirectionConfig, "<this>");
        return $this$toPointerDirectionConfig == Orientation.Vertical ? VerticalPointerDirectionConfig : HorizontalPointerDirectionConfig;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Type inference failed for: r5v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [androidx.compose.ui.input.pointer.PointerInputChange] */
    /* renamed from: awaitLongPressOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m265awaitLongPressOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r20) {
        /*
            r0 = r20
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1
            if (r1 == 0) goto L16
            r1 = r0
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1 r1 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L16
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L1b
        L16:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1 r1 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1
            r1.<init>(r0)
        L1b:
            r0 = r1
            java.lang.Object r2 = r1.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 0
            switch(r3) {
                case 0: goto L42;
                case 1: goto L30;
                default: goto L28;
            }
        L28:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L30:
            java.lang.Object r0 = r1.L$1
            r3 = r0
            kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref.ObjectRef) r3
            java.lang.Object r0 = r1.L$0
            r5 = r0
            androidx.compose.ui.input.pointer.PointerInputChange r5 = (androidx.compose.ui.input.pointer.PointerInputChange) r5
            kotlin.ResultKt.throwOnFailure(r2)     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L3f
            goto Lc1
        L3f:
            r0 = move-exception
            goto Lc5
        L42:
            kotlin.ResultKt.throwOnFailure(r2)
            r3 = r17
            r5 = r18
            androidx.compose.ui.input.pointer.PointerEvent r7 = r3.getCurrentEvent()
            boolean r7 = m277isPointerUpDmW0f2w(r7, r5)
            if (r7 == 0) goto L54
            return r4
        L54:
            androidx.compose.ui.input.pointer.PointerEvent r7 = r3.getCurrentEvent()
            java.util.List r7 = r7.getChanges()
            r8 = 0
            r9 = 0
            r10 = 0
            int r11 = r7.size()
        L66:
            if (r10 >= r11) goto L8a
            java.lang.Object r12 = r7.get(r10)
            r13 = r12
            r14 = 0
            r15 = r13
            androidx.compose.ui.input.pointer.PointerInputChange r15 = (androidx.compose.ui.input.pointer.PointerInputChange) r15
            r16 = 0
            r18 = r7
            r17 = r8
            long r7 = r15.getId()
            boolean r7 = androidx.compose.ui.input.pointer.PointerId.m4051equalsimpl0(r7, r5)
            if (r7 == 0) goto L82
            goto L90
        L82:
            int r10 = r10 + 1
            r8 = r17
            r7 = r18
            goto L66
        L8a:
            r18 = r7
            r17 = r8
            r13 = r4
        L90:
            androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
            if (r13 != 0) goto L95
            return r4
        L95:
            r5 = r13
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            r7.element = r5
            androidx.compose.ui.platform.ViewConfiguration r8 = r3.getViewConfiguration()
            long r8 = r8.getLongPressTimeoutMillis()
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2 r10 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> Lc3
            r10.<init>(r7, r6, r4)     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> Lc3
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> Lc3
            r1.L$0 = r5     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> Lc3
            r1.L$1 = r6     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> Lc3
            r11 = 1
            r1.label = r11     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> Lc3
            java.lang.Object r10 = r3.withTimeout(r8, r10, r1)     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> Lc3
            if (r10 != r0) goto Lc0
            return r0
        Lc0:
            r3 = r6
        Lc1:
            goto Lce
        Lc3:
            r0 = move-exception
            r3 = r6
        Lc5:
            T r0 = r3.element
            androidx.compose.ui.input.pointer.PointerInputChange r0 = (androidx.compose.ui.input.pointer.PointerInputChange) r0
            if (r0 != 0) goto Lcd
            r4 = r5
            goto Lce
        Lcd:
            r4 = r0
        Lce:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m265awaitLongPressOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: isPointerUp-DmW0f2w, reason: not valid java name */
    public static final boolean m277isPointerUpDmW0f2w(PointerEvent $this$isPointerUp_u2dDmW0f2w, long pointerId) {
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

    /* renamed from: pointerSlop-E8SPZFQ, reason: not valid java name */
    public static final float m278pointerSlopE8SPZFQ(ViewConfiguration pointerSlop, int pointerType) {
        Intrinsics.checkNotNullParameter(pointerSlop, "$this$pointerSlop");
        return PointerType.m4139equalsimpl0(pointerType, PointerType.INSTANCE.m4144getMouseT8wyACA()) ? pointerSlop.getTouchSlop() * mouseToTouchSlopRatio : pointerSlop.getTouchSlop();
    }
}
