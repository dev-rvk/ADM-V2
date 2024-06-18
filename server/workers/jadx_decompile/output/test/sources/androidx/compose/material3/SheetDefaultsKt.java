package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Velocity;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SheetDefaults.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a;\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\rH\u0000\u001aA\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00150\r2\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u0015H\u0001¢\u0006\u0002\u0010\u001a\"\u0019\u0010\u0000\u001a\u00020\u0001X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"BottomSheetMaxWidth", "Landroidx/compose/ui/unit/Dp;", "getBottomSheetMaxWidth", "()F", "F", "DragHandleVerticalPadding", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "sheetState", "Landroidx/compose/material3/SheetState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "onFling", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "velocity", "", "rememberSheetState", "skipPartiallyExpanded", "", "confirmValueChange", "Landroidx/compose/material3/SheetValue;", "initialValue", "skipHiddenState", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/material3/SheetValue;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SheetDefaultsKt {
    private static final float DragHandleVerticalPadding = Dp.m5218constructorimpl(22);
    private static final float BottomSheetMaxWidth = Dp.m5218constructorimpl(640);

    public static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(final SheetState sheetState, final Orientation orientation, final Function1<? super Float, Unit> onFling) {
        Intrinsics.checkNotNullParameter(sheetState, "sheetState");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(onFling, "onFling");
        return new NestedScrollConnection() { // from class: androidx.compose.material3.SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1
            @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
            /* renamed from: onPreScroll-OzD1aCk */
            public long mo338onPreScrollOzD1aCk(long available, int source) {
                float delta = offsetToFloat(available);
                if (delta < 0.0f && NestedScrollSource.m3960equalsimpl0(source, NestedScrollSource.INSTANCE.m3965getDragWNlRxjI())) {
                    return toOffset(SheetState.this.getSwipeableState$material3_release().dispatchRawDelta(delta));
                }
                return Offset.INSTANCE.m2726getZeroF1C5BW0();
            }

            @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
            /* renamed from: onPostScroll-DzOQY0M */
            public long mo337onPostScrollDzOQY0M(long consumed, long available, int source) {
                if (NestedScrollSource.m3960equalsimpl0(source, NestedScrollSource.INSTANCE.m3965getDragWNlRxjI())) {
                    return toOffset(SheetState.this.getSwipeableState$material3_release().dispatchRawDelta(offsetToFloat(available)));
                }
                return Offset.INSTANCE.m2726getZeroF1C5BW0();
            }

            @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
            /* renamed from: onPreFling-QWom1Mo */
            public Object mo561onPreFlingQWom1Mo(long available, Continuation<? super Velocity> continuation) {
                long m5454getZero9UxMQ8M;
                float toFling = velocityToFloat(available);
                float currentOffset = SheetState.this.requireOffset();
                if (toFling < 0.0f && currentOffset > SheetState.this.getSwipeableState$material3_release().getMinOffset()) {
                    onFling.invoke(Boxing.boxFloat(toFling));
                    m5454getZero9UxMQ8M = available;
                } else {
                    m5454getZero9UxMQ8M = Velocity.INSTANCE.m5454getZero9UxMQ8M();
                }
                return Velocity.m5434boximpl(m5454getZero9UxMQ8M);
            }

            @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
            /* renamed from: onPostFling-RZ2iAVY */
            public Object mo336onPostFlingRZ2iAVY(long consumed, long available, Continuation<? super Velocity> continuation) {
                onFling.invoke(Boxing.boxFloat(velocityToFloat(available)));
                return Velocity.m5434boximpl(available);
            }

            private final long toOffset(float $this$toOffset) {
                return OffsetKt.Offset(orientation == Orientation.Horizontal ? $this$toOffset : 0.0f, orientation == Orientation.Vertical ? $this$toOffset : 0.0f);
            }

            private final float velocityToFloat(long $this$toFloat) {
                return orientation == Orientation.Horizontal ? Velocity.m5443getXimpl($this$toFloat) : Velocity.m5444getYimpl($this$toFloat);
            }

            private final float offsetToFloat(long $this$toFloat) {
                return orientation == Orientation.Horizontal ? Offset.m2710getXimpl($this$toFloat) : Offset.m2711getYimpl($this$toFloat);
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.material3.SheetState rememberSheetState(boolean r17, kotlin.jvm.functions.Function1<? super androidx.compose.material3.SheetValue, java.lang.Boolean> r18, androidx.compose.material3.SheetValue r19, boolean r20, androidx.compose.runtime.Composer r21, int r22, int r23) {
        /*
            r7 = r21
            r0 = 1032784200(0x3d8f0948, float:0.06984192)
            r7.startReplaceableGroup(r0)
            java.lang.String r1 = "C(rememberSheetState)P(3)422@15342L100,416@15112L330:SheetDefaults.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r1)
            r1 = r23 & 1
            if (r1 == 0) goto L14
            r1 = 0
            r8 = r1
            goto L16
        L14:
            r8 = r17
        L16:
            r1 = r23 & 2
            if (r1 == 0) goto L20
            androidx.compose.material3.SheetDefaultsKt$rememberSheetState$1 r1 = new kotlin.jvm.functions.Function1<androidx.compose.material3.SheetValue, java.lang.Boolean>() { // from class: androidx.compose.material3.SheetDefaultsKt$rememberSheetState$1
                static {
                    /*
                        androidx.compose.material3.SheetDefaultsKt$rememberSheetState$1 r0 = new androidx.compose.material3.SheetDefaultsKt$rememberSheetState$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:androidx.compose.material3.SheetDefaultsKt$rememberSheetState$1) androidx.compose.material3.SheetDefaultsKt$rememberSheetState$1.INSTANCE androidx.compose.material3.SheetDefaultsKt$rememberSheetState$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SheetDefaultsKt$rememberSheetState$1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 1
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SheetDefaultsKt$rememberSheetState$1.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function1
                public final java.lang.Boolean invoke(androidx.compose.material3.SheetValue r2) {
                    /*
                        r1 = this;
                        java.lang.String r0 = "it"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                        r0 = 1
                        java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SheetDefaultsKt$rememberSheetState$1.invoke(androidx.compose.material3.SheetValue):java.lang.Boolean");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ java.lang.Boolean invoke(androidx.compose.material3.SheetValue r2) {
                    /*
                        r1 = this;
                        r0 = r2
                        androidx.compose.material3.SheetValue r0 = (androidx.compose.material3.SheetValue) r0
                        java.lang.Boolean r0 = r1.invoke(r0)
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SheetDefaultsKt$rememberSheetState$1.invoke(java.lang.Object):java.lang.Object");
                }
            }
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r9 = r1
            goto L22
        L20:
            r9 = r18
        L22:
            r1 = r23 & 4
            if (r1 == 0) goto L2a
            androidx.compose.material3.SheetValue r1 = androidx.compose.material3.SheetValue.Hidden
            r10 = r1
            goto L2c
        L2a:
            r10 = r19
        L2c:
            r1 = r23 & 8
            if (r1 == 0) goto L33
            r1 = 0
            r11 = r1
            goto L35
        L33:
            r11 = r20
        L35:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L44
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.rememberSheetState (SheetDefaults.kt:410)"
            r12 = r22
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r12, r1, r2)
            goto L46
        L44:
            r12 = r22
        L46:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r8)
            java.lang.Object[] r0 = new java.lang.Object[]{r0, r9}
            androidx.compose.material3.SheetState$Companion r1 = androidx.compose.material3.SheetState.INSTANCE
            androidx.compose.runtime.saveable.Saver r1 = r1.Saver(r8, r9)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r8)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r11)
            java.lang.Object[] r2 = new java.lang.Object[]{r2, r10, r9, r3}
            r3 = 8
            r4 = 0
            r5 = -568225417(0xffffffffde219177, float:-2.9105543E18)
            r7.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r5)
            r5 = 0
            int r6 = r2.length
            r13 = 0
        L73:
            if (r13 >= r6) goto L7f
            r14 = r2[r13]
            boolean r15 = r7.changed(r14)
            r5 = r5 | r15
            int r13 = r13 + 1
            goto L73
        L7f:
            r6 = r21
            r13 = 0
            java.lang.Object r14 = r6.rememberedValue()
            r15 = 0
            if (r5 != 0) goto L96
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.INSTANCE
            r17 = r2
            java.lang.Object r2 = r16.getEmpty()
            if (r14 != r2) goto L94
            goto L98
        L94:
            r2 = r14
            goto La7
        L96:
            r17 = r2
        L98:
            r2 = 0
            r18 = r2
            androidx.compose.material3.SheetDefaultsKt$rememberSheetState$2$1 r2 = new androidx.compose.material3.SheetDefaultsKt$rememberSheetState$2$1
            r2.<init>()
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r6.updateRememberedValue(r2)
        La7:
            r21.endReplaceableGroup()
            r3 = r2
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r2 = 0
            r5 = 72
            r6 = 4
            r4 = r21
            java.lang.Object r0 = androidx.compose.runtime.saveable.RememberSaveableKt.m2596rememberSaveable(r0, r1, r2, r3, r4, r5, r6)
            androidx.compose.material3.SheetState r0 = (androidx.compose.material3.SheetState) r0
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto Lc4
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        Lc4:
            r21.endReplaceableGroup()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SheetDefaultsKt.rememberSheetState(boolean, kotlin.jvm.functions.Function1, androidx.compose.material3.SheetValue, boolean, androidx.compose.runtime.Composer, int, int):androidx.compose.material3.SheetState");
    }

    public static final float getBottomSheetMaxWidth() {
        return BottomSheetMaxWidth;
    }
}
