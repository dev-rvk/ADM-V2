package androidx.compose.foundation.layout;

import android.view.WindowInsetsAnimationController;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WindowInsetsConnection.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$2", f = "WindowInsetsConnection.android.kt", i = {}, l = {364}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class WindowInsetsNestedScrollConnection$fling$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WindowInsetsAnimationController $animationController;
    final /* synthetic */ int $current;
    final /* synthetic */ Ref.FloatRef $endVelocity;
    final /* synthetic */ float $flingAmount;
    final /* synthetic */ int $hidden;
    final /* synthetic */ int $shown;
    final /* synthetic */ SplineBasedFloatDecayAnimationSpec $spec;
    final /* synthetic */ boolean $targetShown;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WindowInsetsNestedScrollConnection this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WindowInsetsNestedScrollConnection$fling$2(WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection, int i, float f, SplineBasedFloatDecayAnimationSpec splineBasedFloatDecayAnimationSpec, int i2, int i3, Ref.FloatRef floatRef, WindowInsetsAnimationController windowInsetsAnimationController, boolean z, Continuation<? super WindowInsetsNestedScrollConnection$fling$2> continuation) {
        super(2, continuation);
        this.this$0 = windowInsetsNestedScrollConnection;
        this.$current = i;
        this.$flingAmount = f;
        this.$spec = splineBasedFloatDecayAnimationSpec;
        this.$hidden = i2;
        this.$shown = i3;
        this.$endVelocity = floatRef;
        this.$animationController = windowInsetsAnimationController;
        this.$targetShown = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WindowInsetsNestedScrollConnection$fling$2 windowInsetsNestedScrollConnection$fling$2 = new WindowInsetsNestedScrollConnection$fling$2(this.this$0, this.$current, this.$flingAmount, this.$spec, this.$hidden, this.$shown, this.$endVelocity, this.$animationController, this.$targetShown, continuation);
        windowInsetsNestedScrollConnection$fling$2.L$0 = obj;
        return windowInsetsNestedScrollConnection$fling$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WindowInsetsNestedScrollConnection$fling$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WindowInsetsConnection.android.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$2$1", f = "WindowInsetsConnection.android.kt", i = {}, l = {348}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$2$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ WindowInsetsAnimationController $animationController;
        final /* synthetic */ int $current;
        final /* synthetic */ Ref.FloatRef $endVelocity;
        final /* synthetic */ float $flingAmount;
        final /* synthetic */ int $hidden;
        final /* synthetic */ int $shown;
        final /* synthetic */ SplineBasedFloatDecayAnimationSpec $spec;
        final /* synthetic */ boolean $targetShown;
        int label;
        final /* synthetic */ WindowInsetsNestedScrollConnection this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i, float f, SplineBasedFloatDecayAnimationSpec splineBasedFloatDecayAnimationSpec, int i2, int i3, WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection, Ref.FloatRef floatRef, WindowInsetsAnimationController windowInsetsAnimationController, boolean z, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$current = i;
            this.$flingAmount = f;
            this.$spec = splineBasedFloatDecayAnimationSpec;
            this.$hidden = i2;
            this.$shown = i3;
            this.this$0 = windowInsetsNestedScrollConnection;
            this.$endVelocity = floatRef;
            this.$animationController = windowInsetsAnimationController;
            this.$targetShown = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$current, this.$flingAmount, this.$spec, this.$hidden, this.$shown, this.this$0, this.$endVelocity, this.$animationController, this.$targetShown, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    float f = this.$current;
                    float f2 = this.$flingAmount;
                    SplineBasedFloatDecayAnimationSpec splineBasedFloatDecayAnimationSpec = this.$spec;
                    final int i = this.$hidden;
                    final int i2 = this.$shown;
                    final WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection = this.this$0;
                    final Ref.FloatRef floatRef = this.$endVelocity;
                    final WindowInsetsAnimationController windowInsetsAnimationController = this.$animationController;
                    final boolean z = this.$targetShown;
                    this.label = 1;
                    if (SuspendAnimationKt.animateDecay(f, f2, splineBasedFloatDecayAnimationSpec, new Function2<Float, Float, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection.fling.2.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Float f3, Float f4) {
                            invoke(f3.floatValue(), f4.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float value, float velocity) {
                            Job job;
                            float f3 = i;
                            boolean z2 = false;
                            if (value <= i2 && f3 <= value) {
                                z2 = true;
                            }
                            if (z2) {
                                windowInsetsNestedScrollConnection.adjustInsets(value);
                                return;
                            }
                            floatRef.element = velocity;
                            windowInsetsAnimationController.finish(z);
                            windowInsetsNestedScrollConnection.animationController = null;
                            job = windowInsetsNestedScrollConnection.animationJob;
                            if (job != null) {
                                job.cancel((CancellationException) new WindowInsetsAnimationCancelledException());
                            }
                        }
                    }, this) != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0008. Please report as an issue. */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        WindowInsetsNestedScrollConnection$fling$2 windowInsetsNestedScrollConnection$fling$2;
        Job launch$default;
        Job job;
        WindowInsetsNestedScrollConnection$fling$2 windowInsetsNestedScrollConnection$fling$22;
        Object $result2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                windowInsetsNestedScrollConnection$fling$2 = this;
                CoroutineScope $this$coroutineScope = (CoroutineScope) windowInsetsNestedScrollConnection$fling$2.L$0;
                WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection = windowInsetsNestedScrollConnection$fling$2.this$0;
                launch$default = BuildersKt__Builders_commonKt.launch$default($this$coroutineScope, null, null, new AnonymousClass1(windowInsetsNestedScrollConnection$fling$2.$current, windowInsetsNestedScrollConnection$fling$2.$flingAmount, windowInsetsNestedScrollConnection$fling$2.$spec, windowInsetsNestedScrollConnection$fling$2.$hidden, windowInsetsNestedScrollConnection$fling$2.$shown, windowInsetsNestedScrollConnection$fling$2.this$0, windowInsetsNestedScrollConnection$fling$2.$endVelocity, windowInsetsNestedScrollConnection$fling$2.$animationController, windowInsetsNestedScrollConnection$fling$2.$targetShown, null), 3, null);
                windowInsetsNestedScrollConnection.animationJob = launch$default;
                job = windowInsetsNestedScrollConnection$fling$2.this$0.animationJob;
                if (job != null) {
                    windowInsetsNestedScrollConnection$fling$2.label = 1;
                    if (job.join(windowInsetsNestedScrollConnection$fling$2) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    windowInsetsNestedScrollConnection$fling$22 = windowInsetsNestedScrollConnection$fling$2;
                    $result2 = $result;
                    windowInsetsNestedScrollConnection$fling$2 = windowInsetsNestedScrollConnection$fling$22;
                }
                windowInsetsNestedScrollConnection$fling$2.this$0.animationJob = null;
                return Unit.INSTANCE;
            case 1:
                windowInsetsNestedScrollConnection$fling$22 = this;
                $result2 = $result;
                ResultKt.throwOnFailure($result2);
                windowInsetsNestedScrollConnection$fling$2 = windowInsetsNestedScrollConnection$fling$22;
                windowInsetsNestedScrollConnection$fling$2.this$0.animationJob = null;
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
