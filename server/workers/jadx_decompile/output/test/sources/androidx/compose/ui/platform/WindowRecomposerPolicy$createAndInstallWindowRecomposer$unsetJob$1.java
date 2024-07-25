package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Recomposer;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WindowRecomposer.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.ui.platform.WindowRecomposerPolicy$createAndInstallWindowRecomposer$unsetJob$1", f = "WindowRecomposer.android.kt", i = {}, l = {233}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class WindowRecomposerPolicy$createAndInstallWindowRecomposer$unsetJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Recomposer $newRecomposer;
    final /* synthetic */ View $rootView;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WindowRecomposerPolicy$createAndInstallWindowRecomposer$unsetJob$1(Recomposer recomposer, View view, Continuation<? super WindowRecomposerPolicy$createAndInstallWindowRecomposer$unsetJob$1> continuation) {
        super(2, continuation);
        this.$newRecomposer = recomposer;
        this.$rootView = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WindowRecomposerPolicy$createAndInstallWindowRecomposer$unsetJob$1(this.$newRecomposer, this.$rootView, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WindowRecomposerPolicy$createAndInstallWindowRecomposer$unsetJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0007. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004f  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 0
            switch(r1) {
                case 0: goto L19;
                case 1: goto L12;
                default: goto La;
            }
        La:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L12:
            r0 = r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L17
            goto L2e
        L17:
            r1 = move-exception
            goto L45
        L19:
            kotlin.ResultKt.throwOnFailure(r8)
            r1 = r7
            androidx.compose.runtime.Recomposer r3 = r1.$newRecomposer     // Catch: java.lang.Throwable -> L41
            r4 = r1
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4     // Catch: java.lang.Throwable -> L41
            r5 = 1
            r1.label = r5     // Catch: java.lang.Throwable -> L41
            java.lang.Object r3 = r3.join(r4)     // Catch: java.lang.Throwable -> L41
            if (r3 != r0) goto L2d
            return r0
        L2d:
            r0 = r1
        L2e:
            android.view.View r1 = r0.$rootView
            androidx.compose.runtime.CompositionContext r1 = androidx.compose.ui.platform.WindowRecomposer_androidKt.getCompositionContext(r1)
            androidx.compose.runtime.Recomposer r3 = r0.$newRecomposer
            if (r1 != r3) goto L3d
            android.view.View r1 = r0.$rootView
            androidx.compose.ui.platform.WindowRecomposer_androidKt.setCompositionContext(r1, r2)
        L3d:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L41:
            r0 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
        L45:
            android.view.View r3 = r0.$rootView
            androidx.compose.runtime.CompositionContext r3 = androidx.compose.ui.platform.WindowRecomposer_androidKt.getCompositionContext(r3)
            androidx.compose.runtime.Recomposer r4 = r0.$newRecomposer
            if (r3 != r4) goto L54
            android.view.View r3 = r0.$rootView
            androidx.compose.ui.platform.WindowRecomposer_androidKt.setCompositionContext(r3, r2)
        L54:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.WindowRecomposerPolicy$createAndInstallWindowRecomposer$unsetJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
