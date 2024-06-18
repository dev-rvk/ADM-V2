package androidx.compose.material3;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ViewRootForInspector;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: ModalBottomSheet.android.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\r\u0010!\u001a\u00020\u0006H\u0017¢\u0006\u0002\u0010\"J\u0006\u0010#\u001a\u00020\u0006J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020\u0006H\u0016J*\u0010(\u001a\u00020\u00062\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\r¢\u0006\u0002\u0010+J\u0006\u0010,\u001a\u00020\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000RA\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\r2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\r8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\u001b@RX\u0094\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Landroidx/compose/material3/ModalBottomSheetWindow;", "Landroidx/compose/ui/platform/AbstractComposeView;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "Landroidx/compose/ui/platform/ViewRootForInspector;", "onDismissRequest", "Lkotlin/Function0;", "", "composeView", "Landroid/view/View;", "saveId", "Ljava/util/UUID;", "(Lkotlin/jvm/functions/Function0;Landroid/view/View;Ljava/util/UUID;)V", "<set-?>", "Landroidx/compose/runtime/Composable;", "content", "getContent", "()Lkotlin/jvm/functions/Function2;", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "content$delegate", "Landroidx/compose/runtime/MutableState;", "displayWidth", "", "getDisplayWidth", "()I", "params", "Landroid/view/WindowManager$LayoutParams;", "", "shouldCreateCompositionOnAttachedToWindow", "getShouldCreateCompositionOnAttachedToWindow", "()Z", "windowManager", "Landroid/view/WindowManager;", "Content", "(Landroidx/compose/runtime/Composer;I)V", "dismiss", "dispatchKeyEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "onGlobalLayout", "setCustomContent", "parent", "Landroidx/compose/runtime/CompositionContext;", "(Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)V", "show", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class ModalBottomSheetWindow extends AbstractComposeView implements ViewTreeObserver.OnGlobalLayoutListener, ViewRootForInspector {
    private final View composeView;

    /* renamed from: content$delegate, reason: from kotlin metadata */
    private final MutableState content;
    private Function0<Unit> onDismissRequest;
    private final WindowManager.LayoutParams params;
    private boolean shouldCreateCompositionOnAttachedToWindow;
    private final WindowManager windowManager;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ModalBottomSheetWindow(kotlin.jvm.functions.Function0<kotlin.Unit> r8, android.view.View r9, java.util.UUID r10) {
        /*
            r7 = this;
            java.lang.String r0 = "onDismissRequest"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "composeView"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "saveId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            android.content.Context r2 = r9.getContext()
            java.lang.String r0 = "composeView.context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            r5 = 6
            r6 = 0
            r3 = 0
            r4 = 0
            r1 = r7
            r1.<init>(r2, r3, r4, r5, r6)
            r7.onDismissRequest = r8
            r7.composeView = r9
            r0 = 16908290(0x1020002, float:2.3877235E-38)
            r7.setId(r0)
            r0 = r7
            android.view.View r0 = (android.view.View) r0
            android.view.View r1 = r7.composeView
            androidx.lifecycle.LifecycleOwner r1 = androidx.lifecycle.ViewTreeLifecycleOwner.get(r1)
            androidx.lifecycle.ViewTreeLifecycleOwner.set(r0, r1)
            r0 = r7
            android.view.View r0 = (android.view.View) r0
            android.view.View r1 = r7.composeView
            androidx.lifecycle.ViewModelStoreOwner r1 = androidx.lifecycle.ViewTreeViewModelStoreOwner.get(r1)
            androidx.lifecycle.ViewTreeViewModelStoreOwner.set(r0, r1)
            r0 = r7
            android.view.View r0 = (android.view.View) r0
            android.view.View r1 = r7.composeView
            androidx.savedstate.SavedStateRegistryOwner r1 = androidx.savedstate.ViewTreeSavedStateRegistryOwner.get(r1)
            androidx.savedstate.ViewTreeSavedStateRegistryOwner.set(r0, r1)
            int r0 = androidx.compose.ui.R.id.compose_view_saveable_id_tag
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Popup:"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r10)
            java.lang.String r1 = r1.toString()
            r7.setTag(r0, r1)
            r0 = 0
            r7.setClipChildren(r0)
            android.view.View r0 = r7.composeView
            android.content.Context r0 = r0.getContext()
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)
            java.lang.String r1 = "null cannot be cast to non-null type android.view.WindowManager"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            r7.windowManager = r0
            android.view.WindowManager$LayoutParams r0 = new android.view.WindowManager$LayoutParams
            r0.<init>()
            r1 = r0
            r2 = 0
            r3 = 8388691(0x800053, float:1.175506E-38)
            r1.gravity = r3
            r3 = 1000(0x3e8, float:1.401E-42)
            r1.type = r3
            int r3 = r7.getDisplayWidth()
            r1.width = r3
            r3 = -1
            r1.height = r3
            r3 = -3
            r1.format = r3
            android.view.View r3 = r7.composeView
            android.content.Context r3 = r3.getContext()
            android.content.res.Resources r3 = r3.getResources()
            int r4 = androidx.compose.ui.R.string.default_popup_window_title
            java.lang.String r3 = r3.getString(r4)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setTitle(r3)
            android.view.View r3 = r7.composeView
            android.os.IBinder r3 = r3.getApplicationWindowToken()
            r1.token = r3
            int r3 = r1.flags
            r4 = -163841(0xfffffffffffd7fff, float:NaN)
            r3 = r3 & r4
            r1.flags = r3
            int r3 = r1.flags
            r3 = r3 | 512(0x200, float:7.17E-43)
            r1.flags = r3
            r7.params = r0
            androidx.compose.material3.ComposableSingletons$ModalBottomSheet_androidKt r0 = androidx.compose.material3.ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE
            kotlin.jvm.functions.Function2 r0 = r0.m1439getLambda3$material3_release()
            r1 = 0
            r2 = 2
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt.mutableStateOf$default(r0, r1, r2, r1)
            r7.content = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ModalBottomSheetWindow.<init>(kotlin.jvm.functions.Function0, android.view.View, java.util.UUID):void");
    }

    private final int getDisplayWidth() {
        float density = getContext().getResources().getDisplayMetrics().density;
        return MathKt.roundToInt(getContext().getResources().getConfiguration().screenWidthDp * density);
    }

    private final Function2<Composer, Integer, Unit> getContent() {
        State $this$getValue$iv = this.content;
        return (Function2) $this$getValue$iv.getValue();
    }

    private final void setContent(Function2<? super Composer, ? super Integer, Unit> function2) {
        MutableState $this$setValue$iv = this.content;
        $this$setValue$iv.setValue(function2);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    protected boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.shouldCreateCompositionOnAttachedToWindow;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void Content(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-463309699);
        ComposerKt.sourceInformation($composer2, "C(Content)520@21575L9:ModalBottomSheet.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-463309699, $changed, -1, "androidx.compose.material3.ModalBottomSheetWindow.Content (ModalBottomSheet.android.kt:519)");
        }
        getContent().invoke($composer2, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheetWindow$Content$4
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

            public final void invoke(Composer composer, int i) {
                ModalBottomSheetWindow.this.Content(composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    public static /* synthetic */ void setCustomContent$default(ModalBottomSheetWindow modalBottomSheetWindow, CompositionContext compositionContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            compositionContext = null;
        }
        modalBottomSheetWindow.setCustomContent(compositionContext, function2);
    }

    public final void setCustomContent(CompositionContext parent, Function2<? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter(content, "content");
        if (parent != null) {
            setParentCompositionContext(parent);
        }
        setContent(content);
        this.shouldCreateCompositionOnAttachedToWindow = true;
    }

    public final void show() {
        this.windowManager.addView(this, this.params);
    }

    public final void dismiss() {
        ViewTreeLifecycleOwner.set(this, null);
        ViewTreeSavedStateRegistryOwner.set(this, null);
        this.composeView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.windowManager.removeViewImmediate(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent event) {
        KeyEvent.DispatcherState state;
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getKeyCode() == 4) {
            if (getKeyDispatcherState() == null) {
                return super.dispatchKeyEvent(event);
            }
            if (event.getAction() == 0 && event.getRepeatCount() == 0) {
                KeyEvent.DispatcherState state2 = getKeyDispatcherState();
                if (state2 != null) {
                    state2.startTracking(event, this);
                }
                return true;
            }
            if (event.getAction() == 1 && (state = getKeyDispatcherState()) != null && state.isTracking(event) && !event.isCanceled()) {
                this.onDismissRequest.invoke();
                return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
    }
}
