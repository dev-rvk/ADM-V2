package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: RowColumnMeasurementHelper.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001Br\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012*\u0010\u0004\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015ø\u0001\u0000¢\u0006\u0002\u0010\u0017J2\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00162\b\u0010-\u001a\u0004\u0018\u00010)2\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\u0006H\u0002J(\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00104\u001a\u000205H\u0002J3\u00106\u001a\u0002072\u0006\u00104\u001a\u0002052\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b<\u0010=J&\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u0002072\u0006\u0010B\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\bJ\n\u0010\r\u001a\u00020\u0006*\u00020\u0016J\n\u0010C\u001a\u00020\u0006*\u00020\u0016R5\u0010\u0004\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u000b\u001a\u00020\fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001b\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&R\u0018\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010*\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006D"}, d2 = {"Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;", "", "orientation", "Landroidx/compose/foundation/layout/LayoutOrientation;", "arrangement", "Lkotlin/Function5;", "", "", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/Density;", "", "arrangementSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSize", "Landroidx/compose/foundation/layout/SizeMode;", "crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "(Landroidx/compose/foundation/layout/LayoutOrientation;Lkotlin/jvm/functions/Function5;FLandroidx/compose/foundation/layout/SizeMode;Landroidx/compose/foundation/layout/CrossAxisAlignment;Ljava/util/List;[Landroidx/compose/ui/layout/Placeable;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getArrangement", "()Lkotlin/jvm/functions/Function5;", "getArrangementSpacing-D9Ej5fM", "()F", "F", "getCrossAxisAlignment", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "getCrossAxisSize", "()Landroidx/compose/foundation/layout/SizeMode;", "getMeasurables", "()Ljava/util/List;", "getOrientation", "()Landroidx/compose/foundation/layout/LayoutOrientation;", "getPlaceables", "()[Landroidx/compose/ui/layout/Placeable;", "[Landroidx/compose/ui/layout/Placeable;", "rowColumnParentData", "Landroidx/compose/foundation/layout/RowColumnParentData;", "[Landroidx/compose/foundation/layout/RowColumnParentData;", "getCrossAxisPosition", "placeable", "parentData", "crossAxisLayoutSize", "layoutDirection", "beforeCrossAxisAlignmentLine", "mainAxisPositions", "mainAxisLayoutSize", "childrenMainAxisSize", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "measureWithoutPlacing", "Landroidx/compose/foundation/layout/RowColumnMeasureHelperResult;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "startIndex", "endIndex", "measureWithoutPlacing-_EkL_-Y", "(Landroidx/compose/ui/layout/MeasureScope;JII)Landroidx/compose/foundation/layout/RowColumnMeasureHelperResult;", "placeHelper", "placeableScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "measureResult", "crossAxisOffset", "mainAxisSize", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class RowColumnMeasurementHelper {
    private final Function5<Integer, int[], LayoutDirection, Density, int[], Unit> arrangement;
    private final float arrangementSpacing;
    private final CrossAxisAlignment crossAxisAlignment;
    private final SizeMode crossAxisSize;
    private final List<Measurable> measurables;
    private final LayoutOrientation orientation;
    private final Placeable[] placeables;
    private final RowColumnParentData[] rowColumnParentData;

    public /* synthetic */ RowColumnMeasurementHelper(LayoutOrientation layoutOrientation, Function5 function5, float f, SizeMode sizeMode, CrossAxisAlignment crossAxisAlignment, List list, Placeable[] placeableArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(layoutOrientation, function5, f, sizeMode, crossAxisAlignment, list, placeableArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private RowColumnMeasurementHelper(LayoutOrientation orientation, Function5<? super Integer, ? super int[], ? super LayoutDirection, ? super Density, ? super int[], Unit> arrangement, float arrangementSpacing, SizeMode crossAxisSize, CrossAxisAlignment crossAxisAlignment, List<? extends Measurable> measurables, Placeable[] placeables) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(arrangement, "arrangement");
        Intrinsics.checkNotNullParameter(crossAxisSize, "crossAxisSize");
        Intrinsics.checkNotNullParameter(crossAxisAlignment, "crossAxisAlignment");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        Intrinsics.checkNotNullParameter(placeables, "placeables");
        this.orientation = orientation;
        this.arrangement = arrangement;
        this.arrangementSpacing = arrangementSpacing;
        this.crossAxisSize = crossAxisSize;
        this.crossAxisAlignment = crossAxisAlignment;
        this.measurables = measurables;
        this.placeables = placeables;
        int size = this.measurables.size();
        RowColumnParentData[] rowColumnParentDataArr = new RowColumnParentData[size];
        for (int i = 0; i < size; i++) {
            rowColumnParentDataArr[i] = RowColumnImplKt.getRowColumnParentData(this.measurables.get(i));
        }
        this.rowColumnParentData = rowColumnParentDataArr;
    }

    public final LayoutOrientation getOrientation() {
        return this.orientation;
    }

    public final Function5<Integer, int[], LayoutDirection, Density, int[], Unit> getArrangement() {
        return this.arrangement;
    }

    /* renamed from: getArrangementSpacing-D9Ej5fM, reason: not valid java name and from getter */
    public final float getArrangementSpacing() {
        return this.arrangementSpacing;
    }

    public final SizeMode getCrossAxisSize() {
        return this.crossAxisSize;
    }

    public final CrossAxisAlignment getCrossAxisAlignment() {
        return this.crossAxisAlignment;
    }

    public final List<Measurable> getMeasurables() {
        return this.measurables;
    }

    public final Placeable[] getPlaceables() {
        return this.placeables;
    }

    public final int mainAxisSize(Placeable $this$mainAxisSize) {
        Intrinsics.checkNotNullParameter($this$mainAxisSize, "<this>");
        return this.orientation == LayoutOrientation.Horizontal ? $this$mainAxisSize.getWidth() : $this$mainAxisSize.getHeight();
    }

    public final int crossAxisSize(Placeable $this$crossAxisSize) {
        Intrinsics.checkNotNullParameter($this$crossAxisSize, "<this>");
        return this.orientation == LayoutOrientation.Horizontal ? $this$crossAxisSize.getHeight() : $this$crossAxisSize.getWidth();
    }

    /* renamed from: measureWithoutPlacing-_EkL_-Y, reason: not valid java name */
    public final RowColumnMeasureHelperResult m511measureWithoutPlacing_EkL_Y(MeasureScope measureScope, long constraints, int startIndex, int endIndex) {
        boolean z;
        int targetSpace;
        int weightedSpace;
        int fixedSpace;
        int crossAxisSpace;
        boolean anyAlignBy;
        int targetSpace2;
        boolean z2;
        int remainingToTarget;
        float weightUnitSpace;
        int i;
        int beforeCrossAxisAlignmentLine;
        int afterCrossAxisAlignmentLine;
        int crossAxisLayoutSize;
        int crossAxisSize;
        int mainAxisMax;
        boolean z3;
        long m454copyyUG9Ft0;
        int i2 = endIndex;
        Intrinsics.checkNotNullParameter(measureScope, "measureScope");
        long constraints2 = OrientationIndependentConstraints.m453constructorimpl(constraints, this.orientation);
        int i3 = measureScope.mo323roundToPx0680j_4(this.arrangementSpacing);
        int fixedSpace2 = 0;
        int crossAxisSpace2 = 0;
        boolean anyAlignBy2 = false;
        int subSize = i2 - startIndex;
        float totalWeight = 0.0f;
        int weightChildrenCount = 0;
        int spaceAfterLastNoWeight = 0;
        int i4 = startIndex;
        while (true) {
            z = false;
            if (i4 >= i2) {
                break;
            }
            Measurable child = this.measurables.get(i4);
            RowColumnParentData parentData = this.rowColumnParentData[i4];
            float weight = RowColumnImplKt.getWeight(parentData);
            if (weight > 0.0f) {
                totalWeight += weight;
                weightChildrenCount++;
            } else {
                int m5174getMaxWidthimpl = Constraints.m5174getMaxWidthimpl(constraints2);
                Placeable placeable = this.placeables[i4];
                if (placeable == null) {
                    int weightChildrenCount2 = m5174getMaxWidthimpl != Integer.MAX_VALUE ? m5174getMaxWidthimpl - fixedSpace2 : Integer.MAX_VALUE;
                    mainAxisMax = m5174getMaxWidthimpl;
                    z3 = false;
                    m454copyyUG9Ft0 = OrientationIndependentConstraints.m454copyyUG9Ft0(constraints2, (r12 & 1) != 0 ? Constraints.m5176getMinWidthimpl(constraints2) : 0, (r12 & 2) != 0 ? Constraints.m5174getMaxWidthimpl(constraints2) : weightChildrenCount2, (r12 & 4) != 0 ? Constraints.m5175getMinHeightimpl(constraints2) : 0, (r12 & 8) != 0 ? Constraints.m5173getMaxHeightimpl(constraints2) : 0);
                    placeable = child.mo4186measureBRTryo0(OrientationIndependentConstraints.m466toBoxConstraintsOenEA2s(m454copyyUG9Ft0, this.orientation));
                } else {
                    mainAxisMax = m5174getMaxWidthimpl;
                    z3 = false;
                }
                Placeable placeable2 = placeable;
                int spaceAfterLastNoWeight2 = Math.min(i3, (mainAxisMax - fixedSpace2) - mainAxisSize(placeable2));
                fixedSpace2 += mainAxisSize(placeable2) + spaceAfterLastNoWeight2;
                crossAxisSpace2 = Math.max(crossAxisSpace2, crossAxisSize(placeable2));
                anyAlignBy2 = (anyAlignBy2 || RowColumnImplKt.isRelative(parentData)) ? true : z3;
                this.placeables[i4] = placeable2;
                spaceAfterLastNoWeight = spaceAfterLastNoWeight2;
            }
            i4++;
        }
        int weightedSpace2 = 0;
        if (weightChildrenCount == 0) {
            weightedSpace = 0;
            fixedSpace = fixedSpace2 - spaceAfterLastNoWeight;
            crossAxisSpace = crossAxisSpace2;
            anyAlignBy = anyAlignBy2;
        } else {
            if (totalWeight > 0.0f && Constraints.m5174getMaxWidthimpl(constraints2) != Integer.MAX_VALUE) {
                targetSpace = Constraints.m5174getMaxWidthimpl(constraints2);
            } else {
                targetSpace = Constraints.m5176getMinWidthimpl(constraints2);
            }
            int remainingToTarget2 = (targetSpace - fixedSpace2) - ((weightChildrenCount - 1) * i3);
            float weightUnitSpace2 = totalWeight > 0.0f ? remainingToTarget2 / totalWeight : 0.0f;
            Iterator<Integer> it = RangesKt.until(startIndex, endIndex).iterator();
            int i5 = 0;
            while (it.hasNext()) {
                i5 += MathKt.roundToInt(RowColumnImplKt.getWeight(this.rowColumnParentData[((IntIterator) it).nextInt()]) * weightUnitSpace2);
            }
            int childMainAxisSize = remainingToTarget2 - i5;
            int i6 = startIndex;
            while (i6 < i2) {
                if (this.placeables[i6] != null) {
                    targetSpace2 = targetSpace;
                    z2 = z;
                    remainingToTarget = remainingToTarget2;
                    weightUnitSpace = weightUnitSpace2;
                } else {
                    Measurable child2 = this.measurables.get(i6);
                    RowColumnParentData parentData2 = this.rowColumnParentData[i6];
                    float weight2 = RowColumnImplKt.getWeight(parentData2);
                    z2 = false;
                    if (!(weight2 > 0.0f)) {
                        throw new IllegalStateException("All weights <= 0 should have placeables".toString());
                    }
                    int remainderUnit = MathKt.getSign(childMainAxisSize);
                    int remainder = childMainAxisSize - remainderUnit;
                    int remainder2 = MathKt.roundToInt(weightUnitSpace2 * weight2) + remainderUnit;
                    targetSpace2 = targetSpace;
                    int childMainAxisSize2 = Math.max(0, remainder2);
                    if (RowColumnImplKt.getFill(parentData2) && childMainAxisSize2 != Integer.MAX_VALUE) {
                        i = childMainAxisSize2;
                    } else {
                        i = 0;
                    }
                    remainingToTarget = remainingToTarget2;
                    weightUnitSpace = weightUnitSpace2;
                    Placeable placeable3 = child2.mo4186measureBRTryo0(OrientationIndependentConstraints.m466toBoxConstraintsOenEA2s(OrientationIndependentConstraints.m451constructorimpl(i, childMainAxisSize2, 0, Constraints.m5173getMaxHeightimpl(constraints2)), this.orientation));
                    weightedSpace2 += mainAxisSize(placeable3);
                    crossAxisSpace2 = Math.max(crossAxisSpace2, crossAxisSize(placeable3));
                    anyAlignBy2 = anyAlignBy2 || RowColumnImplKt.isRelative(parentData2);
                    this.placeables[i6] = placeable3;
                    childMainAxisSize = remainder;
                }
                i6++;
                i2 = endIndex;
                z = z2;
                targetSpace = targetSpace2;
                weightUnitSpace2 = weightUnitSpace;
                remainingToTarget2 = remainingToTarget;
            }
            weightedSpace = RangesKt.coerceAtMost(((weightChildrenCount - 1) * i3) + weightedSpace2, Constraints.m5174getMaxWidthimpl(constraints2) - fixedSpace2);
            fixedSpace = fixedSpace2;
            crossAxisSpace = crossAxisSpace2;
            anyAlignBy = anyAlignBy2;
        }
        int beforeCrossAxisAlignmentLine2 = 0;
        int afterCrossAxisAlignmentLine2 = 0;
        if (!anyAlignBy) {
            beforeCrossAxisAlignmentLine = 0;
            afterCrossAxisAlignmentLine = 0;
        } else {
            for (int i7 = startIndex; i7 < endIndex; i7++) {
                Placeable placeable4 = this.placeables[i7];
                Intrinsics.checkNotNull(placeable4);
                CrossAxisAlignment crossAxisAlignment = RowColumnImplKt.getCrossAxisAlignment(this.rowColumnParentData[i7]);
                Integer alignmentLinePosition = crossAxisAlignment != null ? crossAxisAlignment.calculateAlignmentLinePosition$foundation_layout_release(placeable4) : null;
                if (alignmentLinePosition != null) {
                    int it2 = alignmentLinePosition.intValue();
                    if (it2 == Integer.MIN_VALUE) {
                        it2 = 0;
                    }
                    int beforeCrossAxisAlignmentLine3 = Math.max(beforeCrossAxisAlignmentLine2, it2);
                    int crossAxisSize2 = crossAxisSize(placeable4);
                    int it3 = alignmentLinePosition.intValue();
                    if (it3 != Integer.MIN_VALUE) {
                        crossAxisSize = it3;
                    } else {
                        crossAxisSize = crossAxisSize(placeable4);
                    }
                    afterCrossAxisAlignmentLine2 = Math.max(afterCrossAxisAlignmentLine2, crossAxisSize2 - crossAxisSize);
                    beforeCrossAxisAlignmentLine2 = beforeCrossAxisAlignmentLine3;
                }
            }
            beforeCrossAxisAlignmentLine = beforeCrossAxisAlignmentLine2;
            afterCrossAxisAlignmentLine = afterCrossAxisAlignmentLine2;
        }
        int beforeCrossAxisAlignmentLine4 = fixedSpace + weightedSpace;
        int mainAxisLayoutSize = Math.max(beforeCrossAxisAlignmentLine4, Constraints.m5176getMinWidthimpl(constraints2));
        if (Constraints.m5173getMaxHeightimpl(constraints2) == Integer.MAX_VALUE || this.crossAxisSize != SizeMode.Expand) {
            crossAxisLayoutSize = Math.max(crossAxisSpace, Math.max(Constraints.m5175getMinHeightimpl(constraints2), beforeCrossAxisAlignmentLine + afterCrossAxisAlignmentLine));
        } else {
            crossAxisLayoutSize = Constraints.m5173getMaxHeightimpl(constraints2);
        }
        int[] mainAxisPositions = new int[subSize];
        for (int i8 = 0; i8 < subSize; i8++) {
            mainAxisPositions[i8] = 0;
        }
        int i9 = 0;
        int[] childrenMainAxisSize = new int[subSize];
        while (i9 < subSize) {
            int subSize2 = subSize;
            Placeable placeable5 = this.placeables[i9 + startIndex];
            Intrinsics.checkNotNull(placeable5);
            childrenMainAxisSize[i9] = mainAxisSize(placeable5);
            i9++;
            subSize = subSize2;
        }
        return new RowColumnMeasureHelperResult(crossAxisLayoutSize, mainAxisLayoutSize, startIndex, endIndex, beforeCrossAxisAlignmentLine, mainAxisPositions(mainAxisLayoutSize, childrenMainAxisSize, mainAxisPositions, measureScope));
    }

    private final int[] mainAxisPositions(int mainAxisLayoutSize, int[] childrenMainAxisSize, int[] mainAxisPositions, MeasureScope measureScope) {
        this.arrangement.invoke(Integer.valueOf(mainAxisLayoutSize), childrenMainAxisSize, measureScope.getLayoutDirection(), measureScope, mainAxisPositions);
        return mainAxisPositions;
    }

    private final int getCrossAxisPosition(Placeable placeable, RowColumnParentData parentData, int crossAxisLayoutSize, LayoutDirection layoutDirection, int beforeCrossAxisAlignmentLine) {
        CrossAxisAlignment childCrossAlignment;
        LayoutDirection layoutDirection2;
        if (parentData == null || (childCrossAlignment = parentData.getCrossAxisAlignment()) == null) {
            childCrossAlignment = this.crossAxisAlignment;
        }
        int crossAxisSize = crossAxisLayoutSize - crossAxisSize(placeable);
        if (this.orientation == LayoutOrientation.Horizontal) {
            layoutDirection2 = LayoutDirection.Ltr;
        } else {
            layoutDirection2 = layoutDirection;
        }
        return childCrossAlignment.align$foundation_layout_release(crossAxisSize, layoutDirection2, placeable, beforeCrossAxisAlignmentLine);
    }

    public final void placeHelper(Placeable.PlacementScope placeableScope, RowColumnMeasureHelperResult measureResult, int crossAxisOffset, LayoutDirection layoutDirection) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(placeableScope, "placeableScope");
        Intrinsics.checkNotNullParameter(measureResult, "measureResult");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        int i3 = measureResult.getStartIndex();
        int endIndex = measureResult.getEndIndex();
        int i4 = i3;
        while (i4 < endIndex) {
            Placeable placeable = this.placeables[i4];
            Intrinsics.checkNotNull(placeable);
            int[] mainAxisPositions = measureResult.getMainAxisPositions();
            Object parentData = this.measurables.get(i4).getParentData();
            int crossAxisPosition = getCrossAxisPosition(placeable, parentData instanceof RowColumnParentData ? (RowColumnParentData) parentData : null, measureResult.getCrossAxisSize(), layoutDirection, measureResult.getBeforeCrossAxisAlignmentLine()) + crossAxisOffset;
            if (this.orientation == LayoutOrientation.Horizontal) {
                i = i4;
                i2 = endIndex;
                Placeable.PlacementScope.place$default(placeableScope, placeable, mainAxisPositions[i4 - measureResult.getStartIndex()], crossAxisPosition, 0.0f, 4, null);
            } else {
                i = i4;
                i2 = endIndex;
                Placeable.PlacementScope.place$default(placeableScope, placeable, crossAxisPosition, mainAxisPositions[i - measureResult.getStartIndex()], 0.0f, 4, null);
            }
            i4 = i + 1;
            endIndex = i2;
        }
    }
}
