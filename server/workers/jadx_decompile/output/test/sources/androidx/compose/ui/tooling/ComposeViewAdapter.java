package androidx.compose.ui.tooling;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.compose.LocalActivityResultRegistryOwner;
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewRootForTest;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyResolver_androidKt;
import androidx.compose.ui.tooling.animation.AnimationSearch;
import androidx.compose.ui.tooling.animation.PreviewAnimationClock;
import androidx.compose.ui.tooling.data.Group;
import androidx.compose.ui.tooling.data.NodeGroup;
import androidx.compose.ui.tooling.data.SlotTreeKt;
import androidx.compose.ui.tooling.data.SourceLocation;
import androidx.compose.ui.tooling.preview.PreviewParameterProvider;
import androidx.compose.ui.unit.IntRect;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityOptionsCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.text.StringsKt;

/* compiled from: ComposeViewAdapter.kt */
@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0004\u000b\u000e\u0011\u0014\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ \u0010Q\u001a\u00020(2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020(0'¢\u0006\u0002\b)H\u0003¢\u0006\u0002\u0010RJ\u0010\u0010S\u001a\u00020(2\u0006\u0010T\u001a\u00020UH\u0014J\r\u0010V\u001a\u00020(H\u0000¢\u0006\u0002\bWJ\b\u0010X\u001a\u00020(H\u0002J\b\u0010Y\u001a\u00020(H\u0002J\u0006\u0010:\u001a\u00020.J\u0010\u0010Z\u001a\u00020(2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u009d\u0001\u0010Z\u001a\u00020(2\u0006\u0010[\u001a\u00020\u00172\u0006\u0010\\\u001a\u00020\u00172\u0016\b\u0002\u0010]\u001a\u0010\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030_\u0018\u00010^2\b\b\u0002\u0010`\u001a\u00020\b2\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020.2\b\b\u0002\u0010a\u001a\u00020b2\b\b\u0002\u00109\u001a\u00020.2\b\b\u0002\u0010;\u001a\u00020.2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00172\u000e\b\u0002\u0010c\u001a\b\u0012\u0004\u0012\u00020(0'2\u000e\b\u0002\u0010<\u001a\b\u0012\u0004\u0012\u00020(0'H\u0001¢\u0006\u0002\bdJ\b\u0010e\u001a\u00020(H\u0002J\b\u0010f\u001a\u00020(H\u0014J0\u0010g\u001a\u00020(2\u0006\u0010h\u001a\u00020.2\u0006\u0010i\u001a\u00020\b2\u0006\u0010j\u001a\u00020\b2\u0006\u0010k\u001a\u00020\b2\u0006\u0010l\u001a\u00020\bH\u0014J\b\u0010m\u001a\u00020(H\u0002J\u000e\u0010n\u001a\u0004\u0018\u00010o*\u00020pH\u0002J\u0016\u0010q\u001a\u0004\u0018\u00010\u0017*\u00020K2\u0006\u0010r\u001a\u00020sH\u0002J\f\u0010t\u001a\u00020.*\u00020KH\u0002J\f\u0010u\u001a\u00020.*\u00020KH\u0002J\u001e\u0010v\u001a\u0004\u0018\u00010\u0017*\u00020p2\u0006\u0010w\u001a\u00020\b2\u0006\u0010x\u001a\u00020\bH\u0002J\f\u0010y\u001a\u00020.*\u00020KH\u0002J\f\u0010z\u001a\u00020G*\u00020KH\u0002R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u00118\u0002X\u0083\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082D¢\u0006\u0002\n\u0000R$\u0010\u0018\u001a\u00020\u00198\u0000@\u0000X\u0081.¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R%\u0010%\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020(0'¢\u0006\u0002\b)0&X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b*\u0010\u001bR\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R \u00102\u001a\b\u0012\u0004\u0012\u00020\u001703X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u000e\u00108\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020(0'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010=\u001a\r\u0012\u0004\u0012\u00020(0'¢\u0006\u0002\b)X\u0082\u000e¢\u0006\u0004\n\u0002\u0010>R\u000e\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010A\u001a\u00020.X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER \u0010F\u001a\b\u0012\u0004\u0012\u00020G03X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u00105\"\u0004\bI\u00107R\u0018\u0010J\u001a\u00020\u0017*\u00020K8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bL\u0010MR\u0018\u0010N\u001a\u00020\b*\u00020K8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bO\u0010P¨\u0006{"}, d2 = {"Landroidx/compose/ui/tooling/ComposeViewAdapter;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "FakeActivityResultRegistryOwner", "androidx/compose/ui/tooling/ComposeViewAdapter$FakeActivityResultRegistryOwner$1", "Landroidx/compose/ui/tooling/ComposeViewAdapter$FakeActivityResultRegistryOwner$1;", "FakeOnBackPressedDispatcherOwner", "androidx/compose/ui/tooling/ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1", "Landroidx/compose/ui/tooling/ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1;", "FakeSavedStateRegistryOwner", "androidx/compose/ui/tooling/ComposeViewAdapter$FakeSavedStateRegistryOwner$1", "Landroidx/compose/ui/tooling/ComposeViewAdapter$FakeSavedStateRegistryOwner$1;", "FakeViewModelStoreOwner", "androidx/compose/ui/tooling/ComposeViewAdapter$FakeViewModelStoreOwner$1", "Landroidx/compose/ui/tooling/ComposeViewAdapter$FakeViewModelStoreOwner$1;", "TAG", "", "clock", "Landroidx/compose/ui/tooling/animation/PreviewAnimationClock;", "getClock$ui_tooling_release$annotations", "()V", "getClock$ui_tooling_release", "()Landroidx/compose/ui/tooling/animation/PreviewAnimationClock;", "setClock$ui_tooling_release", "(Landroidx/compose/ui/tooling/animation/PreviewAnimationClock;)V", "composableName", "composeView", "Landroidx/compose/ui/platform/ComposeView;", "composition", "Landroidx/compose/runtime/Composition;", "content", "Landroidx/compose/runtime/MutableState;", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "getContent$annotations", "debugBoundsPaint", "Landroid/graphics/Paint;", "debugPaintBounds", "", "debugViewInfos", "delayedException", "Landroidx/compose/ui/tooling/ThreadSafeException;", "designInfoList", "", "getDesignInfoList$ui_tooling_release", "()Ljava/util/List;", "setDesignInfoList$ui_tooling_release", "(Ljava/util/List;)V", "designInfoProvidersArgument", "forceCompositionInvalidation", "hasAnimations", "lookForDesignInfoProviders", "onDraw", "previewComposition", "Lkotlin/jvm/functions/Function2;", "slotTableRecord", "Landroidx/compose/ui/tooling/CompositionDataRecord;", "stitchTrees", "getStitchTrees$ui_tooling_release", "()Z", "setStitchTrees$ui_tooling_release", "(Z)V", "viewInfos", "Landroidx/compose/ui/tooling/ViewInfo;", "getViewInfos$ui_tooling_release", "setViewInfos$ui_tooling_release", "fileName", "Landroidx/compose/ui/tooling/data/Group;", "getFileName", "(Landroidx/compose/ui/tooling/data/Group;)Ljava/lang/String;", "lineNumber", "getLineNumber", "(Landroidx/compose/ui/tooling/data/Group;)I", "WrapPreview", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "dispose", "dispose$ui_tooling_release", "findAndTrackAnimations", "findDesignInfoProviders", "init", "className", "methodName", "parameterProvider", "Ljava/lang/Class;", "Landroidx/compose/ui/tooling/preview/PreviewParameterProvider;", "parameterProviderIndex", "animationClockStartTime", "", "onCommit", "init$ui_tooling_release", "invalidateComposition", "onAttachedToWindow", "onLayout", "changed", "left", "top", "right", "bottom", "processViewInfos", "getDesignInfoMethodOrNull", "Ljava/lang/reflect/Method;", "", "getDesignInfoOrNull", "box", "Landroidx/compose/ui/unit/IntRect;", "hasDesignInfo", "hasNullSourcePosition", "invokeGetDesignInfo", "x", "y", "isNullGroup", "toViewInfo", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ComposeViewAdapter extends FrameLayout {
    private final ComposeViewAdapter$FakeActivityResultRegistryOwner$1 FakeActivityResultRegistryOwner;
    private final ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1 FakeOnBackPressedDispatcherOwner;
    private final ComposeViewAdapter$FakeSavedStateRegistryOwner$1 FakeSavedStateRegistryOwner;
    private final ComposeViewAdapter$FakeViewModelStoreOwner$1 FakeViewModelStoreOwner;
    private final String TAG;
    public PreviewAnimationClock clock;
    private String composableName;
    private final ComposeView composeView;
    private Composition composition;
    private final MutableState<Function2<Composer, Integer, Unit>> content;
    private final Paint debugBoundsPaint;
    private boolean debugPaintBounds;
    private boolean debugViewInfos;
    private final ThreadSafeException delayedException;
    private List<String> designInfoList;
    private String designInfoProvidersArgument;
    private boolean forceCompositionInvalidation;
    private boolean hasAnimations;
    private boolean lookForDesignInfoProviders;
    private Function0<Unit> onDraw;
    private Function2<? super Composer, ? super Integer, Unit> previewComposition;
    private final CompositionDataRecord slotTableRecord;
    private boolean stitchTrees;
    private List<ViewInfo> viewInfos;

    public static /* synthetic */ void getClock$ui_tooling_release$annotations() {
    }

    private static /* synthetic */ void getContent$annotations() {
    }

    public final List<ViewInfo> getViewInfos$ui_tooling_release() {
        return this.viewInfos;
    }

    public final void setViewInfos$ui_tooling_release(List<ViewInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.viewInfos = list;
    }

    public final List<String> getDesignInfoList$ui_tooling_release() {
        return this.designInfoList;
    }

    public final void setDesignInfoList$ui_tooling_release(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.designInfoList = list;
    }

    /* renamed from: getStitchTrees$ui_tooling_release, reason: from getter */
    public final boolean getStitchTrees() {
        return this.stitchTrees;
    }

    public final void setStitchTrees$ui_tooling_release(boolean z) {
        this.stitchTrees = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v12, types: [androidx.compose.ui.tooling.ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1] */
    /* JADX WARN: Type inference failed for: r0v13, types: [androidx.compose.ui.tooling.ComposeViewAdapter$FakeActivityResultRegistryOwner$1] */
    public ComposeViewAdapter(Context context, AttributeSet attrs) {
        super(context, attrs);
        Function2 function2;
        MutableState<Function2<Composer, Integer, Unit>> mutableStateOf$default;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.TAG = "ComposeViewAdapter";
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.composeView = new ComposeView(context2, null, 0, 6, null);
        this.viewInfos = CollectionsKt.emptyList();
        this.designInfoList = CollectionsKt.emptyList();
        this.slotTableRecord = CompositionDataRecord.INSTANCE.create();
        this.composableName = "";
        this.delayedException = new ThreadSafeException();
        this.previewComposition = ComposableSingletons$ComposeViewAdapterKt.INSTANCE.m5141getLambda2$ui_tooling_release();
        function2 = ComposeViewAdapterKt.emptyContent;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(function2, null, 2, null);
        this.content = mutableStateOf$default;
        this.designInfoProvidersArgument = "";
        this.onDraw = ComposeViewAdapter$onDraw$1.INSTANCE;
        this.stitchTrees = true;
        Paint $this$debugBoundsPaint_u24lambda_u240 = new Paint();
        $this$debugBoundsPaint_u24lambda_u240.setPathEffect(new DashPathEffect(new float[]{5.0f, 10.0f, 15.0f, 20.0f}, 0.0f));
        $this$debugBoundsPaint_u24lambda_u240.setStyle(Paint.Style.STROKE);
        $this$debugBoundsPaint_u24lambda_u240.setColor(ColorKt.m3003toArgb8_81llA(Color.INSTANCE.m2983getRed0d7_KjU()));
        this.debugBoundsPaint = $this$debugBoundsPaint_u24lambda_u240;
        this.FakeSavedStateRegistryOwner = new ComposeViewAdapter$FakeSavedStateRegistryOwner$1();
        this.FakeViewModelStoreOwner = new ComposeViewAdapter$FakeViewModelStoreOwner$1();
        this.FakeOnBackPressedDispatcherOwner = new OnBackPressedDispatcherOwner() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1
            private final OnBackPressedDispatcher onBackPressedDispatcher = new OnBackPressedDispatcher(null, 1, null);

            @Override // androidx.activity.OnBackPressedDispatcherOwner
            public OnBackPressedDispatcher getOnBackPressedDispatcher() {
                return this.onBackPressedDispatcher;
            }

            @Override // androidx.lifecycle.LifecycleOwner
            /* renamed from: getLifecycle */
            public LifecycleRegistry getLifecycleRegistry() {
                ComposeViewAdapter$FakeSavedStateRegistryOwner$1 composeViewAdapter$FakeSavedStateRegistryOwner$1;
                composeViewAdapter$FakeSavedStateRegistryOwner$1 = ComposeViewAdapter.this.FakeSavedStateRegistryOwner;
                return composeViewAdapter$FakeSavedStateRegistryOwner$1.getLifecycleRegistry();
            }
        };
        this.FakeActivityResultRegistryOwner = new ActivityResultRegistryOwner() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$FakeActivityResultRegistryOwner$1
            private final ComposeViewAdapter$FakeActivityResultRegistryOwner$1$activityResultRegistry$1 activityResultRegistry = new ActivityResultRegistry() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$FakeActivityResultRegistryOwner$1$activityResultRegistry$1
                @Override // androidx.activity.result.ActivityResultRegistry
                public <I, O> void onLaunch(int requestCode, ActivityResultContract<I, O> contract, I input, ActivityOptionsCompat options) {
                    Intrinsics.checkNotNullParameter(contract, "contract");
                    throw new IllegalStateException("Calling launch() is not supported in Preview");
                }
            };

            @Override // androidx.activity.result.ActivityResultRegistryOwner
            public ComposeViewAdapter$FakeActivityResultRegistryOwner$1$activityResultRegistry$1 getActivityResultRegistry() {
                return this.activityResultRegistry;
            }
        };
        init(attrs);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v12, types: [androidx.compose.ui.tooling.ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1] */
    /* JADX WARN: Type inference failed for: r0v13, types: [androidx.compose.ui.tooling.ComposeViewAdapter$FakeActivityResultRegistryOwner$1] */
    public ComposeViewAdapter(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Function2 function2;
        MutableState<Function2<Composer, Integer, Unit>> mutableStateOf$default;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.TAG = "ComposeViewAdapter";
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.composeView = new ComposeView(context2, null, 0, 6, null);
        this.viewInfos = CollectionsKt.emptyList();
        this.designInfoList = CollectionsKt.emptyList();
        this.slotTableRecord = CompositionDataRecord.INSTANCE.create();
        this.composableName = "";
        this.delayedException = new ThreadSafeException();
        this.previewComposition = ComposableSingletons$ComposeViewAdapterKt.INSTANCE.m5141getLambda2$ui_tooling_release();
        function2 = ComposeViewAdapterKt.emptyContent;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(function2, null, 2, null);
        this.content = mutableStateOf$default;
        this.designInfoProvidersArgument = "";
        this.onDraw = ComposeViewAdapter$onDraw$1.INSTANCE;
        this.stitchTrees = true;
        Paint $this$debugBoundsPaint_u24lambda_u240 = new Paint();
        $this$debugBoundsPaint_u24lambda_u240.setPathEffect(new DashPathEffect(new float[]{5.0f, 10.0f, 15.0f, 20.0f}, 0.0f));
        $this$debugBoundsPaint_u24lambda_u240.setStyle(Paint.Style.STROKE);
        $this$debugBoundsPaint_u24lambda_u240.setColor(ColorKt.m3003toArgb8_81llA(Color.INSTANCE.m2983getRed0d7_KjU()));
        this.debugBoundsPaint = $this$debugBoundsPaint_u24lambda_u240;
        this.FakeSavedStateRegistryOwner = new ComposeViewAdapter$FakeSavedStateRegistryOwner$1();
        this.FakeViewModelStoreOwner = new ComposeViewAdapter$FakeViewModelStoreOwner$1();
        this.FakeOnBackPressedDispatcherOwner = new OnBackPressedDispatcherOwner() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1
            private final OnBackPressedDispatcher onBackPressedDispatcher = new OnBackPressedDispatcher(null, 1, null);

            @Override // androidx.activity.OnBackPressedDispatcherOwner
            public OnBackPressedDispatcher getOnBackPressedDispatcher() {
                return this.onBackPressedDispatcher;
            }

            @Override // androidx.lifecycle.LifecycleOwner
            /* renamed from: getLifecycle */
            public LifecycleRegistry getLifecycleRegistry() {
                ComposeViewAdapter$FakeSavedStateRegistryOwner$1 composeViewAdapter$FakeSavedStateRegistryOwner$1;
                composeViewAdapter$FakeSavedStateRegistryOwner$1 = ComposeViewAdapter.this.FakeSavedStateRegistryOwner;
                return composeViewAdapter$FakeSavedStateRegistryOwner$1.getLifecycleRegistry();
            }
        };
        this.FakeActivityResultRegistryOwner = new ActivityResultRegistryOwner() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$FakeActivityResultRegistryOwner$1
            private final ComposeViewAdapter$FakeActivityResultRegistryOwner$1$activityResultRegistry$1 activityResultRegistry = new ActivityResultRegistry() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$FakeActivityResultRegistryOwner$1$activityResultRegistry$1
                @Override // androidx.activity.result.ActivityResultRegistry
                public <I, O> void onLaunch(int requestCode, ActivityResultContract<I, O> contract, I input, ActivityOptionsCompat options) {
                    Intrinsics.checkNotNullParameter(contract, "contract");
                    throw new IllegalStateException("Calling launch() is not supported in Preview");
                }
            };

            @Override // androidx.activity.result.ActivityResultRegistryOwner
            public ComposeViewAdapter$FakeActivityResultRegistryOwner$1$activityResultRegistry$1 getActivityResultRegistry() {
                return this.activityResultRegistry;
            }
        };
        init(attrs);
    }

    private final String getFileName(Group $this$fileName) {
        String sourceFile;
        SourceLocation location = $this$fileName.getLocation();
        return (location == null || (sourceFile = location.getSourceFile()) == null) ? "" : sourceFile;
    }

    private final int getLineNumber(Group $this$lineNumber) {
        SourceLocation location = $this$lineNumber.getLocation();
        if (location != null) {
            return location.getLineNumber();
        }
        return -1;
    }

    private final boolean hasNullSourcePosition(Group $this$hasNullSourcePosition) {
        return (getFileName($this$hasNullSourcePosition).length() == 0) && getLineNumber($this$hasNullSourcePosition) == -1;
    }

    private final boolean isNullGroup(Group group) {
        if (hasNullSourcePosition(group) && group.getChildren().isEmpty()) {
            NodeGroup nodeGroup = group instanceof NodeGroup ? (NodeGroup) group : null;
            Object node = nodeGroup != null ? nodeGroup.getNode() : null;
            if ((node instanceof LayoutInfo ? (LayoutInfo) node : null) == null) {
                return true;
            }
        }
        return false;
    }

    private final ViewInfo toViewInfo(Group group) {
        String str;
        NodeGroup nodeGroup = group instanceof NodeGroup ? (NodeGroup) group : null;
        Object node = nodeGroup != null ? nodeGroup.getNode() : null;
        LayoutInfo layoutInfo = node instanceof LayoutInfo ? (LayoutInfo) node : null;
        if (group.getChildren().size() == 1 && hasNullSourcePosition(group) && layoutInfo == null) {
            return toViewInfo((Group) CollectionsKt.single(group.getChildren()));
        }
        Collection<Group> children = group.getChildren();
        ArrayList arrayList = new ArrayList();
        for (Object obj : children) {
            if (!isNullGroup((Group) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(toViewInfo((Group) it.next()));
        }
        ArrayList arrayList4 = arrayList3;
        SourceLocation location = group.getLocation();
        if (location == null || (str = location.getSourceFile()) == null) {
            str = "";
        }
        String str2 = str;
        SourceLocation location2 = group.getLocation();
        return new ViewInfo(str2, location2 != null ? location2.getLineNumber() : -1, group.getBox(), group.getLocation(), arrayList4, layoutInfo);
    }

    private final void processViewInfos() {
        List list;
        Iterable $this$map$iv = this.slotTableRecord.getStore();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            CompositionData it = (CompositionData) item$iv$iv;
            destination$iv$iv.add(toViewInfo(SlotTreeKt.asTree(it)));
        }
        List newViewInfos = CollectionsKt.toList((List) destination$iv$iv);
        if (this.stitchTrees) {
            list = ShadowViewInfoKt.stitchTrees(newViewInfos);
        } else {
            list = newViewInfos;
        }
        this.viewInfos = list;
        if (this.debugViewInfos) {
            String debugString = ViewInfoUtilKt.toDebugString$default(this.viewInfos, 0, null, 3, null);
            Log.d(this.TAG, debugString);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        this.delayedException.throwIfPresent();
        processViewInfos();
        if (this.composableName.length() > 0) {
            findAndTrackAnimations();
            if (this.lookForDesignInfoProviders) {
                findDesignInfoProviders();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        View rootView = this.composeView.getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "composeView.rootView");
        ViewTreeLifecycleOwner.set(rootView, this.FakeSavedStateRegistryOwner);
        super.onAttachedToWindow();
    }

    private final void findAndTrackAnimations() {
        Iterable $this$map$iv = this.slotTableRecord.getStore();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            destination$iv$iv.add(SlotTreeKt.asTree((CompositionData) item$iv$iv));
        }
        List slotTrees = (List) destination$iv$iv;
        AnimationSearch it = new AnimationSearch(new MutablePropertyReference0Impl(this) { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$findAndTrackAnimations$1
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((ComposeViewAdapter) this.receiver).getClock$ui_tooling_release();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object value) {
                ((ComposeViewAdapter) this.receiver).setClock$ui_tooling_release((PreviewAnimationClock) value);
            }
        }, new ComposeViewAdapter$findAndTrackAnimations$2(this));
        it.findAll(slotTrees);
        this.hasAnimations = it.getHasAnimations();
        if (this.clock != null) {
            it.trackAll();
        }
    }

    private final void findDesignInfoProviders() {
        int $i$f$flatMap;
        Iterable $this$map$iv = this.slotTableRecord.getStore();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            CompositionData it = (CompositionData) item$iv$iv;
            destination$iv$iv.add(SlotTreeKt.asTree(it));
        }
        Object it$iv$iv = (List) destination$iv$iv;
        Iterable $this$flatMap$iv = (Iterable) it$iv$iv;
        int $i$f$flatMap2 = 0;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv : $this$flatMap$iv) {
            Group rootGroup = (Group) element$iv$iv;
            Iterable $this$mapNotNull$iv = PreviewUtilsKt.findAll(rootGroup, new Function1<Group, Boolean>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$findDesignInfoProviders$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                /* JADX WARN: Code restructure failed: missing block: B:4:0x001a, code lost:
                
                    if (r0 == false) goto L6;
                 */
                /* JADX WARN: Removed duplicated region for block: B:25:0x005c A[SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:27:? A[LOOP:0: B:16:0x0039->B:27:?, LOOP_END, SYNTHETIC] */
                @Override // kotlin.jvm.functions.Function1
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Boolean invoke(androidx.compose.ui.tooling.data.Group r12) {
                    /*
                        r11 = this;
                        java.lang.String r0 = "group"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
                        java.lang.String r0 = r12.getName()
                        java.lang.String r1 = "remember"
                        boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                        r2 = 1
                        if (r0 != 0) goto L1c
                        androidx.compose.ui.tooling.ComposeViewAdapter r0 = androidx.compose.ui.tooling.ComposeViewAdapter.this
                        boolean r0 = androidx.compose.ui.tooling.ComposeViewAdapter.access$hasDesignInfo(r0, r12)
                        if (r0 != 0) goto L61
                    L1c:
                        java.util.Collection r0 = r12.getChildren()
                        java.lang.Iterable r0 = (java.lang.Iterable) r0
                        androidx.compose.ui.tooling.ComposeViewAdapter r3 = androidx.compose.ui.tooling.ComposeViewAdapter.this
                        r4 = 0
                        boolean r5 = r0 instanceof java.util.Collection
                        r6 = 0
                        if (r5 == 0) goto L35
                        r5 = r0
                        java.util.Collection r5 = (java.util.Collection) r5
                        boolean r5 = r5.isEmpty()
                        if (r5 == 0) goto L35
                        r0 = r6
                        goto L5f
                    L35:
                        java.util.Iterator r5 = r0.iterator()
                    L39:
                        boolean r7 = r5.hasNext()
                        if (r7 == 0) goto L5e
                        java.lang.Object r7 = r5.next()
                        r8 = r7
                        androidx.compose.ui.tooling.data.Group r8 = (androidx.compose.ui.tooling.data.Group) r8
                        r9 = 0
                        java.lang.String r10 = r8.getName()
                        boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual(r10, r1)
                        if (r10 == 0) goto L59
                        boolean r10 = androidx.compose.ui.tooling.ComposeViewAdapter.access$hasDesignInfo(r3, r8)
                        if (r10 == 0) goto L59
                        r8 = r2
                        goto L5a
                    L59:
                        r8 = r6
                    L5a:
                        if (r8 == 0) goto L39
                        r0 = r2
                        goto L5f
                    L5e:
                        r0 = r6
                    L5f:
                        if (r0 == 0) goto L62
                    L61:
                        goto L63
                    L62:
                        r2 = r6
                    L63:
                        java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.ComposeViewAdapter$findDesignInfoProviders$1$1.invoke(androidx.compose.ui.tooling.data.Group):java.lang.Boolean");
                }
            });
            Collection destination$iv$iv3 = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                Object slotTrees = it$iv$iv;
                Group group = (Group) element$iv$iv$iv;
                Iterable $this$flatMap$iv2 = $this$flatMap$iv;
                String designInfoOrNull = getDesignInfoOrNull(group, group.getBox());
                if (designInfoOrNull == null) {
                    Iterator it2 = group.getChildren().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            $i$f$flatMap = $i$f$flatMap2;
                            designInfoOrNull = null;
                            break;
                        }
                        Iterator it3 = it2;
                        Group it4 = (Group) it2.next();
                        $i$f$flatMap = $i$f$flatMap2;
                        designInfoOrNull = getDesignInfoOrNull(it4, group.getBox());
                        if (designInfoOrNull != null) {
                            break;
                        }
                        it2 = it3;
                        $i$f$flatMap2 = $i$f$flatMap;
                    }
                } else {
                    $i$f$flatMap = $i$f$flatMap2;
                }
                if (designInfoOrNull != null) {
                    destination$iv$iv3.add(designInfoOrNull);
                }
                it$iv$iv = slotTrees;
                $this$flatMap$iv = $this$flatMap$iv2;
                $i$f$flatMap2 = $i$f$flatMap;
            }
            Object slotTrees2 = it$iv$iv;
            Iterable list$iv$iv = (List) destination$iv$iv3;
            CollectionsKt.addAll(destination$iv$iv2, list$iv$iv);
            it$iv$iv = slotTrees2;
        }
        this.designInfoList = (List) destination$iv$iv2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean hasDesignInfo(Group $this$hasDesignInfo) {
        Iterable $this$any$iv = $this$hasDesignInfo.getData();
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        Iterator it = $this$any$iv.iterator();
        while (it.hasNext()) {
            Object element$iv = it.next();
            Object it2 = (element$iv != null ? getDesignInfoMethodOrNull(element$iv) : null) != null ? 1 : null;
            if (it2 != null) {
                return true;
            }
        }
        return false;
    }

    private final String getDesignInfoOrNull(Group $this$getDesignInfoOrNull, IntRect box) {
        String str;
        Iterator<T> it = $this$getDesignInfoOrNull.getData().iterator();
        do {
            str = null;
            if (!it.hasNext()) {
                break;
            }
            Object it2 = it.next();
            if (it2 != null) {
                str = invokeGetDesignInfo(it2, box.getLeft(), box.getRight());
            }
        } while (str == null);
        return str;
    }

    private final Method getDesignInfoMethodOrNull(Object $this$getDesignInfoMethodOrNull) {
        try {
            return $this$getDesignInfoMethodOrNull.getClass().getDeclaredMethod("getDesignInfo", Integer.TYPE, Integer.TYPE, String.class);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    private final String invokeGetDesignInfo(Object $this$invokeGetDesignInfo, int x, int y) {
        Method designInfoMethod = getDesignInfoMethodOrNull($this$invokeGetDesignInfo);
        if (designInfoMethod == null) {
            return null;
        }
        try {
            Object result = designInfoMethod.invoke($this$invokeGetDesignInfo, Integer.valueOf(x), Integer.valueOf(y), this.designInfoProvidersArgument);
            Intrinsics.checkNotNull(result, "null cannot be cast to non-null type kotlin.String");
            String str = (String) result;
            if (str.length() == 0) {
                str = null;
            }
            return str;
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void invalidateComposition() {
        this.content.setValue(ComposableSingletons$ComposeViewAdapterKt.INSTANCE.m5142getLambda3$ui_tooling_release());
        this.content.setValue(this.previewComposition);
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.dispatchDraw(canvas);
        if (this.forceCompositionInvalidation) {
            invalidateComposition();
        }
        this.onDraw.invoke();
        if (!this.debugPaintBounds) {
            return;
        }
        Iterable $this$flatMap$iv = this.viewInfos;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$flatMap$iv) {
            ViewInfo it = (ViewInfo) element$iv$iv;
            Iterable list$iv$iv = CollectionsKt.plus((Collection) CollectionsKt.listOf(it), (Iterable) it.allChildren());
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        Iterable $this$forEach$iv = (List) destination$iv$iv;
        for (Object element$iv : $this$forEach$iv) {
            ViewInfo it2 = (ViewInfo) element$iv;
            if (it2.hasBounds()) {
                Rect pxBounds = new Rect(it2.getBounds().getLeft(), it2.getBounds().getTop(), it2.getBounds().getRight(), it2.getBounds().getBottom());
                canvas.drawRect(pxBounds, this.debugBoundsPaint);
            }
        }
    }

    public final PreviewAnimationClock getClock$ui_tooling_release() {
        PreviewAnimationClock previewAnimationClock = this.clock;
        if (previewAnimationClock != null) {
            return previewAnimationClock;
        }
        Intrinsics.throwUninitializedPropertyAccessException("clock");
        return null;
    }

    public final void setClock$ui_tooling_release(PreviewAnimationClock previewAnimationClock) {
        Intrinsics.checkNotNullParameter(previewAnimationClock, "<set-?>");
        this.clock = previewAnimationClock;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void WrapPreview(final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(493526445);
        ComposerKt.sourceInformation($composer2, "C(WrapPreview)442@16065L428:ComposeViewAdapter.kt#hevd2p");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(493526445, $changed, -1, "androidx.compose.ui.tooling.ComposeViewAdapter.WrapPreview (ComposeViewAdapter.kt:437)");
        }
        ProvidableCompositionLocal<Font.ResourceLoader> localFontLoader = CompositionLocalsKt.getLocalFontLoader();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ProvidableCompositionLocal<FontFamily.Resolver> localFontFamilyResolver = CompositionLocalsKt.getLocalFontFamilyResolver();
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{localFontLoader.provides(new LayoutlibFontResourceLoader(context)), localFontFamilyResolver.provides(FontFamilyResolver_androidKt.createFontFamilyResolver(context2)), LocalOnBackPressedDispatcherOwner.INSTANCE.provides(this.FakeOnBackPressedDispatcherOwner), LocalActivityResultRegistryOwner.INSTANCE.provides(this.FakeActivityResultRegistryOwner)}, ComposableLambdaKt.composableLambda($composer2, -1966112531, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$WrapPreview$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer $composer3, int $changed2) {
                CompositionDataRecord compositionDataRecord;
                ComposerKt.sourceInformation($composer3, "C448@16446L37:ComposeViewAdapter.kt#hevd2p");
                if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1966112531, $changed2, -1, "androidx.compose.ui.tooling.ComposeViewAdapter.WrapPreview.<anonymous> (ComposeViewAdapter.kt:447)");
                    }
                    compositionDataRecord = ComposeViewAdapter.this.slotTableRecord;
                    InspectableKt.Inspectable(compositionDataRecord, function2, $composer3, ($changed << 3) & 112);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer3.skipToGroupEnd();
            }
        }), $composer2, 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$WrapPreview$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                ComposeViewAdapter.this.WrapPreview(function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    public static /* synthetic */ void init$ui_tooling_release$default(ComposeViewAdapter composeViewAdapter, String str, String str2, Class cls, int i, boolean z, boolean z2, long j, boolean z3, boolean z4, String str3, Function0 function0, Function0 function02, int i2, Object obj) {
        composeViewAdapter.init$ui_tooling_release(str, str2, (i2 & 4) != 0 ? null : cls, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? false : z, (i2 & 32) != 0 ? false : z2, (i2 & 64) != 0 ? -1L : j, (i2 & 128) != 0 ? false : z3, (i2 & 256) != 0 ? false : z4, (i2 & 512) != 0 ? null : str3, (i2 & 1024) != 0 ? new Function0<Unit>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$init$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        } : function0, (i2 & 2048) != 0 ? new Function0<Unit>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$init$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        } : function02);
    }

    public final void init$ui_tooling_release(final String className, final String methodName, final Class<? extends PreviewParameterProvider<?>> parameterProvider, final int parameterProviderIndex, boolean debugPaintBounds, boolean debugViewInfos, final long animationClockStartTime, boolean forceCompositionInvalidation, boolean lookForDesignInfoProviders, String designInfoProvidersArgument, final Function0<Unit> onCommit, Function0<Unit> onDraw) {
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(onCommit, "onCommit");
        Intrinsics.checkNotNullParameter(onDraw, "onDraw");
        this.debugPaintBounds = debugPaintBounds;
        this.debugViewInfos = debugViewInfos;
        this.composableName = methodName;
        this.forceCompositionInvalidation = forceCompositionInvalidation;
        this.lookForDesignInfoProviders = lookForDesignInfoProviders;
        this.designInfoProvidersArgument = designInfoProvidersArgument == null ? "" : designInfoProvidersArgument;
        this.onDraw = onDraw;
        this.previewComposition = ComposableLambdaKt.composableLambdaInstance(-1704541905, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$init$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer $composer, int $changed) {
                ComposerKt.sourceInformation($composer, "C499@19077L20,501@19111L2532:ComposeViewAdapter.kt#hevd2p");
                if (($changed & 11) != 2 || !$composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1704541905, $changed, -1, "androidx.compose.ui.tooling.ComposeViewAdapter.init.<anonymous> (ComposeViewAdapter.kt:498)");
                    }
                    EffectsKt.SideEffect(onCommit, $composer, 0);
                    ComposeViewAdapter composeViewAdapter = this;
                    final long j = animationClockStartTime;
                    final ComposeViewAdapter composeViewAdapter2 = this;
                    final String str = className;
                    final String str2 = methodName;
                    final Class<? extends PreviewParameterProvider<?>> cls = parameterProvider;
                    final int i = parameterProviderIndex;
                    composeViewAdapter.WrapPreview(ComposableLambdaKt.composableLambda($composer, 1938351266, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$init$3.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(final Composer $composer2, int $changed2) {
                            ComposerKt.sourceInformation($composer2, "C:ComposeViewAdapter.kt#hevd2p");
                            if (($changed2 & 11) != 2 || !$composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1938351266, $changed2, -1, "androidx.compose.ui.tooling.ComposeViewAdapter.init.<anonymous>.<anonymous> (ComposeViewAdapter.kt:501)");
                                }
                                final String str3 = str;
                                final String str4 = str2;
                                final Class<? extends PreviewParameterProvider<?>> cls2 = cls;
                                final int i2 = i;
                                final ComposeViewAdapter composeViewAdapter3 = composeViewAdapter2;
                                Function0 composable = new Function0<Unit>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$init$3$1$composable$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        ThreadSafeException threadSafeException;
                                        Throwable cause;
                                        try {
                                            ComposableInvoker composableInvoker = ComposableInvoker.INSTANCE;
                                            String str5 = str3;
                                            String str6 = str4;
                                            Composer composer = $composer2;
                                            Object[] previewProviderParameters = PreviewUtilsKt.getPreviewProviderParameters(cls2, i2);
                                            composableInvoker.invokeComposable(str5, str6, composer, Arrays.copyOf(previewProviderParameters, previewProviderParameters.length));
                                        } catch (Throwable t) {
                                            Throwable exception = t;
                                            while ((exception instanceof ReflectiveOperationException) && (cause = exception.getCause()) != null) {
                                                exception = cause;
                                            }
                                            threadSafeException = composeViewAdapter3.delayedException;
                                            threadSafeException.set(exception);
                                            throw t;
                                        }
                                    }
                                };
                                if (j >= 0) {
                                    ComposeViewAdapter composeViewAdapter4 = composeViewAdapter2;
                                    final ComposeViewAdapter composeViewAdapter5 = composeViewAdapter2;
                                    composeViewAdapter4.setClock$ui_tooling_release(new PreviewAnimationClock(new Function0<Unit>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter.init.3.1.1
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public /* bridge */ /* synthetic */ Unit invoke() {
                                            invoke2();
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2() {
                                            View childAt = ComposeViewAdapter.this.getChildAt(0);
                                            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type androidx.compose.ui.platform.ComposeView");
                                            ComposeView composeView = (ComposeView) childAt;
                                            KeyEvent.Callback childAt2 = composeView.getChildAt(0);
                                            ViewRootForTest viewRootForTest = childAt2 instanceof ViewRootForTest ? (ViewRootForTest) childAt2 : null;
                                            if (viewRootForTest != null) {
                                                viewRootForTest.invalidateDescendants();
                                            }
                                            Snapshot.INSTANCE.sendApplyNotifications();
                                        }
                                    }));
                                }
                                composable.invoke();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer2.skipToGroupEnd();
                        }
                    }), $composer, 70);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer.skipToGroupEnd();
            }
        });
        this.composeView.setContent(this.previewComposition);
        invalidate();
    }

    public final void dispose$ui_tooling_release() {
        this.composeView.disposeComposition();
        if (this.clock != null) {
            getClock$ui_tooling_release().dispose();
        }
        this.FakeSavedStateRegistryOwner.getLifecycleRegistry().setCurrentState(Lifecycle.State.DESTROYED);
        this.FakeViewModelStoreOwner.getViewModelStore().clear();
    }

    /* renamed from: hasAnimations, reason: from getter */
    public final boolean getHasAnimations() {
        return this.hasAnimations;
    }

    private final void init(AttributeSet attrs) {
        long animationClockStartTime;
        ViewTreeLifecycleOwner.set(this, this.FakeSavedStateRegistryOwner);
        ViewTreeSavedStateRegistryOwner.set(this, this.FakeSavedStateRegistryOwner);
        ViewTreeViewModelStoreOwner.set(this, this.FakeViewModelStoreOwner);
        addView(this.composeView);
        String composableName = attrs.getAttributeValue("http://schemas.android.com/tools", "composableName");
        if (composableName == null) {
            return;
        }
        String className = StringsKt.substringBeforeLast$default(composableName, '.', (String) null, 2, (Object) null);
        String methodName = StringsKt.substringAfterLast$default(composableName, '.', (String) null, 2, (Object) null);
        int parameterProviderIndex = attrs.getAttributeIntValue("http://schemas.android.com/tools", "parameterProviderIndex", 0);
        String attributeValue = attrs.getAttributeValue("http://schemas.android.com/tools", "parameterProviderClass");
        Class parameterProviderClass = attributeValue != null ? PreviewUtilsKt.asPreviewProviderClass(attributeValue) : null;
        try {
            String attributeValue2 = attrs.getAttributeValue("http://schemas.android.com/tools", "animationClockStartTime");
            Intrinsics.checkNotNullExpressionValue(attributeValue2, "attrs.getAttributeValue(…animationClockStartTime\")");
            animationClockStartTime = Long.parseLong(attributeValue2);
        } catch (Exception e) {
            animationClockStartTime = -1;
        }
        boolean forceCompositionInvalidation = attrs.getAttributeBooleanValue("http://schemas.android.com/tools", "forceCompositionInvalidation", false);
        init$ui_tooling_release$default(this, className, methodName, parameterProviderClass, parameterProviderIndex, attrs.getAttributeBooleanValue("http://schemas.android.com/tools", "paintBounds", this.debugPaintBounds), attrs.getAttributeBooleanValue("http://schemas.android.com/tools", "printViewInfos", this.debugViewInfos), animationClockStartTime, forceCompositionInvalidation, attrs.getAttributeBooleanValue("http://schemas.android.com/tools", "findDesignInfoProviders", this.lookForDesignInfoProviders), attrs.getAttributeValue("http://schemas.android.com/tools", "designInfoProvidersArgument"), null, null, 3072, null);
    }
}
