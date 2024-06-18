package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: Density.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u000b\u001a\u00020\f*\u00020\rH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u000b\u001a\u00020\f*\u00020\u0010H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\r*\u00020\u0010H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\u0013\u001a\u00020\r*\u00020\u0003H\u0017ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u0013\u001a\u00020\r*\u00020\fH\u0017ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u001a*\u00020\u001bH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\u0003*\u00020\rH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010\u0017J\u0019\u0010\u001e\u001a\u00020\u0003*\u00020\u0010H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010\u0015J\f\u0010!\u001a\u00020\"*\u00020#H\u0017J\u0019\u0010$\u001a\u00020\u001b*\u00020\u001aH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010\u001dJ\u0019\u0010&\u001a\u00020\u0010*\u00020\rH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(J\u001c\u0010&\u001a\u00020\u0010*\u00020\u0003H\u0017ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010(J\u001c\u0010&\u001a\u00020\u0010*\u00020\fH\u0017ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007ø\u0001\u0003\u0082\u0002\u0015\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!\n\u0004\b!0\u0001¨\u0006+À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/unit/Density;", "", "density", "", "getDensity$annotations", "()V", "getDensity", "()F", "fontScale", "getFontScale$annotations", "getFontScale", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public interface Density {
    float getDensity();

    float getFontScale();

    /* compiled from: Density.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void getDensity$annotations() {
        }

        public static /* synthetic */ void getFontScale$annotations() {
        }

        @Deprecated
        /* renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m5211toPx0680j_4(Density $this, float $receiver) {
            return Density.super.mo329toPx0680j_4($receiver);
        }

        @Deprecated
        /* renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m5205roundToPx0680j_4(Density $this, float $receiver) {
            return Density.super.mo323roundToPx0680j_4($receiver);
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m5213toSp0xMU5do(Density $this, float $receiver) {
            return Density.super.mo331toSp0xMU5do($receiver);
        }

        @Deprecated
        /* renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m5210toPxR2X_6o(Density $this, long $receiver) {
            return Density.super.mo328toPxR2X_6o($receiver);
        }

        @Deprecated
        /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m5204roundToPxR2X_6o(Density $this, long $receiver) {
            return Density.super.mo322roundToPxR2X_6o($receiver);
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m5206toDpGaN1DYA(Density $this, long $receiver) {
            return Density.super.mo324toDpGaN1DYA($receiver);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m5208toDpu2uoSUM(Density $this, int $receiver) {
            return Density.super.mo326toDpu2uoSUM($receiver);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m5215toSpkPz2Gy4(Density $this, int $receiver) {
            return Density.super.mo333toSpkPz2Gy4($receiver);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m5207toDpu2uoSUM(Density $this, float $receiver) {
            return Density.super.mo325toDpu2uoSUM($receiver);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m5214toSpkPz2Gy4(Density $this, float $receiver) {
            return Density.super.mo332toSpkPz2Gy4($receiver);
        }

        @Deprecated
        public static Rect toRect(Density $this, DpRect receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return Density.super.toRect(receiver);
        }

        @Deprecated
        /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m5212toSizeXkaWNTQ(Density $this, long $receiver) {
            return Density.super.mo330toSizeXkaWNTQ($receiver);
        }

        @Deprecated
        /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m5209toDpSizekrfVVM(Density $this, long $receiver) {
            return Density.super.mo327toDpSizekrfVVM($receiver);
        }
    }

    /* renamed from: toPx-0680j_4 */
    default float mo329toPx0680j_4(float $this$toPx_u2d0680j_4) {
        return getDensity() * $this$toPx_u2d0680j_4;
    }

    /* renamed from: roundToPx-0680j_4 */
    default int mo323roundToPx0680j_4(float $this$roundToPx_u2d0680j_4) {
        float px = mo329toPx0680j_4($this$roundToPx_u2d0680j_4);
        if (Float.isInfinite(px)) {
            return Integer.MAX_VALUE;
        }
        return MathKt.roundToInt(px);
    }

    /* renamed from: toSp-0xMU5do */
    default long mo331toSp0xMU5do(float $this$toSp_u2d0xMU5do) {
        return TextUnitKt.getSp($this$toSp_u2d0xMU5do / getFontScale());
    }

    /* renamed from: toPx--R2X_6o */
    default float mo328toPxR2X_6o(long $this$toPx_u2d_u2dR2X_6o) {
        if (TextUnitType.m5427equalsimpl0(TextUnit.m5398getTypeUIouoOA($this$toPx_u2d_u2dR2X_6o), TextUnitType.INSTANCE.m5432getSpUIouoOA())) {
            return TextUnit.m5399getValueimpl($this$toPx_u2d_u2dR2X_6o) * getFontScale() * getDensity();
        }
        throw new IllegalStateException("Only Sp can convert to Px".toString());
    }

    /* renamed from: roundToPx--R2X_6o */
    default int mo322roundToPxR2X_6o(long $this$roundToPx_u2d_u2dR2X_6o) {
        return MathKt.roundToInt(mo328toPxR2X_6o($this$roundToPx_u2d_u2dR2X_6o));
    }

    /* renamed from: toDp-GaN1DYA */
    default float mo324toDpGaN1DYA(long $this$toDp_u2dGaN1DYA) {
        if (TextUnitType.m5427equalsimpl0(TextUnit.m5398getTypeUIouoOA($this$toDp_u2dGaN1DYA), TextUnitType.INSTANCE.m5432getSpUIouoOA())) {
            return Dp.m5218constructorimpl(TextUnit.m5399getValueimpl($this$toDp_u2dGaN1DYA) * getFontScale());
        }
        throw new IllegalStateException("Only Sp can convert to Px".toString());
    }

    /* renamed from: toDp-u2uoSUM */
    default float mo326toDpu2uoSUM(int $this$toDp_u2du2uoSUM) {
        float $this$dp$iv = $this$toDp_u2du2uoSUM / getDensity();
        return Dp.m5218constructorimpl($this$dp$iv);
    }

    /* renamed from: toSp-kPz2Gy4 */
    default long mo333toSpkPz2Gy4(int $this$toSp_u2dkPz2Gy4) {
        return TextUnitKt.getSp($this$toSp_u2dkPz2Gy4 / (getFontScale() * getDensity()));
    }

    /* renamed from: toDp-u2uoSUM */
    default float mo325toDpu2uoSUM(float $this$toDp_u2du2uoSUM) {
        float $this$dp$iv = $this$toDp_u2du2uoSUM / getDensity();
        return Dp.m5218constructorimpl($this$dp$iv);
    }

    /* renamed from: toSp-kPz2Gy4 */
    default long mo332toSpkPz2Gy4(float $this$toSp_u2dkPz2Gy4) {
        return TextUnitKt.getSp($this$toSp_u2dkPz2Gy4 / (getFontScale() * getDensity()));
    }

    default Rect toRect(DpRect $this$toRect) {
        Intrinsics.checkNotNullParameter($this$toRect, "<this>");
        return new Rect(mo329toPx0680j_4($this$toRect.m5301getLeftD9Ej5fM()), mo329toPx0680j_4($this$toRect.m5303getTopD9Ej5fM()), mo329toPx0680j_4($this$toRect.m5302getRightD9Ej5fM()), mo329toPx0680j_4($this$toRect.m5300getBottomD9Ej5fM()));
    }

    /* renamed from: toSize-XkaWNTQ */
    default long mo330toSizeXkaWNTQ(long $this$toSize_u2dXkaWNTQ) {
        if ($this$toSize_u2dXkaWNTQ != DpSize.INSTANCE.m5325getUnspecifiedMYxV2XQ()) {
            return SizeKt.Size(mo329toPx0680j_4(DpSize.m5316getWidthD9Ej5fM($this$toSize_u2dXkaWNTQ)), mo329toPx0680j_4(DpSize.m5314getHeightD9Ej5fM($this$toSize_u2dXkaWNTQ)));
        }
        return Size.INSTANCE.m2787getUnspecifiedNHjbRc();
    }

    /* renamed from: toDpSize-k-rfVVM */
    default long mo327toDpSizekrfVVM(long $this$toDpSize_u2dk_u2drfVVM) {
        if ($this$toDpSize_u2dk_u2drfVVM != Size.INSTANCE.m2787getUnspecifiedNHjbRc()) {
            return DpKt.m5240DpSizeYgX7TsA(mo325toDpu2uoSUM(Size.m2779getWidthimpl($this$toDpSize_u2dk_u2drfVVM)), mo325toDpu2uoSUM(Size.m2776getHeightimpl($this$toDpSize_u2dk_u2drfVVM)));
        }
        return DpSize.INSTANCE.m5325getUnspecifiedMYxV2XQ();
    }
}
