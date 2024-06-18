package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: SuspendingPointerInputFilter.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001GB1\u0012'\u0010\u0005\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0002\b\nø\u0001\u0000¢\u0006\u0002\u0010\u000bJ@\u00103\u001a\u0002H4\"\u0004\b\u0000\u001042'\u00105\u001a#\b\u0001\u0012\u0004\u0012\u000206\u0012\n\u0012\b\u0012\u0004\u0012\u0002H40\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0002\b\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u00107J\u0018\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\u00102\u0006\u0010:\u001a\u00020;H\u0002J-\u0010<\u001a\u00020\b2\u0006\u0010:\u001a\u00020;2\u001a\u00105\u001a\u0016\u0012\f\u0012\n\u0012\u0002\b\u00030\u0017R\u00020\u0000\u0012\u0004\u0012\u00020\b0=H\u0082\bJ\b\u0010>\u001a\u00020\bH\u0016J\b\u0010?\u001a\u00020\bH\u0016J\b\u0010@\u001a\u00020\bH\u0016J-\u0010A\u001a\u00020\b2\u0006\u00109\u001a\u00020\u00102\u0006\u0010:\u001a\u00020;2\u0006\u0010B\u001a\u00020\rH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010DJ\b\u0010E\u001a\u00020\bH\u0016J\b\u0010F\u001a\u00020\bH\u0016R\u0019\u0010\f\u001a\u00020\rX\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u00030\u0017R\u00020\u00000\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0018\u001a\u00020\u00198VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0014R\u001a\u0010\u001e\u001a\u00020\u001fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u00030\u0017R\u00020\u00000\u0016X\u0082\u0004¢\u0006\u0002\n\u0000Rk\u0010\u0005\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0002\b\n2'\u0010&\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0002\b\n@VX\u0096\u000eø\u0001\u0000¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b'\u0010(\"\u0004\b)\u0010\u000bR\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010-\u001a\u00020\r8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b.\u0010\u001bR\u0014\u0010/\u001a\u0002008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u00102\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006H"}, d2 = {"Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNodeImpl;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "Landroidx/compose/ui/unit/Density;", "pointerInputHandler", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)V", "boundsSize", "Landroidx/compose/ui/unit/IntSize;", "J", "currentEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "density", "", "getDensity", "()F", "dispatchingPointerHandlers", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine;", "extendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "getExtendedTouchPadding-NH-jbRc", "()J", "fontScale", "getFontScale", "interceptOutOfBoundsChildEvents", "", "getInterceptOutOfBoundsChildEvents", "()Z", "setInterceptOutOfBoundsChildEvents", "(Z)V", "lastPointerEvent", "pointerHandlers", "value", "getPointerInputHandler", "()Lkotlin/jvm/functions/Function2;", "setPointerInputHandler", "Lkotlin/jvm/functions/Function2;", "pointerInputJob", "Lkotlinx/coroutines/Job;", "size", "getSize-YbymL2g", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "awaitPointerEventScope", "R", "block", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchPointerEvent", "pointerEvent", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "forEachCurrentPointerHandler", "Lkotlin/Function1;", "onCancelPointerInput", "onDensityChange", "onDetach", "onPointerEvent", "bounds", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onViewConfigurationChange", "resetPointerInputHandler", "PointerEventHandlerCoroutine", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SuspendingPointerInputModifierNodeImpl extends Modifier.Node implements SuspendingPointerInputModifierNode, PointerInputScope, Density {
    private long boundsSize;
    private PointerEvent currentEvent;
    private final MutableVector<PointerEventHandlerCoroutine<?>> dispatchingPointerHandlers;
    private boolean interceptOutOfBoundsChildEvents;
    private PointerEvent lastPointerEvent;
    private final MutableVector<PointerEventHandlerCoroutine<?>> pointerHandlers;
    private Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> pointerInputHandler;
    private Job pointerInputJob;

    /* compiled from: SuspendingPointerInputFilter.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PointerEventPass.values().length];
            try {
                iArr[PointerEventPass.Initial.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[PointerEventPass.Final.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[PointerEventPass.Main.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SuspendingPointerInputModifierNodeImpl(Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> pointerInputHandler) {
        PointerEvent pointerEvent;
        Intrinsics.checkNotNullParameter(pointerInputHandler, "pointerInputHandler");
        this.pointerInputHandler = pointerInputHandler;
        pointerEvent = SuspendingPointerInputFilterKt.EmptyPointerEvent;
        this.currentEvent = pointerEvent;
        this.pointerHandlers = new MutableVector<>(new PointerEventHandlerCoroutine[16], 0);
        this.dispatchingPointerHandlers = new MutableVector<>(new PointerEventHandlerCoroutine[16], 0);
        this.boundsSize = IntSize.INSTANCE.m5383getZeroYbymL2g();
    }

    @Override // androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode
    public Function2<PointerInputScope, Continuation<? super Unit>, Object> getPointerInputHandler() {
        return this.pointerInputHandler;
    }

    @Override // androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode
    public void setPointerInputHandler(Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        resetPointerInputHandler();
        this.pointerInputHandler = value;
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return DelegatableNodeKt.requireLayoutNode(this).getDensity().getDensity();
    }

    @Override // androidx.compose.ui.unit.Density
    public float getFontScale() {
        return DelegatableNodeKt.requireLayoutNode(this).getDensity().getFontScale();
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputScope
    public ViewConfiguration getViewConfiguration() {
        return DelegatableNodeKt.requireLayoutNode(this).getViewConfiguration();
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputScope
    /* renamed from: getSize-YbymL2g, reason: from getter */
    public long getBoundsSize() {
        return this.boundsSize;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputScope
    /* renamed from: getExtendedTouchPadding-NH-jbRc */
    public long mo4103getExtendedTouchPaddingNHjbRc() {
        long minimumTouchTargetSize = mo330toSizeXkaWNTQ(getViewConfiguration().mo4329getMinimumTouchTargetSizeMYxV2XQ());
        long size = getBoundsSize();
        float horizontal = Math.max(0.0f, Size.m2779getWidthimpl(minimumTouchTargetSize) - IntSize.m5378getWidthimpl(size)) / 2.0f;
        float vertical = Math.max(0.0f, Size.m2776getHeightimpl(minimumTouchTargetSize) - IntSize.m5377getHeightimpl(size)) / 2.0f;
        return SizeKt.Size(horizontal, vertical);
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputScope
    public boolean getInterceptOutOfBoundsChildEvents() {
        return this.interceptOutOfBoundsChildEvents;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputScope
    public void setInterceptOutOfBoundsChildEvents(boolean z) {
        this.interceptOutOfBoundsChildEvents = z;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        resetPointerInputHandler();
        super.onDetach();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void onDensityChange() {
        resetPointerInputHandler();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void onViewConfigurationChange() {
        resetPointerInputHandler();
    }

    @Override // androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode
    public void resetPointerInputHandler() {
        Job localJob = this.pointerInputJob;
        if (localJob != null) {
            localJob.cancel((CancellationException) new PointerInputResetException());
            this.pointerInputJob = null;
        }
    }

    private final void forEachCurrentPointerHandler(PointerEventPass pass, Function1<? super PointerEventHandlerCoroutine<?>, Unit> block) {
        Object lock$iv = this.pointerHandlers;
        synchronized (lock$iv) {
            try {
                MutableVector this_$iv = this.dispatchingPointerHandlers;
                MutableVector elements$iv = this.pointerHandlers;
                this_$iv.addAll(this_$iv.getSize(), elements$iv);
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        try {
            switch (WhenMappings.$EnumSwitchMapping$0[pass.ordinal()]) {
                case 1:
                case 2:
                    MutableVector this_$iv2 = this.dispatchingPointerHandlers;
                    int size$iv = this_$iv2.getSize();
                    if (size$iv > 0) {
                        int i$iv = 0;
                        Object[] content$iv = this_$iv2.getContent();
                        do {
                            block.invoke(content$iv[i$iv]);
                            i$iv++;
                        } while (i$iv < size$iv);
                    }
                    break;
                case 3:
                    MutableVector this_$iv3 = this.dispatchingPointerHandlers;
                    int size$iv2 = this_$iv3.getSize();
                    if (size$iv2 > 0) {
                        int i$iv2 = size$iv2 - 1;
                        Object[] content$iv2 = this_$iv3.getContent();
                        do {
                            block.invoke(content$iv2[i$iv2]);
                            i$iv2--;
                        } while (i$iv2 >= 0);
                    }
                    break;
            }
        } finally {
            InlineMarker.finallyStart(1);
            this.dispatchingPointerHandlers.clear();
            InlineMarker.finallyEnd(1);
        }
    }

    private final void dispatchPointerEvent(PointerEvent pointerEvent, PointerEventPass pass) {
        Object lock$iv$iv = this.pointerHandlers;
        synchronized (lock$iv$iv) {
            MutableVector this_$iv$iv = this.dispatchingPointerHandlers;
            MutableVector elements$iv$iv = this.pointerHandlers;
            this_$iv$iv.addAll(this_$iv$iv.getSize(), elements$iv$iv);
        }
        try {
            switch (WhenMappings.$EnumSwitchMapping$0[pass.ordinal()]) {
                case 1:
                case 2:
                    MutableVector this_$iv$iv2 = this.dispatchingPointerHandlers;
                    int size$iv$iv = this_$iv$iv2.getSize();
                    if (size$iv$iv > 0) {
                        int i$iv$iv = 0;
                        Object[] content$iv$iv = this_$iv$iv2.getContent();
                        do {
                            PointerEventHandlerCoroutine it = (PointerEventHandlerCoroutine) content$iv$iv[i$iv$iv];
                            it.offerPointerEvent(pointerEvent, pass);
                            i$iv$iv++;
                        } while (i$iv$iv < size$iv$iv);
                    }
                    break;
                case 3:
                    MutableVector this_$iv$iv3 = this.dispatchingPointerHandlers;
                    int size$iv$iv2 = this_$iv$iv3.getSize();
                    if (size$iv$iv2 > 0) {
                        int i$iv$iv2 = size$iv$iv2 - 1;
                        Object[] content$iv$iv2 = this_$iv$iv3.getContent();
                        do {
                            PointerEventHandlerCoroutine it2 = (PointerEventHandlerCoroutine) content$iv$iv2[i$iv$iv2];
                            it2.offerPointerEvent(pointerEvent, pass);
                            i$iv$iv2--;
                        } while (i$iv$iv2 >= 0);
                    }
                    break;
            }
        } finally {
            this.dispatchingPointerHandlers.clear();
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* renamed from: onPointerEvent-H0pRuoY */
    public void mo146onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        boolean z;
        Job launch$default;
        Intrinsics.checkNotNullParameter(pointerEvent, "pointerEvent");
        Intrinsics.checkNotNullParameter(pass, "pass");
        this.boundsSize = bounds;
        if (pass == PointerEventPass.Initial) {
            this.currentEvent = pointerEvent;
        }
        if (this.pointerInputJob == null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new SuspendingPointerInputModifierNodeImpl$onPointerEvent$1(this, null), 1, null);
            this.pointerInputJob = launch$default;
        }
        dispatchPointerEvent(pointerEvent, pass);
        List $this$fastAll$iv = pointerEvent.getChanges();
        int index$iv$iv = 0;
        int size = $this$fastAll$iv.size();
        while (true) {
            if (index$iv$iv < size) {
                Object item$iv$iv = $this$fastAll$iv.get(index$iv$iv);
                PointerInputChange it = (PointerInputChange) item$iv$iv;
                if (!PointerEventKt.changedToUpIgnoreConsumed(it)) {
                    z = false;
                    break;
                }
                index$iv$iv++;
            } else {
                z = true;
                break;
            }
        }
        this.lastPointerEvent = z ^ true ? pointerEvent : null;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        boolean z;
        PointerEvent lastEvent = this.lastPointerEvent;
        if (lastEvent == null) {
            return;
        }
        List $this$fastAll$iv = lastEvent.getChanges();
        int index$iv$iv = 0;
        int size = $this$fastAll$iv.size();
        while (true) {
            z = true;
            if (index$iv$iv >= size) {
                break;
            }
            Object item$iv$iv = $this$fastAll$iv.get(index$iv$iv);
            PointerInputChange it = (PointerInputChange) item$iv$iv;
            if (!(true ^ it.getPressed())) {
                z = false;
                break;
            }
            index$iv$iv++;
        }
        if (z) {
            return;
        }
        List $this$fastMapNotNull$iv = lastEvent.getChanges();
        List target$iv = new ArrayList($this$fastMapNotNull$iv.size());
        int size2 = $this$fastMapNotNull$iv.size();
        for (int index$iv$iv2 = 0; index$iv$iv2 < size2; index$iv$iv2++) {
            Object item$iv$iv2 = $this$fastMapNotNull$iv.get(index$iv$iv2);
            PointerInputChange old = (PointerInputChange) item$iv$iv2;
            long id = old.getId();
            long position = old.getPosition();
            List list = target$iv;
            list.add(new PointerInputChange(id, old.getUptimeMillis(), position, false, old.getPressure(), old.getUptimeMillis(), old.getPosition(), old.getPressed(), old.getPressed(), 0, 0L, 1536, (DefaultConstructorMarker) null));
        }
        List newChanges = target$iv;
        PointerEvent cancelEvent = new PointerEvent(newChanges);
        this.currentEvent = cancelEvent;
        dispatchPointerEvent(cancelEvent, PointerEventPass.Initial);
        dispatchPointerEvent(cancelEvent, PointerEventPass.Main);
        dispatchPointerEvent(cancelEvent, PointerEventPass.Final);
        this.lastPointerEvent = null;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputScope
    public <R> Object awaitPointerEventScope(Function2<? super AwaitPointerEventScope, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellable$iv.initCancellability();
        CancellableContinuationImpl continuation2 = cancellable$iv;
        final PointerEventHandlerCoroutine handlerCoroutine = new PointerEventHandlerCoroutine(this, continuation2);
        Object lock$iv = this.pointerHandlers;
        synchronized (lock$iv) {
            MutableVector this_$iv = this.pointerHandlers;
            this_$iv.add(handlerCoroutine);
            Continuation<Unit> createCoroutine = ContinuationKt.createCoroutine(function2, handlerCoroutine, handlerCoroutine);
            Result.Companion companion = Result.INSTANCE;
            createCoroutine.resumeWith(Result.m5615constructorimpl(Unit.INSTANCE));
            Unit unit = Unit.INSTANCE;
        }
        continuation2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$awaitPointerEventScope$2$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                handlerCoroutine.cancel(it);
            }
        });
        Object result = cancellable$iv.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SuspendingPointerInputFilter.kt */
    @Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0006J\u0019\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*J\u0016\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\bJ\u001e\u0010-\u001a\u00020(2\f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000/H\u0016ø\u0001\u0000¢\u0006\u0002\u00100JH\u00101\u001a\u0002H2\"\u0004\b\u0001\u001022\u0006\u00103\u001a\u0002042'\u00105\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H20\u0004\u0012\u0006\u0012\u0004\u0018\u00010706¢\u0006\u0002\b8H\u0096@ø\u0001\u0000¢\u0006\u0002\u00109JJ\u0010:\u001a\u0004\u0018\u0001H2\"\u0004\b\u0001\u001022\u0006\u00103\u001a\u0002042'\u00105\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H20\u0004\u0012\u0006\u0012\u0004\u0018\u00010706¢\u0006\u0002\b8H\u0096@ø\u0001\u0000¢\u0006\u0002\u00109J\u001a\u0010;\u001a\u00020<*\u00020=H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b>\u0010?J\u001a\u0010;\u001a\u00020<*\u00020@H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bA\u0010BJ\u001a\u0010C\u001a\u00020=*\u00020@H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010EJ\u001d\u0010C\u001a\u00020=*\u00020\u0012H\u0097\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bF\u0010GJ\u001d\u0010C\u001a\u00020=*\u00020<H\u0097\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bF\u0010HJ\u001a\u0010I\u001a\u00020J*\u00020\u0016H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bK\u0010LJ\u001a\u0010M\u001a\u00020\u0012*\u00020=H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bN\u0010GJ\u001a\u0010M\u001a\u00020\u0012*\u00020@H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bO\u0010EJ\r\u0010P\u001a\u00020Q*\u00020RH\u0097\u0001J\u001a\u0010S\u001a\u00020\u0016*\u00020JH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bT\u0010LJ\u001a\u0010U\u001a\u00020@*\u00020=H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bV\u0010WJ\u001d\u0010U\u001a\u00020@*\u00020\u0012H\u0097\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bX\u0010WJ\u001d\u0010U\u001a\u00020@*\u00020<H\u0097\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bX\u0010YR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00128\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0014R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0018R\u0014\u0010 \u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Z"}, d2 = {"Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine;", "R", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/coroutines/Continuation;", "completion", "(Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNodeImpl;Lkotlin/coroutines/Continuation;)V", "awaitPass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "currentEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "getCurrentEvent", "()Landroidx/compose/ui/input/pointer/PointerEvent;", "density", "", "getDensity", "()F", "extendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "getExtendedTouchPadding-NH-jbRc", "()J", "fontScale", "getFontScale", "pointerAwaiter", "Lkotlinx/coroutines/CancellableContinuation;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "awaitPointerEvent", "pass", "(Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "", "cause", "", "offerPointerEvent", NotificationCompat.CATEGORY_EVENT, "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "withTimeout", "T", "timeMillis", "", "block", "Lkotlin/Function2;", "", "Lkotlin/ExtensionFunctionType;", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeoutOrNull", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public final class PointerEventHandlerCoroutine<R> implements AwaitPointerEventScope, Density, Continuation<R> {
        private final /* synthetic */ SuspendingPointerInputModifierNodeImpl $$delegate_0;
        private PointerEventPass awaitPass;
        private final Continuation<R> completion;
        private final CoroutineContext context;
        private CancellableContinuation<? super PointerEvent> pointerAwaiter;
        final /* synthetic */ SuspendingPointerInputModifierNodeImpl this$0;

        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            return this.$$delegate_0.getDensity();
        }

        @Override // androidx.compose.ui.unit.Density
        public float getFontScale() {
            return this.$$delegate_0.getFontScale();
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: roundToPx--R2X_6o */
        public int mo322roundToPxR2X_6o(long j) {
            return this.$$delegate_0.mo322roundToPxR2X_6o(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: roundToPx-0680j_4 */
        public int mo323roundToPx0680j_4(float f) {
            return this.$$delegate_0.mo323roundToPx0680j_4(f);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toDp-GaN1DYA */
        public float mo324toDpGaN1DYA(long j) {
            return this.$$delegate_0.mo324toDpGaN1DYA(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toDp-u2uoSUM */
        public float mo325toDpu2uoSUM(float f) {
            return this.$$delegate_0.mo325toDpu2uoSUM(f);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toDp-u2uoSUM */
        public float mo326toDpu2uoSUM(int i) {
            return this.$$delegate_0.mo326toDpu2uoSUM(i);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toDpSize-k-rfVVM */
        public long mo327toDpSizekrfVVM(long j) {
            return this.$$delegate_0.mo327toDpSizekrfVVM(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toPx--R2X_6o */
        public float mo328toPxR2X_6o(long j) {
            return this.$$delegate_0.mo328toPxR2X_6o(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toPx-0680j_4 */
        public float mo329toPx0680j_4(float f) {
            return this.$$delegate_0.mo329toPx0680j_4(f);
        }

        @Override // androidx.compose.ui.unit.Density
        public Rect toRect(DpRect dpRect) {
            Intrinsics.checkNotNullParameter(dpRect, "<this>");
            return this.$$delegate_0.toRect(dpRect);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toSize-XkaWNTQ */
        public long mo330toSizeXkaWNTQ(long j) {
            return this.$$delegate_0.mo330toSizeXkaWNTQ(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toSp-0xMU5do */
        public long mo331toSp0xMU5do(float f) {
            return this.$$delegate_0.mo331toSp0xMU5do(f);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toSp-kPz2Gy4 */
        public long mo332toSpkPz2Gy4(float f) {
            return this.$$delegate_0.mo332toSpkPz2Gy4(f);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toSp-kPz2Gy4 */
        public long mo333toSpkPz2Gy4(int i) {
            return this.$$delegate_0.mo333toSpkPz2Gy4(i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public PointerEventHandlerCoroutine(SuspendingPointerInputModifierNodeImpl this$0, Continuation<? super R> completion) {
            Intrinsics.checkNotNullParameter(completion, "completion");
            this.this$0 = this$0;
            this.completion = completion;
            this.$$delegate_0 = this.this$0;
            this.awaitPass = PointerEventPass.Main;
            this.context = EmptyCoroutineContext.INSTANCE;
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public PointerEvent getCurrentEvent() {
            return this.this$0.currentEvent;
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        /* renamed from: getSize-YbymL2g */
        public long mo3982getSizeYbymL2g() {
            return this.this$0.boundsSize;
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public ViewConfiguration getViewConfiguration() {
            return this.this$0.getViewConfiguration();
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        /* renamed from: getExtendedTouchPadding-NH-jbRc */
        public long mo3981getExtendedTouchPaddingNHjbRc() {
            return this.this$0.mo4103getExtendedTouchPaddingNHjbRc();
        }

        public final void offerPointerEvent(PointerEvent event, PointerEventPass pass) {
            CancellableContinuation $this$offerPointerEvent_u24lambda_u240;
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(pass, "pass");
            if (pass == this.awaitPass && ($this$offerPointerEvent_u24lambda_u240 = this.pointerAwaiter) != null) {
                this.pointerAwaiter = null;
                Result.Companion companion = Result.INSTANCE;
                $this$offerPointerEvent_u24lambda_u240.resumeWith(Result.m5615constructorimpl(event));
            }
        }

        public final void cancel(Throwable cause) {
            CancellableContinuation<? super PointerEvent> cancellableContinuation = this.pointerAwaiter;
            if (cancellableContinuation != null) {
                cancellableContinuation.cancel(cause);
            }
            this.pointerAwaiter = null;
        }

        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.context;
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(Object result) {
            Object lock$iv = this.this$0.pointerHandlers;
            SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl = this.this$0;
            synchronized (lock$iv) {
                MutableVector this_$iv = suspendingPointerInputModifierNodeImpl.pointerHandlers;
                this_$iv.remove(this);
                Unit unit = Unit.INSTANCE;
            }
            this.completion.resumeWith(result);
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public Object awaitPointerEvent(PointerEventPass pass, Continuation<? super PointerEvent> continuation) {
            CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellable$iv.initCancellability();
            CancellableContinuationImpl continuation2 = cancellable$iv;
            this.awaitPass = pass;
            this.pointerAwaiter = continuation2;
            Object result = cancellable$iv.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x002d A[Catch: PointerEventTimeoutCancellationException -> 0x0032, TRY_ENTER, TRY_LEAVE, TryCatch #0 {PointerEventTimeoutCancellationException -> 0x0032, blocks: (B:12:0x002d, B:18:0x003a), top: B:7:0x0022 }] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public <T> java.lang.Object withTimeoutOrNull(long r5, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.AwaitPointerEventScope, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r7, kotlin.coroutines.Continuation<? super T> r8) {
            /*
                r4 = this;
                boolean r0 = r8 instanceof androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1
                if (r0 == 0) goto L14
                r0 = r8
                androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1 r0 = (androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L14
                int r8 = r0.label
                int r8 = r8 - r2
                r0.label = r8
                goto L19
            L14:
                androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1 r0 = new androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1
                r0.<init>(r4, r8)
            L19:
                r8 = r0
                java.lang.Object r0 = r8.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r8.label
                switch(r2) {
                    case 0: goto L34;
                    case 1: goto L2d;
                    default: goto L25;
                }
            L25:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L2d:
                kotlin.ResultKt.throwOnFailure(r0)     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L32
                r3 = r0
                goto L43
            L32:
                r5 = move-exception
                goto L44
            L34:
                kotlin.ResultKt.throwOnFailure(r0)
                r2 = r4
                r3 = 1
                r8.label = r3     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L32
                java.lang.Object r3 = r2.withTimeout(r5, r7, r8)     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L32
                if (r3 != r1) goto L43
                return r1
            L43:
                goto L45
            L44:
                r3 = 0
            L45:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine.withTimeoutOrNull(long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0022. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0039  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public <T> java.lang.Object withTimeout(long r11, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.AwaitPointerEventScope, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r13, kotlin.coroutines.Continuation<? super T> r14) {
            /*
                r10 = this;
                boolean r0 = r14 instanceof androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1
                if (r0 == 0) goto L14
                r0 = r14
                androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1 r0 = (androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L14
                int r14 = r0.label
                int r14 = r14 - r2
                r0.label = r14
                goto L19
            L14:
                androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1 r0 = new androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1
                r0.<init>(r10, r14)
            L19:
                r14 = r0
                java.lang.Object r0 = r14.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r14.label
                switch(r2) {
                    case 0: goto L39;
                    case 1: goto L2d;
                    default: goto L25;
                }
            L25:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r12)
                throw r11
            L2d:
                java.lang.Object r11 = r14.L$0
                kotlinx.coroutines.Job r11 = (kotlinx.coroutines.Job) r11
                kotlin.ResultKt.throwOnFailure(r0)     // Catch: java.lang.Throwable -> L37
                r3 = r11
                r11 = r0
                goto L80
            L37:
                r12 = move-exception
                goto L8a
            L39:
                kotlin.ResultKt.throwOnFailure(r0)
                r2 = r10
                r3 = 0
                int r3 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
                if (r3 > 0) goto L5d
                kotlinx.coroutines.CancellableContinuation<? super androidx.compose.ui.input.pointer.PointerEvent> r3 = r2.pointerAwaiter
                if (r3 == 0) goto L5d
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                kotlin.Result$Companion r4 = kotlin.Result.INSTANCE
                androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException r4 = new androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException
                r4.<init>(r11)
                java.lang.Throwable r4 = (java.lang.Throwable) r4
                java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)
                java.lang.Object r4 = kotlin.Result.m5615constructorimpl(r4)
                r3.resumeWith(r4)
            L5d:
                androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl r3 = r2.this$0
                kotlinx.coroutines.CoroutineScope r4 = r3.getCoroutineScope()
                androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1 r3 = new androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1
                r5 = 0
                r3.<init>(r11, r2, r5)
                r7 = r3
                kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
                r8 = 3
                r9 = 0
                r6 = 0
                kotlinx.coroutines.Job r3 = kotlinx.coroutines.BuildersKt.launch$default(r4, r5, r6, r7, r8, r9)
                r14.L$0 = r3     // Catch: java.lang.Throwable -> L88
                r11 = 1
                r14.label = r11     // Catch: java.lang.Throwable -> L88
                java.lang.Object r11 = r13.invoke(r2, r14)     // Catch: java.lang.Throwable -> L88
                if (r11 != r1) goto L80
                return r1
            L80:
                androidx.compose.ui.input.pointer.CancelTimeoutCancellationException r12 = androidx.compose.ui.input.pointer.CancelTimeoutCancellationException.INSTANCE
                java.util.concurrent.CancellationException r12 = (java.util.concurrent.CancellationException) r12
                r3.cancel(r12)
                return r11
            L88:
                r12 = move-exception
                r11 = r3
            L8a:
                androidx.compose.ui.input.pointer.CancelTimeoutCancellationException r13 = androidx.compose.ui.input.pointer.CancelTimeoutCancellationException.INSTANCE
                java.util.concurrent.CancellationException r13 = (java.util.concurrent.CancellationException) r13
                r11.cancel(r13)
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine.withTimeout(long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }
}
