package androidx.compose.ui.platform;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.View;
import android.view.ViewParent;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MonotonicFrameClock;
import androidx.compose.runtime.PausableMonotonicFrameClock;
import androidx.compose.runtime.Recomposer;
import androidx.compose.ui.MotionDurationScale;
import androidx.compose.ui.R;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.HandlerCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: WindowRecomposer.android.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0017\u001a\u00020\u0002H\u0002\u001a\"\u0010\u0018\u001a\u00020\u0011*\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007\u001a\f\u0010\u001d\u001a\u0004\u0018\u00010\u0006*\u00020\b\" \u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\",\u0010\u0007\u001a\u0004\u0018\u00010\u0006*\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\"\u0018\u0010\r\u001a\u00020\b*\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u001e\u0010\u0010\u001a\u00020\u0011*\u00020\b8@X\u0080\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"animationScale", "", "Landroid/content/Context;", "Lkotlinx/coroutines/flow/StateFlow;", "", "value", "Landroidx/compose/runtime/CompositionContext;", "compositionContext", "Landroid/view/View;", "getCompositionContext", "(Landroid/view/View;)Landroidx/compose/runtime/CompositionContext;", "setCompositionContext", "(Landroid/view/View;Landroidx/compose/runtime/CompositionContext;)V", "contentChild", "getContentChild", "(Landroid/view/View;)Landroid/view/View;", "windowRecomposer", "Landroidx/compose/runtime/Recomposer;", "getWindowRecomposer$annotations", "(Landroid/view/View;)V", "getWindowRecomposer", "(Landroid/view/View;)Landroidx/compose/runtime/Recomposer;", "getAnimationScaleFlowFor", "applicationContext", "createLifecycleAwareWindowRecomposer", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "findViewTreeCompositionContext", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class WindowRecomposer_androidKt {
    private static final Map<Context, StateFlow<Float>> animationScale = new LinkedHashMap();

    public static /* synthetic */ void getWindowRecomposer$annotations(View view) {
    }

    public static final CompositionContext getCompositionContext(View $this$compositionContext) {
        Intrinsics.checkNotNullParameter($this$compositionContext, "<this>");
        Object tag = $this$compositionContext.getTag(R.id.androidx_compose_ui_view_composition_context);
        if (tag instanceof CompositionContext) {
            return (CompositionContext) tag;
        }
        return null;
    }

    public static final void setCompositionContext(View $this$compositionContext, CompositionContext value) {
        Intrinsics.checkNotNullParameter($this$compositionContext, "<this>");
        $this$compositionContext.setTag(R.id.androidx_compose_ui_view_composition_context, value);
    }

    public static final CompositionContext findViewTreeCompositionContext(View $this$findViewTreeCompositionContext) {
        Intrinsics.checkNotNullParameter($this$findViewTreeCompositionContext, "<this>");
        CompositionContext found = getCompositionContext($this$findViewTreeCompositionContext);
        if (found != null) {
            return found;
        }
        for (ViewParent parent = $this$findViewTreeCompositionContext.getParent(); found == null && (parent instanceof View); parent = parent.getParent()) {
            found = getCompositionContext((View) parent);
        }
        return found;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1] */
    public static final StateFlow<Float> getAnimationScaleFlowFor(Context applicationContext) {
        StateFlow<Float> stateFlow;
        StateFlow<Float> stateFlow2;
        Object lock$iv = animationScale;
        synchronized (lock$iv) {
            Map $this$getOrPut$iv = animationScale;
            StateFlow<Float> stateFlow3 = $this$getOrPut$iv.get(applicationContext);
            if (stateFlow3 == null) {
                ContentResolver resolver = applicationContext.getContentResolver();
                Uri animationScaleUri = Settings.Global.getUriFor("animator_duration_scale");
                final Channel channel = ChannelKt.Channel$default(-1, null, null, 6, null);
                final Handler createAsync = HandlerCompat.createAsync(Looper.getMainLooper());
                stateFlow = FlowKt.stateIn(FlowKt.flow(new WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1(resolver, animationScaleUri, new ContentObserver(createAsync) { // from class: androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1
                    @Override // android.database.ContentObserver
                    public void onChange(boolean selfChange, Uri uri) {
                        channel.mo7116trySendJP2dKIU(Unit.INSTANCE);
                    }
                }, channel, applicationContext, null)), CoroutineScopeKt.MainScope(), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 0L, 0L, 3, null), Float.valueOf(Settings.Global.getFloat(applicationContext.getContentResolver(), "animator_duration_scale", 1.0f)));
                $this$getOrPut$iv.put(applicationContext, stateFlow);
            } else {
                stateFlow = stateFlow3;
            }
            stateFlow2 = stateFlow;
        }
        return stateFlow2;
    }

    private static final View getContentChild(View $this$contentChild) {
        View self = $this$contentChild;
        ViewParent parent = self.getParent();
        while (parent instanceof View) {
            if (((View) parent).getId() == 16908290) {
                return self;
            }
            self = parent;
            parent = self.getParent();
        }
        return self;
    }

    public static final Recomposer getWindowRecomposer(View $this$windowRecomposer) {
        Intrinsics.checkNotNullParameter($this$windowRecomposer, "<this>");
        if (!$this$windowRecomposer.isAttachedToWindow()) {
            throw new IllegalStateException(("Cannot locate windowRecomposer; View " + $this$windowRecomposer + " is not attached to a window").toString());
        }
        View rootView = getContentChild($this$windowRecomposer);
        CompositionContext rootParentRef = getCompositionContext(rootView);
        if (rootParentRef == null) {
            return WindowRecomposerPolicy.INSTANCE.createAndInstallWindowRecomposer$ui_release(rootView);
        }
        if (rootParentRef instanceof Recomposer) {
            return (Recomposer) rootParentRef;
        }
        throw new IllegalStateException("root viewTreeParentCompositionContext is not a Recomposer".toString());
    }

    public static /* synthetic */ Recomposer createLifecycleAwareWindowRecomposer$default(View view, CoroutineContext coroutineContext, Lifecycle lifecycle, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            lifecycle = null;
        }
        return createLifecycleAwareWindowRecomposer(view, coroutineContext, lifecycle);
    }

    /* JADX WARN: Type inference failed for: r0v36, types: [T, androidx.compose.ui.platform.MotionDurationScaleImpl] */
    public static final Recomposer createLifecycleAwareWindowRecomposer(final View $this$createLifecycleAwareWindowRecomposer, CoroutineContext coroutineContext, Lifecycle lifecycle) {
        CoroutineContext plus;
        PausableMonotonicFrameClock $this$createLifecycleAwareWindowRecomposer_u24lambda_u244_u24lambda_u243;
        Intrinsics.checkNotNullParameter($this$createLifecycleAwareWindowRecomposer, "<this>");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        if (coroutineContext.get(ContinuationInterceptor.INSTANCE) == null || coroutineContext.get(MonotonicFrameClock.INSTANCE) == null) {
            plus = AndroidUiDispatcher.INSTANCE.getCurrentThread().plus(coroutineContext);
        } else {
            plus = coroutineContext;
        }
        CoroutineContext baseContext = plus;
        MonotonicFrameClock it = (MonotonicFrameClock) baseContext.get(MonotonicFrameClock.INSTANCE);
        Lifecycle lifecycle2 = null;
        if (it != null) {
            $this$createLifecycleAwareWindowRecomposer_u24lambda_u244_u24lambda_u243 = new PausableMonotonicFrameClock(it);
            $this$createLifecycleAwareWindowRecomposer_u24lambda_u244_u24lambda_u243.pause();
        } else {
            $this$createLifecycleAwareWindowRecomposer_u24lambda_u244_u24lambda_u243 = null;
        }
        final PausableMonotonicFrameClock pausableClock = $this$createLifecycleAwareWindowRecomposer_u24lambda_u244_u24lambda_u243;
        final Ref.ObjectRef systemDurationScaleSettingConsumer = new Ref.ObjectRef();
        MotionDurationScale motionDurationScale = (MotionDurationScale) baseContext.get(MotionDurationScale.INSTANCE);
        if (motionDurationScale == null) {
            ?? motionDurationScaleImpl = new MotionDurationScaleImpl();
            systemDurationScaleSettingConsumer.element = motionDurationScaleImpl;
            motionDurationScale = (MotionDurationScale) motionDurationScaleImpl;
        }
        MotionDurationScale motionDurationScale2 = motionDurationScale;
        CoroutineContext contextWithClockAndMotionScale = baseContext.plus(pausableClock != null ? pausableClock : EmptyCoroutineContext.INSTANCE).plus(motionDurationScale2);
        final Recomposer it2 = new Recomposer(contextWithClockAndMotionScale);
        it2.pauseCompositionFrameClock();
        final CoroutineScope runRecomposeScope = CoroutineScopeKt.CoroutineScope(contextWithClockAndMotionScale);
        if (lifecycle == null) {
            LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get($this$createLifecycleAwareWindowRecomposer);
            if (lifecycleOwner != null) {
                lifecycle2 = lifecycleOwner.getLifecycleRegistry();
            }
        } else {
            lifecycle2 = lifecycle;
        }
        if (lifecycle2 != null) {
            Lifecycle viewTreeLifecycle = lifecycle2;
            $this$createLifecycleAwareWindowRecomposer.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View v) {
                    Intrinsics.checkNotNullParameter(v, "v");
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View v) {
                    Intrinsics.checkNotNullParameter(v, "v");
                    $this$createLifecycleAwareWindowRecomposer.removeOnAttachStateChangeListener(this);
                    it2.cancel();
                }
            });
            viewTreeLifecycle.addObserver(new LifecycleEventObserver() { // from class: androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2

                /* compiled from: WindowRecomposer.android.kt */
                @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                /* loaded from: classes.dex */
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[Lifecycle.Event.values().length];
                        try {
                            iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
                        } catch (NoSuchFieldError e) {
                        }
                        try {
                            iArr[Lifecycle.Event.ON_START.ordinal()] = 2;
                        } catch (NoSuchFieldError e2) {
                        }
                        try {
                            iArr[Lifecycle.Event.ON_STOP.ordinal()] = 3;
                        } catch (NoSuchFieldError e3) {
                        }
                        try {
                            iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 4;
                        } catch (NoSuchFieldError e4) {
                        }
                        try {
                            iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 5;
                        } catch (NoSuchFieldError e5) {
                        }
                        try {
                            iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 6;
                        } catch (NoSuchFieldError e6) {
                        }
                        try {
                            iArr[Lifecycle.Event.ON_ANY.ordinal()] = 7;
                        } catch (NoSuchFieldError e7) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                    Intrinsics.checkNotNullParameter(source, "source");
                    Intrinsics.checkNotNullParameter(event, "event");
                    switch (WhenMappings.$EnumSwitchMapping$0[event.ordinal()]) {
                        case 1:
                            BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, CoroutineStart.UNDISPATCHED, new WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1(systemDurationScaleSettingConsumer, it2, source, this, $this$createLifecycleAwareWindowRecomposer, null), 1, null);
                            return;
                        case 2:
                            PausableMonotonicFrameClock pausableMonotonicFrameClock = pausableClock;
                            if (pausableMonotonicFrameClock != null) {
                                pausableMonotonicFrameClock.resume();
                            }
                            it2.resumeCompositionFrameClock();
                            return;
                        case 3:
                            it2.pauseCompositionFrameClock();
                            return;
                        case 4:
                            it2.cancel();
                            return;
                        default:
                            return;
                    }
                }
            });
            return it2;
        }
        throw new IllegalStateException(("ViewTreeLifecycleOwner not found from " + $this$createLifecycleAwareWindowRecomposer).toString());
    }
}
