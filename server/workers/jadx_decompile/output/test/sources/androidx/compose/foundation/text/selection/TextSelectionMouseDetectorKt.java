package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* compiled from: TextSelectionMouseDetector.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u001d\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"ClicksSlop", "", "awaitMouseEventDown", "Landroidx/compose/ui/input/pointer/PointerEvent;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mouseSelectionDetector", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "observer", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/text/selection/MouseSelectionObserver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextSelectionMouseDetectorKt {
    public static final double ClicksSlop = 100.0d;

    public static final Object mouseSelectionDetector(PointerInputScope $this$mouseSelectionDetector, MouseSelectionObserver observer, Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture($this$mouseSelectionDetector, new TextSelectionMouseDetectorKt$mouseSelectionDetector$2(observer, null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0025. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x004c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x004d -> B:12:0x0054). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object awaitMouseEventDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerEvent> r18) {
        /*
            r0 = r18
            boolean r1 = r0 instanceof androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$awaitMouseEventDown$1
            if (r1 == 0) goto L16
            r1 = r0
            androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$awaitMouseEventDown$1 r1 = (androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$awaitMouseEventDown$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L16
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L1b
        L16:
            androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$awaitMouseEventDown$1 r1 = new androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$awaitMouseEventDown$1
            r1.<init>(r0)
        L1b:
            r0 = r1
            java.lang.Object r1 = r0.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.label
            r4 = 1
            switch(r3) {
                case 0: goto L3b;
                case 1: goto L30;
                default: goto L28;
            }
        L28:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L30:
            java.lang.Object r3 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r3
            kotlin.ResultKt.throwOnFailure(r1)
            r5 = r3
            r3 = r2
            r2 = r1
            goto L54
        L3b:
            kotlin.ResultKt.throwOnFailure(r1)
            r3 = r17
        L40:
            androidx.compose.ui.input.pointer.PointerEventPass r5 = androidx.compose.ui.input.pointer.PointerEventPass.Main
            r0.L$0 = r3
            r0.label = r4
            java.lang.Object r5 = r3.awaitPointerEvent(r5, r0)
            if (r5 != r2) goto L4d
            return r2
        L4d:
            r16 = r2
            r2 = r1
            r1 = r5
            r5 = r3
            r3 = r16
        L54:
            androidx.compose.ui.input.pointer.PointerEvent r1 = (androidx.compose.ui.input.pointer.PointerEvent) r1
            int r6 = r1.getButtons()
            boolean r6 = androidx.compose.ui.input.pointer.PointerEvent_androidKt.m4042isPrimaryPressedaHzCxE(r6)
            if (r6 == 0) goto La0
            java.util.List r6 = r1.getChanges()
            r7 = 0
            r8 = 0
            r9 = 0
            int r10 = r6.size()
        L6f:
            if (r9 >= r10) goto L9b
            java.lang.Object r11 = r6.get(r9)
            r12 = 0
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            r13 = 0
            int r14 = r11.getType()
            androidx.compose.ui.input.pointer.PointerType$Companion r15 = androidx.compose.ui.input.pointer.PointerType.INSTANCE
            int r15 = r15.m4144getMouseT8wyACA()
            boolean r14 = androidx.compose.ui.input.pointer.PointerType.m4139equalsimpl0(r14, r15)
            r15 = 0
            if (r14 == 0) goto L93
            boolean r14 = androidx.compose.ui.input.pointer.PointerEventKt.changedToDown(r11)
            if (r14 == 0) goto L93
            r11 = r4
            goto L94
        L93:
            r11 = r15
        L94:
            if (r11 != 0) goto L97
            goto L9d
        L97:
            int r9 = r9 + 1
            goto L6f
        L9b:
            r15 = r4
        L9d:
            if (r15 == 0) goto La0
            return r1
        La0:
            r1 = r2
            r2 = r3
            r3 = r5
            goto L40
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt.awaitMouseEventDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
