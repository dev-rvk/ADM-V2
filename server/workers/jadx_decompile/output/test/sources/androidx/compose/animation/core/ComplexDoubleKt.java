package androidx.compose.animation.core;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ComplexDouble.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\u001a,\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0000\u001a\u0015\u0010\t\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0080\n\u001a\u0015\u0010\u000b\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0080\n\u001a\u0015\u0010\f\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0080\n¨\u0006\r"}, d2 = {"complexQuadraticFormula", "Lkotlin/Pair;", "Landroidx/compose/animation/core/ComplexDouble;", "a", "", "b", "c", "complexSqrt", "num", "minus", "other", "plus", "times", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ComplexDoubleKt {
    public static final Pair<ComplexDouble, ComplexDouble> complexQuadraticFormula(double a, double b, double c) {
        double partialRoot = (b * b) - ((4.0d * a) * c);
        double divisor = 1.0d / (2.0d * a);
        double $this$plus$iv = -b;
        ComplexDouble other$iv = complexSqrt(partialRoot);
        other$iv._real += $this$plus$iv;
        other$iv._real *= divisor;
        other$iv._imaginary *= divisor;
        double $this$minus$iv = -b;
        ComplexDouble other$iv2 = complexSqrt(partialRoot);
        double d = -1;
        other$iv2._real *= d;
        other$iv2._imaginary *= d;
        other$iv2._real += $this$minus$iv;
        other$iv2._real *= divisor;
        other$iv2._imaginary *= divisor;
        return TuplesKt.to(other$iv, other$iv2);
    }

    public static final ComplexDouble complexSqrt(double num) {
        if (num < 0.0d) {
            return new ComplexDouble(0.0d, Math.sqrt(Math.abs(num)));
        }
        return new ComplexDouble(Math.sqrt(num), 0.0d);
    }

    public static final ComplexDouble plus(double $this$plus, ComplexDouble other) {
        Intrinsics.checkNotNullParameter(other, "other");
        other._real += $this$plus;
        return other;
    }

    public static final ComplexDouble minus(double $this$minus, ComplexDouble other) {
        Intrinsics.checkNotNullParameter(other, "other");
        double d = -1;
        other._real *= d;
        other._imaginary *= d;
        other._real += $this$minus;
        return other;
    }

    public static final ComplexDouble times(double $this$times, ComplexDouble other) {
        Intrinsics.checkNotNullParameter(other, "other");
        other._real *= $this$times;
        other._imaginary *= $this$times;
        return other;
    }
}
