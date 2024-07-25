package androidx.compose.foundation.layout;

import android.graphics.Insets;
import android.os.CancellationSignal;
import android.view.View;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.WindowInsetsController;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Velocity;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Job;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WindowInsetsConnection.android.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0019H\u0002J\b\u0010#\u001a\u00020!H\u0002J\u0006\u0010$\u001a\u00020!J1\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u0017H\u0082@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b*\u0010+J\u0013\u0010,\u001a\u0004\u0018\u00010\rH\u0082@ø\u0001\u0001¢\u0006\u0002\u0010-J\u0012\u0010.\u001a\u00020!2\b\u0010/\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u00100\u001a\u00020!2\u0006\u0010/\u001a\u00020\rH\u0016J)\u00101\u001a\u00020&2\u0006\u00102\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0096@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b3\u00104J-\u00105\u001a\u0002062\u0006\u00102\u001a\u0002062\u0006\u0010'\u001a\u0002062\u0006\u00107\u001a\u000208H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b9\u0010:J!\u0010;\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0096@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b<\u0010=J%\u0010>\u001a\u0002062\u0006\u0010'\u001a\u0002062\u0006\u00107\u001a\u000208H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b?\u0010@J\u0018\u0010A\u001a\u00020!2\u0006\u0010/\u001a\u00020\r2\u0006\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u00020!H\u0002J%\u0010E\u001a\u0002062\u0006\u0010'\u001a\u0002062\u0006\u0010F\u001a\u00020\u0019H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bG\u0010HR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006I"}, d2 = {"Landroidx/compose/foundation/layout/WindowInsetsNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroid/view/WindowInsetsAnimationControlListener;", "windowInsets", "Landroidx/compose/foundation/layout/AndroidWindowInsets;", "view", "Landroid/view/View;", "sideCalculator", "Landroidx/compose/foundation/layout/SideCalculator;", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/foundation/layout/AndroidWindowInsets;Landroid/view/View;Landroidx/compose/foundation/layout/SideCalculator;Landroidx/compose/ui/unit/Density;)V", "animationController", "Landroid/view/WindowInsetsAnimationController;", "animationJob", "Lkotlinx/coroutines/Job;", "cancellationSignal", "Landroid/os/CancellationSignal;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "isControllerRequested", "", "partialConsumption", "", "getSideCalculator", "()Landroidx/compose/foundation/layout/SideCalculator;", "getView", "()Landroid/view/View;", "getWindowInsets", "()Landroidx/compose/foundation/layout/AndroidWindowInsets;", "adjustInsets", "", "inset", "animationEnded", "dispose", "fling", "Landroidx/compose/ui/unit/Velocity;", "available", "flingAmount", "towardShown", "fling-huYlsQE", "(JFZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAnimationController", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCancelled", "controller", "onFinished", "onPostFling", "consumed", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "onReady", "types", "", "requestAnimationController", "scroll", "scrollAmount", "scroll-8S9VItk", "(JF)J", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class WindowInsetsNestedScrollConnection implements NestedScrollConnection, WindowInsetsAnimationControlListener {
    private WindowInsetsAnimationController animationController;
    private Job animationJob;
    private final CancellationSignal cancellationSignal;
    private CancellableContinuation<? super WindowInsetsAnimationController> continuation;
    private final Density density;
    private boolean isControllerRequested;
    private float partialConsumption;
    private final SideCalculator sideCalculator;
    private final View view;
    private final AndroidWindowInsets windowInsets;

    public WindowInsetsNestedScrollConnection(AndroidWindowInsets windowInsets, View view, SideCalculator sideCalculator, Density density) {
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(sideCalculator, "sideCalculator");
        Intrinsics.checkNotNullParameter(density, "density");
        this.windowInsets = windowInsets;
        this.view = view;
        this.sideCalculator = sideCalculator;
        this.density = density;
        this.cancellationSignal = new CancellationSignal();
    }

    public final AndroidWindowInsets getWindowInsets() {
        return this.windowInsets;
    }

    public final View getView() {
        return this.view;
    }

    public final SideCalculator getSideCalculator() {
        return this.sideCalculator;
    }

    public final Density getDensity() {
        return this.density;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestAnimationController() {
        if (!this.isControllerRequested) {
            this.isControllerRequested = true;
            WindowInsetsController windowInsetsController = this.view.getWindowInsetsController();
            if (windowInsetsController != null) {
                windowInsetsController.controlWindowInsetsAnimation(this.windowInsets.getType(), -1L, null, this.cancellationSignal, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getAnimationController(Continuation<? super WindowInsetsAnimationController> continuation) {
        WindowInsetsAnimationController windowInsetsAnimationController = this.animationController;
        if (windowInsetsAnimationController != null) {
            return windowInsetsAnimationController;
        }
        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellable$iv.initCancellability();
        CancellableContinuationImpl continuation2 = cancellable$iv;
        this.continuation = continuation2;
        requestAnimationController();
        Object result = cancellable$iv.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreScroll-OzD1aCk */
    public long mo338onPreScrollOzD1aCk(long available, int source) {
        return m560scroll8S9VItk(available, this.sideCalculator.hideMotion(Offset.m2710getXimpl(available), Offset.m2711getYimpl(available)));
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M */
    public long mo337onPostScrollDzOQY0M(long consumed, long available, int source) {
        return m560scroll8S9VItk(available, this.sideCalculator.showMotion(Offset.m2710getXimpl(available), Offset.m2711getYimpl(available)));
    }

    /* renamed from: scroll-8S9VItk, reason: not valid java name */
    private final long m560scroll8S9VItk(long available, float scrollAmount) {
        Job it = this.animationJob;
        if (it != null) {
            it.cancel((CancellationException) new WindowInsetsAnimationCancelledException());
            this.animationJob = null;
        }
        WindowInsetsAnimationController animationController = this.animationController;
        if (!(scrollAmount == 0.0f)) {
            if (this.windowInsets.isVisible() != (scrollAmount > 0.0f) || animationController != null) {
                if (animationController == null) {
                    this.partialConsumption = 0.0f;
                    requestAnimationController();
                    return this.sideCalculator.mo512consumedOffsetsMKHz9U(available);
                }
                SideCalculator sideCalculator = this.sideCalculator;
                Insets hiddenStateInsets = animationController.getHiddenStateInsets();
                Intrinsics.checkNotNullExpressionValue(hiddenStateInsets, "animationController.hiddenStateInsets");
                int hidden = sideCalculator.valueOf(hiddenStateInsets);
                SideCalculator sideCalculator2 = this.sideCalculator;
                Insets shownStateInsets = animationController.getShownStateInsets();
                Intrinsics.checkNotNullExpressionValue(shownStateInsets, "animationController.shownStateInsets");
                int shown = sideCalculator2.valueOf(shownStateInsets);
                Insets currentInsets = animationController.getCurrentInsets();
                Intrinsics.checkNotNullExpressionValue(currentInsets, "animationController.currentInsets");
                int current = this.sideCalculator.valueOf(currentInsets);
                int target = scrollAmount > 0.0f ? shown : hidden;
                if (current == target) {
                    this.partialConsumption = 0.0f;
                    return Offset.INSTANCE.m2726getZeroF1C5BW0();
                }
                float total = current + scrollAmount + this.partialConsumption;
                int next = RangesKt.coerceIn(MathKt.roundToInt(total), hidden, shown);
                this.partialConsumption = total - MathKt.roundToInt(total);
                if (next != current) {
                    animationController.setInsetsAndAlpha(this.sideCalculator.adjustInsets(currentInsets, next), 1.0f, 0.0f);
                }
                return this.sideCalculator.mo512consumedOffsetsMKHz9U(available);
            }
        }
        return Offset.INSTANCE.m2726getZeroF1C5BW0();
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreFling-QWom1Mo, reason: not valid java name */
    public Object mo561onPreFlingQWom1Mo(long available, Continuation<? super Velocity> continuation) {
        return m559flinghuYlsQE(available, this.sideCalculator.hideMotion(Velocity.m5443getXimpl(available), Velocity.m5444getYimpl(available)), false, continuation);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostFling-RZ2iAVY */
    public Object mo336onPostFlingRZ2iAVY(long consumed, long available, Continuation<? super Velocity> continuation) {
        return m559flinghuYlsQE(available, this.sideCalculator.showMotion(Velocity.m5443getXimpl(available), Velocity.m5444getYimpl(available)), true, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x002c. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    /* renamed from: fling-huYlsQE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m559flinghuYlsQE(long r27, float r29, boolean r30, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r31) {
        /*
            Method dump skipped, instructions count: 468
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection.m559flinghuYlsQE(long, float, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void adjustInsets(float inset) {
        WindowInsetsAnimationController it = this.animationController;
        if (it != null) {
            Insets currentInsets = it.getCurrentInsets();
            Intrinsics.checkNotNullExpressionValue(currentInsets, "it.currentInsets");
            Insets nextInsets = this.sideCalculator.adjustInsets(currentInsets, MathKt.roundToInt(inset));
            it.setInsetsAndAlpha(nextInsets, 1.0f, 0.0f);
        }
    }

    @Override // android.view.WindowInsetsAnimationControlListener
    public void onReady(WindowInsetsAnimationController controller, int types) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        this.animationController = controller;
        this.isControllerRequested = false;
        CancellableContinuation<? super WindowInsetsAnimationController> cancellableContinuation = this.continuation;
        if (cancellableContinuation != null) {
            cancellableContinuation.resume(controller, new Function1<Throwable, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$onReady$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }
            });
        }
        this.continuation = null;
    }

    public final void dispose() {
        CancellableContinuation<? super WindowInsetsAnimationController> cancellableContinuation = this.continuation;
        if (cancellableContinuation != null) {
            cancellableContinuation.resume(null, new Function1<Throwable, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$dispose$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }
            });
        }
        Job job = this.animationJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        WindowInsetsAnimationController animationController = this.animationController;
        if (animationController != null) {
            boolean visible = !Intrinsics.areEqual(animationController.getCurrentInsets(), animationController.getHiddenStateInsets());
            animationController.finish(visible);
        }
    }

    @Override // android.view.WindowInsetsAnimationControlListener
    public void onFinished(WindowInsetsAnimationController controller) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        animationEnded();
    }

    @Override // android.view.WindowInsetsAnimationControlListener
    public void onCancelled(WindowInsetsAnimationController controller) {
        animationEnded();
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
    
        if (r0.isReady() == true) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void animationEnded() {
        /*
            r4 = this;
            android.view.WindowInsetsAnimationController r0 = r4.animationController
            r1 = 0
            if (r0 == 0) goto Ld
            boolean r0 = r0.isReady()
            r2 = 1
            if (r0 != r2) goto Ld
            goto Le
        Ld:
            r2 = r1
        Le:
            if (r2 == 0) goto L1d
            android.view.WindowInsetsAnimationController r0 = r4.animationController
            if (r0 == 0) goto L1d
            androidx.compose.foundation.layout.AndroidWindowInsets r2 = r4.windowInsets
            boolean r2 = r2.isVisible()
            r0.finish(r2)
        L1d:
            r0 = 0
            r4.animationController = r0
            kotlinx.coroutines.CancellableContinuation<? super android.view.WindowInsetsAnimationController> r2 = r4.continuation
            if (r2 == 0) goto L2b
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$animationEnded$1 r3 = new kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$animationEnded$1
                static {
                    /*
                        androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$animationEnded$1 r0 = new androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$animationEnded$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$animationEnded$1) androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$animationEnded$1.INSTANCE androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$animationEnded$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$animationEnded$1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 1
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$animationEnded$1.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.Unit invoke(java.lang.Throwable r2) {
                    /*
                        r1 = this;
                        r0 = r2
                        java.lang.Throwable r0 = (java.lang.Throwable) r0
                        r1.invoke2(r0)
                        kotlin.Unit r0 = kotlin.Unit.INSTANCE
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$animationEnded$1.invoke(java.lang.Object):java.lang.Object");
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(java.lang.Throwable r2) {
                    /*
                        r1 = this;
                        java.lang.String r0 = "it"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$animationEnded$1.invoke2(java.lang.Throwable):void");
                }
            }
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r2.resume(r0, r3)
        L2b:
            r4.continuation = r0
            kotlinx.coroutines.Job r2 = r4.animationJob
            if (r2 == 0) goto L3b
            androidx.compose.foundation.layout.WindowInsetsAnimationCancelledException r3 = new androidx.compose.foundation.layout.WindowInsetsAnimationCancelledException
            r3.<init>()
            java.util.concurrent.CancellationException r3 = (java.util.concurrent.CancellationException) r3
            r2.cancel(r3)
        L3b:
            r4.animationJob = r0
            r0 = 0
            r4.partialConsumption = r0
            r4.isControllerRequested = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection.animationEnded():void");
    }
}
