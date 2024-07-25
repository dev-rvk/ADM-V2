package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TapGestureDetector.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004ø\u0001\u0001\u0082\u0002\n\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/unit/Density;", "awaitRelease", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryAwaitRelease", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public interface PressGestureScope extends Density {
    Object awaitRelease(Continuation<? super Unit> continuation);

    Object tryAwaitRelease(Continuation<? super Boolean> continuation);

    /* compiled from: TapGestureDetector.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m310roundToPxR2X_6o(PressGestureScope $this, long $receiver) {
            return PressGestureScope.super.mo322roundToPxR2X_6o($receiver);
        }

        @Deprecated
        /* renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m311roundToPx0680j_4(PressGestureScope $this, float $receiver) {
            return PressGestureScope.super.mo323roundToPx0680j_4($receiver);
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m312toDpGaN1DYA(PressGestureScope $this, long $receiver) {
            return PressGestureScope.super.mo324toDpGaN1DYA($receiver);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m313toDpu2uoSUM(PressGestureScope $this, float $receiver) {
            return PressGestureScope.super.mo325toDpu2uoSUM($receiver);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m314toDpu2uoSUM(PressGestureScope $this, int $receiver) {
            return PressGestureScope.super.mo326toDpu2uoSUM($receiver);
        }

        @Deprecated
        /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m315toDpSizekrfVVM(PressGestureScope $this, long $receiver) {
            return PressGestureScope.super.mo327toDpSizekrfVVM($receiver);
        }

        @Deprecated
        /* renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m316toPxR2X_6o(PressGestureScope $this, long $receiver) {
            return PressGestureScope.super.mo328toPxR2X_6o($receiver);
        }

        @Deprecated
        /* renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m317toPx0680j_4(PressGestureScope $this, float $receiver) {
            return PressGestureScope.super.mo329toPx0680j_4($receiver);
        }

        @Deprecated
        public static Rect toRect(PressGestureScope $this, DpRect receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return PressGestureScope.super.toRect(receiver);
        }

        @Deprecated
        /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m318toSizeXkaWNTQ(PressGestureScope $this, long $receiver) {
            return PressGestureScope.super.mo330toSizeXkaWNTQ($receiver);
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m319toSp0xMU5do(PressGestureScope $this, float $receiver) {
            return PressGestureScope.super.mo331toSp0xMU5do($receiver);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m320toSpkPz2Gy4(PressGestureScope $this, float $receiver) {
            return PressGestureScope.super.mo332toSpkPz2Gy4($receiver);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m321toSpkPz2Gy4(PressGestureScope $this, int $receiver) {
            return PressGestureScope.super.mo333toSpkPz2Gy4($receiver);
        }
    }
}
