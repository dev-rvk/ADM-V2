package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.layout.AlignmentLineKt;
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
import kotlin.ranges.RangesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextField.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ8\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\n2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0010H\u0002J<\u0010\u0011\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\n2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0010H\u0002J\"\u0010\u0014\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\"\u0010\u0015\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\nH\u0016J/\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00190\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\"\u0010\u001e\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\"\u0010\u001f\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, d2 = {"Landroidx/compose/material/TextFieldMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "singleLine", "", "animationProgress", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(ZFLandroidx/compose/foundation/layout/PaddingValues;)V", "intrinsicWidth", "", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "intrinsicMeasurer", "Lkotlin/Function2;", "intrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "width", "maxIntrinsicHeight", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "material_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
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
        int it;
        long m5164copyZbe2FdA;
        long placeholderConstraints;
        long textFieldConstraints;
        Object obj4;
        final int width;
        final int height;
        Iterable measurables = list;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        final int topPaddingValue = measure.mo323roundToPx0680j_4(this.paddingValues.getTop());
        int bottomPaddingValue = measure.mo323roundToPx0680j_4(this.paddingValues.getBottom());
        final int topPadding = measure.mo323roundToPx0680j_4(TextFieldKt.getTextFieldTopPadding());
        looseConstraints = Constraints.m5164copyZbe2FdA(constraints, (r12 & 1) != 0 ? Constraints.m5176getMinWidthimpl(constraints) : 0, (r12 & 2) != 0 ? Constraints.m5174getMaxWidthimpl(constraints) : 0, (r12 & 4) != 0 ? Constraints.m5175getMinHeightimpl(constraints) : 0, (r12 & 8) != 0 ? Constraints.m5173getMaxHeightimpl(constraints) : 0);
        Iterator<T> it2 = measurables.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            Measurable it3 = (Measurable) obj;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it3), "Leading")) {
                break;
            }
        }
        Measurable measurable = (Measurable) obj;
        final Placeable leadingPlaceable = measurable != null ? measurable.mo4186measureBRTryo0(looseConstraints) : null;
        int occupiedSpaceHorizontally = 0 + TextFieldImplKt.widthOrZero(leadingPlaceable);
        Iterator<T> it4 = measurables.iterator();
        while (true) {
            if (!it4.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it4.next();
            Measurable it5 = (Measurable) obj2;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it5), "Trailing")) {
                break;
            }
        }
        Measurable measurable2 = (Measurable) obj2;
        final Placeable trailingPlaceable = measurable2 != null ? measurable2.mo4186measureBRTryo0(ConstraintsKt.m5191offsetNN6EwU$default(looseConstraints, -occupiedSpaceHorizontally, 0, 2, null)) : null;
        int occupiedSpaceHorizontally2 = occupiedSpaceHorizontally + TextFieldImplKt.widthOrZero(trailingPlaceable);
        long labelConstraints = ConstraintsKt.m5190offsetNN6EwU(looseConstraints, -occupiedSpaceHorizontally2, -bottomPaddingValue);
        Iterator it6 = measurables.iterator();
        while (true) {
            if (!it6.hasNext()) {
                obj3 = null;
                break;
            }
            obj3 = it6.next();
            Measurable it7 = (Measurable) obj3;
            Iterator it8 = it6;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it7), "Label")) {
                break;
            }
            it6 = it8;
        }
        Measurable measurable3 = (Measurable) obj3;
        final Placeable labelPlaceable = measurable3 != null ? measurable3.mo4186measureBRTryo0(labelConstraints) : null;
        if (labelPlaceable != null) {
            it = labelPlaceable.get(AlignmentLineKt.getLastBaseline());
            if (it == Integer.MIN_VALUE) {
                it = labelPlaceable.getHeight();
            }
        } else {
            it = 0;
        }
        int lastBaseline = it;
        final int effectiveLabelBaseline = Math.max(lastBaseline, topPaddingValue);
        int verticalConstraintOffset = labelPlaceable != null ? ((-bottomPaddingValue) - topPadding) - effectiveLabelBaseline : (-topPaddingValue) - bottomPaddingValue;
        int lastBaseline2 = lastBaseline;
        m5164copyZbe2FdA = Constraints.m5164copyZbe2FdA(constraints, (r12 & 1) != 0 ? Constraints.m5176getMinWidthimpl(constraints) : 0, (r12 & 2) != 0 ? Constraints.m5174getMaxWidthimpl(constraints) : 0, (r12 & 4) != 0 ? Constraints.m5175getMinHeightimpl(constraints) : 0, (r12 & 8) != 0 ? Constraints.m5173getMaxHeightimpl(constraints) : 0);
        long textFieldConstraints2 = ConstraintsKt.m5190offsetNN6EwU(m5164copyZbe2FdA, -occupiedSpaceHorizontally2, verticalConstraintOffset);
        Iterable $this$first$iv = measurables;
        for (Object element$iv : $this$first$iv) {
            Measurable it9 = (Measurable) element$iv;
            final int lastBaseline3 = lastBaseline2;
            long looseConstraints2 = looseConstraints;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it9), "TextField")) {
                final Placeable textFieldPlaceable = ((Measurable) element$iv).mo4186measureBRTryo0(textFieldConstraints2);
                placeholderConstraints = Constraints.m5164copyZbe2FdA(textFieldConstraints2, (r12 & 1) != 0 ? Constraints.m5176getMinWidthimpl(textFieldConstraints2) : 0, (r12 & 2) != 0 ? Constraints.m5174getMaxWidthimpl(textFieldConstraints2) : 0, (r12 & 4) != 0 ? Constraints.m5175getMinHeightimpl(textFieldConstraints2) : 0, (r12 & 8) != 0 ? Constraints.m5173getMaxHeightimpl(textFieldConstraints2) : 0);
                Iterator<T> it10 = measurables.iterator();
                while (true) {
                    if (!it10.hasNext()) {
                        textFieldConstraints = textFieldConstraints2;
                        obj4 = null;
                        break;
                    }
                    obj4 = it10.next();
                    Measurable it11 = (Measurable) obj4;
                    textFieldConstraints = textFieldConstraints2;
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it11), "Hint")) {
                        break;
                    }
                    textFieldConstraints2 = textFieldConstraints;
                }
                Measurable measurable4 = (Measurable) obj4;
                final Placeable placeholderPlaceable = measurable4 != null ? measurable4.mo4186measureBRTryo0(placeholderConstraints) : null;
                width = TextFieldKt.m1255calculateWidthVsPV1Ek(TextFieldImplKt.widthOrZero(leadingPlaceable), TextFieldImplKt.widthOrZero(trailingPlaceable), textFieldPlaceable.getWidth(), TextFieldImplKt.widthOrZero(labelPlaceable), TextFieldImplKt.widthOrZero(placeholderPlaceable), constraints);
                height = TextFieldKt.m1254calculateHeightO3s9Psw(textFieldPlaceable.getHeight(), labelPlaceable != null, effectiveLabelBaseline, TextFieldImplKt.heightOrZero(leadingPlaceable), TextFieldImplKt.heightOrZero(trailingPlaceable), TextFieldImplKt.heightOrZero(placeholderPlaceable), constraints, measure.getDensity(), this.paddingValues);
                return MeasureScope.layout$default(measure, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.TextFieldMeasurePolicy$measure$1
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
                            int labelEndPosition = RangesKt.coerceAtLeast(topPaddingValue - lastBaseline3, 0);
                            int i = width;
                            int i2 = height;
                            Placeable placeable = textFieldPlaceable;
                            Placeable placeable2 = Placeable.this;
                            Placeable placeable3 = placeholderPlaceable;
                            Placeable placeable4 = leadingPlaceable;
                            Placeable placeable5 = trailingPlaceable;
                            z2 = this.singleLine;
                            int i3 = effectiveLabelBaseline + topPadding;
                            f = this.animationProgress;
                            TextFieldKt.placeWithLabel(layout, i, i2, placeable, placeable2, placeable3, placeable4, placeable5, z2, labelEndPosition, i3, f, measure.getDensity());
                            return;
                        }
                        int i4 = width;
                        int i5 = height;
                        Placeable placeable6 = textFieldPlaceable;
                        Placeable placeable7 = placeholderPlaceable;
                        Placeable placeable8 = leadingPlaceable;
                        Placeable placeable9 = trailingPlaceable;
                        z = this.singleLine;
                        float density = measure.getDensity();
                        paddingValues = this.paddingValues;
                        TextFieldKt.placeWithoutLabel(layout, i4, i5, placeable6, placeable7, placeable8, placeable9, z, density, paddingValues);
                    }
                }, 4, null);
            }
            measurables = list;
            lastBaseline2 = lastBaseline3;
            looseConstraints = looseConstraints2;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicHeight($this$maxIntrinsicHeight, measurables, width, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material.TextFieldMeasurePolicy$maxIntrinsicHeight$1
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
        return intrinsicHeight($this$minIntrinsicHeight, measurables, width, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material.TextFieldMeasurePolicy$minIntrinsicHeight$1
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
        return intrinsicWidth(measurables, height, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material.TextFieldMeasurePolicy$maxIntrinsicWidth$1
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
        return intrinsicWidth(measurables, height, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material.TextFieldMeasurePolicy$minIntrinsicWidth$1
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
        int m1255calculateWidthVsPV1Ek;
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
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj4), "Leading")) {
                        break;
                    }
                }
                IntrinsicMeasurable it6 = (IntrinsicMeasurable) obj4;
                int leadingWidth = it6 != null ? intrinsicMeasurer.invoke(it6, Integer.valueOf(height)).intValue() : 0;
                Iterator<T> it7 = measurables.iterator();
                while (true) {
                    if (!it7.hasNext()) {
                        break;
                    }
                    Object next = it7.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next), "Hint")) {
                        obj = next;
                        break;
                    }
                }
                IntrinsicMeasurable it8 = (IntrinsicMeasurable) obj;
                int placeholderWidth = it8 != null ? intrinsicMeasurer.invoke(it8, Integer.valueOf(height)).intValue() : 0;
                m1255calculateWidthVsPV1Ek = TextFieldKt.m1255calculateWidthVsPV1Ek(leadingWidth, trailingWidth, textFieldWidth, labelWidth, placeholderWidth, TextFieldImplKt.getZeroConstraints());
                return m1255calculateWidthVsPV1Ek;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private final int intrinsicHeight(IntrinsicMeasureScope $this$intrinsicHeight, List<? extends IntrinsicMeasurable> list, int width, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        int m1254calculateHeightO3s9Psw;
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
                        break;
                    }
                    Object next = it7.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next), "Hint")) {
                        obj = next;
                        break;
                    }
                }
                IntrinsicMeasurable it8 = (IntrinsicMeasurable) obj;
                int placeholderHeight = it8 != null ? function2.invoke(it8, Integer.valueOf(width)).intValue() : 0;
                m1254calculateHeightO3s9Psw = TextFieldKt.m1254calculateHeightO3s9Psw(textFieldHeight, labelHeight > 0, labelHeight, leadingHeight, trailingHeight, placeholderHeight, TextFieldImplKt.getZeroConstraints(), $this$intrinsicHeight.getDensity(), this.paddingValues);
                return m1254calculateHeightO3s9Psw;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
