package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: RowColumnImpl.kt */
@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a.\u0010\u0012\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002\u001a.\u0010\u0018\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002\u001a.\u0010\u0019\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002\u001a.\u0010\u001a\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002\u001ad\u0010\u001b\u001a\u00020\u00152\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00142\u001d\u0010\u001d\u001a\u0019\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u001e¢\u0006\u0002\b\u001f2\u001d\u0010 \u001a\u0019\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u001e¢\u0006\u0002\b\u001f2\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0015H\u0002\u001aE\u0010#\u001a\u00020\u00152\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00142\u001d\u0010\u001d\u001a\u0019\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u001e¢\u0006\u0002\b\u001f2\u0006\u0010$\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0015H\u0002\u001at\u0010%\u001a\u00020\u00152\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00142\u001d\u0010&\u001a\u0019\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u001e¢\u0006\u0002\b\u001f2\u001d\u0010'\u001a\u0019\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u001e¢\u0006\u0002\b\u001f2\u0006\u0010$\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u0017H\u0002\u001aa\u0010*\u001a\u00020+2\u0006\u0010\u0016\u001a\u00020\u00172*\u0010,\u001a&\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u0002010-2\u0006\u00102\u001a\u0002032\u0006\u0010 \u001a\u0002042\u0006\u0010\u0000\u001a\u00020\u0001H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b5\u00106\"\u001c\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001a\u0010\u0005\u001a\u00020\u0006*\u0004\u0018\u00010\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u001a\u0010\t\u001a\u00020\u0006*\u0004\u0018\u00010\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\b\"\u001a\u0010\n\u001a\u0004\u0018\u00010\u0002*\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u001a\u0010\u000e\u001a\u00020\u000f*\u0004\u0018\u00010\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00067"}, d2 = {"crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "Landroidx/compose/foundation/layout/RowColumnParentData;", "getCrossAxisAlignment", "(Landroidx/compose/foundation/layout/RowColumnParentData;)Landroidx/compose/foundation/layout/CrossAxisAlignment;", "fill", "", "getFill", "(Landroidx/compose/foundation/layout/RowColumnParentData;)Z", "isRelative", "rowColumnParentData", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getRowColumnParentData", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Landroidx/compose/foundation/layout/RowColumnParentData;", "weight", "", "getWeight", "(Landroidx/compose/foundation/layout/RowColumnParentData;)F", "MaxIntrinsicHeightMeasureBlock", "Lkotlin/Function3;", "", "", "orientation", "Landroidx/compose/foundation/layout/LayoutOrientation;", "MaxIntrinsicWidthMeasureBlock", "MinIntrinsicHeightMeasureBlock", "MinIntrinsicWidthMeasureBlock", "intrinsicCrossAxisSize", "children", "mainAxisSize", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "crossAxisSize", "mainAxisAvailable", "mainAxisSpacing", "intrinsicMainAxisSize", "crossAxisAvailable", "intrinsicSize", "intrinsicMainSize", "intrinsicCrossSize", "layoutOrientation", "intrinsicOrientation", "rowColumnMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "arrangement", "Lkotlin/Function5;", "", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/Density;", "", "arrangementSpacing", "Landroidx/compose/ui/unit/Dp;", "Landroidx/compose/foundation/layout/SizeMode;", "rowColumnMeasurePolicy-TDGSqEk", "(Landroidx/compose/foundation/layout/LayoutOrientation;Lkotlin/jvm/functions/Function5;FLandroidx/compose/foundation/layout/SizeMode;Landroidx/compose/foundation/layout/CrossAxisAlignment;)Landroidx/compose/ui/layout/MeasurePolicy;", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class RowColumnImplKt {
    public static final /* synthetic */ int access$intrinsicSize(List children, Function2 intrinsicMainSize, Function2 intrinsicCrossSize, int crossAxisAvailable, int mainAxisSpacing, LayoutOrientation layoutOrientation, LayoutOrientation intrinsicOrientation) {
        return intrinsicSize(children, intrinsicMainSize, intrinsicCrossSize, crossAxisAvailable, mainAxisSpacing, layoutOrientation, intrinsicOrientation);
    }

    /* renamed from: rowColumnMeasurePolicy-TDGSqEk */
    public static final MeasurePolicy m509rowColumnMeasurePolicyTDGSqEk(final LayoutOrientation orientation, final Function5<? super Integer, ? super int[], ? super LayoutDirection, ? super Density, ? super int[], Unit> arrangement, final float arrangementSpacing, final SizeMode crossAxisSize, final CrossAxisAlignment crossAxisAlignment) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(arrangement, "arrangement");
        Intrinsics.checkNotNullParameter(crossAxisSize, "crossAxisSize");
        Intrinsics.checkNotNullParameter(crossAxisAlignment, "crossAxisAlignment");
        return new MeasurePolicy() { // from class: androidx.compose.foundation.layout.RowColumnImplKt$rowColumnMeasurePolicy$1
            @Override // androidx.compose.ui.layout.MeasurePolicy
            /* renamed from: measure-3p2s80s */
            public MeasureResult mo15measure3p2s80s(final MeasureScope measure, List<? extends Measurable> measurables, long constraints) {
                int layoutWidth;
                int layoutHeight;
                Intrinsics.checkNotNullParameter(measure, "$this$measure");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                Placeable[] placeables = new Placeable[measurables.size()];
                final RowColumnMeasurementHelper rowColumnMeasureHelper = new RowColumnMeasurementHelper(LayoutOrientation.this, arrangement, arrangementSpacing, crossAxisSize, crossAxisAlignment, measurables, placeables, null);
                final RowColumnMeasureHelperResult measureResult = rowColumnMeasureHelper.m511measureWithoutPlacing_EkL_Y(measure, constraints, 0, measurables.size());
                if (LayoutOrientation.this == LayoutOrientation.Horizontal) {
                    int layoutWidth2 = measureResult.getMainAxisSize();
                    int layoutHeight2 = measureResult.getCrossAxisSize();
                    layoutWidth = layoutWidth2;
                    layoutHeight = layoutHeight2;
                } else {
                    int layoutWidth3 = measureResult.getCrossAxisSize();
                    int layoutHeight3 = measureResult.getMainAxisSize();
                    layoutWidth = layoutWidth3;
                    layoutHeight = layoutHeight3;
                }
                return MeasureScope.layout$default(measure, layoutWidth, layoutHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.RowColumnImplKt$rowColumnMeasurePolicy$1$measure$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                        invoke2(placementScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Placeable.PlacementScope layout) {
                        Intrinsics.checkNotNullParameter(layout, "$this$layout");
                        RowColumnMeasurementHelper.this.placeHelper(layout, measureResult, 0, measure.getLayoutDirection());
                    }
                }, 4, null);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
                Function3 MinIntrinsicWidthMeasureBlock;
                Intrinsics.checkNotNullParameter($this$minIntrinsicWidth, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                MinIntrinsicWidthMeasureBlock = RowColumnImplKt.MinIntrinsicWidthMeasureBlock(LayoutOrientation.this);
                return ((Number) MinIntrinsicWidthMeasureBlock.invoke(measurables, Integer.valueOf(height), Integer.valueOf($this$minIntrinsicWidth.mo323roundToPx0680j_4(arrangementSpacing)))).intValue();
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
                Function3 MinIntrinsicHeightMeasureBlock;
                Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                MinIntrinsicHeightMeasureBlock = RowColumnImplKt.MinIntrinsicHeightMeasureBlock(LayoutOrientation.this);
                return ((Number) MinIntrinsicHeightMeasureBlock.invoke(measurables, Integer.valueOf(width), Integer.valueOf($this$minIntrinsicHeight.mo323roundToPx0680j_4(arrangementSpacing)))).intValue();
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
                Function3 MaxIntrinsicWidthMeasureBlock;
                Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                MaxIntrinsicWidthMeasureBlock = RowColumnImplKt.MaxIntrinsicWidthMeasureBlock(LayoutOrientation.this);
                return ((Number) MaxIntrinsicWidthMeasureBlock.invoke(measurables, Integer.valueOf(height), Integer.valueOf($this$maxIntrinsicWidth.mo323roundToPx0680j_4(arrangementSpacing)))).intValue();
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
                Function3 MaxIntrinsicHeightMeasureBlock;
                Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                MaxIntrinsicHeightMeasureBlock = RowColumnImplKt.MaxIntrinsicHeightMeasureBlock(LayoutOrientation.this);
                return ((Number) MaxIntrinsicHeightMeasureBlock.invoke(measurables, Integer.valueOf(width), Integer.valueOf($this$maxIntrinsicHeight.mo323roundToPx0680j_4(arrangementSpacing)))).intValue();
            }
        };
    }

    public static final RowColumnParentData getRowColumnParentData(IntrinsicMeasurable $this$rowColumnParentData) {
        Intrinsics.checkNotNullParameter($this$rowColumnParentData, "<this>");
        Object parentData = $this$rowColumnParentData.getParentData();
        if (parentData instanceof RowColumnParentData) {
            return (RowColumnParentData) parentData;
        }
        return null;
    }

    public static final float getWeight(RowColumnParentData $this$weight) {
        if ($this$weight != null) {
            return $this$weight.getWeight();
        }
        return 0.0f;
    }

    public static final boolean getFill(RowColumnParentData $this$fill) {
        if ($this$fill != null) {
            return $this$fill.getFill();
        }
        return true;
    }

    public static final CrossAxisAlignment getCrossAxisAlignment(RowColumnParentData $this$crossAxisAlignment) {
        if ($this$crossAxisAlignment != null) {
            return $this$crossAxisAlignment.getCrossAxisAlignment();
        }
        return null;
    }

    public static final boolean isRelative(RowColumnParentData $this$isRelative) {
        CrossAxisAlignment crossAxisAlignment = getCrossAxisAlignment($this$isRelative);
        if (crossAxisAlignment != null) {
            return crossAxisAlignment.isRelative$foundation_layout_release();
        }
        return false;
    }

    public static final Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> MinIntrinsicWidthMeasureBlock(LayoutOrientation orientation) {
        if (orientation == LayoutOrientation.Horizontal) {
            return IntrinsicMeasureBlocks.INSTANCE.getHorizontalMinWidth();
        }
        return IntrinsicMeasureBlocks.INSTANCE.getVerticalMinWidth();
    }

    public static final Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> MinIntrinsicHeightMeasureBlock(LayoutOrientation orientation) {
        if (orientation == LayoutOrientation.Horizontal) {
            return IntrinsicMeasureBlocks.INSTANCE.getHorizontalMinHeight();
        }
        return IntrinsicMeasureBlocks.INSTANCE.getVerticalMinHeight();
    }

    public static final Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> MaxIntrinsicWidthMeasureBlock(LayoutOrientation orientation) {
        if (orientation == LayoutOrientation.Horizontal) {
            return IntrinsicMeasureBlocks.INSTANCE.getHorizontalMaxWidth();
        }
        return IntrinsicMeasureBlocks.INSTANCE.getVerticalMaxWidth();
    }

    public static final Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> MaxIntrinsicHeightMeasureBlock(LayoutOrientation orientation) {
        if (orientation == LayoutOrientation.Horizontal) {
            return IntrinsicMeasureBlocks.INSTANCE.getHorizontalMaxHeight();
        }
        return IntrinsicMeasureBlocks.INSTANCE.getVerticalMaxHeight();
    }

    public static final int intrinsicSize(List<? extends IntrinsicMeasurable> list, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function22, int crossAxisAvailable, int mainAxisSpacing, LayoutOrientation layoutOrientation, LayoutOrientation intrinsicOrientation) {
        if (layoutOrientation == intrinsicOrientation) {
            return intrinsicMainAxisSize(list, function2, crossAxisAvailable, mainAxisSpacing);
        }
        return intrinsicCrossAxisSize(list, function22, function2, crossAxisAvailable, mainAxisSpacing);
    }

    private static final int intrinsicMainAxisSize(List<? extends IntrinsicMeasurable> list, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2, int crossAxisAvailable, int mainAxisSpacing) {
        int weightUnitSpace = 0;
        int fixedSpace = 0;
        float totalWeight = 0.0f;
        int index$iv = 0;
        int size = list.size();
        while (true) {
            if (index$iv >= size) {
                return MathKt.roundToInt(weightUnitSpace * totalWeight) + fixedSpace + ((list.size() - 1) * mainAxisSpacing);
            }
            Object item$iv = list.get(index$iv);
            IntrinsicMeasurable child = (IntrinsicMeasurable) item$iv;
            float weight = getWeight(getRowColumnParentData(child));
            int size2 = function2.invoke(child, Integer.valueOf(crossAxisAvailable)).intValue();
            if (weight == 0.0f) {
                fixedSpace += size2;
            } else if (weight > 0.0f) {
                totalWeight += weight;
                weightUnitSpace = Math.max(weightUnitSpace, MathKt.roundToInt(size2 / weight));
            }
            index$iv++;
        }
    }

    private static final int intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> list, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function22, int mainAxisAvailable, int mainAxisSpacing) {
        int i;
        float f;
        int i2;
        int fixedSpace = Math.min((list.size() - 1) * mainAxisSpacing, mainAxisAvailable);
        int crossAxisMax = 0;
        float totalWeight = 0.0f;
        int index$iv = 0;
        int size = list.size();
        while (true) {
            f = 0.0f;
            if (index$iv >= size) {
                break;
            }
            Object item$iv = list.get(index$iv);
            IntrinsicMeasurable child = (IntrinsicMeasurable) item$iv;
            float weight = getWeight(getRowColumnParentData(child));
            if ((weight == 0.0f ? 1 : 0) != 0) {
                int mainAxisSpace = Math.min(function2.invoke(child, Integer.MAX_VALUE).intValue(), mainAxisAvailable - fixedSpace);
                fixedSpace += mainAxisSpace;
                crossAxisMax = Math.max(crossAxisMax, function22.invoke(child, Integer.valueOf(mainAxisSpace)).intValue());
            } else if (weight > 0.0f) {
                totalWeight += weight;
            }
            index$iv++;
        }
        if (!(totalWeight == 0.0f)) {
            if (mainAxisAvailable == Integer.MAX_VALUE) {
                i = Integer.MAX_VALUE;
            } else {
                i = MathKt.roundToInt(Math.max(mainAxisAvailable - fixedSpace, 0) / totalWeight);
            }
        }
        int weightUnitSpace = i;
        int index$iv2 = 0;
        int size2 = list.size();
        while (index$iv2 < size2) {
            Object item$iv2 = list.get(index$iv2);
            IntrinsicMeasurable child2 = (IntrinsicMeasurable) item$iv2;
            float weight2 = getWeight(getRowColumnParentData(child2));
            if (weight2 > f) {
                if (weightUnitSpace != Integer.MAX_VALUE) {
                    i2 = MathKt.roundToInt(weightUnitSpace * weight2);
                } else {
                    i2 = Integer.MAX_VALUE;
                }
                crossAxisMax = Math.max(crossAxisMax, function22.invoke(child2, Integer.valueOf(i2)).intValue());
            }
            index$iv2++;
            f = 0.0f;
        }
        return crossAxisMax;
    }
}
