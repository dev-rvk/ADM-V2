package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextField.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ8\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\n2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0010H\u0002J<\u0010\u0011\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\n2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0010H\u0002J\"\u0010\u0014\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\"\u0010\u0015\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\nH\u0016J/\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00190\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\"\u0010\u001e\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\"\u0010\u001f\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, d2 = {"Landroidx/compose/material3/TextFieldMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "singleLine", "", "animationProgress", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(ZFLandroidx/compose/foundation/layout/PaddingValues;)V", "intrinsicWidth", "", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "intrinsicMeasurer", "Lkotlin/Function2;", "intrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "width", "maxIntrinsicHeight", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextFieldMeasurePolicy implements MeasurePolicy {
    private final float animationProgress;
    private final PaddingValues paddingValues;
    private final boolean singleLine;

    public TextFieldMeasurePolicy(boolean singleLine, float animationProgress, PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        this.singleLine = singleLine;
        this.animationProgress = animationProgress;
        this.paddingValues = paddingValues;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo15measure3p2s80s(final MeasureScope measure, List<? extends Measurable> list, long constraints) {
        long looseConstraints;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        long m5164copyZbe2FdA;
        long placeholderConstraints;
        String str;
        Object obj6;
        long supportingConstraints;
        Object obj7;
        long supportingConstraints2;
        Placeable placeable;
        final int width;
        final int totalHeight;
        Iterable measurables = list;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        final int topPaddingValue = measure.mo323roundToPx0680j_4(this.paddingValues.getTop());
        int bottomPaddingValue = measure.mo323roundToPx0680j_4(this.paddingValues.getBottom());
        looseConstraints = Constraints.m5164copyZbe2FdA(constraints, (r12 & 1) != 0 ? Constraints.m5176getMinWidthimpl(constraints) : 0, (r12 & 2) != 0 ? Constraints.m5174getMaxWidthimpl(constraints) : 0, (r12 & 4) != 0 ? Constraints.m5175getMinHeightimpl(constraints) : 0, (r12 & 8) != 0 ? Constraints.m5173getMaxHeightimpl(constraints) : 0);
        Iterator<T> it = measurables.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Measurable it2 = (Measurable) obj;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it2), "Leading")) {
                break;
            }
        }
        Measurable measurable = (Measurable) obj;
        final Placeable leadingPlaceable = measurable != null ? measurable.mo4186measureBRTryo0(looseConstraints) : null;
        int occupiedSpaceHorizontally = 0 + TextFieldImplKt.widthOrZero(leadingPlaceable);
        int occupiedSpaceVertically = Math.max(0, TextFieldImplKt.heightOrZero(leadingPlaceable));
        Iterator<T> it3 = measurables.iterator();
        while (true) {
            if (!it3.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it3.next();
            Measurable it4 = (Measurable) obj2;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it4), "Trailing")) {
                break;
            }
        }
        Measurable measurable2 = (Measurable) obj2;
        final Placeable trailingPlaceable = measurable2 != null ? measurable2.mo4186measureBRTryo0(ConstraintsKt.m5191offsetNN6EwU$default(looseConstraints, -occupiedSpaceHorizontally, 0, 2, null)) : null;
        int occupiedSpaceHorizontally2 = occupiedSpaceHorizontally + TextFieldImplKt.widthOrZero(trailingPlaceable);
        int occupiedSpaceVertically2 = Math.max(occupiedSpaceVertically, TextFieldImplKt.heightOrZero(trailingPlaceable));
        Iterator<T> it5 = measurables.iterator();
        while (true) {
            if (!it5.hasNext()) {
                obj3 = null;
                break;
            }
            obj3 = it5.next();
            Measurable it6 = (Measurable) obj3;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it6), TextFieldImplKt.PrefixId)) {
                break;
            }
        }
        Measurable measurable3 = (Measurable) obj3;
        final Placeable prefixPlaceable = measurable3 != null ? measurable3.mo4186measureBRTryo0(ConstraintsKt.m5191offsetNN6EwU$default(looseConstraints, -occupiedSpaceHorizontally2, 0, 2, null)) : null;
        int occupiedSpaceHorizontally3 = occupiedSpaceHorizontally2 + TextFieldImplKt.widthOrZero(prefixPlaceable);
        int occupiedSpaceVertically3 = Math.max(occupiedSpaceVertically2, TextFieldImplKt.heightOrZero(prefixPlaceable));
        Iterator it7 = measurables.iterator();
        while (true) {
            if (!it7.hasNext()) {
                obj4 = null;
                break;
            }
            obj4 = it7.next();
            Measurable it8 = (Measurable) obj4;
            Iterator it9 = it7;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it8), TextFieldImplKt.SuffixId)) {
                break;
            }
            it7 = it9;
        }
        Measurable measurable4 = (Measurable) obj4;
        final Placeable suffixPlaceable = measurable4 != null ? measurable4.mo4186measureBRTryo0(ConstraintsKt.m5191offsetNN6EwU$default(looseConstraints, -occupiedSpaceHorizontally3, 0, 2, null)) : null;
        int occupiedSpaceHorizontally4 = occupiedSpaceHorizontally3 + TextFieldImplKt.widthOrZero(suffixPlaceable);
        int occupiedSpaceVertically4 = Math.max(occupiedSpaceVertically3, TextFieldImplKt.heightOrZero(suffixPlaceable));
        int occupiedSpaceVertically5 = -bottomPaddingValue;
        long labelConstraints = ConstraintsKt.m5190offsetNN6EwU(looseConstraints, -occupiedSpaceHorizontally4, occupiedSpaceVertically5);
        Iterator it10 = measurables.iterator();
        while (true) {
            if (!it10.hasNext()) {
                obj5 = null;
                break;
            }
            Object next = it10.next();
            Measurable it11 = (Measurable) next;
            Iterator it12 = it10;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it11), "Label")) {
                obj5 = next;
                break;
            }
            it10 = it12;
        }
        Measurable measurable5 = (Measurable) obj5;
        final Placeable labelPlaceable = measurable5 != null ? measurable5.mo4186measureBRTryo0(labelConstraints) : null;
        int effectiveTopOffset = topPaddingValue + TextFieldImplKt.heightOrZero(labelPlaceable);
        int verticalConstraintOffset = (-effectiveTopOffset) - bottomPaddingValue;
        m5164copyZbe2FdA = Constraints.m5164copyZbe2FdA(constraints, (r12 & 1) != 0 ? Constraints.m5176getMinWidthimpl(constraints) : 0, (r12 & 2) != 0 ? Constraints.m5174getMaxWidthimpl(constraints) : 0, (r12 & 4) != 0 ? Constraints.m5175getMinHeightimpl(constraints) : 0, (r12 & 8) != 0 ? Constraints.m5173getMaxHeightimpl(constraints) : 0);
        long textFieldConstraints = ConstraintsKt.m5190offsetNN6EwU(m5164copyZbe2FdA, -occupiedSpaceHorizontally4, verticalConstraintOffset);
        Iterable $this$first$iv = measurables;
        Iterator it13 = $this$first$iv.iterator();
        while (true) {
            int occupiedSpaceHorizontally5 = occupiedSpaceHorizontally4;
            String str2 = "Collection contains no element matching the predicate.";
            if (!it13.hasNext()) {
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            Object element$iv = it13.next();
            Measurable it14 = (Measurable) element$iv;
            Iterable $this$first$iv2 = $this$first$iv;
            int verticalConstraintOffset2 = verticalConstraintOffset;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it14), "TextField")) {
                final Placeable textFieldPlaceable = ((Measurable) element$iv).mo4186measureBRTryo0(textFieldConstraints);
                long placeholderConstraints2 = textFieldConstraints;
                placeholderConstraints = Constraints.m5164copyZbe2FdA(textFieldConstraints, (r12 & 1) != 0 ? Constraints.m5176getMinWidthimpl(textFieldConstraints) : 0, (r12 & 2) != 0 ? Constraints.m5174getMaxWidthimpl(textFieldConstraints) : 0, (r12 & 4) != 0 ? Constraints.m5175getMinHeightimpl(textFieldConstraints) : 0, (r12 & 8) != 0 ? Constraints.m5173getMaxHeightimpl(textFieldConstraints) : 0);
                Iterator it15 = measurables.iterator();
                while (true) {
                    if (!it15.hasNext()) {
                        str = str2;
                        obj6 = null;
                        break;
                    }
                    obj6 = it15.next();
                    Measurable it16 = (Measurable) obj6;
                    Iterator it17 = it15;
                    str = str2;
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it16), "Hint")) {
                        break;
                    }
                    it15 = it17;
                    str2 = str;
                }
                Measurable measurable6 = (Measurable) obj6;
                final Placeable placeholderPlaceable = measurable6 != null ? measurable6.mo4186measureBRTryo0(placeholderConstraints) : null;
                long textFieldConstraints2 = placeholderConstraints;
                supportingConstraints = Constraints.m5164copyZbe2FdA(r38, (r12 & 1) != 0 ? Constraints.m5176getMinWidthimpl(r38) : 0, (r12 & 2) != 0 ? Constraints.m5174getMaxWidthimpl(r38) : 0, (r12 & 4) != 0 ? Constraints.m5175getMinHeightimpl(r38) : 0, (r12 & 8) != 0 ? Constraints.m5173getMaxHeightimpl(ConstraintsKt.m5191offsetNN6EwU$default(looseConstraints, 0, -Math.max(occupiedSpaceVertically4, Math.max(TextFieldImplKt.heightOrZero(textFieldPlaceable), TextFieldImplKt.heightOrZero(placeholderPlaceable)) + effectiveTopOffset + bottomPaddingValue), 1, null)) : 0);
                Iterator it18 = measurables.iterator();
                while (true) {
                    if (!it18.hasNext()) {
                        obj7 = null;
                        break;
                    }
                    obj7 = it18.next();
                    Measurable it19 = (Measurable) obj7;
                    Iterator it20 = it18;
                    long looseConstraints2 = looseConstraints;
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it19), TextFieldImplKt.SupportingId)) {
                        break;
                    }
                    it18 = it20;
                    looseConstraints = looseConstraints2;
                }
                Measurable measurable7 = (Measurable) obj7;
                if (measurable7 != null) {
                    supportingConstraints2 = supportingConstraints;
                    placeable = measurable7.mo4186measureBRTryo0(supportingConstraints2);
                } else {
                    supportingConstraints2 = supportingConstraints;
                    placeable = null;
                }
                final Placeable supportingPlaceable = placeable;
                int supportingHeight = TextFieldImplKt.heightOrZero(supportingPlaceable);
                width = TextFieldKt.m1869calculateWidthyeHjK3Y(TextFieldImplKt.widthOrZero(leadingPlaceable), TextFieldImplKt.widthOrZero(trailingPlaceable), TextFieldImplKt.widthOrZero(prefixPlaceable), TextFieldImplKt.widthOrZero(suffixPlaceable), textFieldPlaceable.getWidth(), TextFieldImplKt.widthOrZero(labelPlaceable), TextFieldImplKt.widthOrZero(placeholderPlaceable), constraints);
                totalHeight = TextFieldKt.m1868calculateHeightmKXJcVc(textFieldPlaceable.getHeight(), TextFieldImplKt.heightOrZero(labelPlaceable), TextFieldImplKt.heightOrZero(leadingPlaceable), TextFieldImplKt.heightOrZero(trailingPlaceable), TextFieldImplKt.heightOrZero(prefixPlaceable), TextFieldImplKt.heightOrZero(suffixPlaceable), TextFieldImplKt.heightOrZero(placeholderPlaceable), TextFieldImplKt.heightOrZero(supportingPlaceable), this.animationProgress == 1.0f, constraints, measure.getDensity(), this.paddingValues);
                int height = totalHeight - supportingHeight;
                for (Object element$iv2 : measurables) {
                    Measurable it21 = (Measurable) element$iv2;
                    long supportingConstraints3 = supportingConstraints2;
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it21), TextFieldImplKt.ContainerId)) {
                        final Placeable containerPlaceable = ((Measurable) element$iv2).mo4186measureBRTryo0(ConstraintsKt.Constraints(width != Integer.MAX_VALUE ? width : 0, width, height != Integer.MAX_VALUE ? height : 0, height));
                        return MeasureScope.layout$default(measure, width, totalHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TextFieldMeasurePolicy$measure$1
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
                                boolean z;
                                PaddingValues paddingValues;
                                boolean z2;
                                float f;
                                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                if (Placeable.this != null) {
                                    int i = width;
                                    int i2 = totalHeight;
                                    Placeable placeable2 = textFieldPlaceable;
                                    Placeable placeable3 = Placeable.this;
                                    Placeable placeable4 = placeholderPlaceable;
                                    Placeable placeable5 = leadingPlaceable;
                                    Placeable placeable6 = trailingPlaceable;
                                    Placeable placeable7 = prefixPlaceable;
                                    Placeable placeable8 = suffixPlaceable;
                                    Placeable placeable9 = containerPlaceable;
                                    Placeable placeable10 = supportingPlaceable;
                                    z2 = this.singleLine;
                                    int i3 = topPaddingValue;
                                    int height2 = topPaddingValue + Placeable.this.getHeight();
                                    f = this.animationProgress;
                                    TextFieldKt.placeWithLabel(layout, i, i2, placeable2, placeable3, placeable4, placeable5, placeable6, placeable7, placeable8, placeable9, placeable10, z2, i3, height2, f, measure.getDensity());
                                    return;
                                }
                                int i4 = width;
                                int i5 = totalHeight;
                                Placeable placeable11 = textFieldPlaceable;
                                Placeable placeable12 = placeholderPlaceable;
                                Placeable placeable13 = leadingPlaceable;
                                Placeable placeable14 = trailingPlaceable;
                                Placeable placeable15 = prefixPlaceable;
                                Placeable placeable16 = suffixPlaceable;
                                Placeable placeable17 = containerPlaceable;
                                Placeable placeable18 = supportingPlaceable;
                                z = this.singleLine;
                                float density = measure.getDensity();
                                paddingValues = this.paddingValues;
                                TextFieldKt.placeWithoutLabel(layout, i4, i5, placeable11, placeable12, placeable13, placeable14, placeable15, placeable16, placeable17, placeable18, z, density, paddingValues);
                            }
                        }, 4, null);
                    }
                    long placeholderConstraints3 = textFieldConstraints2;
                    supportingConstraints2 = supportingConstraints3;
                    textFieldConstraints2 = placeholderConstraints3;
                    placeholderConstraints2 = placeholderConstraints2;
                }
                throw new NoSuchElementException(str);
            }
            measurables = list;
            $this$first$iv = $this$first$iv2;
            verticalConstraintOffset = verticalConstraintOffset2;
            occupiedSpaceHorizontally4 = occupiedSpaceHorizontally5;
        }
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicHeight($this$maxIntrinsicHeight, measurables, width, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material3.TextFieldMeasurePolicy$maxIntrinsicHeight$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num) {
                return invoke(intrinsicMeasurable, num.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int w) {
                Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
                return Integer.valueOf(intrinsicMeasurable.maxIntrinsicHeight(w));
            }
        });
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicHeight($this$minIntrinsicHeight, measurables, width, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material3.TextFieldMeasurePolicy$minIntrinsicHeight$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num) {
                return invoke(intrinsicMeasurable, num.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int w) {
                Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
                return Integer.valueOf(intrinsicMeasurable.minIntrinsicHeight(w));
            }
        });
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicWidth(measurables, height, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material3.TextFieldMeasurePolicy$maxIntrinsicWidth$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num) {
                return invoke(intrinsicMeasurable, num.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int h) {
                Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
                return Integer.valueOf(intrinsicMeasurable.maxIntrinsicWidth(h));
            }
        });
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicWidth(measurables, height, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material3.TextFieldMeasurePolicy$minIntrinsicWidth$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num) {
                return invoke(intrinsicMeasurable, num.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int h) {
                Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
                return Integer.valueOf(intrinsicMeasurable.minIntrinsicWidth(h));
            }
        });
    }

    private final int intrinsicWidth(List<? extends IntrinsicMeasurable> measurables, int height, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> intrinsicMeasurer) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        int m1869calculateWidthyeHjK3Y;
        List<? extends IntrinsicMeasurable> $this$first$iv = measurables;
        for (Object element$iv : $this$first$iv) {
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) element$iv), "TextField")) {
                int textFieldWidth = intrinsicMeasurer.invoke(element$iv, Integer.valueOf(height)).intValue();
                Iterator<T> it = measurables.iterator();
                while (true) {
                    obj = null;
                    if (!it.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj2), "Label")) {
                        break;
                    }
                }
                IntrinsicMeasurable it2 = (IntrinsicMeasurable) obj2;
                int labelWidth = it2 != null ? intrinsicMeasurer.invoke(it2, Integer.valueOf(height)).intValue() : 0;
                Iterator<T> it3 = measurables.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        obj3 = null;
                        break;
                    }
                    obj3 = it3.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj3), "Trailing")) {
                        break;
                    }
                }
                IntrinsicMeasurable it4 = (IntrinsicMeasurable) obj3;
                int trailingWidth = it4 != null ? intrinsicMeasurer.invoke(it4, Integer.valueOf(height)).intValue() : 0;
                Iterator<T> it5 = measurables.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        obj4 = null;
                        break;
                    }
                    obj4 = it5.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj4), TextFieldImplKt.PrefixId)) {
                        break;
                    }
                }
                IntrinsicMeasurable it6 = (IntrinsicMeasurable) obj4;
                int prefixWidth = it6 != null ? intrinsicMeasurer.invoke(it6, Integer.valueOf(height)).intValue() : 0;
                Iterator<T> it7 = measurables.iterator();
                while (true) {
                    if (!it7.hasNext()) {
                        obj5 = null;
                        break;
                    }
                    obj5 = it7.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj5), TextFieldImplKt.SuffixId)) {
                        break;
                    }
                }
                IntrinsicMeasurable it8 = (IntrinsicMeasurable) obj5;
                int suffixWidth = it8 != null ? intrinsicMeasurer.invoke(it8, Integer.valueOf(height)).intValue() : 0;
                Iterator<T> it9 = measurables.iterator();
                while (true) {
                    if (!it9.hasNext()) {
                        obj6 = null;
                        break;
                    }
                    obj6 = it9.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj6), "Leading")) {
                        break;
                    }
                }
                IntrinsicMeasurable it10 = (IntrinsicMeasurable) obj6;
                int leadingWidth = it10 != null ? intrinsicMeasurer.invoke(it10, Integer.valueOf(height)).intValue() : 0;
                Iterator<T> it11 = measurables.iterator();
                while (true) {
                    if (!it11.hasNext()) {
                        break;
                    }
                    Object next = it11.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next), "Hint")) {
                        obj = next;
                        break;
                    }
                }
                IntrinsicMeasurable it12 = (IntrinsicMeasurable) obj;
                int placeholderWidth = it12 != null ? intrinsicMeasurer.invoke(it12, Integer.valueOf(height)).intValue() : 0;
                m1869calculateWidthyeHjK3Y = TextFieldKt.m1869calculateWidthyeHjK3Y(leadingWidth, trailingWidth, prefixWidth, suffixWidth, textFieldWidth, labelWidth, placeholderWidth, TextFieldImplKt.getZeroConstraints());
                return m1869calculateWidthyeHjK3Y;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private final int intrinsicHeight(IntrinsicMeasureScope $this$intrinsicHeight, List<? extends IntrinsicMeasurable> list, int width, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        int m1868calculateHeightmKXJcVc;
        List<? extends IntrinsicMeasurable> $this$first$iv = list;
        for (Object element$iv : $this$first$iv) {
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) element$iv), "TextField")) {
                int textFieldHeight = function2.invoke(element$iv, Integer.valueOf(width)).intValue();
                Iterator<T> it = list.iterator();
                while (true) {
                    obj = null;
                    if (!it.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj2), "Label")) {
                        break;
                    }
                }
                IntrinsicMeasurable it2 = (IntrinsicMeasurable) obj2;
                int labelHeight = it2 != null ? function2.invoke(it2, Integer.valueOf(width)).intValue() : 0;
                Iterator<T> it3 = list.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        obj3 = null;
                        break;
                    }
                    obj3 = it3.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj3), "Trailing")) {
                        break;
                    }
                }
                IntrinsicMeasurable it4 = (IntrinsicMeasurable) obj3;
                int trailingHeight = it4 != null ? function2.invoke(it4, Integer.valueOf(width)).intValue() : 0;
                Iterator<T> it5 = list.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        obj4 = null;
                        break;
                    }
                    obj4 = it5.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj4), "Leading")) {
                        break;
                    }
                }
                IntrinsicMeasurable it6 = (IntrinsicMeasurable) obj4;
                int leadingHeight = it6 != null ? function2.invoke(it6, Integer.valueOf(width)).intValue() : 0;
                Iterator<T> it7 = list.iterator();
                while (true) {
                    if (!it7.hasNext()) {
                        obj5 = null;
                        break;
                    }
                    obj5 = it7.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj5), TextFieldImplKt.PrefixId)) {
                        break;
                    }
                }
                IntrinsicMeasurable it8 = (IntrinsicMeasurable) obj5;
                int prefixHeight = it8 != null ? function2.invoke(it8, Integer.valueOf(width)).intValue() : 0;
                Iterator<T> it9 = list.iterator();
                while (true) {
                    if (!it9.hasNext()) {
                        obj6 = null;
                        break;
                    }
                    obj6 = it9.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj6), TextFieldImplKt.SuffixId)) {
                        break;
                    }
                }
                IntrinsicMeasurable it10 = (IntrinsicMeasurable) obj6;
                int suffixHeight = it10 != null ? function2.invoke(it10, Integer.valueOf(width)).intValue() : 0;
                Iterator<T> it11 = list.iterator();
                while (true) {
                    if (!it11.hasNext()) {
                        obj7 = null;
                        break;
                    }
                    obj7 = it11.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj7), "Hint")) {
                        break;
                    }
                }
                IntrinsicMeasurable it12 = (IntrinsicMeasurable) obj7;
                int placeholderHeight = it12 != null ? function2.invoke(it12, Integer.valueOf(width)).intValue() : 0;
                Iterator<T> it13 = list.iterator();
                while (true) {
                    if (!it13.hasNext()) {
                        break;
                    }
                    Object next = it13.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next), TextFieldImplKt.SupportingId)) {
                        obj = next;
                        break;
                    }
                }
                IntrinsicMeasurable it14 = (IntrinsicMeasurable) obj;
                int supportingHeight = it14 != null ? function2.invoke(it14, Integer.valueOf(width)).intValue() : 0;
                m1868calculateHeightmKXJcVc = TextFieldKt.m1868calculateHeightmKXJcVc(textFieldHeight, labelHeight, leadingHeight, trailingHeight, prefixHeight, suffixHeight, placeholderHeight, supportingHeight, this.animationProgress == 1.0f, TextFieldImplKt.getZeroConstraints(), $this$intrinsicHeight.getDensity(), this.paddingValues);
                return m1868calculateHeightmKXJcVc;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
