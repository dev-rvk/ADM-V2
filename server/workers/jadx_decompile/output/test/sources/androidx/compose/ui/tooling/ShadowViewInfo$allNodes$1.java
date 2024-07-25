package androidx.compose.ui.tooling;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* compiled from: ShadowViewInfo.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Landroidx/compose/ui/tooling/ShadowViewInfo;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.ui.tooling.ShadowViewInfo$allNodes$1", f = "ShadowViewInfo.kt", i = {0, 1}, l = {45, 46}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence"}, s = {"L$0", "L$0"})
/* loaded from: classes.dex */
final class ShadowViewInfo$allNodes$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super ShadowViewInfo>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ShadowViewInfo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShadowViewInfo$allNodes$1(ShadowViewInfo shadowViewInfo, Continuation<? super ShadowViewInfo$allNodes$1> continuation) {
        super(2, continuation);
        this.this$0 = shadowViewInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ShadowViewInfo$allNodes$1 shadowViewInfo$allNodes$1 = new ShadowViewInfo$allNodes$1(this.this$0, continuation);
        shadowViewInfo$allNodes$1.L$0 = obj;
        return shadowViewInfo$allNodes$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super ShadowViewInfo> sequenceScope, Continuation<? super Unit> continuation) {
        return ((ShadowViewInfo$allNodes$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0006. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005e A[LOOP:1: B:20:0x0058->B:22:0x005e, LOOP_END] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            switch(r1) {
                case 0: goto L2a;
                case 1: goto L21;
                case 2: goto L11;
                default: goto L9;
            }
        L9:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L11:
            r1 = r11
            r2 = 0
            r3 = 0
            java.lang.Object r4 = r1.L$1
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r5 = r1.L$0
            kotlin.sequences.SequenceScope r5 = (kotlin.sequences.SequenceScope) r5
            kotlin.ResultKt.throwOnFailure(r12)
            goto L9b
        L21:
            r1 = r11
            java.lang.Object r2 = r1.L$0
            kotlin.sequences.SequenceScope r2 = (kotlin.sequences.SequenceScope) r2
            kotlin.ResultKt.throwOnFailure(r12)
            goto L43
        L2a:
            kotlin.ResultKt.throwOnFailure(r12)
            r1 = r11
            java.lang.Object r2 = r1.L$0
            kotlin.sequences.SequenceScope r2 = (kotlin.sequences.SequenceScope) r2
            androidx.compose.ui.tooling.ShadowViewInfo r3 = r1.this$0
            r4 = r1
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r1.L$0 = r2
            r5 = 1
            r1.label = r5
            java.lang.Object r3 = r2.yield(r3, r4)
            if (r3 != r0) goto L43
            return r0
        L43:
            androidx.compose.ui.tooling.ShadowViewInfo r3 = r1.this$0
            java.util.List r3 = r3.getChildren()
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            r4 = 0
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Collection r5 = (java.util.Collection) r5
            r6 = 0
            java.util.Iterator r7 = r3.iterator()
        L58:
            boolean r3 = r7.hasNext()
            if (r3 == 0) goto L6f
            java.lang.Object r3 = r7.next()
            r8 = r3
            androidx.compose.ui.tooling.ShadowViewInfo r8 = (androidx.compose.ui.tooling.ShadowViewInfo) r8
            r9 = 0
            kotlin.sequences.Sequence r8 = r8.getAllNodes()
            kotlin.collections.CollectionsKt.addAll(r5, r8)
            goto L58
        L6f:
            r3 = r5
            java.util.List r3 = (java.util.List) r3
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            r4 = 0
            java.util.Iterator r5 = r3.iterator()
            r10 = r5
            r5 = r2
            r2 = r4
            r4 = r10
        L7f:
            boolean r3 = r4.hasNext()
            if (r3 == 0) goto L9d
            java.lang.Object r3 = r4.next()
            androidx.compose.ui.tooling.ShadowViewInfo r3 = (androidx.compose.ui.tooling.ShadowViewInfo) r3
            r6 = 0
            r1.L$0 = r5
            r1.L$1 = r4
            r7 = 2
            r1.label = r7
            java.lang.Object r3 = r5.yield(r3, r1)
            if (r3 != r0) goto L9a
            return r0
        L9a:
            r3 = r6
        L9b:
            goto L7f
        L9d:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.ShadowViewInfo$allNodes$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
