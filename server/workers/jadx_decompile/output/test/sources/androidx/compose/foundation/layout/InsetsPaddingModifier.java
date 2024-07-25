package androidx.compose.foundation.layout;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WindowInsetsPadding.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004B(\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b¢\u0006\u0002\u0010\fJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0096\u0002J\b\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020'H\u0016J)\u0010(\u001a\u00020)*\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100R+\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00058B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R+\u0010\u0019\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00058B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\u0014\u0010\u001d\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0010\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00061"}, d2 = {"Landroidx/compose/foundation/layout/InsetsPaddingModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "Landroidx/compose/foundation/layout/WindowInsets;", "insets", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function1;)V", "<set-?>", "consumedInsets", "getConsumedInsets", "()Landroidx/compose/foundation/layout/WindowInsets;", "setConsumedInsets", "(Landroidx/compose/foundation/layout/WindowInsets;)V", "consumedInsets$delegate", "Landroidx/compose/runtime/MutableState;", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "unconsumedInsets", "getUnconsumedInsets", "setUnconsumedInsets", "unconsumedInsets$delegate", "value", "getValue", "equals", "", "other", "", "hashCode", "", "onModifierLocalsUpdated", "scope", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class InsetsPaddingModifier extends InspectorValueInfo implements LayoutModifier, ModifierLocalConsumer, ModifierLocalProvider<WindowInsets> {

    /* renamed from: consumedInsets$delegate, reason: from kotlin metadata */
    private final MutableState consumedInsets;
    private final WindowInsets insets;

    /* renamed from: unconsumedInsets$delegate, reason: from kotlin metadata */
    private final MutableState unconsumedInsets;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ InsetsPaddingModifier(final androidx.compose.foundation.layout.WindowInsets r1, kotlin.jvm.functions.Function1 r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r3 = r3 & 2
            if (r3 == 0) goto L18
            r2 = 0
            boolean r3 = androidx.compose.ui.platform.InspectableValueKt.isDebugInspectorInfoEnabled()
            if (r3 == 0) goto L13
            androidx.compose.foundation.layout.InsetsPaddingModifier$special$$inlined$debugInspectorInfo$1 r3 = new androidx.compose.foundation.layout.InsetsPaddingModifier$special$$inlined$debugInspectorInfo$1
            r3.<init>()
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            goto L17
        L13:
            kotlin.jvm.functions.Function1 r3 = androidx.compose.ui.platform.InspectableValueKt.getNoInspectorInfo()
        L17:
            r2 = r3
        L18:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.InsetsPaddingModifier.<init>(androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function1, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InsetsPaddingModifier(WindowInsets insets, Function1<? super InspectorInfo, Unit> inspectorInfo) {
        super(inspectorInfo);
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        Intrinsics.checkNotNullParameter(insets, "insets");
        Intrinsics.checkNotNullParameter(inspectorInfo, "inspectorInfo");
        this.insets = insets;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(this.insets, null, 2, null);
        this.unconsumedInsets = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(this.insets, null, 2, null);
        this.consumedInsets = mutableStateOf$default2;
    }

    private final WindowInsets getUnconsumedInsets() {
        State $this$getValue$iv = this.unconsumedInsets;
        return (WindowInsets) $this$getValue$iv.getValue();
    }

    private final void setUnconsumedInsets(WindowInsets windowInsets) {
        MutableState $this$setValue$iv = this.unconsumedInsets;
        $this$setValue$iv.setValue(windowInsets);
    }

    private final WindowInsets getConsumedInsets() {
        State $this$getValue$iv = this.consumedInsets;
        return (WindowInsets) $this$getValue$iv.getValue();
    }

    private final void setConsumedInsets(WindowInsets windowInsets) {
        MutableState $this$setValue$iv = this.consumedInsets;
        $this$setValue$iv.setValue(windowInsets);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo41measure3p2s80s(MeasureScope measure, Measurable measurable, long constraints) {
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        final int left = getUnconsumedInsets().getLeft(measure, measure.getLayoutDirection());
        final int top = getUnconsumedInsets().getTop(measure);
        int right = getUnconsumedInsets().getRight(measure, measure.getLayoutDirection());
        int bottom = getUnconsumedInsets().getBottom(measure);
        int horizontal = left + right;
        int vertical = top + bottom;
        long childConstraints = ConstraintsKt.m5190offsetNN6EwU(constraints, -horizontal, -vertical);
        final Placeable placeable = measurable.mo4186measureBRTryo0(childConstraints);
        int width = ConstraintsKt.m5188constrainWidthK40F9xA(constraints, placeable.getWidth() + horizontal);
        int height = ConstraintsKt.m5187constrainHeightK40F9xA(constraints, placeable.getHeight() + vertical);
        return MeasureScope.layout$default(measure, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.InsetsPaddingModifier$measure$1
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
                Placeable.PlacementScope.place$default(layout, Placeable.this, left, top, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalConsumer
    public void onModifierLocalsUpdated(ModifierLocalReadScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        WindowInsets consumed = (WindowInsets) scope.getCurrent(WindowInsetsPaddingKt.getModifierLocalConsumedWindowInsets());
        setUnconsumedInsets(WindowInsetsKt.exclude(this.insets, consumed));
        setConsumedInsets(WindowInsetsKt.union(consumed, this.insets));
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    public ProvidableModifierLocal<WindowInsets> getKey() {
        return WindowInsetsPaddingKt.getModifierLocalConsumedWindowInsets();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    public WindowInsets getValue() {
        return getConsumedInsets();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InsetsPaddingModifier)) {
            return false;
        }
        return Intrinsics.areEqual(((InsetsPaddingModifier) other).insets, this.insets);
    }

    public int hashCode() {
        return this.insets.hashCode();
    }
}
