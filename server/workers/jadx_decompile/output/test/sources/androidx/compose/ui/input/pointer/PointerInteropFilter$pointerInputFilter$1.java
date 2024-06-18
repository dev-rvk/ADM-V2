package androidx.compose.ui.input.pointer;

import android.os.SystemClock;
import android.view.MotionEvent;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInteropFilter;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PointerInteropFilter.android.kt */
@Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\tH\u0016J-\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0014\u001a\u00020\tH\u0002R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"androidx/compose/ui/input/pointer/PointerInteropFilter$pointerInputFilter$1", "Landroidx/compose/ui/input/pointer/PointerInputFilter;", "shareWithSiblings", "", "getShareWithSiblings", "()Z", "state", "Landroidx/compose/ui/input/pointer/PointerInteropFilter$DispatchToViewState;", "dispatchToView", "", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "onCancel", "onPointerEvent", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "reset", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PointerInteropFilter$pointerInputFilter$1 extends PointerInputFilter {
    private PointerInteropFilter.DispatchToViewState state = PointerInteropFilter.DispatchToViewState.Unknown;
    final /* synthetic */ PointerInteropFilter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PointerInteropFilter$pointerInputFilter$1(PointerInteropFilter $receiver) {
        this.this$0 = $receiver;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputFilter
    public boolean getShareWithSiblings() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    @Override // androidx.compose.ui.input.pointer.PointerInputFilter
    /* renamed from: onPointerEvent-H0pRuoY */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void mo4089onPointerEventH0pRuoY(androidx.compose.ui.input.pointer.PointerEvent r19, androidx.compose.ui.input.pointer.PointerEventPass r20, long r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r20
            java.lang.String r2 = "pointerEvent"
            r3 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            java.lang.String r2 = "pass"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.util.List r2 = r19.getChanges()
            androidx.compose.ui.input.pointer.PointerInteropFilter r4 = r0.this$0
            boolean r4 = r4.getDisallowIntercept()
            r5 = 0
            r6 = 1
            if (r4 != 0) goto L57
            r4 = r2
            r7 = 0
            r8 = r4
            r9 = 0
            r10 = 0
            int r11 = r8.size()
        L2b:
            if (r10 >= r11) goto L50
            java.lang.Object r12 = r8.get(r10)
            r13 = r12
            r14 = 0
            r15 = r13
            androidx.compose.ui.input.pointer.PointerInputChange r15 = (androidx.compose.ui.input.pointer.PointerInputChange) r15
            r16 = 0
            boolean r17 = androidx.compose.ui.input.pointer.PointerEventKt.changedToDownIgnoreConsumed(r15)
            if (r17 != 0) goto L47
            boolean r17 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r15)
            if (r17 == 0) goto L45
            goto L47
        L45:
            r15 = r5
            goto L48
        L47:
            r15 = r6
        L48:
            if (r15 == 0) goto L4c
            r4 = r6
            goto L52
        L4c:
            int r10 = r10 + 1
            goto L2b
        L50:
            r4 = r5
        L52:
            if (r4 == 0) goto L55
            goto L57
        L55:
            r4 = r5
            goto L58
        L57:
            r4 = r6
        L58:
            androidx.compose.ui.input.pointer.PointerInteropFilter$DispatchToViewState r7 = r0.state
            androidx.compose.ui.input.pointer.PointerInteropFilter$DispatchToViewState r8 = androidx.compose.ui.input.pointer.PointerInteropFilter.DispatchToViewState.NotDispatching
            if (r7 == r8) goto L71
            androidx.compose.ui.input.pointer.PointerEventPass r7 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
            if (r1 != r7) goto L68
            if (r4 == 0) goto L68
            r18.dispatchToView(r19)
        L68:
            androidx.compose.ui.input.pointer.PointerEventPass r7 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            if (r1 != r7) goto L71
            if (r4 != 0) goto L71
            r18.dispatchToView(r19)
        L71:
            androidx.compose.ui.input.pointer.PointerEventPass r7 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            if (r1 != r7) goto La0
            r7 = r2
            r8 = 0
            r9 = r7
            r10 = 0
            r11 = 0
            int r12 = r9.size()
        L80:
            if (r11 >= r12) goto L99
            java.lang.Object r13 = r9.get(r11)
            r14 = r13
            r15 = 0
            r16 = r14
            androidx.compose.ui.input.pointer.PointerInputChange r16 = (androidx.compose.ui.input.pointer.PointerInputChange) r16
            r17 = 0
            boolean r16 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r16)
            if (r16 != 0) goto L95
            goto L9b
        L95:
            int r11 = r11 + 1
            goto L80
        L99:
            r5 = r6
        L9b:
            if (r5 == 0) goto La0
            r18.reset()
        La0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.PointerInteropFilter$pointerInputFilter$1.mo4089onPointerEventH0pRuoY(androidx.compose.ui.input.pointer.PointerEvent, androidx.compose.ui.input.pointer.PointerEventPass, long):void");
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputFilter
    public void onCancel() {
        if (this.state == PointerInteropFilter.DispatchToViewState.Dispatching) {
            long uptimeMillis = SystemClock.uptimeMillis();
            final PointerInteropFilter pointerInteropFilter = this.this$0;
            PointerInteropUtils_androidKt.emptyCancelMotionEventScope(uptimeMillis, new Function1<MotionEvent, Unit>() { // from class: androidx.compose.ui.input.pointer.PointerInteropFilter$pointerInputFilter$1$onCancel$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(MotionEvent motionEvent) {
                    invoke2(motionEvent);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(MotionEvent motionEvent) {
                    Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
                    PointerInteropFilter.this.getOnTouchEvent().invoke(motionEvent);
                }
            });
            reset();
        }
    }

    private final void reset() {
        this.state = PointerInteropFilter.DispatchToViewState.Unknown;
        this.this$0.setDisallowIntercept$ui_release(false);
    }

    private final void dispatchToView(PointerEvent pointerEvent) {
        List $this$fastForEach$iv$iv;
        List changes = pointerEvent.getChanges();
        int index$iv$iv = 0;
        int size = changes.size();
        while (true) {
            if (index$iv$iv < size) {
                Object item$iv$iv = changes.get(index$iv$iv);
                PointerInputChange it = (PointerInputChange) item$iv$iv;
                if (it.isConsumed()) {
                    $this$fastForEach$iv$iv = 1;
                    break;
                }
                index$iv$iv++;
            } else {
                $this$fastForEach$iv$iv = null;
                break;
            }
        }
        if ($this$fastForEach$iv$iv != null) {
            if (this.state == PointerInteropFilter.DispatchToViewState.Dispatching) {
                LayoutCoordinates layoutCoordinates$ui_release = getLayoutCoordinates();
                if (layoutCoordinates$ui_release != null) {
                    long mo4195localToRootMKHz9U = layoutCoordinates$ui_release.mo4195localToRootMKHz9U(Offset.INSTANCE.m2726getZeroF1C5BW0());
                    final PointerInteropFilter pointerInteropFilter = this.this$0;
                    PointerInteropUtils_androidKt.m4126toCancelMotionEventScoped4ec7I(pointerEvent, mo4195localToRootMKHz9U, new Function1<MotionEvent, Unit>() { // from class: androidx.compose.ui.input.pointer.PointerInteropFilter$pointerInputFilter$1$dispatchToView$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(MotionEvent motionEvent) {
                            invoke2(motionEvent);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(MotionEvent motionEvent) {
                            Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
                            PointerInteropFilter.this.getOnTouchEvent().invoke(motionEvent);
                        }
                    });
                } else {
                    throw new IllegalStateException("layoutCoordinates not set".toString());
                }
            }
            this.state = PointerInteropFilter.DispatchToViewState.NotDispatching;
            return;
        }
        LayoutCoordinates layoutCoordinates$ui_release2 = getLayoutCoordinates();
        if (layoutCoordinates$ui_release2 != null) {
            long mo4195localToRootMKHz9U2 = layoutCoordinates$ui_release2.mo4195localToRootMKHz9U(Offset.INSTANCE.m2726getZeroF1C5BW0());
            final PointerInteropFilter pointerInteropFilter2 = this.this$0;
            PointerInteropUtils_androidKt.m4127toMotionEventScoped4ec7I(pointerEvent, mo4195localToRootMKHz9U2, new Function1<MotionEvent, Unit>() { // from class: androidx.compose.ui.input.pointer.PointerInteropFilter$pointerInputFilter$1$dispatchToView$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(MotionEvent motionEvent) {
                    invoke2(motionEvent);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(MotionEvent motionEvent) {
                    PointerInteropFilter.DispatchToViewState dispatchToViewState;
                    Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
                    if (motionEvent.getActionMasked() == 0) {
                        PointerInteropFilter$pointerInputFilter$1 pointerInteropFilter$pointerInputFilter$1 = PointerInteropFilter$pointerInputFilter$1.this;
                        if (pointerInteropFilter2.getOnTouchEvent().invoke(motionEvent).booleanValue()) {
                            dispatchToViewState = PointerInteropFilter.DispatchToViewState.Dispatching;
                        } else {
                            dispatchToViewState = PointerInteropFilter.DispatchToViewState.NotDispatching;
                        }
                        pointerInteropFilter$pointerInputFilter$1.state = dispatchToViewState;
                        return;
                    }
                    pointerInteropFilter2.getOnTouchEvent().invoke(motionEvent);
                }
            });
            if (this.state != PointerInteropFilter.DispatchToViewState.Dispatching) {
                return;
            }
            int size2 = changes.size();
            for (int index$iv = 0; index$iv < size2; index$iv++) {
                Object item$iv = changes.get(index$iv);
                PointerInputChange it2 = (PointerInputChange) item$iv;
                it2.consume();
            }
            InternalPointerEvent internalPointerEvent = pointerEvent.getInternalPointerEvent();
            if (internalPointerEvent != null) {
                internalPointerEvent.setSuppressMovementConsumption(!this.this$0.getDisallowIntercept());
                return;
            }
            return;
        }
        throw new IllegalStateException("layoutCoordinates not set".toString());
    }
}
