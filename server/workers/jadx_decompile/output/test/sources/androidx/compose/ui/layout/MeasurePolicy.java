package androidx.compose.ui.layout;

import androidx.compose.ui.unit.ConstraintsKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MeasurePolicy.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bç\u0080\u0001\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0016J\"\u0010\t\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\u0003H\u0016J/\u0010\u000b\u001a\u00020\f*\u00020\r2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u0006\u0010\u000f\u001a\u00020\u0010H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\"\u0010\u0013\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0016J\"\u0010\u0014\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\u0003H\u0016ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/layout/MeasurePolicy;", "", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public interface MeasurePolicy {
    /* renamed from: measure-3p2s80s */
    MeasureResult mo15measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j);

    /* compiled from: MeasurePolicy.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static int minIntrinsicWidth(MeasurePolicy $this, IntrinsicMeasureScope receiver, List<? extends IntrinsicMeasurable> measurables, int height) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            return MeasurePolicy.super.minIntrinsicWidth(receiver, measurables, height);
        }

        @Deprecated
        public static int minIntrinsicHeight(MeasurePolicy $this, IntrinsicMeasureScope receiver, List<? extends IntrinsicMeasurable> measurables, int width) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            return MeasurePolicy.super.minIntrinsicHeight(receiver, measurables, width);
        }

        @Deprecated
        public static int maxIntrinsicWidth(MeasurePolicy $this, IntrinsicMeasureScope receiver, List<? extends IntrinsicMeasurable> measurables, int height) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            return MeasurePolicy.super.maxIntrinsicWidth(receiver, measurables, height);
        }

        @Deprecated
        public static int maxIntrinsicHeight(MeasurePolicy $this, IntrinsicMeasureScope receiver, List<? extends IntrinsicMeasurable> measurables, int width) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            return MeasurePolicy.super.maxIntrinsicHeight(receiver, measurables, width);
        }
    }

    default int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        List $this$fastMap$iv = measurables;
        List target$iv = new ArrayList($this$fastMap$iv.size());
        int index$iv$iv = 0;
        int size = $this$fastMap$iv.size();
        while (index$iv$iv < size) {
            Object item$iv$iv = $this$fastMap$iv.get(index$iv$iv);
            IntrinsicMeasurable it = (IntrinsicMeasurable) item$iv$iv;
            target$iv.add(new DefaultIntrinsicMeasurable(it, IntrinsicMinMax.Min, IntrinsicWidthHeight.Width));
            index$iv$iv++;
            $this$fastMap$iv = $this$fastMap$iv;
        }
        List mapped = target$iv;
        long constraints = ConstraintsKt.Constraints$default(0, 0, 0, height, 7, null);
        IntrinsicsMeasureScope layoutReceiver = new IntrinsicsMeasureScope($this$minIntrinsicWidth, $this$minIntrinsicWidth.getLayoutDirection());
        MeasureResult layoutResult = mo15measure3p2s80s(layoutReceiver, mapped, constraints);
        return layoutResult.getWidth();
    }

    default int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        List $this$fastMap$iv = measurables;
        List target$iv = new ArrayList($this$fastMap$iv.size());
        int index$iv$iv = 0;
        int size = $this$fastMap$iv.size();
        while (index$iv$iv < size) {
            Object item$iv$iv = $this$fastMap$iv.get(index$iv$iv);
            IntrinsicMeasurable it = (IntrinsicMeasurable) item$iv$iv;
            target$iv.add(new DefaultIntrinsicMeasurable(it, IntrinsicMinMax.Min, IntrinsicWidthHeight.Height));
            index$iv$iv++;
            $this$fastMap$iv = $this$fastMap$iv;
        }
        List mapped = target$iv;
        long constraints = ConstraintsKt.Constraints$default(0, width, 0, 0, 13, null);
        IntrinsicsMeasureScope layoutReceiver = new IntrinsicsMeasureScope($this$minIntrinsicHeight, $this$minIntrinsicHeight.getLayoutDirection());
        MeasureResult layoutResult = mo15measure3p2s80s(layoutReceiver, mapped, constraints);
        return layoutResult.getHeight();
    }

    default int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        List $this$fastMap$iv = measurables;
        List target$iv = new ArrayList($this$fastMap$iv.size());
        int index$iv$iv = 0;
        int size = $this$fastMap$iv.size();
        while (index$iv$iv < size) {
            Object item$iv$iv = $this$fastMap$iv.get(index$iv$iv);
            IntrinsicMeasurable it = (IntrinsicMeasurable) item$iv$iv;
            target$iv.add(new DefaultIntrinsicMeasurable(it, IntrinsicMinMax.Max, IntrinsicWidthHeight.Width));
            index$iv$iv++;
            $this$fastMap$iv = $this$fastMap$iv;
        }
        List mapped = target$iv;
        long constraints = ConstraintsKt.Constraints$default(0, 0, 0, height, 7, null);
        IntrinsicsMeasureScope layoutReceiver = new IntrinsicsMeasureScope($this$maxIntrinsicWidth, $this$maxIntrinsicWidth.getLayoutDirection());
        MeasureResult layoutResult = mo15measure3p2s80s(layoutReceiver, mapped, constraints);
        return layoutResult.getWidth();
    }

    default int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        List $this$fastMap$iv = measurables;
        List target$iv = new ArrayList($this$fastMap$iv.size());
        int index$iv$iv = 0;
        int size = $this$fastMap$iv.size();
        while (index$iv$iv < size) {
            Object item$iv$iv = $this$fastMap$iv.get(index$iv$iv);
            IntrinsicMeasurable it = (IntrinsicMeasurable) item$iv$iv;
            target$iv.add(new DefaultIntrinsicMeasurable(it, IntrinsicMinMax.Max, IntrinsicWidthHeight.Height));
            index$iv$iv++;
            $this$fastMap$iv = $this$fastMap$iv;
        }
        List mapped = target$iv;
        long constraints = ConstraintsKt.Constraints$default(0, width, 0, 0, 13, null);
        IntrinsicsMeasureScope layoutReceiver = new IntrinsicsMeasureScope($this$maxIntrinsicHeight, $this$maxIntrinsicHeight.getLayoutDirection());
        MeasureResult layoutResult = mo15measure3p2s80s(layoutReceiver, mapped, constraints);
        return layoutResult.getHeight();
    }
}
