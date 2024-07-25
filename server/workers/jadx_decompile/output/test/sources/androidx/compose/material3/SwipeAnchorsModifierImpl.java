package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SwipeableV2.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003Bg\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005\u0012!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\n0\u0005\u0012\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0002\b\u0010ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u001d\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\fH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0019\u001a\u00020\u001aH\u0016J)\u0010\u001b\u001a\u00020\u001c*\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R)\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"Landroidx/compose/material3/SwipeAnchorsModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/layout/OnRemeasuredModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "onDensityChanged", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "density", "", "onSizeChanged", "Landroidx/compose/ui/unit/IntSize;", "layoutSize", "inspectorInfo", "Landroidx/compose/ui/platform/InspectorInfo;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "lastDensity", "", "lastFontScale", "onRemeasured", "size", "onRemeasured-ozmzZPI", "(J)V", "toString", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* renamed from: androidx.compose.material3.SwipeAnchorsModifier, reason: from toString */
/* loaded from: classes.dex */
public final class SwipeAnchorsModifierImpl extends InspectorValueInfo implements LayoutModifier, OnRemeasuredModifier {
    private float lastDensity;
    private float lastFontScale;

    /* renamed from: onDensityChanged, reason: from kotlin metadata and from toString */
    private final Function1<Density, Unit> updateDensity;
    private final Function1<IntSize, Unit> onSizeChanged;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SwipeAnchorsModifierImpl(Function1<? super Density, Unit> onDensityChanged, Function1<? super IntSize, Unit> onSizeChanged, Function1<? super InspectorInfo, Unit> inspectorInfo) {
        super(inspectorInfo);
        Intrinsics.checkNotNullParameter(onDensityChanged, "onDensityChanged");
        Intrinsics.checkNotNullParameter(onSizeChanged, "onSizeChanged");
        Intrinsics.checkNotNullParameter(inspectorInfo, "inspectorInfo");
        this.updateDensity = onDensityChanged;
        this.onSizeChanged = onSizeChanged;
        this.lastDensity = -1.0f;
        this.lastFontScale = -1.0f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0028, code lost:
    
        if ((r9.getFontScale() == r8.lastFontScale) == false) goto L12;
     */
    @Override // androidx.compose.ui.layout.LayoutModifier
    /* renamed from: measure-3p2s80s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.compose.ui.layout.MeasureResult mo41measure3p2s80s(androidx.compose.ui.layout.MeasureScope r9, androidx.compose.ui.layout.Measurable r10, long r11) {
        /*
            r8 = this;
            java.lang.String r0 = "$this$measure"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "measurable"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            float r0 = r9.getDensity()
            float r1 = r8.lastDensity
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L19
            r0 = r1
            goto L1a
        L19:
            r0 = r2
        L1a:
            if (r0 == 0) goto L2a
            float r0 = r9.getFontScale()
            float r3 = r8.lastFontScale
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L27
            goto L28
        L27:
            r1 = r2
        L28:
            if (r1 != 0) goto L47
        L2a:
            kotlin.jvm.functions.Function1<androidx.compose.ui.unit.Density, kotlin.Unit> r0 = r8.updateDensity
            float r1 = r9.getDensity()
            float r2 = r9.getFontScale()
            androidx.compose.ui.unit.Density r1 = androidx.compose.ui.unit.DensityKt.Density(r1, r2)
            r0.invoke(r1)
            float r0 = r9.getDensity()
            r8.lastDensity = r0
            float r0 = r9.getFontScale()
            r8.lastFontScale = r0
        L47:
            androidx.compose.ui.layout.Placeable r0 = r10.mo4186measureBRTryo0(r11)
            int r2 = r0.getWidth()
            int r3 = r0.getHeight()
            androidx.compose.material3.SwipeAnchorsModifier$measure$1 r1 = new androidx.compose.material3.SwipeAnchorsModifier$measure$1
            r1.<init>()
            r5 = r1
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r6 = 4
            r7 = 0
            r4 = 0
            r1 = r9
            androidx.compose.ui.layout.MeasureResult r1 = androidx.compose.ui.layout.MeasureScope.layout$default(r1, r2, r3, r4, r5, r6, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SwipeAnchorsModifierImpl.mo41measure3p2s80s(androidx.compose.ui.layout.MeasureScope, androidx.compose.ui.layout.Measurable, long):androidx.compose.ui.layout.MeasureResult");
    }

    @Override // androidx.compose.ui.layout.OnRemeasuredModifier
    /* renamed from: onRemeasured-ozmzZPI */
    public void mo254onRemeasuredozmzZPI(long size) {
        this.onSizeChanged.invoke(IntSize.m5370boximpl(size));
    }

    public String toString() {
        return "SwipeAnchorsModifierImpl(updateDensity=" + this.updateDensity + ", onSizeChanged=" + this.onSizeChanged + ')';
    }
}
