package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ForEachGesture.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0015\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u0015\u0010\u0003\u001a\u00020\u0004*\u00020\u0006H\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a>\u0010\b\u001a\u00020\u0004*\u00020\u00062'\u0010\t\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n¢\u0006\u0002\b\rH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a>\u0010\u000f\u001a\u00020\u0004*\u00020\u00062'\u0010\t\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n¢\u0006\u0002\b\rH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"allPointersUp", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "awaitAllPointersUp", "", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitEachGesture", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "forEachGesture", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ForEachGestureKt {
    /* JADX WARN: Can't wrap try/catch for region: R(6:1|(2:3|(4:5|6|7|8))|44|6|7|8) */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0064, code lost:
    
        r3 = e;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0022. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0076 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0098 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.compose.ui.input.pointer.PointerInputScope, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.compose.ui.input.pointer.PointerInputScope, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r6v0, types: [androidx.compose.ui.input.pointer.PointerInputScope] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object, kotlin.coroutines.CoroutineContext] */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0099 -> B:13:0x006f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00b7 -> B:13:0x006f). Please report as a decompilation issue!!! */
    @kotlin.Deprecated(message = "Use awaitEachGesture instead. forEachGesture() can drop events between gestures.", replaceWith = @kotlin.ReplaceWith(expression = "awaitEachGesture(block)", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object forEachGesture(androidx.compose.ui.input.pointer.PointerInputScope r6, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            Method dump skipped, instructions count: 204
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ForEachGestureKt.forEachGesture(androidx.compose.ui.input.pointer.PointerInputScope, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final boolean allPointersUp(AwaitPointerEventScope $this$allPointersUp) {
        boolean z;
        Intrinsics.checkNotNullParameter($this$allPointersUp, "<this>");
        List $this$fastAny$iv = $this$allPointersUp.getCurrentEvent().getChanges();
        int index$iv$iv = 0;
        int size = $this$fastAny$iv.size();
        while (true) {
            if (index$iv$iv < size) {
                Object item$iv$iv = $this$fastAny$iv.get(index$iv$iv);
                PointerInputChange it = (PointerInputChange) item$iv$iv;
                if (it.getPressed()) {
                    z = true;
                    break;
                }
                index$iv$iv++;
            } else {
                z = false;
                break;
            }
        }
        return !z;
    }

    public static final Object awaitAllPointersUp(PointerInputScope $this$awaitAllPointersUp, Continuation<? super Unit> continuation) {
        Object awaitPointerEventScope = $this$awaitAllPointersUp.awaitPointerEventScope(new ForEachGestureKt$awaitAllPointersUp$2(null), continuation);
        return awaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitPointerEventScope : Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x003f, code lost:
    
        if (allPointersUp(r14) == false) goto L15;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0023. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x004e -> B:12:0x0052). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object awaitAllPointersUp(androidx.compose.ui.input.pointer.AwaitPointerEventScope r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            boolean r0 = r15 instanceof androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3
            if (r0 == 0) goto L14
            r0 = r15
            androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3 r0 = (androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L19
        L14:
            androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3 r0 = new androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3
            r0.<init>(r15)
        L19:
            r15 = r0
            java.lang.Object r0 = r15.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r15.label
            r3 = 1
            switch(r2) {
                case 0: goto L38;
                case 1: goto L2e;
                default: goto L26;
            }
        L26:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L2e:
            java.lang.Object r14 = r15.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r14 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r14
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r1
            r1 = r0
            goto L52
        L38:
            kotlin.ResultKt.throwOnFailure(r0)
            boolean r2 = allPointersUp(r14)
            if (r2 != 0) goto L83
        L41:
            androidx.compose.ui.input.pointer.PointerEventPass r2 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r15.L$0 = r14
            r15.label = r3
            java.lang.Object r2 = r14.awaitPointerEvent(r2, r15)
            if (r2 != r1) goto L4e
            return r1
        L4e:
            r13 = r1
            r1 = r0
            r0 = r2
            r2 = r13
        L52:
            androidx.compose.ui.input.pointer.PointerEvent r0 = (androidx.compose.ui.input.pointer.PointerEvent) r0
            java.util.List r0 = r0.getChanges()
            r4 = 0
            r5 = 0
            r6 = 0
            int r7 = r0.size()
        L62:
            if (r6 >= r7) goto L7a
            java.lang.Object r8 = r0.get(r6)
            r9 = r8
            r10 = 0
            r11 = r9
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            r12 = 0
            boolean r11 = r11.getPressed()
            if (r11 == 0) goto L76
            r0 = r3
            goto L7c
        L76:
            int r6 = r6 + 1
            goto L62
        L7a:
            r0 = 0
        L7c:
            if (r0 != 0) goto L80
            r0 = r1
            goto L83
        L80:
            r0 = r1
            r1 = r2
            goto L41
        L83:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ForEachGestureKt.awaitAllPointersUp(androidx.compose.ui.input.pointer.AwaitPointerEventScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object awaitEachGesture(PointerInputScope $this$awaitEachGesture, Function2<? super AwaitPointerEventScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        CoroutineContext currentContext = continuation.get$context();
        Object awaitPointerEventScope = $this$awaitEachGesture.awaitPointerEventScope(new ForEachGestureKt$awaitEachGesture$2(currentContext, function2, null), continuation);
        return awaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitPointerEventScope : Unit.INSTANCE;
    }
}
