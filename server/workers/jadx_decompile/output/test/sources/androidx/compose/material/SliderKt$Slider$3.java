package androidx.compose.material;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Slider.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/layout/BoxWithConstraintsScope;", "invoke", "(Landroidx/compose/foundation/layout/BoxWithConstraintsScope;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SliderKt$Slider$3 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ SliderColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Function0<Unit> $onValueChangeFinished;
    final /* synthetic */ State<Function1<Float, Unit>> $onValueChangeState;
    final /* synthetic */ List<Float> $tickFractions;
    final /* synthetic */ float $value;
    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SliderKt$Slider$3(ClosedFloatingPointRange<Float> closedFloatingPointRange, int i, float f, MutableInteractionSource mutableInteractionSource, boolean z, List<Float> list, SliderColors sliderColors, State<? extends Function1<? super Float, Unit>> state, Function0<Unit> function0) {
        super(3);
        this.$valueRange = closedFloatingPointRange;
        this.$$dirty = i;
        this.$value = f;
        this.$interactionSource = mutableInteractionSource;
        this.$enabled = z;
        this.$tickFractions = list;
        this.$colors = sliderColors;
        this.$onValueChangeState = state;
        this.$onValueChangeFinished = function0;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, Integer num) {
        invoke(boxWithConstraintsScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope r47, androidx.compose.runtime.Composer r48, int r49) {
        /*
            Method dump skipped, instructions count: 882
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SliderKt$Slider$3.invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float invoke$scaleToUserValue(Ref.FloatRef minPx, Ref.FloatRef maxPx, ClosedFloatingPointRange<Float> closedFloatingPointRange, float offset) {
        float scale;
        scale = SliderKt.scale(minPx.element, maxPx.element, offset, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
        return scale;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float invoke$scaleToOffset(ClosedFloatingPointRange<Float> closedFloatingPointRange, Ref.FloatRef minPx, Ref.FloatRef maxPx, float userValue) {
        float scale;
        scale = SliderKt.scale(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), userValue, minPx.element, maxPx.element);
        return scale;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Slider.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* renamed from: androidx.compose.material.SliderKt$Slider$3$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Float, Float> {
        final /* synthetic */ Ref.FloatRef $maxPx;
        final /* synthetic */ Ref.FloatRef $minPx;
        final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ClosedFloatingPointRange<Float> closedFloatingPointRange, Ref.FloatRef floatRef, Ref.FloatRef floatRef2) {
            super(1, Intrinsics.Kotlin.class, "scaleToOffset", "invoke$scaleToOffset(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/internal/Ref$FloatRef;Lkotlin/jvm/internal/Ref$FloatRef;F)F", 0);
            this.$valueRange = closedFloatingPointRange;
            this.$minPx = floatRef;
            this.$maxPx = floatRef2;
        }

        public final Float invoke(float p0) {
            return Float.valueOf(SliderKt$Slider$3.invoke$scaleToOffset(this.$valueRange, this.$minPx, this.$maxPx, p0));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Float invoke(Float f) {
            return invoke(f.floatValue());
        }
    }
}
