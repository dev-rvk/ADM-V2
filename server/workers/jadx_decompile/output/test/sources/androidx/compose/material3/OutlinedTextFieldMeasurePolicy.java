package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
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
import androidx.compose.ui.unit.LayoutDirection;
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
/* compiled from: OutlinedTextField.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B4\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0002\u0010\fJ<\u0010\r\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u000e2\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0015H\u0002J<\u0010\u0016\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0017\u001a\u00020\u000e2\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0015H\u0002J\"\u0010\u0018\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\"\u0010\u0019\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J/\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!J\"\u0010\"\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\"\u0010#\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0017\u001a\u00020\u000eH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"Landroidx/compose/material3/OutlinedTextFieldMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "onLabelMeasured", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Size;", "", "singleLine", "", "animationProgress", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Lkotlin/jvm/functions/Function1;ZFLandroidx/compose/foundation/layout/PaddingValues;)V", "intrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "intrinsicMeasurer", "Lkotlin/Function2;", "intrinsicWidth", "height", "maxIntrinsicHeight", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class OutlinedTextFieldMeasurePolicy implements MeasurePolicy {
    private final float animationProgress;
    private final Function1<Size, Unit> onLabelMeasured;
    private final PaddingValues paddingValues;
    private final boolean singleLine;

    /* JADX WARN: Multi-variable type inference failed */
    public OutlinedTextFieldMeasurePolicy(Function1<? super Size, Unit> onLabelMeasured, boolean singleLine, float animationProgress, PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter(onLabelMeasured, "onLabelMeasured");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        this.onLabelMeasured = onLabelMeasured;
        this.singleLine = singleLine;
        this.animationProgress = animationProgress;
        this.paddingValues = paddingValues;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo15measure3p2s80s(final MeasureScope measure, List<? extends Measurable> list, long constraints) {
        long relaxedConstraints;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        long labelConstraints;
        long textConstraints;
        long placeholderConstraints;
        long textConstraints2;
        Object obj6;
        long supportingConstraints;
        int occupiedSpaceVertically;
        long relaxedConstraints2;
        Object obj7;
        final int width;
        final int totalHeight;
        Iterable measurables = list;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        int bottomPadding = measure.mo323roundToPx0680j_4(this.paddingValues.getBottom());
        relaxedConstraints = Constraints.m5164copyZbe2FdA(constraints, (r12 & 1) != 0 ? Constraints.m5176getMinWidthimpl(constraints) : 0, (r12 & 2) != 0 ? Constraints.m5174getMaxWidthimpl(constraints) : 0, (r12 & 4) != 0 ? Constraints.m5175getMinHeightimpl(constraints) : 0, (r12 & 8) != 0 ? Constraints.m5173getMaxHeightimpl(constraints) : 0);
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
        final Placeable leadingPlaceable = measurable != null ? measurable.mo4186measureBRTryo0(relaxedConstraints) : null;
        int occupiedSpaceHorizontally = 0 + TextFieldImplKt.widthOrZero(leadingPlaceable);
        int occupiedSpaceVertically2 = Math.max(0, TextFieldImplKt.heightOrZero(leadingPlaceable));
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
        final Placeable trailingPlaceable = measurable2 != null ? measurable2.mo4186measureBRTryo0(ConstraintsKt.m5191offsetNN6EwU$default(relaxedConstraints, -occupiedSpaceHorizontally, 0, 2, null)) : null;
        int occupiedSpaceHorizontally2 = occupiedSpaceHorizontally + TextFieldImplKt.widthOrZero(trailingPlaceable);
        int occupiedSpaceVertically3 = Math.max(occupiedSpaceVertically2, TextFieldImplKt.heightOrZero(trailingPlaceable));
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
        final Placeable prefixPlaceable = measurable3 != null ? measurable3.mo4186measureBRTryo0(ConstraintsKt.m5191offsetNN6EwU$default(relaxedConstraints, -occupiedSpaceHorizontally2, 0, 2, null)) : null;
        int occupiedSpaceHorizontally3 = occupiedSpaceHorizontally2 + TextFieldImplKt.widthOrZero(prefixPlaceable);
        int occupiedSpaceVertically4 = Math.max(occupiedSpaceVertically3, TextFieldImplKt.heightOrZero(prefixPlaceable));
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
        final Placeable suffixPlaceable = measurable4 != null ? measurable4.mo4186measureBRTryo0(ConstraintsKt.m5191offsetNN6EwU$default(relaxedConstraints, -occupiedSpaceHorizontally3, 0, 2, null)) : null;
        int occupiedSpaceHorizontally4 = occupiedSpaceHorizontally3 + TextFieldImplKt.widthOrZero(suffixPlaceable);
        int occupiedSpaceVertically5 = Math.max(occupiedSpaceVertically4, TextFieldImplKt.heightOrZero(suffixPlaceable));
        boolean isLabelInMiddleSection = this.animationProgress < 1.0f;
        int labelHorizontalPaddingOffset = measure.mo323roundToPx0680j_4(this.paddingValues.mo435calculateLeftPaddingu2uoSUM(measure.getLayoutDirection())) + measure.mo323roundToPx0680j_4(this.paddingValues.mo436calculateRightPaddingu2uoSUM(measure.getLayoutDirection()));
        int occupiedSpaceVertically6 = labelHorizontalPaddingOffset;
        long labelConstraints2 = ConstraintsKt.m5190offsetNN6EwU(relaxedConstraints, isLabelInMiddleSection ? (-occupiedSpaceHorizontally4) - labelHorizontalPaddingOffset : -labelHorizontalPaddingOffset, -bottomPadding);
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
        final Placeable labelPlaceable = measurable5 != null ? measurable5.mo4186measureBRTryo0(labelConstraints2) : null;
        if (labelPlaceable != null) {
            labelConstraints = labelConstraints2;
            this.onLabelMeasured.invoke(Size.m2767boximpl(SizeKt.Size(labelPlaceable.getWidth(), labelPlaceable.getHeight())));
        } else {
            labelConstraints = labelConstraints2;
        }
        int topPadding = Math.max(TextFieldImplKt.heightOrZero(labelPlaceable) / 2, measure.mo323roundToPx0680j_4(this.paddingValues.getTop()));
        textConstraints = Constraints.m5164copyZbe2FdA(r23, (r12 & 1) != 0 ? Constraints.m5176getMinWidthimpl(r23) : 0, (r12 & 2) != 0 ? Constraints.m5174getMaxWidthimpl(r23) : 0, (r12 & 4) != 0 ? Constraints.m5175getMinHeightimpl(r23) : 0, (r12 & 8) != 0 ? Constraints.m5173getMaxHeightimpl(ConstraintsKt.m5190offsetNN6EwU(constraints, -occupiedSpaceHorizontally4, (-bottomPadding) - topPadding)) : 0);
        Iterable $this$first$iv = measurables;
        int $i$f$first = 0;
        Iterator it13 = $this$first$iv.iterator();
        while (true) {
            int occupiedSpaceHorizontally5 = occupiedSpaceHorizontally4;
            if (!it13.hasNext()) {
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            Object element$iv = it13.next();
            Measurable it14 = (Measurable) element$iv;
            Iterable $this$first$iv2 = $this$first$iv;
            int $i$f$first2 = $i$f$first;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it14), "TextField")) {
                final Placeable textFieldPlaceable = ((Measurable) element$iv).mo4186measureBRTryo0(textConstraints);
                placeholderConstraints = Constraints.m5164copyZbe2FdA(textConstraints, (r12 & 1) != 0 ? Constraints.m5176getMinWidthimpl(textConstraints) : 0, (r12 & 2) != 0 ? Constraints.m5174getMaxWidthimpl(textConstraints) : 0, (r12 & 4) != 0 ? Constraints.m5175getMinHeightimpl(textConstraints) : 0, (r12 & 8) != 0 ? Constraints.m5173getMaxHeightimpl(textConstraints) : 0);
                Iterator<T> it15 = measurables.iterator();
                while (true) {
                    if (!it15.hasNext()) {
                        textConstraints2 = textConstraints;
                        obj6 = null;
                        break;
                    }
                    obj6 = it15.next();
                    Measurable it16 = (Measurable) obj6;
                    textConstraints2 = textConstraints;
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it16), "Hint")) {
                        break;
                    }
                    textConstraints = textConstraints2;
                }
                Measurable measurable6 = (Measurable) obj6;
                final Placeable placeholderPlaceable = measurable6 != null ? measurable6.mo4186measureBRTryo0(placeholderConstraints) : null;
                int occupiedSpaceVertically7 = Math.max(occupiedSpaceVertically5, Math.max(TextFieldImplKt.heightOrZero(textFieldPlaceable), TextFieldImplKt.heightOrZero(placeholderPlaceable)) + topPadding + bottomPadding);
                supportingConstraints = Constraints.m5164copyZbe2FdA(r23, (r12 & 1) != 0 ? Constraints.m5176getMinWidthimpl(r23) : 0, (r12 & 2) != 0 ? Constraints.m5174getMaxWidthimpl(r23) : 0, (r12 & 4) != 0 ? Constraints.m5175getMinHeightimpl(r23) : 0, (r12 & 8) != 0 ? Constraints.m5173getMaxHeightimpl(ConstraintsKt.m5191offsetNN6EwU$default(relaxedConstraints, 0, -occupiedSpaceVertically7, 1, null)) : 0);
                Iterator<T> it17 = measurables.iterator();
                while (true) {
                    if (!it17.hasNext()) {
                        occupiedSpaceVertically = occupiedSpaceVertically7;
                        relaxedConstraints2 = relaxedConstraints;
                        obj7 = null;
                        break;
                    }
                    obj7 = it17.next();
                    Measurable it18 = (Measurable) obj7;
                    occupiedSpaceVertically = occupiedSpaceVertically7;
                    relaxedConstraints2 = relaxedConstraints;
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it18), TextFieldImplKt.SupportingId)) {
                        break;
                    }
                    occupiedSpaceVertically7 = occupiedSpaceVertically;
                    relaxedConstraints = relaxedConstraints2;
                }
                Measurable measurable7 = (Measurable) obj7;
                final Placeable supportingPlaceable = measurable7 != null ? measurable7.mo4186measureBRTryo0(supportingConstraints) : null;
                int supportingHeight = TextFieldImplKt.heightOrZero(supportingPlaceable);
                width = OutlinedTextFieldKt.m1646calculateWidthDHJA7U0(TextFieldImplKt.widthOrZero(leadingPlaceable), TextFieldImplKt.widthOrZero(trailingPlaceable), TextFieldImplKt.widthOrZero(prefixPlaceable), TextFieldImplKt.widthOrZero(suffixPlaceable), textFieldPlaceable.getWidth(), TextFieldImplKt.widthOrZero(labelPlaceable), TextFieldImplKt.widthOrZero(placeholderPlaceable), isLabelInMiddleSection, constraints, measure.getDensity(), this.paddingValues);
                totalHeight = OutlinedTextFieldKt.m1645calculateHeightDHJA7U0(TextFieldImplKt.heightOrZero(leadingPlaceable), TextFieldImplKt.heightOrZero(trailingPlaceable), TextFieldImplKt.heightOrZero(prefixPlaceable), TextFieldImplKt.heightOrZero(suffixPlaceable), textFieldPlaceable.getHeight(), TextFieldImplKt.heightOrZero(labelPlaceable), TextFieldImplKt.heightOrZero(placeholderPlaceable), TextFieldImplKt.heightOrZero(supportingPlaceable), constraints, measure.getDensity(), this.paddingValues);
                int height = totalHeight - supportingHeight;
                Iterable $this$first$iv3 = measurables;
                for (Object element$iv2 : $this$first$iv3) {
                    Measurable it19 = (Measurable) element$iv2;
                    Iterable $this$first$iv4 = $this$first$iv3;
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it19), TextFieldImplKt.ContainerId)) {
                        final Placeable containerPlaceable = ((Measurable) element$iv2).mo4186measureBRTryo0(ConstraintsKt.Constraints(width != Integer.MAX_VALUE ? width : 0, width, height != Integer.MAX_VALUE ? height : 0, height));
                        return MeasureScope.layout$default(measure, width, totalHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldMeasurePolicy$measure$2
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
                                float f;
                                boolean z;
                                PaddingValues paddingValues;
                                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                int i = totalHeight;
                                int i2 = width;
                                Placeable placeable = leadingPlaceable;
                                Placeable placeable2 = trailingPlaceable;
                                Placeable placeable3 = prefixPlaceable;
                                Placeable placeable4 = suffixPlaceable;
                                Placeable placeable5 = textFieldPlaceable;
                                Placeable placeable6 = labelPlaceable;
                                Placeable placeable7 = placeholderPlaceable;
                                Placeable placeable8 = containerPlaceable;
                                Placeable placeable9 = supportingPlaceable;
                                f = this.animationProgress;
                                z = this.singleLine;
                                float density = measure.getDensity();
                                LayoutDirection layoutDirection = measure.getLayoutDirection();
                                paddingValues = this.paddingValues;
                                OutlinedTextFieldKt.place(layout, i, i2, placeable, placeable2, placeable3, placeable4, placeable5, placeable6, placeable7, placeable8, placeable9, f, z, density, layoutDirection, paddingValues);
                            }
                        }, 4, null);
                    }
                    $this$first$iv3 = $this$first$iv4;
                    height = height;
                    occupiedSpaceVertically6 = occupiedSpaceVertically6;
                    labelConstraints = labelConstraints;
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            measurables = list;
            $this$first$iv = $this$first$iv2;
            $i$f$first = $i$f$first2;
            occupiedSpaceHorizontally4 = occupiedSpaceHorizontally5;
            labelConstraints = labelConstraints;
        }
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicHeight($this$maxIntrinsicHeight, measurables, width, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material3.OutlinedTextFieldMeasurePolicy$maxIntrinsicHeight$1
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
        return intrinsicHeight($this$minIntrinsicHeight, measurables, width, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material3.OutlinedTextFieldMeasurePolicy$minIntrinsicHeight$1
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
        return intrinsicWidth($this$maxIntrinsicWidth, measurables, height, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material3.OutlinedTextFieldMeasurePolicy$maxIntrinsicWidth$1
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
        return intrinsicWidth($this$minIntrinsicWidth, measurables, height, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material3.OutlinedTextFieldMeasurePolicy$minIntrinsicWidth$1
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

    private final int intrinsicWidth(IntrinsicMeasureScope $this$intrinsicWidth, List<? extends IntrinsicMeasurable> list, int height, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        int m1646calculateWidthDHJA7U0;
        List<? extends IntrinsicMeasurable> $this$first$iv = list;
        for (Object element$iv : $this$first$iv) {
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) element$iv), "TextField")) {
                int textFieldWidth = function2.invoke(element$iv, Integer.valueOf(height)).intValue();
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
                int labelWidth = it2 != null ? function2.invoke(it2, Integer.valueOf(height)).intValue() : 0;
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
                int trailingWidth = it4 != null ? function2.invoke(it4, Integer.valueOf(height)).intValue() : 0;
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
                int leadingWidth = it6 != null ? function2.invoke(it6, Integer.valueOf(height)).intValue() : 0;
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
                int prefixWidth = it8 != null ? function2.invoke(it8, Integer.valueOf(height)).intValue() : 0;
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
                int suffixWidth = it10 != null ? function2.invoke(it10, Integer.valueOf(height)).intValue() : 0;
                Iterator<T> it11 = list.iterator();
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
                int placeholderWidth = it12 != null ? function2.invoke(it12, Integer.valueOf(height)).intValue() : 0;
                m1646calculateWidthDHJA7U0 = OutlinedTextFieldKt.m1646calculateWidthDHJA7U0(leadingWidth, trailingWidth, prefixWidth, suffixWidth, textFieldWidth, labelWidth, placeholderWidth, this.animationProgress < 1.0f, TextFieldImplKt.getZeroConstraints(), $this$intrinsicWidth.getDensity(), this.paddingValues);
                return m1646calculateWidthDHJA7U0;
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
        int m1645calculateHeightDHJA7U0;
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
                m1645calculateHeightDHJA7U0 = OutlinedTextFieldKt.m1645calculateHeightDHJA7U0(leadingHeight, trailingHeight, prefixHeight, suffixHeight, textFieldHeight, labelHeight, placeholderHeight, supportingHeight, TextFieldImplKt.getZeroConstraints(), $this$intrinsicHeight.getDensity(), this.paddingValues);
                return m1645calculateHeightDHJA7U0;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
