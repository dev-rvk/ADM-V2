package androidx.compose.foundation.relocation;

import androidx.compose.runtime.collection.MutableVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BringIntoViewRequester.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001b\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\fR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Landroidx/compose/foundation/relocation/BringIntoViewRequesterImpl;", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "()V", "modifiers", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/relocation/BringIntoViewRequesterNode;", "getModifiers", "()Landroidx/compose/runtime/collection/MutableVector;", "bringIntoView", "", "rect", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class BringIntoViewRequesterImpl implements BringIntoViewRequester {
    private final MutableVector<BringIntoViewRequesterNode> modifiers = new MutableVector<>(new BringIntoViewRequesterNode[16], 0);

    public final MutableVector<BringIntoViewRequesterNode> getModifiers() {
        return this.modifiers;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0023. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x006e -> B:12:0x006f). Please report as a decompilation issue!!! */
    @Override // androidx.compose.foundation.relocation.BringIntoViewRequester
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object bringIntoView(androidx.compose.ui.geometry.Rect r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1
            if (r0 == 0) goto L14
            r0 = r12
            androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1 r0 = (androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1 r0 = new androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1
            r0.<init>(r10, r12)
        L19:
            r12 = r0
            java.lang.Object r0 = r12.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r12.label
            r3 = 1
            switch(r2) {
                case 0: goto L40;
                case 1: goto L2e;
                default: goto L26;
            }
        L26:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L2e:
            r11 = 0
            r2 = 0
            int r4 = r12.I$1
            int r5 = r12.I$0
            java.lang.Object r6 = r12.L$1
            java.lang.Object[] r6 = (java.lang.Object[]) r6
            java.lang.Object r7 = r12.L$0
            androidx.compose.ui.geometry.Rect r7 = (androidx.compose.ui.geometry.Rect) r7
            kotlin.ResultKt.throwOnFailure(r0)
            goto L6f
        L40:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r10
            androidx.compose.runtime.collection.MutableVector<androidx.compose.foundation.relocation.BringIntoViewRequesterNode> r2 = r2.modifiers
            r4 = 0
            int r5 = r2.getSize()
            if (r5 <= 0) goto L75
            r6 = 0
            java.lang.Object[] r7 = r2.getContent()
            r9 = r7
            r7 = r11
            r11 = r4
            r4 = r6
            r6 = r9
        L58:
            r2 = r6[r4]
            androidx.compose.foundation.relocation.BringIntoViewRequesterNode r2 = (androidx.compose.foundation.relocation.BringIntoViewRequesterNode) r2
            r8 = 0
            r12.L$0 = r7
            r12.L$1 = r6
            r12.I$0 = r5
            r12.I$1 = r4
            r12.label = r3
            java.lang.Object r2 = r2.bringIntoView(r7, r12)
            if (r2 != r1) goto L6e
            return r1
        L6e:
            r2 = r8
        L6f:
            int r4 = r4 + r3
            if (r4 < r5) goto L58
            r4 = r11
        L75:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.relocation.BringIntoViewRequesterImpl.bringIntoView(androidx.compose.ui.geometry.Rect, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
