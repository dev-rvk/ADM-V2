package androidx.compose.foundation;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Background.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BG\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fø\u0001\u0000¢\u0006\u0002\u0010\u0010J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0002H\u0016J\f\u0010\u001b\u001a\u00020\u000e*\u00020\rH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0011R\u001f\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/BackgroundElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/BackgroundNode;", "color", "Landroidx/compose/ui/graphics/Color;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(JLandroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "create", "equals", "", "other", "", "hashCode", "", "update", "node", "inspectableProperties", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class BackgroundElement extends ModifierNodeElement<BackgroundNode> {
    private final float alpha;
    private final Brush brush;
    private final long color;
    private final Function1<InspectorInfo, Unit> inspectorInfo;
    private final Shape shape;

    public /* synthetic */ BackgroundElement(long j, Brush brush, float f, Shape shape, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, brush, f, shape, function1);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ BackgroundElement(long r11, androidx.compose.ui.graphics.Brush r13, float r14, androidx.compose.ui.graphics.Shape r15, kotlin.jvm.functions.Function1 r16, int r17, kotlin.jvm.internal.DefaultConstructorMarker r18) {
        /*
            r10 = this;
            r0 = r17 & 1
            if (r0 == 0) goto Lc
            androidx.compose.ui.graphics.Color$Companion r0 = androidx.compose.ui.graphics.Color.INSTANCE
            long r0 = r0.m2985getUnspecified0d7_KjU()
            r3 = r0
            goto Ld
        Lc:
            r3 = r11
        Ld:
            r0 = r17 & 2
            if (r0 == 0) goto L14
            r0 = 0
            r5 = r0
            goto L15
        L14:
            r5 = r13
        L15:
            r9 = 0
            r2 = r10
            r6 = r14
            r7 = r15
            r8 = r16
            r2.<init>(r3, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.BackgroundElement.<init>(long, androidx.compose.ui.graphics.Brush, float, androidx.compose.ui.graphics.Shape, kotlin.jvm.functions.Function1, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private BackgroundElement(long color, Brush brush, float alpha, Shape shape, Function1<? super InspectorInfo, Unit> inspectorInfo) {
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(inspectorInfo, "inspectorInfo");
        this.color = color;
        this.brush = brush;
        this.alpha = alpha;
        this.shape = shape;
        this.inspectorInfo = inspectorInfo;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.ui.node.ModifierNodeElement
    public BackgroundNode create() {
        return new BackgroundNode(this.color, this.brush, this.alpha, this.shape, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(BackgroundNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        node.m165setColor8_81llA(this.color);
        node.setBrush(this.brush);
        node.setAlpha(this.alpha);
        node.setShape(this.shape);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        Intrinsics.checkNotNullParameter($this$inspectableProperties, "<this>");
        this.inspectorInfo.invoke($this$inspectableProperties);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int result = Color.m2956hashCodeimpl(this.color);
        int i = result * 31;
        Brush brush = this.brush;
        int result2 = i + (brush != null ? brush.hashCode() : 0);
        return (((result2 * 31) + Float.hashCode(this.alpha)) * 31) + this.shape.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        BackgroundElement otherModifier = other instanceof BackgroundElement ? (BackgroundElement) other : null;
        if (otherModifier != null && Color.m2950equalsimpl0(this.color, otherModifier.color) && Intrinsics.areEqual(this.brush, otherModifier.brush)) {
            return ((this.alpha > otherModifier.alpha ? 1 : (this.alpha == otherModifier.alpha ? 0 : -1)) == 0) && Intrinsics.areEqual(this.shape, otherModifier.shape);
        }
        return false;
    }
}
