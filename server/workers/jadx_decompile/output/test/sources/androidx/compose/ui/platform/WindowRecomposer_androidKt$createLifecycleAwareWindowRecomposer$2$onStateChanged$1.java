package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Recomposer;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WindowRecomposer.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1", f = "WindowRecomposer.android.kt", i = {0}, l = {394}, m = "invokeSuspend", n = {"durationScaleJob"}, s = {"L$0"})
/* loaded from: classes.dex */
final class WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Recomposer $recomposer;
    final /* synthetic */ WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 $self;
    final /* synthetic */ LifecycleOwner $source;
    final /* synthetic */ Ref.ObjectRef<MotionDurationScaleImpl> $systemDurationScaleSettingConsumer;
    final /* synthetic */ View $this_createLifecycleAwareWindowRecomposer;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1(Ref.ObjectRef<MotionDurationScaleImpl> objectRef, Recomposer recomposer, LifecycleOwner lifecycleOwner, WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2, View view, Continuation<? super WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1> continuation) {
        super(2, continuation);
        this.$systemDurationScaleSettingConsumer = objectRef;
        this.$recomposer = recomposer;
        this.$source = lifecycleOwner;
        this.$self = windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2;
        this.$this_createLifecycleAwareWindowRecomposer = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1 windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1 = new WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1(this.$systemDurationScaleSettingConsumer, this.$recomposer, this.$source, this.$self, this.$this_createLifecycleAwareWindowRecomposer, continuation);
        windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1.L$0 = obj;
        return windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000a. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0089  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            r18 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r1 = r18
            int r2 = r1.label
            r3 = 1
            r4 = 0
            switch(r2) {
                case 0: goto L25;
                case 1: goto L15;
                default: goto Ld;
            }
        Ld:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L15:
            r2 = r18
            r5 = r19
            java.lang.Object r0 = r2.L$0
            r6 = r0
            kotlinx.coroutines.Job r6 = (kotlinx.coroutines.Job) r6
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Throwable -> L22
            goto L86
        L22:
            r0 = move-exception
            goto L9f
        L25:
            kotlin.ResultKt.throwOnFailure(r19)
            r2 = r18
            r5 = r19
            java.lang.Object r6 = r2.L$0
            kotlinx.coroutines.CoroutineScope r6 = (kotlinx.coroutines.CoroutineScope) r6
            r13 = 0
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.platform.MotionDurationScaleImpl> r7 = r2.$systemDurationScaleSettingConsumer     // Catch: java.lang.Throwable -> L9d
            T r7 = r7.element     // Catch: java.lang.Throwable -> L9d
            androidx.compose.ui.platform.MotionDurationScaleImpl r7 = (androidx.compose.ui.platform.MotionDurationScaleImpl) r7     // Catch: java.lang.Throwable -> L9d
            if (r7 == 0) goto L74
            android.view.View r8 = r2.$this_createLifecycleAwareWindowRecomposer     // Catch: java.lang.Throwable -> L9d
            r14 = r7
            r15 = 0
            android.content.Context r7 = r8.getContext()     // Catch: java.lang.Throwable -> L9d
            android.content.Context r7 = r7.getApplicationContext()     // Catch: java.lang.Throwable -> L9d
            java.lang.String r8 = "context.applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)     // Catch: java.lang.Throwable -> L9d
            kotlinx.coroutines.flow.StateFlow r7 = androidx.compose.ui.platform.WindowRecomposer_androidKt.access$getAnimationScaleFlowFor(r7)     // Catch: java.lang.Throwable -> L9d
            r12 = r7
            java.lang.Object r7 = r12.getValue()     // Catch: java.lang.Throwable -> L9d
            java.lang.Number r7 = (java.lang.Number) r7     // Catch: java.lang.Throwable -> L9d
            float r7 = r7.floatValue()     // Catch: java.lang.Throwable -> L9d
            r14.setScaleFactor(r7)     // Catch: java.lang.Throwable -> L9d
            androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1$1$1 r7 = new androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1$1$1     // Catch: java.lang.Throwable -> L9d
            r7.<init>(r12, r14, r4)     // Catch: java.lang.Throwable -> L9d
            r10 = r7
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10     // Catch: java.lang.Throwable -> L9d
            r11 = 3
            r16 = 0
            r8 = 0
            r9 = 0
            r7 = r6
            r17 = r12
            r12 = r16
            kotlinx.coroutines.Job r7 = kotlinx.coroutines.BuildersKt.launch$default(r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> L9d
            goto L75
        L74:
            r7 = r4
        L75:
            r6 = r7
            androidx.compose.runtime.Recomposer r7 = r2.$recomposer     // Catch: java.lang.Throwable -> L22
            r8 = r2
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8     // Catch: java.lang.Throwable -> L22
            r2.L$0 = r6     // Catch: java.lang.Throwable -> L22
            r2.label = r3     // Catch: java.lang.Throwable -> L22
            java.lang.Object r7 = r7.runRecomposeAndApplyChanges(r8)     // Catch: java.lang.Throwable -> L22
            if (r7 != r0) goto L86
            return r0
        L86:
            if (r6 == 0) goto L8c
            kotlinx.coroutines.Job.DefaultImpls.cancel$default(r6, r4, r3, r4)
        L8c:
            androidx.lifecycle.LifecycleOwner r0 = r2.$source
            androidx.lifecycle.Lifecycle r0 = r0.getLifecycleRegistry()
            androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 r3 = r2.$self
            androidx.lifecycle.LifecycleObserver r3 = (androidx.lifecycle.LifecycleObserver) r3
            r0.removeObserver(r3)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L9d:
            r0 = move-exception
            r6 = r13
        L9f:
            if (r6 == 0) goto La4
            kotlinx.coroutines.Job.DefaultImpls.cancel$default(r6, r4, r3, r4)
        La4:
            androidx.lifecycle.LifecycleOwner r3 = r2.$source
            androidx.lifecycle.Lifecycle r3 = r3.getLifecycleRegistry()
            androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 r4 = r2.$self
            androidx.lifecycle.LifecycleObserver r4 = (androidx.lifecycle.LifecycleObserver) r4
            r3.removeObserver(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
